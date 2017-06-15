package models;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class QuestionTest {
  @Test
  public void testGetOptions() {
    Question q = new Question();
    q.setIncorrectAnswers(generateOptions());
    q.setCorrectAnswer("d");
    List<Option> expectedOptions =
        Stream.of("a", "b", "c", "d").map(Option::new).collect(Collectors.toList());

    System.out.println(q.getOptions());
    System.out.println(expectedOptions);

    Assert.assertThat(
        "#getOptions contains both correct and incorrect answers", q.getOptions(), hasSize(4));
  }

  private List<Option> generateOptions() {
    return Stream.of("a", "b", "c").map(Option::new).collect(Collectors.toList());
  }
}
