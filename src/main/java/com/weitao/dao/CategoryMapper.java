package com.weitao.dao;

import com.weitao.bean.Category;

import java.util.List;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer caId);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer caId);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    /*查询父类下有多少子类*/
    List<Category> selectCafather(String cafather);
}