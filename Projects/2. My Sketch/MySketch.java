/******************************************************************************
 *  Name: Brailinson Disla
 *  PennKey: bdisla
 *
 *  Compilation:  javac MySketch.java
 *  Execution:    java MySketch
 *
 *  Draws a series of rectangles of decreasing width and height.
 *
 *  % java MySketch
 ******************************************************************************/
public class MySketch {
  // set windows size
  private static final int SIZE = 1750;

  public static void main(String[] args) {
    // set the window size
    PennDraw.setCanvasSize(SIZE, SIZE);

    // set the x & y scales
    PennDraw.setXscale(0, 100);
    PennDraw.setYscale(0, 100);

    // set the pen radius
    PennDraw.setPenRadius(0.008);

    // set integers for sides
    int width = 50, height = 50;

    // loop to draw multiple rectangles
    for (int i = 0; i < 100; i++) {
      // set the color to a variation of blue
      if (i % 4 == 0)
        PennDraw.setPenColor(0, 138, 252);

      // set the color to pink
      else if (i % 4 == 1)
        PennDraw.setPenColor(PennDraw.PINK);

      // set the color to variation of orange
      else if (i % 4 == 2)
        PennDraw.setPenColor(234, 172, 0);

      // set the color to a variation of red
      else
        PennDraw.setPenColor(255, 94, 94);

      // draw a filled rectangle
      PennDraw.filledRectangle(50, 50, width, height);

      // alternate halving width and height
      if (i % 2 == 0)
        width /= 1.5;
      else
        height /= 1.5;
    }
  }
}
