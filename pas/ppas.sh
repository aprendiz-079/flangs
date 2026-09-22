#!/bin/sh
DoExitAsm ()
{ echo "An error occurred while assembling $1"; exit 1; }
DoExitLink ()
{ echo "An error occurred while linking $1"; exit 1; }
echo Linking hello
OFS=$IFS
IFS="
"
/usr/bin/ld -b elf64-x86-64 -m elf_x86_64     -s  -L. -o hello -T link3992.res -e _start
if [ $? != 0 ]; then DoExitLink hello; fi
IFS=$OFS
