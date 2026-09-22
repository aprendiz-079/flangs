#!/usr/bin/env bash

# ferramenta de formatacao de texto

# section .data
declare -a funcs_name
funcs_id=0

# section .text
#	global _start

array_to_string()
{
	for char in "$@"; do
		printf '%s' $char
	done
}
#string=$(array_to_string "${test[@]}")
#echo -e $string # true

comom_erros()
{
	local func_name=$1
	for name in "${funcs_name[@]}"; do
		if [[ "$func_name" == "$name" ]]; then
			break
		fi
	done

	local err_code=$2

	case $func_name in
		'copy_line_since')
		case $err_code in
			1) echo -e "[$err_code] $func_name: "
		esac
		*) echo -e "[100] comom_errors: invalid function name"
	esac

	exit 0
}

copy_line_since()
{
	local args_err=1
	local file_err=2
	local line_t_err=3
	local char_t_err=4

	[ $# -lt 3 ] && return $args_err

	local file=$1
	[ ! -f $file ] && return $file_err

	tLines=$(cat $file | wc -l)

	local line_t=$2
	[ $line_t -gt $tLines ] && return $line_t_err

	local char_t=$3
	tChars=$(cat $file | awk "NR==$line_t" | wc -m)
	[ $char_t -gt $tChars ] && return $char_t_err

	_line=$(cat $file | awk "NR==$line_t")

	for ((i = 0; i < ${#_line}; i++)); do
		printf "%s" "${_line:$char_t:1}"
	done >> line

	echo -e "line: \n$line"; return 0

	funcs_name+=('copy_line_since')
	local id=((funcs_id++))

	return 0
}

insert_line_in()
{
	local file=$1
	local line=$2
}

copy_and_paste_multiple_lines_since()
{


	return 0
}

_start()
{ [ $# -eq 0 ] && return 0
	local op=0
#	read -p "Enter the option:  " op

	op=1
	case $op in
		0)
		exit 0 ;;

		1)
		copy_line_since $@
		EXIT $? "copy_line_since";;

		*)
		echo -e "Invalid Option."; return 0 ;;
	esac

	return 0
}
_start $@
