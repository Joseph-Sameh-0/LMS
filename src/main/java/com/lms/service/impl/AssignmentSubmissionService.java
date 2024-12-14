package com.lms.service.impl;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.lms.persistence.entities.AssignmentSubmissionEntity;
import com.lms.persistence.repositories.AssignmentRepository;
import com.lms.persistence.repositories.AssignmentSubmissionRepository;
import com.lms.business.models.AssignmentSubmissionModel;

@Service
public class AssignmentSubmissionService {
    private final AssignmentSubmissionRepository submissionRepos;
    private final AssignmentRepository assrepos;
    public AssignmentSubmissionService(AssignmentSubmissionRepository repository , AssignmentRepository assrepos) {
        this.submissionRepos = repository;
        this.assrepos = assrepos;
    }

    public boolean submitAssignment(AssignmentSubmissionModel model, int assignmentId, int studentId) {
        if (assrepos.isExist(assignmentId) ){
        AssignmentSubmissionEntity entity = new AssignmentSubmissionEntity();
        entity.setStudentId(studentId);
        entity.setFileURL(model.getFileUrl()); 
        entity.setRelatedId(assignmentId);
        entity.setStatus("Pending");
        return submissionRepos.add(entity);
    }
    else 
    return false;
}

    
    public List<AssignmentSubmissionEntity> getSubmissionsByAssignment(int assignmentId) {
        return submissionRepos.findAll().stream()
                .filter(s -> s.getRelatedId() == assignmentId)
                .collect(Collectors.toList());
    }

    
    public boolean updateSubmission(int submissionId, AssignmentSubmissionModel updatedModel) {
        AssignmentSubmissionEntity entity = submissionRepos.findById(submissionId);
        if (entity != null) {
            entity.setScore(Integer.parseInt(updatedModel.getScore()));
            entity.setFileURL(updatedModel.getFileUrl());
            entity.setFeedback(updatedModel.getFeedBack());
            return submissionRepos.update(entity);
        }
        return false;
    }

}
