/******************************************************************************
 *  Name: Brailinson Disla
 *  PennKey: bdisla
 *
 *  Compilation:  javac ClickArt.java
 *  Execution:    java ClickArt
 *
 *
 *
 *  % java ClickArt
 ******************************************************************************/
public class ClickArt {
    public static void main(String[] args) {
        // constant for canvas dimensions
        final int CANVAS_WIDTH = 1500, CANVAS_HEIGHT = 1500;

        // constants for lower and upper bounds
        final double XLOWER_BOUND = -100, XUPPER_BOUND = 100;
        final double YLOWER_BOUND = -100, YUPPER_BOUND = 100;

        // sets the size of the window
        PennDraw.setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);

        // sets the x scale
        PennDraw.setXscale(XLOWER_BOUND, XUPPER_BOUND);

        // sets the y scale
        PennDraw.setYscale(YLOWER_BOUND, YUPPER_BOUND);

        // calculates one pixel in the new scale
        double onePixel = (XUPPER_BOUND - XLOWER_BOUND) / CANVAS_WIDTH;
        //////////////////////////////////////////////////// PREP FOR CANVAS ^^^

        // variables for half width and half height
        double halfWidth = (XUPPER_BOUND - XLOWER_BOUND) / 2.0;
        double halfHeight = (YUPPER_BOUND - YLOWER_BOUND) / 2.0;

        // variables for upper and lower backgrounds
        double x = XLOWER_BOUND + halfWidth;
        double yLower = YLOWER_BOUND + (halfHeight / 2.0);
        double yUpper = YUPPER_BOUND - (halfHeight / 2.0);

        // draws the sky
        PennDraw.setPenColor(135, 200, 245);
        PennDraw.filledRectangle(x, yUpper, halfWidth, halfHeight / 2.0);

        // draws the grass
        PennDraw.setPenColor(0, 179, 120);
        PennDraw.filledRectangle(x, yLower, halfWidth, halfHeight / 2.0);

        // draws the horizon
        PennDraw.setPenColor(PennDraw.BLACK);
        PennDraw.setPenRadius(0.005);
        PennDraw.line(XLOWER_BOUND, YLOWER_BOUND + halfHeight,
                        XUPPER_BOUND, YUPPER_BOUND - halfHeight);

        int test = 0;

        // variable for random, and auxiliaries
        double rand = 0, xCoor = 0, yCoor = 0, r = 1, angle = 120;
        double excessA = 0, excessB = 0;

        // draws birds, clouds and ufos randomly
        while (test < 50) {
            // random number to decide on next drawing
            rand = Math.random();

            // random location for drawing
            xCoor = XLOWER_BOUND + (XUPPER_BOUND - XLOWER_BOUND) * Math.random();
            yCoor = XLOWER_BOUND + halfHeight * (1 + Math.random());

            // distribute ~evenly
            if (rand < 0.33) {
                // randomize size and length
                r = 5 * Math.random();
                angle = 60 + 60 * Math.random();

                // calculate potential excess - left
                excessA = r * Math.cos(Math.toRadians(angle));

                // calculate potential excess - right
                excessB = r * (2 + Math.cos(Math.toRadians(180 - angle)));

                // adjust to keep within bounds - left
                if (xCoor + excessA < XLOWER_BOUND) {
                    xCoor = excessA + XLOWER_BOUND;
                }

                // adjust to keep within bounds - right
                else if  (xCoor + excessB > XUPPER_BOUND) {
                    xCoor = XUPPER_BOUND - excessB;
                }

                // calculate potential excess - up
                excessA = r * Math.sin(Math.toRadians(angle));

                // adjust to keep within bounds - up
                if (yCoor + excessA > YUPPER_BOUND) {
                    yCoor = YUPPER_BOUND - excessA;
                }

                // draws a bird
                PennDraw.arc(xCoor, yCoor, r, 0, angle);
                PennDraw.arc(xCoor + 2 * r, yCoor, r, 180 - angle, 180);
            } else if (rand < 0.66) {
                // draws clouds
            } else {
                // draws ufos
            }

            test++;
        }
    }
}
