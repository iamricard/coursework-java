package controllers;

import com.google.inject.Inject;
import models.Quiz;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.*;

import services.QuizService;
import views.html.*;

import java.util.List;
import java.util.concurrent.CompletionStage;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class ApplicationController extends Controller {
  @Inject private HttpExecutionContext ec;
  private static QuizService service = new QuizService();

  public CompletionStage<Result> index() {
    final Http.Context ctx = ctx();
    return service
      .fetch()
      .thenApply(r -> {
        storeSession(r, ctx);
        return ok(quiz.render(r));
      });
  }

  public Result show() {
    if (session("correctAnswers") == null) return redirect("/");

    String[] correctAnswers = session("correctAnswers").split("");
    String[] userAnswers = request().getQueryString("answers").split("");
    int score = 10;

    for (int idx = 0; idx < correctAnswers.length; idx++) {
      if (!correctAnswers[idx].equals(userAnswers[idx])) score -= 1;
    }

    return ok(result.render(score));
  }

  private String joinAnswers(List<Integer> answers) {
    return answers
      .stream()
      .map(Object::toString)
      .reduce("", (acc, x) -> acc + x);
  }

  private void storeSession(Quiz q, Http.Context ctx) {
    ctx.session().put("correctAnswers", joinAnswers(q.correctAnswers()));
  }
}
