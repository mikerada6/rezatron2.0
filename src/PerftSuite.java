import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PerftSuite {
    @Test
    public void perft0()
    {
        System.out.println("\nFEN #1: rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
        Board b = new Board("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
        assertEquals(20, new Perft(b.getFEN()).perft(1));
        assertEquals(400, new Perft(b.getFEN()).perft(2));
        assertEquals(8902, new Perft(b.getFEN()).perft(3));
        assertEquals(197281, new Perft(b.getFEN()).perft(4));
        assertEquals(4865609, new Perft(b.getFEN()).perft(5));
        assertEquals(119060324, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft1()
    {
        System.out.println("\nFEN #2: 3k4/3p4/8/K1P4r/8/8/8/8 b - - 0 1");
        Board b = new Board("3k4/3p4/8/K1P4r/8/8/8/8 b - - 0 1");
        assertEquals(18, new Perft(b.getFEN()).perft(1));
        assertEquals(92, new Perft(b.getFEN()).perft(2));
        assertEquals(1670, new Perft(b.getFEN()).perft(3));
        assertEquals(10138, new Perft(b.getFEN()).perft(4));
        assertEquals(185429, new Perft(b.getFEN()).perft(5));
        assertEquals(1134888, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft2()
    {
        System.out.println("\nFEN #3: 4k3/8/8/8/8/8/8/4K2R w K - 0 1");
        Board b = new Board("4k3/8/8/8/8/8/8/4K2R w K - 0 1");
        assertEquals(15, new Perft(b.getFEN()).perft(1));
        assertEquals(66, new Perft(b.getFEN()).perft(2));
        assertEquals(1197, new Perft(b.getFEN()).perft(3));
        assertEquals(7059, new Perft(b.getFEN()).perft(4));
        assertEquals(133987, new Perft(b.getFEN()).perft(5));
        assertEquals(764643, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft3()
    {
        System.out.println("\nFEN #4: 4k3/8/8/8/8/8/8/R3K3 w Q - 0 1");
        Board b = new Board("4k3/8/8/8/8/8/8/R3K3 w Q - 0 1");
        assertEquals(16, new Perft(b.getFEN()).perft(1));
        assertEquals(71, new Perft(b.getFEN()).perft(2));
        assertEquals(1287, new Perft(b.getFEN()).perft(3));
        assertEquals(7626, new Perft(b.getFEN()).perft(4));
        assertEquals(145232, new Perft(b.getFEN()).perft(5));
        assertEquals(846648, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft4()
    {
        System.out.println("\nFEN #5: 4k2r/8/8/8/8/8/8/4K3 w k - 0 1");
        Board b = new Board("4k2r/8/8/8/8/8/8/4K3 w k - 0 1");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        assertEquals(75, new Perft(b.getFEN()).perft(2));
        assertEquals(459, new Perft(b.getFEN()).perft(3));
        assertEquals(8290, new Perft(b.getFEN()).perft(4));
        assertEquals(47635, new Perft(b.getFEN()).perft(5));
        assertEquals(899442, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft5()
    {
        System.out.println("\nFEN #6: r3k3/8/8/8/8/8/8/4K3 w q - 0 1");
        Board b = new Board("r3k3/8/8/8/8/8/8/4K3 w q - 0 1");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        assertEquals(80, new Perft(b.getFEN()).perft(2));
        assertEquals(493, new Perft(b.getFEN()).perft(3));
        assertEquals(8897, new Perft(b.getFEN()).perft(4));
        assertEquals(52710, new Perft(b.getFEN()).perft(5));
        assertEquals(1001523, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft6()
    {
        System.out.println("\nFEN #7: 4k3/8/8/8/8/8/8/R3K2R w KQ - 0 1");
        Board b = new Board("4k3/8/8/8/8/8/8/R3K2R w KQ - 0 1");
        assertEquals(26, new Perft(b.getFEN()).perft(1));
        assertEquals(112, new Perft(b.getFEN()).perft(2));
        assertEquals(3189, new Perft(b.getFEN()).perft(3));
        assertEquals(17945, new Perft(b.getFEN()).perft(4));
        assertEquals(532933, new Perft(b.getFEN()).perft(5));
        assertEquals(2788982, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft7()
    {
        System.out.println("\nFEN #8: r3k2r/8/8/8/8/8/8/4K3 w kq - 0 1");
        Board b = new Board("r3k2r/8/8/8/8/8/8/4K3 w kq - 0 1");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        assertEquals(130, new Perft(b.getFEN()).perft(2));
        assertEquals(782, new Perft(b.getFEN()).perft(3));
        assertEquals(22180, new Perft(b.getFEN()).perft(4));
        assertEquals(118882, new Perft(b.getFEN()).perft(5));
        assertEquals(3517770, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft8()
    {
        System.out.println("\nFEN #9: 8/8/8/8/8/8/6k1/4K2R w K - 0 1");
        Board b = new Board("8/8/8/8/8/8/6k1/4K2R w K - 0 1");
        assertEquals(12, new Perft(b.getFEN()).perft(1));
        assertEquals(38, new Perft(b.getFEN()).perft(2));
        assertEquals(564, new Perft(b.getFEN()).perft(3));
        assertEquals(2219, new Perft(b.getFEN()).perft(4));
        assertEquals(37735, new Perft(b.getFEN()).perft(5));
        assertEquals(185867, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft9()
    {
        System.out.println("\nFEN #10: 8/8/8/8/8/8/1k6/R3K3 w Q - 0 1");
        Board b = new Board("8/8/8/8/8/8/1k6/R3K3 w Q - 0 1");
        assertEquals(15, new Perft(b.getFEN()).perft(1));
        assertEquals(65, new Perft(b.getFEN()).perft(2));
        assertEquals(1018, new Perft(b.getFEN()).perft(3));
        assertEquals(4573, new Perft(b.getFEN()).perft(4));
        assertEquals(80619, new Perft(b.getFEN()).perft(5));
        assertEquals(413018, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft10()
    {
        System.out.println("\nFEN #11: 4k2r/6K1/8/8/8/8/8/8 w k - 0 1");
        Board b = new Board("4k2r/6K1/8/8/8/8/8/8 w k - 0 1");
        assertEquals(3, new Perft(b.getFEN()).perft(1));
        assertEquals(32, new Perft(b.getFEN()).perft(2));
        assertEquals(134, new Perft(b.getFEN()).perft(3));
        assertEquals(2073, new Perft(b.getFEN()).perft(4));
        assertEquals(10485, new Perft(b.getFEN()).perft(5));
        assertEquals(179869, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft11()
    {
        System.out.println("\nFEN #12: r3k3/1K6/8/8/8/8/8/8 w q - 0 1");
        Board b = new Board("r3k3/1K6/8/8/8/8/8/8 w q - 0 1");
        assertEquals(4, new Perft(b.getFEN()).perft(1));
        assertEquals(49, new Perft(b.getFEN()).perft(2));
        assertEquals(243, new Perft(b.getFEN()).perft(3));
        assertEquals(3991, new Perft(b.getFEN()).perft(4));
        assertEquals(20780, new Perft(b.getFEN()).perft(5));
        assertEquals(367724, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft12()
    {
        System.out.println("\nFEN #13: r3k2r/8/8/8/8/8/8/R3K2R w KQkq - 0 1");
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K2R w KQkq - 0 1");
        assertEquals(26, new Perft(b.getFEN()).perft(1));
        assertEquals(568, new Perft(b.getFEN()).perft(2));
        assertEquals(13744, new Perft(b.getFEN()).perft(3));
        assertEquals(314346, new Perft(b.getFEN()).perft(4));
        assertEquals(7594526, new Perft(b.getFEN()).perft(5));
        assertEquals(179862938, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft13()
    {
        System.out.println("\nFEN #14: r3k2r/8/8/8/8/8/8/1R2K2R w Kkq - 0 1");
        Board b = new Board("r3k2r/8/8/8/8/8/8/1R2K2R w Kkq - 0 1");
        assertEquals(25, new Perft(b.getFEN()).perft(1));
        assertEquals(567, new Perft(b.getFEN()).perft(2));
        assertEquals(14095, new Perft(b.getFEN()).perft(3));
        assertEquals(328965, new Perft(b.getFEN()).perft(4));
        assertEquals(8153719, new Perft(b.getFEN()).perft(5));
        assertEquals(195629489, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft14()
    {
        System.out.println("\nFEN #15: r3k2r/8/8/8/8/8/8/2R1K2R w Kkq - 0 1");
        Board b = new Board("r3k2r/8/8/8/8/8/8/2R1K2R w Kkq - 0 1");
        assertEquals(25, new Perft(b.getFEN()).perft(1));
        assertEquals(548, new Perft(b.getFEN()).perft(2));
        assertEquals(13502, new Perft(b.getFEN()).perft(3));
        assertEquals(312835, new Perft(b.getFEN()).perft(4));
        assertEquals(7736373, new Perft(b.getFEN()).perft(5));
        assertEquals(184411439, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft15()
    {
        System.out.println("\nFEN #16: r3k2r/8/8/8/8/8/8/R3K1R1 w Qkq - 0 1");
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K1R1 w Qkq - 0 1");
        assertEquals(25, new Perft(b.getFEN()).perft(1));
        assertEquals(547, new Perft(b.getFEN()).perft(2));
        assertEquals(13579, new Perft(b.getFEN()).perft(3));
        assertEquals(316214, new Perft(b.getFEN()).perft(4));
        assertEquals(7878456, new Perft(b.getFEN()).perft(5));
        assertEquals(189224276, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft16()
    {
        System.out.println("\nFEN #17: 1r2k2r/8/8/8/8/8/8/R3K2R w KQk - 0 1");
        Board b = new Board("1r2k2r/8/8/8/8/8/8/R3K2R w KQk - 0 1");
        assertEquals(26, new Perft(b.getFEN()).perft(1));
        assertEquals(583, new Perft(b.getFEN()).perft(2));
        assertEquals(14252, new Perft(b.getFEN()).perft(3));
        assertEquals(334705, new Perft(b.getFEN()).perft(4));
        assertEquals(8198901, new Perft(b.getFEN()).perft(5));
        assertEquals(198328929, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft17()
    {
        System.out.println("\nFEN #18: 2r1k2r/8/8/8/8/8/8/R3K2R w KQk - 0 1");
        Board b = new Board("2r1k2r/8/8/8/8/8/8/R3K2R w KQk - 0 1");
        assertEquals(25, new Perft(b.getFEN()).perft(1));
        assertEquals(560, new Perft(b.getFEN()).perft(2));
        assertEquals(13592, new Perft(b.getFEN()).perft(3));
        assertEquals(317324, new Perft(b.getFEN()).perft(4));
        assertEquals(7710115, new Perft(b.getFEN()).perft(5));
        assertEquals(185959088, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft18()
    {
        System.out.println("\nFEN #19: r3k1r1/8/8/8/8/8/8/R3K2R w KQq - 0 1");
        Board b = new Board("r3k1r1/8/8/8/8/8/8/R3K2R w KQq - 0 1");
        assertEquals(25, new Perft(b.getFEN()).perft(1));
        assertEquals(560, new Perft(b.getFEN()).perft(2));
        assertEquals(13607, new Perft(b.getFEN()).perft(3));
        assertEquals(320792, new Perft(b.getFEN()).perft(4));
        assertEquals(7848606, new Perft(b.getFEN()).perft(5));
        assertEquals(190755813, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft19()
    {
        System.out.println("\nFEN #20: 4k3/8/8/8/8/8/8/4K2R b K - 0 1");
        Board b = new Board("4k3/8/8/8/8/8/8/4K2R b K - 0 1");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        assertEquals(75, new Perft(b.getFEN()).perft(2));
        assertEquals(459, new Perft(b.getFEN()).perft(3));
        assertEquals(8290, new Perft(b.getFEN()).perft(4));
        assertEquals(47635, new Perft(b.getFEN()).perft(5));
        assertEquals(899442, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft20()
    {
        System.out.println("\nFEN #21: 4k3/8/8/8/8/8/8/R3K3 b Q - 0 1");
        Board b = new Board("4k3/8/8/8/8/8/8/R3K3 b Q - 0 1");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        assertEquals(80, new Perft(b.getFEN()).perft(2));
        assertEquals(493, new Perft(b.getFEN()).perft(3));
        assertEquals(8897, new Perft(b.getFEN()).perft(4));
        assertEquals(52710, new Perft(b.getFEN()).perft(5));
        assertEquals(1001523, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft21()
    {
        System.out.println("\nFEN #22: 4k2r/8/8/8/8/8/8/4K3 b k - 0 1");
        Board b = new Board("4k2r/8/8/8/8/8/8/4K3 b k - 0 1");
        assertEquals(15, new Perft(b.getFEN()).perft(1));
        assertEquals(66, new Perft(b.getFEN()).perft(2));
        assertEquals(1197, new Perft(b.getFEN()).perft(3));
        assertEquals(7059, new Perft(b.getFEN()).perft(4));
        assertEquals(133987, new Perft(b.getFEN()).perft(5));
        assertEquals(764643, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft22()
    {
        System.out.println("\nFEN #23: r3k3/8/8/8/8/8/8/4K3 b q - 0 1");
        Board b = new Board("r3k3/8/8/8/8/8/8/4K3 b q - 0 1");
        assertEquals(16, new Perft(b.getFEN()).perft(1));
        assertEquals(71, new Perft(b.getFEN()).perft(2));
        assertEquals(1287, new Perft(b.getFEN()).perft(3));
        assertEquals(7626, new Perft(b.getFEN()).perft(4));
        assertEquals(145232, new Perft(b.getFEN()).perft(5));
        assertEquals(846648, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft23()
    {
        System.out.println("\nFEN #24: 4k3/8/8/8/8/8/8/R3K2R b KQ - 0 1");
        Board b = new Board("4k3/8/8/8/8/8/8/R3K2R b KQ - 0 1");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        assertEquals(130, new Perft(b.getFEN()).perft(2));
        assertEquals(782, new Perft(b.getFEN()).perft(3));
        assertEquals(22180, new Perft(b.getFEN()).perft(4));
        assertEquals(118882, new Perft(b.getFEN()).perft(5));
        assertEquals(3517770, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft24()
    {
        System.out.println("\nFEN #25: r3k2r/8/8/8/8/8/8/4K3 b kq - 0 1");
        Board b = new Board("r3k2r/8/8/8/8/8/8/4K3 b kq - 0 1");
        assertEquals(26, new Perft(b.getFEN()).perft(1));
        assertEquals(112, new Perft(b.getFEN()).perft(2));
        assertEquals(3189, new Perft(b.getFEN()).perft(3));
        assertEquals(17945, new Perft(b.getFEN()).perft(4));
        assertEquals(532933, new Perft(b.getFEN()).perft(5));
        assertEquals(2788982, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft25()
    {
        System.out.println("\nFEN #26: 8/8/8/8/8/8/6k1/4K2R b K - 0 1");
        Board b = new Board("8/8/8/8/8/8/6k1/4K2R b K - 0 1");
        assertEquals(3, new Perft(b.getFEN()).perft(1));
        assertEquals(32, new Perft(b.getFEN()).perft(2));
        assertEquals(134, new Perft(b.getFEN()).perft(3));
        assertEquals(2073, new Perft(b.getFEN()).perft(4));
        assertEquals(10485, new Perft(b.getFEN()).perft(5));
        assertEquals(179869, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft26()
    {
        System.out.println("\nFEN #27: 8/8/8/8/8/8/1k6/R3K3 b Q - 0 1");
        Board b = new Board("8/8/8/8/8/8/1k6/R3K3 b Q - 0 1");
        assertEquals(4, new Perft(b.getFEN()).perft(1));
        assertEquals(49, new Perft(b.getFEN()).perft(2));
        assertEquals(243, new Perft(b.getFEN()).perft(3));
        assertEquals(3991, new Perft(b.getFEN()).perft(4));
        assertEquals(20780, new Perft(b.getFEN()).perft(5));
        assertEquals(367724, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft27()
    {
        System.out.println("\nFEN #28: 4k2r/6K1/8/8/8/8/8/8 b k - 0 1");
        Board b = new Board("4k2r/6K1/8/8/8/8/8/8 b k - 0 1");
        assertEquals(12, new Perft(b.getFEN()).perft(1));
        assertEquals(38, new Perft(b.getFEN()).perft(2));
        assertEquals(564, new Perft(b.getFEN()).perft(3));
        assertEquals(2219, new Perft(b.getFEN()).perft(4));
        assertEquals(37735, new Perft(b.getFEN()).perft(5));
        assertEquals(185867, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft28()
    {
        System.out.println("\nFEN #29: r3k3/1K6/8/8/8/8/8/8 b q - 0 1");
        Board b = new Board("r3k3/1K6/8/8/8/8/8/8 b q - 0 1");
        assertEquals(15, new Perft(b.getFEN()).perft(1));
        assertEquals(65, new Perft(b.getFEN()).perft(2));
        assertEquals(1018, new Perft(b.getFEN()).perft(3));
        assertEquals(4573, new Perft(b.getFEN()).perft(4));
        assertEquals(80619, new Perft(b.getFEN()).perft(5));
        assertEquals(413018, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft29()
    {
        System.out.println("\nFEN #30: r3k2r/8/8/8/8/8/8/R3K2R b KQkq - 0 1");
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K2R b KQkq - 0 1");
        assertEquals(26, new Perft(b.getFEN()).perft(1));
        assertEquals(568, new Perft(b.getFEN()).perft(2));
        assertEquals(13744, new Perft(b.getFEN()).perft(3));
        assertEquals(314346, new Perft(b.getFEN()).perft(4));
        assertEquals(7594526, new Perft(b.getFEN()).perft(5));
        assertEquals(179862938, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft30()
    {
        System.out.println("\nFEN #31: r3k2r/8/8/8/8/8/8/1R2K2R b Kkq - 0 1");
        Board b = new Board("r3k2r/8/8/8/8/8/8/1R2K2R b Kkq - 0 1");
        assertEquals(26, new Perft(b.getFEN()).perft(1));
        assertEquals(583, new Perft(b.getFEN()).perft(2));
        assertEquals(14252, new Perft(b.getFEN()).perft(3));
        assertEquals(334705, new Perft(b.getFEN()).perft(4));
        assertEquals(8198901, new Perft(b.getFEN()).perft(5));
        assertEquals(198328929, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft31()
    {
        System.out.println("\nFEN #32: r3k2r/8/8/8/8/8/8/2R1K2R b Kkq - 0 1");
        Board b = new Board("r3k2r/8/8/8/8/8/8/2R1K2R b Kkq - 0 1");
        assertEquals(25, new Perft(b.getFEN()).perft(1));
        assertEquals(560, new Perft(b.getFEN()).perft(2));
        assertEquals(13592, new Perft(b.getFEN()).perft(3));
        assertEquals(317324, new Perft(b.getFEN()).perft(4));
        assertEquals(7710115, new Perft(b.getFEN()).perft(5));
        assertEquals(185959088, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft32()
    {
        System.out.println("\nFEN #33: r3k2r/8/8/8/8/8/8/R3K1R1 b Qkq - 0 1");
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K1R1 b Qkq - 0 1");
        assertEquals(25, new Perft(b.getFEN()).perft(1));
        assertEquals(560, new Perft(b.getFEN()).perft(2));
        assertEquals(13607, new Perft(b.getFEN()).perft(3));
        assertEquals(320792, new Perft(b.getFEN()).perft(4));
        assertEquals(7848606, new Perft(b.getFEN()).perft(5));
        assertEquals(190755813, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft33()
    {
        System.out.println("\nFEN #34: 1r2k2r/8/8/8/8/8/8/R3K2R b KQk - 0 1");
        Board b = new Board("1r2k2r/8/8/8/8/8/8/R3K2R b KQk - 0 1");
        assertEquals(25, new Perft(b.getFEN()).perft(1));
        assertEquals(567, new Perft(b.getFEN()).perft(2));
        assertEquals(14095, new Perft(b.getFEN()).perft(3));
        assertEquals(328965, new Perft(b.getFEN()).perft(4));
        assertEquals(8153719, new Perft(b.getFEN()).perft(5));
        assertEquals(195629489, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft34()
    {
        System.out.println("\nFEN #35: 2r1k2r/8/8/8/8/8/8/R3K2R b KQk - 0 1");
        Board b = new Board("2r1k2r/8/8/8/8/8/8/R3K2R b KQk - 0 1");
        assertEquals(25, new Perft(b.getFEN()).perft(1));
        assertEquals(548, new Perft(b.getFEN()).perft(2));
        assertEquals(13502, new Perft(b.getFEN()).perft(3));
        assertEquals(312835, new Perft(b.getFEN()).perft(4));
        assertEquals(7736373, new Perft(b.getFEN()).perft(5));
        assertEquals(184411439, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft35()
    {
        System.out.println("\nFEN #36: r3k1r1/8/8/8/8/8/8/R3K2R b KQq - 0 1");
        Board b = new Board("r3k1r1/8/8/8/8/8/8/R3K2R b KQq - 0 1");
        assertEquals(25, new Perft(b.getFEN()).perft(1));
        assertEquals(547, new Perft(b.getFEN()).perft(2));
        assertEquals(13579, new Perft(b.getFEN()).perft(3));
        assertEquals(316214, new Perft(b.getFEN()).perft(4));
        assertEquals(7878456, new Perft(b.getFEN()).perft(5));
        assertEquals(189224276, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft36()
    {
        System.out.println("\nFEN #37: 8/1n4N1/2k5/8/8/5K2/1N4n1/8 w - - 0 1");
        Board b = new Board("8/1n4N1/2k5/8/8/5K2/1N4n1/8 w - - 0 1");
        assertEquals(14, new Perft(b.getFEN()).perft(1));
        assertEquals(195, new Perft(b.getFEN()).perft(2));
        assertEquals(2760, new Perft(b.getFEN()).perft(3));
        assertEquals(38675, new Perft(b.getFEN()).perft(4));
        assertEquals(570726, new Perft(b.getFEN()).perft(5));
        assertEquals(8107539, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft37()
    {
        System.out.println("\nFEN #38: 8/1k6/8/5N2/8/4n3/8/2K5 w - - 0 1");
        Board b = new Board("8/1k6/8/5N2/8/4n3/8/2K5 w - - 0 1");
        assertEquals(11, new Perft(b.getFEN()).perft(1));
        assertEquals(156, new Perft(b.getFEN()).perft(2));
        assertEquals(1636, new Perft(b.getFEN()).perft(3));
        assertEquals(20534, new Perft(b.getFEN()).perft(4));
        assertEquals(223507, new Perft(b.getFEN()).perft(5));
        assertEquals(2594412, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft38()
    {
        System.out.println("\nFEN #39: 8/8/4k3/3Nn3/3nN3/4K3/8/8 w - - 0 1");
        Board b = new Board("8/8/4k3/3Nn3/3nN3/4K3/8/8 w - - 0 1");
        assertEquals(19, new Perft(b.getFEN()).perft(1));
        assertEquals(289, new Perft(b.getFEN()).perft(2));
        assertEquals(4442, new Perft(b.getFEN()).perft(3));
        assertEquals(73584, new Perft(b.getFEN()).perft(4));
        assertEquals(1198299, new Perft(b.getFEN()).perft(5));
        assertEquals(19870403, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft39()
    {
        System.out.println("\nFEN #40: K7/8/2n5/1n6/8/8/8/k6N w - - 0 1");
        Board b = new Board("K7/8/2n5/1n6/8/8/8/k6N w - - 0 1");
        assertEquals(3, new Perft(b.getFEN()).perft(1));
        assertEquals(51, new Perft(b.getFEN()).perft(2));
        assertEquals(345, new Perft(b.getFEN()).perft(3));
        assertEquals(5301, new Perft(b.getFEN()).perft(4));
        assertEquals(38348, new Perft(b.getFEN()).perft(5));
        assertEquals(588695, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft40()
    {
        System.out.println("\nFEN #41: k7/8/2N5/1N6/8/8/8/K6n w - - 0 1");
        Board b = new Board("k7/8/2N5/1N6/8/8/8/K6n w - - 0 1");
        assertEquals(17, new Perft(b.getFEN()).perft(1));
        assertEquals(54, new Perft(b.getFEN()).perft(2));
        assertEquals(835, new Perft(b.getFEN()).perft(3));
        assertEquals(5910, new Perft(b.getFEN()).perft(4));
        assertEquals(92250, new Perft(b.getFEN()).perft(5));
        assertEquals(688780, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft41()
    {
        System.out.println("\nFEN #42: 8/1n4N1/2k5/8/8/5K2/1N4n1/8 b - - 0 1");
        Board b = new Board("8/1n4N1/2k5/8/8/5K2/1N4n1/8 b - - 0 1");
        assertEquals(15, new Perft(b.getFEN()).perft(1));
        assertEquals(193, new Perft(b.getFEN()).perft(2));
        assertEquals(2816, new Perft(b.getFEN()).perft(3));
        assertEquals(40039, new Perft(b.getFEN()).perft(4));
        assertEquals(582642, new Perft(b.getFEN()).perft(5));
        assertEquals(8503277, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft42()
    {
        System.out.println("\nFEN #43: 8/1k6/8/5N2/8/4n3/8/2K5 b - - 0 1");
        Board b = new Board("8/1k6/8/5N2/8/4n3/8/2K5 b - - 0 1");
        assertEquals(16, new Perft(b.getFEN()).perft(1));
        assertEquals(180, new Perft(b.getFEN()).perft(2));
        assertEquals(2290, new Perft(b.getFEN()).perft(3));
        assertEquals(24640, new Perft(b.getFEN()).perft(4));
        assertEquals(288141, new Perft(b.getFEN()).perft(5));
        assertEquals(3147566, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft43()
    {
        System.out.println("\nFEN #44: 8/8/3K4/3Nn3/3nN3/4k3/8/8 b - - 0 1");
        Board b = new Board("8/8/3K4/3Nn3/3nN3/4k3/8/8 b - - 0 1");
        assertEquals(4, new Perft(b.getFEN()).perft(1));
        assertEquals(68, new Perft(b.getFEN()).perft(2));
        assertEquals(1118, new Perft(b.getFEN()).perft(3));
        assertEquals(16199, new Perft(b.getFEN()).perft(4));
        assertEquals(281190, new Perft(b.getFEN()).perft(5));
        assertEquals(4405103, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft44()
    {
        System.out.println("\nFEN #45: K7/8/2n5/1n6/8/8/8/k6N b - - 0 1");
        Board b = new Board("K7/8/2n5/1n6/8/8/8/k6N b - - 0 1");
        assertEquals(17, new Perft(b.getFEN()).perft(1));
        assertEquals(54, new Perft(b.getFEN()).perft(2));
        assertEquals(835, new Perft(b.getFEN()).perft(3));
        assertEquals(5910, new Perft(b.getFEN()).perft(4));
        assertEquals(92250, new Perft(b.getFEN()).perft(5));
        assertEquals(688780, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft45()
    {
        System.out.println("\nFEN #46: k7/8/2N5/1N6/8/8/8/K6n b - - 0 1");
        Board b = new Board("k7/8/2N5/1N6/8/8/8/K6n b - - 0 1");
        assertEquals(3, new Perft(b.getFEN()).perft(1));
        assertEquals(51, new Perft(b.getFEN()).perft(2));
        assertEquals(345, new Perft(b.getFEN()).perft(3));
        assertEquals(5301, new Perft(b.getFEN()).perft(4));
        assertEquals(38348, new Perft(b.getFEN()).perft(5));
        assertEquals(588695, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft46()
    {
        System.out.println("\nFEN #47: B6b/8/8/8/2K5/4k3/8/b6B w - - 0 1");
        Board b = new Board("B6b/8/8/8/2K5/4k3/8/b6B w - - 0 1");
        assertEquals(17, new Perft(b.getFEN()).perft(1));
        assertEquals(278, new Perft(b.getFEN()).perft(2));
        assertEquals(4607, new Perft(b.getFEN()).perft(3));
        assertEquals(76778, new Perft(b.getFEN()).perft(4));
        assertEquals(1320507, new Perft(b.getFEN()).perft(5));
        assertEquals(22823890, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft47()
    {
        System.out.println("\nFEN #48: 8/8/1B6/7b/7k/8/2B1b3/7K w - - 0 1");
        Board b = new Board("8/8/1B6/7b/7k/8/2B1b3/7K w - - 0 1");
        assertEquals(21, new Perft(b.getFEN()).perft(1));
        assertEquals(316, new Perft(b.getFEN()).perft(2));
        assertEquals(5744, new Perft(b.getFEN()).perft(3));
        assertEquals(93338, new Perft(b.getFEN()).perft(4));
        assertEquals(1713368, new Perft(b.getFEN()).perft(5));
        assertEquals(28861171, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft48()
    {
        System.out.println("\nFEN #49: k7/B7/1B6/1B6/8/8/8/K6b w - - 0 1");
        Board b = new Board("k7/B7/1B6/1B6/8/8/8/K6b w - - 0 1");
        assertEquals(21, new Perft(b.getFEN()).perft(1));
        assertEquals(144, new Perft(b.getFEN()).perft(2));
        assertEquals(3242, new Perft(b.getFEN()).perft(3));
        assertEquals(32955, new Perft(b.getFEN()).perft(4));
        assertEquals(787524, new Perft(b.getFEN()).perft(5));
        assertEquals(7881673, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft49()
    {
        System.out.println("\nFEN #50: K7/b7/1b6/1b6/8/8/8/k6B w - - 0 1");
        Board b = new Board("K7/b7/1b6/1b6/8/8/8/k6B w - - 0 1");
        assertEquals(7, new Perft(b.getFEN()).perft(1));
        assertEquals(143, new Perft(b.getFEN()).perft(2));
        assertEquals(1416, new Perft(b.getFEN()).perft(3));
        assertEquals(31787, new Perft(b.getFEN()).perft(4));
        assertEquals(310862, new Perft(b.getFEN()).perft(5));
        assertEquals(7382896, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft50()
    {
        System.out.println("\nFEN #51: B6b/8/8/8/2K5/5k2/8/b6B b - - 0 1");
        Board b = new Board("B6b/8/8/8/2K5/5k2/8/b6B b - - 0 1");
        assertEquals(6, new Perft(b.getFEN()).perft(1));
        assertEquals(106, new Perft(b.getFEN()).perft(2));
        assertEquals(1829, new Perft(b.getFEN()).perft(3));
        assertEquals(31151, new Perft(b.getFEN()).perft(4));
        assertEquals(530585, new Perft(b.getFEN()).perft(5));
        assertEquals(9250746, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft51()
    {
        System.out.println("\nFEN #52: 8/8/1B6/7b/7k/8/2B1b3/7K b - - 0 1");
        Board b = new Board("8/8/1B6/7b/7k/8/2B1b3/7K b - - 0 1");
        assertEquals(17, new Perft(b.getFEN()).perft(1));
        assertEquals(309, new Perft(b.getFEN()).perft(2));
        assertEquals(5133, new Perft(b.getFEN()).perft(3));
        assertEquals(93603, new Perft(b.getFEN()).perft(4));
        assertEquals(1591064, new Perft(b.getFEN()).perft(5));
        assertEquals(29027891, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft52()
    {
        System.out.println("\nFEN #53: k7/B7/1B6/1B6/8/8/8/K6b b - - 0 1");
        Board b = new Board("k7/B7/1B6/1B6/8/8/8/K6b b - - 0 1");
        assertEquals(7, new Perft(b.getFEN()).perft(1));
        assertEquals(143, new Perft(b.getFEN()).perft(2));
        assertEquals(1416, new Perft(b.getFEN()).perft(3));
        assertEquals(31787, new Perft(b.getFEN()).perft(4));
        assertEquals(310862, new Perft(b.getFEN()).perft(5));
        assertEquals(7382896, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft53()
    {
        System.out.println("\nFEN #54: K7/b7/1b6/1b6/8/8/8/k6B b - - 0 1");
        Board b = new Board("K7/b7/1b6/1b6/8/8/8/k6B b - - 0 1");
        assertEquals(21, new Perft(b.getFEN()).perft(1));
        assertEquals(144, new Perft(b.getFEN()).perft(2));
        assertEquals(3242, new Perft(b.getFEN()).perft(3));
        assertEquals(32955, new Perft(b.getFEN()).perft(4));
        assertEquals(787524, new Perft(b.getFEN()).perft(5));
        assertEquals(7881673, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft54()
    {
        System.out.println("\nFEN #55: 7k/RR6/8/8/8/8/rr6/7K w - - 0 1");
        Board b = new Board("7k/RR6/8/8/8/8/rr6/7K w - - 0 1");
        assertEquals(19, new Perft(b.getFEN()).perft(1));
        assertEquals(275, new Perft(b.getFEN()).perft(2));
        assertEquals(5300, new Perft(b.getFEN()).perft(3));
        assertEquals(104342, new Perft(b.getFEN()).perft(4));
        assertEquals(2161211, new Perft(b.getFEN()).perft(5));
        assertEquals(44956585, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft55()
    {
        System.out.println("\nFEN #56: R6r/8/8/2K5/5k2/8/8/r6R w - - 0 1");
        Board b = new Board("R6r/8/8/2K5/5k2/8/8/r6R w - - 0 1");
        assertEquals(36, new Perft(b.getFEN()).perft(1));
        assertEquals(1027, new Perft(b.getFEN()).perft(2));
        assertEquals(29215, new Perft(b.getFEN()).perft(3));
        assertEquals(771461, new Perft(b.getFEN()).perft(4));
        assertEquals(20506480, new Perft(b.getFEN()).perft(5));
        assertEquals(525169084, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft56()
    {
        System.out.println("\nFEN #57: 7k/RR6/8/8/8/8/rr6/7K b - - 0 1");
        Board b = new Board("7k/RR6/8/8/8/8/rr6/7K b - - 0 1");
        assertEquals(19, new Perft(b.getFEN()).perft(1));
        assertEquals(275, new Perft(b.getFEN()).perft(2));
        assertEquals(5300, new Perft(b.getFEN()).perft(3));
        assertEquals(104342, new Perft(b.getFEN()).perft(4));
        assertEquals(2161211, new Perft(b.getFEN()).perft(5));
        assertEquals(44956585, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft57()
    {
        System.out.println("\nFEN #58: R6r/8/8/2K5/5k2/8/8/r6R b - - 0 1");
        Board b = new Board("R6r/8/8/2K5/5k2/8/8/r6R b - - 0 1");
        assertEquals(36, new Perft(b.getFEN()).perft(1));
        assertEquals(1027, new Perft(b.getFEN()).perft(2));
        assertEquals(29227, new Perft(b.getFEN()).perft(3));
        assertEquals(771368, new Perft(b.getFEN()).perft(4));
        assertEquals(20521342, new Perft(b.getFEN()).perft(5));
        assertEquals(524966748, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft58()
    {
        System.out.println("\nFEN #59: 6kq/8/8/8/8/8/8/7K w - - 0 1");
        Board b = new Board("6kq/8/8/8/8/8/8/7K w - - 0 1");
        assertEquals(2, new Perft(b.getFEN()).perft(1));
        assertEquals(36, new Perft(b.getFEN()).perft(2));
        assertEquals(143, new Perft(b.getFEN()).perft(3));
        assertEquals(3637, new Perft(b.getFEN()).perft(4));
        assertEquals(14893, new Perft(b.getFEN()).perft(5));
        assertEquals(391507, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft59()
    {
        System.out.println("\nFEN #60: 6KQ/8/8/8/8/8/8/7k b - - 0 1");
        Board b = new Board("6KQ/8/8/8/8/8/8/7k b - - 0 1");
        assertEquals(2, new Perft(b.getFEN()).perft(1));
        assertEquals(36, new Perft(b.getFEN()).perft(2));
        assertEquals(143, new Perft(b.getFEN()).perft(3));
        assertEquals(3637, new Perft(b.getFEN()).perft(4));
        assertEquals(14893, new Perft(b.getFEN()).perft(5));
        assertEquals(391507, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft60()
    {
        System.out.println("\nFEN #61: K7/8/8/3Q4/4q3/8/8/7k w - - 0 1");
        Board b = new Board("K7/8/8/3Q4/4q3/8/8/7k w - - 0 1");
        assertEquals(6, new Perft(b.getFEN()).perft(1));
        assertEquals(35, new Perft(b.getFEN()).perft(2));
        assertEquals(495, new Perft(b.getFEN()).perft(3));
        assertEquals(8349, new Perft(b.getFEN()).perft(4));
        assertEquals(166741, new Perft(b.getFEN()).perft(5));
        assertEquals(3370175, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft61()
    {
        System.out.println("\nFEN #62: 6qk/8/8/8/8/8/8/7K b - - 0 1");
        Board b = new Board("6qk/8/8/8/8/8/8/7K b - - 0 1");
        assertEquals(22, new Perft(b.getFEN()).perft(1));
        assertEquals(43, new Perft(b.getFEN()).perft(2));
        assertEquals(1015, new Perft(b.getFEN()).perft(3));
        assertEquals(4167, new Perft(b.getFEN()).perft(4));
        assertEquals(105749, new Perft(b.getFEN()).perft(5));
        assertEquals(419369, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft62()
    {
        System.out.println("\nFEN #63: 6KQ/8/8/8/8/8/8/7k b - - 0 1");
        Board b = new Board("6KQ/8/8/8/8/8/8/7k b - - 0 1");
        assertEquals(2, new Perft(b.getFEN()).perft(1));
        assertEquals(36, new Perft(b.getFEN()).perft(2));
        assertEquals(143, new Perft(b.getFEN()).perft(3));
        assertEquals(3637, new Perft(b.getFEN()).perft(4));
        assertEquals(14893, new Perft(b.getFEN()).perft(5));
        assertEquals(391507, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft63()
    {
        System.out.println("\nFEN #64: K7/8/8/3Q4/4q3/8/8/7k b - - 0 1");
        Board b = new Board("K7/8/8/3Q4/4q3/8/8/7k b - - 0 1");
        assertEquals(6, new Perft(b.getFEN()).perft(1));
        assertEquals(35, new Perft(b.getFEN()).perft(2));
        assertEquals(495, new Perft(b.getFEN()).perft(3));
        assertEquals(8349, new Perft(b.getFEN()).perft(4));
        assertEquals(166741, new Perft(b.getFEN()).perft(5));
        assertEquals(3370175, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft64()
    {
        System.out.println("\nFEN #65: 8/8/8/8/8/K7/P7/k7 w - - 0 1");
        Board b = new Board("8/8/8/8/8/K7/P7/k7 w - - 0 1");
        assertEquals(3, new Perft(b.getFEN()).perft(1));
        assertEquals(7, new Perft(b.getFEN()).perft(2));
        assertEquals(43, new Perft(b.getFEN()).perft(3));
        assertEquals(199, new Perft(b.getFEN()).perft(4));
        assertEquals(1347, new Perft(b.getFEN()).perft(5));
        assertEquals(6249, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft65()
    {
        System.out.println("\nFEN #66: 8/8/8/8/8/7K/7P/7k w - - 0 1");
        Board b = new Board("8/8/8/8/8/7K/7P/7k w - - 0 1");
        assertEquals(3, new Perft(b.getFEN()).perft(1));
        assertEquals(7, new Perft(b.getFEN()).perft(2));
        assertEquals(43, new Perft(b.getFEN()).perft(3));
        assertEquals(199, new Perft(b.getFEN()).perft(4));
        assertEquals(1347, new Perft(b.getFEN()).perft(5));
        assertEquals(6249, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft66()
    {
        System.out.println("\nFEN #67: K7/p7/k7/8/8/8/8/8 w - - 0 1");
        Board b = new Board("K7/p7/k7/8/8/8/8/8 w - - 0 1");
        assertEquals(1, new Perft(b.getFEN()).perft(1));
        assertEquals(3, new Perft(b.getFEN()).perft(2));
        assertEquals(12, new Perft(b.getFEN()).perft(3));
        assertEquals(80, new Perft(b.getFEN()).perft(4));
        assertEquals(342, new Perft(b.getFEN()).perft(5));
        assertEquals(2343, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft67()
    {
        System.out.println("\nFEN #68: 7K/7p/7k/8/8/8/8/8 w - - 0 1");
        Board b = new Board("7K/7p/7k/8/8/8/8/8 w - - 0 1");
        assertEquals(1, new Perft(b.getFEN()).perft(1));
        assertEquals(3, new Perft(b.getFEN()).perft(2));
        assertEquals(12, new Perft(b.getFEN()).perft(3));
        assertEquals(80, new Perft(b.getFEN()).perft(4));
        assertEquals(342, new Perft(b.getFEN()).perft(5));
        assertEquals(2343, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft68()
    {
        System.out.println("\nFEN #69: 8/2k1p3/3pP3/3P2K1/8/8/8/8 w - - 0 1");
        Board b = new Board("8/2k1p3/3pP3/3P2K1/8/8/8/8 w - - 0 1");
        assertEquals(7, new Perft(b.getFEN()).perft(1));
        assertEquals(35, new Perft(b.getFEN()).perft(2));
        assertEquals(210, new Perft(b.getFEN()).perft(3));
        assertEquals(1091, new Perft(b.getFEN()).perft(4));
        assertEquals(7028, new Perft(b.getFEN()).perft(5));
        assertEquals(34834, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft69()
    {
        System.out.println("\nFEN #70: 8/8/8/8/8/K7/P7/k7 b - - 0 1");
        Board b = new Board("8/8/8/8/8/K7/P7/k7 b - - 0 1");
        assertEquals(1, new Perft(b.getFEN()).perft(1));
        assertEquals(3, new Perft(b.getFEN()).perft(2));
        assertEquals(12, new Perft(b.getFEN()).perft(3));
        assertEquals(80, new Perft(b.getFEN()).perft(4));
        assertEquals(342, new Perft(b.getFEN()).perft(5));
        assertEquals(2343, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft70()
    {
        System.out.println("\nFEN #71: 8/8/8/8/8/7K/7P/7k b - - 0 1");
        Board b = new Board("8/8/8/8/8/7K/7P/7k b - - 0 1");
        assertEquals(1, new Perft(b.getFEN()).perft(1));
        assertEquals(3, new Perft(b.getFEN()).perft(2));
        assertEquals(12, new Perft(b.getFEN()).perft(3));
        assertEquals(80, new Perft(b.getFEN()).perft(4));
        assertEquals(342, new Perft(b.getFEN()).perft(5));
        assertEquals(2343, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft71()
    {
        System.out.println("\nFEN #72: K7/p7/k7/8/8/8/8/8 b - - 0 1");
        Board b = new Board("K7/p7/k7/8/8/8/8/8 b - - 0 1");
        assertEquals(3, new Perft(b.getFEN()).perft(1));
        assertEquals(7, new Perft(b.getFEN()).perft(2));
        assertEquals(43, new Perft(b.getFEN()).perft(3));
        assertEquals(199, new Perft(b.getFEN()).perft(4));
        assertEquals(1347, new Perft(b.getFEN()).perft(5));
        assertEquals(6249, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft72()
    {
        System.out.println("\nFEN #73: 7K/7p/7k/8/8/8/8/8 b - - 0 1");
        Board b = new Board("7K/7p/7k/8/8/8/8/8 b - - 0 1");
        assertEquals(3, new Perft(b.getFEN()).perft(1));
        assertEquals(7, new Perft(b.getFEN()).perft(2));
        assertEquals(43, new Perft(b.getFEN()).perft(3));
        assertEquals(199, new Perft(b.getFEN()).perft(4));
        assertEquals(1347, new Perft(b.getFEN()).perft(5));
        assertEquals(6249, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft73()
    {
        System.out.println("\nFEN #74: 8/2k1p3/3pP3/3P2K1/8/8/8/8 b - - 0 1");
        Board b = new Board("8/2k1p3/3pP3/3P2K1/8/8/8/8 b - - 0 1");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        assertEquals(35, new Perft(b.getFEN()).perft(2));
        assertEquals(182, new Perft(b.getFEN()).perft(3));
        assertEquals(1091, new Perft(b.getFEN()).perft(4));
        assertEquals(5408, new Perft(b.getFEN()).perft(5));
        assertEquals(34822, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft74()
    {
        System.out.println("\nFEN #75: 8/8/8/8/8/4k3/4P3/4K3 w - - 0 1");
        Board b = new Board("8/8/8/8/8/4k3/4P3/4K3 w - - 0 1");
        assertEquals(2, new Perft(b.getFEN()).perft(1));
        assertEquals(8, new Perft(b.getFEN()).perft(2));
        assertEquals(44, new Perft(b.getFEN()).perft(3));
        assertEquals(282, new Perft(b.getFEN()).perft(4));
        assertEquals(1814, new Perft(b.getFEN()).perft(5));
        assertEquals(11848, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft75()
    {
        System.out.println("\nFEN #76: 4k3/4p3/4K3/8/8/8/8/8 b - - 0 1");
        Board b = new Board("4k3/4p3/4K3/8/8/8/8/8 b - - 0 1");
        assertEquals(2, new Perft(b.getFEN()).perft(1));
        assertEquals(8, new Perft(b.getFEN()).perft(2));
        assertEquals(44, new Perft(b.getFEN()).perft(3));
        assertEquals(282, new Perft(b.getFEN()).perft(4));
        assertEquals(1814, new Perft(b.getFEN()).perft(5));
        assertEquals(11848, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft76()
    {
        System.out.println("\nFEN #77: 8/8/7k/7p/7P/7K/8/8 w - - 0 1");
        Board b = new Board("8/8/7k/7p/7P/7K/8/8 w - - 0 1");
        assertEquals(3, new Perft(b.getFEN()).perft(1));
        assertEquals(9, new Perft(b.getFEN()).perft(2));
        assertEquals(57, new Perft(b.getFEN()).perft(3));
        assertEquals(360, new Perft(b.getFEN()).perft(4));
        assertEquals(1969, new Perft(b.getFEN()).perft(5));
        assertEquals(10724, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft77()
    {
        System.out.println("\nFEN #78: 8/8/k7/p7/P7/K7/8/8 w - - 0 1");
        Board b = new Board("8/8/k7/p7/P7/K7/8/8 w - - 0 1");
        assertEquals(3, new Perft(b.getFEN()).perft(1));
        assertEquals(9, new Perft(b.getFEN()).perft(2));
        assertEquals(57, new Perft(b.getFEN()).perft(3));
        assertEquals(360, new Perft(b.getFEN()).perft(4));
        assertEquals(1969, new Perft(b.getFEN()).perft(5));
        assertEquals(10724, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft78()
    {
        System.out.println("\nFEN #79: 8/8/3k4/3p4/3P4/3K4/8/8 w - - 0 1");
        Board b = new Board("8/8/3k4/3p4/3P4/3K4/8/8 w - - 0 1");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        assertEquals(25, new Perft(b.getFEN()).perft(2));
        assertEquals(180, new Perft(b.getFEN()).perft(3));
        assertEquals(1294, new Perft(b.getFEN()).perft(4));
        assertEquals(8296, new Perft(b.getFEN()).perft(5));
        assertEquals(53138, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft79()
    {
        System.out.println("\nFEN #80: 8/3k4/3p4/8/3P4/3K4/8/8 w - - 0 1");
        Board b = new Board("8/3k4/3p4/8/3P4/3K4/8/8 w - - 0 1");
        assertEquals(8, new Perft(b.getFEN()).perft(1));
        assertEquals(61, new Perft(b.getFEN()).perft(2));
        assertEquals(483, new Perft(b.getFEN()).perft(3));
        assertEquals(3213, new Perft(b.getFEN()).perft(4));
        assertEquals(23599, new Perft(b.getFEN()).perft(5));
        assertEquals(157093, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft80()
    {
        System.out.println("\nFEN #81: 8/8/3k4/3p4/8/3P4/3K4/8 w - - 0 1");
        Board b = new Board("8/8/3k4/3p4/8/3P4/3K4/8 w - - 0 1");
        assertEquals(8, new Perft(b.getFEN()).perft(1));
        assertEquals(61, new Perft(b.getFEN()).perft(2));
        assertEquals(411, new Perft(b.getFEN()).perft(3));
        assertEquals(3213, new Perft(b.getFEN()).perft(4));
        assertEquals(21637, new Perft(b.getFEN()).perft(5));
        assertEquals(158065, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft81()
    {
        System.out.println("\nFEN #82: k7/8/3p4/8/3P4/8/8/7K w - - 0 1");
        Board b = new Board("k7/8/3p4/8/3P4/8/8/7K w - - 0 1");
        assertEquals(4, new Perft(b.getFEN()).perft(1));
        assertEquals(15, new Perft(b.getFEN()).perft(2));
        assertEquals(90, new Perft(b.getFEN()).perft(3));
        assertEquals(534, new Perft(b.getFEN()).perft(4));
        assertEquals(3450, new Perft(b.getFEN()).perft(5));
        assertEquals(20960, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft82()
    {
        System.out.println("\nFEN #83: 8/8/7k/7p/7P/7K/8/8 b - - 0 1");
        Board b = new Board("8/8/7k/7p/7P/7K/8/8 b - - 0 1");
        assertEquals(3, new Perft(b.getFEN()).perft(1));
        assertEquals(9, new Perft(b.getFEN()).perft(2));
        assertEquals(57, new Perft(b.getFEN()).perft(3));
        assertEquals(360, new Perft(b.getFEN()).perft(4));
        assertEquals(1969, new Perft(b.getFEN()).perft(5));
        assertEquals(10724, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft83()
    {
        System.out.println("\nFEN #84: 8/8/k7/p7/P7/K7/8/8 b - - 0 1");
        Board b = new Board("8/8/k7/p7/P7/K7/8/8 b - - 0 1");
        assertEquals(3, new Perft(b.getFEN()).perft(1));
        assertEquals(9, new Perft(b.getFEN()).perft(2));
        assertEquals(57, new Perft(b.getFEN()).perft(3));
        assertEquals(360, new Perft(b.getFEN()).perft(4));
        assertEquals(1969, new Perft(b.getFEN()).perft(5));
        assertEquals(10724, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft84()
    {
        System.out.println("\nFEN #85: 8/8/3k4/3p4/3P4/3K4/8/8 b - - 0 1");
        Board b = new Board("8/8/3k4/3p4/3P4/3K4/8/8 b - - 0 1");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        assertEquals(25, new Perft(b.getFEN()).perft(2));
        assertEquals(180, new Perft(b.getFEN()).perft(3));
        assertEquals(1294, new Perft(b.getFEN()).perft(4));
        assertEquals(8296, new Perft(b.getFEN()).perft(5));
        assertEquals(53138, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft85()
    {
        System.out.println("\nFEN #86: 8/3k4/3p4/8/3P4/3K4/8/8 b - - 0 1");
        Board b = new Board("8/3k4/3p4/8/3P4/3K4/8/8 b - - 0 1");
        assertEquals(8, new Perft(b.getFEN()).perft(1));
        assertEquals(61, new Perft(b.getFEN()).perft(2));
        assertEquals(411, new Perft(b.getFEN()).perft(3));
        assertEquals(3213, new Perft(b.getFEN()).perft(4));
        assertEquals(21637, new Perft(b.getFEN()).perft(5));
        assertEquals(158065, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft86()
    {
        System.out.println("\nFEN #87: 8/8/3k4/3p4/8/3P4/3K4/8 b - - 0 1");
        Board b = new Board("8/8/3k4/3p4/8/3P4/3K4/8 b - - 0 1");
        assertEquals(8, new Perft(b.getFEN()).perft(1));
        assertEquals(61, new Perft(b.getFEN()).perft(2));
        assertEquals(483, new Perft(b.getFEN()).perft(3));
        assertEquals(3213, new Perft(b.getFEN()).perft(4));
        assertEquals(23599, new Perft(b.getFEN()).perft(5));
        assertEquals(157093, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft87()
    {
        System.out.println("\nFEN #88: k7/8/3p4/8/3P4/8/8/7K b - - 0 1");
        Board b = new Board("k7/8/3p4/8/3P4/8/8/7K b - - 0 1");
        assertEquals(4, new Perft(b.getFEN()).perft(1));
        assertEquals(15, new Perft(b.getFEN()).perft(2));
        assertEquals(89, new Perft(b.getFEN()).perft(3));
        assertEquals(537, new Perft(b.getFEN()).perft(4));
        assertEquals(3309, new Perft(b.getFEN()).perft(5));
        assertEquals(21104, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft88()
    {
        System.out.println("\nFEN #89: 7k/3p4/8/8/3P4/8/8/K7 w - - 0 1");
        Board b = new Board("7k/3p4/8/8/3P4/8/8/K7 w - - 0 1");
        assertEquals(4, new Perft(b.getFEN()).perft(1));
        assertEquals(19, new Perft(b.getFEN()).perft(2));
        assertEquals(117, new Perft(b.getFEN()).perft(3));
        assertEquals(720, new Perft(b.getFEN()).perft(4));
        assertEquals(4661, new Perft(b.getFEN()).perft(5));
        assertEquals(32191, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft89()
    {
        System.out.println("\nFEN #90: 7k/8/8/3p4/8/8/3P4/K7 w - - 0 1");
        Board b = new Board("7k/8/8/3p4/8/8/3P4/K7 w - - 0 1");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        assertEquals(19, new Perft(b.getFEN()).perft(2));
        assertEquals(116, new Perft(b.getFEN()).perft(3));
        assertEquals(716, new Perft(b.getFEN()).perft(4));
        assertEquals(4786, new Perft(b.getFEN()).perft(5));
        assertEquals(30980, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft90()
    {
        System.out.println("\nFEN #91: k7/8/8/7p/6P1/8/8/K7 w - - 0 1");
        Board b = new Board("k7/8/8/7p/6P1/8/8/K7 w - - 0 1");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        assertEquals(22, new Perft(b.getFEN()).perft(2));
        assertEquals(139, new Perft(b.getFEN()).perft(3));
        assertEquals(877, new Perft(b.getFEN()).perft(4));
        assertEquals(6112, new Perft(b.getFEN()).perft(5));
        assertEquals(41874, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft91()
    {
        System.out.println("\nFEN #92: k7/8/7p/8/8/6P1/8/K7 w - - 0 1");
        Board b = new Board("k7/8/7p/8/8/6P1/8/K7 w - - 0 1");
        assertEquals(4, new Perft(b.getFEN()).perft(1));
        assertEquals(16, new Perft(b.getFEN()).perft(2));
        assertEquals(101, new Perft(b.getFEN()).perft(3));
        assertEquals(637, new Perft(b.getFEN()).perft(4));
        assertEquals(4354, new Perft(b.getFEN()).perft(5));
        assertEquals(29679, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft92()
    {
        System.out.println("\nFEN #93: k7/8/8/6p1/7P/8/8/K7 w - - 0 1");
        Board b = new Board("k7/8/8/6p1/7P/8/8/K7 w - - 0 1");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        assertEquals(22, new Perft(b.getFEN()).perft(2));
        assertEquals(139, new Perft(b.getFEN()).perft(3));
        assertEquals(877, new Perft(b.getFEN()).perft(4));
        assertEquals(6112, new Perft(b.getFEN()).perft(5));
        assertEquals(41874, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft93()
    {
        System.out.println("\nFEN #94: k7/8/6p1/8/8/7P/8/K7 w - - 0 1");
        Board b = new Board("k7/8/6p1/8/8/7P/8/K7 w - - 0 1");
        assertEquals(4, new Perft(b.getFEN()).perft(1));
        assertEquals(16, new Perft(b.getFEN()).perft(2));
        assertEquals(101, new Perft(b.getFEN()).perft(3));
        assertEquals(637, new Perft(b.getFEN()).perft(4));
        assertEquals(4354, new Perft(b.getFEN()).perft(5));
        assertEquals(29679, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft94()
    {
        System.out.println("\nFEN #95: k7/8/8/3p4/4p3/8/8/7K w - - 0 1");
        Board b = new Board("k7/8/8/3p4/4p3/8/8/7K w - - 0 1");
        assertEquals(3, new Perft(b.getFEN()).perft(1));
        assertEquals(15, new Perft(b.getFEN()).perft(2));
        assertEquals(84, new Perft(b.getFEN()).perft(3));
        assertEquals(573, new Perft(b.getFEN()).perft(4));
        assertEquals(3013, new Perft(b.getFEN()).perft(5));
        assertEquals(22886, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft95()
    {
        System.out.println("\nFEN #96: k7/8/3p4/8/8/4P3/8/7K w - - 0 1");
        Board b = new Board("k7/8/3p4/8/8/4P3/8/7K w - - 0 1");
        assertEquals(4, new Perft(b.getFEN()).perft(1));
        assertEquals(16, new Perft(b.getFEN()).perft(2));
        assertEquals(101, new Perft(b.getFEN()).perft(3));
        assertEquals(637, new Perft(b.getFEN()).perft(4));
        assertEquals(4271, new Perft(b.getFEN()).perft(5));
        assertEquals(28662, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft96()
    {
        System.out.println("\nFEN #97: 7k/3p4/8/8/3P4/8/8/K7 b - - 0 1");
        Board b = new Board("7k/3p4/8/8/3P4/8/8/K7 b - - 0 1");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        assertEquals(19, new Perft(b.getFEN()).perft(2));
        assertEquals(117, new Perft(b.getFEN()).perft(3));
        assertEquals(720, new Perft(b.getFEN()).perft(4));
        assertEquals(5014, new Perft(b.getFEN()).perft(5));
        assertEquals(32167, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft97()
    {
        System.out.println("\nFEN #98: 7k/8/8/3p4/8/8/3P4/K7 b - - 0 1");
        Board b = new Board("7k/8/8/3p4/8/8/3P4/K7 b - - 0 1");
        assertEquals(4, new Perft(b.getFEN()).perft(1));
        assertEquals(19, new Perft(b.getFEN()).perft(2));
        assertEquals(117, new Perft(b.getFEN()).perft(3));
        assertEquals(712, new Perft(b.getFEN()).perft(4));
        assertEquals(4658, new Perft(b.getFEN()).perft(5));
        assertEquals(30749, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft98()
    {
        System.out.println("\nFEN #99: k7/8/8/7p/6P1/8/8/K7 b - - 0 1");
        Board b = new Board("k7/8/8/7p/6P1/8/8/K7 b - - 0 1");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        assertEquals(22, new Perft(b.getFEN()).perft(2));
        assertEquals(139, new Perft(b.getFEN()).perft(3));
        assertEquals(877, new Perft(b.getFEN()).perft(4));
        assertEquals(6112, new Perft(b.getFEN()).perft(5));
        assertEquals(41874, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft99()
    {
        System.out.println("\nFEN #100: k7/8/7p/8/8/6P1/8/K7 b - - 0 1");
        Board b = new Board("k7/8/7p/8/8/6P1/8/K7 b - - 0 1");
        assertEquals(4, new Perft(b.getFEN()).perft(1));
        assertEquals(16, new Perft(b.getFEN()).perft(2));
        assertEquals(101, new Perft(b.getFEN()).perft(3));
        assertEquals(637, new Perft(b.getFEN()).perft(4));
        assertEquals(4354, new Perft(b.getFEN()).perft(5));
        assertEquals(29679, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft100()
    {
        System.out.println("\nFEN #101: k7/8/8/6p1/7P/8/8/K7 b - - 0 1");
        Board b = new Board("k7/8/8/6p1/7P/8/8/K7 b - - 0 1");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        assertEquals(22, new Perft(b.getFEN()).perft(2));
        assertEquals(139, new Perft(b.getFEN()).perft(3));
        assertEquals(877, new Perft(b.getFEN()).perft(4));
        assertEquals(6112, new Perft(b.getFEN()).perft(5));
        assertEquals(41874, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft101()
    {
        System.out.println("\nFEN #102: k7/8/6p1/8/8/7P/8/K7 b - - 0 1");
        Board b = new Board("k7/8/6p1/8/8/7P/8/K7 b - - 0 1");
        assertEquals(4, new Perft(b.getFEN()).perft(1));
        assertEquals(16, new Perft(b.getFEN()).perft(2));
        assertEquals(101, new Perft(b.getFEN()).perft(3));
        assertEquals(637, new Perft(b.getFEN()).perft(4));
        assertEquals(4354, new Perft(b.getFEN()).perft(5));
        assertEquals(29679, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft102()
    {
        System.out.println("\nFEN #103: k7/8/8/3p4/4p3/8/8/7K b - - 0 1");
        Board b = new Board("k7/8/8/3p4/4p3/8/8/7K b - - 0 1");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        assertEquals(15, new Perft(b.getFEN()).perft(2));
        assertEquals(102, new Perft(b.getFEN()).perft(3));
        assertEquals(569, new Perft(b.getFEN()).perft(4));
        assertEquals(4337, new Perft(b.getFEN()).perft(5));
        assertEquals(22579, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft103()
    {
        System.out.println("\nFEN #104: k7/8/3p4/8/8/4P3/8/7K b - - 0 1");
        Board b = new Board("k7/8/3p4/8/8/4P3/8/7K b - - 0 1");
        assertEquals(4, new Perft(b.getFEN()).perft(1));
        assertEquals(16, new Perft(b.getFEN()).perft(2));
        assertEquals(101, new Perft(b.getFEN()).perft(3));
        assertEquals(637, new Perft(b.getFEN()).perft(4));
        assertEquals(4271, new Perft(b.getFEN()).perft(5));
        assertEquals(28662, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft104()
    {
        System.out.println("\nFEN #105: 7k/8/8/p7/1P6/8/8/7K w - - 0 1");
        Board b = new Board("7k/8/8/p7/1P6/8/8/7K w - - 0 1");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        assertEquals(22, new Perft(b.getFEN()).perft(2));
        assertEquals(139, new Perft(b.getFEN()).perft(3));
        assertEquals(877, new Perft(b.getFEN()).perft(4));
        assertEquals(6112, new Perft(b.getFEN()).perft(5));
        assertEquals(41874, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft105()
    {
        System.out.println("\nFEN #106: 7k/8/p7/8/8/1P6/8/7K w - - 0 1");
        Board b = new Board("7k/8/p7/8/8/1P6/8/7K w - - 0 1");
        assertEquals(4, new Perft(b.getFEN()).perft(1));
        assertEquals(16, new Perft(b.getFEN()).perft(2));
        assertEquals(101, new Perft(b.getFEN()).perft(3));
        assertEquals(637, new Perft(b.getFEN()).perft(4));
        assertEquals(4354, new Perft(b.getFEN()).perft(5));
        assertEquals(29679, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft106()
    {
        System.out.println("\nFEN #107: 7k/8/8/1p6/P7/8/8/7K w - - 0 1");
        Board b = new Board("7k/8/8/1p6/P7/8/8/7K w - - 0 1");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        assertEquals(22, new Perft(b.getFEN()).perft(2));
        assertEquals(139, new Perft(b.getFEN()).perft(3));
        assertEquals(877, new Perft(b.getFEN()).perft(4));
        assertEquals(6112, new Perft(b.getFEN()).perft(5));
        assertEquals(41874, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft107()
    {
        System.out.println("\nFEN #108: 7k/8/1p6/8/8/P7/8/7K w - - 0 1");
        Board b = new Board("7k/8/1p6/8/8/P7/8/7K w - - 0 1");
        assertEquals(4, new Perft(b.getFEN()).perft(1));
        assertEquals(16, new Perft(b.getFEN()).perft(2));
        assertEquals(101, new Perft(b.getFEN()).perft(3));
        assertEquals(637, new Perft(b.getFEN()).perft(4));
        assertEquals(4354, new Perft(b.getFEN()).perft(5));
        assertEquals(29679, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft108()
    {
        System.out.println("\nFEN #109: k7/7p/8/8/8/8/6P1/K7 w - - 0 1");
        Board b = new Board("k7/7p/8/8/8/8/6P1/K7 w - - 0 1");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        assertEquals(25, new Perft(b.getFEN()).perft(2));
        assertEquals(161, new Perft(b.getFEN()).perft(3));
        assertEquals(1035, new Perft(b.getFEN()).perft(4));
        assertEquals(7574, new Perft(b.getFEN()).perft(5));
        assertEquals(55338, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft109()
    {
        System.out.println("\nFEN #110: k7/6p1/8/8/8/8/7P/K7 w - - 0 1");
        Board b = new Board("k7/6p1/8/8/8/8/7P/K7 w - - 0 1");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        assertEquals(25, new Perft(b.getFEN()).perft(2));
        assertEquals(161, new Perft(b.getFEN()).perft(3));
        assertEquals(1035, new Perft(b.getFEN()).perft(4));
        assertEquals(7574, new Perft(b.getFEN()).perft(5));
        assertEquals(55338, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft110()
    {
        System.out.println("\nFEN #111: 3k4/3pp3/8/8/8/8/3PP3/3K4 w - - 0 1");
        Board b = new Board("3k4/3pp3/8/8/8/8/3PP3/3K4 w - - 0 1");
        assertEquals(7, new Perft(b.getFEN()).perft(1));
        assertEquals(49, new Perft(b.getFEN()).perft(2));
        assertEquals(378, new Perft(b.getFEN()).perft(3));
        assertEquals(2902, new Perft(b.getFEN()).perft(4));
        assertEquals(24122, new Perft(b.getFEN()).perft(5));
        assertEquals(199002, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft111()
    {
        System.out.println("\nFEN #112: 7k/8/8/p7/1P6/8/8/7K b - - 0 1");
        Board b = new Board("7k/8/8/p7/1P6/8/8/7K b - - 0 1");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        assertEquals(22, new Perft(b.getFEN()).perft(2));
        assertEquals(139, new Perft(b.getFEN()).perft(3));
        assertEquals(877, new Perft(b.getFEN()).perft(4));
        assertEquals(6112, new Perft(b.getFEN()).perft(5));
        assertEquals(41874, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft112()
    {
        System.out.println("\nFEN #113: 7k/8/p7/8/8/1P6/8/7K b - - 0 1");
        Board b = new Board("7k/8/p7/8/8/1P6/8/7K b - - 0 1");
        assertEquals(4, new Perft(b.getFEN()).perft(1));
        assertEquals(16, new Perft(b.getFEN()).perft(2));
        assertEquals(101, new Perft(b.getFEN()).perft(3));
        assertEquals(637, new Perft(b.getFEN()).perft(4));
        assertEquals(4354, new Perft(b.getFEN()).perft(5));
        assertEquals(29679, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft113()
    {
        System.out.println("\nFEN #114: 7k/8/8/1p6/P7/8/8/7K b - - 0 1");
        Board b = new Board("7k/8/8/1p6/P7/8/8/7K b - - 0 1");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        assertEquals(22, new Perft(b.getFEN()).perft(2));
        assertEquals(139, new Perft(b.getFEN()).perft(3));
        assertEquals(877, new Perft(b.getFEN()).perft(4));
        assertEquals(6112, new Perft(b.getFEN()).perft(5));
        assertEquals(41874, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft114()
    {
        System.out.println("\nFEN #115: 7k/8/1p6/8/8/P7/8/7K b - - 0 1");
        Board b = new Board("7k/8/1p6/8/8/P7/8/7K b - - 0 1");
        assertEquals(4, new Perft(b.getFEN()).perft(1));
        assertEquals(16, new Perft(b.getFEN()).perft(2));
        assertEquals(101, new Perft(b.getFEN()).perft(3));
        assertEquals(637, new Perft(b.getFEN()).perft(4));
        assertEquals(4354, new Perft(b.getFEN()).perft(5));
        assertEquals(29679, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft115()
    {
        System.out.println("\nFEN #116: k7/7p/8/8/8/8/6P1/K7 b - - 0 1");
        Board b = new Board("k7/7p/8/8/8/8/6P1/K7 b - - 0 1");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        assertEquals(25, new Perft(b.getFEN()).perft(2));
        assertEquals(161, new Perft(b.getFEN()).perft(3));
        assertEquals(1035, new Perft(b.getFEN()).perft(4));
        assertEquals(7574, new Perft(b.getFEN()).perft(5));
        assertEquals(55338, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft116()
    {
        System.out.println("\nFEN #117: k7/6p1/8/8/8/8/7P/K7 b - - 0 1");
        Board b = new Board("k7/6p1/8/8/8/8/7P/K7 b - - 0 1");
        assertEquals(5, new Perft(b.getFEN()).perft(1));
        assertEquals(25, new Perft(b.getFEN()).perft(2));
        assertEquals(161, new Perft(b.getFEN()).perft(3));
        assertEquals(1035, new Perft(b.getFEN()).perft(4));
        assertEquals(7574, new Perft(b.getFEN()).perft(5));
        assertEquals(55338, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft117()
    {
        System.out.println("\nFEN #118: 3k4/3pp3/8/8/8/8/3PP3/3K4 b - - 0 1");
        Board b = new Board("3k4/3pp3/8/8/8/8/3PP3/3K4 b - - 0 1");
        assertEquals(7, new Perft(b.getFEN()).perft(1));
        assertEquals(49, new Perft(b.getFEN()).perft(2));
        assertEquals(378, new Perft(b.getFEN()).perft(3));
        assertEquals(2902, new Perft(b.getFEN()).perft(4));
        assertEquals(24122, new Perft(b.getFEN()).perft(5));
        assertEquals(199002, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft118()
    {
        System.out.println("\nFEN #119: 8/Pk6/8/8/8/8/6Kp/8 w - - 0 1");
        Board b = new Board("8/Pk6/8/8/8/8/6Kp/8 w - - 0 1");
        assertEquals(11, new Perft(b.getFEN()).perft(1));
        assertEquals(97, new Perft(b.getFEN()).perft(2));
        assertEquals(887, new Perft(b.getFEN()).perft(3));
        assertEquals(8048, new Perft(b.getFEN()).perft(4));
        assertEquals(90606, new Perft(b.getFEN()).perft(5));
        assertEquals(1030499, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft119()
    {
        System.out.println("\nFEN #120: n1n5/1Pk5/8/8/8/8/5Kp1/5N1N w - - 0 1");
        Board b = new Board("n1n5/1Pk5/8/8/8/8/5Kp1/5N1N w - - 0 1");
        assertEquals(24, new Perft(b.getFEN()).perft(1));
        assertEquals(421, new Perft(b.getFEN()).perft(2));
        assertEquals(7421, new Perft(b.getFEN()).perft(3));
        assertEquals(124608, new Perft(b.getFEN()).perft(4));
        assertEquals(2193768, new Perft(b.getFEN()).perft(5));
        assertEquals(37665329, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft120()
    {
        System.out.println("\nFEN #121: 8/PPPk4/8/8/8/8/4Kppp/8 w - - 0 1");
        Board b = new Board("8/PPPk4/8/8/8/8/4Kppp/8 w - - 0 1");
        assertEquals(18, new Perft(b.getFEN()).perft(1));
        assertEquals(270, new Perft(b.getFEN()).perft(2));
        assertEquals(4699, new Perft(b.getFEN()).perft(3));
        assertEquals(79355, new Perft(b.getFEN()).perft(4));
        assertEquals(1533145, new Perft(b.getFEN()).perft(5));
        assertEquals(28859283, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft121()
    {
        System.out.println("\nFEN #122: n1n5/PPPk4/8/8/8/8/4Kppp/5N1N w - - 0 1");
        Board b = new Board("n1n5/PPPk4/8/8/8/8/4Kppp/5N1N w - - 0 1");
        assertEquals(24, new Perft(b.getFEN()).perft(1));
        assertEquals(496, new Perft(b.getFEN()).perft(2));
        assertEquals(9483, new Perft(b.getFEN()).perft(3));
        assertEquals(182838, new Perft(b.getFEN()).perft(4));
        assertEquals(3605103, new Perft(b.getFEN()).perft(5));
        assertEquals(71179139, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft122()
    {
        System.out.println("\nFEN #123: 8/Pk6/8/8/8/8/6Kp/8 b - - 0 1");
        Board b = new Board("8/Pk6/8/8/8/8/6Kp/8 b - - 0 1");
        assertEquals(11, new Perft(b.getFEN()).perft(1));
        assertEquals(97, new Perft(b.getFEN()).perft(2));
        assertEquals(887, new Perft(b.getFEN()).perft(3));
        assertEquals(8048, new Perft(b.getFEN()).perft(4));
        assertEquals(90606, new Perft(b.getFEN()).perft(5));
        assertEquals(1030499, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft123()
    {
        System.out.println("\nFEN #124: n1n5/1Pk5/8/8/8/8/5Kp1/5N1N b - - 0 1");
        Board b = new Board("n1n5/1Pk5/8/8/8/8/5Kp1/5N1N b - - 0 1");
        assertEquals(24, new Perft(b.getFEN()).perft(1));
        assertEquals(421, new Perft(b.getFEN()).perft(2));
        assertEquals(7421, new Perft(b.getFEN()).perft(3));
        assertEquals(124608, new Perft(b.getFEN()).perft(4));
        assertEquals(2193768, new Perft(b.getFEN()).perft(5));
        assertEquals(37665329, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft124()
    {
        System.out.println("\nFEN #125: 8/PPPk4/8/8/8/8/4Kppp/8 b - - 0 1");
        Board b = new Board("8/PPPk4/8/8/8/8/4Kppp/8 b - - 0 1");
        assertEquals(18, new Perft(b.getFEN()).perft(1));
        assertEquals(270, new Perft(b.getFEN()).perft(2));
        assertEquals(4699, new Perft(b.getFEN()).perft(3));
        assertEquals(79355, new Perft(b.getFEN()).perft(4));
        assertEquals(1533145, new Perft(b.getFEN()).perft(5));
        assertEquals(28859283, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft125()
    {
        System.out.println("\nFEN #126: n1n5/PPPk4/8/8/8/8/4Kppp/5N1N b - - 0 1");
        Board b = new Board("n1n5/PPPk4/8/8/8/8/4Kppp/5N1N b - - 0 1");
        assertEquals(24, new Perft(b.getFEN()).perft(1));
        assertEquals(496, new Perft(b.getFEN()).perft(2));
        assertEquals(9483, new Perft(b.getFEN()).perft(3));
        assertEquals(182838, new Perft(b.getFEN()).perft(4));
        assertEquals(3605103, new Perft(b.getFEN()).perft(5));
        assertEquals(71179139, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft126()
    {
        System.out.println("\nFEN #127: r3k2r/p1ppqpb1/bn2pnp1/3PN3/1p2P3/2N2Q1p/PPPBBPPP/R3K2R w KQkq - 0 1 ");
        Board b = new Board("r3k2r/p1ppqpb1/bn2pnp1/3PN3/1p2P3/2N2Q1p/PPPBBPPP/R3K2R w KQkq - 0 1 ");
        assertEquals(48, new Perft(b.getFEN()).perft(1));
        assertEquals(2039, new Perft(b.getFEN()).perft(2));
        assertEquals(97862, new Perft(b.getFEN()).perft(3));
        assertEquals(4085603, new Perft(b.getFEN()).perft(4));
        assertEquals(193690690, new Perft(b.getFEN()).perft(5));
    }

}
