package services;

import play.libs.ws.WS;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;

import java.util.concurrent.CompletionStage;

public class QuizService {
  public CompletionStage<String> fetch(String amount, String difficulty) {
    return request(amount, difficulty).thenApply((WSResponse r) -> r.asJson().toString());
  }

  private CompletionStage<WSResponse> request(String amount, String difficulty) {
    final String HOST = "https://opentdb.com/api.php";
    final WSRequest req =
        WS.url(HOST)
            .setQueryParameter("amount", amount)
            .setQueryParameter("type", "multiple")
            .setContentType("application/json");

    if (!difficulty.equals("mixed")) {
      return req.setQueryParameter("difficulty", difficulty).get();
    }

    return req.get();
  }
}
