package com.lms.persistence.repositories;

import com.lms.persistence.entities.QuizSubmission;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class QuizSubmissionRepository {

  private List<QuizSubmission> submissions = new ArrayList<>();

  public void save(QuizSubmission submission) {
    submissions.add(submission);
  }

  public List<QuizSubmission> findByStudentId(String studentId) {
    return submissions
      .stream()
      .filter(submission -> submission.getStudentId().equals(studentId))
      .collect(Collectors.toList());
  }

  public List<QuizSubmission> findAll() {
    return new ArrayList<>(submissions);
  }

  public List<QuizSubmission> findByQuizId(String quizId) {
    return submissions
      .stream()
      .filter(submission -> submission.getQuizId().equals(quizId))
      .collect(Collectors.toList());
  }
}
