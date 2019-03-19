import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class EngineTest {


    @Test
    public void position2(){
        String fen  = "K7/R2r3r1/8/8/3k4/8/8/8 b - - 0 1 ";
        Board b = new Board(fen);
        MinMax.minMax(4,b,false,4,"");
        int ans = Integer.parseInt(MinMax.best.substring(6,11));
        int move = 51480;
        System.out.println(b);
        System.out.println(b.translate(ans));
        assertEquals(ans,move);
    }

    @Test
    public void position3(){
        String fen  = "k7/r2R3R1/8/8/3K4/8/8/8 w - - 0 1 ";
        Board b = new Board(fen);
        MinMax.minMax(4,b,true,4,"");
        int ans = Integer.parseInt(MinMax.best.substring(6,11));
        int move = 51480;
        System.out.println(b);
        System.out.println(b.translate(ans));
        assertEquals(ans,move);
    }

    @Test
    public void position5(){
        String fen  = "K7/R2r3r1/8/8/3k4/8/8/8 w - - 0 1 ";
        Board b = new Board(fen);
        MinMax.minMax(4,b,true,4,"");
        int ans1 = Integer.parseInt(MinMax.best.substring(6,11));
        String[] possibleMoves ={"a7a6","a7a5","a7a4","a7a3","a7a2","a7a1"};
        String move="";
        for(int i=0;i<possibleMoves.length;i++)
        {
            move+="|"+ b.translateToInt(possibleMoves[i]);
        }

        String ans = ans1+"";
        System.out.println(b);
        System.out.println(b.translate(ans));
        assertTrue(move.contains(ans));
    }

    @Test
    public void position6(){
        String fen  = "k7/r2R3R1/8/8/3K4/8/8/8 b - - 0 1 ";
        Board b = new Board(fen);
        MinMax.minMax(4,b,false,4,"");
        int ans1 = Integer.parseInt(MinMax.best.substring(6,11));
        String[] possibleMoves ={"a7a6","a7a5","a7a4","a7a3","a7a2","a7a1"};
        String move="";
        for(int i=0;i<possibleMoves.length;i++)
        {
            move+="|"+ b.translateToInt(possibleMoves[i]);
        }

        String ans = ans1+"";
        System.out.println(b);
        System.out.println(b.translate(ans));
        assertTrue(move.contains(ans));
    }





}
