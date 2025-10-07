package com.kongyu.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.kongyu.core.vo.AbstractVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Luojun
 * @version v1.0.0
 * @since 2025/8/25
 */

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("`sys_account_rule_association`")
public class AccountRuleAssociation extends AbstractVo {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("account_id")
    private String accountId;

    @TableField("role_id")
    private String roleId;

}
