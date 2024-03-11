package com.estsoft.blogproject.repository;

import com.estsoft.blogproject.domain.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {
    List<Article> selectAllArticles();

    Article selectOneArticle(Long id);

    int insertOneArticle(Article article);

    int updateOneArticle(Article article);

    int deleteOneArticle(Long id);
}
