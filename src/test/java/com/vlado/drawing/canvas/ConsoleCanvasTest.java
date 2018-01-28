package com.vlado.drawing.canvas;

import static org.junit.Assert.assertEquals;

import com.google.common.io.CharStreams;
import com.vlado.drawing.geom.Line;
import com.vlado.drawing.geom.Rectangle;
import com.vlado.drawing.transform.FloodFillTransformation;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.junit.Test;

/**
 * Unit test for testing the {@link ConsoleCanvas}
 */
public class ConsoleCanvasTest {

  @Test
  public void testSimpleFloodFill() {
    ConsoleCanvas canvas = new ConsoleCanvas(1, 1);
    canvas.applyTransformation(new FloodFillTransformation(Color.ORANGE, 0, 0));
    assertEquals("o", canvas.renderAsString(false).replace("\n", "").replace("\r", ""));
  }

  @Test
  public void testBlankCanvas() throws IOException {
    ConsoleCanvas canvas = new ConsoleCanvas(20, 4);
    String expected = fileAsString("blankcanvas.txt");
    assertEquals(expected, canvas.toString());
  }

  @Test
  public void testOverlappingLines() throws IOException {
    ConsoleCanvas canvas = new ConsoleCanvas(20, 10);
    canvas.draw(new Line(1, 2, 6, 2));
    canvas.draw(new Line(2, 1, 2, 6, Color.ORANGE));
    String expected = fileAsString("overlappinglines.txt");
    System.out.println(canvas.toString());
  }

  @Test
  public void testLinesRectanglesFill() throws IOException {
    ConsoleCanvas canvas = new ConsoleCanvas(20, 4);
    canvas.draw(new Line(0, 1, 5, 1));
    canvas.draw(new Line(5, 2, 5, 3));
    canvas.draw(new Rectangle(13, 0, 17, 2));
    canvas.applyTransformation(new FloodFillTransformation(Color.valueOf('o'), 2, 9));
    String expected = fileAsString("linesrectsfill.txt");
    System.out.println(expected);
    assertEquals(expected, canvas.toString());
  }

  @Test
  public void testReflect() {
    ConsoleCanvas canvas = new ConsoleCanvas(20, 4);
    canvas.draw(new Line(1, 2, 6, 2));
    String s1 = canvas.toString();
    canvas.draw(new Line(6, 2, 1, 2));
    String s2 = canvas.toString();
    assertEquals(s1, s2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidHeight() {
    new ConsoleCanvas(20, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidWidth() {
    new ConsoleCanvas(-1, 4);
  }

  private String fileAsString(String filename) throws IOException {
    ClassLoader classLoader = getClass().getClassLoader();
    try (FileReader fileReader = new FileReader(
        new File(classLoader.getResource(filename).getFile()))) {
      return CharStreams.toString(fileReader);
    }
  }
}
