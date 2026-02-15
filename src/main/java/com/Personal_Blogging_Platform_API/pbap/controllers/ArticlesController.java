package com.Personal_Blogging_Platform_API.pbap.controllers;

import com.Personal_Blogging_Platform_API.pbap.entity.ArticlesEntity;
import com.Personal_Blogging_Platform_API.pbap.services.ArticlesService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticlesController {

    private final ArticlesService articlesService;

    public ArticlesController(ArticlesService articlesService){
        this.articlesService = articlesService;
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody @Valid ArticlesEntity articlesEntity){
        this.articlesService.create(articlesEntity);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<List<ArticlesEntity>> getAll(){
        return ResponseEntity.ok(articlesService.findAll());
    }
}
