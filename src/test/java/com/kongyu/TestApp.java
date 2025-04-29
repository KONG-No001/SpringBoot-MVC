package com.kongyu;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author Luojun
 * @version v1.0.0
 * @since 2024/6/21
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = App.class)
public class TestApp {

    private MockMvc mvc;

    @WithMockUser(authorities = "USER")
    @Test
    public void endpointWhenUserAuthorityThenAuthorized() {
    }

    @WithMockUser
    @Test
    public void endpointWhenNotUserAuthorityThenForbidden() {
    }

    @Test
    public void anyWhenUnauthenticatedThenUnauthorized() {

    }
}
