package com.vlado.drawing.canvas;

/**
 * A representation of a blank rectangular area of the screen onto which the application can draw.
 */
public interface Canvas {

  /**
   * @return a positive, greater than zero number, which represents the height of the canvas.
   */
  int getHeight();

  /**
   * @return @return a positive, greater than zero number, which represents the width of the canvas.
   */
  int getWidth();

  /**
   * @param row a row
   * @param col a column
   * @return an object representing the coordinate at the provided position.
   */
  Pixel pixelAt(int row, int col);
}
