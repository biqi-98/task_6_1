package com.lagou.mapper;

import com.lagou.domain.Comment;

import java.util.List;

public interface CommentMapper {


    /*
        根据aid查询对应评论
     */
    public List<Comment> findByAid(Integer aid);





}
