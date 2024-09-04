# Multimedia Content Protection System

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Project Structure](#project-structure)
- [Requirements](#requirements)
- [Building the Project](#building-the-project)
- [Running the Application](#running-the-application)
- [Usage](#usage)
- [Authors and Contributions](#authors-and-contributions)

## Overview

The **Multimedia Content Protection System** is a C-based application designed to manage user authentication, document protection, and user profiles. It provides a secure environment for users to register, log in, and interact with their documents by performing various operations such as encryption, storage, and opening documents.

This project represents a **basic implementation** of a Multimedia Content Protection System and is not fully functional. Certain features and functionalities may not work as intended, and further development is needed to achieve a stable and reliable system. Use this project primarily for educational purposes and as a foundation for further improvements.

## Features

- **User Registration**: Create a new user account with a username, password, and email.
- **User Authentication**: Secure login with validation and failed attempt tracking.
- **Document Encryption**: Encrypt and decrypt documents using a specified key.
- **Document Storage**: Store and manage documents within the system.
- **Document Opening**: Access and open stored documents.
- **User Profile Management**: Create and manage user profiles within the system.

## Project Structure

- **src/** - Source files for the project:
  - **document_protection.c** - Functions for document encryption and protection.
  - **main.c** - Main program logic and menu handling.
  - **authentication.c** - Functions for user authentication.
  - **user_profile.c** - Functions for user registration and profile management.
  - **document_storage.c** - Functions for storing documents.

- **include/** - Header files:
  - **document_protection.h** - Declarations for document protection functions.
  - **authentication.h** - Declarations for authentication functions.
  - **user_profile.h** - Declarations for user profile functions.
  - **document_storage.h** - Declarations for document storage functions.

- **obj/** - Directory for object files (created during compilation).

- **bin/** - Directory for the compiled executable.

- **doc/** - Directory for necessary documents:
  - **readme.txt** - Project documentation.



## Requirements

To build and run the Multimedia Content Protection System, you will need:

- **GCC Compiler**: To compile the C source code.
- **MinGW or equivalent build tools**: For building the project on Windows.

## Building the Project

1. **Extract the Project**: Unzip the project folder to a desired location on your computer.

2. **Navigate to the Project Directory**:

    ```bash
    cd "filepath"
    ```

3. **Compile the Project**: Use `mingw32-make` or `make` in the project directory to compile the source code. The compiled executable will be placed in the `bin/` directory.

    ```bash
    mingw32-make
    ```

## Running the Application

1. **Navigate to the `bin` Directory**:

    ```bash
    cd bin
    ```

2. **Run the Executable**:

    ```bash
    .\multimedia_protection.exe
    ```

3. **Interact with the Application**:

    - **Register**: Choose `1` to register a new user.
    - **Login**: Choose `2` to log in with an existing user.

    Once logged in, you can:
    - Encrypt a document
    - Store a document
    - Open a document
    - Log out

## Usage

### Registering a New User

1. Select the **Register** option from the main menu.
2. Enter your desired username, password, and email.
3. After registration, the user profile is automatically created, and you are logged in.

### Logging In

1. Select the **Login** option from the main menu.
2. Enter the username and password for an existing account.
3. If the credentials are correct, you will be logged in. Otherwise, the system will track failed login attempts.

### Main Menu Operations

- **Encrypt Document**: Secure your documents by encrypting them with a predefined key.
- **Store Document**: Store your documents in the system for easy access later.
- **Open Document**: Provide the path to a document and open it directly from the system.
- **Logout**: Log out of the current session securely.

## Author

- **Shivambu Dev Pandey** (23bcs123)



