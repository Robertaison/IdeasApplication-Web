package br.com.ideas.ideas.response;

import lombok.Data;

@Data
public class IdeaResponse {

    private int id;

    private String title;

    private String description;

    private String humor;

    private String date;
}
