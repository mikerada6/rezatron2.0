import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Test2 {

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

    private long perft(Board board, int depth) {
        ArrayList<Integer> moveList = board.generateMovesNeo(true);
        if (depth == 1)
            return moveList.size();
        long nodes = 0;
        if (!moveList.equals("")) {
            for (int i = 0; i < moveList.size(); i++) {
                board.move(moveList.get(i));
                nodes += diveIn(board,depth - 1);
                board.undo();
            }
        }
        return nodes;
    }

    private long diveIn(Board board, int depth) {
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
                nodes += diveIn(board, depth - 1);
                board.undo();
            }
        }
        return nodes;
    }
    @BeforeMethod
    public void setup()
    {
        //setup zobrist keys before the start of each test
        Zobrist.zobristFillArray();
        MinMax.clear();
    }

    @Test
    public void divide1()
    {
        Board b = new Board("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
        b.move(Board.translateToInt("a2a4"));
        b.move(Board.translateToInt("b7b5"));
        int moves =2;
        System.out.println(divide(b,5-moves));
        Assert.assertEquals(4865609, perft(b,5-moves));
    }

    @Test
    public void perft1()
    {
        Board b = new Board("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
        Assert.assertEquals(20, perft(b,1));
        Assert.assertEquals(400, perft(b,2));
        Assert.assertEquals(8902, perft(b,3));
        Assert.assertEquals(197281, perft(b,4));
        Assert.assertEquals(4865609, perft(b,5));
        Assert.assertEquals(119060324, perft(b,6));
    }

    @Test
    public void perft2()
    {
        Board b = new Board("3k4/3p4/8/K1P4r/8/8/8/8 b - - 0 1");
        Assert.assertEquals(18, perft(b,1));
        Assert.assertEquals(92, perft(b,2));
        Assert.assertEquals(1670, perft(b,3));
        Assert.assertEquals(10138, perft(b,4));
        Assert.assertEquals(185429, perft(b,5));
        Assert.assertEquals(1134888, perft(b,6));
    }

    @Test
    public void perft3()
    {
        Board b = new Board("4k3/8/8/8/8/8/8/4K2R w K - 0 1");
        Assert.assertEquals(15, perft(b,1));
        Assert.assertEquals(66, perft(b,2));
        Assert.assertEquals(1197, perft(b,3));
        Assert.assertEquals(7059, perft(b,4));
        Assert.assertEquals(133987, perft(b,5));
        Assert.assertEquals(764643, perft(b,6));
    }


    @Test
    public void perft4()
    {
        Board b = new Board("4k3/8/8/8/8/8/8/R3K3 w Q - 0 1");
        Assert.assertEquals(16, perft(b,1));
        Assert.assertEquals(71, perft(b,2));
        Assert.assertEquals(1287, perft(b,3));
        Assert.assertEquals(7626, perft(b,4));
        Assert.assertEquals(145232, perft(b,5));
        Assert.assertEquals(846648, perft(b,6));
    }

    @Test
    public void perft5()
    {
        Board b = new Board("4k2r/8/8/8/8/8/8/4K3 w k - 0 1");
        Assert.assertEquals(5, perft(b,1));
        Assert.assertEquals(75, perft(b,2));
        Assert.assertEquals(459, perft(b,3));
        Assert.assertEquals(8290, perft(b,4));
        Assert.assertEquals(47635, perft(b,5));
        Assert.assertEquals(899442, perft(b,6));
    }

    @Test
    public void perft6()
    {
        Board b = new Board("r3k3/8/8/8/8/8/8/4K3 w q - 0 1");
        Assert.assertEquals(5, perft(b,1));
        Assert.assertEquals(80, perft(b,2));
        Assert.assertEquals(493, perft(b,3));
        Assert.assertEquals(8897, perft(b,4));
        Assert.assertEquals(52710, perft(b,5));
        Assert.assertEquals(1001523, perft(b,6));
    }

    @Test
    public void perft7()
    {
        Board b = new Board("4k3/8/8/8/8/8/8/R3K2R w KQ - 0 1");
        Assert.assertEquals(26, perft(b,1));
        Assert.assertEquals(112, perft(b,2));
        Assert.assertEquals(3189, perft(b,3));
        Assert.assertEquals(17945, perft(b,4));
        Assert.assertEquals(532933, perft(b,5));
        Assert.assertEquals(2788982, perft(b,6));
    }

    @Test
    public void perft8()
    {
        Board b = new Board("r3k2r/8/8/8/8/8/8/4K3 w kq - 0 1");
        Assert.assertEquals(5, perft(b,1));
        Assert.assertEquals(130, perft(b,2));
        Assert.assertEquals(782, perft(b,3));
        Assert.assertEquals(22180, perft(b,4));
        Assert.assertEquals(118882, perft(b,5));
        Assert.assertEquals(3517770, perft(b,6));
    }

    @Test
    public void perft9()
    {
        Board b = new Board("8/8/8/8/8/8/6k1/4K2R w K - 0 1");
        Assert.assertEquals(12, perft(b,1));
        Assert.assertEquals(38, perft(b,2));
        Assert.assertEquals(564, perft(b,3));
        Assert.assertEquals(2219, perft(b,4));
        Assert.assertEquals(37735, perft(b,5));
        Assert.assertEquals(185867, perft(b,6));
    }

    @Test
    public void perft10()
    {
        Board b = new Board("8/8/8/8/8/8/1k6/R3K3 w Q - 0 1");
        Assert.assertEquals(15, perft(b,1));
        Assert.assertEquals(65, perft(b,2));
        Assert.assertEquals(1018, perft(b,3));
        Assert.assertEquals(4573, perft(b,4));
        Assert.assertEquals(80619, perft(b,5));
        Assert.assertEquals(413018, perft(b,6));
    }

    @Test
    public void perft11()
    {
        Board b = new Board("4k2r/6K1/8/8/8/8/8/8 w k - 0 1");
        Assert.assertEquals(3, perft(b,1));
        Assert.assertEquals(32, perft(b,2));
        Assert.assertEquals(134, perft(b,3));
        Assert.assertEquals(2073, perft(b,4));
        Assert.assertEquals(10485, perft(b,5));
        Assert.assertEquals(179869, perft(b,6));
    }

    @Test
    public void perft12()
    {
        Board b = new Board("r3k3/1K6/8/8/8/8/8/8 w q - 0 1");
        Assert.assertEquals(4, perft(b,1));
        Assert.assertEquals(49, perft(b,2));
        Assert.assertEquals(243, perft(b,3));
        Assert.assertEquals(3991, perft(b,4));
        Assert.assertEquals(20780, perft(b,5));
        Assert.assertEquals(367724, perft(b,6));
    }

    @Test
    public void perft13()
    {
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K2R w KQkq - 0 1");
        Assert.assertEquals(26, perft(b,1));
        Assert.assertEquals(568, perft(b,2));
        Assert.assertEquals(13744, perft(b,3));
        Assert.assertEquals(314346, perft(b,4));
        Assert.assertEquals(7594526, perft(b,5));
        Assert.assertEquals(179862938, perft(b,6));
    }

    @Test
    public void perft14()
    {
        Board b = new Board("r3k2r/8/8/8/8/8/8/1R2K2R w Kkq - 0 1");
        Assert.assertEquals(25, perft(b,1));
        Assert.assertEquals(567, perft(b,2));
        Assert.assertEquals(14095, perft(b,3));
        Assert.assertEquals(328965, perft(b,4));
        Assert.assertEquals(8153719, perft(b,5));
        Assert.assertEquals(195629489, perft(b,6));
    }

    @Test
    public void perft15()
    {
        Board b = new Board("r3k2r/8/8/8/8/8/8/2R1K2R w Kkq - 0 1");
        Assert.assertEquals(25, perft(b,1));
        Assert.assertEquals(548, perft(b,2));
        Assert.assertEquals(13502, perft(b,3));
        Assert.assertEquals(312835, perft(b,4));
        Assert.assertEquals(7736373, perft(b,5));
        Assert.assertEquals(184411439, perft(b,6));
    }

    @Test
    public void perft16()
    {
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K1R1 w Qkq - 0 1");
        Assert.assertEquals(25, perft(b,1));
        Assert.assertEquals(547, perft(b,2));
        Assert.assertEquals(13579, perft(b,3));
        Assert.assertEquals(316214, perft(b,4));
        Assert.assertEquals(7878456, perft(b,5));
        Assert.assertEquals(189224276, perft(b,6));
    }

    @Test
    public void perft17()
    {
        Board b = new Board("1r2k2r/8/8/8/8/8/8/R3K2R w KQk - 0 1");
        Assert.assertEquals(26, perft(b,1));
        Assert.assertEquals(583, perft(b,2));
        Assert.assertEquals(14252, perft(b,3));
        Assert.assertEquals(334705, perft(b,4));
        Assert.assertEquals(8198901, perft(b,5));
        Assert.assertEquals(198328929, perft(b,6));
    }

    @Test
    public void perft18()
    {
        Board b = new Board("2r1k2r/8/8/8/8/8/8/R3K2R w KQk - 0 1");
        Assert.assertEquals(25, perft(b,1));
        Assert.assertEquals(560, perft(b,2));
        Assert.assertEquals(13592, perft(b,3));
        Assert.assertEquals(317324, perft(b,4));
        Assert.assertEquals(7710115, perft(b,5));
        Assert.assertEquals(185959088, perft(b,6));
    }

    @Test
    public void perft19()
    {
        Board b = new Board("r3k1r1/8/8/8/8/8/8/R3K2R w KQq - 0 1");
        Assert.assertEquals(25, perft(b,1));
        Assert.assertEquals(560, perft(b,2));
        Assert.assertEquals(13607, perft(b,3));
        Assert.assertEquals(320792, perft(b,4));
        Assert.assertEquals(7848606, perft(b,5));
        Assert.assertEquals(190755813, perft(b,6));
    }

    @Test
    public void perft20()
    {
        Board b = new Board("4k3/8/8/8/8/8/8/4K2R b K - 0 1");
        Assert.assertEquals(5, perft(b,1));
        Assert.assertEquals(75, perft(b,2));
        Assert.assertEquals(459, perft(b,3));
        Assert.assertEquals(8290, perft(b,4));
        Assert.assertEquals(47635, perft(b,5));
        Assert.assertEquals(899442, perft(b,6));
    }

    @Test
    public void perft21()
    {
        Board b = new Board("4k3/8/8/8/8/8/8/R3K3 b Q - 0 1");
        Assert.assertEquals(5, perft(b,1));
        Assert.assertEquals(80, perft(b,2));
        Assert.assertEquals(493, perft(b,3));
        Assert.assertEquals(8897, perft(b,4));
        Assert.assertEquals(52710, perft(b,5));
        Assert.assertEquals(1001523, perft(b,6));
    }

    @Test
    public void perft22()
    {
        Board b = new Board("4k2r/8/8/8/8/8/8/4K3 b k - 0 1");
        Assert.assertEquals(15, perft(b,1));
        Assert.assertEquals(66, perft(b,2));
        Assert.assertEquals(1197, perft(b,3));
        Assert.assertEquals(7059, perft(b,4));
        Assert.assertEquals(133987, perft(b,5));
        Assert.assertEquals(764643, perft(b,6));
    }

    @Test
    public void perft23()
    {
        Board b = new Board("r3k3/8/8/8/8/8/8/4K3 b q - 0 1");
        Assert.assertEquals(16, perft(b,1));
        Assert.assertEquals(71, perft(b,2));
        Assert.assertEquals(1287, perft(b,3));
        Assert.assertEquals(7626, perft(b,4));
        Assert.assertEquals(145232, perft(b,5));
        Assert.assertEquals(846648, perft(b,6));
    }

    @Test
    public void perft24()
    {
        Board b = new Board("4k3/8/8/8/8/8/8/R3K2R b KQ - 0 1");
        Assert.assertEquals(5, perft(b,1));
        Assert.assertEquals(130, perft(b,2));
        Assert.assertEquals(782, perft(b,3));
        Assert.assertEquals(22180, perft(b,4));
        Assert.assertEquals(118882, perft(b,5));
        Assert.assertEquals(3517770, perft(b,6));
    }

    @Test
    public void perft25()
    {
        Board b = new Board("r3k2r/8/8/8/8/8/8/4K3 b kq - 0 1");
        Assert.assertEquals(26, perft(b,1));
        Assert.assertEquals(112, perft(b,2));
        Assert.assertEquals(3189, perft(b,3));
        Assert.assertEquals(17945, perft(b,4));
        Assert.assertEquals(532933, perft(b,5));
        Assert.assertEquals(2788982, perft(b,6));
    }

    @Test
    public void perft26()
    {
        Board b = new Board("8/8/8/8/8/8/6k1/4K2R b K - 0 1");
        Assert.assertEquals(3, perft(b,1));
        Assert.assertEquals(32, perft(b,2));
        Assert.assertEquals(134, perft(b,3));
        Assert.assertEquals(2073, perft(b,4));
        Assert.assertEquals(10485, perft(b,5));
        Assert.assertEquals(179869, perft(b,6));
    }

    @Test
    public void perft27()
    {
        Board b = new Board("8/8/8/8/8/8/1k6/R3K3 b Q - 0 1");
        Assert.assertEquals(4, perft(b,1));
        Assert.assertEquals(49, perft(b,2));
        Assert.assertEquals(243, perft(b,3));
        Assert.assertEquals(3991, perft(b,4));
        Assert.assertEquals(20780, perft(b,5));
        Assert.assertEquals(367724, perft(b,6));
    }

    @Test
    public void perft28()
    {
        Board b = new Board("4k2r/6K1/8/8/8/8/8/8 b k - 0 1");
        Assert.assertEquals(12, perft(b,1));
        Assert.assertEquals(38, perft(b,2));
        Assert.assertEquals(564, perft(b,3));
        Assert.assertEquals(2219, perft(b,4));
        Assert.assertEquals(37735, perft(b,5));
        Assert.assertEquals(185867, perft(b,6));
    }

    @Test
    public void perft29()
    {
        Board b = new Board("r3k3/1K6/8/8/8/8/8/8 b q - 0 1");
        Assert.assertEquals(15, perft(b,1));
        Assert.assertEquals(65, perft(b,2));
        Assert.assertEquals(1018, perft(b,3));
        Assert.assertEquals(4573, perft(b,4));
        Assert.assertEquals(80619, perft(b,5));
        Assert.assertEquals(413018, perft(b,6));
    }

    @Test
    public void perft30()
    {
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K2R b KQkq - 0 1");
        Assert.assertEquals(26, perft(b,1));
        Assert.assertEquals(568, perft(b,2));
        Assert.assertEquals(13744, perft(b,3));
        Assert.assertEquals(314346, perft(b,4));
        Assert.assertEquals(7594526, perft(b,5));
        Assert.assertEquals(179862938, perft(b,6));
    }

    @Test
    public void perft31()
    {
        Board b = new Board("r3k2r/8/8/8/8/8/8/1R2K2R b Kkq - 0 1");
        Assert.assertEquals(26, perft(b,1));
        Assert.assertEquals(583, perft(b,2));
        Assert.assertEquals(14252, perft(b,3));
        Assert.assertEquals(334705, perft(b,4));
        Assert.assertEquals(8198901, perft(b,5));
        Assert.assertEquals(198328929, perft(b,6));
    }

    @Test
    public void perft32()
    {
        Board b = new Board("r3k2r/8/8/8/8/8/8/2R1K2R b Kkq - 0 1");
        Assert.assertEquals(25, perft(b,1));
        Assert.assertEquals(560, perft(b,2));
        Assert.assertEquals(13592, perft(b,3));
        Assert.assertEquals(317324, perft(b,4));
        Assert.assertEquals(7710115, perft(b,5));
        Assert.assertEquals(185959088, perft(b,6));
    }

    @Test
    public void perft33()
    {
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K1R1 b Qkq - 0 1");
        Assert.assertEquals(25, perft(b,1));
        Assert.assertEquals(560, perft(b,2));
        Assert.assertEquals(13607, perft(b,3));
        Assert.assertEquals(320792, perft(b,4));
        Assert.assertEquals(7848606, perft(b,5));
        Assert.assertEquals(190755813, perft(b,6));
    }

    @Test
    public void perft34()
    {
        Board b = new Board("1r2k2r/8/8/8/8/8/8/R3K2R b KQk - 0 1");
        Assert.assertEquals(25, perft(b,1));
        Assert.assertEquals(567, perft(b,2));
        Assert.assertEquals(14095, perft(b,3));
        Assert.assertEquals(328965, perft(b,4));
        Assert.assertEquals(8153719, perft(b,5));
        Assert.assertEquals(195629489, perft(b,6));
    }

    @Test
    public void perft35()
    {
        Board b = new Board("2r1k2r/8/8/8/8/8/8/R3K2R b KQk - 0 1");
        Assert.assertEquals(25, perft(b,1));
        Assert.assertEquals(548, perft(b,2));
        Assert.assertEquals(13502, perft(b,3));
        Assert.assertEquals(312835, perft(b,4));
        Assert.assertEquals(7736373, perft(b,5));
        Assert.assertEquals(184411439, perft(b,6));
    }

    @Test
    public void perft36()
    {
        Board b = new Board("r3k1r1/8/8/8/8/8/8/R3K2R b KQq - 0 1");
        Assert.assertEquals(25, perft(b,1));
        Assert.assertEquals(547, perft(b,2));
        Assert.assertEquals(13579, perft(b,3));
        Assert.assertEquals(316214, perft(b,4));
        Assert.assertEquals(7878456, perft(b,5));
        Assert.assertEquals(189224276, perft(b,6));
    }

    @Test
    public void perft37()
    {
        Board b = new Board("8/1n4N1/2k5/8/8/5K2/1N4n1/8 w - - 0 1");
        Assert.assertEquals(14, perft(b,1));
        Assert.assertEquals(195, perft(b,2));
        Assert.assertEquals(2760, perft(b,3));
        Assert.assertEquals(38675, perft(b,4));
        Assert.assertEquals(570726, perft(b,5));
        Assert.assertEquals(8107539, perft(b,6));
    }

    @Test
    public void perft38()
    {
        Board b = new Board("8/1k6/8/5N2/8/4n3/8/2K5 w - - 0 1");
        Assert.assertEquals(11, perft(b,1));
        Assert.assertEquals(156, perft(b,2));
        Assert.assertEquals(1636, perft(b,3));
        Assert.assertEquals(20534, perft(b,4));
        Assert.assertEquals(223507, perft(b,5));
        Assert.assertEquals(2594412, perft(b,6));
    }

    @Test
    public void perft39()
    {
        Board b = new Board("8/8/4k3/3Nn3/3nN3/4K3/8/8 w - - 0 1");
        Assert.assertEquals(19, perft(b,1));
        Assert.assertEquals(289, perft(b,2));
        Assert.assertEquals(4442, perft(b,3));
        Assert.assertEquals(73584, perft(b,4));
        Assert.assertEquals(1198299, perft(b,5));
        Assert.assertEquals(19870403, perft(b,6));
    }

    @Test
    public void perft40()
    {
        Board b = new Board("K7/8/2n5/1n6/8/8/8/k6N w - - 0 1");
        Assert.assertEquals(3, perft(b,1));
        Assert.assertEquals(51, perft(b,2));
        Assert.assertEquals(345, perft(b,3));
        Assert.assertEquals(5301, perft(b,4));
        Assert.assertEquals(38348, perft(b,5));
        Assert.assertEquals(588695, perft(b,6));
    }

    @Test
    public void perft41()
    {
        Board b = new Board("k7/8/2N5/1N6/8/8/8/K6n w - - 0 1");
        Assert.assertEquals(17, perft(b,1));
        Assert.assertEquals(54, perft(b,2));
        Assert.assertEquals(835, perft(b,3));
        Assert.assertEquals(5910, perft(b,4));
        Assert.assertEquals(92250, perft(b,5));
        Assert.assertEquals(688780, perft(b,6));
    }

    @Test
    public void perft42()
    {
        Board b = new Board("8/1n4N1/2k5/8/8/5K2/1N4n1/8 b - - 0 1");
        Assert.assertEquals(15, perft(b,1));
        Assert.assertEquals(193, perft(b,2));
        Assert.assertEquals(2816, perft(b,3));
        Assert.assertEquals(40039, perft(b,4));
        Assert.assertEquals(582642, perft(b,5));
        Assert.assertEquals(8503277, perft(b,6));
    }

    @Test
    public void perft43()
    {
        Board b = new Board("8/1k6/8/5N2/8/4n3/8/2K5 b - - 0 1");
        Assert.assertEquals(16, perft(b,1));
        Assert.assertEquals(180, perft(b,2));
        Assert.assertEquals(2290, perft(b,3));
        Assert.assertEquals(24640, perft(b,4));
        Assert.assertEquals(288141, perft(b,5));
        Assert.assertEquals(3147566, perft(b,6));
    }

    @Test
    public void perft44()
    {
        Board b = new Board("8/8/3K4/3Nn3/3nN3/4k3/8/8 b - - 0 1");
        Assert.assertEquals(4, perft(b,1));
        Assert.assertEquals(68, perft(b,2));
        Assert.assertEquals(1118, perft(b,3));
        Assert.assertEquals(16199, perft(b,4));
        Assert.assertEquals(281190, perft(b,5));
        Assert.assertEquals(4405103, perft(b,6));
    }

    @Test
    public void perft45()
    {
        Board b = new Board("K7/8/2n5/1n6/8/8/8/k6N b - - 0 1");
        Assert.assertEquals(17, perft(b,1));
        Assert.assertEquals(54, perft(b,2));
        Assert.assertEquals(835, perft(b,3));
        Assert.assertEquals(5910, perft(b,4));
        Assert.assertEquals(92250, perft(b,5));
        Assert.assertEquals(688780, perft(b,6));
    }

    @Test
    public void perft46()
    {
        Board b = new Board("k7/8/2N5/1N6/8/8/8/K6n b - - 0 1");
        Assert.assertEquals(3, perft(b,1));
        Assert.assertEquals(51, perft(b,2));
        Assert.assertEquals(345, perft(b,3));
        Assert.assertEquals(5301, perft(b,4));
        Assert.assertEquals(38348, perft(b,5));
        Assert.assertEquals(588695, perft(b,6));
    }

    @Test
    public void perft47()
    {
        Board b = new Board("B6b/8/8/8/2K5/4k3/8/b6B w - - 0 1");
        Assert.assertEquals(17, perft(b,1));
        Assert.assertEquals(278, perft(b,2));
        Assert.assertEquals(4607, perft(b,3));
        Assert.assertEquals(76778, perft(b,4));
        Assert.assertEquals(1320507, perft(b,5));
        Assert.assertEquals(22823890, perft(b,6));
    }

    @Test
    public void perft48()
    {
        Board b = new Board("8/8/1B6/7b/7k/8/2B1b3/7K w - - 0 1");
        Assert.assertEquals(21, perft(b,1));
        Assert.assertEquals(316, perft(b,2));
        Assert.assertEquals(5744, perft(b,3));
        Assert.assertEquals(93338, perft(b,4));
        Assert.assertEquals(1713368, perft(b,5));
        Assert.assertEquals(28861171, perft(b,6));
    }

    @Test
    public void perft49()
    {
        Board b = new Board("k7/B7/1B6/1B6/8/8/8/K6b w - - 0 1");
        Assert.assertEquals(21, perft(b,1));
        Assert.assertEquals(144, perft(b,2));
        Assert.assertEquals(3242, perft(b,3));
        Assert.assertEquals(32955, perft(b,4));
        Assert.assertEquals(787524, perft(b,5));
        Assert.assertEquals(7881673, perft(b,6));
    }

    @Test
    public void perft50()
    {
        Board b = new Board("K7/b7/1b6/1b6/8/8/8/k6B w - - 0 1");
        Assert.assertEquals(7, perft(b,1));
        Assert.assertEquals(143, perft(b,2));
        Assert.assertEquals(1416, perft(b,3));
        Assert.assertEquals(31787, perft(b,4));
        Assert.assertEquals(310862, perft(b,5));
        Assert.assertEquals(7382896, perft(b,6));
    }

    @Test
    public void perft51()
    {
        Board b = new Board("B6b/8/8/8/2K5/5k2/8/b6B b - - 0 1");
        Assert.assertEquals(6, perft(b,1));
        Assert.assertEquals(106, perft(b,2));
        Assert.assertEquals(1829, perft(b,3));
        Assert.assertEquals(31151, perft(b,4));
        Assert.assertEquals(530585, perft(b,5));
        Assert.assertEquals(9250746, perft(b,6));
    }

    @Test
    public void perft52()
    {
        Board b = new Board("8/8/1B6/7b/7k/8/2B1b3/7K b - - 0 1");
        Assert.assertEquals(17, perft(b,1));
        Assert.assertEquals(309, perft(b,2));
        Assert.assertEquals(5133, perft(b,3));
        Assert.assertEquals(93603, perft(b,4));
        Assert.assertEquals(1591064, perft(b,5));
        Assert.assertEquals(29027891, perft(b,6));
    }

    @Test
    public void perft53()
    {
        Board b = new Board("k7/B7/1B6/1B6/8/8/8/K6b b - - 0 1");
        Assert.assertEquals(7, perft(b,1));
        Assert.assertEquals(143, perft(b,2));
        Assert.assertEquals(1416, perft(b,3));
        Assert.assertEquals(31787, perft(b,4));
        Assert.assertEquals(310862, perft(b,5));
        Assert.assertEquals(7382896, perft(b,6));
    }

    @Test
    public void perft54()
    {
        Board b = new Board("K7/b7/1b6/1b6/8/8/8/k6B b - - 0 1");
        Assert.assertEquals(21, perft(b,1));
        Assert.assertEquals(144, perft(b,2));
        Assert.assertEquals(3242, perft(b,3));
        Assert.assertEquals(32955, perft(b,4));
        Assert.assertEquals(787524, perft(b,5));
        Assert.assertEquals(7881673, perft(b,6));
    }

    @Test
    public void perft55()
    {
        Board b = new Board("7k/RR6/8/8/8/8/rr6/7K w - - 0 1");
        Assert.assertEquals(19, perft(b,1));
        Assert.assertEquals(275, perft(b,2));
        Assert.assertEquals(5300, perft(b,3));
        Assert.assertEquals(104342, perft(b,4));
        Assert.assertEquals(2161211, perft(b,5));
        Assert.assertEquals(44956585, perft(b,6));
    }

    @Test
    public void perft56()
    {
        Board b = new Board("R6r/8/8/2K5/5k2/8/8/r6R w - - 0 1");
        Assert.assertEquals(36, perft(b,1));
        Assert.assertEquals(1027, perft(b,2));
        Assert.assertEquals(29215, perft(b,3));
        Assert.assertEquals(771461, perft(b,4));
        Assert.assertEquals(20506480, perft(b,5));
        Assert.assertEquals(525169084, perft(b,6));
    }

    @Test
    public void perft57()
    {
        Board b = new Board("7k/RR6/8/8/8/8/rr6/7K b - - 0 1");
        Assert.assertEquals(19, perft(b,1));
        Assert.assertEquals(275, perft(b,2));
        Assert.assertEquals(5300, perft(b,3));
        Assert.assertEquals(104342, perft(b,4));
        Assert.assertEquals(2161211, perft(b,5));
        Assert.assertEquals(44956585, perft(b,6));
    }

    @Test
    public void perft58()
    {
        Board b = new Board("R6r/8/8/2K5/5k2/8/8/r6R b - - 0 1");
        Assert.assertEquals(36, perft(b,1));
        Assert.assertEquals(1027, perft(b,2));
        Assert.assertEquals(29227, perft(b,3));
        Assert.assertEquals(771368, perft(b,4));
        Assert.assertEquals(20521342, perft(b,5));
        Assert.assertEquals(524966748, perft(b,6));
    }

    @Test
    public void perft59()
    {
        Board b = new Board("6kq/8/8/8/8/8/8/7K w - - 0 1");
        Assert.assertEquals(2, perft(b,1));
        Assert.assertEquals(36, perft(b,2));
        Assert.assertEquals(143, perft(b,3));
        Assert.assertEquals(3637, perft(b,4));
        Assert.assertEquals(14893, perft(b,5));
        Assert.assertEquals(391507, perft(b,6));
    }

    @Test
    public void perft60()
    {
        Board b = new Board("6KQ/8/8/8/8/8/8/7k b - - 0 1");
        Assert.assertEquals(2, perft(b,1));
        Assert.assertEquals(36, perft(b,2));
        Assert.assertEquals(143, perft(b,3));
        Assert.assertEquals(3637, perft(b,4));
        Assert.assertEquals(14893, perft(b,5));
        Assert.assertEquals(391507, perft(b,6));
    }

    @Test
    public void perft61()
    {
        Board b = new Board("K7/8/8/3Q4/4q3/8/8/7k w - - 0 1");
        Assert.assertEquals(6, perft(b,1));
        Assert.assertEquals(35, perft(b,2));
        Assert.assertEquals(495, perft(b,3));
        Assert.assertEquals(8349, perft(b,4));
        Assert.assertEquals(166741, perft(b,5));
        Assert.assertEquals(3370175, perft(b,6));
    }

    @Test
    public void perft62()
    {
        Board b = new Board("6qk/8/8/8/8/8/8/7K b - - 0 1");
        Assert.assertEquals(22, perft(b,1));
        Assert.assertEquals(43, perft(b,2));
        Assert.assertEquals(1015, perft(b,3));
        Assert.assertEquals(4167, perft(b,4));
        Assert.assertEquals(105749, perft(b,5));
        Assert.assertEquals(419369, perft(b,6));
    }

    @Test
    public void perft63()
    {
        Board b = new Board("6KQ/8/8/8/8/8/8/7k b - - 0 1");
        Assert.assertEquals(2, perft(b,1));
        Assert.assertEquals(36, perft(b,2));
        Assert.assertEquals(143, perft(b,3));
        Assert.assertEquals(3637, perft(b,4));
        Assert.assertEquals(14893, perft(b,5));
        Assert.assertEquals(391507, perft(b,6));
    }

    @Test
    public void perft64()
    {
        Board b = new Board("K7/8/8/3Q4/4q3/8/8/7k b - - 0 1");
        Assert.assertEquals(6, perft(b,1));
        Assert.assertEquals(35, perft(b,2));
        Assert.assertEquals(495, perft(b,3));
        Assert.assertEquals(8349, perft(b,4));
        Assert.assertEquals(166741, perft(b,5));
        Assert.assertEquals(3370175, perft(b,6));
    }

    @Test
    public void perft65()
    {
        Board b = new Board("8/8/8/8/8/K7/P7/k7 w - - 0 1");
        Assert.assertEquals(3, perft(b,1));
        Assert.assertEquals(7, perft(b,2));
        Assert.assertEquals(43, perft(b,3));
        Assert.assertEquals(199, perft(b,4));
        Assert.assertEquals(1347, perft(b,5));
        Assert.assertEquals(6249, perft(b,6));
    }

    @Test
    public void perft66()
    {
        Board b = new Board("8/8/8/8/8/7K/7P/7k w - - 0 1");
        Assert.assertEquals(3, perft(b,1));
        Assert.assertEquals(7, perft(b,2));
        Assert.assertEquals(43, perft(b,3));
        Assert.assertEquals(199, perft(b,4));
        Assert.assertEquals(1347, perft(b,5));
        Assert.assertEquals(6249, perft(b,6));
    }

    @Test
    public void perft67()
    {
        Board b = new Board("K7/p7/k7/8/8/8/8/8 w - - 0 1");
        Assert.assertEquals(1, perft(b,1));
        Assert.assertEquals(3, perft(b,2));
        Assert.assertEquals(12, perft(b,3));
        Assert.assertEquals(80, perft(b,4));
        Assert.assertEquals(342, perft(b,5));
        Assert.assertEquals(2343, perft(b,6));
    }

    @Test
    public void perft68()
    {
        Board b = new Board("7K/7p/7k/8/8/8/8/8 w - - 0 1");
        Assert.assertEquals(1, perft(b,1));
        Assert.assertEquals(3, perft(b,2));
        Assert.assertEquals(12, perft(b,3));
        Assert.assertEquals(80, perft(b,4));
        Assert.assertEquals(342, perft(b,5));
        Assert.assertEquals(2343, perft(b,6));
    }

    @Test
    public void perft69()
    {
        Board b = new Board("8/2k1p3/3pP3/3P2K1/8/8/8/8 w - - 0 1");
        Assert.assertEquals(7, perft(b,1));
        Assert.assertEquals(35, perft(b,2));
        Assert.assertEquals(210, perft(b,3));
        Assert.assertEquals(1091, perft(b,4));
        Assert.assertEquals(7028, perft(b,5));
        Assert.assertEquals(34834, perft(b,6));
    }

    @Test
    public void perft70()
    {
        Board b = new Board("8/8/8/8/8/K7/P7/k7 b - - 0 1");
        Assert.assertEquals(1, perft(b,1));
        Assert.assertEquals(3, perft(b,2));
        Assert.assertEquals(12, perft(b,3));
        Assert.assertEquals(80, perft(b,4));
        Assert.assertEquals(342, perft(b,5));
        Assert.assertEquals(2343, perft(b,6));
    }

    @Test
    public void perft71()
    {
        Board b = new Board("8/8/8/8/8/7K/7P/7k b - - 0 1");
        Assert.assertEquals(1, perft(b,1));
        Assert.assertEquals(3, perft(b,2));
        Assert.assertEquals(12, perft(b,3));
        Assert.assertEquals(80, perft(b,4));
        Assert.assertEquals(342, perft(b,5));
        Assert.assertEquals(2343, perft(b,6));
    }

    @Test
    public void perft72()
    {
        Board b = new Board("K7/p7/k7/8/8/8/8/8 b - - 0 1");
        Assert.assertEquals(3, perft(b,1));
        Assert.assertEquals(7, perft(b,2));
        Assert.assertEquals(43, perft(b,3));
        Assert.assertEquals(199, perft(b,4));
        Assert.assertEquals(1347, perft(b,5));
        Assert.assertEquals(6249, perft(b,6));
    }

    @Test
    public void perft73()
    {
        Board b = new Board("7K/7p/7k/8/8/8/8/8 b - - 0 1");
        Assert.assertEquals(3, perft(b,1));
        Assert.assertEquals(7, perft(b,2));
        Assert.assertEquals(43, perft(b,3));
        Assert.assertEquals(199, perft(b,4));
        Assert.assertEquals(1347, perft(b,5));
        Assert.assertEquals(6249, perft(b,6));
    }

    @Test
    public void perft74()
    {
        Board b = new Board("8/2k1p3/3pP3/3P2K1/8/8/8/8 b - - 0 1");
        Assert.assertEquals(5, perft(b,1));
        Assert.assertEquals(35, perft(b,2));
        Assert.assertEquals(182, perft(b,3));
        Assert.assertEquals(1091, perft(b,4));
        Assert.assertEquals(5408, perft(b,5));
        Assert.assertEquals(34822, perft(b,6));
    }

    @Test
    public void perft75()
    {
        Board b = new Board("8/8/8/8/8/4k3/4P3/4K3 w - - 0 1");
        Assert.assertEquals(2, perft(b,1));
        Assert.assertEquals(8, perft(b,2));
        Assert.assertEquals(44, perft(b,3));
        Assert.assertEquals(282, perft(b,4));
        Assert.assertEquals(1814, perft(b,5));
        Assert.assertEquals(11848, perft(b,6));
    }

    @Test
    public void perft76()
    {
        Board b = new Board("4k3/4p3/4K3/8/8/8/8/8 b - - 0 1");
        Assert.assertEquals(2, perft(b,1));
        Assert.assertEquals(8, perft(b,2));
        Assert.assertEquals(44, perft(b,3));
        Assert.assertEquals(282, perft(b,4));
        Assert.assertEquals(1814, perft(b,5));
        Assert.assertEquals(11848, perft(b,6));
    }

    @Test
    public void perft77()
    {
        Board b = new Board("8/8/7k/7p/7P/7K/8/8 w - - 0 1");
        Assert.assertEquals(3, perft(b,1));
        Assert.assertEquals(9, perft(b,2));
        Assert.assertEquals(57, perft(b,3));
        Assert.assertEquals(360, perft(b,4));
        Assert.assertEquals(1969, perft(b,5));
        Assert.assertEquals(10724, perft(b,6));
    }

    @Test
    public void perft78()
    {
        Board b = new Board("8/8/k7/p7/P7/K7/8/8 w - - 0 1");
        Assert.assertEquals(3, perft(b,1));
        Assert.assertEquals(9, perft(b,2));
        Assert.assertEquals(57, perft(b,3));
        Assert.assertEquals(360, perft(b,4));
        Assert.assertEquals(1969, perft(b,5));
        Assert.assertEquals(10724, perft(b,6));
    }

    @Test
    public void perft79()
    {
        Board b = new Board("8/8/3k4/3p4/3P4/3K4/8/8 w - - 0 1");
        Assert.assertEquals(5, perft(b,1));
        Assert.assertEquals(25, perft(b,2));
        Assert.assertEquals(180, perft(b,3));
        Assert.assertEquals(1294, perft(b,4));
        Assert.assertEquals(8296, perft(b,5));
        Assert.assertEquals(53138, perft(b,6));
    }

    @Test
    public void perft80()
    {
        Board b = new Board("8/3k4/3p4/8/3P4/3K4/8/8 w - - 0 1");
        Assert.assertEquals(8, perft(b,1));
        Assert.assertEquals(61, perft(b,2));
        Assert.assertEquals(483, perft(b,3));
        Assert.assertEquals(3213, perft(b,4));
        Assert.assertEquals(23599, perft(b,5));
        Assert.assertEquals(157093, perft(b,6));
    }

    @Test
    public void perft81()
    {
        Board b = new Board("8/8/3k4/3p4/8/3P4/3K4/8 w - - 0 1");
        Assert.assertEquals(8, perft(b,1));
        Assert.assertEquals(61, perft(b,2));
        Assert.assertEquals(411, perft(b,3));
        Assert.assertEquals(3213, perft(b,4));
        Assert.assertEquals(21637, perft(b,5));
        Assert.assertEquals(158065, perft(b,6));
    }

    @Test
    public void perft82()
    {
        Board b = new Board("k7/8/3p4/8/3P4/8/8/7K w - - 0 1");
        Assert.assertEquals(4, perft(b,1));
        Assert.assertEquals(15, perft(b,2));
        Assert.assertEquals(90, perft(b,3));
        Assert.assertEquals(534, perft(b,4));
        Assert.assertEquals(3450, perft(b,5));
        Assert.assertEquals(20960, perft(b,6));
    }

    @Test
    public void perft83()
    {
        Board b = new Board("8/8/7k/7p/7P/7K/8/8 b - - 0 1");
        Assert.assertEquals(3, perft(b,1));
        Assert.assertEquals(9, perft(b,2));
        Assert.assertEquals(57, perft(b,3));
        Assert.assertEquals(360, perft(b,4));
        Assert.assertEquals(1969, perft(b,5));
        Assert.assertEquals(10724, perft(b,6));
    }

    @Test
    public void perft84()
    {
        Board b = new Board("8/8/k7/p7/P7/K7/8/8 b - - 0 1");
        Assert.assertEquals(3, perft(b,1));
        Assert.assertEquals(9, perft(b,2));
        Assert.assertEquals(57, perft(b,3));
        Assert.assertEquals(360, perft(b,4));
        Assert.assertEquals(1969, perft(b,5));
        Assert.assertEquals(10724, perft(b,6));
    }

    @Test
    public void perft85()
    {
        Board b = new Board("8/8/3k4/3p4/3P4/3K4/8/8 b - - 0 1");
        Assert.assertEquals(5, perft(b,1));
        Assert.assertEquals(25, perft(b,2));
        Assert.assertEquals(180, perft(b,3));
        Assert.assertEquals(1294, perft(b,4));
        Assert.assertEquals(8296, perft(b,5));
        Assert.assertEquals(53138, perft(b,6));
    }

    @Test
    public void perft86()
    {
        Board b = new Board("8/3k4/3p4/8/3P4/3K4/8/8 b - - 0 1");
        Assert.assertEquals(8, perft(b,1));
        Assert.assertEquals(61, perft(b,2));
        Assert.assertEquals(411, perft(b,3));
        Assert.assertEquals(3213, perft(b,4));
        Assert.assertEquals(21637, perft(b,5));
        Assert.assertEquals(158065, perft(b,6));
    }

    @Test
    public void perft87()
    {
        Board b = new Board("8/8/3k4/3p4/8/3P4/3K4/8 b - - 0 1");
        Assert.assertEquals(8, perft(b,1));
        Assert.assertEquals(61, perft(b,2));
        Assert.assertEquals(483, perft(b,3));
        Assert.assertEquals(3213, perft(b,4));
        Assert.assertEquals(23599, perft(b,5));
        Assert.assertEquals(157093, perft(b,6));
    }

    @Test
    public void perft88()
    {
        Board b = new Board("k7/8/3p4/8/3P4/8/8/7K b - - 0 1");
        Assert.assertEquals(4, perft(b,1));
        Assert.assertEquals(15, perft(b,2));
        Assert.assertEquals(89, perft(b,3));
        Assert.assertEquals(537, perft(b,4));
        Assert.assertEquals(3309, perft(b,5));
        Assert.assertEquals(21104, perft(b,6));
    }

    @Test
    public void perft89()
    {
        Board b = new Board("7k/3p4/8/8/3P4/8/8/K7 w - - 0 1");
        Assert.assertEquals(4, perft(b,1));
        Assert.assertEquals(19, perft(b,2));
        Assert.assertEquals(117, perft(b,3));
        Assert.assertEquals(720, perft(b,4));
        Assert.assertEquals(4661, perft(b,5));
        Assert.assertEquals(32191, perft(b,6));
    }

    @Test
    public void perft90()
    {
        Board b = new Board("7k/8/8/3p4/8/8/3P4/K7 w - - 0 1");
        Assert.assertEquals(5, perft(b,1));
        Assert.assertEquals(19, perft(b,2));
        Assert.assertEquals(116, perft(b,3));
        Assert.assertEquals(716, perft(b,4));
        Assert.assertEquals(4786, perft(b,5));
        Assert.assertEquals(30980, perft(b,6));
    }

    @Test
    public void perft91()
    {
        Board b = new Board("k7/8/8/7p/6P1/8/8/K7 w - - 0 1");
        Assert.assertEquals(5, perft(b,1));
        Assert.assertEquals(22, perft(b,2));
        Assert.assertEquals(139, perft(b,3));
        Assert.assertEquals(877, perft(b,4));
        Assert.assertEquals(6112, perft(b,5));
        Assert.assertEquals(41874, perft(b,6));
    }

    @Test
    public void perft92()
    {
        Board b = new Board("k7/8/7p/8/8/6P1/8/K7 w - - 0 1");
        Assert.assertEquals(4, perft(b,1));
        Assert.assertEquals(16, perft(b,2));
        Assert.assertEquals(101, perft(b,3));
        Assert.assertEquals(637, perft(b,4));
        Assert.assertEquals(4354, perft(b,5));
        Assert.assertEquals(29679, perft(b,6));
    }

    @Test
    public void perft93()
    {
        Board b = new Board("k7/8/8/6p1/7P/8/8/K7 w - - 0 1");
        Assert.assertEquals(5, perft(b,1));
        Assert.assertEquals(22, perft(b,2));
        Assert.assertEquals(139, perft(b,3));
        Assert.assertEquals(877, perft(b,4));
        Assert.assertEquals(6112, perft(b,5));
        Assert.assertEquals(41874, perft(b,6));
    }

    @Test
    public void perft94()
    {
        Board b = new Board("k7/8/6p1/8/8/7P/8/K7 w - - 0 1");
        Assert.assertEquals(4, perft(b,1));
        Assert.assertEquals(16, perft(b,2));
        Assert.assertEquals(101, perft(b,3));
        Assert.assertEquals(637, perft(b,4));
        Assert.assertEquals(4354, perft(b,5));
        Assert.assertEquals(29679, perft(b,6));
    }

    @Test
    public void perft95()
    {
        Board b = new Board("k7/8/8/3p4/4p3/8/8/7K w - - 0 1");
        Assert.assertEquals(3, perft(b,1));
        Assert.assertEquals(15, perft(b,2));
        Assert.assertEquals(84, perft(b,3));
        Assert.assertEquals(573, perft(b,4));
        Assert.assertEquals(3013, perft(b,5));
        Assert.assertEquals(22886, perft(b,6));
    }

    @Test
    public void perft96()
    {
        Board b = new Board("k7/8/3p4/8/8/4P3/8/7K w - - 0 1");
        Assert.assertEquals(4, perft(b,1));
        Assert.assertEquals(16, perft(b,2));
        Assert.assertEquals(101, perft(b,3));
        Assert.assertEquals(637, perft(b,4));
        Assert.assertEquals(4271, perft(b,5));
        Assert.assertEquals(28662, perft(b,6));
    }

    @Test
    public void perft97()
    {
        Board b = new Board("7k/3p4/8/8/3P4/8/8/K7 b - - 0 1");
        Assert.assertEquals(5, perft(b,1));
        Assert.assertEquals(19, perft(b,2));
        Assert.assertEquals(117, perft(b,3));
        Assert.assertEquals(720, perft(b,4));
        Assert.assertEquals(5014, perft(b,5));
        Assert.assertEquals(32167, perft(b,6));
    }

    @Test
    public void perft98()
    {
        Board b = new Board("7k/8/8/3p4/8/8/3P4/K7 b - - 0 1");
        Assert.assertEquals(4, perft(b,1));
        Assert.assertEquals(19, perft(b,2));
        Assert.assertEquals(117, perft(b,3));
        Assert.assertEquals(712, perft(b,4));
        Assert.assertEquals(4658, perft(b,5));
        Assert.assertEquals(30749, perft(b,6));
    }

    @Test
    public void perft99()
    {
        Board b = new Board("k7/8/8/7p/6P1/8/8/K7 b - - 0 1");
        Assert.assertEquals(5, perft(b,1));
        Assert.assertEquals(22, perft(b,2));
        Assert.assertEquals(139, perft(b,3));
        Assert.assertEquals(877, perft(b,4));
        Assert.assertEquals(6112, perft(b,5));
        Assert.assertEquals(41874, perft(b,6));
    }

    @Test
    public void perft100()
    {
        Board b = new Board("k7/8/7p/8/8/6P1/8/K7 b - - 0 1");
        Assert.assertEquals(4, perft(b,1));
        Assert.assertEquals(16, perft(b,2));
        Assert.assertEquals(101, perft(b,3));
        Assert.assertEquals(637, perft(b,4));
        Assert.assertEquals(4354, perft(b,5));
        Assert.assertEquals(29679, perft(b,6));
    }

    @Test
    public void perft101()
    {
        Board b = new Board("k7/8/8/6p1/7P/8/8/K7 b - - 0 1");
        Assert.assertEquals(5, perft(b,1));
        Assert.assertEquals(22, perft(b,2));
        Assert.assertEquals(139, perft(b,3));
        Assert.assertEquals(877, perft(b,4));
        Assert.assertEquals(6112, perft(b,5));
        Assert.assertEquals(41874, perft(b,6));
    }

    @Test
    public void perft102()
    {
        Board b = new Board("k7/8/6p1/8/8/7P/8/K7 b - - 0 1");
        Assert.assertEquals(4, perft(b,1));
        Assert.assertEquals(16, perft(b,2));
        Assert.assertEquals(101, perft(b,3));
        Assert.assertEquals(637, perft(b,4));
        Assert.assertEquals(4354, perft(b,5));
        Assert.assertEquals(29679, perft(b,6));
    }

    @Test
    public void perft103()
    {
        Board b = new Board("k7/8/8/3p4/4p3/8/8/7K b - - 0 1");
        Assert.assertEquals(5, perft(b,1));
        Assert.assertEquals(15, perft(b,2));
        Assert.assertEquals(102, perft(b,3));
        Assert.assertEquals(569, perft(b,4));
        Assert.assertEquals(4337, perft(b,5));
        Assert.assertEquals(22579, perft(b,6));
    }

    @Test
    public void perft104()
    {
        Board b = new Board("k7/8/3p4/8/8/4P3/8/7K b - - 0 1");
        Assert.assertEquals(4, perft(b,1));
        Assert.assertEquals(16, perft(b,2));
        Assert.assertEquals(101, perft(b,3));
        Assert.assertEquals(637, perft(b,4));
        Assert.assertEquals(4271, perft(b,5));
        Assert.assertEquals(28662, perft(b,6));
    }

    @Test
    public void perft105()
    {
        Board b = new Board("7k/8/8/p7/1P6/8/8/7K w - - 0 1");
        Assert.assertEquals(5, perft(b,1));
        Assert.assertEquals(22, perft(b,2));
        Assert.assertEquals(139, perft(b,3));
        Assert.assertEquals(877, perft(b,4));
        Assert.assertEquals(6112, perft(b,5));
        Assert.assertEquals(41874, perft(b,6));
    }

    @Test
    public void perft106()
    {
        Board b = new Board("7k/8/p7/8/8/1P6/8/7K w - - 0 1");
        Assert.assertEquals(4, perft(b,1));
        Assert.assertEquals(16, perft(b,2));
        Assert.assertEquals(101, perft(b,3));
        Assert.assertEquals(637, perft(b,4));
        Assert.assertEquals(4354, perft(b,5));
        Assert.assertEquals(29679, perft(b,6));
    }

    @Test
    public void perft107()
    {
        Board b = new Board("7k/8/8/1p6/P7/8/8/7K w - - 0 1");
        Assert.assertEquals(5, perft(b,1));
        Assert.assertEquals(22, perft(b,2));
        Assert.assertEquals(139, perft(b,3));
        Assert.assertEquals(877, perft(b,4));
        Assert.assertEquals(6112, perft(b,5));
        Assert.assertEquals(41874, perft(b,6));
    }

    @Test
    public void perft108()
    {
        Board b = new Board("7k/8/1p6/8/8/P7/8/7K w - - 0 1");
        Assert.assertEquals(4, perft(b,1));
        Assert.assertEquals(16, perft(b,2));
        Assert.assertEquals(101, perft(b,3));
        Assert.assertEquals(637, perft(b,4));
        Assert.assertEquals(4354, perft(b,5));
        Assert.assertEquals(29679, perft(b,6));
    }

    @Test
    public void perft109()
    {
        Board b = new Board("k7/7p/8/8/8/8/6P1/K7 w - - 0 1");
        Assert.assertEquals(5, perft(b,1));
        Assert.assertEquals(25, perft(b,2));
        Assert.assertEquals(161, perft(b,3));
        Assert.assertEquals(1035, perft(b,4));
        Assert.assertEquals(7574, perft(b,5));
        Assert.assertEquals(55338, perft(b,6));
    }

    @Test
    public void perft110()
    {
        Board b = new Board("k7/6p1/8/8/8/8/7P/K7 w - - 0 1");
        Assert.assertEquals(5, perft(b,1));
        Assert.assertEquals(25, perft(b,2));
        Assert.assertEquals(161, perft(b,3));
        Assert.assertEquals(1035, perft(b,4));
        Assert.assertEquals(7574, perft(b,5));
        Assert.assertEquals(55338, perft(b,6));
    }

    @Test
    public void perft111()
    {
        Board b = new Board("3k4/3pp3/8/8/8/8/3PP3/3K4 w - - 0 1");
        Assert.assertEquals(7, perft(b,1));
        Assert.assertEquals(49, perft(b,2));
        Assert.assertEquals(378, perft(b,3));
        Assert.assertEquals(2902, perft(b,4));
        Assert.assertEquals(24122, perft(b,5));
        Assert.assertEquals(199002, perft(b,6));
    }

    @Test
    public void perft112()
    {
        Board b = new Board("7k/8/8/p7/1P6/8/8/7K b - - 0 1");
        Assert.assertEquals(5, perft(b,1));
        Assert.assertEquals(22, perft(b,2));
        Assert.assertEquals(139, perft(b,3));
        Assert.assertEquals(877, perft(b,4));
        Assert.assertEquals(6112, perft(b,5));
        Assert.assertEquals(41874, perft(b,6));
    }

    @Test
    public void perft113()
    {
        Board b = new Board("7k/8/p7/8/8/1P6/8/7K b - - 0 1");
        Assert.assertEquals(4, perft(b,1));
        Assert.assertEquals(16, perft(b,2));
        Assert.assertEquals(101, perft(b,3));
        Assert.assertEquals(637, perft(b,4));
        Assert.assertEquals(4354, perft(b,5));
        Assert.assertEquals(29679, perft(b,6));
    }

    @Test
    public void perft114()
    {
        Board b = new Board("7k/8/8/1p6/P7/8/8/7K b - - 0 1");
        Assert.assertEquals(5, perft(b,1));
        Assert.assertEquals(22, perft(b,2));
        Assert.assertEquals(139, perft(b,3));
        Assert.assertEquals(877, perft(b,4));
        Assert.assertEquals(6112, perft(b,5));
        Assert.assertEquals(41874, perft(b,6));
    }

    @Test
    public void perft115()
    {
        Board b = new Board("7k/8/1p6/8/8/P7/8/7K b - - 0 1");
        Assert.assertEquals(4, perft(b,1));
        Assert.assertEquals(16, perft(b,2));
        Assert.assertEquals(101, perft(b,3));
        Assert.assertEquals(637, perft(b,4));
        Assert.assertEquals(4354, perft(b,5));
        Assert.assertEquals(29679, perft(b,6));
    }

    @Test
    public void perft116()
    {
        Board b = new Board("k7/7p/8/8/8/8/6P1/K7 b - - 0 1");
        Assert.assertEquals(5, perft(b,1));
        Assert.assertEquals(25, perft(b,2));
        Assert.assertEquals(161, perft(b,3));
        Assert.assertEquals(1035, perft(b,4));
        Assert.assertEquals(7574, perft(b,5));
        Assert.assertEquals(55338, perft(b,6));
    }

    @Test
    public void perft117()
    {
        Board b = new Board("k7/6p1/8/8/8/8/7P/K7 b - - 0 1");
        Assert.assertEquals(5, perft(b,1));
        Assert.assertEquals(25, perft(b,2));
        Assert.assertEquals(161, perft(b,3));
        Assert.assertEquals(1035, perft(b,4));
        Assert.assertEquals(7574, perft(b,5));
        Assert.assertEquals(55338, perft(b,6));
    }

    @Test
    public void perft118()
    {
        Board b = new Board("3k4/3pp3/8/8/8/8/3PP3/3K4 b - - 0 1");
        Assert.assertEquals(7, perft(b,1));
        Assert.assertEquals(49, perft(b,2));
        Assert.assertEquals(378, perft(b,3));
        Assert.assertEquals(2902, perft(b,4));
        Assert.assertEquals(24122, perft(b,5));
        Assert.assertEquals(199002, perft(b,6));
    }

    @Test
    public void perft119()
    {
        Board b = new Board("8/Pk6/8/8/8/8/6Kp/8 w - - 0 1");
        Assert.assertEquals(11, perft(b,1));
        Assert.assertEquals(97, perft(b,2));
        Assert.assertEquals(887, perft(b,3));
        Assert.assertEquals(8048, perft(b,4));
        Assert.assertEquals(90606, perft(b,5));
        Assert.assertEquals(1030499, perft(b,6));
    }

    @Test
    public void perft120()
    {
        Board b = new Board("n1n5/1Pk5/8/8/8/8/5Kp1/5N1N w - - 0 1");
        Assert.assertEquals(24, perft(b,1));
        Assert.assertEquals(421, perft(b,2));
        Assert.assertEquals(7421, perft(b,3));
        Assert.assertEquals(124608, perft(b,4));
        Assert.assertEquals(2193768, perft(b,5));
        Assert.assertEquals(37665329, perft(b,6));
    }

    @Test
    public void perft121()
    {
        Board b = new Board("8/PPPk4/8/8/8/8/4Kppp/8 w - - 0 1");
        Assert.assertEquals(18, perft(b,1));
        Assert.assertEquals(270, perft(b,2));
        Assert.assertEquals(4699, perft(b,3));
        Assert.assertEquals(79355, perft(b,4));
        Assert.assertEquals(1533145, perft(b,5));
        Assert.assertEquals(28859283, perft(b,6));
    }

    @Test
    public void perft122()
    {
        Board b = new Board("n1n5/PPPk4/8/8/8/8/4Kppp/5N1N w - - 0 1");
        Assert.assertEquals(24, perft(b,1));
        Assert.assertEquals(496, perft(b,2));
        Assert.assertEquals(9483, perft(b,3));
        Assert.assertEquals(182838, perft(b,4));
        Assert.assertEquals(3605103, perft(b,5));
        Assert.assertEquals(71179139, perft(b,6));
    }

    @Test
    public void perft123()
    {
        Board b = new Board("8/Pk6/8/8/8/8/6Kp/8 b - - 0 1");
        Assert.assertEquals(11, perft(b,1));
        Assert.assertEquals(97, perft(b,2));
        Assert.assertEquals(887, perft(b,3));
        Assert.assertEquals(8048, perft(b,4));
        Assert.assertEquals(90606, perft(b,5));
        Assert.assertEquals(1030499, perft(b,6));
    }

    @Test
    public void perft124()
    {
        Board b = new Board("n1n5/1Pk5/8/8/8/8/5Kp1/5N1N b - - 0 1");
        Assert.assertEquals(24, perft(b,1));
        Assert.assertEquals(421, perft(b,2));
        Assert.assertEquals(7421, perft(b,3));
        Assert.assertEquals(124608, perft(b,4));
        Assert.assertEquals(2193768, perft(b,5));
        Assert.assertEquals(37665329, perft(b,6));
    }

    @Test
    public void perft125()
    {
        Board b = new Board("8/PPPk4/8/8/8/8/4Kppp/8 b - - 0 1");
        Assert.assertEquals(18, perft(b,1));
        Assert.assertEquals(270, perft(b,2));
        Assert.assertEquals(4699, perft(b,3));
        Assert.assertEquals(79355, perft(b,4));
        Assert.assertEquals(1533145, perft(b,5));
        Assert.assertEquals(28859283, perft(b,6));
    }

    @Test
    public void perft126()
    {
        Board b = new Board("n1n5/PPPk4/8/8/8/8/4Kppp/5N1N b - - 0 1");
        Assert.assertEquals(24, perft(b,1));
        Assert.assertEquals(496, perft(b,2));
        Assert.assertEquals(9483, perft(b,3));
        Assert.assertEquals(182838, perft(b,4));
        Assert.assertEquals(3605103, perft(b,5));
        Assert.assertEquals(71179139, perft(b,6));
    }

    @Test
    public void perft127()
    {
        Board b = new Board("r3k2r/p1ppqpb1/bn2pnp1/3PN3/1p2P3/2N2Q1p/PPPBBPPP/R3K2R w KQkq - 0 1 ");
        Assert.assertEquals(48, perft(b,1));
        Assert.assertEquals(2039, perft(b,2));
        Assert.assertEquals(97862, perft(b,3));
        Assert.assertEquals(4085603, perft(b,4));
        long temp = perft(b,5);
        Assert.assertEquals(193690690,temp );
        System.out.println(temp);
    }

    @Test
    public void perft128()
    {
        Board b = new Board("rnbQkbnr/3ppppp/p1p5/8/8/2P5/PP1PPPPP/RNB1KBNR b KQkq - 0 ");
        Assert.assertEquals(67820026 , perft(b,7));
    }

    @Test
    public void perft129()
    {
        Board b = new Board("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
        Assert.assertEquals(119060324 , perft(b,6));
    }

    @Test
    public void temp() {
        Board b = new Board("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
        Board b1 = new Board("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
        perft(b1, 5);
        b.move("a2a4");
        b.move("h7h5");
        b.move("a4a5");
        System.out.println(divide(b, 2));
        Assert.assertEquals(perft(b, 5), 4865609);
    }

}
