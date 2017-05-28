package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties({ "response_code" })
public class Quiz {
  @JsonProperty("results") public List<Question> questions;

  public List<Integer> correctAnswers() {
    List<Integer> answers = new ArrayList<>();

    for (Question q : questions) {
      answers.add(q.options().indexOf(q.correctAnswer));
    }

    return answers;
  }
}
