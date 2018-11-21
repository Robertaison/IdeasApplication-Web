package br.com.thoughts.thoughts.domain;

import lombok.Data;
import javax.persistence.*;


@Entity
@Data
public class Thought  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String humor;

    private String data;
}
