package com.vlado.drawing.transform;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.vlado.drawing.canvas.Canvas;
import com.vlado.drawing.canvas.Color;
import com.vlado.drawing.canvas.Pixel;
import com.vlado.drawing.canvas.RenderDelegate;
import org.junit.Test;

public class FloodFillTest {

  @Test
  public void testTransform() {
    Canvas canvas = mock(Canvas.class);
    when(canvas.getHeight()).thenReturn(2);
    when(canvas.getWidth()).thenReturn(2);
    when(canvas.pixelAt(anyInt(), anyInt())).thenReturn(new Pixel(Color.ORANGE));
    RenderDelegate renderDelegate = mock(RenderDelegate.class);
    FloodFillTransformation transformation = new FloodFillTransformation(Color.BLUE, 0, 0);
    transformation.transform(canvas, renderDelegate);
    verify(canvas, times(1)).getHeight();
    verify(canvas, times(1)).getWidth();
    verify(renderDelegate, times(4)).setPixelAt(anyInt(), anyInt(), any(Pixel.class));
  }

  @Test(expected = NullPointerException.class)
  public void testNullColor() {
    new FloodFillTransformation(null, 1, 2);
  }

}
