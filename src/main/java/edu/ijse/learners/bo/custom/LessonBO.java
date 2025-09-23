package edu.ijse.learners.bo.custom;

import edu.ijse.learners.bo.SuperBO;
import edu.ijse.learners.dto.LessonDTO;

import java.util.List;
import java.util.Optional;

public interface LessonBO extends SuperBO {
    List<LessonDTO> getAllLessons() throws Exception;

    String getLastLessonId() throws Exception;

    boolean saveLessons(LessonDTO t) throws Exception;

    boolean updateLessons(LessonDTO t) throws Exception;

    boolean deleteLessons(String id) throws Exception;

    List<String> getAllLessonIds() throws Exception;

    Optional<LessonDTO> findByLessonId(String id) throws Exception;
}
