package models;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import play.data.DynamicForm;

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

  @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
  private List<QuizResult> quizResults;

  private String difficulty;

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

  public int computeScore(DynamicForm answers) {
    int score = 0;

    for (Question q : questions) {
      String a = answers.get(q.getId().toString());
      if (a != null && a.equals(q.getCorrectAnswer())) score += 1;
    }

    return score;
  }

  public List<QuizResult> getQuizResults() {
    return quizResults;
  }

  public void setQuizResults(List<QuizResult> quizResults) {
    this.quizResults = quizResults;
  }
}
