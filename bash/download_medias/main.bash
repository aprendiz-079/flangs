

declare -a music_pids
declare -a video_pids

declare -a music_urls
declare -a video_urls


yt-dlp_helpfile='~/helpers/yt-dlp_-help.txt'


print_slow()
{ echo -e "$@"; sleep 0.2; }

download()
{
	local url="$1"
	local format="$2"
	yt-dlp -t $format "$1" 1>/dev/null &
	music_pids+=($$)
}

info()
{
	p() { print_slow "$1"; }
	p "Musics downloading now: ${#musics_pid[@]}"
	p "Videos downloading now: ${#videos_pid[@]}\n"

	p "Quality: "
}

menu()
{
	p() { print_slow "$1"; }
	p "\nOptions menu yt-dlp\n"

	p "[0] Exit;\n"

	p "1 Musics ops:"
	p "  [1.1] Download;"
	p "  [1.2] See downloadings;"
	p "  [1.3] See avaliable formats;"

	p "2 Videos ops:"
	p "  [2.1] Download;"
	p "  [2.2] See downloadings;"
	p "  [2.3] See avaiable formats;\n"

	p "[3] yt-dlpt --help\n"

	p "[4] See full formats"
}

main()
{
	local url, op
	while 1
	do
		clear

		info

		read -p 'Enter url: ' url

		menu
		read -p '' op

		case $op in
		'0') exit 0;

		'3') cat "$yt-dlp_helpfile"; exit 0;;

		'4') yt-dlp -F "$url"; exit 0;;

		'1.1')
			music_urls+=("$url")
			download "$url" "mp3"
		;;

		'1.2') ;;
		esac

	done
}

main
