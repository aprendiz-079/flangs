

# write
def a() -> None:

	from pathlib import Path

	Path("test/test.txt").write_text("opa");

	# read all
	content = Path("test/test.txt").read_text()
	print(content)

	# read line per line
	with open("test/test.txt", "r", encoding="utf-8") as f:
		for line in f:
			print(line.strip())


	# write at the final
	with open("test/test.txt", "a", encoding="utf-8") as f:
		f.write("asasdasds") #override



def b() -> None:

	from pathlib import Path

	dir = Paht("test")
	dir.mkdir(parents=True, exist_ok=True)

	file = dir / "test.txt"

	print(file.name)
	print(file.parent)
	print(file.suffix)
	print(file.exists())

	for item in dir.iterdir():
		print(item)

	for img in Path(".").rglob("*.jpg"):
		print(img)



def c() -> None:
	import shutil
	from pathlib import Path

	img = "picture.jpg"

	source  = Path(img)
	destine = Path("backup/" img)

	shutil.copy(source, destine)

	img = "picture.png"
	destine.rename(img)

	Path("test/test.txt").unlink(missing_ok=True) # del file

	shutil.rmtree("old-dir") # del dir

	sz = Path(img).stat().st_size # get file size
