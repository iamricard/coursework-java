package controllers;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import models.Quiz;
import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import services.QuizService;
import views.html.quizzes.form;
import views.html.quizzes.show;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class QuizzesController extends Controller {
  @Inject private FormFactory formFactory;
  private QuizService service = new QuizService();

  public Result form() {
    Form<Quiz> quizForm = formFactory.form(Quiz.class);
    return ok(form.render(quizForm));
  }

  public Result create() {
    DynamicForm requestData = formFactory.form().bindFromRequest();
    String amount = requestData.get("questionsAmount");
    String difficulty = requestData.get("difficulty");

    try {
      ObjectMapper mapper = new ObjectMapper();
      String json = service.fetch(amount, difficulty).toCompletableFuture().get();
      Quiz q = mapper.readValue(json, Quiz.class);
      q.save();
      return redirect("/quiz/" + q.getId());
    } catch (InterruptedException | ExecutionException | IOException e) {
      e.printStackTrace();
    }

    return redirect("/");
  }

  public Result show(UUID id) {
    Quiz q = Ebean.find(Quiz.class, id);

    return ok(show.render(q));
  }
}
