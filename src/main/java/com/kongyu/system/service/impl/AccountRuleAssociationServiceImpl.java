package com.kongyu.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kongyu.entity.mapper.AccountRuleAssociationMapper;
import com.kongyu.entity.vo.AccountRuleAssociation;
import com.kongyu.entity.vo.Role;
import com.kongyu.system.service.IAccountRuleAssociationService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Luojun
 * @version v1.0.0
 * @since 2025/8/26
 */

@Service
public class AccountRuleAssociationServiceImpl extends ServiceImpl<AccountRuleAssociationMapper, AccountRuleAssociation> implements IAccountRuleAssociationService {

    @Override
    public List<Role> listRolesByAccountId(int id) {
        return getBaseMapper().listRolesByAccountId(id);
    }
}
