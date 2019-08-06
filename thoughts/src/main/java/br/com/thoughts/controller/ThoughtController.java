package br.com.thoughts.controller;

import br.com.thoughts.domain.ThoughtEntity;
import br.com.thoughts.service.ThoughtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class ThoughtController {

    @Autowired
    private ThoughtService thoughtService;

    @GetMapping("/{id}")
    public ThoughtEntity findById(@PathVariable final Long id) {
        return thoughtService.findById(id);
    }

    @GetMapping
    public List<ThoughtEntity> findAll() {
        return thoughtService.retrieveAllThoughts();
    }

    @PostMapping
    public HttpEntity save(@Valid @RequestBody final ThoughtEntity thoughtEntity) {
        Long thoughtId = thoughtService.save(thoughtEntity);
        return ResponseEntity.created(URI.create("/" + thoughtId)).build();
    }

    @DeleteMapping("/{id}")
    public void deleteThought(@PathVariable long id){
        thoughtService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateThought(@RequestBody ThoughtEntity thoughtEntity, @PathVariable long id){
        Optional<ThoughtEntity> thoughtOptional = Optional.ofNullable(thoughtService.findById(id));

        if(!thoughtOptional.isPresent())
            return ResponseEntity.notFound().build();

        thoughtEntity.setId(id);

        thoughtService.save(thoughtEntity);

        return ResponseEntity.noContent().build();
    }
}
