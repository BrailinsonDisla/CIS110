/******************************************************************************
 *  Name: Brailinson Disla
 *  PennKey: bdisla
 *
 *  Compilation:  javac Race.java
 *  Execution:    java Race
 *
 *  Visualizes a race between two contestants, by default Princeton and UPenn.
 *
 *  % java Race
 ******************************************************************************/
public class Race {
    public static void main(String[] args) {
        // constant for canvas dimensions
        final int CANVAS_WIDTH = 1500, CANVAS_HEIGHT = 1500;

        // constants for lower and upper bounds for scales, and pennant height
        final double LOWER_BOUND = -151, UPPER_BOUND = 100, HEIGHT = 70;

        // sets the size of the window
        PennDraw.setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);

        // sets the x scale
        PennDraw.setXscale(LOWER_BOUND, UPPER_BOUND);

        // sets the y scale
        PennDraw.setYscale(LOWER_BOUND, UPPER_BOUND);

        // calculates one pixel in the new scale
        double onePixel = (UPPER_BOUND - LOWER_BOUND) / CANVAS_WIDTH;
        //////////////////////////////////////////////////// PREP FOR CANVAS ^^^

        // variables to track if the contestants have won
        boolean pennWins = false, princetonWins = false;

        // initialize starting x-coordinate locations
            // half the pennant's width (in pixels) to the right of lower bound,
            // so that both start behind the start line
        double pennXCoor = LOWER_BOUND * (1 - (onePixel / 4.0));
        double princetonXCoor = LOWER_BOUND * (1 - (onePixel / 4.0));

        // initialize starting y-coordinate locations
            // twice the pennant's height (in pixels) below the upper bound and
            // twice above the lower bound, for penn and princeton respectively
        double pennYCoor = UPPER_BOUND - HEIGHT * 2.0 * onePixel;
        double princetonYCoor = LOWER_BOUND + HEIGHT * 2.0 * onePixel;

        // initializes the x-coodinates of the start and finish lines
        double startLineXCoor = LOWER_BOUND * (1 - 1.5 * onePixel);
        double finishLineXCoor = UPPER_BOUND + (LOWER_BOUND * onePixel);

        // initialize the y-coodinates of the start and finish lines
        double lineLowerYCoor = LOWER_BOUND + HEIGHT * onePixel;
        double lineUpperYCoor = UPPER_BOUND - HEIGHT * onePixel;

        // initialize text height
        double textHeight = UPPER_BOUND - 0.5 * HEIGHT * onePixel;

        // initialize variable for the middle
        double midXCoor = (startLineXCoor + finishLineXCoor) / 2.0,
                midYCoor = (lineLowerYCoor + lineUpperYCoor) / 2.0;

        // set pen's width
        PennDraw.setPenRadius(0.005);

        // enable animation
        PennDraw.enableAnimation(100);

        PennDraw.setFontBold();
        PennDraw.setFont("Georgia", 30);

        // continous for race animation
        while (!pennWins && !princetonWins) {
            // clears the screen
            PennDraw.clear();

            // draws start line and finish line text
            PennDraw.text(startLineXCoor, textHeight, "Start");
            PennDraw.text(finishLineXCoor, textHeight, "Finish");

            // draws the start and finish lines
            PennDraw.line(startLineXCoor, lineLowerYCoor,
                          startLineXCoor, lineUpperYCoor);
            PennDraw.line(finishLineXCoor, lineLowerYCoor,
                          finishLineXCoor, lineUpperYCoor);

            // draws the constestants (or pennants)
            PennDraw.picture(pennXCoor, pennYCoor, "penn.png", -1 * LOWER_BOUND, HEIGHT);
            PennDraw.picture(princetonXCoor, princetonYCoor, "princeton.png", -1 * LOWER_BOUND, HEIGHT);

            // checks if penn have reached the finish line
            if (pennXCoor >= finishLineXCoor) {
                // sets flag to win
                pennWins = true;
            }

            // checks if princeton have reached the finish line
            if (princetonXCoor >= finishLineXCoor) {
                // sets flag to win
                princetonWins = true;
            }

            // checks for a tie, then if penn has won, or princeton
            if (pennWins && princetonWins) {
                // show winner text
                PennDraw.text(midXCoor, midYCoor, "TIE");
            } else if (pennWins) {
                // show winner text
                PennDraw.text(midXCoor, midYCoor, "Penn Wins");
            } else if (princetonWins) {
                // show winner text
                PennDraw.text(midXCoor, midYCoor, "Princeton Wins");
            }

            // checks if penn moves - random
            if (Math.random() < 0.5) {
                // move penn by a pixel
                pennXCoor += onePixel;
            }

            // checks if princeton moves
            if (Math.random() >= 0.5) {
                // move princeton by a pixel
                princetonXCoor += onePixel;
            }

            // advance to the next frame
            PennDraw.advance();
        }

    }
}
