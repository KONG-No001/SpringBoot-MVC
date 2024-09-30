package com.kong.core.page.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * 页面查询请求对象
 *
 * @author Luojun
 * @version v1.0.0
 * @since 2024/9/27
 */
public class PageRequest {
    /**
     * 搜索列表
     */
    protected List<Search> searches;

    /**
     * 排序列表
     */
    protected List<Sort> sorts;

    /**
     * 构造一个 PageRequest 类
     */
    public PageRequest() {
    }

    /**
     * 用给定的搜索列表和排序列表构造一个 PageRequest 类
     *
     * @param searches 搜索列表
     * @param sorts    排序列表
     */
    public PageRequest(List<Search> searches, List<Sort> sorts) {
        this.searches = searches;
        this.sorts = sorts;
    }

    /**
     * 返回排序列表。
     *
     * @return 排序列表。
     */
    public List<Sort> getSorts() {
        return sorts;
    }

    /**
     * 设置排序列表。
     *
     * @param sorts List of Sort objects to set.
     */
    public void setSorts(List<Sort> sorts) {
        this.sorts = sorts;
    }

    /**
     * 添加具有指定字段、操作和值的新搜索。
     *
     * @param field     要搜索的字段。
     * @param operation 要执行的操作。
     * @param value     搜索的值。
     */
    public void addSearch(String field, String operation, Object value) {
        addSearch(new Search(field, operation, value));
    }

    /**
     * 将 Search 对象添加到搜索列表中。
     *
     * @param search 要添加的 Search 对象。
     */
    public void addSearch(Search search) {
        getSearches().add(search);
    }

    /**
     * 返回搜索列表。
     * 如果列表为 null，则初始化列表。
     *
     * @return 搜索列表。
     */
    public List<Search> getSearches() {
        if (this.searches == null) {
            this.searches = new ArrayList<>();
        }
        return this.searches;
    }

    /**
     * 设置搜索列表。
     *
     * @param searches 要设置的 Search 对象列表。
     */
    public void setSearches(List<Search> searches) {
        this.searches = searches;
    }

    /**
     * 根据字段名称从列表中删除搜索。
     *
     * @param field 要搜索和删除的字段。
     */
    public void removeSearch(String field) {
        getSearches().removeIf(t -> field.equals(t.getField()));
    }

    /**
     * 检查是否存在对指定字段的搜索。
     *
     * @param field 要检查的字段。
     * @return 如果字段存在，则为 true，否则为 false。
     */
    public boolean hasField(String field) {
        return getSearches().stream().anyMatch(t -> field.equals(t.getField()));
    }

    /**
     * 检索与指定字段匹配的第一个 Search 对象的值。
     *
     * @param field 要搜索的字段。
     * @return 匹配的 Search 对象的值，如果未找到，则为 null。
     */
    public Object getFieldData(String field) {
        return getSearches().stream().filter(t -> field.equals(t.getField())).findFirst().map(t -> t.value).orElse(null);
    }

    /**
     * 检索与指定字段匹配的所有 Search 对象的值。
     *
     * @param field 要搜索的字段。
     * @return 来自匹配 Search 对象的值列表。
     */
    public List<Object> getFieldDatas(String field) {
        return getSearches().stream().filter(t -> field.equals(t.getField())).map(t -> t.value).collect(Collectors.toList());
    }

    /**
     * 在与指定字段匹配的 Search 对象上执行提供的函数。
     *
     * @param field 要搜索的字段。
     * @param fun   要对匹配的 Search 对象执行的函数。
     */
    public void whenField(String field, Consumer<Search> fun) {
        Search search = getField(field);
        if (search != null) {
            fun.accept(search);
        }
    }

    /**
     * 检索与指定字段匹配的第一个 Search 对象。
     *
     * @param field 要搜索的字段。
     * @return 匹配的 Search 对象或 null（如果未找到）。
     */
    public Search getField(String field) {
        return getSearches().stream().filter(t -> field.equals(t.getField())).findFirst().orElse(null);
    }

    /**
     * 在与指定字段匹配的 Search 对象列表上执行提供的函数。
     *
     * @param field 要搜索的字段。
     * @param fun   要对 Search 对象的匹配列表执行的函数。
     */
    public void whenFields(String field, Consumer<List<Search>> fun) {
        List<Search> s = getFields(field);
        if (!s.isEmpty()) { fun.accept(s); }
    }

    /**
     * 检索与指定字段匹配的 Search 对象的列表。
     *
     * @param field 要搜索的字段。
     * @return 匹配的 Search 对象列表。
     */
    public List<Search> getFields(String field) {
        return getSearches().stream().filter(t -> field.equals(t.getField())).collect(Collectors.toList());
    }

}
