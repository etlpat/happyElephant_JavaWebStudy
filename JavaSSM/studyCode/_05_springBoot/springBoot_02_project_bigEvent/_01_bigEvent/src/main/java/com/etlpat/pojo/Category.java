package com.etlpat.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


// validated分组校验
//  功能：把校验项进行归类分组,在完成不同的功能的时候,校验指定组中的校验项。
//  步骤：
//      ①在实体类中定义分组接口。
//      ②为实体类中的校验注解设置分组。
//      ③在controller中使用@validated注解校验时，指定要校验的分组。
//  注意：定义校验项时如果没有指定分组,则属于Default分组,分组可以继承。


@Data// lombok注解，用于在编译阶段自动生成getter、setter、toString等方法
@NoArgsConstructor// 添加无参构造器
@AllArgsConstructor// 添加全参构造器
public class Category {// 分类表

    @NotNull(groups = Update.class)// 设置校验注解@NotNull的分组(仅在更新时非空)
    private Integer id;// ID

    @NotEmpty(groups = {Add.class, Update.class})// 设置校验注解@NotEmpty的分组(插入、更加时均非空)
    private String categoryName;// 分类名称

    @NotEmpty(groups = {Add.class, Update.class})// 设置校验注解@NotEmpty的分组
    private String categoryAlias;// 分类别名

    private Integer createUser;// 创建人ID

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")// 指定输出json字符串中，日期的格式
    private LocalDateTime createTime;// 创建时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;// 修改时间


    // 在实体类中定义validated分组接口。
    public interface Add {// add方法分组接口
    }

    public interface Update {// update方法分组接口
    }
}
