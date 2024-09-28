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
    protected List<Search> searches;
    protected List<Sort> sorts;

    public PageRequest() {
    }

    public PageRequest(List<Search> searches, List<Sort> sorts) {
        this.searches = searches;
        this.sorts = sorts;
    }

    /**
     * Returns the list of sorts.
     *
     * @return List of sorts.
     */
    public List<Sort> getSorts() {
        return sorts;
    }

    /**
     * Sets the list of sorts.
     *
     * @param sorts List of Sort objects to set.
     */
    public void setSorts(List<Sort> sorts) {
        this.sorts = sorts;
    }

    /**
     * Adds a new search with the specified field, operation, and value.
     *
     * @param field     The field to search on.
     * @param operation The operation to perform.
     * @param value     The value for the search.
     */
    public void addSearch(String field, String operation, Object value) {
        addSearch(new Search(field, operation, value));
    }

    /**
     * Adds a Search object to the list of searches.
     *
     * @param search The Search object to add.
     */
    public void addSearch(Search search) {
        getSearches().add(search);
    }

    /**
     * Returns the list of searches.
     * Initializes the list if it is null.
     *
     * @return List of searches.
     */
    public List<Search> getSearches() {
        if (this.searches == null) {
            this.searches = new ArrayList<>();
        }
        return this.searches;
    }

    /**
     * Sets the list of searches.
     *
     * @param searches List of Search objects to set.
     */
    public void setSearches(List<Search> searches) {
        this.searches = searches;
    }

    /**
     * Removes a search from the list based on the field name.
     *
     * @param field The field to search for and remove.
     */
    public void removeSearch(String field) {
        getSearches().removeIf(t -> field.equals(t.getField()));
    }

    /**
     * Checks if a search for the specified field exists.
     *
     * @param field The field to check.
     * @return true if the field exists, false otherwise.
     */
    public boolean hasField(String field) {
        return getSearches().stream().anyMatch(t -> field.equals(t.getField()));
    }

    /**
     * Retrieves the value of the first Search object that matches the specified field.
     *
     * @param field The field to search for.
     * @return The value of the matching Search object or null if not found.
     */
    public Object getFieldData(String field) {
        return getSearches().stream().filter(t -> field.equals(t.getField())).findFirst().map(t -> t.value).orElse(null);
    }

    /**
     * Retrieves the values of all Search objects that match the specified field.
     *
     * @param field The field to search for.
     * @return List of values from matching Search objects.
     */
    public List<Object> getFieldDatas(String field) {
        return getSearches().stream().filter(t -> field.equals(t.getField())).map(t -> t.value).collect(Collectors.toList());
    }

    /**
     * Executes the provided function on the Search object that matches the specified field.
     *
     * @param field The field to search for.
     * @param fun   The function to execute on the matching Search object.
     */
    public void whenField(String field, Consumer<Search> fun) {
        Search search = getField(field);
        if (search != null) {
            fun.accept(search);
        }
    }

    /**
     * Retrieves the first Search object that matches the specified field.
     *
     * @param field The field to search for.
     * @return The matching Search object or null if not found.
     */
    public Search getField(String field) {
        return getSearches().stream().filter(t -> field.equals(t.getField())).findFirst().orElse(null);
    }

    /**
     * Executes the provided function on the list of Search objects that match the specified field.
     *
     * @param field The field to search for.
     * @param fun   The function to execute on the matching list of Search objects.
     */
    public void whenFields(String field, Consumer<List<Search>> fun) {
        List<Search> s = getFields(field);
        if (!s.isEmpty()) { fun.accept(s); }
    }

    /**
     * Retrieves a list of Search objects that match the specified field.
     *
     * @param field The field to search for.
     * @return List of matching Search objects.
     */
    public List<Search> getFields(String field) {
        return getSearches().stream().filter(t -> field.equals(t.getField())).collect(Collectors.toList());
    }

}
