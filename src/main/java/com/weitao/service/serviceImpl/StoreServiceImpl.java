package com.weitao.service.serviceImpl;

import com.weitao.bean.Store;
import com.weitao.dao.StoreMapper;
import com.weitao.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ycp on 2018/9/4.
 */
@Service
public class StoreServiceImpl implements StoreService{
    @Autowired
    private StoreMapper storeMapper;

    @Override
    public List<Store> seleteStore(Store store) {
        return storeMapper.seleteStore(store);
    }
}
