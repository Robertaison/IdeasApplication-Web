package br.com.ideas.ideas.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Idea {

    @Id
    @GeneratedValue
    private int id;

    private String title;

    private String description;

    private String humor;

    private Date date;
}
