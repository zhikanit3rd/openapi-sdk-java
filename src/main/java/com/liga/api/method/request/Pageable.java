package com.liga.api.method.request;

import com.liga.api.method.LigaApiRequest;

/**
 * @author: Ferry
 * @create: 2023/10/16
 * @description:
 **/
public interface Pageable extends LigaApiRequest {

    /**
     * 获取当前页面
     * @return
     */
    Integer getPageNumber();

    /**
     * 设置当前页面，从1开始
     * @param pageNumber
     * @return
     */
    void setPageNumber(Integer pageNumber);

    /**
     * 获取每页分页条数
     * @return
     */
    Integer getPageSize();

    /**
     * 设置每页分页条数
     * @param pageSize
     * @return
     */
    void setPageSize(Integer pageSize);

}
