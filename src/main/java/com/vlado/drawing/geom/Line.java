package com.vlado.drawing.geom;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableList.Builder;
import com.vlado.drawing.canvas.Color;
import java.util.Iterator;

/**
 * A line representation in {@code (x,y)} coordinate space.
 */
public class Line implements Shape {

  private Color color;
  private final Point startPoint;
  private final Point endPoint;

  /**
   * Constructs a line by start {@link Point}, end {@link Point} and {@link Color}.
   *
   * @param startPoint the start point of the line. Cannot be null.
   * @param endPoint the end point of the line. Cannot be null.
   * @param color the color of the line. Cannot be null.
   */
  public Line(Point startPoint, Point endPoint, Color color) {
    this.startPoint = checkNotNull(startPoint);
    this.endPoint = checkNotNull(endPoint);
    this.color = checkNotNull(color);
  }

  /**
   * Constructs a line by X and Y coordinates.
   *
   * @param startX the X coordinate of the starting point.
   * @param startY the Y coordinate of the starting point.
   * @param endX the X coordinate of the end point.
   * @param endY the Y coordinate of the end point.
   */
  public Line(int startX, int startY, int endX, int endY) {
    this(startX, startY, endX, endY, Color.DEFAULT);
  }

  /**
   * Constructs a line by provided start and end coordinates and color.
   *
   * @param color the color of the line. Cannot be null.
   */
  public Line(int startX, int startY, int endX, int endY, Color color) {
    this(new Point(startX, startY), new Point(endX, endY), color);
  }

  /**
   * {@inheritDoc}
   *
   * @return an immutable {@link Iterator} of the {@link Point}s constructing the line. Iterator is
   * never null.
   */
  @Override
  public Iterator<Point> getPathIterator() {
    Builder<Point> builder = new Builder<>();
    if (startPoint.getX() == endPoint.getX()) {
      //Vertical case
      for (int i = Math.min(startPoint.getY(), endPoint.getY()); i <= Math.max(startPoint.getY(),
          endPoint.getY()); i++) {
        builder.add(new Point(startPoint.getX(), i));
      }
    } else if (startPoint.getY() == endPoint.getY()) {
      //Horizontal case
      for (int i = Math.min(startPoint.getX(), endPoint.getX()); i <= Math.max(startPoint.getX(),
          endPoint.getX()); i++) {
        builder.add(new Point(i, startPoint.getY()));
      }
    }
    //TODO non-horizontal and non-vertical lines not supported yet
    return builder.build().listIterator();
  }

  /**
   * {@inheritDoc}
   * Returns the {@link Color} of the line. If not specified on construction time, returns the
   * default {@link Color}.
   *
   * @return the color of the line, never null.
   */
  public Color getColor() {
    return color;
  }

  /**
   * Returns a {@link Point} representation of the starting point of the line.
   *
   * @return the start point of the line. Never null.
   */
  public Point getStartPoint() {
    return new Point(startPoint);
  }

  /**
   * Returns a {@link Point} representation of the ending point of the line.
   *
   * @return the end point of theline. Never null.
   */
  public Point getEndPoint() {
    return new Point(endPoint);
  }

}
