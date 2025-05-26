package com.etlpat.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.etlpat.mapper.CommentMapper;
import com.etlpat.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentMapper commentMapper;


    public List<Comment> getCommentsByAuthorId(Integer authorId) {
        LambdaQueryWrapper<Comment> wrapper = new LambdaQueryWrapper<Comment>()
                .eq(Comment::getAuthorId, authorId);
        return commentMapper.selectList(wrapper);
    }

}
