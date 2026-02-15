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
}
