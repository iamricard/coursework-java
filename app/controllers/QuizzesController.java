package controllers;

import com.avaje.ebean.Ebean;
import com.google.inject.Inject;
import models.Quiz;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import services.QuizService;
import views.html.quizzes.form;
import views.html.quizzes.show;

import java.util.UUID;
import java.util.concurrent.CompletionStage;

public class QuizzesController extends Controller {
  @Inject private FormFactory formFactory;
  private QuizService service = new QuizService();

  public Result form() {
    return ok(form.render());
  }

  public CompletionStage<Result> create() {
    DynamicForm requestData = formFactory.form().bindFromRequest();
    String amount = requestData.get("questionsAmount");
    String difficulty = requestData.get("difficulty");

    return service
        .fetch(amount, difficulty)
        .thenApply(
            (Quiz q) -> {
              if (q.getQuestions().size() == 0) return redirect("/");

              return redirect("/quiz/" + q.getId());
            });
  }

  public Result show(UUID id) {
    Quiz q = Ebean.find(Quiz.class, id);

    return ok(show.render(q));
  }
}
