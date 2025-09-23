package edu.ijse.learners.bo.custom.impl;

import edu.ijse.learners.bo.custom.InstructorBO;
import edu.ijse.learners.bo.util.EntityToDTO;
import edu.ijse.learners.dao.DAOFactory;
import edu.ijse.learners.dao.custom.InstructorDAO;
import edu.ijse.learners.dto.InstructorDTO;
import edu.ijse.learners.entity.Instructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InstructorBOImpl implements InstructorBO {

    private final InstructorDAO instructorDAO = (InstructorDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.INSTRUCTORS);
    private final EntityToDTO entityToDTO = new EntityToDTO();

    @Override
    public List<InstructorDTO> getAllInstructors() throws Exception {
        List<Instructor> instructors = instructorDAO.getAll();
        List<InstructorDTO> instructorDTOs = new ArrayList<>();
        for (Instructor instructor : instructors) {
            instructorDTOs.add(entityToDTO.getInstructorsDTO(instructor));
        }
        return instructorDTOs;
    }

    @Override
    public String getLastInstructorId() throws Exception {
        return instructorDAO.getLastId();
    }

    @Override
    public boolean saveInstructors(InstructorDTO t) throws Exception {
        Optional<Instructor> instructors = instructorDAO.findById(t.getInstructorId());
        if (instructors.isPresent()) {
            throw new Exception("Instructor already exists");
        }
        return instructorDAO.save(entityToDTO.getInstructorsEntity(t));
    }

    @Override
    public boolean updateInstructors(InstructorDTO t) throws Exception {
        Optional<Instructor> instructors = instructorDAO.findById(t.getInstructorId());
        if (instructors.isEmpty()) {
            throw new Exception("Instructor Not Found");
        }
        return instructorDAO.update(entityToDTO.getInstructorsEntity(t));
    }

    @Override
    public boolean deleteInstructors(String id) throws Exception {
        Optional<Instructor> instructors = instructorDAO.findById(id);
        if (instructors.isEmpty()) {
            throw new Exception("Instructor not Found");
        }
        return instructorDAO.delete(id);
    }

    @Override
    public List<String> getAllInstructorIds() throws Exception {
        return instructorDAO.getAllIds();
    }

    @Override
    public Optional<InstructorDTO> findByInstructorId(String id) throws Exception {
        Optional<Instructor> instructors = instructorDAO.findById(id);
        if (instructors.isPresent()) {
            return Optional.of(entityToDTO.getInstructorsDTO(instructors.get()));
        }
        return Optional.empty();
    }

    @Override
    public String generateNewInstructorsId() {
        return instructorDAO.generateNewId();
    }
}
