package edu.ijse.learners.bo.custom.impl;

import edu.ijse.learners.bo.custom.CourseBO;
import edu.ijse.learners.bo.exception.DuplicateException;
import edu.ijse.learners.bo.util.EntityDTOConverter;
import edu.ijse.learners.dao.DAOFactory;
import edu.ijse.learners.dao.DAOTypes;
import edu.ijse.learners.dao.custom.CourseDAO;
import edu.ijse.learners.dto.CourseDTO;
import edu.ijse.learners.entity.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseBOImpl implements CourseBO {

    private final CourseDAO courseDAO = (CourseDAO) DAOFactory.getInstance().getDAO(DAOTypes.COURSE);
    private final EntityDTOConverter entityDTOConverter = new EntityDTOConverter();

    @Override
    public List<CourseDTO> getAllCourses() throws Exception {
        List<Course> courses = courseDAO.getAll();
        List<CourseDTO> dtos = new ArrayList<>();
        for (Course course : courses) {
            dtos.add(entityDTOConverter.getCourseDTO(course));
        }
        return dtos;
    }

    @Override
    public String getLastCourseId() throws Exception {
        return courseDAO.getLastId();
    }

    @Override
    public boolean saveCourses(CourseDTO t) throws Exception {
        Optional<Course> course = courseDAO.findById(t.getCourseId());
        if (course.isPresent()) {
            throw new DuplicateException("Course already exists");
        }
        return courseDAO.save(entityDTOConverter.getCourseEntity(t));
    }

    @Override
    public boolean updateCourses(CourseDTO t) throws Exception {
        Optional<Course> course = courseDAO.findById(t.getCourseId());
        if (course.isEmpty()) {
            throw new DuplicateException("Course not Found");
        }
        return courseDAO.update(entityDTOConverter.getCourseEntity(t));
    }

    @Override
    public boolean deleteCourses(String id) throws Exception {
        Optional<Course> course = courseDAO.findById(id);
        if (course.isEmpty()) {
            throw new DuplicateException("Course not Found");
        }
        return courseDAO.delete(id);
    }

    @Override
    public List<String> getAllCourseIds() throws Exception {
        return courseDAO.getAllIds();
    }

    @Override
    public Optional<CourseDTO> findByCourseId(String id) throws Exception {
        Optional<Course> course = courseDAO.findById(id);
        if (course.isPresent()) {
           return Optional.of(entityDTOConverter.getCourseDTO(course.get()));
        }
        return Optional.empty();
    }

    @Override
    public String generateNewCourseId() {
        return courseDAO.generateNewId();
    }
}
