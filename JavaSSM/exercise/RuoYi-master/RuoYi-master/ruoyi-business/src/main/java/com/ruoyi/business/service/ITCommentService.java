package com.ruoyi.business.service;

import java.util.List;
import com.ruoyi.business.domain.TComment;

/**
 * 评论管理Service接口
 * 
 * @author ruoyi
 * @date 2025-05-26
 */
public interface ITCommentService 
{
    /**
     * 查询评论管理
     * 
     * @param id 评论管理主键
     * @return 评论管理
     */
    public TComment selectTCommentById(Long id);

    /**
     * 查询评论管理列表
     * 
     * @param tComment 评论管理
     * @return 评论管理集合
     */
    public List<TComment> selectTCommentList(TComment tComment);

    /**
     * 新增评论管理
     * 
     * @param tComment 评论管理
     * @return 结果
     */
    public int insertTComment(TComment tComment);

    /**
     * 修改评论管理
     * 
     * @param tComment 评论管理
     * @return 结果
     */
    public int updateTComment(TComment tComment);

    /**
     * 批量删除评论管理
     * 
     * @param ids 需要删除的评论管理主键集合
     * @return 结果
     */
    public int deleteTCommentByIds(String ids);

    /**
     * 删除评论管理信息
     * 
     * @param id 评论管理主键
     * @return 结果
     */
    public int deleteTCommentById(Long id);
}
