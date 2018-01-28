package com.vlado.drawing.geom;

import com.vlado.drawing.canvas.Color;
import java.util.Iterator;

/**
 * Interface that provides definitions for objects that represent some form of geometric shape.
 * The <code>Shape</code> is described by an {@link Iterator} of {@link Point} objects, which can
 * express the outline of the <code>Shape</code>.
 */
public interface Shape {

  /**
   * Returns an iterator object that iterates along the <code>Shape</code> boundary and provides
   * access to the geometry of the <code>Shape</code> outline.
   */
  Iterator<Point> getPathIterator();

  /**
   * Returns the color of the <code>Shep</code>.
   */
  Color getColor();
}
