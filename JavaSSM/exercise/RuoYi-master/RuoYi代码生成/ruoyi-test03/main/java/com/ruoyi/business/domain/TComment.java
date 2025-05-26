package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 评论管理对象 t_comment
 * 
 * @author ruoyi
 * @date 2025-05-26
 */
public class TComment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 评论 id */
    private Long id;

    /** 评论内容 */
    @Excel(name = "评论内容")
    private String content;

    /** 评论作者 */
    @Excel(name = "评论作者")
    private String author;

    /** 关联的文章id */
    @Excel(name = "关联的文章id")
    private Long aId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setAuthor(String author) 
    {
        this.author = author;
    }

    public String getAuthor() 
    {
        return author;
    }
    public void setaId(Long aId) 
    {
        this.aId = aId;
    }

    public Long getaId() 
    {
        return aId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("content", getContent())
            .append("author", getAuthor())
            .append("aId", getaId())
            .toString();
    }
}
