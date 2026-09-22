

#echo {a..z}
#>a b c d e f g h i j k l m n o p q r s t u v w x y z

#echo "'"{a..z}"'"
#>'a' 'b' 'c' 'd' 'e' 'f' 'g' 'h' 'i' 'j' 'k' 'l' 'm' 'n' 'o' 'p' 'q' 'r' 's' 't' 'u' 'v' 'w' 'x' 'y' 'z'

#so
declare -a alphabet
alphabet=('a' 'b' 'c' 'd' 'e' 'f' 'g' 'h' 'i' 'j' 'k' 'l' 'm' 'n' 'o' 'p' 'q' 'r' 's' 't' 'u' 'v' 'w' 'x' 'y' 'z')

for((i=0; i<${#alphabet[@]}-1; i++))
do
  printf "'%c' " ${alphabet[$i]}
done
printf "'%c'\n" ${alphabet[${#alphabet[@]}-1]}
