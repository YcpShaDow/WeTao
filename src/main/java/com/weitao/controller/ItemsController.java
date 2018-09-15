package com.weitao.controller;

import com.weitao.bean.Category;
import com.weitao.bean.Items;
import com.weitao.bean.Store;
import com.weitao.exception.ResultEnum;
import com.weitao.service.CategoryService;
import com.weitao.service.ItemsService;
import com.weitao.service.StoreService;
import com.weitao.utils.Result;
import com.weitao.utils.ResultUtil;
import com.weitao.vo.ItemsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by ycp on 2018/9/5.
 */
@RestController
public class ItemsController {

    @Autowired
    private ItemsService itemsService;
    @Autowired
    private StoreService storeService;
    @Autowired
    private CategoryService categoryService;

    /*插入商品*/
    @RequestMapping(value = "/insertItems", method = RequestMethod.POST)
    public Result insertItems(Model model, HttpServletRequest request,
                              ItemsVo itemsVo, MultipartFile i_Photos) throws Exception {
        itemsVo.setiPhotos(i_Photos.getOriginalFilename());//获得图片的初始名字
        if(itemsService.insertItems(itemsVo))//返回值
            return ResultUtil.success();
        else
            return ResultUtil.error(ResultEnum.ITEMS_INSERT_FAIL);
    }

    @RequestMapping(value = "/success")
    public String insertItems() {
        return "success";//返回成功页面 //这不是json
    }

    /*下拉框显示卖家有多少店铺*/
    @RequestMapping(value = "/findStore")
    public List<Store> findStore(HttpServletRequest request,
                                         @RequestParam(value = "sellerId", defaultValue = "1") int sellerId,
                                         @RequestParam(value = "stStatus", defaultValue = "0") int stStatus) {
        Store store=new Store();
        store.setSellerId(sellerId);
        store.setStStatus((byte) stStatus);
        List<Store> stores=storeService.seleteStore(store);
        /*Map<String, List<Store>> map = new HashMap<String, List<Store>>(); //不要传Object  //是这里的问题，应该返回店铺集合，不是一个一个放进去
        map.put("stores",stores);*/
        System.out.println("==数据长度；====="+stores.size()+"   数据;   "+stores);
        return  stores;
    }

    /*下拉框显示父类下有多少子类*/
    @RequestMapping(value = "findCafather")
    public List<Category> findCafather(HttpServletRequest request, String cafather){
        cafather=request.getParameter("cafather");
        System.out.println(cafather);
        List<Category> categories=categoryService.selectCafather(cafather);
     /*   System.out.println(categories);*/
        return categories;
    }

    /*加载图片*/
    @RequestMapping(value = "upFile")
    public String upFile(MultipartFile i_Photos, HttpSession session) throws IOException {
        System.out.println("==6==============6");
        //获取上传的文件名
        String originalFilename = i_Photos.getOriginalFilename();
        /* 存储文件路径*/
        String path = "E:\\ideaa\\WeTao\\src\\main\\webapp\\static\\images\\";
        String root_path = session.getServletContext().getRealPath("images");// 获取自定义缓存文件夹路径
        File file=new File(root_path);
        /*如果文件夹不存在，则创建*/
        if(!file.exists()){
            file.mkdir();
        }
        /*构建图片url路径，显示图片需要*/
        String url_root=session.getServletContext().getContextPath();
        String file_url = url_root + "/images/" + originalFilename;
            /* 将图片写入 */
            try {
                File file1=new File(path,i_Photos.getOriginalFilename());
                i_Photos.transferTo(file1);
            }catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        System.out.println(originalFilename+"8888");
        return file_url;
    }
/*根据各种条件查询商品（条件默认为空，即查询所有商品）
* caFather:根据父类查询，caName:根据子类查询
* iName:根据商品名字查询：type:默认为以i_id升序
* */
@RequestMapping(value = "queryItems")
    public Result queryItems(HttpServletRequest request,@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date iDate,
                                    @RequestParam(value = "caFather", defaultValue = "") String caFather,
                                    @RequestParam(value = "iName", defaultValue = "")   String iName,
                                    @RequestParam(value = "caName", defaultValue = "")  String caName ,
                                    @RequestParam(value = "type", defaultValue = "i_id")  String type) throws Exception{
    System.out.println(type);
    List<ItemsVo> itemsVos=itemsService.selectItems(caFather,iName,caName,type);

    return ResultUtil.success(itemsVos);
    }

}