package tech.enspd.enspdbiblio.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.enspd.enspdbiblio.entities.Memoire;
import tech.enspd.enspdbiblio.service.MemoireService;
@AllArgsConstructor
@RestController
@RequestMapping(path = "memoire")
public class MemoireController {

    private final MemoireService memoireService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void creer (@RequestBody Memoire memoire){
        this.memoireService.creer(memoire);
    }
}
