package com.ruoyi.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.TCommentMapper;
import com.ruoyi.business.domain.TComment;
import com.ruoyi.business.service.ITCommentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 评论管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-05-26
 */
@Service
public class TCommentServiceImpl implements ITCommentService 
{
    @Autowired
    private TCommentMapper tCommentMapper;

    /**
     * 查询评论管理
     * 
     * @param id 评论管理主键
     * @return 评论管理
     */
    @Override
    public TComment selectTCommentById(Long id)
    {
        return tCommentMapper.selectTCommentById(id);
    }

    /**
     * 查询评论管理列表
     * 
     * @param tComment 评论管理
     * @return 评论管理
     */
    @Override
    public List<TComment> selectTCommentList(TComment tComment)
    {
        return tCommentMapper.selectTCommentList(tComment);
    }

    /**
     * 新增评论管理
     * 
     * @param tComment 评论管理
     * @return 结果
     */
    @Override
    public int insertTComment(TComment tComment)
    {
        return tCommentMapper.insertTComment(tComment);
    }

    /**
     * 修改评论管理
     * 
     * @param tComment 评论管理
     * @return 结果
     */
    @Override
    public int updateTComment(TComment tComment)
    {
        return tCommentMapper.updateTComment(tComment);
    }

    /**
     * 批量删除评论管理
     * 
     * @param ids 需要删除的评论管理主键
     * @return 结果
     */
    @Override
    public int deleteTCommentByIds(String ids)
    {
        return tCommentMapper.deleteTCommentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除评论管理信息
     * 
     * @param id 评论管理主键
     * @return 结果
     */
    @Override
    public int deleteTCommentById(Long id)
    {
        return tCommentMapper.deleteTCommentById(id);
    }
}
