package com.kongyu.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kongyu.entity.vo.AccountRuleAssociation;
import com.kongyu.entity.vo.Role;

import java.util.List;

/**
 * @author Luojun
 * @version v1.0.0
 * @since 2025/8/26
 */
public interface IAccountRuleAssociationService extends IService<AccountRuleAssociation> {
    List<Role> listRolesByAccountId(int id);
}
