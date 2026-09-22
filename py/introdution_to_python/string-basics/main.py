

def a() -> None:
	valid_strings = [
	"\"17\" or \'17\'", "\"seveteen\" or \'seveteen\'", "\"Where?\" or \'Where?\'",
	"\"I ope you aren\'t sad.\"", "\"The teacher said \"Corret!\"\""
	]

	invalid_strings = [
	"17", "seveteen", "\"Where?\'", "\'I hope you aren\'t sad.\'", "\"The teacher said \"Correct!\"\""
	]

	print('valid strings: \n', valid_strings)
	print('invalid stirngs: \n', invalid_strings)


a()
