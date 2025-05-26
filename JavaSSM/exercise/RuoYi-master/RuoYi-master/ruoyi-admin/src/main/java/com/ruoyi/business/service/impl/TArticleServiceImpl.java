package com.ruoyi.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.business.domain.TComment;
import com.ruoyi.business.mapper.TArticleMapper;
import com.ruoyi.business.domain.TArticle;
import com.ruoyi.business.service.ITArticleService;
import com.ruoyi.common.core.text.Convert;

/**
 * 文章信息管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-05-26
 */
@Service
public class TArticleServiceImpl implements ITArticleService 
{
    @Autowired
    private TArticleMapper tArticleMapper;

    /**
     * 查询文章信息管理
     * 
     * @param id 文章信息管理主键
     * @return 文章信息管理
     */
    @Override
    public TArticle selectTArticleById(Long id)
    {
        return tArticleMapper.selectTArticleById(id);
    }

    /**
     * 查询文章信息管理列表
     * 
     * @param tArticle 文章信息管理
     * @return 文章信息管理
     */
    @Override
    public List<TArticle> selectTArticleList(TArticle tArticle)
    {
        return tArticleMapper.selectTArticleList(tArticle);
    }

    /**
     * 新增文章信息管理
     * 
     * @param tArticle 文章信息管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertTArticle(TArticle tArticle)
    {
        int rows = tArticleMapper.insertTArticle(tArticle);
        insertTComment(tArticle);
        return rows;
    }

    /**
     * 修改文章信息管理
     * 
     * @param tArticle 文章信息管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateTArticle(TArticle tArticle)
    {
        tArticleMapper.deleteTCommentByAId(tArticle.getId());
        insertTComment(tArticle);
        return tArticleMapper.updateTArticle(tArticle);
    }

    /**
     * 批量删除文章信息管理
     * 
     * @param ids 需要删除的文章信息管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteTArticleByIds(String ids)
    {
        tArticleMapper.deleteTCommentByAIds(Convert.toStrArray(ids));
        return tArticleMapper.deleteTArticleByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除文章信息管理信息
     * 
     * @param id 文章信息管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteTArticleById(Long id)
    {
        tArticleMapper.deleteTCommentByAId(id);
        return tArticleMapper.deleteTArticleById(id);
    }

    /**
     * 新增评论管理信息
     * 
     * @param tArticle 文章信息管理对象
     */
    public void insertTComment(TArticle tArticle)
    {
        List<TComment> tCommentList = tArticle.getTCommentList();
        Long id = tArticle.getId();
        if (StringUtils.isNotNull(tCommentList))
        {
            List<TComment> list = new ArrayList<TComment>();
            for (TComment tComment : tCommentList)
            {
                tComment.setaId(id);
                list.add(tComment);
            }
            if (list.size() > 0)
            {
                tArticleMapper.batchTComment(list);
            }
        }
    }
}
