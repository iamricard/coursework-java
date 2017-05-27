package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question {
  @JsonProperty("question") public String text;
  public String category;
  public String type;
  public String difficulty;
  @JsonProperty("correct_answer") public String correctAnswer;
  @JsonProperty("incorrect_answers") public List<String> incorrectAnswers;
  private List<String> options = new ArrayList<>();

  public List<String> options() {
    if (this.options.isEmpty()) {
      this.options = new ArrayList<>(this.incorrectAnswers);
      this.options.add(correctAnswer);
      Collections.shuffle(this.options);
    }

    return this.options;
  }
}
