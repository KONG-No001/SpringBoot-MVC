package com.kongyu.entity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kongyu.entity.vo.AccountRuleAssociation;
import com.kongyu.entity.vo.Role;

import java.util.List;

/**
 * @author Luojun
 * @version v1.0.0
 * @since 2025/8/26
 */
public interface AccountRuleAssociationMapper extends BaseMapper<AccountRuleAssociation> {
    List<Role> listRolesByAccountId(int accountId);
}
