package br.com.thoughts.thoughts.repository;

import br.com.thoughts.thoughts.domain.Thought;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThoughtRepository extends JpaRepository<Thought, Long> {
}
