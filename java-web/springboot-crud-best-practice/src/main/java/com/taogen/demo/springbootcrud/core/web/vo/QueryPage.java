package com.taogen.demo.springbootcrud.core.web.vo;

import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * Query Page
 * <p>
 * Spring @Validate + ExceptionHandler (global)
 * or
 * Spring @Validate + BindingResult
 *
 * @author Taogen
 */
public class QueryPage<T> {
    private final String dbName = "mysql";

    @Min(value = 1, message = "pageNo can't less than 1")
    private Integer pageNo;

    @Min(value = 1, message = "pageSize can't less than 1")
    private Integer pageSize;
    private Long count;
    private String orderBy;
    private Integer start;

    /**
     * @Valid nested objects are also validated
     */
    @Valid
    private T entity;

    public QueryPage(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.start = (pageNo - 1) * pageSize;
    }


    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", count=" + count +
                ", orderBy='" + orderBy + '\'' +
                ", start=" + start +
                ", entity=" + entity +
                '}';
    }
}