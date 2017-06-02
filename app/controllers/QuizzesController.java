package controllers;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Quiz;
import play.mvc.Controller;
import play.mvc.Result;
import services.QuizService;
import views.html.quizzes.form;
import views.html.quizzes.show;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class QuizzesController extends Controller {
  private QuizService service = new QuizService();

  public Result form() {
    return ok(form.render());
  }

  public Result create() {
    try {
      ObjectMapper mapper = new ObjectMapper();
      String json = service.fetch().toCompletableFuture().get();
      Quiz q = mapper.readValue(json, Quiz.class);
      System.out.println(q.getQuestions());
      q.save();
    } catch (InterruptedException | ExecutionException | IOException e) {
      e.printStackTrace();
    }

    return redirect("/quiz");
  }

  public Result show(UUID id) {
    Quiz q = Ebean.find(Quiz.class, id);

    return ok(show.render(q));
  }
}
