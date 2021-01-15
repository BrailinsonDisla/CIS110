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

        while (true) {
            // check if a key has been pressed
            do {
                // clear canvas
                PennDraw.clear();

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

                // number of iterations
                int iters = (int) (50 * Math.random());

                // variable for random, and auxiliaries
                double rand = 0, xCoor = 0, yCoor = 0, r = 1, angle = 120;
                double excessA = 0, excessB = 0;

                // draws birds and ufos randomly
                while (iters >= 0) {
                    // random number to decide on next drawing
                    rand = Math.random();

                    // random location for drawing
                    xCoor = XLOWER_BOUND + (XUPPER_BOUND - XLOWER_BOUND) * Math.random();
                    yCoor = XLOWER_BOUND + halfHeight * (1 + Math.random());

                    // distribute ~evenly
                    if (rand < 0.95) {
                        // randomize opacity
                        PennDraw.setPenColor(0, 0, 0, (int) (75 + 25 * Math.random()));

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
                    } else {
                        // randomize opacity
                        PennDraw.setPenColor(0, 0, 0, (int) (100 * Math.random()));

                        // randomize size
                        r = 14 + 6 * Math.random();

                        // adjust to keep within bounds - left
                        if (xCoor - r < XLOWER_BOUND) {
                            xCoor = r + XLOWER_BOUND;
                        }

                        // adjust to keep within bounds - right
                        else if  (xCoor + r > XUPPER_BOUND) {
                            xCoor = XUPPER_BOUND - r;
                        }

                        // adjust to keep within bounds - up
                        if (yCoor + r  / 5.0 > YUPPER_BOUND) {
                            yCoor = YUPPER_BOUND - r  / 5.0 ;
                        }

                        // adjust to keep within bounds - down
                        else if (yCoor - r  / 5.0 > YUPPER_BOUND) {
                            yCoor = YUPPER_BOUND + r  / 5.0 ;
                        }

                        // draws ufos
                        PennDraw.filledEllipse(xCoor, yCoor, r, r / 5.0);
                    }
                    // update counter
                    iters--;
                }

                // number of iterations
                iters = 100 + (int) (250 * Math.random());

                // draws grass
                while (iters >= 0) {
                    // random location for drawing
                    xCoor = XLOWER_BOUND + (XUPPER_BOUND - XLOWER_BOUND) * Math.random();
                    yCoor = XLOWER_BOUND + halfHeight * Math.random();

                    // set pen color for grass leaf blades
                    PennDraw.setPenColor(0, 220, 120);

                    // randomize size and length
                    r = 10 * Math.random();
                    angle = 60 + 30 * Math.random();

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
                    if (yCoor + excessA > halfHeight) {
                        yCoor = halfHeight - excessA;
                    }

                    // draws a leaf blade
                    if (iters % 2 == 0)
                        PennDraw.arc(xCoor, yCoor, r, 0, angle);
                    else
                        PennDraw.arc(xCoor + 2 * r, yCoor, r, 180 - angle, 180);

                    // update counter
                    iters--;
                }

                // wait for keypress, and check clicks
                while (!PennDraw.hasNextKeyTyped()) {
                    // checks if mouse is pressed
                    if (PennDraw.mousePressed()) {
                        // gets the coordinates
                        xCoor = PennDraw.mouseX();
                        yCoor = PennDraw.mouseY();

                        // variables for horizon y-coordindate
                        double horizon = YLOWER_BOUND + halfHeight;

                        // variable for distance from horizon and scale
                        double dist = 0, scale = 10;

                        // checks in region the mouse is
                        if (yCoor == horizon) {

                        } else if (yCoor > horizon &&
                                    yCoor + scale < YUPPER_BOUND) { // sky
                            // set pen color to white
                            PennDraw.setPenColor(PennDraw.WHITE);

                            // calculate distance from horizon
                            dist = Math.abs(yCoor - horizon);

                            // calculate r to scale
                            r = scale * dist / halfHeight;

                            // draws cloud
                            // draw circle
                            PennDraw.filledCircle(xCoor, yCoor, r);
                            PennDraw.filledCircle(xCoor + 1.5 * r, yCoor, r);
                            PennDraw.filledCircle(xCoor + 3.0 * r, yCoor, r);
                        } else if (yCoor < horizon
                                    && yCoor - scale > YLOWER_BOUND) { // grass
                            // set pen color to orange
                            PennDraw.setPenColor(PennDraw.ORANGE);

                            // calculate distance from horizon
                            dist = Math.abs(horizon - yCoor);

                            // calculate r to scale
                            r = scale * dist / halfHeight;

                            // draw circle
                            PennDraw.filledCircle(xCoor, yCoor, r);
                        }
                    }
                }

                // clear buffer
                PennDraw.nextKeyTyped();
            } while (PennDraw.hasNextKeyTyped());
        }

    }
}
