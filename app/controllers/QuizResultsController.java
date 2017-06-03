package controllers;

import com.avaje.ebean.Ebean;
import com.google.inject.Inject;
import models.Quiz;
import models.QuizResult;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.UUID;

public class QuizResultsController extends Controller {
  @Inject private FormFactory formFactory;

  public Result create() {
    DynamicForm requestData = formFactory.form().bindFromRequest();
    Quiz q = Ebean.find(Quiz.class, UUID.fromString(requestData.get("quiz-id")));
    QuizResult r = new QuizResult();
    r.setScore(q.computeScore(requestData));
    r.setQuiz(q);
    r.save();
    return ok("yay!");
  }

  public Result show(UUID id) {
    //
    return ok("yay!");
  }
}
