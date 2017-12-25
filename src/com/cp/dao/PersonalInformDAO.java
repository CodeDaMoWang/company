package com.cp.dao;

import com.cp.model.PersonalInform;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by 徐鹏 on 2017/12/19.
 */
public interface PersonalInformDAO {

    /**
     * 查询个人通知
     * @param receiverNumber
     * @return
     * @throws SQLException
     */
    List<PersonalInform> getPI(String receiverNumber)throws SQLException;

//    /**
//     *修改个人通知
//     * @param personalInform
//     * @return
//     * @throws SQLException
//     */
//
////    int updatePI(PersonalInform personalInform) throws SQLException;

    /**
     * 新增
     * @param personalInform
     * @return
     * @throws SQLException
     */

    int insertPI(PersonalInform personalInform) throws SQLException;


    /**
     * 删除个人
     * @param receiverNumber
     * @return
     * @throws SQLException
     */
    int deletePI(String receiverNumber) throws SQLException;


    /**
     * 查询所有个人信息
     * @return
     * @throws SQLException
     */
    List<PersonalInform> getAllPI() throws SQLException;
}