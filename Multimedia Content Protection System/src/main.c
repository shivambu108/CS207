#include <stdio.h>
#include "user_profile.h"
#include "authentication.h"
#include "document_protection.h"
#include "document_storage.h"

void mainMenu(User *user);
void initializeUser(User *user);

int main() {
    User user;
    UserProfile profile;
    Authentication auth = {0, 3};  // max 3 attempts allowed
    int choice;

    initializeUser(&user);

    while (1) {
        printf("1. Register\n");
        printf("2. Login\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        if (choice == 1) {
            registerUser(&user);
            createProfile(&profile);
            printf("Registration complete. You are now logged in.\n");
            mainMenu(&user);
            break;
        } else if (choice == 2) {
            if (authenticateUser(&auth, &user)) {
                printf("Login successful.\n");
                mainMenu(&user);
                break;
            } else {
                printf("Login failed.\n");
                if (auth.failedAttempts >= auth.maxFailedAttempts) {
                    printf("Too many failed attempts. Exiting...\n");
                    return 1;
                }
            }
        } else {
            printf("Invalid choice. Please try again.\n");
        }
    }

    return 0;
}

void mainMenu(User *user) {
    int choice;
    (void)user;
    DocumentProtection docProtection = {"example.txt", "secretkey"};

    while (1) {
        printf("\nMain Menu:\n");
        printf("1. Encrypt Document\n");
        printf("2. Store Document\n");
        printf("3. Open Document\n");
        printf("4. Copy Document\n");
        printf("5. Delete Document\n");
        printf("6. Logout\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                encryptDocument(&docProtection);
                break;
            case 2:
                storeDocument(&docProtection);
                break;
            case 3:
                printf("Enter document path to open: ");
                scanf("%s", docProtection.documentPath);
                openDocument(&docProtection);
                break;
            case 4: {
                char destinationPath[256];
                printf("Enter destination path for copying the document: ");
                scanf("%s", destinationPath);
                copyDocument(&docProtection, destinationPath);
                break;
            }
            case 5:
                deleteDocument(&docProtection);
                break;
            case 6:
                printf("Logging out...\n");
                return;
            default:
                printf("Invalid choice. Please try again.\n");
        }
    }
}

void initializeUser(User *user) {
    user->username[0] = '\0';
    user->password[0] = '\0';
    user->email[0] = '\0';
}
