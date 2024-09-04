#ifndef USER_PROFILE_H
#define USER_PROFILE_H

typedef struct {
    char username[50];
    char password[50];
    char email[50];
} User;

typedef struct {
    char username[50];
    char password[50];
    char profileData[200];
} UserProfile;

void registerUser(User *user);
void loginUser(User *user);
void logoutUser(User *user);

void createProfile(UserProfile *profile);
void updateProfile(UserProfile *profile);
void deleteProfile(UserProfile *profile);

#endif 
