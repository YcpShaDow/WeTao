package com.weitao.dao;

import com.weitao.bean.Category;
import com.weitao.bean.Items;
import com.weitao.vo.ItemsVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ycp on 2018/9/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ItemsMapperTest {
    @Test
    public void selectItemsAll() throws Exception {
        String search="鞋";
        List<ItemsVo> list=itemsMapper.selectItemsAll(search);
        System.out.println(list);
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        Items items=new Items();
        System.out.println(itemsMapper.selectByPrimaryKey(8000002));
    }

    @Autowired
    ItemsMapper itemsMapper;
    @Autowired
    CategoryMapper categoryMapper;
    @Test
    public void insert() throws Exception {
        Items items=new Items();
        items.setiName("ycp");
        items.setiIntroduction("ad");
        items.setiPrice(BigDecimal.valueOf(50.000));
        items.setiPhotos("aa");
        items.setiSale(12);
        items.setiExsit(20);
        items.setStoreId(1);
        items.setiStatus((byte) 3);
        items.setCatagoryId(101);
        items.getiDate();
        itemsMapper.insert(items);
    }

    @Test
    public void selectItems() throws Exception {
        Items items=new Items();
        ItemsVo itemsVo=new ItemsVo();
        Category category=new Category();
        category.setCaFather("鞋");
        //itemsVo.setiName("华");
        String caFather=category.getCaFather();;
   /*     List<Items> list=itemsMapper.selectItems(caFather);*/
        String type="i_id";
        List<ItemsVo> itemVos=itemsMapper.selectItemsDown(caFather,"","",type);
        System.out.println(itemVos);
     /*   for(int i=0;i<itemVos.size();i++)
        System.out.println(itemsVo.getiIntroduction());*/
    }
}