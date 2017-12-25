package com.cp.dao;

import com.cp.factory.DAOFactory;
import com.cp.model.PersonalInform;
import org.junit.Before;
import org.junit.Test;

import javax.naming.ldap.PagedResultsControl;


import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 徐鹏 on 2017/12/19.
 */
public class PersonalInformDAOTest {
    private PersonalInformDAO personalInformDAO;

    @Before
    public void setUp() throws Exception {
        personalInformDAO = DAOFactory.getPersonalInformDAO();
    }

    @Test
    public void getPI() throws SQLException {
        List<PersonalInform> list = personalInformDAO.getPI("20012");
        list.forEach(personalInform -> System.out.println(personalInform));

    }
    @Test
    public void insertPI() throws SQLException {

        java.util.Date date = new Date();
        PersonalInform personalInform = new PersonalInform("20016","20010","20010",
                new java.sql.Date(date.getTime()));
        int n = personalInformDAO.insertPI(personalInform);
        assertEquals(1, n);
    }

    @Test
    public void deletePI() throws SQLException {
        int n = personalInformDAO.deletePI("20016");
        assertEquals(1, n);

    }

    @Test
    public void getAllPI() throws SQLException {
        List<PersonalInform> list = personalInformDAO.getAllPI();
        list.forEach(PersonalInform -> System.out.println(PersonalInform));
    }
}