
CC     = gcc
CFLAGS = -Wall -O2

TARGET = main

SRC    = main.c


$(TARGET): $(SRC)
	$(CC) $(CFLAGS) $(SRC) -o $(TARGET)

run:
	./$(TARGET)
	@echo -e "[Finished]\n[Exit: $$?]"

clean:
	rm -f $(TARGET)

.PHONY: all clean run
