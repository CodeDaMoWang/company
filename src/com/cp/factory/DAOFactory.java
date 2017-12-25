package com.cp.factory;

import com.cp.dao.AllInformDAO;
import com.cp.dao.PersonalInformDAO;
import com.cp.dao.StaffDAO;
import com.cp.dao.impl.AllInformDAOImpl;
import com.cp.dao.impl.PersonalInformDAOImpl;
import com.cp.dao.impl.StaffDAOImpl;

/**
 * Created by 徐鹏 on 2017/12/19.
 */
public class DAOFactory {
    public static AllInformDAO getAllInformDAO(){
        return new AllInformDAOImpl();
    }


    public static PersonalInformDAO getPersonalInformDAO(){
        return new PersonalInformDAOImpl();
    }

    public static StaffDAO getStaffDAO(){
        return new StaffDAOImpl();
    }
}