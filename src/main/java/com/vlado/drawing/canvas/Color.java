package com.vlado.drawing.canvas;

/**
 * Wrapper class for colors
 */
public class Color {
  public static final Color BLANK = new Color(' ');
  public static final Color DEFAULT = new Color('x');
  public static final Color ORANGE = new Color('o');
  public static final Color BLUE = new Color('b');
  private final char c;

  private Color(char c) {
    this.c = c;
  }

  @Override
  public String toString() {
    return String.valueOf(c);
  }


  public static Color valueOf(Character c) {
    return new Color(c);
  }
}
