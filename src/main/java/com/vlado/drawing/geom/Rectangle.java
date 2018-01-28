package com.vlado.drawing.geom;

import static com.google.common.base.Verify.verifyNotNull;

import com.google.common.collect.Iterators;
import com.vlado.drawing.canvas.Color;
import java.util.Iterator;

/**
 * Rectangle shape, represented by 4 {@link Line}s and a {@link Color}.
 */
public class Rectangle implements Shape {

  private Line upperLine;
  private Line lowerLine;
  private Line rightLine;
  private Line leftLine;
  private Color color;

  /**
   * Constructs a {@link Rectangle} by start and end coordinates and a default {@link Color}
   *
   * @param startX x coordinate of the upper-left corner.
   * @param startY y coordinate of the upper-left corner.
   * @param endX x coordinate of the lower-right corner.
   * @param endY y coordinate of the lower-right corner.
   */
  public Rectangle(int startX, int startY, int endX, int endY) {
    this(startX, startY, endX, endY, Color.DEFAULT);
  }

  /**
   * Constructs a {@link Rectangle} by start and end coordinates and a default {@link Color}
   *
   * @param startX x coordinate of the upper-left corner.
   * @param startY y coordinate of the upper-left corner.
   * @param endX x coordinate of the lower-right corner.
   * @param endY y coordinate of the lower-right corner.
   * @param color the color of the rectangle. Cannot be null.
   */
  public Rectangle(int startX, int startY, int endX, int endY, Color color) {
    Point upperLeft = new Point(startX, startY);
    Point upperRight = new Point(endX, startY);
    Point lowerLeft = new Point(startX, endY);
    Point lowerRight = new Point(endX, endY);
    upperLine = new Line(upperLeft, upperRight, color);
    lowerLine = new Line(lowerLeft, lowerRight, color);
    rightLine = new Line(upperLeft, lowerLeft, color);
    leftLine = new Line(upperRight, lowerRight, color);
    this.color = verifyNotNull(color);
  }

  public Color getColor() {
    return color;
  }

  @Override
  public Iterator<Point> getPathIterator() {
    return Iterators.concat(upperLine.getPathIterator(), lowerLine.getPathIterator(), rightLine
        .getPathIterator(), leftLine.getPathIterator());
  }

}
