package com.biz.std.utils;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by xjk70 on 2017/5/11.
 */
public class ManagePage {
    private Integer currentPage ;
    private Integer pageSize;
    private Integer allPageCounts;
    private Integer allSize;

    public ManagePage() {
    }

    public ManagePage(Integer currentPage, Integer pageSize, Integer allPageCounts, Integer allSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.allPageCounts = allPageCounts;
        this.allSize = allSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getAllPageCounts() {
        return allPageCounts;
    }

    public void setAllPageCounts(Integer allPageCounts) {
        this.allPageCounts = allPageCounts;
    }

    public Integer getAllSize() {
        return allSize;
    }

    public void setAllSize(Integer allSize) {
        this.allSize = allSize;
    }
}
