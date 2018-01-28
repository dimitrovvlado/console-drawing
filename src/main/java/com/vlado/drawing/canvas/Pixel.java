package com.vlado.drawing.canvas;

import static com.google.common.base.Verify.verifyNotNull;

/**
 * The {@link Pixel} class represents a single coordinate on a {@link Canvas}
 */
public class Pixel {

  private Color color;

  /**
   * Constructs a {@link Pixel} with a default color.
   */
  public Pixel() {
    this(Color.DEFAULT);
  }

  /**
   * Constructs a {@link Pixel} with a provided color.
   *
   * @param color the color to set. Cannot be null.
   */
  public Pixel(Color color) {
    this.color = verifyNotNull(color);
  }

  public Color getColor() {
    return color;
  }
}
