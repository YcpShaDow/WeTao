package com.weitao.dao;

import com.weitao.bean.Items;
import com.weitao.vo.ItemsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemsMapper {
    int deleteByPrimaryKey(Integer iId);

    int insert(Items record);

    int insertSelective(Items record);

    Items selectByPrimaryKey(Integer iId);

    int updateByPrimaryKeySelective(Items record);

    int updateByPrimaryKeyWithBLOBs(Items record);

    int updateByPrimaryKey(Items record);
    /*根据各种条件来查询，父类，商品名，子类，升序排序条件*/
    List<ItemsVo> selectItems(@Param("caFather") String caFather,
                              @Param("iName") String iName,
                              @Param("caName") String caName ,@Param("type") String type);
    /*根据各种条件来查询，父类，商品名，子类，降序排序条件*/
    List<ItemsVo> selectItemsDown(@Param("caFather") String caFather,
                              @Param("iName") String iName,
                              @Param("caName") String caName ,@Param("type") String type);
    /*为搜索框进行多字段的查询，包含父类，子类，商品名*/
    List<ItemsVo> selectItemsAll(@Param("search") String search);
}