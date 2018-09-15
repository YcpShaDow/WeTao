package com.weitao.service.serviceImpl;

import com.weitao.bean.Items;
import com.weitao.dao.ItemsMapper;
import com.weitao.exception.ResultEnum;
import com.weitao.exception.UserException;
import com.weitao.service.ItemsService;
import com.weitao.vo.ItemsVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by ycp on 2018/9/4.
 */

@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsMapper itemsMapper;

    /*插入商品*/
    @Override
    public boolean insertItems(Items items) throws Exception {
        ItemsVo itemsVo = new ItemsVo();
        //将items表的属性copy过来
        BeanUtils.copyProperties(items, itemsVo);
        itemsVo.setiSale(0);
        System.out.println(itemsVo.getiExsit() + "111");
        if (itemsVo.getiExsit() <= 0)/*如果库存大于0就物品的状态为0，否则为1*/
            throw new UserException(ResultEnum.ITEMS_EXSIT);
        else
            itemsVo.setiStatus((byte) 0);
        itemsVo.setiDate(new Date());
        System.out.println(itemsVo.getiName() + "====");
        int insert = itemsMapper.insert(itemsVo);
        if (insert == 1) { //插入成功返回的是1
            return true;
        }
        return false;
    }

    /*根据父类，子类，商品名查询，可按照价格销售量上架时间升序*/
    @Override
    public List<ItemsVo> selectItems(String caFather, String iName, String caName, String type) throws Exception {
        return itemsMapper.selectItems(caFather, iName, caName, type);
    }

    /*根据父类，子类，商品名查询，可按照价格销售量上架时间降序*/
    @Override
    public List<ItemsVo> selectItemsDown(String caFather, String iName, String caName, String type) throws Exception {
        return itemsMapper.selectItemsDown(caFather,iName,caName,type);
    }

    /*为搜索框进行多字段的查询，包含父类，子类，商品名*/
    @Override
    public List<ItemsVo> selectItemsAll(String search) {
        return itemsMapper.selectItemsAll(search);
    }
}