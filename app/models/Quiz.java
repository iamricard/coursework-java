package models;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "quizzes")
@JsonIgnoreProperties({"response_code"})
public class Quiz extends Model {
  @Id private UUID id;

  @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
  @JsonProperty("results")
  private List<Question> questions;

  private String difficulty = "Mixed";

  public static Finder<Long, Quiz> find = new Finder<>(Quiz.class);

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public List<Question> getQuestions() {
    return questions;
  }

  public void setQuestions(List<Question> questions) {
    this.questions = questions;
  }

  public String getDifficulty() {
    return difficulty;
  }

  public void setDifficulty(String difficulty) {
    this.difficulty = difficulty;
  }
}
