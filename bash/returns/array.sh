

function to_array_01
{
	s=$1
	[[ "$s" == "" ]] && return 0

	s_qtd=$(echo $s | wc -w)
	s="$(echo $s | sed 's/ /\n/g')"

	local -n _ret=$2
	for((i=1; i<=$s_qtd; i++))
	do
 		_ret+=($(echo "$s" | awk NR==$i))
	done
	return 0
}

function to_array_02
{
	
}


main()
{
	declare -a a
	s='opa bom dia'

	to_array_01 "$s" a

	declare -p a
}
main
