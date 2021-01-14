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
        //PennDraw.filledRectangle(x, yUpper, halfWidth, halfHeight / 2.0);

        // draws the grass
        PennDraw.setPenColor(0, 179, 120);
        //PennDraw.filledRectangle(x, yLower, halfWidth, halfHeight / 2.0);

        // draws the horizon
        PennDraw.setPenColor(PennDraw.BLACK);
        PennDraw.setPenRadius(0.005);
        PennDraw.line(XLOWER_BOUND, YLOWER_BOUND + halfHeight,
                        XUPPER_BOUND, YUPPER_BOUND - halfHeight);

        boolean test = true;

        // variable for random, and auxiliaries
        double random = 0, xc = 0, yc = 0, r = 10, r1 = 0, r2 = 0;

        // draws birds, clouds and ufos randomly
        while (test) {
            // randomizes the number
            random = Math.random();
            
            // distribute probability
            if (random < 1) {
                // draws a bird
                PennDraw.arc(xc, yc, r, 0, 135);
                PennDraw.arc(xc + 2 * r, yc, r, 45, 180);
            } else if (random < 0.66) {
                // draws clouds
            } else {
                // draws ufos
            }

            test = !test;
        }
    }
}
