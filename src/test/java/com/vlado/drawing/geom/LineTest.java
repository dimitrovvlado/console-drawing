package com.vlado.drawing.geom;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertEquals;

import com.google.common.collect.Lists;
import com.vlado.drawing.canvas.Color;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;

public class LineTest {

  @Test
  public void testPathIterator() {
    Line line = new Line(1, 2, 1, 4, Color.BLUE);
    assertEquals(Color.BLUE, line.getColor());
    Iterator<Point> pathIterator = line.getPathIterator();
    List<Point> points = Lists.newArrayList(pathIterator);
    assertThat(points, hasItems(new Point(1, 2), new Point(1, 3), new Point(1, 4)));
  }

  @Test(expected = NullPointerException.class)
  public void testLineNullPointX() {
    new Line(null, new Point(), Color.BLUE);
  }

  @Test(expected = NullPointerException.class)
  public void testLineNullPointY() {
    new Line(new Point(), null, Color.BLUE);
  }

  @Test(expected = NullPointerException.class)
  public void testLineNullColor() {
    new Line(new Point(), new Point(), null);
  }

}
