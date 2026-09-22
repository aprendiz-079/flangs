

def a() -> None:
	s = b'\xf0\x9f\x98\x80'
	print(s.decode('utf-8'))


a()
