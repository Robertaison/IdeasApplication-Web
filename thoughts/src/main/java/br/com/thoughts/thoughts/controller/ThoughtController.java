package br.com.thoughts.thoughts.controller;

import br.com.thoughts.thoughts.domain.Thought;
import br.com.thoughts.thoughts.service.ThoughtService;
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
    public Thought findById(@PathVariable final Long id) {
        return thoughtService.findById(id);
    }

    @GetMapping
    public List<Thought> findAll() {
        return thoughtService.retrieveAllThoughts();
    }

    @PostMapping
    public HttpEntity save(@Valid @RequestBody final Thought thought) {
        Long thoughtId = thoughtService.save(thought);
        return ResponseEntity.created(URI.create("/" + thoughtId)).build();
    }

    @DeleteMapping("/{id}")
    public void deleteThought(@PathVariable long id){
        thoughtService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateThought(@RequestBody Thought thought, @PathVariable long id){
        Optional<Thought> thoughtOptional = Optional.ofNullable(thoughtService.findById(id));

        if(!thoughtOptional.isPresent())
            return ResponseEntity.notFound().build();

        thought.setId(id);

        thoughtService.save(thought);

        return ResponseEntity.noContent().build();
    }
}
