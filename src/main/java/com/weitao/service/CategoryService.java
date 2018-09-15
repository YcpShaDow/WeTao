package com.weitao.service;

import com.weitao.bean.Category;
import com.weitao.dao.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by ycp on 2018/9/10.
 */
public interface CategoryService {
    public List<Category> selectCafather(String cafather);
}
