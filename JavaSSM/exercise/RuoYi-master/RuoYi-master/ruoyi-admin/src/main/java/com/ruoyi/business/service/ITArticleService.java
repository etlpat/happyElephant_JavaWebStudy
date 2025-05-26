package com.ruoyi.business.service;

import java.util.List;
import com.ruoyi.business.domain.TArticle;

/**
 * 文章信息管理Service接口
 * 
 * @author ruoyi
 * @date 2025-05-26
 */
public interface ITArticleService 
{
    /**
     * 查询文章信息管理
     * 
     * @param id 文章信息管理主键
     * @return 文章信息管理
     */
    public TArticle selectTArticleById(Long id);

    /**
     * 查询文章信息管理列表
     * 
     * @param tArticle 文章信息管理
     * @return 文章信息管理集合
     */
    public List<TArticle> selectTArticleList(TArticle tArticle);

    /**
     * 新增文章信息管理
     * 
     * @param tArticle 文章信息管理
     * @return 结果
     */
    public int insertTArticle(TArticle tArticle);

    /**
     * 修改文章信息管理
     * 
     * @param tArticle 文章信息管理
     * @return 结果
     */
    public int updateTArticle(TArticle tArticle);

    /**
     * 批量删除文章信息管理
     * 
     * @param ids 需要删除的文章信息管理主键集合
     * @return 结果
     */
    public int deleteTArticleByIds(String ids);

    /**
     * 删除文章信息管理信息
     * 
     * @param id 文章信息管理主键
     * @return 结果
     */
    public int deleteTArticleById(Long id);
}
