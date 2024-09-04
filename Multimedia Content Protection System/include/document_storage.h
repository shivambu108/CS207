#ifndef DOCUMENT_STORAGE_H
#define DOCUMENT_STORAGE_H

void saveDocument(const char *storagePath, const char *documentPath);
void loadDocument(const char *storagePath, const char *documentPath);
void deleteStoredDocument(const char *storagePath, const char *documentPath);

#endif 
