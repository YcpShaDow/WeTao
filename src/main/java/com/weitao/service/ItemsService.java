package com.weitao.service;

import com.weitao.bean.Items;
import com.weitao.vo.ItemsVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ycp on 2018/9/4.
 */
@Service
public interface ItemsService {
    /*插入商品信息*/
    public boolean insertItems(Items items) throws  Exception;

    /*根据各种条件来查询，父类，商品名，子类，升序排序条件*/
    public List<ItemsVo> selectItems(String caFather, String iName, String caName ,String type)
                                        throws  Exception;

    /*根据各种条件来查询，父类，商品名，子类，降序排序条件*/
    public List<ItemsVo> selectItemsDown(String caFather, String iName, String caName, String type)throws  Exception;

    /*为搜索框进行多字段的查询，包含父类，子类，商品名*/
    public List<ItemsVo> selectItemsAll(String search);
}
