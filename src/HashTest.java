import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.HashMap;

public class HashTest {
    private HashMap<Long, Long> perftHash = new HashMap<Long, Long>();

    public String divide(Board board, int depth) {
        System.out.println("Divide for board :" + board.getFEN()
                + "\n\t Depth: " + depth);
        ArrayList<Integer> moveList = board.generateMovesNeo(true);
        String[] ary1 = new String[moveList.size()];
        long[] count = new long[ary1.length];
        String answer = "";
        int temp = 0;
        if (!(moveList.size() == 0)) {
            for (int i = 0; i < moveList.size(); i++) {
                ary1[temp] = board.translate("" + moveList.get(i));
                board.move(moveList.get(i));
                count[temp] = diveIn(board, depth - 1);
                board.undo();
                temp++;
            }
            int sum = 0;
            for (int i = 0; i < ary1.length; i++) {
                answer += ary1[i] + ": " + count[i] + "\n";
                sum += count[i];
            }
            answer += "\n Moves: " + ary1.length + "\n Nodes: " + sum;
        }
        return answer;
    }

    public String divideFull(Board board, int depth) {
        System.out.println("DivideFull for board :" + board.getFEN()
                + "\n\t Depth: " + depth);
        ArrayList<Integer> moveList = board.generateMovesNeo(true);
        String[] ary1 = new String[moveList.size()];
        long[] count = new long[ary1.length];
        String answer = "";
        int temp = 0;
        if (!(moveList.size() == 0)) {
            for (int i = 0; i < moveList.size(); i++) {
                ary1[temp] = board.translate("" + moveList.get(i));
                board.move(moveList.get(i));
                count[temp] = diveIn(board, depth - 1);
                board.undo();
                temp++;
            }
            int sum = 0;
            for (int i = 0; i < ary1.length; i++) {
                answer += ary1[i] + ": " + count[i] + "\n";
                sum += count[i];
            }
            answer += "\n Moves: " + ary1.length + "\n Nodes: " + sum;
        }
        return answer;
    }

    private long perftFull(Board board, int depth) {
        ArrayList<Integer> moveList = board.generateMovesNeo(true);
        if (depth == 1)
            return moveList.size();
        long nodes = 0;
        if (!moveList.equals("")) {
            for (int i = 0; i < moveList.size(); i++) {
                board.move(moveList.get(i));
                nodes += diveInFull(board,depth - 1);
                board.undo();
            }
        }
        return nodes;
    }

    private long diveInFull(Board board, int depth) {
        ArrayList<Integer> moveList = board.generateMovesNeo(true);
        if (moveList.size() == 0 && depth != 0) {
            return 0;
        } else if (moveList.size() == 0 || depth == 1) {
            return moveList.size();
        }
        long nodes = 0;
        if (depth == 0) {
            return 1;
        }

        if (!moveList.equals("")) {
            for (int i = 0; i < moveList.size(); i++) {
                board.move(moveList.get(i));
                nodes += diveInFull(board, depth - 1);
                board.undo();
            }
        }
        return nodes;
    }

    private long perft(Board board, int depth) {
        ArrayList<Integer> moveList = board.generateMovesNeo(true);
        long key = board.zobristKey() ^ Zobrist.zdepgth[depth];
        if(perftHash.containsKey(key))
        {
            System.out.println("We've been here already");
            return perftHash.get(key);
        }
        if (depth == 1) {

            perftHash.put(key, (long) moveList.size());
            return moveList.size();
        }
        long nodes = 0;
        if (!moveList.equals("")) {
            for (int i = 0; i < moveList.size(); i++) {
                board.move(moveList.get(i));
                nodes += diveIn(board,depth - 1);
                board.undo();
            }
        }
        perftHash.put(key, nodes);
        return nodes;
    }

    private long diveIn(Board board, int depth) {
        ArrayList<Integer> moveList = board.generateMovesNeo(true);
        long key = board.zobristKey() ^ Zobrist.zdepgth[depth];
        if(perftHash.containsKey(key))
        {
                return perftHash.get(key);
        }
        if (moveList.size() == 0 && depth != 0) {
            perftHash.put(key, 0L);
            return 0;
        } else if (moveList.size() == 0 || depth == 1) {
            perftHash.put(key, (long) moveList.size());
            return moveList.size();
        }
        long nodes = 0;
        if (depth == 0) {
            perftHash.put(key, 1L);
            return 1;
        }

        if (!moveList.equals("")) {
            for (int i = 0; i < moveList.size(); i++) {
                board.move(moveList.get(i));
                nodes += diveIn(board, depth - 1);
                board.undo();
            }
        }
        perftHash.put(key, nodes);
        return nodes;
    }
    @BeforeMethod
    public void setupEach()
    {
        perftHash = new HashMap<Long, Long>();
        MinMax.clear();
    }

    @BeforeSuite
    public void setup()
    {
        System.out.println("STARTING");
        Zobrist.zobristFillArray();
    }



//    @Parameters({"board", "depth","score"})
//    @Test
//    public void perft(String board, int depth, long score)
//    {
//        Board b = new Board(board);
//        Assert.assertEquals(score, perft(b,depth));
//    }
    @Test
    public void perft1_1(){
        Board b = new Board("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
        Assert.assertEquals(perft(b,1),20);
    }

    @Test(dependsOnMethods = { "perft1_1" })
    public void perft1_2(){
        Board b = new Board("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
        Assert.assertEquals(perft(b,2),400);
    }

    @Test(dependsOnMethods = { "perft1_2" })
    public void perft1_3(){
        Board b = new Board("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
        Assert.assertEquals(perft(b,3),8902);
    }

    @Test(dependsOnMethods = { "perft1_3" })
    public void perft1_4(){
        Board b = new Board("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
        Assert.assertEquals(perft(b,4),197281);
    }

    @Test(dependsOnMethods = { "perft1_4" })
    public void perft1_5(){
        Board b = new Board("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
        Assert.assertEquals(perft(b,5),4865609);
    }

    @Test(dependsOnMethods = { "perft1_5" })
    public void perft1_6(){
        Board b = new Board("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
        Assert.assertEquals(perft(b,6),119060324);
    }

    @Test
    public void perft2_1(){
        Board b = new Board("3k4/3p4/8/K1P4r/8/8/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,1),18);
    }

    @Test(dependsOnMethods = { "perft2_1" })
    public void perft2_2(){
        Board b = new Board("3k4/3p4/8/K1P4r/8/8/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,2),92);
    }

    @Test(dependsOnMethods = { "perft2_2" })
    public void perft2_3(){
        Board b = new Board("3k4/3p4/8/K1P4r/8/8/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,3),1670);
    }

    @Test(dependsOnMethods = { "perft2_3" })
    public void perft2_4(){
        Board b = new Board("3k4/3p4/8/K1P4r/8/8/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,4),10138);
    }

    @Test(dependsOnMethods = { "perft2_4" })
    public void perft2_5(){
        Board b = new Board("3k4/3p4/8/K1P4r/8/8/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,5),185429);
    }

    @Test(dependsOnMethods = { "perft2_5" })
    public void perft2_6(){
        Board b = new Board("3k4/3p4/8/K1P4r/8/8/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,6),1134888);
    }

    @Test
    public void perft3_1(){
        Board b = new Board("4k3/8/8/8/8/8/8/4K2R w K - 0 1");
        Assert.assertEquals(perft(b,1),15);
    }

    @Test(dependsOnMethods = { "perft3_1" })
    public void perft3_2(){
        Board b = new Board("4k3/8/8/8/8/8/8/4K2R w K - 0 1");
        Assert.assertEquals(perft(b,2),66);
    }

    @Test(dependsOnMethods = { "perft3_2" })
    public void perft3_3(){
        Board b = new Board("4k3/8/8/8/8/8/8/4K2R w K - 0 1");
        Assert.assertEquals(perft(b,3),1197);
    }

    @Test(dependsOnMethods = { "perft3_3" })
    public void perft3_4(){
        Board b = new Board("4k3/8/8/8/8/8/8/4K2R w K - 0 1");
        Assert.assertEquals(perft(b,4),7059);
    }

    @Test(dependsOnMethods = { "perft3_4" })
    public void perft3_5(){
        Board b = new Board("4k3/8/8/8/8/8/8/4K2R w K - 0 1");
        Assert.assertEquals(perft(b,5),133987);
    }

    @Test(dependsOnMethods = { "perft3_5" })
    public void perft3_6(){
        Board b = new Board("4k3/8/8/8/8/8/8/4K2R w K - 0 1");
        Assert.assertEquals(perft(b,6),764643);
    }

    @Test
    public void perft4_1(){
        Board b = new Board("4k3/8/8/8/8/8/8/R3K3 w Q - 0 1");
        Assert.assertEquals(perft(b,1),16);
    }

    @Test(dependsOnMethods = { "perft4_1" })
    public void perft4_2(){
        Board b = new Board("4k3/8/8/8/8/8/8/R3K3 w Q - 0 1");
        Assert.assertEquals(perft(b,2),71);
    }

    @Test(dependsOnMethods = { "perft4_2" })
    public void perft4_3(){
        Board b = new Board("4k3/8/8/8/8/8/8/R3K3 w Q - 0 1");
        Assert.assertEquals(perft(b,3),1287);
    }

    @Test(dependsOnMethods = { "perft4_3" })
    public void perft4_4(){
        Board b = new Board("4k3/8/8/8/8/8/8/R3K3 w Q - 0 1");
        Assert.assertEquals(perft(b,4),7626);
    }

    @Test(dependsOnMethods = { "perft4_4" })
    public void perft4_5(){
        Board b = new Board("4k3/8/8/8/8/8/8/R3K3 w Q - 0 1");
        Assert.assertEquals(perft(b,5),145232);
    }

    @Test(dependsOnMethods = { "perft4_5" })
    public void perft4_6(){
        Board b = new Board("4k3/8/8/8/8/8/8/R3K3 w Q - 0 1");
        Assert.assertEquals(perft(b,6),846648);
    }

    @Test
    public void perft5_1(){
        Board b = new Board("4k2r/8/8/8/8/8/8/4K3 w k - 0 1");
        Assert.assertEquals(perft(b,1),5);
    }

    @Test(dependsOnMethods = { "perft5_1" })
    public void perft5_2(){
        Board b = new Board("4k2r/8/8/8/8/8/8/4K3 w k - 0 1");
        Assert.assertEquals(perft(b,2),75);
    }

    @Test(dependsOnMethods = { "perft5_2" })
    public void perft5_3(){
        Board b = new Board("4k2r/8/8/8/8/8/8/4K3 w k - 0 1");
        Assert.assertEquals(perft(b,3),459);
    }

    @Test(dependsOnMethods = { "perft5_3" })
    public void perft5_4(){
        Board b = new Board("4k2r/8/8/8/8/8/8/4K3 w k - 0 1");
        Assert.assertEquals(perft(b,4),8290);
    }

    @Test(dependsOnMethods = { "perft5_4" })
    public void perft5_5(){
        Board b = new Board("4k2r/8/8/8/8/8/8/4K3 w k - 0 1");
        Assert.assertEquals(perft(b,5),47635);
    }

    @Test(dependsOnMethods = { "perft5_5" })
    public void perft5_6(){
        Board b = new Board("4k2r/8/8/8/8/8/8/4K3 w k - 0 1");
        Assert.assertEquals(perft(b,6),899442);
    }

    @Test
    public void perft6_1(){
        Board b = new Board("r3k3/8/8/8/8/8/8/4K3 w q - 0 1");
        Assert.assertEquals(perft(b,1),5);
    }

    @Test(dependsOnMethods = { "perft6_1" })
    public void perft6_2(){
        Board b = new Board("r3k3/8/8/8/8/8/8/4K3 w q - 0 1");
        Assert.assertEquals(perft(b,2),80);
    }

    @Test(dependsOnMethods = { "perft6_2" })
    public void perft6_3(){
        Board b = new Board("r3k3/8/8/8/8/8/8/4K3 w q - 0 1");
        Assert.assertEquals(perft(b,3),493);
    }

    @Test(dependsOnMethods = { "perft6_3" })
    public void perft6_4(){
        Board b = new Board("r3k3/8/8/8/8/8/8/4K3 w q - 0 1");
        Assert.assertEquals(perft(b,4),8897);
    }

    @Test(dependsOnMethods = { "perft6_4" })
    public void perft6_5(){
        Board b = new Board("r3k3/8/8/8/8/8/8/4K3 w q - 0 1");
        Assert.assertEquals(perft(b,5),52710);
    }

    @Test(dependsOnMethods = { "perft6_5" })
    public void perft6_6(){
        Board b = new Board("r3k3/8/8/8/8/8/8/4K3 w q - 0 1");
        Assert.assertEquals(perft(b,6),1001523);
    }

    @Test
    public void perft7_1(){
        Board b = new Board("4k3/8/8/8/8/8/8/R3K2R w KQ - 0 1");
        Assert.assertEquals(perft(b,1),26);
    }

    @Test(dependsOnMethods = { "perft7_1" })
    public void perft7_2(){
        Board b = new Board("4k3/8/8/8/8/8/8/R3K2R w KQ - 0 1");
        Assert.assertEquals(perft(b,2),112);
    }

    @Test(dependsOnMethods = { "perft7_2" })
    public void perft7_3(){
        Board b = new Board("4k3/8/8/8/8/8/8/R3K2R w KQ - 0 1");
        Assert.assertEquals(perft(b,3),3189);
    }

    @Test(dependsOnMethods = { "perft7_3" })
    public void perft7_4(){
        Board b = new Board("4k3/8/8/8/8/8/8/R3K2R w KQ - 0 1");
        Assert.assertEquals(perft(b,4),17945);
    }

    @Test(dependsOnMethods = { "perft7_4" })
    public void perft7_5(){
        Board b = new Board("4k3/8/8/8/8/8/8/R3K2R w KQ - 0 1");
        Assert.assertEquals(perft(b,5),532933);
    }

    @Test(dependsOnMethods = { "perft7_5" })
    public void perft7_6(){
        Board b = new Board("4k3/8/8/8/8/8/8/R3K2R w KQ - 0 1");
        Assert.assertEquals(perft(b,6),2788982);
    }

    @Test
    public void perft8_1(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/4K3 w kq - 0 1");
        Assert.assertEquals(perft(b,1),5);
    }

    @Test(dependsOnMethods = { "perft8_1" })
    public void perft8_2(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/4K3 w kq - 0 1");
        Assert.assertEquals(perft(b,2),130);
    }

    @Test(dependsOnMethods = { "perft8_2" })
    public void perft8_3(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/4K3 w kq - 0 1");
        Assert.assertEquals(perft(b,3),782);
    }

    @Test(dependsOnMethods = { "perft8_3" })
    public void perft8_4(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/4K3 w kq - 0 1");
        Assert.assertEquals(perft(b,4),22180);
    }

    @Test(dependsOnMethods = { "perft8_4" })
    public void perft8_5(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/4K3 w kq - 0 1");
        Assert.assertEquals(perft(b,5),118882);
    }

    @Test(dependsOnMethods = { "perft8_5" })
    public void perft8_6(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/4K3 w kq - 0 1");
        Assert.assertEquals(perft(b,6),3517770);
    }

    @Test
    public void perft9_1(){
        Board b = new Board("8/8/8/8/8/8/6k1/4K2R w K - 0 1");
        Assert.assertEquals(perft(b,1),12);
    }

    @Test(dependsOnMethods = { "perft9_1" })
    public void perft9_2(){
        Board b = new Board("8/8/8/8/8/8/6k1/4K2R w K - 0 1");
        Assert.assertEquals(perft(b,2),38);
    }

    @Test(dependsOnMethods = { "perft9_2" })
    public void perft9_3(){
        Board b = new Board("8/8/8/8/8/8/6k1/4K2R w K - 0 1");
        Assert.assertEquals(perft(b,3),564);
    }

    @Test(dependsOnMethods = { "perft9_3" })
    public void perft9_4(){
        Board b = new Board("8/8/8/8/8/8/6k1/4K2R w K - 0 1");
        Assert.assertEquals(perft(b,4),2219);
    }

    @Test(dependsOnMethods = { "perft9_4" })
    public void perft9_5(){
        Board b = new Board("8/8/8/8/8/8/6k1/4K2R w K - 0 1");
        Assert.assertEquals(perft(b,5),37735);
    }

    @Test(dependsOnMethods = { "perft9_5" })
    public void perft9_6(){
        Board b = new Board("8/8/8/8/8/8/6k1/4K2R w K - 0 1");
        Assert.assertEquals(perft(b,6),185867);
    }

    @Test
    public void perft10_1(){
        Board b = new Board("8/8/8/8/8/8/1k6/R3K3 w Q - 0 1");
        Assert.assertEquals(perft(b,1),15);
    }

    @Test(dependsOnMethods = { "perft10_1" })
    public void perft10_2(){
        Board b = new Board("8/8/8/8/8/8/1k6/R3K3 w Q - 0 1");
        Assert.assertEquals(perft(b,2),65);
    }

    @Test(dependsOnMethods = { "perft10_2" })
    public void perft10_3(){
        Board b = new Board("8/8/8/8/8/8/1k6/R3K3 w Q - 0 1");
        Assert.assertEquals(perft(b,3),1018);
    }

    @Test(dependsOnMethods = { "perft10_3" })
    public void perft10_4(){
        Board b = new Board("8/8/8/8/8/8/1k6/R3K3 w Q - 0 1");
        Assert.assertEquals(perft(b,4),4573);
    }

    @Test(dependsOnMethods = { "perft10_4" })
    public void perft10_5(){
        Board b = new Board("8/8/8/8/8/8/1k6/R3K3 w Q - 0 1");
        Assert.assertEquals(perft(b,5),80619);
    }

    @Test(dependsOnMethods = { "perft10_5" })
    public void perft10_6(){
        Board b = new Board("8/8/8/8/8/8/1k6/R3K3 w Q - 0 1");
        Assert.assertEquals(perft(b,6),413018);
    }

    @Test
    public void perft11_1(){
        Board b = new Board("4k2r/6K1/8/8/8/8/8/8 w k - 0 1");
        Assert.assertEquals(perft(b,1),3);
    }

    @Test(dependsOnMethods = { "perft11_1" })
    public void perft11_2(){
        Board b = new Board("4k2r/6K1/8/8/8/8/8/8 w k - 0 1");
        Assert.assertEquals(perft(b,2),32);
    }

    @Test(dependsOnMethods = { "perft11_2" })
    public void perft11_3(){
        Board b = new Board("4k2r/6K1/8/8/8/8/8/8 w k - 0 1");
        Assert.assertEquals(perft(b,3),134);
    }

    @Test(dependsOnMethods = { "perft11_3" })
    public void perft11_4(){
        Board b = new Board("4k2r/6K1/8/8/8/8/8/8 w k - 0 1");
        Assert.assertEquals(perft(b,4),2073);
    }

    @Test(dependsOnMethods = { "perft11_4" })
    public void perft11_5(){
        Board b = new Board("4k2r/6K1/8/8/8/8/8/8 w k - 0 1");
        Assert.assertEquals(perft(b,5),10485);
    }

    @Test(dependsOnMethods = { "perft11_5" })
    public void perft11_6(){
        Board b = new Board("4k2r/6K1/8/8/8/8/8/8 w k - 0 1");
        Assert.assertEquals(perft(b,6),179869);
    }

    @Test
    public void perft12_1(){
        Board b = new Board("r3k3/1K6/8/8/8/8/8/8 w q - 0 1");
        Assert.assertEquals(perft(b,1),4);
    }

    @Test(dependsOnMethods = { "perft12_1" })
    public void perft12_2(){
        Board b = new Board("r3k3/1K6/8/8/8/8/8/8 w q - 0 1");
        Assert.assertEquals(perft(b,2),49);
    }

    @Test(dependsOnMethods = { "perft12_2" })
    public void perft12_3(){
        Board b = new Board("r3k3/1K6/8/8/8/8/8/8 w q - 0 1");
        Assert.assertEquals(perft(b,3),243);
    }

    @Test(dependsOnMethods = { "perft12_3" })
    public void perft12_4(){
        Board b = new Board("r3k3/1K6/8/8/8/8/8/8 w q - 0 1");
        Assert.assertEquals(perft(b,4),3991);
    }

    @Test(dependsOnMethods = { "perft12_4" })
    public void perft12_5(){
        Board b = new Board("r3k3/1K6/8/8/8/8/8/8 w q - 0 1");
        Assert.assertEquals(perft(b,5),20780);
    }

    @Test(dependsOnMethods = { "perft12_5" })
    public void perft12_6(){
        Board b = new Board("r3k3/1K6/8/8/8/8/8/8 w q - 0 1");
        Assert.assertEquals(perft(b,6),367724);
    }

    @Test
    public void perft13_1(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K2R w KQkq - 0 1");
        Assert.assertEquals(perft(b,1),26);
    }

    @Test(dependsOnMethods = { "perft13_1" })
    public void perft13_2(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K2R w KQkq - 0 1");
        Assert.assertEquals(perft(b,2),568);
    }

    @Test(dependsOnMethods = { "perft13_2" })
    public void perft13_3(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K2R w KQkq - 0 1");
        Assert.assertEquals(perft(b,3),13744);
    }

    @Test(dependsOnMethods = { "perft13_3" })
    public void perft13_4(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K2R w KQkq - 0 1");
        Assert.assertEquals(perft(b,4),314346);
    }

    @Test(dependsOnMethods = { "perft13_4" })
    public void perft13_5(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K2R w KQkq - 0 1");
        Assert.assertEquals(perft(b,5),7594526);
    }

    @Test(dependsOnMethods = { "perft13_5" })
    public void perft13_6(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K2R w KQkq - 0 1");
        Assert.assertEquals(perft(b,6),179862938);
    }

    @Test
    public void perft14_1(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/1R2K2R w Kkq - 0 1");
        Assert.assertEquals(perft(b,1),25);
    }

    @Test(dependsOnMethods = { "perft14_1" })
    public void perft14_2(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/1R2K2R w Kkq - 0 1");
        Assert.assertEquals(perft(b,2),567);
    }

    @Test(dependsOnMethods = { "perft14_2" })
    public void perft14_3(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/1R2K2R w Kkq - 0 1");
        Assert.assertEquals(perft(b,3),14095);
    }

    @Test(dependsOnMethods = { "perft14_3" })
    public void perft14_4(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/1R2K2R w Kkq - 0 1");
        Assert.assertEquals(perft(b,4),328965);
    }

    @Test(dependsOnMethods = { "perft14_4" })
    public void perft14_5(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/1R2K2R w Kkq - 0 1");
        Assert.assertEquals(perft(b,5),8153719);
    }

    @Test(dependsOnMethods = { "perft14_5" })
    public void perft14_6(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/1R2K2R w Kkq - 0 1");
        Assert.assertEquals(perft(b,6),195629489);
    }

    @Test
    public void perft15_1(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/2R1K2R w Kkq - 0 1");
        Assert.assertEquals(perft(b,1),25);
    }

    @Test(dependsOnMethods = { "perft15_1" })
    public void perft15_2(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/2R1K2R w Kkq - 0 1");
        Assert.assertEquals(perft(b,2),548);
    }

    @Test(dependsOnMethods = { "perft15_2" })
    public void perft15_3(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/2R1K2R w Kkq - 0 1");
        Assert.assertEquals(perft(b,3),13502);
    }

    @Test(dependsOnMethods = { "perft15_3" })
    public void perft15_4(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/2R1K2R w Kkq - 0 1");
        Assert.assertEquals(perft(b,4),312835);
    }

    @Test(dependsOnMethods = { "perft15_4" })
    public void perft15_5(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/2R1K2R w Kkq - 0 1");
        Assert.assertEquals(perft(b,5),7736373);
    }

    @Test(dependsOnMethods = { "perft15_5" })
    public void perft15_6(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/2R1K2R w Kkq - 0 1");
        Assert.assertEquals(perft(b,6),184411439);
    }

    @Test
    public void perft16_1(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K1R1 w Qkq - 0 1");
        Assert.assertEquals(perft(b,1),25);
    }

    @Test(dependsOnMethods = { "perft16_1" })
    public void perft16_2(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K1R1 w Qkq - 0 1");
        Assert.assertEquals(perft(b,2),547);
    }

    @Test(dependsOnMethods = { "perft16_2" })
    public void perft16_3(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K1R1 w Qkq - 0 1");
        Assert.assertEquals(perft(b,3),13579);
    }

    @Test(dependsOnMethods = { "perft16_3" })
    public void perft16_4(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K1R1 w Qkq - 0 1");
        Assert.assertEquals(perft(b,4),316214);
    }

    @Test(dependsOnMethods = { "perft16_4" })
    public void perft16_5(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K1R1 w Qkq - 0 1");
        Assert.assertEquals(perft(b,5),7878456);
    }

    @Test(dependsOnMethods = { "perft16_5" })
    public void perft16_6(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K1R1 w Qkq - 0 1");
        Assert.assertEquals(perft(b,6),189224276);
    }

    @Test
    public void perft17_1(){
        Board b = new Board("1r2k2r/8/8/8/8/8/8/R3K2R w KQk - 0 1");
        Assert.assertEquals(perft(b,1),26);
    }

    @Test(dependsOnMethods = { "perft17_1" })
    public void perft17_2(){
        Board b = new Board("1r2k2r/8/8/8/8/8/8/R3K2R w KQk - 0 1");
        Assert.assertEquals(perft(b,2),583);
    }

    @Test(dependsOnMethods = { "perft17_2" })
    public void perft17_3(){
        Board b = new Board("1r2k2r/8/8/8/8/8/8/R3K2R w KQk - 0 1");
        Assert.assertEquals(perft(b,3),14252);
    }

    @Test(dependsOnMethods = { "perft17_3" })
    public void perft17_4(){
        Board b = new Board("1r2k2r/8/8/8/8/8/8/R3K2R w KQk - 0 1");
        Assert.assertEquals(perft(b,4),334705);
    }

    @Test(dependsOnMethods = { "perft17_4" })
    public void perft17_5(){
        Board b = new Board("1r2k2r/8/8/8/8/8/8/R3K2R w KQk - 0 1");
        Assert.assertEquals(perft(b,5),8198901);
    }

    @Test(dependsOnMethods = { "perft17_5" })
    public void perft17_6(){
        Board b = new Board("1r2k2r/8/8/8/8/8/8/R3K2R w KQk - 0 1");
        Assert.assertEquals(perft(b,6),198328929);
    }

    @Test
    public void perft18_1(){
        Board b = new Board("2r1k2r/8/8/8/8/8/8/R3K2R w KQk - 0 1");
        Assert.assertEquals(perft(b,1),25);
    }

    @Test(dependsOnMethods = { "perft18_1" })
    public void perft18_2(){
        Board b = new Board("2r1k2r/8/8/8/8/8/8/R3K2R w KQk - 0 1");
        Assert.assertEquals(perft(b,2),560);
    }

    @Test(dependsOnMethods = { "perft18_2" })
    public void perft18_3(){
        Board b = new Board("2r1k2r/8/8/8/8/8/8/R3K2R w KQk - 0 1");
        Assert.assertEquals(perft(b,3),13592);
    }

    @Test(dependsOnMethods = { "perft18_3" })
    public void perft18_4(){
        Board b = new Board("2r1k2r/8/8/8/8/8/8/R3K2R w KQk - 0 1");
        Assert.assertEquals(perft(b,4),317324);
    }

    @Test(dependsOnMethods = { "perft18_4" })
    public void perft18_5(){
        Board b = new Board("2r1k2r/8/8/8/8/8/8/R3K2R w KQk - 0 1");
        Assert.assertEquals(perft(b,5),7710115);
    }

    @Test(dependsOnMethods = { "perft18_5" })
    public void perft18_6(){
        Board b = new Board("2r1k2r/8/8/8/8/8/8/R3K2R w KQk - 0 1");
        Assert.assertEquals(perft(b,6),185959088);
    }

    @Test
    public void perft19_1(){
        Board b = new Board("r3k1r1/8/8/8/8/8/8/R3K2R w KQq - 0 1");
        Assert.assertEquals(perft(b,1),25);
    }

    @Test(dependsOnMethods = { "perft19_1" })
    public void perft19_2(){
        Board b = new Board("r3k1r1/8/8/8/8/8/8/R3K2R w KQq - 0 1");
        Assert.assertEquals(perft(b,2),560);
    }

    @Test(dependsOnMethods = { "perft19_2" })
    public void perft19_3(){
        Board b = new Board("r3k1r1/8/8/8/8/8/8/R3K2R w KQq - 0 1");
        Assert.assertEquals(perft(b,3),13607);
    }

    @Test(dependsOnMethods = { "perft19_3" })
    public void perft19_4(){
        Board b = new Board("r3k1r1/8/8/8/8/8/8/R3K2R w KQq - 0 1");
        Assert.assertEquals(perft(b,4),320792);
    }

    @Test(dependsOnMethods = { "perft19_4" })
    public void perft19_5(){
        Board b = new Board("r3k1r1/8/8/8/8/8/8/R3K2R w KQq - 0 1");
        Assert.assertEquals(perft(b,5),7848606);
    }

    @Test(dependsOnMethods = { "perft19_5" })
    public void perft19_6(){
        Board b = new Board("r3k1r1/8/8/8/8/8/8/R3K2R w KQq - 0 1");
        Assert.assertEquals(perft(b,6),190755813);
    }

    @Test
    public void perft20_1(){
        Board b = new Board("4k3/8/8/8/8/8/8/4K2R b K - 0 1");
        Assert.assertEquals(perft(b,1),5);
    }

    @Test(dependsOnMethods = { "perft20_1" })
    public void perft20_2(){
        Board b = new Board("4k3/8/8/8/8/8/8/4K2R b K - 0 1");
        Assert.assertEquals(perft(b,2),75);
    }

    @Test(dependsOnMethods = { "perft20_2" })
    public void perft20_3(){
        Board b = new Board("4k3/8/8/8/8/8/8/4K2R b K - 0 1");
        Assert.assertEquals(perft(b,3),459);
    }

    @Test(dependsOnMethods = { "perft20_3" })
    public void perft20_4(){
        Board b = new Board("4k3/8/8/8/8/8/8/4K2R b K - 0 1");
        Assert.assertEquals(perft(b,4),8290);
    }

    @Test(dependsOnMethods = { "perft20_4" })
    public void perft20_5(){
        Board b = new Board("4k3/8/8/8/8/8/8/4K2R b K - 0 1");
        Assert.assertEquals(perft(b,5),47635);
    }

    @Test(dependsOnMethods = { "perft20_5" })
    public void perft20_6(){
        Board b = new Board("4k3/8/8/8/8/8/8/4K2R b K - 0 1");
        Assert.assertEquals(perft(b,6),899442);
    }

    @Test
    public void perft21_1(){
        Board b = new Board("4k3/8/8/8/8/8/8/R3K3 b Q - 0 1");
        Assert.assertEquals(perft(b,1),5);
    }

    @Test(dependsOnMethods = { "perft21_1" })
    public void perft21_2(){
        Board b = new Board("4k3/8/8/8/8/8/8/R3K3 b Q - 0 1");
        Assert.assertEquals(perft(b,2),80);
    }

    @Test(dependsOnMethods = { "perft21_2" })
    public void perft21_3(){
        Board b = new Board("4k3/8/8/8/8/8/8/R3K3 b Q - 0 1");
        Assert.assertEquals(perft(b,3),493);
    }

    @Test(dependsOnMethods = { "perft21_3" })
    public void perft21_4(){
        Board b = new Board("4k3/8/8/8/8/8/8/R3K3 b Q - 0 1");
        Assert.assertEquals(perft(b,4),8897);
    }

    @Test(dependsOnMethods = { "perft21_4" })
    public void perft21_5(){
        Board b = new Board("4k3/8/8/8/8/8/8/R3K3 b Q - 0 1");
        Assert.assertEquals(perft(b,5),52710);
    }

    @Test(dependsOnMethods = { "perft21_5" })
    public void perft21_6(){
        Board b = new Board("4k3/8/8/8/8/8/8/R3K3 b Q - 0 1");
        Assert.assertEquals(perft(b,6),1001523);
    }

    @Test
    public void perft22_1(){
        Board b = new Board("4k2r/8/8/8/8/8/8/4K3 b k - 0 1");
        Assert.assertEquals(perft(b,1),15);
    }

    @Test(dependsOnMethods = { "perft22_1" })
    public void perft22_2(){
        Board b = new Board("4k2r/8/8/8/8/8/8/4K3 b k - 0 1");
        Assert.assertEquals(perft(b,2),66);
    }

    @Test(dependsOnMethods = { "perft22_2" })
    public void perft22_3(){
        Board b = new Board("4k2r/8/8/8/8/8/8/4K3 b k - 0 1");
        Assert.assertEquals(perft(b,3),1197);
    }

    @Test(dependsOnMethods = { "perft22_3" })
    public void perft22_4(){
        Board b = new Board("4k2r/8/8/8/8/8/8/4K3 b k - 0 1");
        Assert.assertEquals(perft(b,4),7059);
    }

    @Test(dependsOnMethods = { "perft22_4" })
    public void perft22_5(){
        Board b = new Board("4k2r/8/8/8/8/8/8/4K3 b k - 0 1");
        Assert.assertEquals(perft(b,5),133987);
    }

    @Test(dependsOnMethods = { "perft22_5" })
    public void perft22_6(){
        Board b = new Board("4k2r/8/8/8/8/8/8/4K3 b k - 0 1");
        Assert.assertEquals(perft(b,6),764643);
    }

    @Test
    public void perft23_1(){
        Board b = new Board("r3k3/8/8/8/8/8/8/4K3 b q - 0 1");
        Assert.assertEquals(perft(b,1),16);
    }

    @Test(dependsOnMethods = { "perft23_1" })
    public void perft23_2(){
        Board b = new Board("r3k3/8/8/8/8/8/8/4K3 b q - 0 1");
        Assert.assertEquals(perft(b,2),71);
    }

    @Test(dependsOnMethods = { "perft23_2" })
    public void perft23_3(){
        Board b = new Board("r3k3/8/8/8/8/8/8/4K3 b q - 0 1");
        Assert.assertEquals(perft(b,3),1287);
    }

    @Test(dependsOnMethods = { "perft23_3" })
    public void perft23_4(){
        Board b = new Board("r3k3/8/8/8/8/8/8/4K3 b q - 0 1");
        Assert.assertEquals(perft(b,4),7626);
    }

    @Test(dependsOnMethods = { "perft23_4" })
    public void perft23_5(){
        Board b = new Board("r3k3/8/8/8/8/8/8/4K3 b q - 0 1");
        Assert.assertEquals(perft(b,5),145232);
    }

    @Test(dependsOnMethods = { "perft23_5" })
    public void perft23_6(){
        Board b = new Board("r3k3/8/8/8/8/8/8/4K3 b q - 0 1");
        Assert.assertEquals(perft(b,6),846648);
    }

    @Test
    public void perft24_1(){
        Board b = new Board("4k3/8/8/8/8/8/8/R3K2R b KQ - 0 1");
        Assert.assertEquals(perft(b,1),5);
    }

    @Test(dependsOnMethods = { "perft24_1" })
    public void perft24_2(){
        Board b = new Board("4k3/8/8/8/8/8/8/R3K2R b KQ - 0 1");
        Assert.assertEquals(perft(b,2),130);
    }

    @Test(dependsOnMethods = { "perft24_2" })
    public void perft24_3(){
        Board b = new Board("4k3/8/8/8/8/8/8/R3K2R b KQ - 0 1");
        Assert.assertEquals(perft(b,3),782);
    }

    @Test(dependsOnMethods = { "perft24_3" })
    public void perft24_4(){
        Board b = new Board("4k3/8/8/8/8/8/8/R3K2R b KQ - 0 1");
        Assert.assertEquals(perft(b,4),22180);
    }

    @Test(dependsOnMethods = { "perft24_4" })
    public void perft24_5(){
        Board b = new Board("4k3/8/8/8/8/8/8/R3K2R b KQ - 0 1");
        Assert.assertEquals(perft(b,5),118882);
    }

    @Test(dependsOnMethods = { "perft24_5" })
    public void perft24_6(){
        Board b = new Board("4k3/8/8/8/8/8/8/R3K2R b KQ - 0 1");
        Assert.assertEquals(perft(b,6),3517770);
    }

    @Test
    public void perft25_1(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/4K3 b kq - 0 1");
        Assert.assertEquals(perft(b,1),26);
    }

    @Test(dependsOnMethods = { "perft25_1" })
    public void perft25_2(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/4K3 b kq - 0 1");
        Assert.assertEquals(perft(b,2),112);
    }

    @Test(dependsOnMethods = { "perft25_2" })
    public void perft25_3(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/4K3 b kq - 0 1");
        Assert.assertEquals(perft(b,3),3189);
    }

    @Test(dependsOnMethods = { "perft25_3" })
    public void perft25_4(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/4K3 b kq - 0 1");
        Assert.assertEquals(perft(b,4),17945);
    }

    @Test(dependsOnMethods = { "perft25_4" })
    public void perft25_5(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/4K3 b kq - 0 1");
        Assert.assertEquals(perft(b,5),532933);
    }

    @Test(dependsOnMethods = { "perft25_5" })
    public void perft25_6(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/4K3 b kq - 0 1");
        Assert.assertEquals(perft(b,6),2788982);
    }

    @Test
    public void perft26_1(){
        Board b = new Board("8/8/8/8/8/8/6k1/4K2R b K - 0 1");
        Assert.assertEquals(perft(b,1),3);
    }

    @Test(dependsOnMethods = { "perft26_1" })
    public void perft26_2(){
        Board b = new Board("8/8/8/8/8/8/6k1/4K2R b K - 0 1");
        Assert.assertEquals(perft(b,2),32);
    }

    @Test(dependsOnMethods = { "perft26_2" })
    public void perft26_3(){
        Board b = new Board("8/8/8/8/8/8/6k1/4K2R b K - 0 1");
        Assert.assertEquals(perft(b,3),134);
    }

    @Test(dependsOnMethods = { "perft26_3" })
    public void perft26_4(){
        Board b = new Board("8/8/8/8/8/8/6k1/4K2R b K - 0 1");
        Assert.assertEquals(perft(b,4),2073);
    }

    @Test(dependsOnMethods = { "perft26_4" })
    public void perft26_5(){
        Board b = new Board("8/8/8/8/8/8/6k1/4K2R b K - 0 1");
        Assert.assertEquals(perft(b,5),10485);
    }

    @Test(dependsOnMethods = { "perft26_5" })
    public void perft26_6(){
        Board b = new Board("8/8/8/8/8/8/6k1/4K2R b K - 0 1");
        Assert.assertEquals(perft(b,6),179869);
    }

    @Test
    public void perft27_1(){
        Board b = new Board("8/8/8/8/8/8/1k6/R3K3 b Q - 0 1");
        Assert.assertEquals(perft(b,1),4);
    }

    @Test(dependsOnMethods = { "perft27_1" })
    public void perft27_2(){
        Board b = new Board("8/8/8/8/8/8/1k6/R3K3 b Q - 0 1");
        Assert.assertEquals(perft(b,2),49);
    }

    @Test(dependsOnMethods = { "perft27_2" })
    public void perft27_3(){
        Board b = new Board("8/8/8/8/8/8/1k6/R3K3 b Q - 0 1");
        Assert.assertEquals(perft(b,3),243);
    }

    @Test(dependsOnMethods = { "perft27_3" })
    public void perft27_4(){
        Board b = new Board("8/8/8/8/8/8/1k6/R3K3 b Q - 0 1");
        Assert.assertEquals(perft(b,4),3991);
    }

    @Test(dependsOnMethods = { "perft27_4" })
    public void perft27_5(){
        Board b = new Board("8/8/8/8/8/8/1k6/R3K3 b Q - 0 1");
        Assert.assertEquals(perft(b,5),20780);
    }

    @Test(dependsOnMethods = { "perft27_5" })
    public void perft27_6(){
        Board b = new Board("8/8/8/8/8/8/1k6/R3K3 b Q - 0 1");
        Assert.assertEquals(perft(b,6),367724);
    }

    @Test
    public void perft28_1(){
        Board b = new Board("4k2r/6K1/8/8/8/8/8/8 b k - 0 1");
        Assert.assertEquals(perft(b,1),12);
    }

    @Test(dependsOnMethods = { "perft28_1" })
    public void perft28_2(){
        Board b = new Board("4k2r/6K1/8/8/8/8/8/8 b k - 0 1");
        Assert.assertEquals(perft(b,2),38);
    }

    @Test(dependsOnMethods = { "perft28_2" })
    public void perft28_3(){
        Board b = new Board("4k2r/6K1/8/8/8/8/8/8 b k - 0 1");
        Assert.assertEquals(perft(b,3),564);
    }

    @Test(dependsOnMethods = { "perft28_3" })
    public void perft28_4(){
        Board b = new Board("4k2r/6K1/8/8/8/8/8/8 b k - 0 1");
        Assert.assertEquals(perft(b,4),2219);
    }

    @Test(dependsOnMethods = { "perft28_4" })
    public void perft28_5(){
        Board b = new Board("4k2r/6K1/8/8/8/8/8/8 b k - 0 1");
        Assert.assertEquals(perft(b,5),37735);
    }

    @Test(dependsOnMethods = { "perft28_5" })
    public void perft28_6(){
        Board b = new Board("4k2r/6K1/8/8/8/8/8/8 b k - 0 1");
        Assert.assertEquals(perft(b,6),185867);
    }

    @Test
    public void perft29_1(){
        Board b = new Board("r3k3/1K6/8/8/8/8/8/8 b q - 0 1");
        Assert.assertEquals(perft(b,1),15);
    }

    @Test(dependsOnMethods = { "perft29_1" })
    public void perft29_2(){
        Board b = new Board("r3k3/1K6/8/8/8/8/8/8 b q - 0 1");
        Assert.assertEquals(perft(b,2),65);
    }

    @Test(dependsOnMethods = { "perft29_2" })
    public void perft29_3(){
        Board b = new Board("r3k3/1K6/8/8/8/8/8/8 b q - 0 1");
        Assert.assertEquals(perft(b,3),1018);
    }

    @Test(dependsOnMethods = { "perft29_3" })
    public void perft29_4(){
        Board b = new Board("r3k3/1K6/8/8/8/8/8/8 b q - 0 1");
        Assert.assertEquals(perft(b,4),4573);
    }

    @Test(dependsOnMethods = { "perft29_4" })
    public void perft29_5(){
        Board b = new Board("r3k3/1K6/8/8/8/8/8/8 b q - 0 1");
        Assert.assertEquals(perft(b,5),80619);
    }

    @Test(dependsOnMethods = { "perft29_5" })
    public void perft29_6(){
        Board b = new Board("r3k3/1K6/8/8/8/8/8/8 b q - 0 1");
        Assert.assertEquals(perft(b,6),413018);
    }

    @Test
    public void perft30_1(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K2R b KQkq - 0 1");
        Assert.assertEquals(perft(b,1),26);
    }

    @Test(dependsOnMethods = { "perft30_1" })
    public void perft30_2(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K2R b KQkq - 0 1");
        Assert.assertEquals(perft(b,2),568);
    }

    @Test(dependsOnMethods = { "perft30_2" })
    public void perft30_3(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K2R b KQkq - 0 1");
        Assert.assertEquals(perft(b,3),13744);
    }

    @Test(dependsOnMethods = { "perft30_3" })
    public void perft30_4(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K2R b KQkq - 0 1");
        Assert.assertEquals(perft(b,4),314346);
    }

    @Test(dependsOnMethods = { "perft30_4" })
    public void perft30_5(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K2R b KQkq - 0 1");
        Assert.assertEquals(perft(b,5),7594526);
    }

    @Test(dependsOnMethods = { "perft30_5" })
    public void perft30_6(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K2R b KQkq - 0 1");
        Assert.assertEquals(perft(b,6),179862938);
    }

    @Test
    public void perft31_1(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/1R2K2R b Kkq - 0 1");
        Assert.assertEquals(perft(b,1),26);
    }

    @Test(dependsOnMethods = { "perft31_1" })
    public void perft31_2(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/1R2K2R b Kkq - 0 1");
        Assert.assertEquals(perft(b,2),583);
    }

    @Test(dependsOnMethods = { "perft31_2" })
    public void perft31_3(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/1R2K2R b Kkq - 0 1");
        Assert.assertEquals(perft(b,3),14252);
    }

    @Test(dependsOnMethods = { "perft31_3" })
    public void perft31_4(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/1R2K2R b Kkq - 0 1");
        Assert.assertEquals(perft(b,4),334705);
    }

    @Test(dependsOnMethods = { "perft31_4" })
    public void perft31_5(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/1R2K2R b Kkq - 0 1");
        Assert.assertEquals(perft(b,5),8198901);
    }

    @Test(dependsOnMethods = { "perft31_5" })
    public void perft31_6(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/1R2K2R b Kkq - 0 1");
        Assert.assertEquals(perft(b,6),198328929);
    }

    @Test
    public void perft32_1(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/2R1K2R b Kkq - 0 1");
        Assert.assertEquals(perft(b,1),25);
    }

    @Test(dependsOnMethods = { "perft32_1" })
    public void perft32_2(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/2R1K2R b Kkq - 0 1");
        Assert.assertEquals(perft(b,2),560);
    }

    @Test(dependsOnMethods = { "perft32_2" })
    public void perft32_3(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/2R1K2R b Kkq - 0 1");
        Assert.assertEquals(perft(b,3),13592);
    }

    @Test(dependsOnMethods = { "perft32_3" })
    public void perft32_4(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/2R1K2R b Kkq - 0 1");
        Assert.assertEquals(perft(b,4),317324);
    }

    @Test(dependsOnMethods = { "perft32_4" })
    public void perft32_5(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/2R1K2R b Kkq - 0 1");
        Assert.assertEquals(perft(b,5),7710115);
    }

    @Test(dependsOnMethods = { "perft32_5" })
    public void perft32_6(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/2R1K2R b Kkq - 0 1");
        Assert.assertEquals(perft(b,6),185959088);
    }

    @Test
    public void perft33_1(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K1R1 b Qkq - 0 1");
        Assert.assertEquals(perft(b,1),25);
    }

    @Test(dependsOnMethods = { "perft33_1" })
    public void perft33_2(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K1R1 b Qkq - 0 1");
        Assert.assertEquals(perft(b,2),560);
    }

    @Test(dependsOnMethods = { "perft33_2" })
    public void perft33_3(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K1R1 b Qkq - 0 1");
        Assert.assertEquals(perft(b,3),13607);
    }

    @Test(dependsOnMethods = { "perft33_3" })
    public void perft33_4(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K1R1 b Qkq - 0 1");
        Assert.assertEquals(perft(b,4),320792);
    }

    @Test(dependsOnMethods = { "perft33_4" })
    public void perft33_5(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K1R1 b Qkq - 0 1");
        Assert.assertEquals(perft(b,5),7848606);
    }

    @Test(dependsOnMethods = { "perft33_5" })
    public void perft33_6(){
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K1R1 b Qkq - 0 1");
        Assert.assertEquals(perft(b,6),190755813);
    }

    @Test
    public void perft34_1(){
        Board b = new Board("1r2k2r/8/8/8/8/8/8/R3K2R b KQk - 0 1");
        Assert.assertEquals(perft(b,1),25);
    }

    @Test(dependsOnMethods = { "perft34_1" })
    public void perft34_2(){
        Board b = new Board("1r2k2r/8/8/8/8/8/8/R3K2R b KQk - 0 1");
        Assert.assertEquals(perft(b,2),567);
    }

    @Test(dependsOnMethods = { "perft34_2" })
    public void perft34_3(){
        Board b = new Board("1r2k2r/8/8/8/8/8/8/R3K2R b KQk - 0 1");
        Assert.assertEquals(perft(b,3),14095);
    }

    @Test(dependsOnMethods = { "perft34_3" })
    public void perft34_4(){
        Board b = new Board("1r2k2r/8/8/8/8/8/8/R3K2R b KQk - 0 1");
        Assert.assertEquals(perft(b,4),328965);
    }

    @Test(dependsOnMethods = { "perft34_4" })
    public void perft34_5(){
        Board b = new Board("1r2k2r/8/8/8/8/8/8/R3K2R b KQk - 0 1");
        Assert.assertEquals(perft(b,5),8153719);
    }

    @Test(dependsOnMethods = { "perft34_5" })
    public void perft34_6(){
        Board b = new Board("1r2k2r/8/8/8/8/8/8/R3K2R b KQk - 0 1");
        Assert.assertEquals(perft(b,6),195629489);
    }



    @Test
    public void perft35_1(){
        Board b = new Board("2r1k2r/8/8/8/8/8/8/R3K2R b KQk - 0 1");
        Assert.assertEquals(perft(b,1),25);
    }

    @Test(dependsOnMethods = { "perft35_1" })
    public void perft35_2(){
        Board b = new Board("2r1k2r/8/8/8/8/8/8/R3K2R b KQk - 0 1");
        Assert.assertEquals(perft(b,2),548);
    }

    @Test(dependsOnMethods = { "perft35_2" })
    public void perft35_3(){
        Board b = new Board("2r1k2r/8/8/8/8/8/8/R3K2R b KQk - 0 1");
        Assert.assertEquals(perft(b,3),13502);
    }

    @Test(dependsOnMethods = { "perft35_3" })
    public void perft35_4(){
        Board b = new Board("2r1k2r/8/8/8/8/8/8/R3K2R b KQk - 0 1");
        Assert.assertEquals(perft(b,4),312835);
    }

    @Test(dependsOnMethods = { "perft35_4" })
    public void perft35_5(){
        Board b = new Board("2r1k2r/8/8/8/8/8/8/R3K2R b KQk - 0 1");
        Assert.assertEquals(perft(b,5),7736373);
    }

    @Test(dependsOnMethods = { "perft35_5" })
    public void perft35_6(){
        Board b = new Board("2r1k2r/8/8/8/8/8/8/R3K2R b KQk - 0 1");
        Assert.assertEquals(perft(b,6),184411439);
    }

    @Test
    public void perft36_1(){
        Board b = new Board("r3k1r1/8/8/8/8/8/8/R3K2R b KQq - 0 1");
        Assert.assertEquals(perft(b,1),25);
    }

    @Test(dependsOnMethods = { "perft36_1" })
    public void perft36_2(){
        Board b = new Board("r3k1r1/8/8/8/8/8/8/R3K2R b KQq - 0 1");
        Assert.assertEquals(perft(b,2),547);
    }

    @Test(dependsOnMethods = { "perft36_2" })
    public void perft36_3(){
        Board b = new Board("r3k1r1/8/8/8/8/8/8/R3K2R b KQq - 0 1");
        Assert.assertEquals(perft(b,3),13579);
    }

    @Test(dependsOnMethods = { "perft36_3" })
    public void perft36_4(){
        Board b = new Board("r3k1r1/8/8/8/8/8/8/R3K2R b KQq - 0 1");
        Assert.assertEquals(perft(b,4),316214);
    }

    @Test(dependsOnMethods = { "perft36_4" })
    public void perft36_5(){
        Board b = new Board("r3k1r1/8/8/8/8/8/8/R3K2R b KQq - 0 1");
        Assert.assertEquals(perft(b,5),7878456);
    }

    @Test(dependsOnMethods = { "perft36_5" })
    public void perft36_6(){
        Board b = new Board("r3k1r1/8/8/8/8/8/8/R3K2R b KQq - 0 1");
        Assert.assertEquals(perft(b,6),189224276);
    }

    @Test
    public void perft37_1(){
        Board b = new Board("8/1n4N1/2k5/8/8/5K2/1N4n1/8 w - - 0 1");
        Assert.assertEquals(perft(b,1),14);
    }

    @Test(dependsOnMethods = { "perft37_1" })
    public void perft37_2(){
        Board b = new Board("8/1n4N1/2k5/8/8/5K2/1N4n1/8 w - - 0 1");
        Assert.assertEquals(perft(b,2),195);
    }

    @Test(dependsOnMethods = { "perft37_2" })
    public void perft37_3(){
        Board b = new Board("8/1n4N1/2k5/8/8/5K2/1N4n1/8 w - - 0 1");
        Assert.assertEquals(perft(b,3),2760);
    }

    @Test(dependsOnMethods = { "perft37_3" })
    public void perft37_4(){
        Board b = new Board("8/1n4N1/2k5/8/8/5K2/1N4n1/8 w - - 0 1");
        Assert.assertEquals(perft(b,4),38675);
    }

    @Test(dependsOnMethods = { "perft37_4" })
    public void perft37_5(){
        Board b = new Board("8/1n4N1/2k5/8/8/5K2/1N4n1/8 w - - 0 1");
        Assert.assertEquals(perft(b,5),570726);
    }

    @Test(dependsOnMethods = { "perft37_5" })
    public void perft37_6(){
        Board b = new Board("8/1n4N1/2k5/8/8/5K2/1N4n1/8 w - - 0 1");
        Assert.assertEquals(perft(b,6),8107539);
    }

    @Test
    public void perft38_1(){
        Board b = new Board("8/1k6/8/5N2/8/4n3/8/2K5 w - - 0 1");
        Assert.assertEquals(perft(b,1),11);
    }

    @Test(dependsOnMethods = { "perft38_1" })
    public void perft38_2(){
        Board b = new Board("8/1k6/8/5N2/8/4n3/8/2K5 w - - 0 1");
        Assert.assertEquals(perft(b,2),156);
    }

    @Test(dependsOnMethods = { "perft38_2" })
    public void perft38_3(){
        Board b = new Board("8/1k6/8/5N2/8/4n3/8/2K5 w - - 0 1");
        Assert.assertEquals(perft(b,3),1636);
    }

    @Test(dependsOnMethods = { "perft38_3" })
    public void perft38_4(){
        Board b = new Board("8/1k6/8/5N2/8/4n3/8/2K5 w - - 0 1");
        Assert.assertEquals(perft(b,4),20534);
    }

    @Test(dependsOnMethods = { "perft38_4" })
    public void perft38_5(){
        Board b = new Board("8/1k6/8/5N2/8/4n3/8/2K5 w - - 0 1");
        Assert.assertEquals(perft(b,5),223507);
    }

    @Test(dependsOnMethods = { "perft38_5" })
    public void perft38_6(){
        Board b = new Board("8/1k6/8/5N2/8/4n3/8/2K5 w - - 0 1");
        Assert.assertEquals(perft(b,6),2594412);
    }

    @Test
    public void perft39_1(){
        Board b = new Board("8/8/4k3/3Nn3/3nN3/4K3/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,1),19);
    }

    @Test(dependsOnMethods = { "perft39_1" })
    public void perft39_2(){
        Board b = new Board("8/8/4k3/3Nn3/3nN3/4K3/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,2),289);
    }

    @Test(dependsOnMethods = { "perft39_2" })
    public void perft39_3(){
        Board b = new Board("8/8/4k3/3Nn3/3nN3/4K3/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,3),4442);
    }

    @Test(dependsOnMethods = { "perft39_3" })
    public void perft39_4(){
        Board b = new Board("8/8/4k3/3Nn3/3nN3/4K3/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,4),73584);
    }

    @Test(dependsOnMethods = { "perft39_4" })
    public void perft39_5(){
        Board b = new Board("8/8/4k3/3Nn3/3nN3/4K3/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,5),1198299);
    }

    @Test(dependsOnMethods = { "perft39_5" })
    public void perft39_6(){
        Board b = new Board("8/8/4k3/3Nn3/3nN3/4K3/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,6),19870403);
    }

    @Test
    public void perft40_1(){
        Board b = new Board("K7/8/2n5/1n6/8/8/8/k6N w - - 0 1");
        Assert.assertEquals(perft(b,1),3);
    }

    @Test(dependsOnMethods = { "perft40_1" })
    public void perft40_2(){
        Board b = new Board("K7/8/2n5/1n6/8/8/8/k6N w - - 0 1");
        Assert.assertEquals(perft(b,2),51);
    }

    @Test(dependsOnMethods = { "perft40_2" })
    public void perft40_3(){
        Board b = new Board("K7/8/2n5/1n6/8/8/8/k6N w - - 0 1");
        Assert.assertEquals(perft(b,3),345);
    }

    @Test(dependsOnMethods = { "perft40_3" })
    public void perft40_4(){
        Board b = new Board("K7/8/2n5/1n6/8/8/8/k6N w - - 0 1");
        Assert.assertEquals(perft(b,4),5301);
    }

    @Test(dependsOnMethods = { "perft40_4" })
    public void perft40_5(){
        Board b = new Board("K7/8/2n5/1n6/8/8/8/k6N w - - 0 1");
        Assert.assertEquals(perft(b,5),38348);
    }

    @Test(dependsOnMethods = { "perft40_5" })
    public void perft40_6(){
        Board b = new Board("K7/8/2n5/1n6/8/8/8/k6N w - - 0 1");
        Assert.assertEquals(perft(b,6),588695);
    }

    @Test
    public void perft41_1(){
        Board b = new Board("k7/8/2N5/1N6/8/8/8/K6n w - - 0 1");
        Assert.assertEquals(perft(b,1),17);
    }

    @Test(dependsOnMethods = { "perft41_1" })
    public void perft41_2(){
        Board b = new Board("k7/8/2N5/1N6/8/8/8/K6n w - - 0 1");
        Assert.assertEquals(perft(b,2),54);
    }

    @Test(dependsOnMethods = { "perft41_2" })
    public void perft41_3(){
        Board b = new Board("k7/8/2N5/1N6/8/8/8/K6n w - - 0 1");
        Assert.assertEquals(perft(b,3),835);
    }

    @Test(dependsOnMethods = { "perft41_3" })
    public void perft41_4(){
        Board b = new Board("k7/8/2N5/1N6/8/8/8/K6n w - - 0 1");
        Assert.assertEquals(perft(b,4),5910);
    }

    @Test(dependsOnMethods = { "perft41_4" })
    public void perft41_5(){
        Board b = new Board("k7/8/2N5/1N6/8/8/8/K6n w - - 0 1");
        Assert.assertEquals(perft(b,5),92250);
    }

    @Test(dependsOnMethods = { "perft41_5" })
    public void perft41_6(){
        Board b = new Board("k7/8/2N5/1N6/8/8/8/K6n w - - 0 1");
        Assert.assertEquals(perft(b,6),688780);
    }

    @Test
    public void perft42_1(){
        Board b = new Board("8/1n4N1/2k5/8/8/5K2/1N4n1/8 b - - 0 1");
        Assert.assertEquals(perft(b,1),15);
    }

    @Test(dependsOnMethods = { "perft42_1" })
    public void perft42_2(){
        Board b = new Board("8/1n4N1/2k5/8/8/5K2/1N4n1/8 b - - 0 1");
        Assert.assertEquals(perft(b,2),193);
    }

    @Test(dependsOnMethods = { "perft42_2" })
    public void perft42_3(){
        Board b = new Board("8/1n4N1/2k5/8/8/5K2/1N4n1/8 b - - 0 1");
        Assert.assertEquals(perft(b,3),2816);
    }

    @Test(dependsOnMethods = { "perft42_3" })
    public void perft42_4(){
        Board b = new Board("8/1n4N1/2k5/8/8/5K2/1N4n1/8 b - - 0 1");
        Assert.assertEquals(perft(b,4),40039);
    }

    @Test(dependsOnMethods = { "perft42_4" })
    public void perft42_5(){
        Board b = new Board("8/1n4N1/2k5/8/8/5K2/1N4n1/8 b - - 0 1");
        Assert.assertEquals(perft(b,5),582642);
    }

    @Test(dependsOnMethods = { "perft42_5" })
    public void perft42_6(){
        Board b = new Board("8/1n4N1/2k5/8/8/5K2/1N4n1/8 b - - 0 1");
        Assert.assertEquals(perft(b,6),8503277);
    }

    @Test
    public void perft43_1(){
        Board b = new Board("8/1k6/8/5N2/8/4n3/8/2K5 b - - 0 1");
        Assert.assertEquals(perft(b,1),16);
    }

    @Test(dependsOnMethods = { "perft43_1" })
    public void perft43_2(){
        Board b = new Board("8/1k6/8/5N2/8/4n3/8/2K5 b - - 0 1");
        Assert.assertEquals(perft(b,2),180);
    }

    @Test(dependsOnMethods = { "perft43_2" })
    public void perft43_3(){
        Board b = new Board("8/1k6/8/5N2/8/4n3/8/2K5 b - - 0 1");
        Assert.assertEquals(perft(b,3),2290);
    }

    @Test(dependsOnMethods = { "perft43_3" })
    public void perft43_4(){
        Board b = new Board("8/1k6/8/5N2/8/4n3/8/2K5 b - - 0 1");
        Assert.assertEquals(perft(b,4),24640);
    }

    @Test(dependsOnMethods = { "perft43_4" })
    public void perft43_5(){
        Board b = new Board("8/1k6/8/5N2/8/4n3/8/2K5 b - - 0 1");
        Assert.assertEquals(perft(b,5),288141);
    }

    @Test(dependsOnMethods = { "perft43_5" })
    public void perft43_6(){
        Board b = new Board("8/1k6/8/5N2/8/4n3/8/2K5 b - - 0 1");
        Assert.assertEquals(perft(b,6),3147566);
    }

    @Test
    public void perft44_1(){
        Board b = new Board("8/8/3K4/3Nn3/3nN3/4k3/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,1),4);
    }

    @Test(dependsOnMethods = { "perft44_1" })
    public void perft44_2(){
        Board b = new Board("8/8/3K4/3Nn3/3nN3/4k3/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,2),68);
    }

    @Test(dependsOnMethods = { "perft44_2" })
    public void perft44_3(){
        Board b = new Board("8/8/3K4/3Nn3/3nN3/4k3/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,3),1118);
    }

    @Test(dependsOnMethods = { "perft44_3" })
    public void perft44_4(){
        Board b = new Board("8/8/3K4/3Nn3/3nN3/4k3/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,4),16199);
    }

    @Test(dependsOnMethods = { "perft44_4" })
    public void perft44_5(){
        Board b = new Board("8/8/3K4/3Nn3/3nN3/4k3/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,5),281190);
    }

    @Test(dependsOnMethods = { "perft44_5" })
    public void perft44_6(){
        Board b = new Board("8/8/3K4/3Nn3/3nN3/4k3/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,6),4405103);
    }

    @Test
    public void perft45_1(){
        Board b = new Board("K7/8/2n5/1n6/8/8/8/k6N b - - 0 1");
        Assert.assertEquals(perft(b,1),17);
    }

    @Test(dependsOnMethods = { "perft45_1" })
    public void perft45_2(){
        Board b = new Board("K7/8/2n5/1n6/8/8/8/k6N b - - 0 1");
        Assert.assertEquals(perft(b,2),54);
    }

    @Test(dependsOnMethods = { "perft45_2" })
    public void perft45_3(){
        Board b = new Board("K7/8/2n5/1n6/8/8/8/k6N b - - 0 1");
        Assert.assertEquals(perft(b,3),835);
    }

    @Test(dependsOnMethods = { "perft45_3" })
    public void perft45_4(){
        Board b = new Board("K7/8/2n5/1n6/8/8/8/k6N b - - 0 1");
        Assert.assertEquals(perft(b,4),5910);
    }

    @Test(dependsOnMethods = { "perft45_4" })
    public void perft45_5(){
        Board b = new Board("K7/8/2n5/1n6/8/8/8/k6N b - - 0 1");
        Assert.assertEquals(perft(b,5),92250);
    }

    @Test(dependsOnMethods = { "perft45_5" })
    public void perft45_6(){
        Board b = new Board("K7/8/2n5/1n6/8/8/8/k6N b - - 0 1");
        Assert.assertEquals(perft(b,6),688780);
    }

    @Test
    public void perft46_1(){
        Board b = new Board("k7/8/2N5/1N6/8/8/8/K6n b - - 0 1");
        Assert.assertEquals(perft(b,1),3);
    }

    @Test(dependsOnMethods = { "perft46_1" })
    public void perft46_2(){
        Board b = new Board("k7/8/2N5/1N6/8/8/8/K6n b - - 0 1");
        Assert.assertEquals(perft(b,2),51);
    }

    @Test(dependsOnMethods = { "perft46_2" })
    public void perft46_3(){
        Board b = new Board("k7/8/2N5/1N6/8/8/8/K6n b - - 0 1");
        Assert.assertEquals(perft(b,3),345);
    }

    @Test(dependsOnMethods = { "perft46_3" })
    public void perft46_4(){
        Board b = new Board("k7/8/2N5/1N6/8/8/8/K6n b - - 0 1");
        Assert.assertEquals(perft(b,4),5301);
    }

    @Test(dependsOnMethods = { "perft46_4" })
    public void perft46_5(){
        Board b = new Board("k7/8/2N5/1N6/8/8/8/K6n b - - 0 1");
        Assert.assertEquals(perft(b,5),38348);
    }

    @Test(dependsOnMethods = { "perft46_5" })
    public void perft46_6(){
        Board b = new Board("k7/8/2N5/1N6/8/8/8/K6n b - - 0 1");
        Assert.assertEquals(perft(b,6),588695);
    }

    @Test
    public void perft47_1(){
        Board b = new Board("B6b/8/8/8/2K5/4k3/8/b6B w - - 0 1");
        Assert.assertEquals(perft(b,1),17);
    }

    @Test(dependsOnMethods = { "perft47_1" })
    public void perft47_2(){
        Board b = new Board("B6b/8/8/8/2K5/4k3/8/b6B w - - 0 1");
        Assert.assertEquals(perft(b,2),278);
    }

    @Test(dependsOnMethods = { "perft47_2" })
    public void perft47_3(){
        Board b = new Board("B6b/8/8/8/2K5/4k3/8/b6B w - - 0 1");
        Assert.assertEquals(perft(b,3),4607);
    }

    @Test(dependsOnMethods = { "perft47_3" })
    public void perft47_4(){
        Board b = new Board("B6b/8/8/8/2K5/4k3/8/b6B w - - 0 1");
        Assert.assertEquals(perft(b,4),76778);
    }

    @Test(dependsOnMethods = { "perft47_4" })
    public void perft47_5(){
        Board b = new Board("B6b/8/8/8/2K5/4k3/8/b6B w - - 0 1");
        Assert.assertEquals(perft(b,5),1320507);
    }

    @Test(dependsOnMethods = { "perft47_5" })
    public void perft47_6(){
        Board b = new Board("B6b/8/8/8/2K5/4k3/8/b6B w - - 0 1");
        Assert.assertEquals(perft(b,6),22823890);
    }

    @Test
    public void perft48_1(){
        Board b = new Board("8/8/1B6/7b/7k/8/2B1b3/7K w - - 0 1");
        Assert.assertEquals(perft(b,1),21);
    }

    @Test(dependsOnMethods = { "perft48_1" })
    public void perft48_2(){
        Board b = new Board("8/8/1B6/7b/7k/8/2B1b3/7K w - - 0 1");
        Assert.assertEquals(perft(b,2),316);
    }

    @Test(dependsOnMethods = { "perft48_2" })
    public void perft48_3(){
        Board b = new Board("8/8/1B6/7b/7k/8/2B1b3/7K w - - 0 1");
        Assert.assertEquals(perft(b,3),5744);
    }

    @Test(dependsOnMethods = { "perft48_3" })
    public void perft48_4(){
        Board b = new Board("8/8/1B6/7b/7k/8/2B1b3/7K w - - 0 1");
        Assert.assertEquals(perft(b,4),93338);
    }

    @Test(dependsOnMethods = { "perft48_4" })
    public void perft48_5(){
        Board b = new Board("8/8/1B6/7b/7k/8/2B1b3/7K w - - 0 1");
        Assert.assertEquals(perft(b,5),1713368);
    }

    @Test(dependsOnMethods = { "perft48_5" })
    public void perft48_6(){
        Board b = new Board("8/8/1B6/7b/7k/8/2B1b3/7K w - - 0 1");
        Assert.assertEquals(perft(b,6),28861171);
    }

    @Test
    public void perft49_1(){
        Board b = new Board("k7/B7/1B6/1B6/8/8/8/K6b w - - 0 1");
        Assert.assertEquals(perft(b,1),21);
    }

    @Test(dependsOnMethods = { "perft49_1" })
    public void perft49_2(){
        Board b = new Board("k7/B7/1B6/1B6/8/8/8/K6b w - - 0 1");
        Assert.assertEquals(perft(b,2),144);
    }

    @Test(dependsOnMethods = { "perft49_2" })
    public void perft49_3(){
        Board b = new Board("k7/B7/1B6/1B6/8/8/8/K6b w - - 0 1");
        Assert.assertEquals(perft(b,3),3242);
    }

    @Test(dependsOnMethods = { "perft49_3" })
    public void perft49_4(){
        Board b = new Board("k7/B7/1B6/1B6/8/8/8/K6b w - - 0 1");
        Assert.assertEquals(perft(b,4),32955);
    }

    @Test(dependsOnMethods = { "perft49_4" })
    public void perft49_5(){
        Board b = new Board("k7/B7/1B6/1B6/8/8/8/K6b w - - 0 1");
        Assert.assertEquals(perft(b,5),787524);
    }

    @Test(dependsOnMethods = { "perft49_5" })
    public void perft49_6(){
        Board b = new Board("k7/B7/1B6/1B6/8/8/8/K6b w - - 0 1");
        Assert.assertEquals(perft(b,6),7881673);
    }

    @Test
    public void perft50_1(){
        Board b = new Board("K7/b7/1b6/1b6/8/8/8/k6B w - - 0 1");
        Assert.assertEquals(perft(b,1),7);
    }

    @Test(dependsOnMethods = { "perft50_1" })
    public void perft50_2(){
        Board b = new Board("K7/b7/1b6/1b6/8/8/8/k6B w - - 0 1");
        Assert.assertEquals(perft(b,2),143);
    }

    @Test(dependsOnMethods = { "perft50_2" })
    public void perft50_3(){
        Board b = new Board("K7/b7/1b6/1b6/8/8/8/k6B w - - 0 1");
        Assert.assertEquals(perft(b,3),1416);
    }

    @Test(dependsOnMethods = { "perft50_3" })
    public void perft50_4(){
        Board b = new Board("K7/b7/1b6/1b6/8/8/8/k6B w - - 0 1");
        Assert.assertEquals(perft(b,4),31787);
    }

    @Test(dependsOnMethods = { "perft50_4" })
    public void perft50_5(){
        Board b = new Board("K7/b7/1b6/1b6/8/8/8/k6B w - - 0 1");
        Assert.assertEquals(perft(b,5),310862);
    }

    @Test(dependsOnMethods = { "perft50_5" })
    public void perft50_6(){
        Board b = new Board("K7/b7/1b6/1b6/8/8/8/k6B w - - 0 1");
        Assert.assertEquals(perft(b,6),7382896);
    }

    @Test
    public void perft51_1(){
        Board b = new Board("B6b/8/8/8/2K5/5k2/8/b6B b - - 0 1");
        Assert.assertEquals(perft(b,1),6);
    }

    @Test(dependsOnMethods = { "perft51_1" })
    public void perft51_2(){
        Board b = new Board("B6b/8/8/8/2K5/5k2/8/b6B b - - 0 1");
        Assert.assertEquals(perft(b,2),106);
    }

    @Test(dependsOnMethods = { "perft51_2" })
    public void perft51_3(){
        Board b = new Board("B6b/8/8/8/2K5/5k2/8/b6B b - - 0 1");
        Assert.assertEquals(perft(b,3),1829);
    }

    @Test(dependsOnMethods = { "perft51_3" })
    public void perft51_4(){
        Board b = new Board("B6b/8/8/8/2K5/5k2/8/b6B b - - 0 1");
        Assert.assertEquals(perft(b,4),31151);
    }

    @Test(dependsOnMethods = { "perft51_4" })
    public void perft51_5(){
        Board b = new Board("B6b/8/8/8/2K5/5k2/8/b6B b - - 0 1");
        Assert.assertEquals(perft(b,5),530585);
    }

    @Test(dependsOnMethods = { "perft51_5" })
    public void perft51_6(){
        Board b = new Board("B6b/8/8/8/2K5/5k2/8/b6B b - - 0 1");
        Assert.assertEquals(perft(b,6),9250746);
    }

    @Test
    public void perft52_1(){
        Board b = new Board("8/8/1B6/7b/7k/8/2B1b3/7K b - - 0 1");
        Assert.assertEquals(perft(b,1),17);
    }

    @Test(dependsOnMethods = { "perft52_1" })
    public void perft52_2(){
        Board b = new Board("8/8/1B6/7b/7k/8/2B1b3/7K b - - 0 1");
        Assert.assertEquals(perft(b,2),309);
    }

    @Test(dependsOnMethods = { "perft52_2" })
    public void perft52_3(){
        Board b = new Board("8/8/1B6/7b/7k/8/2B1b3/7K b - - 0 1");
        Assert.assertEquals(perft(b,3),5133);
    }

    @Test(dependsOnMethods = { "perft52_3" })
    public void perft52_4(){
        Board b = new Board("8/8/1B6/7b/7k/8/2B1b3/7K b - - 0 1");
        Assert.assertEquals(perft(b,4),93603);
    }

    @Test(dependsOnMethods = { "perft52_4" })
    public void perft52_5(){
        Board b = new Board("8/8/1B6/7b/7k/8/2B1b3/7K b - - 0 1");
        Assert.assertEquals(perft(b,5),1591064);
    }

    @Test(dependsOnMethods = { "perft52_5" })
    public void perft52_6(){
        Board b = new Board("8/8/1B6/7b/7k/8/2B1b3/7K b - - 0 1");
        Assert.assertEquals(perft(b,6),29027891);
    }

    @Test
    public void perft53_1(){
        Board b = new Board("k7/B7/1B6/1B6/8/8/8/K6b b - - 0 1");
        Assert.assertEquals(perft(b,1),7);
    }

    @Test(dependsOnMethods = { "perft53_1" })
    public void perft53_2(){
        Board b = new Board("k7/B7/1B6/1B6/8/8/8/K6b b - - 0 1");
        Assert.assertEquals(perft(b,2),143);
    }

    @Test(dependsOnMethods = { "perft53_2" })
    public void perft53_3(){
        Board b = new Board("k7/B7/1B6/1B6/8/8/8/K6b b - - 0 1");
        Assert.assertEquals(perft(b,3),1416);
    }

    @Test(dependsOnMethods = { "perft53_3" })
    public void perft53_4(){
        Board b = new Board("k7/B7/1B6/1B6/8/8/8/K6b b - - 0 1");
        Assert.assertEquals(perft(b,4),31787);
    }

    @Test(dependsOnMethods = { "perft53_4" })
    public void perft53_5(){
        Board b = new Board("k7/B7/1B6/1B6/8/8/8/K6b b - - 0 1");
        Assert.assertEquals(perft(b,5),310862);
    }

    @Test(dependsOnMethods = { "perft53_5" })
    public void perft53_6(){
        Board b = new Board("k7/B7/1B6/1B6/8/8/8/K6b b - - 0 1");
        Assert.assertEquals(perft(b,6),7382896);
    }

    @Test
    public void perft54_1(){
        Board b = new Board("K7/b7/1b6/1b6/8/8/8/k6B b - - 0 1");
        Assert.assertEquals(perft(b,1),21);
    }

    @Test(dependsOnMethods = { "perft54_1" })
    public void perft54_2(){
        Board b = new Board("K7/b7/1b6/1b6/8/8/8/k6B b - - 0 1");
        Assert.assertEquals(perft(b,2),144);
    }

    @Test(dependsOnMethods = { "perft54_2" })
    public void perft54_3(){
        Board b = new Board("K7/b7/1b6/1b6/8/8/8/k6B b - - 0 1");
        Assert.assertEquals(perft(b,3),3242);
    }

    @Test(dependsOnMethods = { "perft54_3" })
    public void perft54_4(){
        Board b = new Board("K7/b7/1b6/1b6/8/8/8/k6B b - - 0 1");
        Assert.assertEquals(perft(b,4),32955);
    }

    @Test(dependsOnMethods = { "perft54_4" })
    public void perft54_5(){
        Board b = new Board("K7/b7/1b6/1b6/8/8/8/k6B b - - 0 1");
        Assert.assertEquals(perft(b,5),787524);
    }

    @Test(dependsOnMethods = { "perft54_5" })
    public void perft54_6(){
        Board b = new Board("K7/b7/1b6/1b6/8/8/8/k6B b - - 0 1");
        Assert.assertEquals(perft(b,6),7881673);
    }

    @Test
    public void perft55_1(){
        Board b = new Board("7k/RR6/8/8/8/8/rr6/7K w - - 0 1");
        Assert.assertEquals(perft(b,1),19);
    }

    @Test(dependsOnMethods = { "perft55_1" })
    public void perft55_2(){
        Board b = new Board("7k/RR6/8/8/8/8/rr6/7K w - - 0 1");
        Assert.assertEquals(perft(b,2),275);
    }

    @Test(dependsOnMethods = { "perft55_2" })
    public void perft55_3(){
        Board b = new Board("7k/RR6/8/8/8/8/rr6/7K w - - 0 1");
        Assert.assertEquals(perft(b,3),5300);
    }

    @Test(dependsOnMethods = { "perft55_3" })
    public void perft55_4(){
        Board b = new Board("7k/RR6/8/8/8/8/rr6/7K w - - 0 1");
        Assert.assertEquals(perft(b,4),104342);
    }

    @Test(dependsOnMethods = { "perft55_4" })
    public void perft55_5(){
        Board b = new Board("7k/RR6/8/8/8/8/rr6/7K w - - 0 1");
        Assert.assertEquals(perft(b,5),2161211);
    }

    @Test(dependsOnMethods = { "perft55_5" })
    public void perft55_6(){
        Board b = new Board("7k/RR6/8/8/8/8/rr6/7K w - - 0 1");
        Assert.assertEquals(perft(b,6),44956585);
    }

    @Test
    public void perft56_1(){
        Board b = new Board("R6r/8/8/2K5/5k2/8/8/r6R w - - 0 1");
        Assert.assertEquals(perft(b,1),36);
    }

    @Test(dependsOnMethods = { "perft56_1" })
    public void perft56_2(){
        Board b = new Board("R6r/8/8/2K5/5k2/8/8/r6R w - - 0 1");
        Assert.assertEquals(perft(b,2),1027);
    }

    @Test(dependsOnMethods = { "perft56_2" })
    public void perft56_3(){
        Board b = new Board("R6r/8/8/2K5/5k2/8/8/r6R w - - 0 1");
        Assert.assertEquals(perft(b,3),29215);
    }

    @Test(dependsOnMethods = { "perft56_3" })
    public void perft56_4(){
        Board b = new Board("R6r/8/8/2K5/5k2/8/8/r6R w - - 0 1");
        Assert.assertEquals(perft(b,4),771461);
    }

    @Test(dependsOnMethods = { "perft56_4" })
    public void perft56_5(){
        Board b = new Board("R6r/8/8/2K5/5k2/8/8/r6R w - - 0 1");
        Assert.assertEquals(perft(b,5),20506480);
    }

    @Test(dependsOnMethods = { "perft56_5" })
    public void perft56_6(){
        Board b = new Board("R6r/8/8/2K5/5k2/8/8/r6R w - - 0 1");
        Assert.assertEquals(perft(b,6),525169084);
    }

    @Test
    public void perft57_1(){
        Board b = new Board("7k/RR6/8/8/8/8/rr6/7K b - - 0 1");
        Assert.assertEquals(perft(b,1),19);
    }

    @Test(dependsOnMethods = { "perft57_1" })
    public void perft57_2(){
        Board b = new Board("7k/RR6/8/8/8/8/rr6/7K b - - 0 1");
        Assert.assertEquals(perft(b,2),275);
    }

    @Test(dependsOnMethods = { "perft57_2" })
    public void perft57_3(){
        Board b = new Board("7k/RR6/8/8/8/8/rr6/7K b - - 0 1");
        Assert.assertEquals(perft(b,3),5300);
    }

    @Test(dependsOnMethods = { "perft57_3" })
    public void perft57_4(){
        Board b = new Board("7k/RR6/8/8/8/8/rr6/7K b - - 0 1");
        Assert.assertEquals(perft(b,4),104342);
    }

    @Test(dependsOnMethods = { "perft57_4" })
    public void perft57_5(){
        Board b = new Board("7k/RR6/8/8/8/8/rr6/7K b - - 0 1");
        Assert.assertEquals(perft(b,5),2161211);
    }

    @Test(dependsOnMethods = { "perft57_5" })
    public void perft57_6(){
        Board b = new Board("7k/RR6/8/8/8/8/rr6/7K b - - 0 1");
        Assert.assertEquals(perft(b,6),44956585);
    }

    @Test
    public void perft58_1(){
        Board b = new Board("R6r/8/8/2K5/5k2/8/8/r6R b - - 0 1");
        Assert.assertEquals(perft(b,1),36);
    }

    @Test(dependsOnMethods = { "perft58_1" })
    public void perft58_2(){
        Board b = new Board("R6r/8/8/2K5/5k2/8/8/r6R b - - 0 1");
        Assert.assertEquals(perft(b,2),1027);
    }

    @Test(dependsOnMethods = { "perft58_2" })
    public void perft58_3(){
        Board b = new Board("R6r/8/8/2K5/5k2/8/8/r6R b - - 0 1");
        Assert.assertEquals(perft(b,3),29227);
    }

    @Test(dependsOnMethods = { "perft58_3" })
    public void perft58_4(){
        Board b = new Board("R6r/8/8/2K5/5k2/8/8/r6R b - - 0 1");
        Assert.assertEquals(perft(b,4),771368);
    }

    @Test(dependsOnMethods = { "perft58_4" })
    public void perft58_5(){
        Board b = new Board("R6r/8/8/2K5/5k2/8/8/r6R b - - 0 1");
        Assert.assertEquals(perft(b,5),20521342);
    }

    @Test(dependsOnMethods = { "perft58_5" })
    public void perft58_6(){
        Board b = new Board("R6r/8/8/2K5/5k2/8/8/r6R b - - 0 1");
        Assert.assertEquals(perft(b,6),524966748);
    }

    @Test
    public void perft59_1(){
        Board b = new Board("6kq/8/8/8/8/8/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,1),2);
    }

    @Test(dependsOnMethods = { "perft59_1" })
    public void perft59_2(){
        Board b = new Board("6kq/8/8/8/8/8/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,2),36);
    }

    @Test(dependsOnMethods = { "perft59_2" })
    public void perft59_3(){
        Board b = new Board("6kq/8/8/8/8/8/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,3),143);
    }

    @Test(dependsOnMethods = { "perft59_3" })
    public void perft59_4(){
        Board b = new Board("6kq/8/8/8/8/8/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,4),3637);
    }

    @Test(dependsOnMethods = { "perft59_4" })
    public void perft59_5(){
        Board b = new Board("6kq/8/8/8/8/8/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,5),14893);
    }

    @Test(dependsOnMethods = { "perft59_5" })
    public void perft59_6(){
        Board b = new Board("6kq/8/8/8/8/8/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,6),391507);
    }

    @Test
    public void perft60_1(){
        Board b = new Board("6KQ/8/8/8/8/8/8/7k b - - 0 1");
        Assert.assertEquals(perft(b,1),2);
    }

    @Test(dependsOnMethods = { "perft60_1" })
    public void perft60_2(){
        Board b = new Board("6KQ/8/8/8/8/8/8/7k b - - 0 1");
        Assert.assertEquals(perft(b,2),36);
    }

    @Test(dependsOnMethods = { "perft60_2" })
    public void perft60_3(){
        Board b = new Board("6KQ/8/8/8/8/8/8/7k b - - 0 1");
        Assert.assertEquals(perft(b,3),143);
    }

    @Test(dependsOnMethods = { "perft60_3" })
    public void perft60_4(){
        Board b = new Board("6KQ/8/8/8/8/8/8/7k b - - 0 1");
        Assert.assertEquals(perft(b,4),3637);
    }

    @Test(dependsOnMethods = { "perft60_4" })
    public void perft60_5(){
        Board b = new Board("6KQ/8/8/8/8/8/8/7k b - - 0 1");
        Assert.assertEquals(perft(b,5),14893);
    }

    @Test(dependsOnMethods = { "perft60_5" })
    public void perft60_6(){
        Board b = new Board("6KQ/8/8/8/8/8/8/7k b - - 0 1");
        Assert.assertEquals(perft(b,6),391507);
    }

    @Test
    public void perft61_1(){
        Board b = new Board("K7/8/8/3Q4/4q3/8/8/7k w - - 0 1");
        Assert.assertEquals(perft(b,1),6);
    }

    @Test(dependsOnMethods = { "perft61_1" })
    public void perft61_2(){
        Board b = new Board("K7/8/8/3Q4/4q3/8/8/7k w - - 0 1");
        Assert.assertEquals(perft(b,2),35);
    }

    @Test(dependsOnMethods = { "perft61_2" })
    public void perft61_3(){
        Board b = new Board("K7/8/8/3Q4/4q3/8/8/7k w - - 0 1");
        Assert.assertEquals(perft(b,3),495);
    }

    @Test(dependsOnMethods = { "perft61_3" })
    public void perft61_4(){
        Board b = new Board("K7/8/8/3Q4/4q3/8/8/7k w - - 0 1");
        Assert.assertEquals(perft(b,4),8349);
    }

    @Test(dependsOnMethods = { "perft61_4" })
    public void perft61_5(){
        Board b = new Board("K7/8/8/3Q4/4q3/8/8/7k w - - 0 1");
        Assert.assertEquals(perft(b,5),166741);
    }

    @Test(dependsOnMethods = { "perft61_5" })
    public void perft61_6(){
        Board b = new Board("K7/8/8/3Q4/4q3/8/8/7k w - - 0 1");
        Assert.assertEquals(perft(b,6),3370175);
    }

    @Test
    public void perft62_1(){
        Board b = new Board("6qk/8/8/8/8/8/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,1),22);
    }

    @Test(dependsOnMethods = { "perft62_1" })
    public void perft62_2(){
        Board b = new Board("6qk/8/8/8/8/8/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,2),43);
    }

    @Test(dependsOnMethods = { "perft62_2" })
    public void perft62_3(){
        Board b = new Board("6qk/8/8/8/8/8/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,3),1015);
    }

    @Test(dependsOnMethods = { "perft62_3" })
    public void perft62_4(){
        Board b = new Board("6qk/8/8/8/8/8/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,4),4167);
    }

    @Test(dependsOnMethods = { "perft62_4" })
    public void perft62_5(){
        Board b = new Board("6qk/8/8/8/8/8/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,5),105749);
    }

    @Test(dependsOnMethods = { "perft62_5" })
    public void perft62_6(){
        Board b = new Board("6qk/8/8/8/8/8/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,6),419369);
    }

    @Test
    public void perft63_1(){
        Board b = new Board("6KQ/8/8/8/8/8/8/7k b - - 0 1");
        Assert.assertEquals(perft(b,1),2);
    }

    @Test(dependsOnMethods = { "perft63_1" })
    public void perft63_2(){
        Board b = new Board("6KQ/8/8/8/8/8/8/7k b - - 0 1");
        Assert.assertEquals(perft(b,2),36);
    }

    @Test(dependsOnMethods = { "perft63_2" })
    public void perft63_3(){
        Board b = new Board("6KQ/8/8/8/8/8/8/7k b - - 0 1");
        Assert.assertEquals(perft(b,3),143);
    }

    @Test(dependsOnMethods = { "perft63_3" })
    public void perft63_4(){
        Board b = new Board("6KQ/8/8/8/8/8/8/7k b - - 0 1");
        Assert.assertEquals(perft(b,4),3637);
    }

    @Test(dependsOnMethods = { "perft63_4" })
    public void perft63_5(){
        Board b = new Board("6KQ/8/8/8/8/8/8/7k b - - 0 1");
        Assert.assertEquals(perft(b,5),14893);
    }

    @Test(dependsOnMethods = { "perft63_5" })
    public void perft63_6(){
        Board b = new Board("6KQ/8/8/8/8/8/8/7k b - - 0 1");
        Assert.assertEquals(perft(b,6),391507);
    }

    @Test
    public void perft64_1(){
        Board b = new Board("K7/8/8/3Q4/4q3/8/8/7k b - - 0 1");
        Assert.assertEquals(perft(b,1),6);
    }

    @Test(dependsOnMethods = { "perft64_1" })
    public void perft64_2(){
        Board b = new Board("K7/8/8/3Q4/4q3/8/8/7k b - - 0 1");
        Assert.assertEquals(perft(b,2),35);
    }

    @Test(dependsOnMethods = { "perft64_2" })
    public void perft64_3(){
        Board b = new Board("K7/8/8/3Q4/4q3/8/8/7k b - - 0 1");
        Assert.assertEquals(perft(b,3),495);
    }

    @Test(dependsOnMethods = { "perft64_3" })
    public void perft64_4(){
        Board b = new Board("K7/8/8/3Q4/4q3/8/8/7k b - - 0 1");
        Assert.assertEquals(perft(b,4),8349);
    }

    @Test(dependsOnMethods = { "perft64_4" })
    public void perft64_5(){
        Board b = new Board("K7/8/8/3Q4/4q3/8/8/7k b - - 0 1");
        Assert.assertEquals(perft(b,5),166741);
    }

    @Test(dependsOnMethods = { "perft64_5" })
    public void perft64_6(){
        Board b = new Board("K7/8/8/3Q4/4q3/8/8/7k b - - 0 1");
        Assert.assertEquals(perft(b,6),3370175);
    }

    @Test
    public void perft65_1(){
        Board b = new Board("8/8/8/8/8/K7/P7/k7 w - - 0 1");
        Assert.assertEquals(perft(b,1),3);
    }

    @Test(dependsOnMethods = { "perft65_1" })
    public void perft65_2(){
        Board b = new Board("8/8/8/8/8/K7/P7/k7 w - - 0 1");
        Assert.assertEquals(perft(b,2),7);
    }

    @Test(dependsOnMethods = { "perft65_2" })
    public void perft65_3(){
        Board b = new Board("8/8/8/8/8/K7/P7/k7 w - - 0 1");
        Assert.assertEquals(perft(b,3),43);
    }

    @Test(dependsOnMethods = { "perft65_3" })
    public void perft65_4(){
        Board b = new Board("8/8/8/8/8/K7/P7/k7 w - - 0 1");
        Assert.assertEquals(perft(b,4),199);
    }

    @Test(dependsOnMethods = { "perft65_4" })
    public void perft65_5(){
        Board b = new Board("8/8/8/8/8/K7/P7/k7 w - - 0 1");
        Assert.assertEquals(perft(b,5),1347);
    }

    @Test(dependsOnMethods = { "perft65_5" })
    public void perft65_6(){
        Board b = new Board("8/8/8/8/8/K7/P7/k7 w - - 0 1");
        Assert.assertEquals(perft(b,6),6249);
    }

    @Test
    public void perft66_1(){
        Board b = new Board("8/8/8/8/8/7K/7P/7k w - - 0 1");
        Assert.assertEquals(perft(b,1),3);
    }

    @Test(dependsOnMethods = { "perft66_1" })
    public void perft66_2(){
        Board b = new Board("8/8/8/8/8/7K/7P/7k w - - 0 1");
        Assert.assertEquals(perft(b,2),7);
    }

    @Test(dependsOnMethods = { "perft66_2" })
    public void perft66_3(){
        Board b = new Board("8/8/8/8/8/7K/7P/7k w - - 0 1");
        Assert.assertEquals(perft(b,3),43);
    }

    @Test(dependsOnMethods = { "perft66_3" })
    public void perft66_4(){
        Board b = new Board("8/8/8/8/8/7K/7P/7k w - - 0 1");
        Assert.assertEquals(perft(b,4),199);
    }

    @Test(dependsOnMethods = { "perft66_4" })
    public void perft66_5(){
        Board b = new Board("8/8/8/8/8/7K/7P/7k w - - 0 1");
        Assert.assertEquals(perft(b,5),1347);
    }

    @Test(dependsOnMethods = { "perft66_5" })
    public void perft66_6(){
        Board b = new Board("8/8/8/8/8/7K/7P/7k w - - 0 1");
        Assert.assertEquals(perft(b,6),6249);
    }

    @Test
    public void perft67_1(){
        Board b = new Board("K7/p7/k7/8/8/8/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,1),1);
    }

    @Test(dependsOnMethods = { "perft67_1" })
    public void perft67_2(){
        Board b = new Board("K7/p7/k7/8/8/8/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,2),3);
    }

    @Test(dependsOnMethods = { "perft67_2" })
    public void perft67_3(){
        Board b = new Board("K7/p7/k7/8/8/8/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,3),12);
    }

    @Test(dependsOnMethods = { "perft67_3" })
    public void perft67_4(){
        Board b = new Board("K7/p7/k7/8/8/8/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,4),80);
    }

    @Test(dependsOnMethods = { "perft67_4" })
    public void perft67_5(){
        Board b = new Board("K7/p7/k7/8/8/8/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,5),342);
    }

    @Test(dependsOnMethods = { "perft67_5" })
    public void perft67_6(){
        Board b = new Board("K7/p7/k7/8/8/8/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,6),2343);
    }

    @Test
    public void perft68_1(){
        Board b = new Board("7K/7p/7k/8/8/8/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,1),1);
    }

    @Test(dependsOnMethods = { "perft68_1" })
    public void perft68_2(){
        Board b = new Board("7K/7p/7k/8/8/8/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,2),3);
    }

    @Test(dependsOnMethods = { "perft68_2" })
    public void perft68_3(){
        Board b = new Board("7K/7p/7k/8/8/8/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,3),12);
    }

    @Test(dependsOnMethods = { "perft68_3" })
    public void perft68_4(){
        Board b = new Board("7K/7p/7k/8/8/8/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,4),80);
    }

    @Test(dependsOnMethods = { "perft68_4" })
    public void perft68_5(){
        Board b = new Board("7K/7p/7k/8/8/8/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,5),342);
    }

    @Test(dependsOnMethods = { "perft68_5" })
    public void perft68_6(){
        Board b = new Board("7K/7p/7k/8/8/8/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,6),2343);
    }

    @Test
    public void perft69_1(){
        Board b = new Board("8/2k1p3/3pP3/3P2K1/8/8/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,1),7);
    }

    @Test(dependsOnMethods = { "perft69_1" })
    public void perft69_2(){
        Board b = new Board("8/2k1p3/3pP3/3P2K1/8/8/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,2),35);
    }

    @Test(dependsOnMethods = { "perft69_2" })
    public void perft69_3(){
        Board b = new Board("8/2k1p3/3pP3/3P2K1/8/8/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,3),210);
    }

    @Test(dependsOnMethods = { "perft69_3" })
    public void perft69_4(){
        Board b = new Board("8/2k1p3/3pP3/3P2K1/8/8/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,4),1091);
    }

    @Test(dependsOnMethods = { "perft69_4" })
    public void perft69_5(){
        Board b = new Board("8/2k1p3/3pP3/3P2K1/8/8/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,5),7028);
    }

    @Test(dependsOnMethods = { "perft69_5" })
    public void perft69_6(){
        Board b = new Board("8/2k1p3/3pP3/3P2K1/8/8/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,6),34834);
    }

    @Test
    public void perft70_1(){
        Board b = new Board("8/8/8/8/8/K7/P7/k7 b - - 0 1");
        Assert.assertEquals(perft(b,1),1);
    }

    @Test(dependsOnMethods = { "perft70_1" })
    public void perft70_2(){
        Board b = new Board("8/8/8/8/8/K7/P7/k7 b - - 0 1");
        Assert.assertEquals(perft(b,2),3);
    }

    @Test(dependsOnMethods = { "perft70_2" })
    public void perft70_3(){
        Board b = new Board("8/8/8/8/8/K7/P7/k7 b - - 0 1");
        Assert.assertEquals(perft(b,3),12);
    }

    @Test(dependsOnMethods = { "perft70_3" })
    public void perft70_4(){
        Board b = new Board("8/8/8/8/8/K7/P7/k7 b - - 0 1");
        Assert.assertEquals(perft(b,4),80);
    }

    @Test(dependsOnMethods = { "perft70_4" })
    public void perft70_5(){
        Board b = new Board("8/8/8/8/8/K7/P7/k7 b - - 0 1");
        Assert.assertEquals(perft(b,5),342);
    }

    @Test(dependsOnMethods = { "perft70_5" })
    public void perft70_6(){
        Board b = new Board("8/8/8/8/8/K7/P7/k7 b - - 0 1");
        Assert.assertEquals(perft(b,6),2343);
    }

    @Test
    public void perft71_1(){
        Board b = new Board("8/8/8/8/8/7K/7P/7k b - - 0 1");
        Assert.assertEquals(perft(b,1),1);
    }

    @Test(dependsOnMethods = { "perft71_1" })
    public void perft71_2(){
        Board b = new Board("8/8/8/8/8/7K/7P/7k b - - 0 1");
        Assert.assertEquals(perft(b,2),3);
    }

    @Test(dependsOnMethods = { "perft71_2" })
    public void perft71_3(){
        Board b = new Board("8/8/8/8/8/7K/7P/7k b - - 0 1");
        Assert.assertEquals(perft(b,3),12);
    }

    @Test(dependsOnMethods = { "perft71_3" })
    public void perft71_4(){
        Board b = new Board("8/8/8/8/8/7K/7P/7k b - - 0 1");
        Assert.assertEquals(perft(b,4),80);
    }

    @Test(dependsOnMethods = { "perft71_4" })
    public void perft71_5(){
        Board b = new Board("8/8/8/8/8/7K/7P/7k b - - 0 1");
        Assert.assertEquals(perft(b,5),342);
    }

    @Test(dependsOnMethods = { "perft71_5" })
    public void perft71_6(){
        Board b = new Board("8/8/8/8/8/7K/7P/7k b - - 0 1");
        Assert.assertEquals(perft(b,6),2343);
    }

    @Test
    public void perft72_1(){
        Board b = new Board("K7/p7/k7/8/8/8/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,1),3);
    }

    @Test(dependsOnMethods = { "perft72_1" })
    public void perft72_2(){
        Board b = new Board("K7/p7/k7/8/8/8/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,2),7);
    }

    @Test(dependsOnMethods = { "perft72_2" })
    public void perft72_3(){
        Board b = new Board("K7/p7/k7/8/8/8/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,3),43);
    }

    @Test(dependsOnMethods = { "perft72_3" })
    public void perft72_4(){
        Board b = new Board("K7/p7/k7/8/8/8/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,4),199);
    }

    @Test(dependsOnMethods = { "perft72_4" })
    public void perft72_5(){
        Board b = new Board("K7/p7/k7/8/8/8/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,5),1347);
    }

    @Test(dependsOnMethods = { "perft72_5" })
    public void perft72_6(){
        Board b = new Board("K7/p7/k7/8/8/8/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,6),6249);
    }

    @Test
    public void perft73_1(){
        Board b = new Board("7K/7p/7k/8/8/8/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,1),3);
    }

    @Test(dependsOnMethods = { "perft73_1" })
    public void perft73_2(){
        Board b = new Board("7K/7p/7k/8/8/8/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,2),7);
    }

    @Test(dependsOnMethods = { "perft73_2" })
    public void perft73_3(){
        Board b = new Board("7K/7p/7k/8/8/8/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,3),43);
    }

    @Test(dependsOnMethods = { "perft73_3" })
    public void perft73_4(){
        Board b = new Board("7K/7p/7k/8/8/8/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,4),199);
    }

    @Test(dependsOnMethods = { "perft73_4" })
    public void perft73_5(){
        Board b = new Board("7K/7p/7k/8/8/8/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,5),1347);
    }

    @Test(dependsOnMethods = { "perft73_5" })
    public void perft73_6(){
        Board b = new Board("7K/7p/7k/8/8/8/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,6),6249);
    }

    @Test
    public void perft74_1(){
        Board b = new Board("8/2k1p3/3pP3/3P2K1/8/8/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,1),5);
    }

    @Test(dependsOnMethods = { "perft74_1" })
    public void perft74_2(){
        Board b = new Board("8/2k1p3/3pP3/3P2K1/8/8/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,2),35);
    }

    @Test(dependsOnMethods = { "perft74_2" })
    public void perft74_3(){
        Board b = new Board("8/2k1p3/3pP3/3P2K1/8/8/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,3),182);
    }

    @Test(dependsOnMethods = { "perft74_3" })
    public void perft74_4(){
        Board b = new Board("8/2k1p3/3pP3/3P2K1/8/8/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,4),1091);
    }

    @Test(dependsOnMethods = { "perft74_4" })
    public void perft74_5(){
        Board b = new Board("8/2k1p3/3pP3/3P2K1/8/8/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,5),5408);
    }

    @Test(dependsOnMethods = { "perft74_5" })
    public void perft74_6(){
        Board b = new Board("8/2k1p3/3pP3/3P2K1/8/8/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,6),34822);
    }

    @Test
    public void perft75_1(){
        Board b = new Board("8/8/8/8/8/4k3/4P3/4K3 w - - 0 1");
        Assert.assertEquals(perft(b,1),2);
    }

    @Test(dependsOnMethods = { "perft75_1" })
    public void perft75_2(){
        Board b = new Board("8/8/8/8/8/4k3/4P3/4K3 w - - 0 1");
        Assert.assertEquals(perft(b,2),8);
    }

    @Test(dependsOnMethods = { "perft75_2" })
    public void perft75_3(){
        Board b = new Board("8/8/8/8/8/4k3/4P3/4K3 w - - 0 1");
        Assert.assertEquals(perft(b,3),44);
    }

    @Test(dependsOnMethods = { "perft75_3" })
    public void perft75_4(){
        Board b = new Board("8/8/8/8/8/4k3/4P3/4K3 w - - 0 1");
        Assert.assertEquals(perft(b,4),282);
    }

    @Test(dependsOnMethods = { "perft75_4" })
    public void perft75_5(){
        Board b = new Board("8/8/8/8/8/4k3/4P3/4K3 w - - 0 1");
        Assert.assertEquals(perft(b,5),1814);
    }

    @Test(dependsOnMethods = { "perft75_5" })
    public void perft75_6(){
        Board b = new Board("8/8/8/8/8/4k3/4P3/4K3 w - - 0 1");
        Assert.assertEquals(perft(b,6),11848);
    }

    @Test
    public void perft76_1(){
        Board b = new Board("4k3/4p3/4K3/8/8/8/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,1),2);
    }

    @Test(dependsOnMethods = { "perft76_1" })
    public void perft76_2(){
        Board b = new Board("4k3/4p3/4K3/8/8/8/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,2),8);
    }

    @Test(dependsOnMethods = { "perft76_2" })
    public void perft76_3(){
        Board b = new Board("4k3/4p3/4K3/8/8/8/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,3),44);
    }

    @Test(dependsOnMethods = { "perft76_3" })
    public void perft76_4(){
        Board b = new Board("4k3/4p3/4K3/8/8/8/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,4),282);
    }

    @Test(dependsOnMethods = { "perft76_4" })
    public void perft76_5(){
        Board b = new Board("4k3/4p3/4K3/8/8/8/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,5),1814);
    }

    @Test(dependsOnMethods = { "perft76_5" })
    public void perft76_6(){
        Board b = new Board("4k3/4p3/4K3/8/8/8/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,6),11848);
    }

    @Test
    public void perft77_1(){
        Board b = new Board("8/8/7k/7p/7P/7K/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,1),3);
    }

    @Test(dependsOnMethods = { "perft77_1" })
    public void perft77_2(){
        Board b = new Board("8/8/7k/7p/7P/7K/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,2),9);
    }

    @Test(dependsOnMethods = { "perft77_2" })
    public void perft77_3(){
        Board b = new Board("8/8/7k/7p/7P/7K/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,3),57);
    }

    @Test(dependsOnMethods = { "perft77_3" })
    public void perft77_4(){
        Board b = new Board("8/8/7k/7p/7P/7K/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,4),360);
    }

    @Test(dependsOnMethods = { "perft77_4" })
    public void perft77_5(){
        Board b = new Board("8/8/7k/7p/7P/7K/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,5),1969);
    }

    @Test(dependsOnMethods = { "perft77_5" })
    public void perft77_6(){
        Board b = new Board("8/8/7k/7p/7P/7K/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,6),10724);
    }

    @Test
    public void perft78_1(){
        Board b = new Board("8/8/k7/p7/P7/K7/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,1),3);
    }

    @Test(dependsOnMethods = { "perft78_1" })
    public void perft78_2(){
        Board b = new Board("8/8/k7/p7/P7/K7/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,2),9);
    }

    @Test(dependsOnMethods = { "perft78_2" })
    public void perft78_3(){
        Board b = new Board("8/8/k7/p7/P7/K7/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,3),57);
    }

    @Test(dependsOnMethods = { "perft78_3" })
    public void perft78_4(){
        Board b = new Board("8/8/k7/p7/P7/K7/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,4),360);
    }

    @Test(dependsOnMethods = { "perft78_4" })
    public void perft78_5(){
        Board b = new Board("8/8/k7/p7/P7/K7/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,5),1969);
    }

    @Test(dependsOnMethods = { "perft78_5" })
    public void perft78_6(){
        Board b = new Board("8/8/k7/p7/P7/K7/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,6),10724);
    }

    @Test
    public void perft79_1(){
        Board b = new Board("8/8/3k4/3p4/3P4/3K4/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,1),5);
    }

    @Test(dependsOnMethods = { "perft79_1" })
    public void perft79_2(){
        Board b = new Board("8/8/3k4/3p4/3P4/3K4/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,2),25);
    }

    @Test(dependsOnMethods = { "perft79_2" })
    public void perft79_3(){
        Board b = new Board("8/8/3k4/3p4/3P4/3K4/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,3),180);
    }

    @Test(dependsOnMethods = { "perft79_3" })
    public void perft79_4(){
        Board b = new Board("8/8/3k4/3p4/3P4/3K4/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,4),1294);
    }

    @Test(dependsOnMethods = { "perft79_4" })
    public void perft79_5(){
        Board b = new Board("8/8/3k4/3p4/3P4/3K4/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,5),8296);
    }

    @Test(dependsOnMethods = { "perft79_5" })
    public void perft79_6(){
        Board b = new Board("8/8/3k4/3p4/3P4/3K4/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,6),53138);
    }

    @Test
    public void perft80_1(){
        Board b = new Board("8/3k4/3p4/8/3P4/3K4/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,1),8);
    }

    @Test(dependsOnMethods = { "perft80_1" })
    public void perft80_2(){
        Board b = new Board("8/3k4/3p4/8/3P4/3K4/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,2),61);
    }

    @Test(dependsOnMethods = { "perft80_2" })
    public void perft80_3(){
        Board b = new Board("8/3k4/3p4/8/3P4/3K4/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,3),483);
    }

    @Test(dependsOnMethods = { "perft80_3" })
    public void perft80_4(){
        Board b = new Board("8/3k4/3p4/8/3P4/3K4/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,4),3213);
    }

    @Test(dependsOnMethods = { "perft80_4" })
    public void perft80_5(){
        Board b = new Board("8/3k4/3p4/8/3P4/3K4/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,5),23599);
    }

    @Test(dependsOnMethods = { "perft80_5" })
    public void perft80_6(){
        Board b = new Board("8/3k4/3p4/8/3P4/3K4/8/8 w - - 0 1");
        Assert.assertEquals(perft(b,6),157093);
    }

    @Test
    public void perft81_1(){
        Board b = new Board("8/8/3k4/3p4/8/3P4/3K4/8 w - - 0 1");
        Assert.assertEquals(perft(b,1),8);
    }

    @Test(dependsOnMethods = { "perft81_1" })
    public void perft81_2(){
        Board b = new Board("8/8/3k4/3p4/8/3P4/3K4/8 w - - 0 1");
        Assert.assertEquals(perft(b,2),61);
    }

    @Test(dependsOnMethods = { "perft81_2" })
    public void perft81_3(){
        Board b = new Board("8/8/3k4/3p4/8/3P4/3K4/8 w - - 0 1");
        Assert.assertEquals(perft(b,3),411);
    }

    @Test(dependsOnMethods = { "perft81_3" })
    public void perft81_4(){
        Board b = new Board("8/8/3k4/3p4/8/3P4/3K4/8 w - - 0 1");
        Assert.assertEquals(perft(b,4),3213);
    }

    @Test(dependsOnMethods = { "perft81_4" })
    public void perft81_5(){
        Board b = new Board("8/8/3k4/3p4/8/3P4/3K4/8 w - - 0 1");
        Assert.assertEquals(perft(b,5),21637);
    }

    @Test(dependsOnMethods = { "perft81_5" })
    public void perft81_6(){
        Board b = new Board("8/8/3k4/3p4/8/3P4/3K4/8 w - - 0 1");
        Assert.assertEquals(perft(b,6),158065);
    }

    @Test
    public void perft82_1(){
        Board b = new Board("k7/8/3p4/8/3P4/8/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,1),4);
    }

    @Test(dependsOnMethods = { "perft82_1" })
    public void perft82_2(){
        Board b = new Board("k7/8/3p4/8/3P4/8/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,2),15);
    }

    @Test(dependsOnMethods = { "perft82_2" })
    public void perft82_3(){
        Board b = new Board("k7/8/3p4/8/3P4/8/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,3),90);
    }

    @Test(dependsOnMethods = { "perft82_3" })
    public void perft82_4(){
        Board b = new Board("k7/8/3p4/8/3P4/8/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,4),534);
    }

    @Test(dependsOnMethods = { "perft82_4" })
    public void perft82_5(){
        Board b = new Board("k7/8/3p4/8/3P4/8/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,5),3450);
    }

    @Test(dependsOnMethods = { "perft82_5" })
    public void perft82_6(){
        Board b = new Board("k7/8/3p4/8/3P4/8/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,6),20960);
    }

    @Test
    public void perft83_1(){
        Board b = new Board("8/8/7k/7p/7P/7K/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,1),3);
    }

    @Test(dependsOnMethods = { "perft83_1" })
    public void perft83_2(){
        Board b = new Board("8/8/7k/7p/7P/7K/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,2),9);
    }

    @Test(dependsOnMethods = { "perft83_2" })
    public void perft83_3(){
        Board b = new Board("8/8/7k/7p/7P/7K/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,3),57);
    }

    @Test(dependsOnMethods = { "perft83_3" })
    public void perft83_4(){
        Board b = new Board("8/8/7k/7p/7P/7K/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,4),360);
    }

    @Test(dependsOnMethods = { "perft83_4" })
    public void perft83_5(){
        Board b = new Board("8/8/7k/7p/7P/7K/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,5),1969);
    }

    @Test(dependsOnMethods = { "perft83_5" })
    public void perft83_6(){
        Board b = new Board("8/8/7k/7p/7P/7K/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,6),10724);
    }

    @Test
    public void perft84_1(){
        Board b = new Board("8/8/k7/p7/P7/K7/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,1),3);
    }

    @Test(dependsOnMethods = { "perft84_1" })
    public void perft84_2(){
        Board b = new Board("8/8/k7/p7/P7/K7/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,2),9);
    }

    @Test(dependsOnMethods = { "perft84_2" })
    public void perft84_3(){
        Board b = new Board("8/8/k7/p7/P7/K7/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,3),57);
    }

    @Test(dependsOnMethods = { "perft84_3" })
    public void perft84_4(){
        Board b = new Board("8/8/k7/p7/P7/K7/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,4),360);
    }

    @Test(dependsOnMethods = { "perft84_4" })
    public void perft84_5(){
        Board b = new Board("8/8/k7/p7/P7/K7/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,5),1969);
    }

    @Test(dependsOnMethods = { "perft84_5" })
    public void perft84_6(){
        Board b = new Board("8/8/k7/p7/P7/K7/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,6),10724);
    }

    @Test
    public void perft85_1(){
        Board b = new Board("8/8/3k4/3p4/3P4/3K4/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,1),5);
    }

    @Test(dependsOnMethods = { "perft85_1" })
    public void perft85_2(){
        Board b = new Board("8/8/3k4/3p4/3P4/3K4/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,2),25);
    }

    @Test(dependsOnMethods = { "perft85_2" })
    public void perft85_3(){
        Board b = new Board("8/8/3k4/3p4/3P4/3K4/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,3),180);
    }

    @Test(dependsOnMethods = { "perft85_3" })
    public void perft85_4(){
        Board b = new Board("8/8/3k4/3p4/3P4/3K4/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,4),1294);
    }

    @Test(dependsOnMethods = { "perft85_4" })
    public void perft85_5(){
        Board b = new Board("8/8/3k4/3p4/3P4/3K4/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,5),8296);
    }

    @Test(dependsOnMethods = { "perft85_5" })
    public void perft85_6(){
        Board b = new Board("8/8/3k4/3p4/3P4/3K4/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,6),53138);
    }

    @Test
    public void perft86_1(){
        Board b = new Board("8/3k4/3p4/8/3P4/3K4/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,1),8);
    }

    @Test(dependsOnMethods = { "perft86_1" })
    public void perft86_2(){
        Board b = new Board("8/3k4/3p4/8/3P4/3K4/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,2),61);
    }

    @Test(dependsOnMethods = { "perft86_2" })
    public void perft86_3(){
        Board b = new Board("8/3k4/3p4/8/3P4/3K4/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,3),411);
    }

    @Test(dependsOnMethods = { "perft86_3" })
    public void perft86_4(){
        Board b = new Board("8/3k4/3p4/8/3P4/3K4/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,4),3213);
    }

    @Test(dependsOnMethods = { "perft86_4" })
    public void perft86_5(){
        Board b = new Board("8/3k4/3p4/8/3P4/3K4/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,5),21637);
    }

    @Test(dependsOnMethods = { "perft86_5" })
    public void perft86_6(){
        Board b = new Board("8/3k4/3p4/8/3P4/3K4/8/8 b - - 0 1");
        Assert.assertEquals(perft(b,6),158065);
    }

    @Test
    public void perft87_1(){
        Board b = new Board("8/8/3k4/3p4/8/3P4/3K4/8 b - - 0 1");
        Assert.assertEquals(perft(b,1),8);
    }

    @Test(dependsOnMethods = { "perft87_1" })
    public void perft87_2(){
        Board b = new Board("8/8/3k4/3p4/8/3P4/3K4/8 b - - 0 1");
        Assert.assertEquals(perft(b,2),61);
    }

    @Test(dependsOnMethods = { "perft87_2" })
    public void perft87_3(){
        Board b = new Board("8/8/3k4/3p4/8/3P4/3K4/8 b - - 0 1");
        Assert.assertEquals(perft(b,3),483);
    }

    @Test(dependsOnMethods = { "perft87_3" })
    public void perft87_4(){
        Board b = new Board("8/8/3k4/3p4/8/3P4/3K4/8 b - - 0 1");
        Assert.assertEquals(perft(b,4),3213);
    }

    @Test(dependsOnMethods = { "perft87_4" })
    public void perft87_5(){
        Board b = new Board("8/8/3k4/3p4/8/3P4/3K4/8 b - - 0 1");
        Assert.assertEquals(perft(b,5),23599);
    }

    @Test(dependsOnMethods = { "perft87_5" })
    public void perft87_6(){
        Board b = new Board("8/8/3k4/3p4/8/3P4/3K4/8 b - - 0 1");
        Assert.assertEquals(perft(b,6),157093);
    }

    @Test
    public void perft88_1(){
        Board b = new Board("k7/8/3p4/8/3P4/8/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,1),4);
    }

    @Test(dependsOnMethods = { "perft88_1" })
    public void perft88_2(){
        Board b = new Board("k7/8/3p4/8/3P4/8/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,2),15);
    }

    @Test(dependsOnMethods = { "perft88_2" })
    public void perft88_3(){
        Board b = new Board("k7/8/3p4/8/3P4/8/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,3),89);
    }

    @Test(dependsOnMethods = { "perft88_3" })
    public void perft88_4(){
        Board b = new Board("k7/8/3p4/8/3P4/8/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,4),537);
    }

    @Test(dependsOnMethods = { "perft88_4" })
    public void perft88_5(){
        Board b = new Board("k7/8/3p4/8/3P4/8/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,5),3309);
    }

    @Test(dependsOnMethods = { "perft88_5" })
    public void perft88_6(){
        Board b = new Board("k7/8/3p4/8/3P4/8/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,6),21104);
    }

    @Test
    public void perft89_1(){
        Board b = new Board("7k/3p4/8/8/3P4/8/8/K7 w - - 0 1");
        Assert.assertEquals(perft(b,1),4);
    }

    @Test(dependsOnMethods = { "perft89_1" })
    public void perft89_2(){
        Board b = new Board("7k/3p4/8/8/3P4/8/8/K7 w - - 0 1");
        Assert.assertEquals(perft(b,2),19);
    }

    @Test(dependsOnMethods = { "perft89_2" })
    public void perft89_3(){
        Board b = new Board("7k/3p4/8/8/3P4/8/8/K7 w - - 0 1");
        Assert.assertEquals(perft(b,3),117);
    }

    @Test(dependsOnMethods = { "perft89_3" })
    public void perft89_4(){
        Board b = new Board("7k/3p4/8/8/3P4/8/8/K7 w - - 0 1");
        Assert.assertEquals(perft(b,4),720);
    }

    @Test(dependsOnMethods = { "perft89_4" })
    public void perft89_5(){
        Board b = new Board("7k/3p4/8/8/3P4/8/8/K7 w - - 0 1");
        Assert.assertEquals(perft(b,5),4661);
    }

    @Test(dependsOnMethods = { "perft89_5" })
    public void perft89_6(){
        Board b = new Board("7k/3p4/8/8/3P4/8/8/K7 w - - 0 1");
        Assert.assertEquals(perft(b,6),32191);
    }

    @Test
    public void perft90_1(){
        Board b = new Board("7k/8/8/3p4/8/8/3P4/K7 w - - 0 1");
        Assert.assertEquals(perft(b,1),5);
    }

    @Test(dependsOnMethods = { "perft90_1" })
    public void perft90_2(){
        Board b = new Board("7k/8/8/3p4/8/8/3P4/K7 w - - 0 1");
        Assert.assertEquals(perft(b,2),19);
    }

    @Test(dependsOnMethods = { "perft90_2" })
    public void perft90_3(){
        Board b = new Board("7k/8/8/3p4/8/8/3P4/K7 w - - 0 1");
        Assert.assertEquals(perft(b,3),116);
    }

    @Test(dependsOnMethods = { "perft90_3" })
    public void perft90_4(){
        Board b = new Board("7k/8/8/3p4/8/8/3P4/K7 w - - 0 1");
        Assert.assertEquals(perft(b,4),716);
    }

    @Test(dependsOnMethods = { "perft90_4" })
    public void perft90_5(){
        Board b = new Board("7k/8/8/3p4/8/8/3P4/K7 w - - 0 1");
        Assert.assertEquals(perft(b,5),4786);
    }

    @Test(dependsOnMethods = { "perft90_5" })
    public void perft90_6(){
        Board b = new Board("7k/8/8/3p4/8/8/3P4/K7 w - - 0 1");
        Assert.assertEquals(perft(b,6),30980);
    }

    @Test
    public void perft91_1(){
        Board b = new Board("k7/8/8/7p/6P1/8/8/K7 w - - 0 1");
        Assert.assertEquals(perft(b,1),5);
    }

    @Test(dependsOnMethods = { "perft91_1" })
    public void perft91_2(){
        Board b = new Board("k7/8/8/7p/6P1/8/8/K7 w - - 0 1");
        Assert.assertEquals(perft(b,2),22);
    }

    @Test(dependsOnMethods = { "perft91_2" })
    public void perft91_3(){
        Board b = new Board("k7/8/8/7p/6P1/8/8/K7 w - - 0 1");
        Assert.assertEquals(perft(b,3),139);
    }

    @Test(dependsOnMethods = { "perft91_3" })
    public void perft91_4(){
        Board b = new Board("k7/8/8/7p/6P1/8/8/K7 w - - 0 1");
        Assert.assertEquals(perft(b,4),877);
    }

    @Test(dependsOnMethods = { "perft91_4" })
    public void perft91_5(){
        Board b = new Board("k7/8/8/7p/6P1/8/8/K7 w - - 0 1");
        Assert.assertEquals(perft(b,5),6112);
    }

    @Test(dependsOnMethods = { "perft91_5" })
    public void perft91_6(){
        Board b = new Board("k7/8/8/7p/6P1/8/8/K7 w - - 0 1");
        Assert.assertEquals(perft(b,6),41874);
    }

    @Test
    public void perft92_1(){
        Board b = new Board("k7/8/7p/8/8/6P1/8/K7 w - - 0 1");
        Assert.assertEquals(perft(b,1),4);
    }

    @Test(dependsOnMethods = { "perft92_1" })
    public void perft92_2(){
        Board b = new Board("k7/8/7p/8/8/6P1/8/K7 w - - 0 1");
        Assert.assertEquals(perft(b,2),16);
    }

    @Test(dependsOnMethods = { "perft92_2" })
    public void perft92_3(){
        Board b = new Board("k7/8/7p/8/8/6P1/8/K7 w - - 0 1");
        Assert.assertEquals(perft(b,3),101);
    }

    @Test(dependsOnMethods = { "perft92_3" })
    public void perft92_4(){
        Board b = new Board("k7/8/7p/8/8/6P1/8/K7 w - - 0 1");
        Assert.assertEquals(perft(b,4),637);
    }

    @Test(dependsOnMethods = { "perft92_4" })
    public void perft92_5(){
        Board b = new Board("k7/8/7p/8/8/6P1/8/K7 w - - 0 1");
        Assert.assertEquals(perft(b,5),4354);
    }

    @Test(dependsOnMethods = { "perft92_5" })
    public void perft92_6(){
        Board b = new Board("k7/8/7p/8/8/6P1/8/K7 w - - 0 1");
        Assert.assertEquals(perft(b,6),29679);
    }

    @Test
    public void perft93_1(){
        Board b = new Board("k7/8/8/6p1/7P/8/8/K7 w - - 0 1");
        Assert.assertEquals(perft(b,1),5);
    }

    @Test(dependsOnMethods = { "perft93_1" })
    public void perft93_2(){
        Board b = new Board("k7/8/8/6p1/7P/8/8/K7 w - - 0 1");
        Assert.assertEquals(perft(b,2),22);
    }

    @Test(dependsOnMethods = { "perft93_2" })
    public void perft93_3(){
        Board b = new Board("k7/8/8/6p1/7P/8/8/K7 w - - 0 1");
        Assert.assertEquals(perft(b,3),139);
    }

    @Test(dependsOnMethods = { "perft93_3" })
    public void perft93_4(){
        Board b = new Board("k7/8/8/6p1/7P/8/8/K7 w - - 0 1");
        Assert.assertEquals(perft(b,4),877);
    }

    @Test(dependsOnMethods = { "perft93_4" })
    public void perft93_5(){
        Board b = new Board("k7/8/8/6p1/7P/8/8/K7 w - - 0 1");
        Assert.assertEquals(perft(b,5),6112);
    }

    @Test(dependsOnMethods = { "perft93_5" })
    public void perft93_6(){
        Board b = new Board("k7/8/8/6p1/7P/8/8/K7 w - - 0 1");
        Assert.assertEquals(perft(b,6),41874);
    }

    @Test
    public void perft94_1(){
        Board b = new Board("k7/8/6p1/8/8/7P/8/K7 w - - 0 1");
        Assert.assertEquals(perft(b,1),4);
    }

    @Test(dependsOnMethods = { "perft94_1" })
    public void perft94_2(){
        Board b = new Board("k7/8/6p1/8/8/7P/8/K7 w - - 0 1");
        Assert.assertEquals(perft(b,2),16);
    }

    @Test(dependsOnMethods = { "perft94_2" })
    public void perft94_3(){
        Board b = new Board("k7/8/6p1/8/8/7P/8/K7 w - - 0 1");
        Assert.assertEquals(perft(b,3),101);
    }

    @Test(dependsOnMethods = { "perft94_3" })
    public void perft94_4(){
        Board b = new Board("k7/8/6p1/8/8/7P/8/K7 w - - 0 1");
        Assert.assertEquals(perft(b,4),637);
    }

    @Test(dependsOnMethods = { "perft94_4" })
    public void perft94_5(){
        Board b = new Board("k7/8/6p1/8/8/7P/8/K7 w - - 0 1");
        Assert.assertEquals(perft(b,5),4354);
    }

    @Test(dependsOnMethods = { "perft94_5" })
    public void perft94_6(){
        Board b = new Board("k7/8/6p1/8/8/7P/8/K7 w - - 0 1");
        Assert.assertEquals(perft(b,6),29679);
    }

    @Test
    public void perft95_1(){
        Board b = new Board("k7/8/8/3p4/4p3/8/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,1),3);
    }

    @Test(dependsOnMethods = { "perft95_1" })
    public void perft95_2(){
        Board b = new Board("k7/8/8/3p4/4p3/8/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,2),15);
    }

    @Test(dependsOnMethods = { "perft95_2" })
    public void perft95_3(){
        Board b = new Board("k7/8/8/3p4/4p3/8/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,3),84);
    }

    @Test(dependsOnMethods = { "perft95_3" })
    public void perft95_4(){
        Board b = new Board("k7/8/8/3p4/4p3/8/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,4),573);
    }

    @Test(dependsOnMethods = { "perft95_4" })
    public void perft95_5(){
        Board b = new Board("k7/8/8/3p4/4p3/8/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,5),3013);
    }

    @Test(dependsOnMethods = { "perft95_5" })
    public void perft95_6(){
        Board b = new Board("k7/8/8/3p4/4p3/8/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,6),22886);
    }

    @Test
    public void perft96_1(){
        Board b = new Board("k7/8/3p4/8/8/4P3/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,1),4);
    }

    @Test(dependsOnMethods = { "perft96_1" })
    public void perft96_2(){
        Board b = new Board("k7/8/3p4/8/8/4P3/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,2),16);
    }

    @Test(dependsOnMethods = { "perft96_2" })
    public void perft96_3(){
        Board b = new Board("k7/8/3p4/8/8/4P3/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,3),101);
    }

    @Test(dependsOnMethods = { "perft96_3" })
    public void perft96_4(){
        Board b = new Board("k7/8/3p4/8/8/4P3/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,4),637);
    }

    @Test(dependsOnMethods = { "perft96_4" })
    public void perft96_5(){
        Board b = new Board("k7/8/3p4/8/8/4P3/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,5),4271);
    }

    @Test(dependsOnMethods = { "perft96_5" })
    public void perft96_6(){
        Board b = new Board("k7/8/3p4/8/8/4P3/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,6),28662);
    }

    @Test
    public void perft97_1(){
        Board b = new Board("7k/3p4/8/8/3P4/8/8/K7 b - - 0 1");
        Assert.assertEquals(perft(b,1),5);
    }

    @Test(dependsOnMethods = { "perft97_1" })
    public void perft97_2(){
        Board b = new Board("7k/3p4/8/8/3P4/8/8/K7 b - - 0 1");
        Assert.assertEquals(perft(b,2),19);
    }

    @Test(dependsOnMethods = { "perft97_2" })
    public void perft97_3(){
        Board b = new Board("7k/3p4/8/8/3P4/8/8/K7 b - - 0 1");
        Assert.assertEquals(perft(b,3),117);
    }

    @Test(dependsOnMethods = { "perft97_3" })
    public void perft97_4(){
        Board b = new Board("7k/3p4/8/8/3P4/8/8/K7 b - - 0 1");
        Assert.assertEquals(perft(b,4),720);
    }

    @Test(dependsOnMethods = { "perft97_4" })
    public void perft97_5(){
        Board b = new Board("7k/3p4/8/8/3P4/8/8/K7 b - - 0 1");
        Assert.assertEquals(perft(b,5),5014);
    }

    @Test(dependsOnMethods = { "perft97_5" })
    public void perft97_6(){
        Board b = new Board("7k/3p4/8/8/3P4/8/8/K7 b - - 0 1");
        Assert.assertEquals(perft(b,6),32167);
    }

    @Test
    public void perft98_1(){
        Board b = new Board("7k/8/8/3p4/8/8/3P4/K7 b - - 0 1");
        Assert.assertEquals(perft(b,1),4);
    }

    @Test(dependsOnMethods = { "perft98_1" })
    public void perft98_2(){
        Board b = new Board("7k/8/8/3p4/8/8/3P4/K7 b - - 0 1");
        Assert.assertEquals(perft(b,2),19);
    }

    @Test(dependsOnMethods = { "perft98_2" })
    public void perft98_3(){
        Board b = new Board("7k/8/8/3p4/8/8/3P4/K7 b - - 0 1");
        Assert.assertEquals(perft(b,3),117);
    }

    @Test(dependsOnMethods = { "perft98_3" })
    public void perft98_4(){
        Board b = new Board("7k/8/8/3p4/8/8/3P4/K7 b - - 0 1");
        Assert.assertEquals(perft(b,4),712);
    }

    @Test(dependsOnMethods = { "perft98_4" })
    public void perft98_5(){
        Board b = new Board("7k/8/8/3p4/8/8/3P4/K7 b - - 0 1");
        Assert.assertEquals(perft(b,5),4658);
    }

    @Test(dependsOnMethods = { "perft98_5" })
    public void perft98_6(){
        Board b = new Board("7k/8/8/3p4/8/8/3P4/K7 b - - 0 1");
        Assert.assertEquals(perft(b,6),30749);
    }

    @Test
    public void perft99_1(){
        Board b = new Board("k7/8/8/7p/6P1/8/8/K7 b - - 0 1");
        Assert.assertEquals(perft(b,1),5);
    }

    @Test(dependsOnMethods = { "perft99_1" })
    public void perft99_2(){
        Board b = new Board("k7/8/8/7p/6P1/8/8/K7 b - - 0 1");
        Assert.assertEquals(perft(b,2),22);
    }

    @Test(dependsOnMethods = { "perft99_2" })
    public void perft99_3(){
        Board b = new Board("k7/8/8/7p/6P1/8/8/K7 b - - 0 1");
        Assert.assertEquals(perft(b,3),139);
    }

    @Test(dependsOnMethods = { "perft99_3" })
    public void perft99_4(){
        Board b = new Board("k7/8/8/7p/6P1/8/8/K7 b - - 0 1");
        Assert.assertEquals(perft(b,4),877);
    }

    @Test(dependsOnMethods = { "perft99_4" })
    public void perft99_5(){
        Board b = new Board("k7/8/8/7p/6P1/8/8/K7 b - - 0 1");
        Assert.assertEquals(perft(b,5),6112);
    }

    @Test(dependsOnMethods = { "perft99_5" })
    public void perft99_6(){
        Board b = new Board("k7/8/8/7p/6P1/8/8/K7 b - - 0 1");
        Assert.assertEquals(perft(b,6),41874);
    }

    @Test
    public void perft100_1(){
        Board b = new Board("k7/8/7p/8/8/6P1/8/K7 b - - 0 1");
        Assert.assertEquals(perft(b,1),4);
    }

    @Test(dependsOnMethods = { "perft100_1" })
    public void perft100_2(){
        Board b = new Board("k7/8/7p/8/8/6P1/8/K7 b - - 0 1");
        Assert.assertEquals(perft(b,2),16);
    }

    @Test(dependsOnMethods = { "perft100_2" })
    public void perft100_3(){
        Board b = new Board("k7/8/7p/8/8/6P1/8/K7 b - - 0 1");
        Assert.assertEquals(perft(b,3),101);
    }

    @Test(dependsOnMethods = { "perft100_3" })
    public void perft100_4(){
        Board b = new Board("k7/8/7p/8/8/6P1/8/K7 b - - 0 1");
        Assert.assertEquals(perft(b,4),637);
    }

    @Test(dependsOnMethods = { "perft100_4" })
    public void perft100_5(){
        Board b = new Board("k7/8/7p/8/8/6P1/8/K7 b - - 0 1");
        Assert.assertEquals(perft(b,5),4354);
    }

    @Test(dependsOnMethods = { "perft100_5" })
    public void perft100_6(){
        Board b = new Board("k7/8/7p/8/8/6P1/8/K7 b - - 0 1");
        Assert.assertEquals(perft(b,6),29679);
    }

    @Test
    public void perft101_1(){
        Board b = new Board("k7/8/8/6p1/7P/8/8/K7 b - - 0 1");
        Assert.assertEquals(perft(b,1),5);
    }

    @Test(dependsOnMethods = { "perft101_1" })
    public void perft101_2(){
        Board b = new Board("k7/8/8/6p1/7P/8/8/K7 b - - 0 1");
        Assert.assertEquals(perft(b,2),22);
    }

    @Test(dependsOnMethods = { "perft101_2" })
    public void perft101_3(){
        Board b = new Board("k7/8/8/6p1/7P/8/8/K7 b - - 0 1");
        Assert.assertEquals(perft(b,3),139);
    }

    @Test(dependsOnMethods = { "perft101_3" })
    public void perft101_4(){
        Board b = new Board("k7/8/8/6p1/7P/8/8/K7 b - - 0 1");
        Assert.assertEquals(perft(b,4),877);
    }

    @Test(dependsOnMethods = { "perft101_4" })
    public void perft101_5(){
        Board b = new Board("k7/8/8/6p1/7P/8/8/K7 b - - 0 1");
        Assert.assertEquals(perft(b,5),6112);
    }

    @Test(dependsOnMethods = { "perft101_5" })
    public void perft101_6(){
        Board b = new Board("k7/8/8/6p1/7P/8/8/K7 b - - 0 1");
        Assert.assertEquals(perft(b,6),41874);
    }

    @Test
    public void perft102_1(){
        Board b = new Board("k7/8/6p1/8/8/7P/8/K7 b - - 0 1");
        Assert.assertEquals(perft(b,1),4);
    }

    @Test(dependsOnMethods = { "perft102_1" })
    public void perft102_2(){
        Board b = new Board("k7/8/6p1/8/8/7P/8/K7 b - - 0 1");
        Assert.assertEquals(perft(b,2),16);
    }

    @Test(dependsOnMethods = { "perft102_2" })
    public void perft102_3(){
        Board b = new Board("k7/8/6p1/8/8/7P/8/K7 b - - 0 1");
        Assert.assertEquals(perft(b,3),101);
    }

    @Test(dependsOnMethods = { "perft102_3" })
    public void perft102_4(){
        Board b = new Board("k7/8/6p1/8/8/7P/8/K7 b - - 0 1");
        Assert.assertEquals(perft(b,4),637);
    }

    @Test(dependsOnMethods = { "perft102_4" })
    public void perft102_5(){
        Board b = new Board("k7/8/6p1/8/8/7P/8/K7 b - - 0 1");
        Assert.assertEquals(perft(b,5),4354);
    }

    @Test(dependsOnMethods = { "perft102_5" })
    public void perft102_6(){
        Board b = new Board("k7/8/6p1/8/8/7P/8/K7 b - - 0 1");
        Assert.assertEquals(perft(b,6),29679);
    }

    @Test
    public void perft103_1(){
        Board b = new Board("k7/8/8/3p4/4p3/8/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,1),5);
    }

    @Test(dependsOnMethods = { "perft103_1" })
    public void perft103_2(){
        Board b = new Board("k7/8/8/3p4/4p3/8/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,2),15);
    }

    @Test(dependsOnMethods = { "perft103_2" })
    public void perft103_3(){
        Board b = new Board("k7/8/8/3p4/4p3/8/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,3),102);
    }

    @Test(dependsOnMethods = { "perft103_3" })
    public void perft103_4(){
        Board b = new Board("k7/8/8/3p4/4p3/8/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,4),569);
    }

    @Test(dependsOnMethods = { "perft103_4" })
    public void perft103_5(){
        Board b = new Board("k7/8/8/3p4/4p3/8/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,5),4337);
    }

    @Test(dependsOnMethods = { "perft103_5" })
    public void perft103_6(){
        Board b = new Board("k7/8/8/3p4/4p3/8/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,6),22579);
    }

    @Test
    public void perft104_1(){
        Board b = new Board("k7/8/3p4/8/8/4P3/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,1),4);
    }

    @Test(dependsOnMethods = { "perft104_1" })
    public void perft104_2(){
        Board b = new Board("k7/8/3p4/8/8/4P3/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,2),16);
    }

    @Test(dependsOnMethods = { "perft104_2" })
    public void perft104_3(){
        Board b = new Board("k7/8/3p4/8/8/4P3/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,3),101);
    }

    @Test(dependsOnMethods = { "perft104_3" })
    public void perft104_4(){
        Board b = new Board("k7/8/3p4/8/8/4P3/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,4),637);
    }

    @Test(dependsOnMethods = { "perft104_4" })
    public void perft104_5(){
        Board b = new Board("k7/8/3p4/8/8/4P3/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,5),4271);
    }

    @Test(dependsOnMethods = { "perft104_5" })
    public void perft104_6(){
        Board b = new Board("k7/8/3p4/8/8/4P3/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,6),28662);
    }

    @Test
    public void perft105_1(){
        Board b = new Board("7k/8/8/p7/1P6/8/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,1),5);
    }

    @Test(dependsOnMethods = { "perft105_1" })
    public void perft105_2(){
        Board b = new Board("7k/8/8/p7/1P6/8/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,2),22);
    }

    @Test(dependsOnMethods = { "perft105_2" })
    public void perft105_3(){
        Board b = new Board("7k/8/8/p7/1P6/8/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,3),139);
    }

    @Test(dependsOnMethods = { "perft105_3" })
    public void perft105_4(){
        Board b = new Board("7k/8/8/p7/1P6/8/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,4),877);
    }

    @Test(dependsOnMethods = { "perft105_4" })
    public void perft105_5(){
        Board b = new Board("7k/8/8/p7/1P6/8/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,5),6112);
    }

    @Test(dependsOnMethods = { "perft105_5" })
    public void perft105_6(){
        Board b = new Board("7k/8/8/p7/1P6/8/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,6),41874);
    }

    @Test
    public void perft106_1(){
        Board b = new Board("7k/8/p7/8/8/1P6/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,1),4);
    }

    @Test(dependsOnMethods = { "perft106_1" })
    public void perft106_2(){
        Board b = new Board("7k/8/p7/8/8/1P6/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,2),16);
    }

    @Test(dependsOnMethods = { "perft106_2" })
    public void perft106_3(){
        Board b = new Board("7k/8/p7/8/8/1P6/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,3),101);
    }

    @Test(dependsOnMethods = { "perft106_3" })
    public void perft106_4(){
        Board b = new Board("7k/8/p7/8/8/1P6/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,4),637);
    }

    @Test(dependsOnMethods = { "perft106_4" })
    public void perft106_5(){
        Board b = new Board("7k/8/p7/8/8/1P6/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,5),4354);
    }

    @Test(dependsOnMethods = { "perft106_5" })
    public void perft106_6(){
        Board b = new Board("7k/8/p7/8/8/1P6/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,6),29679);
    }

    @Test
    public void perft107_1(){
        Board b = new Board("7k/8/8/1p6/P7/8/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,1),5);
    }

    @Test(dependsOnMethods = { "perft107_1" })
    public void perft107_2(){
        Board b = new Board("7k/8/8/1p6/P7/8/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,2),22);
    }

    @Test(dependsOnMethods = { "perft107_2" })
    public void perft107_3(){
        Board b = new Board("7k/8/8/1p6/P7/8/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,3),139);
    }

    @Test(dependsOnMethods = { "perft107_3" })
    public void perft107_4(){
        Board b = new Board("7k/8/8/1p6/P7/8/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,4),877);
    }

    @Test(dependsOnMethods = { "perft107_4" })
    public void perft107_5(){
        Board b = new Board("7k/8/8/1p6/P7/8/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,5),6112);
    }

    @Test(dependsOnMethods = { "perft107_5" })
    public void perft107_6(){
        Board b = new Board("7k/8/8/1p6/P7/8/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,6),41874);
    }

    @Test
    public void perft108_1(){
        Board b = new Board("7k/8/1p6/8/8/P7/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,1),4);
    }

    @Test(dependsOnMethods = { "perft108_1" })
    public void perft108_2(){
        Board b = new Board("7k/8/1p6/8/8/P7/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,2),16);
    }

    @Test(dependsOnMethods = { "perft108_2" })
    public void perft108_3(){
        Board b = new Board("7k/8/1p6/8/8/P7/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,3),101);
    }

    @Test(dependsOnMethods = { "perft108_3" })
    public void perft108_4(){
        Board b = new Board("7k/8/1p6/8/8/P7/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,4),637);
    }

    @Test(dependsOnMethods = { "perft108_4" })
    public void perft108_5(){
        Board b = new Board("7k/8/1p6/8/8/P7/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,5),4354);
    }

    @Test(dependsOnMethods = { "perft108_5" })
    public void perft108_6(){
        Board b = new Board("7k/8/1p6/8/8/P7/8/7K w - - 0 1");
        Assert.assertEquals(perft(b,6),29679);
    }

    @Test
    public void perft109_1(){
        Board b = new Board("k7/7p/8/8/8/8/6P1/K7 w - - 0 1");
        Assert.assertEquals(perft(b,1),5);
    }

    @Test(dependsOnMethods = { "perft109_1" })
    public void perft109_2(){
        Board b = new Board("k7/7p/8/8/8/8/6P1/K7 w - - 0 1");
        Assert.assertEquals(perft(b,2),25);
    }

    @Test(dependsOnMethods = { "perft109_2" })
    public void perft109_3(){
        Board b = new Board("k7/7p/8/8/8/8/6P1/K7 w - - 0 1");
        Assert.assertEquals(perft(b,3),161);
    }

    @Test(dependsOnMethods = { "perft109_3" })
    public void perft109_4(){
        Board b = new Board("k7/7p/8/8/8/8/6P1/K7 w - - 0 1");
        Assert.assertEquals(perft(b,4),1035);
    }

    @Test(dependsOnMethods = { "perft109_4" })
    public void perft109_5(){
        Board b = new Board("k7/7p/8/8/8/8/6P1/K7 w - - 0 1");
        Assert.assertEquals(perft(b,5),7574);
    }

    @Test(dependsOnMethods = { "perft109_5" })
    public void perft109_6(){
        Board b = new Board("k7/7p/8/8/8/8/6P1/K7 w - - 0 1");
        Assert.assertEquals(perft(b,6),55338);
    }

    @Test
    public void perft110_1(){
        Board b = new Board("k7/6p1/8/8/8/8/7P/K7 w - - 0 1");
        Assert.assertEquals(perft(b,1),5);
    }

    @Test(dependsOnMethods = { "perft110_1" })
    public void perft110_2(){
        Board b = new Board("k7/6p1/8/8/8/8/7P/K7 w - - 0 1");
        Assert.assertEquals(perft(b,2),25);
    }

    @Test(dependsOnMethods = { "perft110_2" })
    public void perft110_3(){
        Board b = new Board("k7/6p1/8/8/8/8/7P/K7 w - - 0 1");
        Assert.assertEquals(perft(b,3),161);
    }

    @Test(dependsOnMethods = { "perft110_3" })
    public void perft110_4(){
        Board b = new Board("k7/6p1/8/8/8/8/7P/K7 w - - 0 1");
        Assert.assertEquals(perft(b,4),1035);
    }

    @Test(dependsOnMethods = { "perft110_4" })
    public void perft110_5(){
        Board b = new Board("k7/6p1/8/8/8/8/7P/K7 w - - 0 1");
        Assert.assertEquals(perft(b,5),7574);
    }

    @Test(dependsOnMethods = { "perft110_5" })
    public void perft110_6(){
        Board b = new Board("k7/6p1/8/8/8/8/7P/K7 w - - 0 1");
        Assert.assertEquals(perft(b,6),55338);
    }

    @Test
    public void perft111_1(){
        Board b = new Board("3k4/3pp3/8/8/8/8/3PP3/3K4 w - - 0 1");
        Assert.assertEquals(perft(b,1),7);
    }

    @Test(dependsOnMethods = { "perft111_1" })
    public void perft111_2(){
        Board b = new Board("3k4/3pp3/8/8/8/8/3PP3/3K4 w - - 0 1");
        Assert.assertEquals(perft(b,2),49);
    }

    @Test(dependsOnMethods = { "perft111_2" })
    public void perft111_3(){
        Board b = new Board("3k4/3pp3/8/8/8/8/3PP3/3K4 w - - 0 1");
        Assert.assertEquals(perft(b,3),378);
    }

    @Test(dependsOnMethods = { "perft111_3" })
    public void perft111_4(){
        Board b = new Board("3k4/3pp3/8/8/8/8/3PP3/3K4 w - - 0 1");
        Assert.assertEquals(perft(b,4),2902);
    }

    @Test(dependsOnMethods = { "perft111_4" })
    public void perft111_5(){
        Board b = new Board("3k4/3pp3/8/8/8/8/3PP3/3K4 w - - 0 1");
        Assert.assertEquals(perft(b,5),24122);
    }

    @Test(dependsOnMethods = { "perft111_5" })
    public void perft111_6(){
        Board b = new Board("3k4/3pp3/8/8/8/8/3PP3/3K4 w - - 0 1");
        Assert.assertEquals(perft(b,6),199002);
    }

    @Test
    public void perft112_1(){
        Board b = new Board("7k/8/8/p7/1P6/8/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,1),5);
    }

    @Test(dependsOnMethods = { "perft112_1" })
    public void perft112_2(){
        Board b = new Board("7k/8/8/p7/1P6/8/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,2),22);
    }

    @Test(dependsOnMethods = { "perft112_2" })
    public void perft112_3(){
        Board b = new Board("7k/8/8/p7/1P6/8/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,3),139);
    }

    @Test(dependsOnMethods = { "perft112_3" })
    public void perft112_4(){
        Board b = new Board("7k/8/8/p7/1P6/8/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,4),877);
    }

    @Test(dependsOnMethods = { "perft112_4" })
    public void perft112_5(){
        Board b = new Board("7k/8/8/p7/1P6/8/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,5),6112);
    }

    @Test(dependsOnMethods = { "perft112_5" })
    public void perft112_6(){
        Board b = new Board("7k/8/8/p7/1P6/8/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,6),41874);
    }

    @Test
    public void perft113_1(){
        Board b = new Board("7k/8/p7/8/8/1P6/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,1),4);
    }

    @Test(dependsOnMethods = { "perft113_1" })
    public void perft113_2(){
        Board b = new Board("7k/8/p7/8/8/1P6/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,2),16);
    }

    @Test(dependsOnMethods = { "perft113_2" })
    public void perft113_3(){
        Board b = new Board("7k/8/p7/8/8/1P6/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,3),101);
    }

    @Test(dependsOnMethods = { "perft113_3" })
    public void perft113_4(){
        Board b = new Board("7k/8/p7/8/8/1P6/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,4),637);
    }

    @Test(dependsOnMethods = { "perft113_4" })
    public void perft113_5(){
        Board b = new Board("7k/8/p7/8/8/1P6/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,5),4354);
    }

    @Test(dependsOnMethods = { "perft113_5" })
    public void perft113_6(){
        Board b = new Board("7k/8/p7/8/8/1P6/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,6),29679);
    }

    @Test
    public void perft114_1(){
        Board b = new Board("7k/8/8/1p6/P7/8/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,1),5);
    }

    @Test(dependsOnMethods = { "perft114_1" })
    public void perft114_2(){
        Board b = new Board("7k/8/8/1p6/P7/8/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,2),22);
    }

    @Test(dependsOnMethods = { "perft114_2" })
    public void perft114_3(){
        Board b = new Board("7k/8/8/1p6/P7/8/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,3),139);
    }

    @Test(dependsOnMethods = { "perft114_3" })
    public void perft114_4(){
        Board b = new Board("7k/8/8/1p6/P7/8/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,4),877);
    }

    @Test(dependsOnMethods = { "perft114_4" })
    public void perft114_5(){
        Board b = new Board("7k/8/8/1p6/P7/8/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,5),6112);
    }

    @Test(dependsOnMethods = { "perft114_5" })
    public void perft114_6(){
        Board b = new Board("7k/8/8/1p6/P7/8/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,6),41874);
    }

    @Test
    public void perft115_1(){
        Board b = new Board("7k/8/1p6/8/8/P7/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,1),4);
    }

    @Test(dependsOnMethods = { "perft115_1" })
    public void perft115_2(){
        Board b = new Board("7k/8/1p6/8/8/P7/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,2),16);
    }

    @Test(dependsOnMethods = { "perft115_2" })
    public void perft115_3(){
        Board b = new Board("7k/8/1p6/8/8/P7/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,3),101);
    }

    @Test(dependsOnMethods = { "perft115_3" })
    public void perft115_4(){
        Board b = new Board("7k/8/1p6/8/8/P7/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,4),637);
    }

    @Test(dependsOnMethods = { "perft115_4" })
    public void perft115_5(){
        Board b = new Board("7k/8/1p6/8/8/P7/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,5),4354);
    }

    @Test(dependsOnMethods = { "perft115_5" })
    public void perft115_6(){
        Board b = new Board("7k/8/1p6/8/8/P7/8/7K b - - 0 1");
        Assert.assertEquals(perft(b,6),29679);
    }

    @Test
    public void perft116_1(){
        Board b = new Board("k7/7p/8/8/8/8/6P1/K7 b - - 0 1");
        Assert.assertEquals(perft(b,1),5);
    }

    @Test(dependsOnMethods = { "perft116_1" })
    public void perft116_2(){
        Board b = new Board("k7/7p/8/8/8/8/6P1/K7 b - - 0 1");
        Assert.assertEquals(perft(b,2),25);
    }

    @Test(dependsOnMethods = { "perft116_2" })
    public void perft116_3(){
        Board b = new Board("k7/7p/8/8/8/8/6P1/K7 b - - 0 1");
        Assert.assertEquals(perft(b,3),161);
    }

    @Test(dependsOnMethods = { "perft116_3" })
    public void perft116_4(){
        Board b = new Board("k7/7p/8/8/8/8/6P1/K7 b - - 0 1");
        Assert.assertEquals(perft(b,4),1035);
    }

    @Test(dependsOnMethods = { "perft116_4" })
    public void perft116_5(){
        Board b = new Board("k7/7p/8/8/8/8/6P1/K7 b - - 0 1");
        Assert.assertEquals(perft(b,5),7574);
    }

    @Test(dependsOnMethods = { "perft116_5" })
    public void perft116_6(){
        Board b = new Board("k7/7p/8/8/8/8/6P1/K7 b - - 0 1");
        Assert.assertEquals(perft(b,6),55338);
    }

    @Test
    public void perft117_1(){
        Board b = new Board("k7/6p1/8/8/8/8/7P/K7 b - - 0 1");
        Assert.assertEquals(perft(b,1),5);
    }

    @Test(dependsOnMethods = { "perft117_1" })
    public void perft117_2(){
        Board b = new Board("k7/6p1/8/8/8/8/7P/K7 b - - 0 1");
        Assert.assertEquals(perft(b,2),25);
    }

    @Test(dependsOnMethods = { "perft117_2" })
    public void perft117_3(){
        Board b = new Board("k7/6p1/8/8/8/8/7P/K7 b - - 0 1");
        Assert.assertEquals(perft(b,3),161);
    }

    @Test(dependsOnMethods = { "perft117_3" })
    public void perft117_4(){
        Board b = new Board("k7/6p1/8/8/8/8/7P/K7 b - - 0 1");
        Assert.assertEquals(perft(b,4),1035);
    }

    @Test(dependsOnMethods = { "perft117_4" })
    public void perft117_5(){
        Board b = new Board("k7/6p1/8/8/8/8/7P/K7 b - - 0 1");
        Assert.assertEquals(perft(b,5),7574);
    }

    @Test(dependsOnMethods = { "perft117_5" })
    public void perft117_6(){
        Board b = new Board("k7/6p1/8/8/8/8/7P/K7 b - - 0 1");
        Assert.assertEquals(perft(b,6),55338);
    }

    @Test
    public void perft118_1(){
        Board b = new Board("3k4/3pp3/8/8/8/8/3PP3/3K4 b - - 0 1");
        Assert.assertEquals(perft(b,1),7);
    }

    @Test(dependsOnMethods = { "perft118_1" })
    public void perft118_2(){
        Board b = new Board("3k4/3pp3/8/8/8/8/3PP3/3K4 b - - 0 1");
        Assert.assertEquals(perft(b,2),49);
    }

    @Test(dependsOnMethods = { "perft118_2" })
    public void perft118_3(){
        Board b = new Board("3k4/3pp3/8/8/8/8/3PP3/3K4 b - - 0 1");
        Assert.assertEquals(perft(b,3),378);
    }

    @Test(dependsOnMethods = { "perft118_3" })
    public void perft118_4(){
        Board b = new Board("3k4/3pp3/8/8/8/8/3PP3/3K4 b - - 0 1");
        Assert.assertEquals(perft(b,4),2902);
    }

    @Test(dependsOnMethods = { "perft118_4" })
    public void perft118_5(){
        Board b = new Board("3k4/3pp3/8/8/8/8/3PP3/3K4 b - - 0 1");
        Assert.assertEquals(perft(b,5),24122);
    }

    @Test(dependsOnMethods = { "perft118_5" })
    public void perft118_6(){
        Board b = new Board("3k4/3pp3/8/8/8/8/3PP3/3K4 b - - 0 1");
        Assert.assertEquals(perft(b,6),199002);
    }

    @Test
    public void perft119_1(){
        Board b = new Board("8/Pk6/8/8/8/8/6Kp/8 w - - 0 1");
        Assert.assertEquals(perft(b,1),11);
    }

    @Test(dependsOnMethods = { "perft119_1" })
    public void perft119_2(){
        Board b = new Board("8/Pk6/8/8/8/8/6Kp/8 w - - 0 1");
        Assert.assertEquals(perft(b,2),97);
    }

    @Test(dependsOnMethods = { "perft119_2" })
    public void perft119_3(){
        Board b = new Board("8/Pk6/8/8/8/8/6Kp/8 w - - 0 1");
        Assert.assertEquals(perft(b,3),887);
    }

    @Test(dependsOnMethods = { "perft119_3" })
    public void perft119_4(){
        Board b = new Board("8/Pk6/8/8/8/8/6Kp/8 w - - 0 1");
        Assert.assertEquals(perft(b,4),8048);
    }

    @Test(dependsOnMethods = { "perft119_4" })
    public void perft119_5(){
        Board b = new Board("8/Pk6/8/8/8/8/6Kp/8 w - - 0 1");
        Assert.assertEquals(perft(b,5),90606);
    }

    @Test(dependsOnMethods = { "perft119_5" })
    public void perft119_6(){
        Board b = new Board("8/Pk6/8/8/8/8/6Kp/8 w - - 0 1");
        Assert.assertEquals(perft(b,6),1030499);
    }

    @Test
    public void perft120_1(){
        Board b = new Board("n1n5/1Pk5/8/8/8/8/5Kp1/5N1N w - - 0 1");
        Assert.assertEquals(perft(b,1),24);
    }

    @Test(dependsOnMethods = { "perft120_1" })
    public void perft120_2(){
        Board b = new Board("n1n5/1Pk5/8/8/8/8/5Kp1/5N1N w - - 0 1");
        Assert.assertEquals(perft(b,2),421);
    }

    @Test(dependsOnMethods = { "perft120_2" })
    public void perft120_3(){
        Board b = new Board("n1n5/1Pk5/8/8/8/8/5Kp1/5N1N w - - 0 1");
        Assert.assertEquals(perft(b,3),7421);
    }

    @Test(dependsOnMethods = { "perft120_3" })
    public void perft120_4(){
        Board b = new Board("n1n5/1Pk5/8/8/8/8/5Kp1/5N1N w - - 0 1");
        Assert.assertEquals(perft(b,4),124608);
    }

    @Test(dependsOnMethods = { "perft120_4" })
    public void perft120_5(){
        Board b = new Board("n1n5/1Pk5/8/8/8/8/5Kp1/5N1N w - - 0 1");
        Assert.assertEquals(perft(b,5),2193768);
    }

    @Test(dependsOnMethods = { "perft120_5" })
    public void perft120_6(){
        Board b = new Board("n1n5/1Pk5/8/8/8/8/5Kp1/5N1N w - - 0 1");
        Assert.assertEquals(perft(b,6),37665329);
    }

    @Test
    public void perft121_1(){
        Board b = new Board("8/PPPk4/8/8/8/8/4Kppp/8 w - - 0 1");
        Assert.assertEquals(perft(b,1),18);
    }

    @Test(dependsOnMethods = { "perft121_1" })
    public void perft121_2(){
        Board b = new Board("8/PPPk4/8/8/8/8/4Kppp/8 w - - 0 1");
        Assert.assertEquals(perft(b,2),270);
    }

    @Test(dependsOnMethods = { "perft121_2" })
    public void perft121_3(){
        Board b = new Board("8/PPPk4/8/8/8/8/4Kppp/8 w - - 0 1");
        Assert.assertEquals(perft(b,3),4699);
    }

    @Test(dependsOnMethods = { "perft121_3" })
    public void perft121_4(){
        Board b = new Board("8/PPPk4/8/8/8/8/4Kppp/8 w - - 0 1");
        Assert.assertEquals(perft(b,4),79355);
    }

    @Test(dependsOnMethods = { "perft121_4" })
    public void perft121_5(){
        Board b = new Board("8/PPPk4/8/8/8/8/4Kppp/8 w - - 0 1");
        Assert.assertEquals(perft(b,5),1533145);
    }

    @Test(dependsOnMethods = { "perft121_5" })
    public void perft121_6(){
        Board b = new Board("8/PPPk4/8/8/8/8/4Kppp/8 w - - 0 1");
        Assert.assertEquals(perft(b,6),28859283);
    }

    @Test
    public void perft122_1(){
        Board b = new Board("n1n5/PPPk4/8/8/8/8/4Kppp/5N1N w - - 0 1");
        Assert.assertEquals(perft(b,1),24);
    }

    @Test(dependsOnMethods = { "perft122_1" })
    public void perft122_2(){
        Board b = new Board("n1n5/PPPk4/8/8/8/8/4Kppp/5N1N w - - 0 1");
        Assert.assertEquals(perft(b,2),496);
    }

    @Test(dependsOnMethods = { "perft122_2" })
    public void perft122_3(){
        Board b = new Board("n1n5/PPPk4/8/8/8/8/4Kppp/5N1N w - - 0 1");
        Assert.assertEquals(perft(b,3),9483);
    }

    @Test(dependsOnMethods = { "perft122_3" })
    public void perft122_4(){
        Board b = new Board("n1n5/PPPk4/8/8/8/8/4Kppp/5N1N w - - 0 1");
        Assert.assertEquals(perft(b,4),182838);
    }

    @Test(dependsOnMethods = { "perft122_4" })
    public void perft122_5(){
        Board b = new Board("n1n5/PPPk4/8/8/8/8/4Kppp/5N1N w - - 0 1");
        Assert.assertEquals(perft(b,5),3605103);
    }

    @Test(dependsOnMethods = { "perft122_5" })
    public void perft122_6(){
        Board b = new Board("n1n5/PPPk4/8/8/8/8/4Kppp/5N1N w - - 0 1");
        Assert.assertEquals(perft(b,6),71179139);
    }

    @Test
    public void perft123_1(){
        Board b = new Board("8/Pk6/8/8/8/8/6Kp/8 b - - 0 1");
        Assert.assertEquals(perft(b,1),11);
    }

    @Test(dependsOnMethods = { "perft123_1" })
    public void perft123_2(){
        Board b = new Board("8/Pk6/8/8/8/8/6Kp/8 b - - 0 1");
        Assert.assertEquals(perft(b,2),97);
    }

    @Test(dependsOnMethods = { "perft123_2" })
    public void perft123_3(){
        Board b = new Board("8/Pk6/8/8/8/8/6Kp/8 b - - 0 1");
        Assert.assertEquals(perft(b,3),887);
    }

    @Test(dependsOnMethods = { "perft123_3" })
    public void perft123_4(){
        Board b = new Board("8/Pk6/8/8/8/8/6Kp/8 b - - 0 1");
        Assert.assertEquals(perft(b,4),8048);
    }

    @Test(dependsOnMethods = { "perft123_4" })
    public void perft123_5(){
        Board b = new Board("8/Pk6/8/8/8/8/6Kp/8 b - - 0 1");
        Assert.assertEquals(perft(b,5),90606);
    }

    @Test(dependsOnMethods = { "perft123_5" })
    public void perft123_6(){
        Board b = new Board("8/Pk6/8/8/8/8/6Kp/8 b - - 0 1");
        Assert.assertEquals(perft(b,6),1030499);
    }

    @Test
    public void perft124_1(){
        Board b = new Board("n1n5/1Pk5/8/8/8/8/5Kp1/5N1N b - - 0 1");
        Assert.assertEquals(perft(b,1),24);
    }

    @Test(dependsOnMethods = { "perft124_1" })
    public void perft124_2(){
        Board b = new Board("n1n5/1Pk5/8/8/8/8/5Kp1/5N1N b - - 0 1");
        Assert.assertEquals(perft(b,2),421);
    }

    @Test(dependsOnMethods = { "perft124_2" })
    public void perft124_3(){
        Board b = new Board("n1n5/1Pk5/8/8/8/8/5Kp1/5N1N b - - 0 1");
        Assert.assertEquals(perft(b,3),7421);
    }

    @Test(dependsOnMethods = { "perft124_3" })
    public void perft124_4(){
        Board b = new Board("n1n5/1Pk5/8/8/8/8/5Kp1/5N1N b - - 0 1");
        Assert.assertEquals(perft(b,4),124608);
    }

    @Test(dependsOnMethods = { "perft124_4" })
    public void perft124_5(){
        Board b = new Board("n1n5/1Pk5/8/8/8/8/5Kp1/5N1N b - - 0 1");
        Assert.assertEquals(perft(b,5),2193768);
    }

    @Test(dependsOnMethods = { "perft124_5" })
    public void perft124_6(){
        Board b = new Board("n1n5/1Pk5/8/8/8/8/5Kp1/5N1N b - - 0 1");
        Assert.assertEquals(perft(b,6),37665329);
    }

    @Test
    public void perft125_1(){
        Board b = new Board("8/PPPk4/8/8/8/8/4Kppp/8 b - - 0 1");
        Assert.assertEquals(perft(b,1),18);
    }

    @Test(dependsOnMethods = { "perft125_1" })
    public void perft125_2(){
        Board b = new Board("8/PPPk4/8/8/8/8/4Kppp/8 b - - 0 1");
        Assert.assertEquals(perft(b,2),270);
    }

    @Test(dependsOnMethods = { "perft125_2" })
    public void perft125_3(){
        Board b = new Board("8/PPPk4/8/8/8/8/4Kppp/8 b - - 0 1");
        Assert.assertEquals(perft(b,3),4699);
    }

    @Test(dependsOnMethods = { "perft125_3" })
    public void perft125_4(){
        Board b = new Board("8/PPPk4/8/8/8/8/4Kppp/8 b - - 0 1");
        Assert.assertEquals(perft(b,4),79355);
    }

    @Test(dependsOnMethods = { "perft125_4" })
    public void perft125_5(){
        Board b = new Board("8/PPPk4/8/8/8/8/4Kppp/8 b - - 0 1");
        Assert.assertEquals(perft(b,5),1533145);
    }

    @Test(dependsOnMethods = { "perft125_5" })
    public void perft125_6(){
        Board b = new Board("8/PPPk4/8/8/8/8/4Kppp/8 b - - 0 1");
        Assert.assertEquals(perft(b,6),28859283);
    }

    @Test
    public void perft126_1(){
        Board b = new Board("n1n5/PPPk4/8/8/8/8/4Kppp/5N1N b - - 0 1");
        Assert.assertEquals(perft(b,1),24);
    }

    @Test(dependsOnMethods = { "perft126_1" })
    public void perft126_2(){
        Board b = new Board("n1n5/PPPk4/8/8/8/8/4Kppp/5N1N b - - 0 1");
        Assert.assertEquals(perft(b,2),496);
    }

    @Test(dependsOnMethods = { "perft126_2" })
    public void perft126_3(){
        Board b = new Board("n1n5/PPPk4/8/8/8/8/4Kppp/5N1N b - - 0 1");
        Assert.assertEquals(perft(b,3),9483);
    }

    @Test(dependsOnMethods = { "perft126_3" })
    public void perft126_4(){
        Board b = new Board("n1n5/PPPk4/8/8/8/8/4Kppp/5N1N b - - 0 1");
        Assert.assertEquals(perft(b,4),182838);
    }

    @Test(dependsOnMethods = { "perft126_4" })
    public void perft126_5(){
        Board b = new Board("n1n5/PPPk4/8/8/8/8/4Kppp/5N1N b - - 0 1");
        Assert.assertEquals(perft(b,5),3605103);
    }

    @Test(dependsOnMethods = { "perft126_5" })
    public void perft126_6(){
        Board b = new Board("n1n5/PPPk4/8/8/8/8/4Kppp/5N1N b - - 0 1");
        Assert.assertEquals(perft(b,6),71179139);
    }

    @Test
    public void perft127_1(){
        Board b = new Board("r3k2r/p1ppqpb1/bn2pnp1/3PN3/1p2P3/2N2Q1p/PPPBBPPP/R3K2R w KQkq - 0 1 ");
        Assert.assertEquals(perft(b,1),48);
    }

    @Test(dependsOnMethods = { "perft127_1" })
    public void perft127_2(){
        Board b = new Board("r3k2r/p1ppqpb1/bn2pnp1/3PN3/1p2P3/2N2Q1p/PPPBBPPP/R3K2R w KQkq - 0 1 ");
        Assert.assertEquals(perft(b,2),2039);
    }

    @Test(dependsOnMethods = { "perft127_2" })
    public void perft127_3(){
        Board b = new Board("r3k2r/p1ppqpb1/bn2pnp1/3PN3/1p2P3/2N2Q1p/PPPBBPPP/R3K2R w KQkq - 0 1 ");
        Assert.assertEquals(perft(b,3),97862);
    }

    @Test(dependsOnMethods = { "perft127_3" })
    public void perft127_4(){
        Board b = new Board("r3k2r/p1ppqpb1/bn2pnp1/3PN3/1p2P3/2N2Q1p/PPPBBPPP/R3K2R w KQkq - 0 1 ");
        Assert.assertEquals(perft(b,4),4085603);
    }

    @Test(dependsOnMethods = { "perft127_4" })
    public void perft127_5(){
        Board b = new Board("r3k2r/p1ppqpb1/bn2pnp1/3PN3/1p2P3/2N2Q1p/PPPBBPPP/R3K2R w KQkq - 0 1 ");
        Assert.assertEquals(perft(b,5),193690690);
    }

    @Test
    public void temp() {
        Board b = new Board("8/2k2p2/2b3p1/P1p1Np2/1p3b2/1P1K4/5r2/R3R3 b - - 0 1");
        String next = "6k1/5p2/1p5p/p4Np1/5q2/Q6P/PPr5/3R3K w - - 1 0";
        b=new Board(next);
        System.out.println(b);
        Assert.assertEquals(perft(b,4),1468528);

    }


}
