package edu.ijse.learners.dao.custom;

import edu.ijse.learners.dao.SuperDAO;

public interface QueryDAO extends SuperDAO {
    public int getStudentCountForLesson(String lessonId);
}
