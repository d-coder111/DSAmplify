import hashlib
import os

def hash_file(file_path):
    """Returns the SHA-1 hash of the file."""
    hash_sha1 = hashlib.sha1()
    with open(file_path, "rb") as f:
        for chunk in iter(lambda: f.read(4096), b""):
            hash_sha1.update(chunk)
    return hash_sha1.hexdigest()

def check_duplicates(base_dir=".", extensions=(".cpp", ".java", ".py")):
    """Checks for duplicate files by content hash in the given directory."""
    hashes = {}
    duplicates = []

    for root, _, files in os.walk(base_dir):
        for file in files:
            if file.endswith(extensions):
                file_path = os.path.join(root, file)
                file_hash = hash_file(file_path)
                
                if file_hash in hashes:
                    duplicates.append((file_path, hashes[file_hash]))
                else:
                    hashes[file_hash] = file_path
    
    return duplicates

if __name__ == "__main__":
    duplicates = check_duplicates()
    if duplicates:
        print("Duplicate files found:")
        for dup in duplicates:
            print(f"{dup[0]} is a duplicate of {dup[1]}")
        exit(1)  # Exit with error to flag as duplicate in GitHub Actions
    else:
        print("No duplicates found.")
