package com.kongyu.entity.vo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("`authorities`")
public class Authorities {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("authority")
    private String authority;
    @TableField("username")
    private String username;
}
