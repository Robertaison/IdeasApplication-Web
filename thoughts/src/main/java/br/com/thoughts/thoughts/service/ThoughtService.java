package br.com.thoughts.thoughts.service;

import br.com.thoughts.thoughts.domain.Thought;
import br.com.thoughts.thoughts.repository.ThoughtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ThoughtService {

    @Autowired
    private ThoughtRepository thoughtRepository;

    @Transactional
    public Long save(final Thought thought) {

        Thought toPersist = thought;

        Thought persistedThought = persist(toPersist);

        return persistedThought.getId();
    }

    public Thought findById(final Long id){

        Thought thought =   retriveThoughtById(id);
        return thought;
    }

    @Transactional(readOnly = true)
    protected Thought retriveThoughtById(final Long id) {
        return thoughtRepository.findById(id).orElse(null);
    }

    @Transactional
    public Thought persist (final Thought thought){
        return thoughtRepository.save(thought);
    }

    public List<Thought> retrieveAllThoughts() {
        return thoughtRepository.findAll();
    }

    @Transactional
    public void delete(long id) {
        thoughtRepository.deleteById(id);
    }
}
