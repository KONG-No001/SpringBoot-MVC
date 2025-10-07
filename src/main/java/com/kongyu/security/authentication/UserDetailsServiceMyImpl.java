package com.kongyu.security.authentication;

import com.kongyu.entity.vo.Account;
import com.kongyu.entity.vo.Role;
import com.kongyu.system.service.IAccountRuleAssociationService;
import com.kongyu.system.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

/**
 * @author Luojun
 * @version v1.0.0
 * @since 2025/8/25
 */
@Component
public class UserDetailsServiceMyImpl implements UserDetailsService {

    protected MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();

    @Autowired
    IAccountService accountService;

    @Autowired
    IAccountRuleAssociationService accountRuleAssociationService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account account = accountService.getByUserName(username);

        assertAccount(username, account);

        List<GrantedAuthority> authorityList = getGrantedAuthorities(account);

        return new User(
                account.getUsername(),
                account.getPassword(),
                authorityList
        );
    }

    private List<GrantedAuthority> getGrantedAuthorities(Account account) {
        List<GrantedAuthority> authorityList;
        List<Role> roleList = accountRuleAssociationService.listRolesByAccountId(account.getId());
        if (!roleList.isEmpty()) {
            authorityList = AuthorityUtils.createAuthorityList(roleList.stream().map(t -> "ROLE_" + t.getRoleName().toUpperCase(Locale.ROOT)).toArray(String[]::new));
        }
        else {
            authorityList = AuthorityUtils.NO_AUTHORITIES;
        }
        return authorityList;
    }

    private void assertAccount(String username, Account account) {
        if (account == null) {
            throw new UsernameNotFoundException(this.messages.getMessage(
                    "AccountServiceImpl.notFound",
                    new Object[]{username},
                    "Username {0} not found"
            ));
        }
    }
}
