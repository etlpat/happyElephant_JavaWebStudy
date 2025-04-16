package com.etlpat.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.groups.Default;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;


@Data// lombok注解，用于在编译阶段自动生成getter、setter、toString等方法
@NoArgsConstructor// 添加无参构造器
@AllArgsConstructor// 添加全参构造器
public class Article {

    @NotNull(groups = Update.class)
    private Integer id;// ID

    @NotEmpty
    @Pattern(regexp = "^\\S{1,10}$")
    private String title;// 文章标题

    @NotEmpty
    private String content;// 文章内容

    @NotEmpty
    @URL
    private String coverImg;// 文章封面

    @NotEmpty
    @Pattern(regexp = "^(已发布|草稿)$")
    private String state;// 文章状态:只能是[已发布]或者[草稿]

    @NotNull
    private Integer categoryId;// 文章分类ID

    private Integer createUser;// 创建人ID

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;// 创建时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;// 修改时间


    // 在实体类中定义validated分组接口。
    public interface Add extends Default {// add方法分组接口
    }

    public interface Update extends Default {// update方法分组接口
    }
}
