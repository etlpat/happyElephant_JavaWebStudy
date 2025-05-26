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
import com.ruoyi.business.domain.TArticle;
import com.ruoyi.business.service.ITArticleService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 文章信息管理Controller
 * 
 * @author ruoyi
 * @date 2025-05-26
 */
@Controller
@RequestMapping("/business/article")
public class TArticleController extends BaseController
{
    private String prefix = "business/article";

    @Autowired
    private ITArticleService tArticleService;

    @RequiresPermissions("business:article:view")
    @GetMapping()
    public String article()
    {
        return prefix + "/article";
    }

    /**
     * 查询文章信息管理列表
     */
    @RequiresPermissions("business:article:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TArticle tArticle)
    {
        startPage();
        List<TArticle> list = tArticleService.selectTArticleList(tArticle);
        return getDataTable(list);
    }

    /**
     * 导出文章信息管理列表
     */
    @RequiresPermissions("business:article:export")
    @Log(title = "文章信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TArticle tArticle)
    {
        List<TArticle> list = tArticleService.selectTArticleList(tArticle);
        ExcelUtil<TArticle> util = new ExcelUtil<TArticle>(TArticle.class);
        return util.exportExcel(list, "文章信息管理数据");
    }

    /**
     * 新增文章信息管理
     */
    @RequiresPermissions("business:article:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存文章信息管理
     */
    @RequiresPermissions("business:article:add")
    @Log(title = "文章信息管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TArticle tArticle)
    {
        return toAjax(tArticleService.insertTArticle(tArticle));
    }

    /**
     * 修改文章信息管理
     */
    @RequiresPermissions("business:article:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TArticle tArticle = tArticleService.selectTArticleById(id);
        mmap.put("tArticle", tArticle);
        return prefix + "/edit";
    }

    /**
     * 修改保存文章信息管理
     */
    @RequiresPermissions("business:article:edit")
    @Log(title = "文章信息管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TArticle tArticle)
    {
        return toAjax(tArticleService.updateTArticle(tArticle));
    }

    /**
     * 删除文章信息管理
     */
    @RequiresPermissions("business:article:remove")
    @Log(title = "文章信息管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tArticleService.deleteTArticleByIds(ids));
    }
}
