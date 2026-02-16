package com.Personal_Blogging_Platform_API.pbap.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "articles")
public class ArticlesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @CreationTimestamp
    private LocalDateTime creationdata;

    protected ArticlesEntity(){}

    public ArticlesEntity(String title, String description){
        this.title = title;
        this.description = description;
    }

    public Integer getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreationdata(){
        return this.creationdata;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
