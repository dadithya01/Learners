package edu.ijse.learners.bo.custom.impl;

import edu.ijse.learners.bo.custom.LessonBO;
import edu.ijse.learners.bo.util.EntityToDTO;
import edu.ijse.learners.dao.DAOFactory;
import edu.ijse.learners.dao.custom.CourseDAO;
import edu.ijse.learners.dao.custom.InstructorDAO;
import edu.ijse.learners.dao.custom.LessonsDAO;
import edu.ijse.learners.dao.custom.QueryDAO;
import edu.ijse.learners.dto.LessonDTO;
import edu.ijse.learners.entity.Lesson;
import edu.ijse.learners.exception.DuplicateException;
import edu.ijse.learners.exception.NotFoundException;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LessonBOImpl implements LessonBO {

    private final LessonsDAO lessonsDAO = (LessonsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.LESSONS);
    private final CourseDAO courseDAO = (CourseDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.COURSE);
    private final InstructorDAO instructorDAO =  (InstructorDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.INSTRUCTORS);
    private final QueryDAO queryDAO = (QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);
    private final EntityToDTO entityToDTO = new EntityToDTO();

    @Override
    public List<LessonDTO> getAllLessons() throws Exception {
        List<Lesson> lessons = lessonsDAO.getAll();
        List<LessonDTO> lessonsDTOS = new ArrayList<>();
        for (Lesson lesson : lessons) {
            lessonsDTOS.add(entityToDTO.getLessonsDTO(lesson));
        }
        return lessonsDTOS;
    }

    @Override
    public String getLastLessonId() throws Exception {
        return lessonsDAO.getLastId();
    }

    @Override
    public boolean saveLessons(LessonDTO t) throws Exception {
        boolean courseExists = courseDAO.findById(t.getCourseId()).isPresent();
        boolean instructorExists = instructorDAO.findById(t.getCourseId()).isPresent();

        if (courseExists && instructorExists) {
            return lessonsDAO.save(entityToDTO.getLessonsEntity(t));
        }
        throw new Exception("Lessons not saved");
    }

    @Override
    public boolean updateLessons(LessonDTO t) throws Exception {
        Optional<Lesson> lessons = lessonsDAO.findById(t.getLessonId());
        if (lessons.isEmpty()) {
            throw new DuplicateException("Lessons Not Found");
        }
        return lessonsDAO.update(entityToDTO.getLessonsEntity(t));
    }

    @Override
    public boolean deleteLessons(String id) throws Exception {
        Optional<Lesson> lesson = lessonsDAO.findById(id);
        if (lesson.isEmpty()) {
            throw new NotFoundException("Lesson not found");
        }

        int studentsEnrolled = queryDAO.getStudentCountForLesson(id);
        if (studentsEnrolled > 0) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                    "Students are enrolled in this lesson. Are you sure you want to delete?",
                    ButtonType.YES,
                    ButtonType.NO);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);

            ButtonType result = alert.showAndWait().orElse(ButtonType.NO);
            if (result != ButtonType.YES) {
                return false;
            }
        }

        return lessonsDAO.delete(id);
    }

    @Override
    public List<String> getAllLessonIds() throws Exception {
        return lessonsDAO.getAllIds();
    }

    @Override
    public Optional<LessonDTO> findByLessonId(String id) throws Exception {
        Optional<Lesson> lessons = lessonsDAO.findById(id);
        if (lessons.isPresent()) {
            return Optional.of(entityToDTO.getLessonsDTO(lessons.get()));
        }
        return Optional.empty();
    }
}
