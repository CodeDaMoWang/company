package com.cp.dao;

import com.cp.model.AllInform;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by 徐鹏 on 2017/12/19.
 */
public interface AllInformDAO {

    /**
     * 查询所有通知信息
     * @return
     * @throws SQLException
     */
    List<AllInform> getAll() throws SQLException;

    /**
     * 新增全体通知
     * @param allInform
     * @return
     * @throws SQLException
     */

    int insertAll(AllInform allInform) throws SQLException;


    /**
     * 删除
     * @param id
     * @param senderNumber
     * @return
     * @throws SQLException
     */
    int deleteAll(int id , String senderNumber) throws SQLException;



}