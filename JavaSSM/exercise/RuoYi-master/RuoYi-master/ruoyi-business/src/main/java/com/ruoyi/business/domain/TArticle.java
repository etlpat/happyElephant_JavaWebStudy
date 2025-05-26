package com.ruoyi.business.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 文章信息管理对象 t_article
 * 
 * @author ruoyi
 * @date 2025-05-26
 */
public class TArticle extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 文章 id */
    private Long id;

    /** 文章标题 */
    @Excel(name = "文章标题")
    private String title;

    /** 文章内容 */
    @Excel(name = "文章内容")
    private String content;

    /** 评论管理信息 */
    private List<TComment> tCommentList;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }

    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    public List<TComment> getTCommentList()
    {
        return tCommentList;
    }

    public void setTCommentList(List<TComment> tCommentList)
    {
        this.tCommentList = tCommentList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("content", getContent())
            .append("tCommentList", getTCommentList())
            .toString();
    }
}
