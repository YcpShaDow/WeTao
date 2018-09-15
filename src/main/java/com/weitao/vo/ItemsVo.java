package com.weitao.vo;

import com.weitao.bean.Category;
import com.weitao.bean.Items;

/**
 *
 */

public class ItemsVo extends Items{

    private Items items;

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    /*添加类别表关联*/
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ItemsVo{" +
                "category=" + category +
                "} " + super.toString();
    }
}
