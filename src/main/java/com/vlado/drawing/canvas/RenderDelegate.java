package com.vlado.drawing.canvas;

/**
 * Delegate interface for communicating with an object renderer.
 * A typical {@link Canvas} provides read-only access to it's state. The {@link RenderDelegate}
 * is the write interface to a {@link Canvas}
 */
public interface RenderDelegate {

  /**
   * Sets a {@link Pixel} at a specified location in {@code (x,y)} coordinate.
   * space.
   *
   * @param row the X coordinate of the coordinate space.
   * @param col the Y coordinate of the coordinate space.
   * @param pixel the pixel to set
   * @return true if operation was successful, false otherwise.
   */
  boolean setPixelAt(int row, int col, Pixel pixel);

}
