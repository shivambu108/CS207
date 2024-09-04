#include "document_storage.h"
#include <stdio.h>

void saveDocument(const char *storagePath, const char *documentPath) {
    printf("Saving document: %s to %s\n", documentPath, storagePath);
}

void loadDocument(const char *storagePath, const char *documentPath) {
    printf("Loading document: %s from %s\n", documentPath, storagePath);
}

void deleteStoredDocument(const char *storagePath, const char *documentPath) {
    printf("Deleting document: %s from %s\n", documentPath, storagePath);
}
