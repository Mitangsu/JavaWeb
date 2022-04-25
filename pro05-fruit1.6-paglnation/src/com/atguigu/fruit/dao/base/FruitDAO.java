package com.atguigu.fruit.dao.base;

import com.atguigu.fruit.pojo.Fruit;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-03-13 16:51
 */
public interface FruitDAO {
    //获取指定页码上的的库存列表信息,每页显示5条
    List<Fruit> getFruitList(Integer pageNo);

    //根据fid获取特定的水果库存信息
    Fruit getFruitByFid(Integer fid);

    //修改指定的库存记录
    void updateFruit(Fruit fruit);

    //根据fid删除指定的库存记录
    void delFruit(Integer fid);

    //添加新的库存记录
    void addFruit(Fruit fruit);

    //查询库存总结路条数
    int getFruitCount();

}
