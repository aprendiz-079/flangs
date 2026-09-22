

for ((i = 1; i < $(ls | wc -w); i++)); do
	cat $(ls | awk "NR==$i") | sed "s/public static void main(String[] argv) {}//" > test.txt
	cat test.txt
	break
done
