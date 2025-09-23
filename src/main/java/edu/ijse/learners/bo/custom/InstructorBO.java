package edu.ijse.learners.bo.custom;

import edu.ijse.learners.bo.SuperBO;
import edu.ijse.learners.dto.InstructorDTO;

import java.util.List;
import java.util.Optional;

public interface InstructorBO extends SuperBO {
    List<InstructorDTO> getAllInstructors() throws Exception;

    String getLastInstructorId() throws Exception;

    boolean saveInstructors(InstructorDTO t) throws Exception;

    boolean updateInstructors(InstructorDTO t) throws Exception;

    boolean deleteInstructors(String id) throws Exception;

    List<String> getAllInstructorIds() throws Exception;

    Optional<InstructorDTO> findByInstructorId(String id) throws Exception;

    String generateNewInstructorsId();
}
