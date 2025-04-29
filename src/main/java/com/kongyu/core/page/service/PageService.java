package com.kongyu.core.page.service;

import com.kongyu.core.page.model.ExportRequest;
import com.kongyu.core.page.model.Page;
import com.kongyu.core.page.model.PageRequest;
import jakarta.servlet.ServletOutputStream;

import java.util.Map;

/**
 * @author Luojun
 * @version v1.0.0
 * @since 2024/9/27
 */
public interface PageService<T> {
    Page<T> getPage(PageRequest pageRequest);

    Map<String, Object> getFilterToolbarData(PageRequest pageRequest);

    void export(ServletOutputStream stream, ExportRequest exportRequest);
}
