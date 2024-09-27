package com.kong.core.page.model;

import java.util.List;

/**
 * 简单页面对象
 *
 * @author Luojun
 * @version v1.0.0
 * @since 2024/9/27
 */
public class Page<T> {
    protected List<T> record;
    protected long total = 0;

    public List<T> getRecord() {
        return record;
    }

    public void setRecord(List<T> record) {
        this.record = record;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
