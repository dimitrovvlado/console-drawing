package com.vlado.drawing;

import com.vlado.drawing.canvas.Color;
import com.vlado.drawing.canvas.ConsoleCanvas;
import com.vlado.drawing.geom.Line;
import com.vlado.drawing.geom.Rectangle;
import com.vlado.drawing.transform.FloodFillTransformation;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Entrypoint of the console drawing application.
 */
public class ConsoleDrawing {

  private ConsoleCanvas canvas;

  private void createOrUpdateCanvas(String[] args) {
    validateArgumentsCount(args, 2);
    int[] numbers = parseIntegers(args);
    canvas = new ConsoleCanvas(numbers[0], numbers[1]);
    System.out.println(canvas.toString());
  }

  private void drawLine(String[] args) {
    validateArgumentsCount(args, 4);
    validateCanvasInitialized();
    int[] ints = parseIntegers(args);
    canvas.draw(new Line(ints[0] - 1, ints[1] - 1, ints[2] - 1, ints[3] - 1));
    System.out.println(canvas.toString());
  }

  private void drawRectangle(String[] args) {
    validateArgumentsCount(args, 4);
    validateCanvasInitialized();
    int[] ints = parseIntegers(args);
    canvas.draw(new Rectangle(ints[0] - 1, ints[1] - 1, ints[2] - 1, ints[3] - 1));
    System.out.println(canvas.toString());
  }

  private void bucketFill(String[] args) {
    validateArgumentsCount(args, 3);
    validateCanvasInitialized();
    Color color = Color.valueOf(args[2].charAt(0));
    int[] ints = parseIntegers(Arrays.copyOfRange(args, 0, args.length - 1));
    canvas.applyTransformation(new FloodFillTransformation(color, ints[1] - 1,
        ints[0] - 1));
    System.out.println(canvas.toString());
  }

  private void validateArgumentsCount(String[] args, int expectedCount) {
    if (args == null || args.length != expectedCount) {
      throw new IllegalArgumentException(String.format("Expected %d arguments.", expectedCount));
    }
  }

  private void validateCanvasInitialized() {
    if (canvas == null) {
      throw new IllegalArgumentException("Canvas not initialized.");
    }
  }

  private int[] parseIntegers(String[] args) {
    try {
      return Arrays.stream(args).mapToInt(Integer::parseInt).toArray();
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Cannot convert numbers.");
    }
  }

  public static void main(String[] args) throws IOException {
    //TODO figure out a better approach for interactive shell
    Scanner scanner = new Scanner(System.in);
    ConsoleDrawing console = new ConsoleDrawing();
    String command = "";
    while (true) {
      System.out.print("Enter command: ");
      command = scanner.nextLine();
      String[] split = command.split(" ");
      if (split.length > 0) {
        try {
          String c = split[0].trim();
          if ("L".equals(c)) {
            console.drawLine(Arrays.copyOfRange(split, 1, split.length));
          } else if ("C".equals(c)){
            console.createOrUpdateCanvas(Arrays.copyOfRange(split, 1, split.length));
          } else if ("R".equals(c)) {
            console.drawRectangle(Arrays.copyOfRange(split, 1, split.length));
          } else if ("B".equals(c)) {
            console.bucketFill(Arrays.copyOfRange(split, 1, split.length));
          } else if ("Q".equals(c)) {
            System.out.println("Bye!");
            break;
          } else {
            System.out.println("Unknown command.");
          }
        } catch (IllegalArgumentException e) {
          System.err.println(e.getMessage());
        }
      }
    }
  }
}
