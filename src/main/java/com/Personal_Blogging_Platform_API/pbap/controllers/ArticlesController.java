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

    @GetMapping("/{id}")
    public ResponseEntity<ArticlesEntity> findById(@PathVariable Integer id){
        ArticlesEntity articlesEntity = this.articlesService.getById(id);
        return ResponseEntity.ok(articlesEntity);
    }

    @GetMapping()
    public ResponseEntity<List<ArticlesEntity>> getAll(){
        return ResponseEntity.ok(articlesService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteArticles (@PathVariable Integer id){
        this.articlesService.deletArticle(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateArticles (@PathVariable Integer id, @RequestBody ArticlesEntity newData){
        ArticlesEntity updated = articlesService.updateById(id, newData);
        return ResponseEntity.ok().build();
    }
}
