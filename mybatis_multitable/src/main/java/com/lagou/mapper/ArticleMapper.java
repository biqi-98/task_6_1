package com.lagou.mapper;

import com.lagou.domain.Article;

import java.util.List;

public interface ArticleMapper {

    /*
        一对多嵌套查询：查询所有的文章，同时还要查询出每个文章所关联的评论信息
     */
    public List<Article> findAllWithComment();
}
