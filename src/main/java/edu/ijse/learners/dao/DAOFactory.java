package edu.ijse.learners.dao;

import edu.ijse.learners.dao.custom.impl.StudentDAOImpl;

public class DAOFactory {
    private static DAOFactory DAOFactory;
    private DAOFactory() {}
    public static DAOFactory getInstance() {
        return DAOFactory == null ? DAOFactory = new DAOFactory() : DAOFactory;
    }
    public enum DAOTypes {
        STUDENT
    }

    public SuperDAO getDAO(DAOTypes daoTypes) {
        return switch (daoTypes) {
            case STUDENT -> new StudentDAOImpl();
        };
    }
}
