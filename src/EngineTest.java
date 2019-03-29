import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class EngineTest {

    /**
     * A method that will switch all the peices colors.   All black peices become white and all white peices become black.  It will also flip whoose turn it is
     *
     * @param fen
     * @return
     */
    public static String flipColors(String input) {
        String temp[] = input.split(" ");
        String fen = temp[0];
        String upper = fen.toUpperCase();
        String lower = fen.toLowerCase();
        String ans="";
        for(int i=0;i<fen.length();i++)
        {
            if(fen.charAt(i)==upper.charAt(i))
            {
                ans+=lower.charAt(i);
            }
            else
            {
                ans+=upper.charAt(i);
            }
        }
        ans +=" ";
        if(temp[1].equalsIgnoreCase("B"))
        {
            ans+="w";
        }
        else
        {
            ans+="b";
        }
        for(int i=2;i<temp.length;i++)
        {
            ans+=" "+temp[i];
        }
        return ans;
    }

    @BeforeMethod
    public void setup() {
        //setup zobrist keys before the start of each test
        Zobrist.zobristFillArray();
        MinMax.clear();
    }

    @Test
    public void switch1() {
        String fen = "K7/R2r3r1/8/8/3k4/8/8/8 b - - 0 1";
        String ans = "k7/r2R3R1/8/8/3K4/8/8/8 w - - 0 1";
        assertEquals(ans, flipColors(fen));
    }

    @Test
    public void position1() {
        for(int depth=3;depth<6;depth++) {
            String fen = "k7/r2R3R1/8/8/3K4/8/8/8 w - - 0 1 ";
            Board b = new Board(fen);
            System.out.println(b);
            MinMax.minMax(depth, b, true, depth, "");
            System.out.println(MinMax.best);
            int ans1 = Integer.parseInt(MinMax.best.substring(6, 11));
            String[] possibleMoves = {"d7d8,h7h8"};
            String move = "";
            for (int i = 0; i < possibleMoves.length; i++) {
                move += "|" + Board.translateToInt(possibleMoves[i]);
            }

            String ans = ans1 + "";
            System.out.println(b);
            System.out.println(b.translate(ans));
            assertTrue(move.contains(ans), "White's moves at depth " + depth);

            String fen2 = flipColors(fen);
            Board b2 = new Board(fen2);
            MinMax.minMax(depth, b2, false, depth, "");
            int ans2 = Integer.parseInt(MinMax.best.substring(6, 11));
            assertTrue(move.contains(ans2 + ""), "Blacks's moves at depth " + depth);
        }
    }

    @Test
    public void position2() {
        for(int depth=3;depth<6;depth++) {
            String fen = "k7/r2R3R1/8/8/3K4/8/8/8 w - - 0 1 ";
            Board b = new Board(fen);
            System.out.println(b);
            MinMax.minMax(depth, b, true, depth, "");
            System.out.println(MinMax.best);
            int ans1 = Integer.parseInt(MinMax.best.substring(6, 11));
            String[] possibleMoves = {"d7d8,h7h8"};
            String move = "";
            for (int i = 0; i < possibleMoves.length; i++) {
                move += "|" + Board.translateToInt(possibleMoves[i]);
            }

            String ans = ans1 + "";
            System.out.println(b);
            System.out.println(b.translate(ans));
            assertTrue(move.contains(ans), "White's moves at depth " + depth);

            String fen2 = flipColors(fen);
            Board b2 = new Board(fen2);
            MinMax.minMax(depth, b2, false, depth, "");
            int ans2 = Integer.parseInt(MinMax.best.substring(6, 11));
            assertTrue(move.contains(ans2 + ""), "Blacks's moves at depth " + depth);
        }
    }

    @Test
    public void position3() {
        for(int depth=1;depth<6;depth++) {
            String fen = "k7/P1b5/KP6/8/8/8/8/8 w - - 0 1 ";
            Board b = new Board(fen);
            System.out.println(b);
            MinMax.minMax(depth, b, true, depth, "");
            System.out.println(MinMax.best);
            int ans1 = Integer.parseInt(MinMax.best.substring(6, 11));
            String[] possibleMoves = {"b6b7"};
            String move = "";
            for (int i = 0; i < possibleMoves.length; i++) {
                move += "|" + Board.translateToInt(possibleMoves[i]);
            }

            String ans = ans1 + "";
            System.out.println(b);
            System.out.println(b.translate(ans));
            assertTrue(move.contains(ans), "White's moves at depth " + depth);
        }
    }

    @Test
    public void position4() {
        for(int depth=1;depth<6;depth++) {
            String fen = "k7/P1q5/KP6/8/8/8/8/8 w - - 0 1 ";
            Board b = new Board(fen);
            System.out.println(b);
            MinMax.minMax(depth, b, true, depth, "");
            System.out.println(MinMax.best);
            int ans1 = Integer.parseInt(MinMax.best.substring(6, 11));
            String[] possibleMoves = {"b6c7"};
            String move = "";
            for (int i = 0; i < possibleMoves.length; i++) {
                move += "|" + Board.translateToInt(possibleMoves[i]);
            }

            String ans = ans1 + "";
            System.out.println(b);
            System.out.println(b.translate(ans));
            assertTrue(move.contains(ans), "White's moves at depth " + depth);
        }
    }

    @Test
    public void position5() {
        for(int depth=4;depth<6;depth++) {
            String fen = "r2qkb1r/pp2nppp/3p4/2pNN1B1/2BnP3/3P4/PPP2PPP/R2bK2R w KQkq - 1 0";
            Board b = new Board(fen);
            System.out.println(b);
            MinMax.minMax(depth, b, true, depth, "");
            System.out.println(MinMax.best);
            int ans1 = Integer.parseInt(MinMax.best.substring(6, 11));
            String[] possibleMoves = {"d5f6"};
            String move = "";
            for (int i = 0; i < possibleMoves.length; i++) {
                move += "|" + Board.translateToInt(possibleMoves[i]);
            }

            String ans = ans1 + "";
            System.out.println(b);
            System.out.println(b.translate(ans));
            assertTrue(move.contains(ans), "White's moves at depth " + depth);
        }
    }







}
