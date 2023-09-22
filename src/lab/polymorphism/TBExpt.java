package lab.polymorphism;

import java.io.PrintWriter;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.3 of September 2019
 */
public class TBExpt {
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) throws Exception {
    // Prepare for input and output
    PrintWriter pen = new PrintWriter(System.out, true);

    // Create a block to use
    // TextBlock block = new TextLine("Hello");

    TextBlock block = new TextLine("test");
    TextBlock truncblock = new TextLine("We're truncating");
    TextBlock rightblock = new TextLine("Right");
    TextBlock empt = new TextLine("          ");

    BoxedBlock blk = new BoxedBlock(block);
    BoxedBlock em = new BoxedBlock(empt);
    TextBlock tb = new BoxedBlock(new BoxedBlock(new TextLine("Hello there")));

    Truncated trun = new Truncated(truncblock, 3);
    Centered cent = new Centered(block, 10);
    RightJustified rjust = new RightJustified(rightblock, 40);
    NewBlock mult = new NewBlock(block, 4);


    
    HorizontallyFlipped horfli = new HorizontallyFlipped(tb);


    TBUtils.print(pen, trun);
    TBUtils.print(pen, cent);
    TBUtils.print(pen, rjust);
    TBUtils.print(pen, mult);
    TBUtils.print(pen, horfli);

    // TBUtils.print(pen,trun);
    // TBUtils.print(pen,blk);
    // TBUtils.print(pen,em);
    // TBUtils.print(pen,tb);
    // TBUtils.print(pen,trun.truncate(tb, 10));
    // Print out the block
    // TBUtils.print(pen, block);

    // Clean up after ourselves.
    pen.close();
  } // main(String[])

} // class TBExpt
