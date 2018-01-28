package com.vlado.drawing.canvas;

import static com.google.common.base.Preconditions.checkArgument;

import com.vlado.drawing.geom.Shape;
import com.vlado.drawing.transform.Transformation;

/**
 * An abstract implementation of a {@link Canvas}. Provides functionality to set dimensions.
 */
public abstract class AbstractCanvas implements Canvas {

  /**
   * Width of a canvas in whole-number
   */
  protected final int width;

  /**
   * Width of a canvas in whole-number
   */
  protected final int height;

  /**
   * Constructs a {@link Canvas} with specified dimensions.
   *
   * @param width the width of the canvas, must be greater than 0.
   * @param height the height of the canvas, must be greater than 0.
   */
  public AbstractCanvas(int width, int height) {
    checkArgument(width > 0, "Width was %s but expected non-negative.", width);
    checkArgument(height > 0, "Height was %s but expected non-negative.", height);
    this.width = width;
    this.height = height;
  }

  public int getHeight() {
    return height;
  }

  public int getWidth() {
    return width;
  }

  /**
   * {@inheritDoc}
   */
  public abstract Pixel pixelAt(int row, int col);

  /**
   * Applies a {@link Transformation} on the canvas.
   */
  public abstract void applyTransformation(Transformation transformation);

  /**
   * Draws a {@link Shape} on to the canvas.
   */
  public abstract void draw(Shape shape);

  /**
   * Clears the canvas to its default state right after initialization.
   */
  public abstract void clear();
}
