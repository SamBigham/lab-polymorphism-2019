package lab.polymorphism;

public class Truncated implements TextBlock {

    TextBlock contents;

    TextBlock txt;

    // pre: Textblock
    // pre: width -> int n, where n is greater than 1
    // post: Textblock truncated by width
    // This program truncates by making the string smaller, or by making the string
    // bigger using
    // spaces if the width is greater than the string
    public Truncated(TextBlock txt, int widt) { // truncates the given textblock
        if (widt < 2) { // if the width is under two, it can't be truncated anymore and is an error
            TextBlock errorB = new TextLine("Error");
            this.contents = errorB; // returns an error textblock
        } else if (widt > (txt.textline().length() + 2)) {
            String spacestring = " ".repeat(widt - txt.textline().length() - 2); // spaces to be used as whitespace
            TextLine string1 = new TextLine(txt.textline().concat(spacestring));
            this.contents = string1; // sets contents equal to string1
        } else {
            TextLine string1 = new TextLine(txt.textline().substring(0, widt - 2)); // this line truncates using
                                                                                    // substring

            this.contents = string1;
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
    public String type(){
        return "Truncated";
      }
}
