Multimedia Content Protection System

Overview

The Multimedia Content Protection System is a C-based program designed for managing user authentication, document protection, and user profiles. It allows users to register, log in, and interact with document management functionalities such as encryption and storage.

Project Structure

src/ - Source files for the project
    document_protection.c - Functions for document encryption and protection
    main.c - Main program logic and menu handling
    authentication.c - Functions for user authentication
    user_profile.c - Functions for user registration and profile management
    document_storage.c - Functions for storing documents

include/ - Header files
    document_protection.h - Declarations for document protection functions
    authentication.h - Declarations for authentication functions
    user_profile.h - Declarations for user profile functions
    document_storage.h - Declarations for document storage functions

obj/ - Directory for object files (created during compilation)

bin/ - Directory for the compiled executable

doc/- Directory for necessary documents
    readme.txt

Requirements

    GCC Compiler
    MinGW or equivalent build tools

Building the Project

    Extract the Project: Unzip the project folder to a desired location.

Navigate to the Project Directory:


    cd path/to/project

Compile the Project: Run mingw32-make or make in the project directory. This will compile the source code and generate the executable in the bin/ directory.


    mingw32-make

Running the Application

Navigate to the bin Directory:


    cd bin

Run the Executable:


    .\multimedia_protection.exe

Follow the On-Screen Instructions:


    Choose 1 to Register a new user.
    Choose 2 to Log in with an existing user.

        After logging in, access the Main Menu to:
        Encrypt a document
        Store a document
        Open a document
        Log out

Usage

Register a User:

    Enter a username, password, and email when prompted. This will create a new user profile.

Login:

    Enter the username and password for an existing user. The application will validate the credentials and log you in if they are correct.

Main Menu Options:

    Encrypt Document: Encrypt a document with a preset key.
    Store Document: Store a document in the system.
    Open Document: Provide the path to a document to open it.
    Logout: Log out of the application.