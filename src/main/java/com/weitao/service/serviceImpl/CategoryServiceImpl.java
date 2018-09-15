package com.weitao.service.serviceImpl;

import com.weitao.bean.Category;
import com.weitao.dao.CategoryMapper;
import com.weitao.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ycp on 2018/9/10.
 */
@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public List<Category> selectCafather(String cafather) {
        return categoryMapper.selectCafather(cafather);
    }
}
