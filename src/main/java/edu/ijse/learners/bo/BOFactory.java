package edu.ijse.learners.bo;

import edu.ijse.learners.bo.custom.impl.CourseBOImpl;
import edu.ijse.learners.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {}

    public static BOFactory getInstance() {
        return boFactory == null ? (boFactory = new BOFactory()) : boFactory;
    }

    @SuppressWarnings("unchecked")
    public <Hello extends SuperBO> Hello getBO(BOTypes boType) {
        return switch (boType) {
            case COURSE ->  (Hello) new CourseBOImpl();
            case  INSTRUCTOR -> (Hello) new InstructorBOImpl();
            case  LESSONS -> (Hello) new LessonsBOImpl();
            case PAYMENTS ->  (Hello) new PaymentsBOImpl();
            case QUERY ->   (Hello) new QueryBOImpl();
            case STUDENT -> (Hello) new StudentBOImpl();
            case USER -> (Hello) new UserBOImpl();

        };
    }
}
