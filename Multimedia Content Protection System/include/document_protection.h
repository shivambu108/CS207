#ifndef DOCUMENT_PROTECTION_H
#define DOCUMENT_PROTECTION_H

typedef struct {
    char documentPath[100];
    char encryptionKey[50];
} DocumentProtection;

void encryptDocument(DocumentProtection *doc);
void decryptDocument(DocumentProtection *doc);
void storeDocument(DocumentProtection *doc);
void deleteDocument(DocumentProtection *doc);
void copyDocument(DocumentProtection *doc, const char *destinationPath);
void openDocument(DocumentProtection *doc);

#endif 

