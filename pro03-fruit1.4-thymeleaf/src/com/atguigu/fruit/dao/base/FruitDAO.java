package com.atguigu.fruit.dao.base;

import com.atguigu.fruit.pojo.Fruit;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-03-13 16:51
 */
public interface FruitDAO {
    //获取所有的库存列表信息
    List<Fruit> getFruitList();
}
