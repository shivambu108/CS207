#ifndef AUTHENTICATION_H
#define AUTHENTICATION_H

#include "user_profile.h"

typedef struct {
    int failedAttempts;
    int maxFailedAttempts;
} Authentication;

void lockAccount(Authentication *auth);
void unlockAccount(Authentication *auth);
int authenticateUser(Authentication *auth, User *user);

#endif 
