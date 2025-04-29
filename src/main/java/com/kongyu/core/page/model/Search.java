package com.kongyu.core.page.model;

/**
 * @author Luojun
 * @version v1.0.0
 * @since 2024/9/27
 */
public class Search {
    protected String field;
    protected String operation;
    protected Object value;

    public Search() {
    }

    public Search(String field, Object value) {
        this.field = field;
        this.value = value;
    }

    public Search(String field, String operation, Object value) {
        this.field = field;
        this.operation = operation;
        this.value = value;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
