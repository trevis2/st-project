@echo off
REM Questo script inizializza un progetto Node.js con le impostazioni specificate nel package.json esistente

REM Inizializza il progetto npm (se non esiste già un package.json)
if not exist package.json (
    call npm init -y
)

REM Crea un .gitignore di base con ogni elemento su una nuova riga
(
echo node_modules/
echo .env
echo *.log
echo npm-debug.log*
echo .DS_Store
) > .gitignore

REM Crea un file index.js completamente vuoto (se non esiste già)
if not exist index.js (
    type nul > index.js
)

REM Configura il package.json con le impostazioni specificate
call npm pkg set name="utils-js"
call npm pkg set version="0.0.1"
call npm pkg set description="libreria javascript con funzionalita utili da definire"
call npm pkg set main="index.js"
call npm pkg set scripts.test="echo \"Error: no test specified\" && exit 1"
call npm pkg set scripts.start="node index.js"
call npm pkg set scripts.dev="nodemon index.js"
call npm pkg set keywords[0]="esm"
call npm pkg set keywords[1]="nodejs"
call npm pkg set keywords[2]="utils"
call npm pkg set keywords[3]="express"
call npm pkg set author="Simone Trevisan"
call npm pkg set license="ISC"
call npm pkg set type="module"

REM Installa le dipendenze
call npm install express
call npm install --save-dev nodemon
call npm install --save-dev typescript @types/node @types/express ts-node
call npm install --save-dev cross-env rimraf

if not exist tsconfig.json (
    call npx tsc --init
)

echo Setup del progetto completato! Express e Nodemon sono stati installati o aggiornati.