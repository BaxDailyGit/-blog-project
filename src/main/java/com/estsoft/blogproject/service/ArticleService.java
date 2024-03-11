package com.estsoft.blogproject.service;

import com.estsoft.blogproject.domain.Article;
import com.estsoft.blogproject.domain.ModifyArticleRequest;
import com.estsoft.blogproject.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    private final BlogRepository repository;

    public ArticleService(BlogRepository repository) {
        this.repository = repository;
    }

    public List<Article> findAll() {
        return repository.selectAllArticles();
    }

    public Article findOne(Long id) {
        return repository.selectOneArticle(id);
    }

    public int insertOneArticle(Article article) {
        return repository.insertOneArticle(article);
    }

    public Article update(Long id, ModifyArticleRequest request) {
        Article article = findOne(id);
        String title = article.getTitle();
        String content = article.getContent();

        if (!title.equals(request.getTitle())) {
            title = request.getTitle();
        }

        if (!content.equals(request.getContent())) {
            content = request.getContent();
        }

        Article updatedArticle = new Article(id, title, content);
        repository.updateOneArticle(updatedArticle);

        return updatedArticle;
    }

    public int deleteOneArticle(Long id) {
        return repository.deleteOneArticle(id);
    }

}
