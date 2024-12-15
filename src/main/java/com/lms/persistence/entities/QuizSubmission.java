package com.lms.persistence.entities;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class QuizSubmission {

  private String id;
  private String studentId;
  private String quizId;
  private Double score;
  private Double grade;
  private List<StudentAnswer> studentAnswers;

  public void setStudentAnswers(List<StudentAnswer> studentAnswers) {
    this.studentAnswers = studentAnswers;
    calcScore();
  }

  private void calcScore() {
    score = 0D;
    grade = 0D;
    for (StudentAnswer answer : studentAnswers) {
      if (answer.getStatus() == "correct") {
        score += answer.getQuestionGrade();
      }
      grade += answer.getQuestionGrade();
    }
  }
}
