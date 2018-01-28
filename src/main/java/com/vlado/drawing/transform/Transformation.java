package com.vlado.drawing.transform;

import com.vlado.drawing.canvas.Canvas;
import com.vlado.drawing.canvas.RenderDelegate;

/**
 * An interface to apply transformations to a {@link Canvas}.
 */
public interface Transformation {

  /**
   * Applies a transformation on a given {@link Canvas}
   *
   * @param canvas a read-only version of a canvas.
   * @param delegate the delegate interface used by the {@link Canvas} to apply the changes.
   */
  void transform(Canvas canvas, RenderDelegate delegate);
}
