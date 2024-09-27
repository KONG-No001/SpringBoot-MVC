package com.kong.core.page.model;

/**
 * @author Luojun
 * @version v1.0.0
 * @since 2024/9/27
 */
public class Sort {
    protected String field;
    protected String direction;

    public Sort(String field) {
        this.field = field;
    }

    public Sort(String field, String direction) {
        this.field = field;
        this.direction = direction;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
