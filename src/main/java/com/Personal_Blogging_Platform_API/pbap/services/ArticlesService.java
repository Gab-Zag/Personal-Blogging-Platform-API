package com.Personal_Blogging_Platform_API.pbap.services;

import com.Personal_Blogging_Platform_API.pbap.entity.ArticlesEntity;
import com.Personal_Blogging_Platform_API.pbap.repository.ArticlesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticlesService {
    private final ArticlesRepository articlesRepository;

    public ArticlesService(ArticlesRepository articlesRepository){
        this.articlesRepository = articlesRepository;
    }

    public ArticlesEntity create(ArticlesEntity articlesEntity){
        return articlesRepository.save(articlesEntity);
    }

    public List<ArticlesEntity> findAll(){
        return articlesRepository.findAll();
    }

    public ArticlesEntity getById(Integer id){
        return articlesRepository.findById(id).orElse(null);
    }

    public void deletArticle (Integer id){
        articlesRepository.deleteById(id);
    }

    public ArticlesEntity updateById(Integer id, ArticlesEntity newData){
        ArticlesEntity article = articlesRepository.findById(id).orElseThrow(() -> new RuntimeException("Artigo nao encotrado"));
        article.setTitle(newData.getTitle());
        article.setDescription(newData.getDescription());

        return articlesRepository.save(article);
    }
}
