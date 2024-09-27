package com.kong.core.page.service;

import com.kong.core.page.model.Page;
import com.kong.core.page.model.PageRequest;

/**
 * @author Luojun
 * @version v1.0.0
 * @since 2024/9/27
 */
public interface PageService<T> {
    Page<T> page(PageRequest pageRequest);
}
