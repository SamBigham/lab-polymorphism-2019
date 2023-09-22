package lab.polymorphism;

public class HorizontallyFlipped implements TextBlock {
    TextBlock contents;

    TextBlock txt;

    public HorizontallyFlipped(TextBlock txt) {
        String string1 = txt.textline();
        char[] chararr = string1.toCharArray();

        char[] flippedarr = new char[string1.length()];

        for (int i = 0; i < string1.length(); i++) {
            flippedarr[i] = chararr[string1.length() - 1 - i];
        }

        String flip = new String(flippedarr);

        TextLine flipped = new TextLine(flip);
        this.contents = flipped;

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
        return "HoriFlip";
      }
}
