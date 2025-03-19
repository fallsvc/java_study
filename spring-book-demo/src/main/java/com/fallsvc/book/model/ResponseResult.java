package com.fallsvc.book.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/17  21:31
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseResult<T> {
    private Integer total;
    private List<T> records;
    private PageRequest pageRequest;
}
