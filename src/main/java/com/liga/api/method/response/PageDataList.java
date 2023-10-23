package com.liga.api.method.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author: Ferry
 * @create: 2023/10/16
 * @description:
 **/

@Getter
@Setter
public class PageDataList<T> {
    private Long total;
    private List<T> list;

    public PageDataList() {
    }

    @Override
    public String toString() {
        return "PageDataList{" +
                "total=" + total +
                ", list=" + list +
                '}';
    }
}
