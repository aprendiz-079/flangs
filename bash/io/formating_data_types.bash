

# print bytes

dec=65


echo -e "Dec: $dec"
printf "Hex: 0x%X\n" $dec
printf "Bin: %d\n" $(echo "obase=2; $dec" | bc)
