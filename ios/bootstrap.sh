#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")"
if ! command -v xcodegen >/dev/null 2>&1; then
  echo "XcodeGen no está instalado. En macOS: brew install xcodegen" >&2
  exit 1
fi
if [[ ! -f "../app/src/main/assets/campaign/es-ES/levels-v1.json" ]]; then
  echo "Debes trabajar desde el repositorio completo con los recursos Android." >&2
  exit 1
fi
# Content is copied for packaging; source of truth is shared with Android.
rm -rf campaign rv1909
cp -R ../app/src/main/assets/campaign ./campaign
cp -R ../app/src/main/assets/bible/rv1909 ./rv1909
xcodegen generate --spec project.yml
echo "Proyecto Xcode creado con 300 niveles, 30 misterios y 66 libros RV1909."
