package models;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "questions")
public class Question extends Model {
  @Id private UUID id;

  @ManyToOne(cascade = CascadeType.ALL)
  private Quiz quiz;

  @JsonProperty("question")
  private String text;

  private String category;
  private String type;
  private String difficulty;

  @JsonProperty("correct_answer")
  private String correctAnswer;

  @JsonProperty("incorrect_answers")
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
  private List<Option> incorrectAnswers;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Quiz getQuiz() {
    return quiz;
  }

  public void setQuiz(Quiz quiz) {
    this.quiz = quiz;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getCategory() {
    return category.split("\\s|:")[0].toLowerCase();
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getDifficulty() {
    return difficulty;
  }

  public void setDifficulty(String difficulty) {
    this.difficulty = difficulty;
  }

  public String getCorrectAnswer() {
    return correctAnswer;
  }

  public void setCorrectAnswer(String correctAnswer) {
    this.correctAnswer = correctAnswer;
  }

  public List<Option> getIncorrectAnswers() {
    return incorrectAnswers;
  }

  public void setIncorrectAnswers(List<Option> incorrectAnswers) {
    this.incorrectAnswers = incorrectAnswers;
  }

  public List<Option> getOptions() {
    List<Option> os = new ArrayList<>(this.incorrectAnswers);
    os.add(new Option(this.correctAnswer));
    Collections.shuffle(os);

    return os;
  }
}
