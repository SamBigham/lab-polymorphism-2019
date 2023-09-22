package lab.polymorphism;

import java.lang.Math;

public class Centered implements TextBlock {

    TextBlock contents;

    TextBlock txt;

    // pre: textblock
    // pre: width, where width is bigger than or equal to the string inside plus 2
    // post: textblock, where textblock has a string in the middle
    // this program takes in a textblock and a width, and creates a textblock where
    // the string is in the middle of the textblock
    // and the text block has width equal to the width given
    public Centered(TextBlock txt, int widt) {
        if ((widt - 2) < txt.textline().length()) {// checking if width is less than two plus the length of the string
            TextBlock errorB = new TextLine("Error");
            this.contents = errorB; // sets this equal to error block
        } else {
            // emptybeg empty space for beginning of string.
            String emptybeg = " ".repeat((int) Math.ceil(((double) widt - (txt.textline().length() + 2)) / 2));
            String emptyend = " ".repeat((int) Math.floor(((double) widt - (txt.textline().length() + 2)) / 2));
            // emptyend creates empty space for end of string
            TextLine string1 = new TextLine(emptybeg.concat(txt.textline().concat(emptyend)));
            // creates a textline where the text is in the middle surrounded by whitespace
            this.contents = string1; // sets contents equal to string
        }
    }

    // code for running TextBlock
    public String row(int i) throws Exception {
        int h = this.contents.height();
        // The top and bottom of the box
        if ((i == 0) || (i == h + 1)) {
            return "+" + TBUtils.dashes(this.contents.width()) + "+";
        }
        // Stuff within the box
        else if ((i > 0) && (i <= h)) {
            return "|" + this.contents.row(i - 1) + "|";
        }
        // Everything else
        else {
            throw new Exception("Invalid row " + i);
        }
    } // row(int)

    /**
     * Determine how many rows are in the block.
     */
    public int height() {
        return 2 + this.contents.height();
    } // height()

    /**
     * Determine how many columns are in the block.
     */
    public int width() {
        return 2 + this.contents.width();
    } // width()

    public String textline() {
        return this.contents.textline();
    }
    public String type() {
        return "Centered";
      }
}
