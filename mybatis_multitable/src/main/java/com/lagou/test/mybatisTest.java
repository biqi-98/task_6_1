package com.lagou.test;

import com.lagou.domain.Article;
import com.lagou.mapper.ArticleMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class mybatisTest {
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;


    // 在 @Test方法标注的方法执行之前来执行
    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        sqlSession = sqlSessionFactory.openSession();
    }


    @After
    public void after(){

        sqlSession.commit();
        sqlSession.close();

    }



    /*
        测试查询方法
     */
    @Test
    public void testSelect() throws IOException {

        ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);

        List<Article> all = mapper.findAllWithComment();

        for (Article article : all) {
            System.out.println(article);
            article.getCommentList();
        }

        for (Article article : all) {
            System.out.println(article);
        }

    }

}
