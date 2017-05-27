package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties({ "response_code" })
public class Quiz {
  @JsonProperty("results") public List<Question> questions;
}
