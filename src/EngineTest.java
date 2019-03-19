import org.testng.annotations.Test;


import static org.testng.Assert.assertTrue;

public class EngineTest {

    @Test
    public void position1(){
        String fen  = "k7/2R3R1/8/8/3K4/8/8/8 w - - 0 1 ";
        Board b = new Board(fen);
        System.out.println(b);
        System.out.println(b.generateMovesNeo(true));
        String myString="value1";
        System.out.println(b.translateToInt("c7c8"));
        System.out.println(b.translateToInt("g7g8"));
        String ans = b.translateToInt("g7g8")+"|"+b.translateToInt("c7c8");
        int move = 50580;
        assertTrue(ans.contains(""+move));
    }

}
