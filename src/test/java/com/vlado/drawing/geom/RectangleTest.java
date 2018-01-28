package com.vlado.drawing.geom;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertEquals;

import com.google.common.collect.Lists;
import com.vlado.drawing.canvas.Color;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;

public class RectangleTest {

  @Test
  public void testPathIterator() {
    Rectangle rectangle = new Rectangle(1, 1, 2, 2, Color.BLUE);
    Iterator<Point> pathIterator = rectangle.getPathIterator();
    List<Point> points = Lists.newArrayList(pathIterator);
    assertThat(points, hasItems(new Point(1, 1), new Point(1, 2), new Point(2, 1), new Point(2,
        2)));
    assertEquals(Color.BLUE, rectangle.getColor());
  }

  @Test(expected = NullPointerException.class)
  public void testNullColor() {
    new Rectangle(1, 1, 2, 2, null);
  }
}
