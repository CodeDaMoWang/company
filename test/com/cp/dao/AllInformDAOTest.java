package com.cp.dao;

import com.cp.factory.DAOFactory;
import com.cp.model.AllInform;
import com.cp.model.PersonalInform;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 徐鹏 on 2017/12/19.
 */
public class AllInformDAOTest {
    private AllInformDAO allInformDAO;
    @Before
    public void setUp() throws Exception {
        allInformDAO = DAOFactory.getAllInformDAO();
    }

    @Test
    public void getAll() throws SQLException {
        List<AllInform> list = allInformDAO.getAll();
        list.forEach(AllInform -> System.out.println(AllInform));
    }

    @Test
    public void insertAll() throws SQLException {
        java.util.Date date = new Date();

        AllInform allInform = new AllInform("20018","oooo","uyueyueyrueye",
                new java.sql.Date(date.getTime()));
        int n = allInformDAO.insertAll(allInform);
        assertEquals(1,n);
    }

    @Test
    public void deleteAll() throws SQLException {
        int n = allInformDAO.deleteAll(5,"20018");
        assertEquals(1, n);
    }
}