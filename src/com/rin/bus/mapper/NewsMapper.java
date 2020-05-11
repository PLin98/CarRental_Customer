package com.rin.bus.mapper;

import java.util.List;

import com.rin.bus.domain.News;


public interface NewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);
    
    /**
     * 查询
     */
    List<News> queryAllNews(News news); 
}