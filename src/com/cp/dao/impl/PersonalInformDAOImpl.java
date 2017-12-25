package com.cp.dao.impl;

import com.cp.dao.PersonalInformDAO;

import com.cp.model.PersonalInform;
import com.cp.utils.JDBCUtil;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 徐鹏 on 2017/12/19.
 */
public class PersonalInformDAOImpl implements PersonalInformDAO{
    private JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();

    //查询
    @Override
    public List<PersonalInform> getPI(String receiverNumber) throws SQLException {
        String sql = "SELECT * FROM t_personal_inform WHERE receiverNumber = ? ";
        List<Object> list = jdbcUtil.excuteQuery(sql, new Object[]{receiverNumber});
        return getPIList(list);

    }

    //新增
    @Override
    public int insertPI(PersonalInform personalInform) throws SQLException {

        String sql = "INSERT INTO t_personal_inform(receiverNumber,senderNumber,informContent,sendDate) VALUES (?,?,?,?) ";
        Object[] params = {personalInform.getReceiverNumber(),personalInform.getSenderNumber(),personalInform.getInformContent(),
        personalInform.getSendDate()};
        int n = jdbcUtil.executeUpdate(sql, params);
        return n;
    }

    //删除
    @Override
    public int deletePI(String receiverNumber) throws SQLException {
        String sql = "DELETE FROM t_personal_inform WHERE receiverNumber = ? ";
        Object[] params = {receiverNumber};
        int n = jdbcUtil.executeUpdate(sql, params);
        return n;
    }

    //查询所有个人信息
    @Override
    public List<PersonalInform> getAllPI() throws SQLException {
        String sql = "SELECT * FROM t_personal_inform ";
        List<Object> list = jdbcUtil.excuteQuery(sql, null);
        return getAllPIList(list);
    }
    //查询所有
    private List<PersonalInform> getAllPIList(List<Object> list) {
        List<PersonalInform> personalInformList = new ArrayList<>();
        for (Object object : list) {
            Map<String, Object> map = (Map<String, Object>) object;
            PersonalInform personalInform = new PersonalInform(map.get("receiverNumber").toString(), map.get("senderNumber").toString(),
                    map.get("informContent").toString(), (Date) map.get("sendDate"),map.get("isRead").toString());

            //给id设置值
            personalInform.setId((Integer) map.get("id"));
            personalInformList.add(personalInform);

        }
        return personalInformList;
    }

//    @Override
//    public int updatePI(PersonalInform personalInform) throws SQLException {
//        int n;
//        String sql = "UPDATE t_student SET password = ? WHERE studentid = ? ";
//        Object[] params = {personalInform};
//        n = jdbcUtil.executeUpdate(sql,params);
//        return n;
//    }


    //查询
    private List<PersonalInform>getPIList(List<Object> list) {
        List<PersonalInform>  personalInformList = new ArrayList<>();
        for (Object object : list) {
            Map<String, Object> map = (Map<String, Object>) object;
            PersonalInform personalInform = new PersonalInform(map.get("receiverNumber").toString(), map.get("senderNumber").toString(),
                    map.get("informContent").toString(), (Date) map.get("sendDate"),map.get("isRead").toString());
            //给id设置值
//            allInform.setId((Integer) map.get("id"));
//            allInformList.add(allInform);
            personalInform.setId((Integer) map.get("id"));
            personalInformList.add(personalInform);

        }
        return personalInformList;



    }
}