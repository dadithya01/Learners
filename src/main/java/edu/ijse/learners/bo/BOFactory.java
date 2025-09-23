package edu.ijse.learners.bo;

import edu.ijse.learners.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){}

    public static BOFactory getInstance() {
        return (boFactory == null)?boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes{
        STUDENT,
        COURSE,
        INSTRUCTORS,
        LESSONS,
        PAYMENTS,
        USER,
        QUERY
    }

    public SuperBO getBO(BOTypes boTypes) {
        return switch (boTypes){
            case STUDENT ->  new StudentBOImpl();
            case USER -> new UserBOImpl();
            case COURSE -> new CourseBOImpl();
            case INSTRUCTORS -> new InstructorBOImpl();
            case LESSONS -> new LessonBOImpl();
            case PAYMENTS -> new PaymentBOImpl();
            case QUERY -> new QueryBOImpl();
            default -> null;
        };
    }
}
