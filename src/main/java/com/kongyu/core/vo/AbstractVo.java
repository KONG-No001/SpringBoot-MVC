package com.kongyu.core.vo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Luojun
 * @version v1.0.0
 * @since 2025/8/25
 */

public class AbstractVo {

    protected String createdBy;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected Date createdDate;

    protected String updatedBy;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected Date updatedDate;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
