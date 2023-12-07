package tech.enspd.enspdbiblio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.enspd.enspdbiblio.entities.Documents;
import tech.enspd.enspdbiblio.repository.DocumentsRepository;

import java.util.List;
import java.util.Optional;
@Service
public class DocumentsService {

    @Autowired
    private DocumentsRepository documentRepository;

    public List<Documents> getAllDocuments() {
        return documentRepository.findAll();
    }

    public Documents getDocumentById(int id) {
        Optional<Documents> document = documentRepository.findById(id);
        return document.orElse(null);
    }

    public Documents createDocument(Documents document) {
        return documentRepository.save(document);
    }

    public Documents updateDocument(int id, Documents documentDetails) {
        Optional<Documents> doc = documentRepository.findById(id);
        if (doc.isPresent()) {
            Documents updatedDocument = doc.get();
            // Mise à jour des champs nécessaires ici
            return documentRepository.save(updatedDocument);
        }
        return null;
    }

    public void deleteDocument(int id) {
        documentRepository.deleteById(id);
    }
}
