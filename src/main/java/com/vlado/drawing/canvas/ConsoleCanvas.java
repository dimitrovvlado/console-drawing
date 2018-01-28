package com.vlado.drawing.canvas;

import com.google.common.base.Strings;
import com.vlado.drawing.geom.Point;
import com.vlado.drawing.geom.Shape;
import com.vlado.drawing.transform.Transformation;
import java.util.Iterator;

/**
 * A {@link Canvas} implementation which draws shapes on the console.
 */
public class ConsoleCanvas extends AbstractCanvas implements RenderDelegate {

  private final Pixel[][] canvasMatrix;

  /**
   * Constructs a {@link ConsoleCanvas} by the specified height and width.
   *
   * @param width the width of the canvas. Must be greater than 0.
   * @param height the height of the canvas. Must be greater than 0.
   */
  public ConsoleCanvas(int width, int height) {
    super(width, height);
    canvasMatrix = new Pixel[height][width];
    clear();
  }

  public void applyTransformation(Transformation transformation) {
    transformation.transform(new Canvas() {
      public int getHeight() {
        return ConsoleCanvas.this.height;
      }

      public int getWidth() {
        return ConsoleCanvas.this.width;
      }

      public Pixel pixelAt(int row, int col) {
        return ConsoleCanvas.this.pixelAt(row, col);
      }
    }, this);
  }

  /**
   * Returns a string representation of the canvas.
   *
   * @param withFrame whether to draw a frame around the canvas or not.
   * @return a string representation of the canvas, never null.
   */
  public String renderAsString(boolean withFrame) {
    //Increment horizontal border with 2 because of frame thickness
    String hBorder = withFrame ? Strings.repeat("-", width + 2) : "";
    StringBuilder sb = new StringBuilder(hBorder);
    sb.append("\n");
    for (int col = 0; col < canvasMatrix.length; col++) {
      sb.append(withFrame ? "|" : "");
      for (int row = 0; row < canvasMatrix[col].length; row++) {
        Pixel pixel = canvasMatrix[col][row];
        sb.append(pixel != null ? pixel.getColor() : " ");
      }
      sb.append(withFrame ? "|" : "");
      sb.append("\n");
    }
    sb.append(hBorder);
    return sb.toString();
  }

  @Override
  public String toString() {
    return renderAsString(true);
  }

  /**
   * {@inheritDoc}
   *
   * @param shape the shape to draw. If null, no changes are applied.
   */
  public void draw(Shape shape) {
    if (shape != null) {
      final Color color = shape.getColor() != null ? shape.getColor() : Color.DEFAULT;
      Iterator<Point> pathIterator = shape.getPathIterator();
      if (pathIterator != null) {
        pathIterator.forEachRemaining(point -> {
          if (point != null) {
            setPixelAt(point.getY(), point.getX(), new Pixel(color));
          }
        });
      }
    }
  }

  /**
   * {@inheritDoc}
   * The canvas will make a copy of the pixel.
   *
   * @param row row of the pixel. If not within range, no changes are applied.
   * @param col column of the pixel. If not within range, no changes are applied.
   * @param pixel the pixel to set on the canvas. If null, no changes are applied.
   */
  public boolean setPixelAt(int row, int col, Pixel pixel) {
    if (pixel != null && row >= 0 && col >= 0 && canvasMatrix.length > row && canvasMatrix[0]
        .length > col) {
      canvasMatrix[row][col] = new Pixel(pixel.getColor());
      return true;
    }
    return false;
  }

  /**
   * {@inheritDoc}
   *
   * @param row the Y coordinate of the pixel.
   * @param col the X coordinate of the pixel.
   * @return the pixel at the specified location or <code>null</code> if out-of-range.
   */
  public Pixel pixelAt(int row, int col) {
    if (row < 0 || row >= canvasMatrix.length || col < 0 || col >= canvasMatrix[0].length) {
      return null;
    }
    return canvasMatrix[row][col];
  }

  /**
   * {@inheritDoc}
   * Clears the canvas by switching all pixels with a blank {@link Color}
   */
  public void clear() {
    for (int col = 0; col < canvasMatrix.length; col++) {
      for (int row = 0; row < canvasMatrix[col].length; row++) {
        canvasMatrix[col][row] = new Pixel(Color.BLANK);
      }
    }
  }

}
