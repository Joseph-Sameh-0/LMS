package com.lms.business.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lms.persistence.entities.AssignmentSubmissionEntity;
import com.lms.persistence.entities.QuizSubmission;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class StudentProgress {

  private String studentId;
  private Map<String, List<QuizSubmission>> quizSubmission = new HashMap<>();
  private Map<String, List<AssignmentSubmissionEntity>> assignmentSubmission = new HashMap<>();
  // private List<String> attendedLessonsIds = new ArrayList<>();
}
