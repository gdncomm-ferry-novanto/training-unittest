package com.gdn.training;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("String Helper Test")
class StringHelperTest {
  @Test
  @DisplayName("Is String Uppercased")
  public void isStringUppercased() {
    List<String> inputs = new ArrayList<>();
    inputs.add("lower");
    inputs.add("UPPER");
    inputs.add("CaMeL");
    inputs.add("123");
    inputs.add(null);

    inputs = inputs.stream().filter(Objects::nonNull).toList();

    List<String> output = StringHelper.toUpperCase(inputs);

    assertEquals(inputs.size(), output.size());

    for (String input : inputs) {
      assertTrue(output.contains(input.toUpperCase()));
    }
  }
}