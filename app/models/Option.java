package models;

import javax.persistence.*;

@Entity
@Table(name = "options")
public class Option {
  @Id private Long id;
  private String text;

  @ManyToOne(cascade = CascadeType.ALL)
  private Question question;

  public Option(String t) {
    this.text = t;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Question getQuestion() {
    return question;
  }

  public void setQuestion(Question question) {
    this.question = question;
  }

  @Override
  public String toString() {
    return "Option{" + "text='" + text + '\'' + '}';
  }
}
