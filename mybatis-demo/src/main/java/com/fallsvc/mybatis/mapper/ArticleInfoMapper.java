package com.fallsvc.mybatis.mapper;

import com.fallsvc.mybatis.model.ArticleInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/14  22:50
 */
@Mapper
public interface ArticleInfoMapper {
    ArticleInfo selectArticleInfoById(Integer id);
}
