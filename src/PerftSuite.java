import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.assertEquals;

public class PerftSuite {
    @Test
    public void perft0()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #1: rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
        Board b = new Board("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
        System.out.print("Perft(1): 000000020 nodes, Time: ");
        assertEquals(20, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000400 nodes, Time: ");
        assertEquals(400, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000008902 nodes, Time: ");
        assertEquals(8902, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000197281 nodes, Time: ");
        assertEquals(197281, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 004865609 nodes, Time: ");
        assertEquals(4865609, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 119060324 nodes, Time: ");
        assertEquals(119060324, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft1()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #2: 3k4/3p4/8/K1P4r/8/8/8/8 b - - 0 1");
        Board b = new Board("3k4/3p4/8/K1P4r/8/8/8/8 b - - 0 1");
        System.out.print("Perft(1): 000000018 nodes, Time: ");
        assertEquals(18, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000092 nodes, Time: ");
        assertEquals(92, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000001670 nodes, Time: ");
        assertEquals(1670, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000010138 nodes, Time: ");
        assertEquals(10138, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000185429 nodes, Time: ");
        assertEquals(185429, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 001134888 nodes, Time: ");
        assertEquals(1134888, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft2()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #3: 4k3/8/8/8/8/8/8/4K2R w K - 0 1");
        Board b = new Board("4k3/8/8/8/8/8/8/4K2R w K - 0 1");
        System.out.print("Perft(1): 000000015 nodes, Time: ");
        assertEquals(15, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000066 nodes, Time: ");
        assertEquals(66, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000001197 nodes, Time: ");
        assertEquals(1197, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000007059 nodes, Time: ");
        assertEquals(7059, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000133987 nodes, Time: ");
        assertEquals(133987, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000764643 nodes, Time: ");
        assertEquals(764643, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft3()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #4: 4k3/8/8/8/8/8/8/R3K3 w Q - 0 1");
        Board b = new Board("4k3/8/8/8/8/8/8/R3K3 w Q - 0 1");
        System.out.print("Perft(1): 000000016 nodes, Time: ");
        assertEquals(16, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000071 nodes, Time: ");
        assertEquals(71, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000001287 nodes, Time: ");
        assertEquals(1287, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000007626 nodes, Time: ");
        assertEquals(7626, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000145232 nodes, Time: ");
        assertEquals(145232, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000846648 nodes, Time: ");
        assertEquals(846648, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft4()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #5: 4k2r/8/8/8/8/8/8/4K3 w k - 0 1");
        Board b = new Board("4k2r/8/8/8/8/8/8/4K3 w k - 0 1");
        System.out.print("Perft(1): 000000005 nodes, Time: ");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000075 nodes, Time: ");
        assertEquals(75, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000459 nodes, Time: ");
        assertEquals(459, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000008290 nodes, Time: ");
        assertEquals(8290, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000047635 nodes, Time: ");
        assertEquals(47635, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000899442 nodes, Time: ");
        assertEquals(899442, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft5()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #6: r3k3/8/8/8/8/8/8/4K3 w q - 0 1");
        Board b = new Board("r3k3/8/8/8/8/8/8/4K3 w q - 0 1");
        System.out.print("Perft(1): 000000005 nodes, Time: ");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000080 nodes, Time: ");
        assertEquals(80, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000493 nodes, Time: ");
        assertEquals(493, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000008897 nodes, Time: ");
        assertEquals(8897, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000052710 nodes, Time: ");
        assertEquals(52710, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 001001523 nodes, Time: ");
        assertEquals(1001523, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft6()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #7: 4k3/8/8/8/8/8/8/R3K2R w KQ - 0 1");
        Board b = new Board("4k3/8/8/8/8/8/8/R3K2R w KQ - 0 1");
        System.out.print("Perft(1): 000000026 nodes, Time: ");
        assertEquals(26, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000112 nodes, Time: ");
        assertEquals(112, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000003189 nodes, Time: ");
        assertEquals(3189, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000017945 nodes, Time: ");
        assertEquals(17945, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000532933 nodes, Time: ");
        assertEquals(532933, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 002788982 nodes, Time: ");
        assertEquals(2788982, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft7()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #8: r3k2r/8/8/8/8/8/8/4K3 w kq - 0 1");
        Board b = new Board("r3k2r/8/8/8/8/8/8/4K3 w kq - 0 1");
        System.out.print("Perft(1): 000000005 nodes, Time: ");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000130 nodes, Time: ");
        assertEquals(130, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000782 nodes, Time: ");
        assertEquals(782, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000022180 nodes, Time: ");
        assertEquals(22180, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000118882 nodes, Time: ");
        assertEquals(118882, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 003517770 nodes, Time: ");
        assertEquals(3517770, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft8()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #9: 8/8/8/8/8/8/6k1/4K2R w K - 0 1");
        Board b = new Board("8/8/8/8/8/8/6k1/4K2R w K - 0 1");
        System.out.print("Perft(1): 000000012 nodes, Time: ");
        assertEquals(12, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000038 nodes, Time: ");
        assertEquals(38, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000564 nodes, Time: ");
        assertEquals(564, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000002219 nodes, Time: ");
        assertEquals(2219, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000037735 nodes, Time: ");
        assertEquals(37735, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000185867 nodes, Time: ");
        assertEquals(185867, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft9()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #10: 8/8/8/8/8/8/1k6/R3K3 w Q - 0 1");
        Board b = new Board("8/8/8/8/8/8/1k6/R3K3 w Q - 0 1");
        System.out.print("Perft(1): 000000015 nodes, Time: ");
        assertEquals(15, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000065 nodes, Time: ");
        assertEquals(65, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000001018 nodes, Time: ");
        assertEquals(1018, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000004573 nodes, Time: ");
        assertEquals(4573, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000080619 nodes, Time: ");
        assertEquals(80619, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000413018 nodes, Time: ");
        assertEquals(413018, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft10()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #11: 4k2r/6K1/8/8/8/8/8/8 w k - 0 1");
        Board b = new Board("4k2r/6K1/8/8/8/8/8/8 w k - 0 1");
        System.out.print("Perft(1): 000000003 nodes, Time: ");
        assertEquals(3, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000032 nodes, Time: ");
        assertEquals(32, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000134 nodes, Time: ");
        assertEquals(134, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000002073 nodes, Time: ");
        assertEquals(2073, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000010485 nodes, Time: ");
        assertEquals(10485, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000179869 nodes, Time: ");
        assertEquals(179869, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft11()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #12: r3k3/1K6/8/8/8/8/8/8 w q - 0 1");
        Board b = new Board("r3k3/1K6/8/8/8/8/8/8 w q - 0 1");
        System.out.print("Perft(1): 000000004 nodes, Time: ");
        assertEquals(4, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000049 nodes, Time: ");
        assertEquals(49, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000243 nodes, Time: ");
        assertEquals(243, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000003991 nodes, Time: ");
        assertEquals(3991, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000020780 nodes, Time: ");
        assertEquals(20780, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000367724 nodes, Time: ");
        assertEquals(367724, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft12()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #13: r3k2r/8/8/8/8/8/8/R3K2R w KQkq - 0 1");
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K2R w KQkq - 0 1");
        System.out.print("Perft(1): 000000026 nodes, Time: ");
        assertEquals(26, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000568 nodes, Time: ");
        assertEquals(568, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000013744 nodes, Time: ");
        assertEquals(13744, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000314346 nodes, Time: ");
        assertEquals(314346, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 007594526 nodes, Time: ");
        assertEquals(7594526, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 179862938 nodes, Time: ");
        assertEquals(179862938, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft13()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #14: r3k2r/8/8/8/8/8/8/1R2K2R w Kkq - 0 1");
        Board b = new Board("r3k2r/8/8/8/8/8/8/1R2K2R w Kkq - 0 1");
        System.out.print("Perft(1): 000000025 nodes, Time: ");
        assertEquals(25, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000567 nodes, Time: ");
        assertEquals(567, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000014095 nodes, Time: ");
        assertEquals(14095, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000328965 nodes, Time: ");
        assertEquals(328965, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 008153719 nodes, Time: ");
        assertEquals(8153719, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 195629489 nodes, Time: ");
        assertEquals(195629489, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft14()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #15: r3k2r/8/8/8/8/8/8/2R1K2R w Kkq - 0 1");
        Board b = new Board("r3k2r/8/8/8/8/8/8/2R1K2R w Kkq - 0 1");
        System.out.print("Perft(1): 000000025 nodes, Time: ");
        assertEquals(25, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000548 nodes, Time: ");
        assertEquals(548, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000013502 nodes, Time: ");
        assertEquals(13502, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000312835 nodes, Time: ");
        assertEquals(312835, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 007736373 nodes, Time: ");
        assertEquals(7736373, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 184411439 nodes, Time: ");
        assertEquals(184411439, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft15()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #16: r3k2r/8/8/8/8/8/8/R3K1R1 w Qkq - 0 1");
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K1R1 w Qkq - 0 1");
        System.out.print("Perft(1): 000000025 nodes, Time: ");
        assertEquals(25, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000547 nodes, Time: ");
        assertEquals(547, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000013579 nodes, Time: ");
        assertEquals(13579, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000316214 nodes, Time: ");
        assertEquals(316214, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 007878456 nodes, Time: ");
        assertEquals(7878456, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 189224276 nodes, Time: ");
        assertEquals(189224276, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft16()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #17: 1r2k2r/8/8/8/8/8/8/R3K2R w KQk - 0 1");
        Board b = new Board("1r2k2r/8/8/8/8/8/8/R3K2R w KQk - 0 1");
        System.out.print("Perft(1): 000000026 nodes, Time: ");
        assertEquals(26, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000583 nodes, Time: ");
        assertEquals(583, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000014252 nodes, Time: ");
        assertEquals(14252, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000334705 nodes, Time: ");
        assertEquals(334705, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 008198901 nodes, Time: ");
        assertEquals(8198901, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 198328929 nodes, Time: ");
        assertEquals(198328929, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft17()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #18: 2r1k2r/8/8/8/8/8/8/R3K2R w KQk - 0 1");
        Board b = new Board("2r1k2r/8/8/8/8/8/8/R3K2R w KQk - 0 1");
        System.out.print("Perft(1): 000000025 nodes, Time: ");
        assertEquals(25, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000560 nodes, Time: ");
        assertEquals(560, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000013592 nodes, Time: ");
        assertEquals(13592, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000317324 nodes, Time: ");
        assertEquals(317324, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 007710115 nodes, Time: ");
        assertEquals(7710115, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 185959088 nodes, Time: ");
        assertEquals(185959088, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft18()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #19: r3k1r1/8/8/8/8/8/8/R3K2R w KQq - 0 1");
        Board b = new Board("r3k1r1/8/8/8/8/8/8/R3K2R w KQq - 0 1");
        System.out.print("Perft(1): 000000025 nodes, Time: ");
        assertEquals(25, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000560 nodes, Time: ");
        assertEquals(560, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000013607 nodes, Time: ");
        assertEquals(13607, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000320792 nodes, Time: ");
        assertEquals(320792, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 007848606 nodes, Time: ");
        assertEquals(7848606, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 190755813 nodes, Time: ");
        assertEquals(190755813, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft19()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #20: 4k3/8/8/8/8/8/8/4K2R b K - 0 1");
        Board b = new Board("4k3/8/8/8/8/8/8/4K2R b K - 0 1");
        System.out.print("Perft(1): 000000005 nodes, Time: ");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000075 nodes, Time: ");
        assertEquals(75, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000459 nodes, Time: ");
        assertEquals(459, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000008290 nodes, Time: ");
        assertEquals(8290, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000047635 nodes, Time: ");
        assertEquals(47635, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000899442 nodes, Time: ");
        assertEquals(899442, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft20()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #21: 4k3/8/8/8/8/8/8/R3K3 b Q - 0 1");
        Board b = new Board("4k3/8/8/8/8/8/8/R3K3 b Q - 0 1");
        System.out.print("Perft(1): 000000005 nodes, Time: ");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000080 nodes, Time: ");
        assertEquals(80, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000493 nodes, Time: ");
        assertEquals(493, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000008897 nodes, Time: ");
        assertEquals(8897, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000052710 nodes, Time: ");
        assertEquals(52710, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 001001523 nodes, Time: ");
        assertEquals(1001523, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft21()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #22: 4k2r/8/8/8/8/8/8/4K3 b k - 0 1");
        Board b = new Board("4k2r/8/8/8/8/8/8/4K3 b k - 0 1");
        System.out.print("Perft(1): 000000015 nodes, Time: ");
        assertEquals(15, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000066 nodes, Time: ");
        assertEquals(66, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000001197 nodes, Time: ");
        assertEquals(1197, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000007059 nodes, Time: ");
        assertEquals(7059, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000133987 nodes, Time: ");
        assertEquals(133987, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000764643 nodes, Time: ");
        assertEquals(764643, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft22()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #23: r3k3/8/8/8/8/8/8/4K3 b q - 0 1");
        Board b = new Board("r3k3/8/8/8/8/8/8/4K3 b q - 0 1");
        System.out.print("Perft(1): 000000016 nodes, Time: ");
        assertEquals(16, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000071 nodes, Time: ");
        assertEquals(71, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000001287 nodes, Time: ");
        assertEquals(1287, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000007626 nodes, Time: ");
        assertEquals(7626, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000145232 nodes, Time: ");
        assertEquals(145232, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000846648 nodes, Time: ");
        assertEquals(846648, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft23()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #24: 4k3/8/8/8/8/8/8/R3K2R b KQ - 0 1");
        Board b = new Board("4k3/8/8/8/8/8/8/R3K2R b KQ - 0 1");
        System.out.print("Perft(1): 000000005 nodes, Time: ");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000130 nodes, Time: ");
        assertEquals(130, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000782 nodes, Time: ");
        assertEquals(782, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000022180 nodes, Time: ");
        assertEquals(22180, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000118882 nodes, Time: ");
        assertEquals(118882, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 003517770 nodes, Time: ");
        assertEquals(3517770, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft24()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #25: r3k2r/8/8/8/8/8/8/4K3 b kq - 0 1");
        Board b = new Board("r3k2r/8/8/8/8/8/8/4K3 b kq - 0 1");
        System.out.print("Perft(1): 000000026 nodes, Time: ");
        assertEquals(26, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000112 nodes, Time: ");
        assertEquals(112, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000003189 nodes, Time: ");
        assertEquals(3189, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000017945 nodes, Time: ");
        assertEquals(17945, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000532933 nodes, Time: ");
        assertEquals(532933, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 002788982 nodes, Time: ");
        assertEquals(2788982, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft25()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #26: 8/8/8/8/8/8/6k1/4K2R b K - 0 1");
        Board b = new Board("8/8/8/8/8/8/6k1/4K2R b K - 0 1");
        System.out.print("Perft(1): 000000003 nodes, Time: ");
        assertEquals(3, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000032 nodes, Time: ");
        assertEquals(32, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000134 nodes, Time: ");
        assertEquals(134, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000002073 nodes, Time: ");
        assertEquals(2073, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000010485 nodes, Time: ");
        assertEquals(10485, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000179869 nodes, Time: ");
        assertEquals(179869, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft26()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #27: 8/8/8/8/8/8/1k6/R3K3 b Q - 0 1");
        Board b = new Board("8/8/8/8/8/8/1k6/R3K3 b Q - 0 1");
        System.out.print("Perft(1): 000000004 nodes, Time: ");
        assertEquals(4, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000049 nodes, Time: ");
        assertEquals(49, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000243 nodes, Time: ");
        assertEquals(243, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000003991 nodes, Time: ");
        assertEquals(3991, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000020780 nodes, Time: ");
        assertEquals(20780, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000367724 nodes, Time: ");
        assertEquals(367724, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft27()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #28: 4k2r/6K1/8/8/8/8/8/8 b k - 0 1");
        Board b = new Board("4k2r/6K1/8/8/8/8/8/8 b k - 0 1");
        System.out.print("Perft(1): 000000012 nodes, Time: ");
        assertEquals(12, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000038 nodes, Time: ");
        assertEquals(38, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000564 nodes, Time: ");
        assertEquals(564, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000002219 nodes, Time: ");
        assertEquals(2219, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000037735 nodes, Time: ");
        assertEquals(37735, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000185867 nodes, Time: ");
        assertEquals(185867, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft28()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #29: r3k3/1K6/8/8/8/8/8/8 b q - 0 1");
        Board b = new Board("r3k3/1K6/8/8/8/8/8/8 b q - 0 1");
        System.out.print("Perft(1): 000000015 nodes, Time: ");
        assertEquals(15, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000065 nodes, Time: ");
        assertEquals(65, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000001018 nodes, Time: ");
        assertEquals(1018, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000004573 nodes, Time: ");
        assertEquals(4573, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000080619 nodes, Time: ");
        assertEquals(80619, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000413018 nodes, Time: ");
        assertEquals(413018, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft29()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #30: r3k2r/8/8/8/8/8/8/R3K2R b KQkq - 0 1");
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K2R b KQkq - 0 1");
        System.out.print("Perft(1): 000000026 nodes, Time: ");
        assertEquals(26, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000568 nodes, Time: ");
        assertEquals(568, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000013744 nodes, Time: ");
        assertEquals(13744, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000314346 nodes, Time: ");
        assertEquals(314346, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 007594526 nodes, Time: ");
        assertEquals(7594526, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 179862938 nodes, Time: ");
        assertEquals(179862938, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft30()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #31: r3k2r/8/8/8/8/8/8/1R2K2R b Kkq - 0 1");
        Board b = new Board("r3k2r/8/8/8/8/8/8/1R2K2R b Kkq - 0 1");
        System.out.print("Perft(1): 000000026 nodes, Time: ");
        assertEquals(26, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000583 nodes, Time: ");
        assertEquals(583, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000014252 nodes, Time: ");
        assertEquals(14252, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000334705 nodes, Time: ");
        assertEquals(334705, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 008198901 nodes, Time: ");
        assertEquals(8198901, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 198328929 nodes, Time: ");
        assertEquals(198328929, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft31()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #32: r3k2r/8/8/8/8/8/8/2R1K2R b Kkq - 0 1");
        Board b = new Board("r3k2r/8/8/8/8/8/8/2R1K2R b Kkq - 0 1");
        System.out.print("Perft(1): 000000025 nodes, Time: ");
        assertEquals(25, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000560 nodes, Time: ");
        assertEquals(560, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000013592 nodes, Time: ");
        assertEquals(13592, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000317324 nodes, Time: ");
        assertEquals(317324, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 007710115 nodes, Time: ");
        assertEquals(7710115, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 185959088 nodes, Time: ");
        assertEquals(185959088, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft32()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #33: r3k2r/8/8/8/8/8/8/R3K1R1 b Qkq - 0 1");
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K1R1 b Qkq - 0 1");
        System.out.print("Perft(1): 000000025 nodes, Time: ");
        assertEquals(25, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000560 nodes, Time: ");
        assertEquals(560, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000013607 nodes, Time: ");
        assertEquals(13607, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000320792 nodes, Time: ");
        assertEquals(320792, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 007848606 nodes, Time: ");
        assertEquals(7848606, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 190755813 nodes, Time: ");
        assertEquals(190755813, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft33()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #34: 1r2k2r/8/8/8/8/8/8/R3K2R b KQk - 0 1");
        Board b = new Board("1r2k2r/8/8/8/8/8/8/R3K2R b KQk - 0 1");
        System.out.print("Perft(1): 000000025 nodes, Time: ");
        assertEquals(25, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000567 nodes, Time: ");
        assertEquals(567, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000014095 nodes, Time: ");
        assertEquals(14095, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000328965 nodes, Time: ");
        assertEquals(328965, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 008153719 nodes, Time: ");
        assertEquals(8153719, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 195629489 nodes, Time: ");
        assertEquals(195629489, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft34()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #35: 2r1k2r/8/8/8/8/8/8/R3K2R b KQk - 0 1");
        Board b = new Board("2r1k2r/8/8/8/8/8/8/R3K2R b KQk - 0 1");
        System.out.print("Perft(1): 000000025 nodes, Time: ");
        assertEquals(25, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000548 nodes, Time: ");
        assertEquals(548, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000013502 nodes, Time: ");
        assertEquals(13502, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000312835 nodes, Time: ");
        assertEquals(312835, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 007736373 nodes, Time: ");
        assertEquals(7736373, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 184411439 nodes, Time: ");
        assertEquals(184411439, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft35()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #36: r3k1r1/8/8/8/8/8/8/R3K2R b KQq - 0 1");
        Board b = new Board("r3k1r1/8/8/8/8/8/8/R3K2R b KQq - 0 1");
        System.out.print("Perft(1): 000000025 nodes, Time: ");
        assertEquals(25, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000547 nodes, Time: ");
        assertEquals(547, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000013579 nodes, Time: ");
        assertEquals(13579, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000316214 nodes, Time: ");
        assertEquals(316214, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 007878456 nodes, Time: ");
        assertEquals(7878456, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 189224276 nodes, Time: ");
        assertEquals(189224276, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft36()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #37: 8/1n4N1/2k5/8/8/5K2/1N4n1/8 w - - 0 1");
        Board b = new Board("8/1n4N1/2k5/8/8/5K2/1N4n1/8 w - - 0 1");
        System.out.print("Perft(1): 000000014 nodes, Time: ");
        assertEquals(14, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000195 nodes, Time: ");
        assertEquals(195, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000002760 nodes, Time: ");
        assertEquals(2760, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000038675 nodes, Time: ");
        assertEquals(38675, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000570726 nodes, Time: ");
        assertEquals(570726, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 008107539 nodes, Time: ");
        assertEquals(8107539, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft37()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #38: 8/1k6/8/5N2/8/4n3/8/2K5 w - - 0 1");
        Board b = new Board("8/1k6/8/5N2/8/4n3/8/2K5 w - - 0 1");
        System.out.print("Perft(1): 000000011 nodes, Time: ");
        assertEquals(11, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000156 nodes, Time: ");
        assertEquals(156, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000001636 nodes, Time: ");
        assertEquals(1636, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000020534 nodes, Time: ");
        assertEquals(20534, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000223507 nodes, Time: ");
        assertEquals(223507, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 002594412 nodes, Time: ");
        assertEquals(2594412, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft38()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #39: 8/8/4k3/3Nn3/3nN3/4K3/8/8 w - - 0 1");
        Board b = new Board("8/8/4k3/3Nn3/3nN3/4K3/8/8 w - - 0 1");
        System.out.print("Perft(1): 000000019 nodes, Time: ");
        assertEquals(19, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000289 nodes, Time: ");
        assertEquals(289, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000004442 nodes, Time: ");
        assertEquals(4442, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000073584 nodes, Time: ");
        assertEquals(73584, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 001198299 nodes, Time: ");
        assertEquals(1198299, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 019870403 nodes, Time: ");
        assertEquals(19870403, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft39()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #40: K7/8/2n5/1n6/8/8/8/k6N w - - 0 1");
        Board b = new Board("K7/8/2n5/1n6/8/8/8/k6N w - - 0 1");
        System.out.print("Perft(1): 000000003 nodes, Time: ");
        assertEquals(3, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000051 nodes, Time: ");
        assertEquals(51, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000345 nodes, Time: ");
        assertEquals(345, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000005301 nodes, Time: ");
        assertEquals(5301, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000038348 nodes, Time: ");
        assertEquals(38348, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000588695 nodes, Time: ");
        assertEquals(588695, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft40()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #41: k7/8/2N5/1N6/8/8/8/K6n w - - 0 1");
        Board b = new Board("k7/8/2N5/1N6/8/8/8/K6n w - - 0 1");
        System.out.print("Perft(1): 000000017 nodes, Time: ");
        assertEquals(17, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000054 nodes, Time: ");
        assertEquals(54, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000835 nodes, Time: ");
        assertEquals(835, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000005910 nodes, Time: ");
        assertEquals(5910, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000092250 nodes, Time: ");
        assertEquals(92250, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000688780 nodes, Time: ");
        assertEquals(688780, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft41()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #42: 8/1n4N1/2k5/8/8/5K2/1N4n1/8 b - - 0 1");
        Board b = new Board("8/1n4N1/2k5/8/8/5K2/1N4n1/8 b - - 0 1");
        System.out.print("Perft(1): 000000015 nodes, Time: ");
        assertEquals(15, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000193 nodes, Time: ");
        assertEquals(193, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000002816 nodes, Time: ");
        assertEquals(2816, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000040039 nodes, Time: ");
        assertEquals(40039, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000582642 nodes, Time: ");
        assertEquals(582642, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 008503277 nodes, Time: ");
        assertEquals(8503277, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft42()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #43: 8/1k6/8/5N2/8/4n3/8/2K5 b - - 0 1");
        Board b = new Board("8/1k6/8/5N2/8/4n3/8/2K5 b - - 0 1");
        System.out.print("Perft(1): 000000016 nodes, Time: ");
        assertEquals(16, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000180 nodes, Time: ");
        assertEquals(180, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000002290 nodes, Time: ");
        assertEquals(2290, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000024640 nodes, Time: ");
        assertEquals(24640, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000288141 nodes, Time: ");
        assertEquals(288141, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 003147566 nodes, Time: ");
        assertEquals(3147566, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft43()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #44: 8/8/3K4/3Nn3/3nN3/4k3/8/8 b - - 0 1");
        Board b = new Board("8/8/3K4/3Nn3/3nN3/4k3/8/8 b - - 0 1");
        System.out.print("Perft(1): 000000004 nodes, Time: ");
        assertEquals(4, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000068 nodes, Time: ");
        assertEquals(68, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000001118 nodes, Time: ");
        assertEquals(1118, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000016199 nodes, Time: ");
        assertEquals(16199, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000281190 nodes, Time: ");
        assertEquals(281190, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 004405103 nodes, Time: ");
        assertEquals(4405103, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft44()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #45: K7/8/2n5/1n6/8/8/8/k6N b - - 0 1");
        Board b = new Board("K7/8/2n5/1n6/8/8/8/k6N b - - 0 1");
        System.out.print("Perft(1): 000000017 nodes, Time: ");
        assertEquals(17, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000054 nodes, Time: ");
        assertEquals(54, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000835 nodes, Time: ");
        assertEquals(835, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000005910 nodes, Time: ");
        assertEquals(5910, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000092250 nodes, Time: ");
        assertEquals(92250, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000688780 nodes, Time: ");
        assertEquals(688780, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft45()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #46: k7/8/2N5/1N6/8/8/8/K6n b - - 0 1");
        Board b = new Board("k7/8/2N5/1N6/8/8/8/K6n b - - 0 1");
        System.out.print("Perft(1): 000000003 nodes, Time: ");
        assertEquals(3, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000051 nodes, Time: ");
        assertEquals(51, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000345 nodes, Time: ");
        assertEquals(345, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000005301 nodes, Time: ");
        assertEquals(5301, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000038348 nodes, Time: ");
        assertEquals(38348, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000588695 nodes, Time: ");
        assertEquals(588695, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft46()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #47: B6b/8/8/8/2K5/4k3/8/b6B w - - 0 1");
        Board b = new Board("B6b/8/8/8/2K5/4k3/8/b6B w - - 0 1");
        System.out.print("Perft(1): 000000017 nodes, Time: ");
        assertEquals(17, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000278 nodes, Time: ");
        assertEquals(278, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000004607 nodes, Time: ");
        assertEquals(4607, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000076778 nodes, Time: ");
        assertEquals(76778, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 001320507 nodes, Time: ");
        assertEquals(1320507, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 022823890 nodes, Time: ");
        assertEquals(22823890, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft47()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #48: 8/8/1B6/7b/7k/8/2B1b3/7K w - - 0 1");
        Board b = new Board("8/8/1B6/7b/7k/8/2B1b3/7K w - - 0 1");
        System.out.print("Perft(1): 000000021 nodes, Time: ");
        assertEquals(21, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000316 nodes, Time: ");
        assertEquals(316, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000005744 nodes, Time: ");
        assertEquals(5744, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000093338 nodes, Time: ");
        assertEquals(93338, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 001713368 nodes, Time: ");
        assertEquals(1713368, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 028861171 nodes, Time: ");
        assertEquals(28861171, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft48()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #49: k7/B7/1B6/1B6/8/8/8/K6b w - - 0 1");
        Board b = new Board("k7/B7/1B6/1B6/8/8/8/K6b w - - 0 1");
        System.out.print("Perft(1): 000000021 nodes, Time: ");
        assertEquals(21, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000144 nodes, Time: ");
        assertEquals(144, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000003242 nodes, Time: ");
        assertEquals(3242, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000032955 nodes, Time: ");
        assertEquals(32955, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000787524 nodes, Time: ");
        assertEquals(787524, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 007881673 nodes, Time: ");
        assertEquals(7881673, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft49()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #50: K7/b7/1b6/1b6/8/8/8/k6B w - - 0 1");
        Board b = new Board("K7/b7/1b6/1b6/8/8/8/k6B w - - 0 1");
        System.out.print("Perft(1): 000000007 nodes, Time: ");
        assertEquals(7, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000143 nodes, Time: ");
        assertEquals(143, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000001416 nodes, Time: ");
        assertEquals(1416, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000031787 nodes, Time: ");
        assertEquals(31787, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000310862 nodes, Time: ");
        assertEquals(310862, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 007382896 nodes, Time: ");
        assertEquals(7382896, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft50()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #51: B6b/8/8/8/2K5/5k2/8/b6B b - - 0 1");
        Board b = new Board("B6b/8/8/8/2K5/5k2/8/b6B b - - 0 1");
        System.out.print("Perft(1): 000000006 nodes, Time: ");
        assertEquals(6, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000106 nodes, Time: ");
        assertEquals(106, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000001829 nodes, Time: ");
        assertEquals(1829, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000031151 nodes, Time: ");
        assertEquals(31151, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000530585 nodes, Time: ");
        assertEquals(530585, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 009250746 nodes, Time: ");
        assertEquals(9250746, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft51()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #52: 8/8/1B6/7b/7k/8/2B1b3/7K b - - 0 1");
        Board b = new Board("8/8/1B6/7b/7k/8/2B1b3/7K b - - 0 1");
        System.out.print("Perft(1): 000000017 nodes, Time: ");
        assertEquals(17, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000309 nodes, Time: ");
        assertEquals(309, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000005133 nodes, Time: ");
        assertEquals(5133, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000093603 nodes, Time: ");
        assertEquals(93603, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 001591064 nodes, Time: ");
        assertEquals(1591064, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 029027891 nodes, Time: ");
        assertEquals(29027891, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft52()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #53: k7/B7/1B6/1B6/8/8/8/K6b b - - 0 1");
        Board b = new Board("k7/B7/1B6/1B6/8/8/8/K6b b - - 0 1");
        System.out.print("Perft(1): 000000007 nodes, Time: ");
        assertEquals(7, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000143 nodes, Time: ");
        assertEquals(143, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000001416 nodes, Time: ");
        assertEquals(1416, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000031787 nodes, Time: ");
        assertEquals(31787, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000310862 nodes, Time: ");
        assertEquals(310862, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 007382896 nodes, Time: ");
        assertEquals(7382896, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft53()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #54: K7/b7/1b6/1b6/8/8/8/k6B b - - 0 1");
        Board b = new Board("K7/b7/1b6/1b6/8/8/8/k6B b - - 0 1");
        System.out.print("Perft(1): 000000021 nodes, Time: ");
        assertEquals(21, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000144 nodes, Time: ");
        assertEquals(144, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000003242 nodes, Time: ");
        assertEquals(3242, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000032955 nodes, Time: ");
        assertEquals(32955, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000787524 nodes, Time: ");
        assertEquals(787524, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 007881673 nodes, Time: ");
        assertEquals(7881673, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft54()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #55: 7k/RR6/8/8/8/8/rr6/7K w - - 0 1");
        Board b = new Board("7k/RR6/8/8/8/8/rr6/7K w - - 0 1");
        System.out.print("Perft(1): 000000019 nodes, Time: ");
        assertEquals(19, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000275 nodes, Time: ");
        assertEquals(275, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000005300 nodes, Time: ");
        assertEquals(5300, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000104342 nodes, Time: ");
        assertEquals(104342, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 002161211 nodes, Time: ");
        assertEquals(2161211, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 044956585 nodes, Time: ");
        assertEquals(44956585, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft55()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #56: R6r/8/8/2K5/5k2/8/8/r6R w - - 0 1");
        Board b = new Board("R6r/8/8/2K5/5k2/8/8/r6R w - - 0 1");
        System.out.print("Perft(1): 000000036 nodes, Time: ");
        assertEquals(36, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000001027 nodes, Time: ");
        assertEquals(1027, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000029215 nodes, Time: ");
        assertEquals(29215, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000771461 nodes, Time: ");
        assertEquals(771461, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 020506480 nodes, Time: ");
        assertEquals(20506480, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 525169084 nodes, Time: ");
        assertEquals(525169084, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft56()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #57: 7k/RR6/8/8/8/8/rr6/7K b - - 0 1");
        Board b = new Board("7k/RR6/8/8/8/8/rr6/7K b - - 0 1");
        System.out.print("Perft(1): 000000019 nodes, Time: ");
        assertEquals(19, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000275 nodes, Time: ");
        assertEquals(275, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000005300 nodes, Time: ");
        assertEquals(5300, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000104342 nodes, Time: ");
        assertEquals(104342, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 002161211 nodes, Time: ");
        assertEquals(2161211, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 044956585 nodes, Time: ");
        assertEquals(44956585, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft57()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #58: R6r/8/8/2K5/5k2/8/8/r6R b - - 0 1");
        Board b = new Board("R6r/8/8/2K5/5k2/8/8/r6R b - - 0 1");
        System.out.print("Perft(1): 000000036 nodes, Time: ");
        assertEquals(36, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000001027 nodes, Time: ");
        assertEquals(1027, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000029227 nodes, Time: ");
        assertEquals(29227, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000771368 nodes, Time: ");
        assertEquals(771368, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 020521342 nodes, Time: ");
        assertEquals(20521342, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 524966748 nodes, Time: ");
        assertEquals(524966748, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft58()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #59: 6kq/8/8/8/8/8/8/7K w - - 0 1");
        Board b = new Board("6kq/8/8/8/8/8/8/7K w - - 0 1");
        System.out.print("Perft(1): 000000002 nodes, Time: ");
        assertEquals(2, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000036 nodes, Time: ");
        assertEquals(36, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000143 nodes, Time: ");
        assertEquals(143, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000003637 nodes, Time: ");
        assertEquals(3637, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000014893 nodes, Time: ");
        assertEquals(14893, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000391507 nodes, Time: ");
        assertEquals(391507, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft59()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #60: 6KQ/8/8/8/8/8/8/7k b - - 0 1");
        Board b = new Board("6KQ/8/8/8/8/8/8/7k b - - 0 1");
        System.out.print("Perft(1): 000000002 nodes, Time: ");
        assertEquals(2, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000036 nodes, Time: ");
        assertEquals(36, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000143 nodes, Time: ");
        assertEquals(143, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000003637 nodes, Time: ");
        assertEquals(3637, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000014893 nodes, Time: ");
        assertEquals(14893, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000391507 nodes, Time: ");
        assertEquals(391507, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft60()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #61: K7/8/8/3Q4/4q3/8/8/7k w - - 0 1");
        Board b = new Board("K7/8/8/3Q4/4q3/8/8/7k w - - 0 1");
        System.out.print("Perft(1): 000000006 nodes, Time: ");
        assertEquals(6, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000035 nodes, Time: ");
        assertEquals(35, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000495 nodes, Time: ");
        assertEquals(495, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000008349 nodes, Time: ");
        assertEquals(8349, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000166741 nodes, Time: ");
        assertEquals(166741, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 003370175 nodes, Time: ");
        assertEquals(3370175, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft61()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #62: 6qk/8/8/8/8/8/8/7K b - - 0 1");
        Board b = new Board("6qk/8/8/8/8/8/8/7K b - - 0 1");
        System.out.print("Perft(1): 000000022 nodes, Time: ");
        assertEquals(22, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000043 nodes, Time: ");
        assertEquals(43, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000001015 nodes, Time: ");
        assertEquals(1015, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000004167 nodes, Time: ");
        assertEquals(4167, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000105749 nodes, Time: ");
        assertEquals(105749, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000419369 nodes, Time: ");
        assertEquals(419369, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft62()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #63: 6KQ/8/8/8/8/8/8/7k b - - 0 1");
        Board b = new Board("6KQ/8/8/8/8/8/8/7k b - - 0 1");
        System.out.print("Perft(1): 000000002 nodes, Time: ");
        assertEquals(2, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000036 nodes, Time: ");
        assertEquals(36, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000143 nodes, Time: ");
        assertEquals(143, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000003637 nodes, Time: ");
        assertEquals(3637, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000014893 nodes, Time: ");
        assertEquals(14893, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000391507 nodes, Time: ");
        assertEquals(391507, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft63()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #64: K7/8/8/3Q4/4q3/8/8/7k b - - 0 1");
        Board b = new Board("K7/8/8/3Q4/4q3/8/8/7k b - - 0 1");
        System.out.print("Perft(1): 000000006 nodes, Time: ");
        assertEquals(6, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000035 nodes, Time: ");
        assertEquals(35, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000495 nodes, Time: ");
        assertEquals(495, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000008349 nodes, Time: ");
        assertEquals(8349, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000166741 nodes, Time: ");
        assertEquals(166741, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 003370175 nodes, Time: ");
        assertEquals(3370175, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft64()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #65: 8/8/8/8/8/K7/P7/k7 w - - 0 1");
        Board b = new Board("8/8/8/8/8/K7/P7/k7 w - - 0 1");
        System.out.print("Perft(1): 000000003 nodes, Time: ");
        assertEquals(3, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000007 nodes, Time: ");
        assertEquals(7, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000043 nodes, Time: ");
        assertEquals(43, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000199 nodes, Time: ");
        assertEquals(199, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000001347 nodes, Time: ");
        assertEquals(1347, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000006249 nodes, Time: ");
        assertEquals(6249, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft65()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #66: 8/8/8/8/8/7K/7P/7k w - - 0 1");
        Board b = new Board("8/8/8/8/8/7K/7P/7k w - - 0 1");
        System.out.print("Perft(1): 000000003 nodes, Time: ");
        assertEquals(3, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000007 nodes, Time: ");
        assertEquals(7, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000043 nodes, Time: ");
        assertEquals(43, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000199 nodes, Time: ");
        assertEquals(199, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000001347 nodes, Time: ");
        assertEquals(1347, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000006249 nodes, Time: ");
        assertEquals(6249, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft66()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #67: K7/p7/k7/8/8/8/8/8 w - - 0 1");
        Board b = new Board("K7/p7/k7/8/8/8/8/8 w - - 0 1");
        System.out.print("Perft(1): 000000001 nodes, Time: ");
        assertEquals(1, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000003 nodes, Time: ");
        assertEquals(3, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000012 nodes, Time: ");
        assertEquals(12, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000080 nodes, Time: ");
        assertEquals(80, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000000342 nodes, Time: ");
        assertEquals(342, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000002343 nodes, Time: ");
        assertEquals(2343, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft67()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #68: 7K/7p/7k/8/8/8/8/8 w - - 0 1");
        Board b = new Board("7K/7p/7k/8/8/8/8/8 w - - 0 1");
        System.out.print("Perft(1): 000000001 nodes, Time: ");
        assertEquals(1, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000003 nodes, Time: ");
        assertEquals(3, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000012 nodes, Time: ");
        assertEquals(12, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000080 nodes, Time: ");
        assertEquals(80, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000000342 nodes, Time: ");
        assertEquals(342, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000002343 nodes, Time: ");
        assertEquals(2343, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft68()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #69: 8/2k1p3/3pP3/3P2K1/8/8/8/8 w - - 0 1");
        Board b = new Board("8/2k1p3/3pP3/3P2K1/8/8/8/8 w - - 0 1");
        System.out.print("Perft(1): 000000007 nodes, Time: ");
        assertEquals(7, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000035 nodes, Time: ");
        assertEquals(35, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000210 nodes, Time: ");
        assertEquals(210, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000001091 nodes, Time: ");
        assertEquals(1091, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000007028 nodes, Time: ");
        assertEquals(7028, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000034834 nodes, Time: ");
        assertEquals(34834, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft69()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #70: 8/8/8/8/8/K7/P7/k7 b - - 0 1");
        Board b = new Board("8/8/8/8/8/K7/P7/k7 b - - 0 1");
        System.out.print("Perft(1): 000000001 nodes, Time: ");
        assertEquals(1, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000003 nodes, Time: ");
        assertEquals(3, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000012 nodes, Time: ");
        assertEquals(12, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000080 nodes, Time: ");
        assertEquals(80, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000000342 nodes, Time: ");
        assertEquals(342, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000002343 nodes, Time: ");
        assertEquals(2343, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft70()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #71: 8/8/8/8/8/7K/7P/7k b - - 0 1");
        Board b = new Board("8/8/8/8/8/7K/7P/7k b - - 0 1");
        System.out.print("Perft(1): 000000001 nodes, Time: ");
        assertEquals(1, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000003 nodes, Time: ");
        assertEquals(3, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000012 nodes, Time: ");
        assertEquals(12, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000080 nodes, Time: ");
        assertEquals(80, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000000342 nodes, Time: ");
        assertEquals(342, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000002343 nodes, Time: ");
        assertEquals(2343, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft71()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #72: K7/p7/k7/8/8/8/8/8 b - - 0 1");
        Board b = new Board("K7/p7/k7/8/8/8/8/8 b - - 0 1");
        System.out.print("Perft(1): 000000003 nodes, Time: ");
        assertEquals(3, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000007 nodes, Time: ");
        assertEquals(7, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000043 nodes, Time: ");
        assertEquals(43, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000199 nodes, Time: ");
        assertEquals(199, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000001347 nodes, Time: ");
        assertEquals(1347, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000006249 nodes, Time: ");
        assertEquals(6249, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft72()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #73: 7K/7p/7k/8/8/8/8/8 b - - 0 1");
        Board b = new Board("7K/7p/7k/8/8/8/8/8 b - - 0 1");
        System.out.print("Perft(1): 000000003 nodes, Time: ");
        assertEquals(3, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000007 nodes, Time: ");
        assertEquals(7, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000043 nodes, Time: ");
        assertEquals(43, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000199 nodes, Time: ");
        assertEquals(199, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000001347 nodes, Time: ");
        assertEquals(1347, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000006249 nodes, Time: ");
        assertEquals(6249, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft73()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #74: 8/2k1p3/3pP3/3P2K1/8/8/8/8 b - - 0 1");
        Board b = new Board("8/2k1p3/3pP3/3P2K1/8/8/8/8 b - - 0 1");
        System.out.print("Perft(1): 000000005 nodes, Time: ");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000035 nodes, Time: ");
        assertEquals(35, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000182 nodes, Time: ");
        assertEquals(182, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000001091 nodes, Time: ");
        assertEquals(1091, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000005408 nodes, Time: ");
        assertEquals(5408, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000034822 nodes, Time: ");
        assertEquals(34822, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft74()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #75: 8/8/8/8/8/4k3/4P3/4K3 w - - 0 1");
        Board b = new Board("8/8/8/8/8/4k3/4P3/4K3 w - - 0 1");
        System.out.print("Perft(1): 000000002 nodes, Time: ");
        assertEquals(2, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000008 nodes, Time: ");
        assertEquals(8, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000044 nodes, Time: ");
        assertEquals(44, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000282 nodes, Time: ");
        assertEquals(282, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000001814 nodes, Time: ");
        assertEquals(1814, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000011848 nodes, Time: ");
        assertEquals(11848, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft75()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #76: 4k3/4p3/4K3/8/8/8/8/8 b - - 0 1");
        Board b = new Board("4k3/4p3/4K3/8/8/8/8/8 b - - 0 1");
        System.out.print("Perft(1): 000000002 nodes, Time: ");
        assertEquals(2, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000008 nodes, Time: ");
        assertEquals(8, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000044 nodes, Time: ");
        assertEquals(44, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000282 nodes, Time: ");
        assertEquals(282, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000001814 nodes, Time: ");
        assertEquals(1814, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000011848 nodes, Time: ");
        assertEquals(11848, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft76()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #77: 8/8/7k/7p/7P/7K/8/8 w - - 0 1");
        Board b = new Board("8/8/7k/7p/7P/7K/8/8 w - - 0 1");
        System.out.print("Perft(1): 000000003 nodes, Time: ");
        assertEquals(3, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000009 nodes, Time: ");
        assertEquals(9, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000057 nodes, Time: ");
        assertEquals(57, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000360 nodes, Time: ");
        assertEquals(360, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000001969 nodes, Time: ");
        assertEquals(1969, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000010724 nodes, Time: ");
        assertEquals(10724, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft77()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #78: 8/8/k7/p7/P7/K7/8/8 w - - 0 1");
        Board b = new Board("8/8/k7/p7/P7/K7/8/8 w - - 0 1");
        System.out.print("Perft(1): 000000003 nodes, Time: ");
        assertEquals(3, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000009 nodes, Time: ");
        assertEquals(9, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000057 nodes, Time: ");
        assertEquals(57, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000360 nodes, Time: ");
        assertEquals(360, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000001969 nodes, Time: ");
        assertEquals(1969, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000010724 nodes, Time: ");
        assertEquals(10724, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft78()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #79: 8/8/3k4/3p4/3P4/3K4/8/8 w - - 0 1");
        Board b = new Board("8/8/3k4/3p4/3P4/3K4/8/8 w - - 0 1");
        System.out.print("Perft(1): 000000005 nodes, Time: ");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000025 nodes, Time: ");
        assertEquals(25, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000180 nodes, Time: ");
        assertEquals(180, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000001294 nodes, Time: ");
        assertEquals(1294, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000008296 nodes, Time: ");
        assertEquals(8296, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000053138 nodes, Time: ");
        assertEquals(53138, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft79()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #80: 8/3k4/3p4/8/3P4/3K4/8/8 w - - 0 1");
        Board b = new Board("8/3k4/3p4/8/3P4/3K4/8/8 w - - 0 1");
        System.out.print("Perft(1): 000000008 nodes, Time: ");
        assertEquals(8, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000061 nodes, Time: ");
        assertEquals(61, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000483 nodes, Time: ");
        assertEquals(483, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000003213 nodes, Time: ");
        assertEquals(3213, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000023599 nodes, Time: ");
        assertEquals(23599, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000157093 nodes, Time: ");
        assertEquals(157093, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft80()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #81: 8/8/3k4/3p4/8/3P4/3K4/8 w - - 0 1");
        Board b = new Board("8/8/3k4/3p4/8/3P4/3K4/8 w - - 0 1");
        System.out.print("Perft(1): 000000008 nodes, Time: ");
        assertEquals(8, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000061 nodes, Time: ");
        assertEquals(61, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000411 nodes, Time: ");
        assertEquals(411, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000003213 nodes, Time: ");
        assertEquals(3213, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000021637 nodes, Time: ");
        assertEquals(21637, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000158065 nodes, Time: ");
        assertEquals(158065, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft81()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #82: k7/8/3p4/8/3P4/8/8/7K w - - 0 1");
        Board b = new Board("k7/8/3p4/8/3P4/8/8/7K w - - 0 1");
        System.out.print("Perft(1): 000000004 nodes, Time: ");
        assertEquals(4, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000015 nodes, Time: ");
        assertEquals(15, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000090 nodes, Time: ");
        assertEquals(90, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000534 nodes, Time: ");
        assertEquals(534, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000003450 nodes, Time: ");
        assertEquals(3450, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000020960 nodes, Time: ");
        assertEquals(20960, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft82()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #83: 8/8/7k/7p/7P/7K/8/8 b - - 0 1");
        Board b = new Board("8/8/7k/7p/7P/7K/8/8 b - - 0 1");
        System.out.print("Perft(1): 000000003 nodes, Time: ");
        assertEquals(3, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000009 nodes, Time: ");
        assertEquals(9, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000057 nodes, Time: ");
        assertEquals(57, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000360 nodes, Time: ");
        assertEquals(360, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000001969 nodes, Time: ");
        assertEquals(1969, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000010724 nodes, Time: ");
        assertEquals(10724, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft83()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #84: 8/8/k7/p7/P7/K7/8/8 b - - 0 1");
        Board b = new Board("8/8/k7/p7/P7/K7/8/8 b - - 0 1");
        System.out.print("Perft(1): 000000003 nodes, Time: ");
        assertEquals(3, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000009 nodes, Time: ");
        assertEquals(9, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000057 nodes, Time: ");
        assertEquals(57, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000360 nodes, Time: ");
        assertEquals(360, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000001969 nodes, Time: ");
        assertEquals(1969, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000010724 nodes, Time: ");
        assertEquals(10724, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft84()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #85: 8/8/3k4/3p4/3P4/3K4/8/8 b - - 0 1");
        Board b = new Board("8/8/3k4/3p4/3P4/3K4/8/8 b - - 0 1");
        System.out.print("Perft(1): 000000005 nodes, Time: ");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000025 nodes, Time: ");
        assertEquals(25, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000180 nodes, Time: ");
        assertEquals(180, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000001294 nodes, Time: ");
        assertEquals(1294, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000008296 nodes, Time: ");
        assertEquals(8296, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000053138 nodes, Time: ");
        assertEquals(53138, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft85()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #86: 8/3k4/3p4/8/3P4/3K4/8/8 b - - 0 1");
        Board b = new Board("8/3k4/3p4/8/3P4/3K4/8/8 b - - 0 1");
        System.out.print("Perft(1): 000000008 nodes, Time: ");
        assertEquals(8, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000061 nodes, Time: ");
        assertEquals(61, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000411 nodes, Time: ");
        assertEquals(411, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000003213 nodes, Time: ");
        assertEquals(3213, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000021637 nodes, Time: ");
        assertEquals(21637, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000158065 nodes, Time: ");
        assertEquals(158065, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft86()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #87: 8/8/3k4/3p4/8/3P4/3K4/8 b - - 0 1");
        Board b = new Board("8/8/3k4/3p4/8/3P4/3K4/8 b - - 0 1");
        System.out.print("Perft(1): 000000008 nodes, Time: ");
        assertEquals(8, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000061 nodes, Time: ");
        assertEquals(61, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000483 nodes, Time: ");
        assertEquals(483, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000003213 nodes, Time: ");
        assertEquals(3213, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000023599 nodes, Time: ");
        assertEquals(23599, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000157093 nodes, Time: ");
        assertEquals(157093, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft87()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #88: k7/8/3p4/8/3P4/8/8/7K b - - 0 1");
        Board b = new Board("k7/8/3p4/8/3P4/8/8/7K b - - 0 1");
        System.out.print("Perft(1): 000000004 nodes, Time: ");
        assertEquals(4, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000015 nodes, Time: ");
        assertEquals(15, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000089 nodes, Time: ");
        assertEquals(89, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000537 nodes, Time: ");
        assertEquals(537, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000003309 nodes, Time: ");
        assertEquals(3309, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000021104 nodes, Time: ");
        assertEquals(21104, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft88()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #89: 7k/3p4/8/8/3P4/8/8/K7 w - - 0 1");
        Board b = new Board("7k/3p4/8/8/3P4/8/8/K7 w - - 0 1");
        System.out.print("Perft(1): 000000004 nodes, Time: ");
        assertEquals(4, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000019 nodes, Time: ");
        assertEquals(19, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000117 nodes, Time: ");
        assertEquals(117, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000720 nodes, Time: ");
        assertEquals(720, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000004661 nodes, Time: ");
        assertEquals(4661, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000032191 nodes, Time: ");
        assertEquals(32191, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft89()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #90: 7k/8/8/3p4/8/8/3P4/K7 w - - 0 1");
        Board b = new Board("7k/8/8/3p4/8/8/3P4/K7 w - - 0 1");
        System.out.print("Perft(1): 000000005 nodes, Time: ");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000019 nodes, Time: ");
        assertEquals(19, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000116 nodes, Time: ");
        assertEquals(116, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000716 nodes, Time: ");
        assertEquals(716, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000004786 nodes, Time: ");
        assertEquals(4786, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000030980 nodes, Time: ");
        assertEquals(30980, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft90()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #91: k7/8/8/7p/6P1/8/8/K7 w - - 0 1");
        Board b = new Board("k7/8/8/7p/6P1/8/8/K7 w - - 0 1");
        System.out.print("Perft(1): 000000005 nodes, Time: ");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000022 nodes, Time: ");
        assertEquals(22, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000139 nodes, Time: ");
        assertEquals(139, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000877 nodes, Time: ");
        assertEquals(877, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000006112 nodes, Time: ");
        assertEquals(6112, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000041874 nodes, Time: ");
        assertEquals(41874, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft91()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #92: k7/8/7p/8/8/6P1/8/K7 w - - 0 1");
        Board b = new Board("k7/8/7p/8/8/6P1/8/K7 w - - 0 1");
        System.out.print("Perft(1): 000000004 nodes, Time: ");
        assertEquals(4, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000016 nodes, Time: ");
        assertEquals(16, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000101 nodes, Time: ");
        assertEquals(101, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000637 nodes, Time: ");
        assertEquals(637, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000004354 nodes, Time: ");
        assertEquals(4354, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000029679 nodes, Time: ");
        assertEquals(29679, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft92()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #93: k7/8/8/6p1/7P/8/8/K7 w - - 0 1");
        Board b = new Board("k7/8/8/6p1/7P/8/8/K7 w - - 0 1");
        System.out.print("Perft(1): 000000005 nodes, Time: ");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000022 nodes, Time: ");
        assertEquals(22, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000139 nodes, Time: ");
        assertEquals(139, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000877 nodes, Time: ");
        assertEquals(877, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000006112 nodes, Time: ");
        assertEquals(6112, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000041874 nodes, Time: ");
        assertEquals(41874, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft93()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #94: k7/8/6p1/8/8/7P/8/K7 w - - 0 1");
        Board b = new Board("k7/8/6p1/8/8/7P/8/K7 w - - 0 1");
        System.out.print("Perft(1): 000000004 nodes, Time: ");
        assertEquals(4, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000016 nodes, Time: ");
        assertEquals(16, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000101 nodes, Time: ");
        assertEquals(101, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000637 nodes, Time: ");
        assertEquals(637, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000004354 nodes, Time: ");
        assertEquals(4354, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000029679 nodes, Time: ");
        assertEquals(29679, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft94()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #95: k7/8/8/3p4/4p3/8/8/7K w - - 0 1");
        Board b = new Board("k7/8/8/3p4/4p3/8/8/7K w - - 0 1");
        System.out.print("Perft(1): 000000003 nodes, Time: ");
        assertEquals(3, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000015 nodes, Time: ");
        assertEquals(15, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000084 nodes, Time: ");
        assertEquals(84, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000573 nodes, Time: ");
        assertEquals(573, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000003013 nodes, Time: ");
        assertEquals(3013, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000022886 nodes, Time: ");
        assertEquals(22886, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft95()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #96: k7/8/3p4/8/8/4P3/8/7K w - - 0 1");
        Board b = new Board("k7/8/3p4/8/8/4P3/8/7K w - - 0 1");
        System.out.print("Perft(1): 000000004 nodes, Time: ");
        assertEquals(4, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000016 nodes, Time: ");
        assertEquals(16, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000101 nodes, Time: ");
        assertEquals(101, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000637 nodes, Time: ");
        assertEquals(637, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000004271 nodes, Time: ");
        assertEquals(4271, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000028662 nodes, Time: ");
        assertEquals(28662, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft96()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #97: 7k/3p4/8/8/3P4/8/8/K7 b - - 0 1");
        Board b = new Board("7k/3p4/8/8/3P4/8/8/K7 b - - 0 1");
        System.out.print("Perft(1): 000000005 nodes, Time: ");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000019 nodes, Time: ");
        assertEquals(19, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000117 nodes, Time: ");
        assertEquals(117, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000720 nodes, Time: ");
        assertEquals(720, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000005014 nodes, Time: ");
        assertEquals(5014, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000032167 nodes, Time: ");
        assertEquals(32167, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft97()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #98: 7k/8/8/3p4/8/8/3P4/K7 b - - 0 1");
        Board b = new Board("7k/8/8/3p4/8/8/3P4/K7 b - - 0 1");
        System.out.print("Perft(1): 000000004 nodes, Time: ");
        assertEquals(4, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000019 nodes, Time: ");
        assertEquals(19, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000117 nodes, Time: ");
        assertEquals(117, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000712 nodes, Time: ");
        assertEquals(712, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000004658 nodes, Time: ");
        assertEquals(4658, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000030749 nodes, Time: ");
        assertEquals(30749, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft98()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #99: k7/8/8/7p/6P1/8/8/K7 b - - 0 1");
        Board b = new Board("k7/8/8/7p/6P1/8/8/K7 b - - 0 1");
        System.out.print("Perft(1): 000000005 nodes, Time: ");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000022 nodes, Time: ");
        assertEquals(22, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000139 nodes, Time: ");
        assertEquals(139, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000877 nodes, Time: ");
        assertEquals(877, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000006112 nodes, Time: ");
        assertEquals(6112, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000041874 nodes, Time: ");
        assertEquals(41874, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft99()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #100: k7/8/7p/8/8/6P1/8/K7 b - - 0 1");
        Board b = new Board("k7/8/7p/8/8/6P1/8/K7 b - - 0 1");
        System.out.print("Perft(1): 000000004 nodes, Time: ");
        assertEquals(4, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000016 nodes, Time: ");
        assertEquals(16, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000101 nodes, Time: ");
        assertEquals(101, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000637 nodes, Time: ");
        assertEquals(637, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000004354 nodes, Time: ");
        assertEquals(4354, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000029679 nodes, Time: ");
        assertEquals(29679, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft100()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #101: k7/8/8/6p1/7P/8/8/K7 b - - 0 1");
        Board b = new Board("k7/8/8/6p1/7P/8/8/K7 b - - 0 1");
        System.out.print("Perft(1): 000000005 nodes, Time: ");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000022 nodes, Time: ");
        assertEquals(22, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000139 nodes, Time: ");
        assertEquals(139, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000877 nodes, Time: ");
        assertEquals(877, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000006112 nodes, Time: ");
        assertEquals(6112, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000041874 nodes, Time: ");
        assertEquals(41874, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft101()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #102: k7/8/6p1/8/8/7P/8/K7 b - - 0 1");
        Board b = new Board("k7/8/6p1/8/8/7P/8/K7 b - - 0 1");
        System.out.print("Perft(1): 000000004 nodes, Time: ");
        assertEquals(4, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000016 nodes, Time: ");
        assertEquals(16, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000101 nodes, Time: ");
        assertEquals(101, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000637 nodes, Time: ");
        assertEquals(637, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000004354 nodes, Time: ");
        assertEquals(4354, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000029679 nodes, Time: ");
        assertEquals(29679, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft102()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #103: k7/8/8/3p4/4p3/8/8/7K b - - 0 1");
        Board b = new Board("k7/8/8/3p4/4p3/8/8/7K b - - 0 1");
        System.out.print("Perft(1): 000000005 nodes, Time: ");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000015 nodes, Time: ");
        assertEquals(15, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000102 nodes, Time: ");
        assertEquals(102, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000569 nodes, Time: ");
        assertEquals(569, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000004337 nodes, Time: ");
        assertEquals(4337, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000022579 nodes, Time: ");
        assertEquals(22579, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft103()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #104: k7/8/3p4/8/8/4P3/8/7K b - - 0 1");
        Board b = new Board("k7/8/3p4/8/8/4P3/8/7K b - - 0 1");
        System.out.print("Perft(1): 000000004 nodes, Time: ");
        assertEquals(4, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000016 nodes, Time: ");
        assertEquals(16, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000101 nodes, Time: ");
        assertEquals(101, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000637 nodes, Time: ");
        assertEquals(637, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000004271 nodes, Time: ");
        assertEquals(4271, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000028662 nodes, Time: ");
        assertEquals(28662, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft104()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #105: 7k/8/8/p7/1P6/8/8/7K w - - 0 1");
        Board b = new Board("7k/8/8/p7/1P6/8/8/7K w - - 0 1");
        System.out.print("Perft(1): 000000005 nodes, Time: ");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000022 nodes, Time: ");
        assertEquals(22, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000139 nodes, Time: ");
        assertEquals(139, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000877 nodes, Time: ");
        assertEquals(877, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000006112 nodes, Time: ");
        assertEquals(6112, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000041874 nodes, Time: ");
        assertEquals(41874, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft105()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #106: 7k/8/p7/8/8/1P6/8/7K w - - 0 1");
        Board b = new Board("7k/8/p7/8/8/1P6/8/7K w - - 0 1");
        System.out.print("Perft(1): 000000004 nodes, Time: ");
        assertEquals(4, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000016 nodes, Time: ");
        assertEquals(16, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000101 nodes, Time: ");
        assertEquals(101, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000637 nodes, Time: ");
        assertEquals(637, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000004354 nodes, Time: ");
        assertEquals(4354, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000029679 nodes, Time: ");
        assertEquals(29679, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft106()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #107: 7k/8/8/1p6/P7/8/8/7K w - - 0 1");
        Board b = new Board("7k/8/8/1p6/P7/8/8/7K w - - 0 1");
        System.out.print("Perft(1): 000000005 nodes, Time: ");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000022 nodes, Time: ");
        assertEquals(22, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000139 nodes, Time: ");
        assertEquals(139, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000877 nodes, Time: ");
        assertEquals(877, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000006112 nodes, Time: ");
        assertEquals(6112, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000041874 nodes, Time: ");
        assertEquals(41874, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft107()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #108: 7k/8/1p6/8/8/P7/8/7K w - - 0 1");
        Board b = new Board("7k/8/1p6/8/8/P7/8/7K w - - 0 1");
        System.out.print("Perft(1): 000000004 nodes, Time: ");
        assertEquals(4, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000016 nodes, Time: ");
        assertEquals(16, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000101 nodes, Time: ");
        assertEquals(101, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000637 nodes, Time: ");
        assertEquals(637, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000004354 nodes, Time: ");
        assertEquals(4354, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000029679 nodes, Time: ");
        assertEquals(29679, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft108()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #109: k7/7p/8/8/8/8/6P1/K7 w - - 0 1");
        Board b = new Board("k7/7p/8/8/8/8/6P1/K7 w - - 0 1");
        System.out.print("Perft(1): 000000005 nodes, Time: ");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000025 nodes, Time: ");
        assertEquals(25, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000161 nodes, Time: ");
        assertEquals(161, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000001035 nodes, Time: ");
        assertEquals(1035, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000007574 nodes, Time: ");
        assertEquals(7574, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000055338 nodes, Time: ");
        assertEquals(55338, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft109()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #110: k7/6p1/8/8/8/8/7P/K7 w - - 0 1");
        Board b = new Board("k7/6p1/8/8/8/8/7P/K7 w - - 0 1");
        System.out.print("Perft(1): 000000005 nodes, Time: ");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000025 nodes, Time: ");
        assertEquals(25, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000161 nodes, Time: ");
        assertEquals(161, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000001035 nodes, Time: ");
        assertEquals(1035, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000007574 nodes, Time: ");
        assertEquals(7574, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000055338 nodes, Time: ");
        assertEquals(55338, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft110()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #111: 3k4/3pp3/8/8/8/8/3PP3/3K4 w - - 0 1");
        Board b = new Board("3k4/3pp3/8/8/8/8/3PP3/3K4 w - - 0 1");
        System.out.print("Perft(1): 000000007 nodes, Time: ");
        assertEquals(7, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000049 nodes, Time: ");
        assertEquals(49, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000378 nodes, Time: ");
        assertEquals(378, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000002902 nodes, Time: ");
        assertEquals(2902, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000024122 nodes, Time: ");
        assertEquals(24122, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000199002 nodes, Time: ");
        assertEquals(199002, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft111()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #112: 7k/8/8/p7/1P6/8/8/7K b - - 0 1");
        Board b = new Board("7k/8/8/p7/1P6/8/8/7K b - - 0 1");
        System.out.print("Perft(1): 000000005 nodes, Time: ");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000022 nodes, Time: ");
        assertEquals(22, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000139 nodes, Time: ");
        assertEquals(139, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000877 nodes, Time: ");
        assertEquals(877, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000006112 nodes, Time: ");
        assertEquals(6112, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000041874 nodes, Time: ");
        assertEquals(41874, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft112()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #113: 7k/8/p7/8/8/1P6/8/7K b - - 0 1");
        Board b = new Board("7k/8/p7/8/8/1P6/8/7K b - - 0 1");
        System.out.print("Perft(1): 000000004 nodes, Time: ");
        assertEquals(4, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000016 nodes, Time: ");
        assertEquals(16, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000101 nodes, Time: ");
        assertEquals(101, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000637 nodes, Time: ");
        assertEquals(637, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000004354 nodes, Time: ");
        assertEquals(4354, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000029679 nodes, Time: ");
        assertEquals(29679, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft113()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #114: 7k/8/8/1p6/P7/8/8/7K b - - 0 1");
        Board b = new Board("7k/8/8/1p6/P7/8/8/7K b - - 0 1");
        System.out.print("Perft(1): 000000005 nodes, Time: ");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000022 nodes, Time: ");
        assertEquals(22, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000139 nodes, Time: ");
        assertEquals(139, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000877 nodes, Time: ");
        assertEquals(877, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000006112 nodes, Time: ");
        assertEquals(6112, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000041874 nodes, Time: ");
        assertEquals(41874, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft114()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #115: 7k/8/1p6/8/8/P7/8/7K b - - 0 1");
        Board b = new Board("7k/8/1p6/8/8/P7/8/7K b - - 0 1");
        System.out.print("Perft(1): 000000004 nodes, Time: ");
        assertEquals(4, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000016 nodes, Time: ");
        assertEquals(16, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000101 nodes, Time: ");
        assertEquals(101, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000000637 nodes, Time: ");
        assertEquals(637, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000004354 nodes, Time: ");
        assertEquals(4354, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000029679 nodes, Time: ");
        assertEquals(29679, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft115()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #116: k7/7p/8/8/8/8/6P1/K7 b - - 0 1");
        Board b = new Board("k7/7p/8/8/8/8/6P1/K7 b - - 0 1");
        System.out.print("Perft(1): 000000005 nodes, Time: ");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000025 nodes, Time: ");
        assertEquals(25, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000161 nodes, Time: ");
        assertEquals(161, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000001035 nodes, Time: ");
        assertEquals(1035, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000007574 nodes, Time: ");
        assertEquals(7574, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000055338 nodes, Time: ");
        assertEquals(55338, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft116()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #117: k7/6p1/8/8/8/8/7P/K7 b - - 0 1");
        Board b = new Board("k7/6p1/8/8/8/8/7P/K7 b - - 0 1");
        System.out.print("Perft(1): 000000005 nodes, Time: ");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000025 nodes, Time: ");
        assertEquals(25, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000161 nodes, Time: ");
        assertEquals(161, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000001035 nodes, Time: ");
        assertEquals(1035, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000007574 nodes, Time: ");
        assertEquals(7574, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000055338 nodes, Time: ");
        assertEquals(55338, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft117()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #118: 3k4/3pp3/8/8/8/8/3PP3/3K4 b - - 0 1");
        Board b = new Board("3k4/3pp3/8/8/8/8/3PP3/3K4 b - - 0 1");
        System.out.print("Perft(1): 000000007 nodes, Time: ");
        assertEquals(7, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000049 nodes, Time: ");
        assertEquals(49, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000378 nodes, Time: ");
        assertEquals(378, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000002902 nodes, Time: ");
        assertEquals(2902, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000024122 nodes, Time: ");
        assertEquals(24122, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 000199002 nodes, Time: ");
        assertEquals(199002, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft118()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #119: 8/Pk6/8/8/8/8/6Kp/8 w - - 0 1");
        Board b = new Board("8/Pk6/8/8/8/8/6Kp/8 w - - 0 1");
        System.out.print("Perft(1): 000000011 nodes, Time: ");
        assertEquals(11, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000097 nodes, Time: ");
        assertEquals(97, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000887 nodes, Time: ");
        assertEquals(887, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000008048 nodes, Time: ");
        assertEquals(8048, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000090606 nodes, Time: ");
        assertEquals(90606, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 001030499 nodes, Time: ");
        assertEquals(1030499, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft119()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #120: n1n5/1Pk5/8/8/8/8/5Kp1/5N1N w - - 0 1");
        Board b = new Board("n1n5/1Pk5/8/8/8/8/5Kp1/5N1N w - - 0 1");
        System.out.print("Perft(1): 000000024 nodes, Time: ");
        assertEquals(24, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000421 nodes, Time: ");
        assertEquals(421, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000007421 nodes, Time: ");
        assertEquals(7421, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000124608 nodes, Time: ");
        assertEquals(124608, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 002193768 nodes, Time: ");
        assertEquals(2193768, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 037665329 nodes, Time: ");
        assertEquals(37665329, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft120()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #121: 8/PPPk4/8/8/8/8/4Kppp/8 w - - 0 1");
        Board b = new Board("8/PPPk4/8/8/8/8/4Kppp/8 w - - 0 1");
        System.out.print("Perft(1): 000000018 nodes, Time: ");
        assertEquals(18, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000270 nodes, Time: ");
        assertEquals(270, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000004699 nodes, Time: ");
        assertEquals(4699, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000079355 nodes, Time: ");
        assertEquals(79355, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 001533145 nodes, Time: ");
        assertEquals(1533145, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 028859283 nodes, Time: ");
        assertEquals(28859283, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft121()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #122: n1n5/PPPk4/8/8/8/8/4Kppp/5N1N w - - 0 1");
        Board b = new Board("n1n5/PPPk4/8/8/8/8/4Kppp/5N1N w - - 0 1");
        System.out.print("Perft(1): 000000024 nodes, Time: ");
        assertEquals(24, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000496 nodes, Time: ");
        assertEquals(496, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000009483 nodes, Time: ");
        assertEquals(9483, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000182838 nodes, Time: ");
        assertEquals(182838, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 003605103 nodes, Time: ");
        assertEquals(3605103, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 071179139 nodes, Time: ");
        assertEquals(71179139, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft122()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #123: 8/Pk6/8/8/8/8/6Kp/8 b - - 0 1");
        Board b = new Board("8/Pk6/8/8/8/8/6Kp/8 b - - 0 1");
        System.out.print("Perft(1): 000000011 nodes, Time: ");
        assertEquals(11, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000097 nodes, Time: ");
        assertEquals(97, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000000887 nodes, Time: ");
        assertEquals(887, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000008048 nodes, Time: ");
        assertEquals(8048, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 000090606 nodes, Time: ");
        assertEquals(90606, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 001030499 nodes, Time: ");
        assertEquals(1030499, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft123()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #124: n1n5/1Pk5/8/8/8/8/5Kp1/5N1N b - - 0 1");
        Board b = new Board("n1n5/1Pk5/8/8/8/8/5Kp1/5N1N b - - 0 1");
        System.out.print("Perft(1): 000000024 nodes, Time: ");
        assertEquals(24, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000421 nodes, Time: ");
        assertEquals(421, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000007421 nodes, Time: ");
        assertEquals(7421, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000124608 nodes, Time: ");
        assertEquals(124608, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 002193768 nodes, Time: ");
        assertEquals(2193768, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 037665329 nodes, Time: ");
        assertEquals(37665329, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft124()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #125: 8/PPPk4/8/8/8/8/4Kppp/8 b - - 0 1");
        Board b = new Board("8/PPPk4/8/8/8/8/4Kppp/8 b - - 0 1");
        System.out.print("Perft(1): 000000018 nodes, Time: ");
        assertEquals(18, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000270 nodes, Time: ");
        assertEquals(270, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000004699 nodes, Time: ");
        assertEquals(4699, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000079355 nodes, Time: ");
        assertEquals(79355, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 001533145 nodes, Time: ");
        assertEquals(1533145, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 028859283 nodes, Time: ");
        assertEquals(28859283, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft125()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #126: n1n5/PPPk4/8/8/8/8/4Kppp/5N1N b - - 0 1");
        Board b = new Board("n1n5/PPPk4/8/8/8/8/4Kppp/5N1N b - - 0 1");
        System.out.print("Perft(1): 000000024 nodes, Time: ");
        assertEquals(24, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000000496 nodes, Time: ");
        assertEquals(496, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000009483 nodes, Time: ");
        assertEquals(9483, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 000182838 nodes, Time: ");
        assertEquals(182838, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 003605103 nodes, Time: ");
        assertEquals(3605103, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(6): 071179139 nodes, Time: ");
        assertEquals(71179139, new Perft(b.getFEN()).perft(6));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }

    @Test
    public void perft126()
    {
        Timer fen = new Timer();
        fen.start();
        System.out.println("\nFEN #127: r3k2r/p1ppqpb1/bn2pnp1/3PN3/1p2P3/2N2Q1p/PPPBBPPP/R3K2R w KQkq - 0 1 ");
        Board b = new Board("r3k2r/p1ppqpb1/bn2pnp1/3PN3/1p2P3/2N2Q1p/PPPBBPPP/R3K2R w KQkq - 0 1 ");
        System.out.print("Perft(1): 000000048 nodes, Time: ");
        assertEquals(48, new Perft(b.getFEN()).perft(1));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(2): 000002039 nodes, Time: ");
        assertEquals(2039, new Perft(b.getFEN()).perft(2));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(3): 000097862 nodes, Time: ");
        assertEquals(97862, new Perft(b.getFEN()).perft(3));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(4): 004085603 nodes, Time: ");
        assertEquals(4085603, new Perft(b.getFEN()).perft(4));
        fen.lap();
        System.out.println(fen.displayLastLap());

        System.out.print("Perft(5): 193690690 nodes, Time: ");
        assertEquals(193690690, new Perft(b.getFEN()).perft(5));
        fen.lap();
        System.out.println(fen.displayLastLap());

    }



}
