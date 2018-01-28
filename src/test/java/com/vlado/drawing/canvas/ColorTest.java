package com.vlado.drawing.canvas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ColorTest {

  @Test
  public void testValueOf() {
    Color color = Color.valueOf('o');
    assertEquals(color.toString(), "o");
  }

}
