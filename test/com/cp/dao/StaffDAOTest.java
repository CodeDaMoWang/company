package com.cp.dao;

import com.cp.factory.DAOFactory;
import com.cp.model.Staff;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 徐鹏 on 2017/12/22.
 */
public class StaffDAOTest {
    private StaffDAO staffDAO;

    @Before
    public void setUp() throws Exception {
        staffDAO = DAOFactory.getStaffDAO();
    }

    @Test
    public void get() throws SQLException {
        Staff staff = staffDAO.get("20010");
        System.out.println(staff);
    }

    @Test
    public void getAll() throws SQLException {
        List<Staff> list = staffDAO.getAll("20010");
        list.forEach(staff -> System.out.println(staff));
    }
}