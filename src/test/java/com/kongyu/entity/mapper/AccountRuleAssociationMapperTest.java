package com.kongyu.entity.mapper;

import com.kongyu.entity.vo.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class AccountRuleAssociationMapperTest {

    @Autowired
    AccountRuleAssociationMapper accountRuleAssociationMapper;

    @Test
    void listRolesByAccountId() {
        List<Role> roles = accountRuleAssociationMapper.listRolesByAccountId(1);
        System.out.println(roles);
    }
}