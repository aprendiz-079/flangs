

soma1()
{ printf "%i" $(($1 + $2)); }

function soma2
{ soma1 $1 $2; }

f=log.txt

function soma3
{ soma1 $1 $2; } > $f

main()
{
	echo -e "soma1: $(soma1 1 4)"

	echo -e "soma2: $(soma2 4 2)"

	echo -e "soma3: $(soma3 4 2)"
	echo -e "file log content: "
	cat $f
}

main
[ -f $f ] && rm $f
