package services;

import play.libs.ws.WS;
import play.libs.ws.WSResponse;

import java.util.concurrent.CompletionStage;

public class QuizService {
  public CompletionStage<String> fetch() {
    return request().thenApply((WSResponse r) -> r.asJson().toString());
  }

  private CompletionStage<WSResponse> request() {
    final String HOST = "https://opentdb.com/api.php";
    return WS.url(HOST)
        .setQueryParameter("amount", "10")
        .setQueryParameter("type", "multiple")
        .setContentType("application/json")
        .get();
  }
}
