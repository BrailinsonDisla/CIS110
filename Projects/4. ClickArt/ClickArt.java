/******************************************************************************
 *  Name: Brailinson Disla
 *  PennKey: bdisla
 *
 *  Compilation:  javac ClickArt.java
 *  Execution:    java ClickArt
 *
 *  Creates and provides an interactive drawing environment for the user.
 *
 *  % java ClickArt
 ******************************************************************************/
public class ClickArt {
    public static void main(String[] args) {
        // constants for canvas dimensions
        final int CANVAS_WIDTH = 1500, CANVAS_HEIGHT = 1500;

        // constants for lower and upper bounds
        final double XLOWER_BOUND = -100, XUPPER_BOUND = 100;
        final double YLOWER_BOUND = -100, YUPPER_BOUND = 100;

        // sets the size of the window
        PennDraw.setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);

        // sets the x scale (domain)
        PennDraw.setXscale(XLOWER_BOUND, XUPPER_BOUND);

        // sets the y scale (range)
        PennDraw.setYscale(YLOWER_BOUND, YUPPER_BOUND);
        //////////////////////////////////////////////////// PREP FOR CANVAS ^^^

        // constants for half width and half height
        final double halfWidth = (XUPPER_BOUND - XLOWER_BOUND) / 2.0;
        final double halfHeight = (YUPPER_BOUND - YLOWER_BOUND) / 2.0;
            // <upper> - <lower> is the toal distance between the bounds

        // constants for the coordicates of the upper and lower backgrounds
        final double x = XLOWER_BOUND + halfWidth;
        final double yLower = YLOWER_BOUND + (halfHeight / 2.0);
        final double yUpper = YUPPER_BOUND - (halfHeight / 2.0);
        ////////////////////////////////////////////////// PREP FOR RELATIVE ^^^

        // continuously run the program
        while (true) {
            // do, and repeat when any key is pressed
            do {
                // clears the canvas
                PennDraw.clear();

                // draws the upper background - sky
                PennDraw.setPenColor(135, 200, 245);
                PennDraw.filledRectangle(x, yUpper, halfWidth, halfHeight / 2.0);

                // draws the lower background - grass
                PennDraw.setPenColor(0, 179, 120);
                PennDraw.filledRectangle(x, yLower, halfWidth, halfHeight / 2.0);

                // draws the horizon
                PennDraw.setPenColor(PennDraw.BLACK);
                PennDraw.setPenRadius(0.005);
                PennDraw.line(XLOWER_BOUND, YLOWER_BOUND + halfHeight,
                                XUPPER_BOUND, YUPPER_BOUND - halfHeight);

                // randomizes number of iterations - [0, 51) or [0, 50]
                int iters = (int) (51 * Math.random());

                // auxiliary variables
                double rand = 0, xCoor = 0, yCoor = 0, r = 1, angle = 120;
                double excessA = 0, excessB = 0;
                double horizon = YLOWER_BOUND  + halfHeight;

                // draws birds and ufos randomly, favoring birds
                while (iters >= 0) {
                    // randomize number
                    rand = Math.random();

                    // randomize location
                    xCoor = XLOWER_BOUND + (XUPPER_BOUND - XLOWER_BOUND) * Math.random();
                    yCoor = XLOWER_BOUND + halfHeight * (1 + Math.random());

                    // draw birs or ufo -- depends on random number
                    if (rand < 0.95) {
                        // randomize opacity
                        PennDraw.setPenColor(0, 0, 0, (int) (75 + 25 * Math.random()));

                        // randomize size and length
                        r = 5 * Math.random();
                        angle = 60 + 60 * Math.random();

                        // calculates potential excess - left
                        excessA = r * Math.cos(Math.toRadians(angle));

                        // calculates potential excess - right
                        excessB = r * (2 + Math.cos(Math.toRadians(180 - angle)));

                        // adjust coordinates to keep within bounds - left
                        if (xCoor + excessA < XLOWER_BOUND) {
                            xCoor = XLOWER_BOUND - excessA;
                        }

                        // adjust coordinates to keep within bounds - right
                        else if  (xCoor + excessB > XUPPER_BOUND) {
                            xCoor = XUPPER_BOUND - excessB;
                        }

                        // calculate potential excess - up
                        excessA = r * Math.sin(Math.toRadians(angle));

                        // adjust coordinates to keep within bounds - up
                        if (yCoor + excessA > YUPPER_BOUND) {
                            yCoor = YUPPER_BOUND - excessA;
                        }

                        // draws a bird at the sanitized location
                        PennDraw.arc(xCoor, yCoor, r, 0, angle);
                        PennDraw.arc(xCoor + 2 * r, yCoor, r, 180 - angle, 180);
                    } else {
                        // randomize opacity
                        PennDraw.setPenColor(0, 0, 0, (int) (100 * Math.random()));

                        // randomize size
                        r = 14 + 6 * Math.random();

                        // adjust coordinates to keep within bounds - left
                        if (xCoor - r < XLOWER_BOUND) {
                            xCoor = XLOWER_BOUND + r;
                        }

                        // adjust coordinates to keep within bounds - right
                        else if  (xCoor + r > XUPPER_BOUND) {
                            xCoor = XUPPER_BOUND - r;
                        }

                        // adjust coordinates to keep within bounds - up
                        if (yCoor + r  / 5.0 > YUPPER_BOUND) {
                            yCoor = YUPPER_BOUND - r  / 5.0 ;
                        }

                        // adjust coordinates to keep within bounds - down
                        else if (yCoor - r  / 5.0 < horizon) {
                            yCoor = horizon + r  / 5.0 ;
                        }

                        // draws ufos at sanitized location
                        PennDraw.filledEllipse(xCoor, yCoor, r, r / 5.0);
                    }
                    // update counter
                    iters--;
                }

                // randomizes number of iterations - [100, 351) or [100, 150]
                iters = 100 + (int) (251 * Math.random());

                // draws grass
                while (iters >= 0) {
                    // randomizes location
                    xCoor = XLOWER_BOUND + (XUPPER_BOUND - XLOWER_BOUND) * Math.random();
                    yCoor = XLOWER_BOUND + halfHeight * Math.random();

                    // sets pen color for grass leaf blades
                    PennDraw.setPenColor(0, 220, 120);

                    // randomizes size and length
                    r = 10 * Math.random();
                    angle = 60 + 30 * Math.random();

                    // calculates potential excess - left
                    excessA = r * Math.cos(Math.toRadians(angle));

                    // calculates potential excess - right
                    excessB = r * (2 + Math.cos(Math.toRadians(180 - angle)));

                    // adjust coordinates to keep within bounds - left
                    if (xCoor + excessA < XLOWER_BOUND) {
                        xCoor = XLOWER_BOUND - excessA;
                    }

                    // adjust coordinates to keep within bounds - right
                    else if  (xCoor + excessB > XUPPER_BOUND) {
                        xCoor = XUPPER_BOUND - excessB;
                    }

                    // calculateS potential excess - up
                    excessA = r * Math.sin(Math.toRadians(angle));

                    // adjust to keep within bounds - up
                    if (yCoor + excessA > halfHeight) {
                        yCoor = halfHeight - excessA;
                    }

                    // draws a leaf blade, alternates directions
                    if (iters % 2 == 0) // CCW
                        PennDraw.arc(xCoor, yCoor, r, 0, angle);
                    else // CW
                        PennDraw.arc(xCoor + 2 * r, yCoor, r, 180 - angle, 180);

                    // update counter
                    iters--;
                }

                // runs while no key is pressed
                while (!PennDraw.hasNextKeyTyped()) {
                    // checks if mouse is pressed
                    if (PennDraw.mousePressed()) {
                        // gets mouse the coordinates on canvas
                        xCoor = PennDraw.mouseX();
                        yCoor = PennDraw.mouseY();

                        // variables for distance from horizon and scale
                        double dist = 0, scale = 12;

                        // calculates distance from horizon
                        dist = Math.abs(yCoor - horizon);

                        // calculates r on scale
                        r = scale * dist / halfHeight;

                        // checks in region the mouse is
                        if (yCoor == horizon) {
                            // draw nothing at the horizon
                        } else if (yCoor > horizon &&
                                    yCoor + r < YUPPER_BOUND) { // sky
                            // sets pen color to white
                            PennDraw.setPenColor(255, 255, 255);

                            // calculates potential excess - left
                            excessA = r;

                            // calculates potential excess - right
                            excessB = 4.0 * r;

                            // adjust coordinates to keep within bounds - left
                            if (xCoor - excessA < XLOWER_BOUND) {
                                xCoor = XLOWER_BOUND + excessA;
                            }

                            // adjust coordinates to keep within bounds - right
                            else if  (xCoor + excessB > XUPPER_BOUND) {
                                xCoor = XUPPER_BOUND - excessB;
                            }

                            // draws cloud at sanitized location
                            PennDraw.filledCircle(xCoor, yCoor, r);
                            PennDraw.filledCircle(xCoor + 1.5 * r, yCoor, r);
                            PennDraw.filledCircle(xCoor + 3.0 * r, yCoor, r);
                        } else if (yCoor < horizon
                                    && yCoor > YLOWER_BOUND) { // grass
                            // sets pen color to orange
                            PennDraw.setPenColor(PennDraw.ORANGE);

                            // adjust coordinates to keep within bounds - left
                            if (xCoor - r - r / 2.0 < XLOWER_BOUND) {
                                xCoor = XLOWER_BOUND + r + r / 2.0;
                            }

                            // adjust coordinates to keep within bounds - right
                            else if  (xCoor + r + r / 2.0 > XUPPER_BOUND) {
                                xCoor = XUPPER_BOUND - r - r / 2.0;
                            }

                            // draws stem
                            PennDraw.setPenRadius(r / 500);
                            PennDraw.setPenColor(139, 69, 19);
                            PennDraw.line(xCoor, yCoor, xCoor, yCoor + 1.5 * r);

                            // draws tree top
                            PennDraw.setPenRadius();
                            PennDraw.setPenColor(PennDraw.ORANGE);
                            PennDraw.filledCircle(xCoor, yCoor + 2.5 * r, r);
                            PennDraw.filledCircle(xCoor + r, yCoor + 2.5 * r, r / 2.0);
                            PennDraw.filledCircle(xCoor - r, yCoor + 2.5 * r, r / 2.0);
                            PennDraw.filledCircle(xCoor, yCoor + 3.5 * r, r / 2.0);

                            // adds center
                            PennDraw.setPenColor(PennDraw.GREEN);
                            PennDraw.filledCircle(xCoor, yCoor + 2.5 * r, r / 2.0);
                        }
                    }
                }

                // clears the key buffer
                PennDraw.nextKeyTyped();
            } while (PennDraw.hasNextKeyTyped());
        }
    }
}
