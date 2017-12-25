package com.cp.dao.impl;

import com.cp.dao.StaffDAO;
import com.cp.model.Staff;
import com.cp.utils.JDBCUtil;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 徐鹏 on 2017/12/22.
 */
public class StaffDAOImpl implements StaffDAO {
    private JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();


    @Override
    public Staff get(String staffNumber) throws SQLException {
        String sql = "SELECT * FROM t_staff WHERE staffNumber = ? ";
        Map<String, Object> map = jdbcUtil.executeQuerySingle(sql, new Object[]{staffNumber});
        if (map.size() != 0) {
            Staff staff = new Staff(map.get("staffNumber").toString(), map.get("staffName").toString(),
                    map.get("staffAge").toString(),map.get("staffSex").toString(),map.get("deptNumber").toString()
                    ,map.get("staffPost").toString(),map.get("staffPlace").toString(),map.get("staffMarriage").toString(),
                    map.get("staffPhone").toString(),map.get("staffMailbox").toString(),(byte[]) map.get("staffPicture"),
                    (Date)map.get("staffEntrytime"));
            return staff;
        } else {
            return null;
        }
    }

    @Override
    public List<Staff> getAll(String staffNumber) throws SQLException {
        String sql = "SELECT * FROM t_staff WHERE staffNumber NOT IN(?) ";
        List<Object> list = jdbcUtil.excuteQuery(sql,new Object[]{staffNumber});
        List<Staff> staffList = new ArrayList<>();
        for (Object object : list){
            Map<String, Object> map = (Map<String, Object>) object;
            Staff staff = new Staff(map.get("staffNumber").toString(), map.get("staffName").toString(),
                    map.get("staffAge").toString(),map.get("staffSex").toString(),map.get("deptNumber").toString()
                    ,map.get("staffPost").toString(),map.get("staffPlace").toString(),map.get("staffMarriage").toString(),
                    map.get("staffPhone").toString(),map.get("staffMailbox").toString(),(byte[]) map.get("staffPicture"),
                    (Date)map.get("staffEntrytime"));
            staffList.add(staff);
        }
        return staffList;
    }
}