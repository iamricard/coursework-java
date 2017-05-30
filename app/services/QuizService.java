package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Quiz;
import play.libs.ws.WS;
import play.libs.ws.WSResponse;

import java.io.IOException;
import java.util.concurrent.CompletionStage;

public class QuizService {
  private String HOST = "https://opentdb.com/api.php";
  private ObjectMapper mapper = new ObjectMapper();

  public CompletionStage<Quiz> fetch() {
    return WS.url(this.HOST)
        .setQueryParameter("amount", "10")
        .setQueryParameter("type", "multiple")
        .setContentType("application/json")
        .get()
        .thenApply(
            (WSResponse response) -> {
              try {
                return this.mapper.readValue(response.asJson().toString(), Quiz.class);
              } catch (IOException e) {
                e.printStackTrace();
                return new Quiz();
              }
            });
  }
}
