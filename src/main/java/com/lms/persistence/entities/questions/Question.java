package com.lms.persistence.entities.questions;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public abstract class Question {
  private String id;
  private String type;
  private String questionText;
  public abstract boolean validate();
}
