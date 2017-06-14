package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Quiz;
import play.libs.ws.WS;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;

import java.io.IOException;
import java.util.concurrent.CompletionStage;

public class QuizService {
  public CompletionStage<Quiz> fetch(String amount, String difficulty) {
    return request(amount, difficulty)
        .thenApply((WSResponse r) -> r.asJson().toString())
        .thenApply((String json) -> save(json, difficulty));
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

  private Quiz save(String json, String difficulty) {
    ObjectMapper m = new ObjectMapper();
    try {
      Quiz q = m.readValue(json, Quiz.class);
      q.setDifficulty(difficulty);
      q.save();
      return q;
    } catch (IOException e) {
      return new Quiz();
    }
  }
}
