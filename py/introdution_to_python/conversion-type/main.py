

def a() -> None:
	pi = 3.141592653
	print('pi: ', pi)
	print('float part: ', pi - 3 )
	print('integer part: ', int(pi))
	print('str part: ', str(pi))
	print('trunc at the 1st dec: ', round(pi, 1))
	print('trunc at the 2nd dec: ', round(pi, 2))
	print('trunc at the 0 dec: ', round(pi))


a()
