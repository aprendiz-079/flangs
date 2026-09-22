
# using pointers in bash

function inc
{ declare -n x=$1; ((x++)); }

a=10
echo -e "a: $a"

inc a
echo -e "a: $a"

inc a
echo -e "a: $a"

