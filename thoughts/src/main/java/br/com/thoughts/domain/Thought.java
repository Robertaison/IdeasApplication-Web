package br.com.thoughts.domain;

import lombok.Data;
import javax.persistence.*;


@Entity
@Data
public class ThoughtEntity {

    @Id
    @GeneratedValue(generator = "increment")
    private Long id;

    private String title;

    private String description;

    private String humor;

    private String data;
}
