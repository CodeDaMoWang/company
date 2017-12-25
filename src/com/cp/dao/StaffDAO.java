package com.cp.dao;

import com.cp.model.Staff;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by 徐鹏 on 2017/12/22.
 */
public interface StaffDAO {

    /**
     * 根据工号查找员工
     * @param staffNumber
     * @return
     * @throws SQLException
     */

    Staff get(String staffNumber)throws SQLException;

    List<Staff> getAll(String staffNumber) throws SQLException;
}