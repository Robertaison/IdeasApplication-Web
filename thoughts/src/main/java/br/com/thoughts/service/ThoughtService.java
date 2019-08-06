package br.com.thoughts.service;

import br.com.thoughts.domain.ThoughtEntity;
import br.com.thoughts.repository.ThoughtRepository;
import br.com.thoughts.utils.GetData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ThoughtService {

    @Autowired
    private ThoughtRepository thoughtRepository;

    @Transactional
    public Long save(final ThoughtEntity thoughtEntity) {
        GetData getData = new GetData();
        thoughtEntity.setData(getData.data());
        ThoughtEntity toPersist = thoughtEntity;

        ThoughtEntity persistedThoughtEntity = persist(toPersist);

        return persistedThoughtEntity.getId();
    }

    public ThoughtEntity findById(final Long id){

        ThoughtEntity thoughtEntity =   retriveThoughtById(id);
        return thoughtEntity;
    }

    @Transactional(readOnly = true)
    protected ThoughtEntity retriveThoughtById(final Long id) {
        return thoughtRepository.findById(id).orElse(null);
    }

    @Transactional
    public ThoughtEntity persist (final ThoughtEntity thoughtEntity){
        return thoughtRepository.save(thoughtEntity);
    }

    public List<ThoughtEntity> retrieveAllThoughts() {
        return thoughtRepository.findAll();
    }

    @Transactional
    public void delete(long id) {
        thoughtRepository.deleteById(id);
    }
}
