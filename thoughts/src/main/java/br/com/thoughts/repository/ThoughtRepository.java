package br.com.thoughts.repository;

import br.com.thoughts.domain.ThoughtEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThoughtRepository extends JpaRepository<ThoughtEntity, Long> {
}
