package tech.enspd.enspdbiblio.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import tech.enspd.enspdbiblio.entities.Memoire;
import tech.enspd.enspdbiblio.entities.User;
import tech.enspd.enspdbiblio.repository.MemoireRepository;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class MemoireService {

    private final MemoireRepository memoireRepository;

    public void ajouterMemoire(Memoire memoire){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        memoire.setUser(user);
        this.memoireRepository.save(memoire);
    }

    public List<Memoire> liste() {
        return (List<Memoire>) this.memoireRepository.findAll();
    }

    public List<Memoire> rechercherMemoire(String titre, String filiere, int annee){

        List<Memoire> memoires = (List<Memoire>) memoireRepository.findAll();

        return memoires.stream()
                .filter(memoire ->
                        (titre == null || memoire.getTitre().contains(titre)) &&
                                (filiere == null || memoire.getFiliere().equals(filiere)) &&
                                (annee == 0 || memoire.getAnnee() == annee))
                .collect(Collectors.toList());
    }
}
