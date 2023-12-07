package tech.enspd.enspdbiblio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.enspd.enspdbiblio.entities.Documents;
import tech.enspd.enspdbiblio.service.DocumentsService;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "documents")
public class DocumentsController {

    @Autowired
    private DocumentsService DocumentService; // Injection du service pour gérer les opérations sur les Documents

    // Endpoint pour récupérer tous les Documents

    @GetMapping
    public List<Documents> getAllDocuments() {
        return DocumentService.getAllDocuments();
    }

    // Endpoint pour récupérer un Document par son ID
    @GetMapping("/{id}")
    public Documents getDocumentById(@PathVariable int id) {
        return DocumentService.getDocumentById(id);
    }

    // Endpoint pour créer un nouvel Document
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public Documents createDocument(@RequestBody Documents Document) {
        return DocumentService.createDocument(Document);
    }

    // Endpoint pour mettre à jour un Document existant
    @PutMapping("/{id}")
    public Documents updateDocument(@PathVariable int id, @RequestBody Documents DocumentDetails) {
        return DocumentService.updateDocument(id, DocumentDetails);
    }

    // Endpoint pour supprimer un Document par son ID
    @DeleteMapping("/{id}")
    public void deleteDocument(@PathVariable int id) {
        DocumentService.deleteDocument(id);
    }

}
