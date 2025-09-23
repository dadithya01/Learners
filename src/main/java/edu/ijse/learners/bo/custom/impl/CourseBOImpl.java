package edu.ijse.learners.bo.custom.impl;

import edu.ijse.learners.bo.custom.CourseBO;
import edu.ijse.learners.bo.util.EntityToDTO;
import edu.ijse.learners.dao.DAOFactory;
import edu.ijse.learners.dao.custom.CourseDAO;
import edu.ijse.learners.dto.CourseDTO;
import edu.ijse.learners.entity.Course;
import edu.ijse.learners.exception.DuplicateException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseBOImpl implements CourseBO {

    private final CourseDAO courseDAO = (CourseDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.COURSE);
    private final EntityToDTO entityToDTO = new EntityToDTO();

    @Override
    public List<CourseDTO> getAllCourses() throws Exception {
        List<Course> courses = courseDAO.getAll();
        List<CourseDTO> dtos = new ArrayList<>();
        for (Course course : courses) {
            dtos.add(entityToDTO.getCourseDTO(course));
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
        return courseDAO.save(entityToDTO.getCourseEntity(t));
    }

    @Override
    public boolean updateCourses(CourseDTO t) throws Exception {
        Optional<Course> course = courseDAO.findById(t.getCourseId());
        if (course.isEmpty()) {
            throw new DuplicateException("Course not Found");
        }
        return courseDAO.update(entityToDTO.getCourseEntity(t));
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
            return Optional.of(entityToDTO.getCourseDTO(course.get()));
        }
        return Optional.empty();
    }

    @Override
    public String generateNewCourseId() {
        return courseDAO.generateNewId();
    }
}
