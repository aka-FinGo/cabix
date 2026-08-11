import zipfile
import os

src_apk = "old/OmborX_1.0.apk"
out_apk = "build/outputs/apk/FonRo-POS-unsigned.apk"

os.makedirs("build/outputs/apk", exist_ok=True)
print(f"Packaging {src_apk} -> {out_apk}...")

with zipfile.ZipFile(src_apk, 'r') as zin:
    with zipfile.ZipFile(out_apk, 'w') as zout:
        for item in zin.infolist():
            buffer = zin.read(item.filename)
            
            # Rebrand OmborX -> FonRo in Manifest, resources.arsc, and resource XMLs
            if item.filename in ["AndroidManifest.xml", "resources.arsc"] or item.filename.startswith("res/"):
                buffer = buffer.replace(b"OmborX", b"FonRo").replace(b"omborx", b"fonro")
            
            # Skip old signature files
            if item.filename.startswith("META-INF/"):
                continue

            # Ensure ZIP_STORED (uncompressed) for resources.arsc, manifest, images and native libraries
            compress_type = item.compress_type
            if item.filename in ["resources.arsc", "AndroidManifest.xml"] or item.filename.endswith(".png") or item.filename.endswith(".so"):
                compress_type = zipfile.ZIP_STORED

            zout.writestr(item, buffer, compress_type=compress_type)

print(f"Successfully packaged {out_apk}, size: {os.path.getsize(out_apk)} bytes")
