package controllers;

import play.mvc.*;

import services.QuizService;
import views.html.*;

import java.util.concurrent.CompletionStage;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {
  private static QuizService service = new QuizService();

  public Result index() {
    return ok(index.render("Your new application is ready."));
  }

  public CompletionStage<Result> quiz() {
    return service
      .fetch()
      .thenApply(response -> ok(quiz.render(response)));
  }
}
