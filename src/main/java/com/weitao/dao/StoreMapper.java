package com.weitao.dao;

import com.weitao.bean.Store;

import java.util.List;

public interface StoreMapper {
    int deleteByPrimaryKey(Integer stId);

    int insert(Store record);

    int insertSelective(Store record);

    Store selectByPrimaryKey(Integer stId);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);

    /*查询卖家有多少的店铺*/
    List<Store> seleteStore(Store store);
}