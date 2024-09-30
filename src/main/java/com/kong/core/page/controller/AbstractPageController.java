package com.kong.core.page.controller;

import com.kong.core.common.model.Result;
import com.kong.core.page.model.ExportRequest;
import com.kong.core.page.model.Page;
import com.kong.core.page.model.PageRequest;
import com.kong.core.page.service.PageService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Map;

/**
 * @author Luojun
 * @version v1.0.0
 * @since 2024/9/27
 */
public abstract class AbstractPageController<T> {

    public abstract PageService<T> getQueryService();

    @RequestMapping(value = "/page")
    public Result<Page<T>> getPage(@RequestBody PageRequest pageRequest) throws Exception {
        return Result.success(getQueryService().getPage(pageRequest));
    }


    /**
     * 筛选工具栏
     *
     * @param pageRequest pageRequest
     * @return 筛选项数据
     * @throws CloneNotSupportedException pageRequest 复制异常
     */
    @RequestMapping(value = "/filter-toolbar-data")
    public Result<Map<String, Object>> getFilterToolbarData(PageRequest pageRequest) throws CloneNotSupportedException {
        return Result.success(getQueryService().getFilterToolbarData(pageRequest));
    }

    /**
     * 导出
     *
     * @param exportRequest exportRequest
     * @param resp          resp
     */
    @RequestMapping(value = "/export")
    public void export(HttpServletResponse resp, @RequestBody ExportRequest exportRequest) {
        try {
            resp.reset();
            resp.setContentType("application/text;charset=UTF-8");
            resp.addHeader("Content-Disposition", "attachment;filename=\"export-" + System.currentTimeMillis() + ".xlsx\"");
            ServletOutputStream stream = resp.getOutputStream();
            getQueryService().export(stream, exportRequest);
            stream.flush();
            stream.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
