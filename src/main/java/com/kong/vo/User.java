package com.kong.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("`user`")
public class User {
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer id;
    @TableField("user_name")
    private String name;
    @TableField("user_password")
    private String password;

}
