package com.gdn.training;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Date Formatter Test")
class DateFormatterTest {
  @Test
  @DisplayName("is date not null")
  public void isDateNotNull() {
    IllegalArgumentException ex = assertThrows(
        IllegalArgumentException.class, () -> DateFormatter.getFormattedYearMonth(null)
    );
    assertEquals("date is null", ex.getMessage());
  }

  @Test
  @DisplayName("is date format correct")
  public void isDateFormatCorrect() {
    Calendar cal = Calendar.getInstance();
    cal.set(2023, Calendar.MARCH, 10, 0, 0, 0);
    cal.set(Calendar.MILLISECOND, 0);

    Date date = cal.getTime();

    assertEquals("2023-03", DateFormatter.getFormattedYearMonth(date));
  }
}