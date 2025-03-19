package com.fallsvc.book.model;

import lombok.Data;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/17  21:36
 */
@Data
public class PageRequest {
    private Integer currentPage=1;
    private Integer pageSize=10;
    private Integer offset;
    public Integer getOffset(){
        return (currentPage-1)*pageSize;
    }
}
