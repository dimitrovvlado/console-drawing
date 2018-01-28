package com.vlado.drawing.geom;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PointTest {

  @Test
  public void testEquals() {
    assertEquals(new Point(1, 2), new Point(1, 2));
  }
}
