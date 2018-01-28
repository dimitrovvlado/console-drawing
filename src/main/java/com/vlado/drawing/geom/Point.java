package com.vlado.drawing.geom;

import com.google.common.base.Objects;

/**
 * A point representing a location in {@code (x,y)} coordinate space, specified in integer
 * precision. This class is immutable.
 */
public class Point {

  /**
   * The X coordinate of this <code>Point</code>.
   */
  private final int x;

  /**
   * The Y coordinate of this <code>Point</code>.
   */
  private final int y;

  /**
   * Constructs and initializes a point at the origin of the coordinate space.
   */
  public Point() {
    this(0, 0);
  }

  /**
   * Constructs and initializes a point at the specified {@code (x,y)} location in the coordinate
   * space.
   *
   * @param x the X coordinate of the constructed <code>Point</code>
   * @param y the Y coordinate of the constructed <code>Point</code>
   */
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Copy constructor. Constructs and initializes a point with the same location as
   * the specified <code>Point</code> object.
   *
   * @param point a point to copy. Cannot be null.
   */
  public Point(Point point) {
    this.x = point.getX();
    this.y = point.getY();
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Point)) {
      return false;
    }
    Point point = (Point) o;
    return getX() == point.getX() && getY() == point.getY();

  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.x, this.y);
  }

  @Override
  public String toString() {
    return "Point{" +
        "x=" + x +
        ", y=" + y +
        '}';
  }
}
