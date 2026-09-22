
ASM = nasm
ASMFLAGS = -f elf32
LD = ld
LDFLAGS = -m elf_i386
TARGET = program
SRCS = main.asm soma.asm
OBJS = $(SRCS:.asm=.o)


all: $(TARGET)

$(TARGET): $(OBJS)
	$(LD) $(LDFLAGS) $(OBJS) -o $(TARGET)

%.o: %.asm
	$(ASM) $(ASMFLAGS) $< -o $@

clean:
	rm -f $(OBJS) $(TARGET)

run: $(TARGET)
	./$(TARGET)
	@echo -e "[Finished]\n[Exit: $$?]"

.PHONY: all clean run
