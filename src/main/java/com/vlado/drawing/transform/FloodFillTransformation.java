package com.vlado.drawing.transform;

import static com.google.common.base.Preconditions.checkNotNull;

import com.vlado.drawing.canvas.Canvas;
import com.vlado.drawing.canvas.Color;
import com.vlado.drawing.canvas.Pixel;
import com.vlado.drawing.canvas.RenderDelegate;

/**
 * A {@link Transformation} which by given 2-dimensional coordinate, fills the neighboring pixels
 * with a specified color, provided they are with the same color as with the initial coordinate.
 */
public class FloodFillTransformation implements Transformation {

  private final Color color;
  private final int row;
  private final int col;
  private boolean[][] visited;

  public FloodFillTransformation(Color color, int row, int col) {
    this.color = checkNotNull(color);
    this.row = row;
    this.col = col;
  }

  /**
   * {@inheritDoc}
   * @param canvas a read-only version of a canvas.
   * @param delegate the delegate interface used by the {@link Canvas} to apply the changes.
   * @return
   */
  public void transform(Canvas canvas, RenderDelegate delegate) {
    int height = canvas.getHeight();
    int width = canvas.getWidth();
    visited = new boolean[height][width];
    Pixel pixel = canvas.pixelAt(row, col);
    if (pixel != null && pixel.getColor() != null) {
      floodFill(row, col, height, width, canvas, pixel.getColor(), delegate);
    }
  }

  private void floodFill(int row, int col, int height, int width, Canvas canvas, Color
      targetColor, RenderDelegate delegate) {
    if (row >= 0 &&
        row < height &&
        col >= 0 &&
        col < width &&
        !visited[row][col] &&
        canvas.pixelAt(row, col) != null &&
        canvas.pixelAt(row, col).getColor() == targetColor) {

      visited[row][col] = true;
      if (canvas.pixelAt(row, col).getColor().equals(targetColor)) {
        delegate.setPixelAt(row, col, new Pixel(color));
      }

      //Flood filling on all directions
      floodFill(row - 1, col - 1, height, width, canvas, targetColor, delegate);
      floodFill(row - 1, col, height, width, canvas, targetColor, delegate);
      floodFill(row - 1, col + 1, height, width, canvas, targetColor, delegate);
      floodFill(row, col - 1, height, width, canvas, targetColor, delegate);
      floodFill(row, col + 1, height, width, canvas, targetColor, delegate);
      floodFill(row + 1, col - 1, height, width, canvas, targetColor, delegate);
      floodFill(row + 1, col, height, width, canvas, targetColor, delegate);
      floodFill(row + 1, col + 1, height, width, canvas, targetColor, delegate);
    }
  }
}
