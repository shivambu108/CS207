CC = gcc

CFLAGS = -Iinclude -Wall -Wextra 

SRC_DIR = src
OBJ_DIR = obj
BIN_DIR = bin
INCLUDE_DIR = include

TARGET = $(BIN_DIR)/multimedia_protection.exe

SRC_FILES = $(wildcard $(SRC_DIR)/*.c)

OBJ_FILES = $(patsubst $(SRC_DIR)/%.c,$(OBJ_DIR)/%.o,$(SRC_FILES))

all: $(TARGET)

$(TARGET): $(OBJ_FILES) | $(BIN_DIR)
	$(CC) $(OBJ_FILES) -o $(TARGET)

$(OBJ_DIR)/%.o: $(SRC_DIR)/%.c | $(OBJ_DIR)
	$(CC) $(CFLAGS) -c $< -o $@

$(BIN_DIR):
	if not exist $(BIN_DIR) mkdir $(BIN_DIR)

$(OBJ_DIR):
	if not exist $(OBJ_DIR) mkdir $(OBJ_DIR)

clean:
	del /Q $(OBJ_DIR)\*.o
	if exist $(TARGET) del /Q $(TARGET)

.PHONY: all clean
