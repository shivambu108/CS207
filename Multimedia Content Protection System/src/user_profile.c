#include "user_profile.h"
#include <stdio.h>
#include <string.h>

void registerUser(User *user) {
    printf("Enter username: ");
    scanf("%s", user->username);
    printf("Enter password: ");
    scanf("%s", user->password);
    printf("Enter email: ");
    scanf("%s", user->email);
    printf("User registered with username: %s\n", user->username);
}

void loginUser(User *user) {
    char username[50];
    char password[50];

    printf("Enter username: ");
    scanf("%s", username);
    printf("Enter password: ");
    scanf("%s", password);

    if (strcmp(username, user->username) == 0 && strcmp(password, user->password) == 0) {
        printf("Login successful. Welcome %s!\n", user->username);
    } else {
        printf("Login failed. Invalid username or password.\n");
    }
}

void logoutUser(User *user) {
    printf("User %s has logged out.\n", user->username);
}

void createProfile(UserProfile *profile) {
    strcpy(profile->username, "dummyUser");
    strcpy(profile->password, "dummyPassword");
    strcpy(profile->profileData, "Dummy Profile Data");
    printf("Profile created for user: %s\n", profile->username);
}

void updateProfile(UserProfile *profile) {
    printf("Updating profile for user: %s\n", profile->username);
    // Update logic here...
}

void deleteProfile(UserProfile *profile) {
    printf("Deleting profile for user: %s\n", profile->username);
    // Deletion logic here...
}
