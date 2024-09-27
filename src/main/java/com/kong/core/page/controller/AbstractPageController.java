package com.kong.core.page.controller;

import com.kong.core.page.model.Page;
import com.kong.core.page.model.PageRequest;
import com.kong.core.common.Result;
import com.kong.core.page.service.PageService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Luojun
 * @version v1.0.0
 * @since 2024/9/27
 */
public abstract class AbstractPageController<T> {
    public abstract PageService<T> getQueryService();

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public Result page(@Validated PageRequest pageRequest) throws Exception {
        Page<T> page = getQueryService().page(pageRequest);
        return new Result();
    }

}
