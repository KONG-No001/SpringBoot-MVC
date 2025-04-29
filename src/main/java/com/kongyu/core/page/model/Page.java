package com.kongyu.core.page.model;

import java.util.List;

/**
 * 表示分页响应的泛型类。
 *
 * @param <T> 此页面包含的记录类型。
 * @author Luojun
 * @version v1.0.0
 * @since 2024/9/27
 */
public class Page<T> {

    /**
     * 此页面中的记录列表。
     */
    protected List<T> record;

    /**
     * 所有页面的记录总数。
     */
    protected long total = 0;

    /**
     * 获取此页面的记录列表。
     *
     * @return 类型 T 的记录列表。
     */
    public List<T> getRecord() {
        return record;
    }

    /**
     * 设置此页面的记录列表。
     *
     * @param record 要设置的记录列表。
     */
    public void setRecord(List<T> record) {
        this.record = record;
    }

    /**
     * 获取所有页面的记录总数。
     *
     * @return 总记录计数。
     */
    public long getTotal() {
        return total;
    }

    /**
     * 设置所有页面的记录总数。
     *
     * @param total 要设置的记录总数。
     */
    public void setTotal(long total) {
        this.total = total;
    }

    /**
     * 检查当前页面是否有记录。
     *
     * @return 如果页面没有记录，则为 true，否则为 false。
     */
    public boolean isEmpty() {
        return record == null || record.isEmpty();
    }
}
