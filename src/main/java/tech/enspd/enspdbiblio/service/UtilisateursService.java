package tech.enspd.enspdbiblio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.enspd.enspdbiblio.entities.Utilisateurs;
import tech.enspd.enspdbiblio.repository.UtilisateursRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateursService {

    @Autowired
    private UtilisateursRepository utilisateurRepository;

    public List<Utilisateurs> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Utilisateurs getUtilisateurById(int id) {
        Optional<Utilisateurs> utilisateur = utilisateurRepository.findById(id);
        return utilisateur.orElse(null);
    }

    public Utilisateurs createUtilisateur(Utilisateurs utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateurs updateUtilisateur(int id, Utilisateurs utilisateurDetails) {
        Optional<Utilisateurs> user = utilisateurRepository.findById(id);
        if (user.isPresent()) {
            Utilisateurs updatedUser = user.get();
            // Mise à jour des champs nécessaires ici
            return utilisateurRepository.save(updatedUser);
        }
        return null;
    }

    public void deleteUtilisateur(int id) {
        utilisateurRepository.deleteById(id);
    }

    public Optional<Utilisateurs> findById(int id) {
        return utilisateurRepository.findById(id);
    }
}
