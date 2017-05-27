package controllers;

import play.mvc.*;

import services.QuizService;
import views.html.*;

import java.util.concurrent.CompletionStage;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class ApplicationController extends Controller {
  private static QuizService service = new QuizService();

  public CompletionStage<Result> index() {
    return service
      .fetch()
      .thenApply(response -> ok(quiz.render(response)));
  }
}
