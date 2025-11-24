package com.gdn.training;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Number Helper Test")
class NumberHelperTest {
  @Test
  @DisplayName("is odd number true")
  public void isOddNumberTrue() {
    assertTrue(NumberHelper.isOdd(1));
    assertTrue(NumberHelper.isOdd(-5));
  }

  @Test
  @DisplayName("is odd number false")
  public void isOddNumberFalse() {
    assertFalse(NumberHelper.isOdd(2));
    assertFalse(NumberHelper.isOdd(-6));
  }

  @Test
  @DisplayName("is even number true")
  public void isEvenNumberTrue() {
    assertTrue(NumberHelper.isEven(2));
    assertTrue(NumberHelper.isEven(-6));
  }

  @Test
  @DisplayName("is even number false")
  public void isEvenNumberFalse() {
    assertFalse(NumberHelper.isEven(3));
    assertFalse(NumberHelper.isEven(-7));
  }
}