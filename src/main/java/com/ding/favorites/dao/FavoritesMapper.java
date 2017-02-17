package com.ding.favorites.dao;

import com.ding.favorites.domain.Favorites;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritesMapper {


    /**
     * 根据主键删除
     *
     * @param id 主键值
     */
    int deleteByPrimaryKey(String id);

    /**
     * 新增记录
     *
     * @param record 待新增的对象
     */
    int insert(Favorites record);

    /**
     * 新增记录 <font color='blue'>（该操作为选择性的，只对record中不为空的属性生成sql语句）</font>
     *
     * @param record 待新增的对象
     */
    int insertSelective(Favorites record);

    /**
     * 根据主键查询
     *
     * @param id 主键值
     */
    Favorites selectByPrimaryKey(String id);


    /**
     * 根据主键更新记录 <font color='blue'>（该操作为选择性的，只对record中不为空的属性生成sql语句）</font>
     *
     * @param record 记录
     */
    int updateByPrimaryKeySelective(Favorites record);

    /**
     * 根据主键更新记录
     *
     * @param record 记录
     */
    int updateByPrimaryKey(Favorites record);
}