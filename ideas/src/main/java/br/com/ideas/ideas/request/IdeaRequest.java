package br.com.ideas.ideas.request;

import lombok.Data;

@Data
public class IdeaRequest {

    private String title;

    private String description;

    private String humor;

    private String date;
}
