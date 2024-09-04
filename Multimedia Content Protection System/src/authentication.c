#include "authentication.h"
#include <stdio.h>
#include <string.h>

void lockAccount(Authentication *auth) {
    printf("Account is locked due to %d failed attempts.\n", auth->failedAttempts);
}

void unlockAccount(Authentication *auth) {
    auth->failedAttempts = 0;
    printf("Account has been unlocked.\n");
}

int authenticateUser(Authentication *auth, User *user) {
    char username[50];
    char password[50];

    printf("Enter username: ");
    scanf("%s", username);
    printf("Enter password: ");
    scanf("%s", password);

    if (auth->failedAttempts >= auth->maxFailedAttempts) {
        lockAccount(auth);
        return 0;
    }

    if (strcmp(username, user->username) == 0 && strcmp(password, user->password) == 0) {
        printf("Authentication successful.\n");
        auth->failedAttempts = 0;
        return 1;
    } else {
        auth->failedAttempts++;
        printf("Authentication failed. Attempt %d of %d.\n", auth->failedAttempts, auth->maxFailedAttempts);
        return 0;
    }
}
