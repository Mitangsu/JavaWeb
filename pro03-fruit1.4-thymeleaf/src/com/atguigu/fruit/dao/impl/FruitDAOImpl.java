package com.atguigu.fruit.dao.impl;

import com.atguigu.fruit.dao.base.FruitDAO;
import com.atguigu.fruit.dao.base.BaseDAO;
import com.atguigu.fruit.pojo.Fruit;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-03-13 16:52
 */
public class FruitDAOImpl extends BaseDAO<Fruit> implements FruitDAO{


    @Override
    public List<Fruit> getFruitList() {
        return super.executeQuery("select * from t_fruit");
    }
}
