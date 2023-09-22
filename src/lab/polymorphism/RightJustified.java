package lab.polymorphism;

public class RightJustified implements TextBlock {
   
    TextBlock contents;

    TextBlock txt;

    public RightJustified(TextBlock txt, int widt){
        if ((widt - 2) < txt.textline().length()) {
            TextBlock errorB = new TextLine("Error");
            this.contents = errorB;
        } else{
           String emptybeg = " ".repeat(widt - (txt.textline().length() + 2));
        TextLine string1 = new TextLine(emptybeg.concat(txt.textline()));

        this.contents = string1;
    }
    }

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
        return "RightJust";
      }
}

