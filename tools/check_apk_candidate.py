#!/usr/bin/env python3
"""Report an actual build artifact; never prints a synthetic candidate hash."""
import hashlib
import os
from pathlib import Path

APK = Path(__file__).resolve().parents[1] / "app/build/outputs/apk/debug/app-debug.apk"

def main() -> int:
    if not APK.is_file():
        print(f"APK_NOT_GENERATED: {APK}")
        return 1
    digest = hashlib.sha256()
    with APK.open("rb") as stream:
        for block in iter(lambda: stream.read(1024 * 1024), b""):
            digest.update(block)
    print(f"APK_PATH={APK}")
    print(f"APK_BYTES={APK.stat().st_size}")
    print(f"APK_SHA256={digest.hexdigest()}")
    print(f"SOURCE_SHA={os.environ.get('GITHUB_SHA', 'LOCAL_UNVERIFIED')}")
    print("APK_STATUS=TECHNICAL_BUILD_PENDING_INDEPENDENT_REVIEW")
    return 0

if __name__ == "__main__":
    raise SystemExit(main())
