package br.com.ideas.ideas.controller;

import br.com.ideas.ideas.request.IdeaRequest;
import br.com.ideas.ideas.service.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IdeaController {

    @Autowired
    private IdeaService ideaService;


}
