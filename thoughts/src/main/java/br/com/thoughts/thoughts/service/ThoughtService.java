package br.com.thoughts.thoughts.service;

import br.com.thoughts.thoughts.domain.Thought;
import br.com.thoughts.thoughts.repository.ThoughtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ThoughtService {

    @Autowired
    private ThoughtRepository thoughtRepository;

    @Transactional
    public Long save(final Thought thought) {
//        log.info("Method=save, activityRequest={}", activityRequest);

        Thought toPersist = thought;

        Thought persistedThought = persist(toPersist);

        return persistedThought.getId();
    }

    public Thought findById(final Long id){
//        log.info("Method=findById, id={}", id);

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
}
