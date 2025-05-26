package com.ruoyi.business.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.business.domain.TComment;
import com.ruoyi.business.service.ITCommentService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 评论管理Controller
 * 
 * @author ruoyi
 * @date 2025-05-26
 */
@Controller
@RequestMapping("/business/comment")
public class TCommentController extends BaseController
{
    private String prefix = "business/comment";

    @Autowired
    private ITCommentService tCommentService;

    @RequiresPermissions("business:comment:view")
    @GetMapping()
    public String comment()
    {
        return prefix + "/comment";
    }

    /**
     * 查询评论管理列表
     */
    @RequiresPermissions("business:comment:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TComment tComment)
    {
        startPage();
        List<TComment> list = tCommentService.selectTCommentList(tComment);
        return getDataTable(list);
    }

    /**
     * 导出评论管理列表
     */
    @RequiresPermissions("business:comment:export")
    @Log(title = "评论管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TComment tComment)
    {
        List<TComment> list = tCommentService.selectTCommentList(tComment);
        ExcelUtil<TComment> util = new ExcelUtil<TComment>(TComment.class);
        return util.exportExcel(list, "评论管理数据");
    }

    /**
     * 新增评论管理
     */
    @RequiresPermissions("business:comment:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存评论管理
     */
    @RequiresPermissions("business:comment:add")
    @Log(title = "评论管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TComment tComment)
    {
        return toAjax(tCommentService.insertTComment(tComment));
    }

    /**
     * 修改评论管理
     */
    @RequiresPermissions("business:comment:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TComment tComment = tCommentService.selectTCommentById(id);
        mmap.put("tComment", tComment);
        return prefix + "/edit";
    }

    /**
     * 修改保存评论管理
     */
    @RequiresPermissions("business:comment:edit")
    @Log(title = "评论管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TComment tComment)
    {
        return toAjax(tCommentService.updateTComment(tComment));
    }

    /**
     * 删除评论管理
     */
    @RequiresPermissions("business:comment:remove")
    @Log(title = "评论管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tCommentService.deleteTCommentByIds(ids));
    }
}
