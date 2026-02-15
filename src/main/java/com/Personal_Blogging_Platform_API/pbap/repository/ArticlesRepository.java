package com.Personal_Blogging_Platform_API.pbap.repository;

import com.Personal_Blogging_Platform_API.pbap.entity.ArticlesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticlesRepository  extends JpaRepository<ArticlesEntity, Integer> {
}
