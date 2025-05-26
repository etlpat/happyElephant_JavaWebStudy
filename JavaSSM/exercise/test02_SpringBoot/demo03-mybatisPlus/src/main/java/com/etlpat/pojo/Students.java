package com.etlpat.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Students {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private String number;
    private String address;
    private Integer status;
}
