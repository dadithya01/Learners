package edu.ijse.learners.dao;

import edu.ijse.learners.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory DAOFactory;
    private DAOFactory() {}
    public static DAOFactory getInstance() {
        return DAOFactory == null ? DAOFactory = new DAOFactory() : DAOFactory;
    }
    public enum DAOTypes {
        COURSE,
        INSTRUCTORS,
        LESSONS,
        PAYMENTS,
        STUDENT,
        USER,
        QUERY
    }

    public SuperDAO getDAO(DAOTypes daoTypes) {
        return switch (daoTypes) {
            case STUDENT -> new StudentDAOImpl();
            case COURSE -> new CourseDAOImpl();
            case INSTRUCTORS -> new InstructorDAOImpl();
            case LESSONS -> new LessonDAOImpl();
            case PAYMENTS -> new PaymentDAOImpl();
            case USER -> new UserDAOImpl();
            case QUERY -> new QueryDAOImpl();
            default -> null;
        };
    }
}
