package com.weitao.service;

import com.weitao.bean.Category;
import com.weitao.bean.Items;
import com.weitao.bean.Store;
import com.weitao.vo.ItemsVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class ItemsServiceTest {
    @Test
    public void selectItemsAll() throws Exception {
        System.out.println(itemsService.selectItemsAll("机"));
    }

    @Test
    public void selectItems() throws Exception {
        ItemsVo itemsVo=new ItemsVo();
        Category category=new Category();
        category.setCaFather("鞋");
        //itemsVo.setiName("华");
        String caFather=category.getCaFather();
        String iName=itemsVo.getiName();
        System.out.println(caFather+"sssss");
   /*     List<Items> list=itemsMapper.selectItems(caFather);*/
        String type="i_price";
        System.out.println(itemsService.selectItems(caFather,"","",type));
    }

    @Test
    public void selectItemsDown() throws Exception {
        ItemsVo itemsVo=new ItemsVo();
        Category category=new Category();
        category.setCaFather("鞋");
        //itemsVo.setiName("华");
        String caFather=category.getCaFather();
        String iName=itemsVo.getiName();
        System.out.println(caFather+"sssss");
   /*     List<Items> list=itemsMapper.selectItems(caFather);*/
        String type="i_price";
        System.out.println(itemsService.selectItemsDown(caFather,"","",type));
    }

    @Autowired
    private ItemsService itemsService;
    @Autowired
    private StoreService storeService;
    @Autowired
    private CategoryService categoryService;
    @Test
    public void insertItems()throws Exception{
        Items items=new Items();
        items.setiName("yco2");
        items.setiIntroduction("ad");
        items.setiPrice(BigDecimal.valueOf(50));
        items.setiPhotos("aa");
        items.setiSale(123);
        items.setiExsit(20);
        items.setStoreId(1);
        items.setiStatus((byte) 3);
        items.setCatagoryId(101);
        itemsService.insertItems(items);
    }
    @Test
    public void seleteStore() throws Exception{
        Store store =new Store();
        store.setSellerId(1);
        store.setStStatus((byte) 0);
        List<Store> list=storeService.seleteStore(store);
        for(Store s:list)
            System.out.println(s.getStId());
    }
    /*查找类别父类*/
    @Test
    public void selectFather() throws  Exception{
        Category category=new Category();
        category.setCaFather("男鞋");
        String cafather=category.getCaFather();
        List<Category> list= categoryService.selectCafather(cafather);
        System.out.println(list);
    }
}
