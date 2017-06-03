package models;

import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "quiz_results")
public class QuizResult extends Model {
  @Id private UUID id;

  @ManyToOne(cascade = CascadeType.PERSIST)
  private Quiz quiz;

  private int score;

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

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }
}
