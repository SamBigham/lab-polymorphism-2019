package lab.polymorphism;

public class NewBlock implements TextBlock {

    TextBlock contents;

    TextBlock txt;

    // pre: textblock
    // pre: n, where n is the number of Boxes surround the text. N > 0
    // post: a boxed block where there are n amount of boxes
    // creates a new textblock which is surrounded n times
    public NewBlock(TextBlock txt, int n) {
        TextLine lin = new TextLine(txt.textline());
        if (n <= 1) {
            this.contents = lin; // there will only be one box
        } else {
            BoxedBlock multiblk = new BoxedBlock(lin); // there will be two boxes
            if (n > 2) {
                for (int i = 2; i < n; i++) {
                    multiblk = new BoxedBlock(multiblk); // there will be n amount of boxes
                }
            }
            this.contents = multiblk; // sets contents equal to n amount of boxes
        }
        // for (int i = 0; i < n; i++){
        // multiblk = new BoxedBlock(multiblk);

        // }

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
        return "NewBlock";
      }
}
