package com.cp.dao.impl;

import com.cp.dao.AllInformDAO;
import com.cp.model.AllInform;
import com.cp.utils.JDBCUtil;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 徐鹏 on 2017/12/19.
 */
public class AllInformDAOImpl implements AllInformDAO {
    private JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();

    //查询
    @Override
    public List<AllInform> getAll() throws SQLException {
        String sql = "SELECT * FROM t_all_inform ";
        List<Object> list = jdbcUtil.excuteQuery(sql, null);
        return getAllInformList(list);

    }

    //新增
    @Override
    public int insertAll(AllInform allInform) throws SQLException {
        String sql = "INSERT INTO t_all_inform VALUES (null,?,?,?,?) ";
        Object[] params = {allInform.getSenderNumber(),allInform.getInformTitle(),allInform.getInformContent(),allInform.getSendDate()};
        int n = jdbcUtil.executeUpdate(sql, params);
        return n;
    }

    //删除
    @Override
    public int deleteAll(int id, String senderNumber) throws SQLException {
        String sql = "DELETE FROM t_all_inform WHERE id = ? AND senderNumber = ? ";
        Object[] params = {id,senderNumber};
        int n = jdbcUtil.executeUpdate(sql, params);
        return n;
    }


    //查询
    //(Integer) map.get("id"),
    private List<AllInform> getAllInformList(List<Object> list) {
        List<AllInform> allInformList = new ArrayList<>();
        for (Object object : list) {
            Map<String, Object> map = (Map<String, Object>) object;
            AllInform allInform = new AllInform(map.get("senderNumber").toString(), map.get("informTitle").toString(),
                    map.get("informContent").toString(), (Date) map.get("sendDate"));
            //给id设置值
            allInform.setId((Integer) map.get("id"));
            allInformList.add(allInform);

        }
        return allInformList;
    }
}


