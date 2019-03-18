import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class Test2 {

    @Test
    public void perft1()
    {
        Board b = new Board("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
        Assert.assertEquals(20, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(400, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(8902, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(197281, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(4865609, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(119060324, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft2()
    {
        Board b = new Board("3k4/3p4/8/K1P4r/8/8/8/8 b - - 0 1");
        Assert.assertEquals(18, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(92, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(1670, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(10138, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(185429, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(1134888, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft3()
    {
        Board b = new Board("4k3/8/8/8/8/8/8/4K2R w K - 0 1");
        Assert.assertEquals(15, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(66, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(1197, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(7059, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(133987, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(764643, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft4()
    {
        Board b = new Board("4k3/8/8/8/8/8/8/R3K3 w Q - 0 1");
        Assert.assertEquals(16, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(71, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(1287, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(7626, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(145232, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(846648, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft5()
    {
        Board b = new Board("4k2r/8/8/8/8/8/8/4K3 w k - 0 1");
        Assert.assertEquals(5, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(75, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(459, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(8290, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(47635, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(899442, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft6()
    {
        Board b = new Board("r3k3/8/8/8/8/8/8/4K3 w q - 0 1");
        Assert.assertEquals(5, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(80, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(493, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(8897, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(52710, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(1001523, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft7()
    {
        Board b = new Board("4k3/8/8/8/8/8/8/R3K2R w KQ - 0 1");
        Assert.assertEquals(26, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(112, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(3189, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(17945, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(532933, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(2788982, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft8()
    {
        Board b = new Board("r3k2r/8/8/8/8/8/8/4K3 w kq - 0 1");
        Assert.assertEquals(5, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(130, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(782, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(22180, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(118882, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(3517770, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft9()
    {
        Board b = new Board("8/8/8/8/8/8/6k1/4K2R w K - 0 1");
        Assert.assertEquals(12, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(38, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(564, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(2219, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(37735, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(185867, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft10()
    {
        Board b = new Board("8/8/8/8/8/8/1k6/R3K3 w Q - 0 1");
        Assert.assertEquals(15, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(65, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(1018, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(4573, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(80619, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(413018, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft11()
    {
        Board b = new Board("4k2r/6K1/8/8/8/8/8/8 w k - 0 1");
        Assert.assertEquals(3, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(32, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(134, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(2073, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(10485, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(179869, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft12()
    {
        Board b = new Board("r3k3/1K6/8/8/8/8/8/8 w q - 0 1");
        Assert.assertEquals(4, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(49, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(243, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(3991, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(20780, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(367724, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft13()
    {
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K2R w KQkq - 0 1");
        Assert.assertEquals(26, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(568, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(13744, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(314346, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(7594526, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(179862938, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft14()
    {
        Board b = new Board("r3k2r/8/8/8/8/8/8/1R2K2R w Kkq - 0 1");
        Assert.assertEquals(25, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(567, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(14095, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(328965, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(8153719, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(195629489, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft15()
    {
        Board b = new Board("r3k2r/8/8/8/8/8/8/2R1K2R w Kkq - 0 1");
        Assert.assertEquals(25, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(548, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(13502, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(312835, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(7736373, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(184411439, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft16()
    {
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K1R1 w Qkq - 0 1");
        Assert.assertEquals(25, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(547, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(13579, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(316214, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(7878456, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(189224276, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft17()
    {
        Board b = new Board("1r2k2r/8/8/8/8/8/8/R3K2R w KQk - 0 1");
        Assert.assertEquals(26, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(583, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(14252, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(334705, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(8198901, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(198328929, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft18()
    {
        Board b = new Board("2r1k2r/8/8/8/8/8/8/R3K2R w KQk - 0 1");
        Assert.assertEquals(25, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(560, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(13592, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(317324, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(7710115, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(185959088, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft19()
    {
        Board b = new Board("r3k1r1/8/8/8/8/8/8/R3K2R w KQq - 0 1");
        Assert.assertEquals(25, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(560, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(13607, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(320792, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(7848606, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(190755813, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft20()
    {
        Board b = new Board("4k3/8/8/8/8/8/8/4K2R b K - 0 1");
        Assert.assertEquals(5, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(75, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(459, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(8290, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(47635, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(899442, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft21()
    {
        Board b = new Board("4k3/8/8/8/8/8/8/R3K3 b Q - 0 1");
        Assert.assertEquals(5, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(80, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(493, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(8897, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(52710, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(1001523, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft22()
    {
        Board b = new Board("4k2r/8/8/8/8/8/8/4K3 b k - 0 1");
        Assert.assertEquals(15, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(66, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(1197, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(7059, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(133987, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(764643, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft23()
    {
        Board b = new Board("r3k3/8/8/8/8/8/8/4K3 b q - 0 1");
        Assert.assertEquals(16, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(71, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(1287, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(7626, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(145232, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(846648, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft24()
    {
        Board b = new Board("4k3/8/8/8/8/8/8/R3K2R b KQ - 0 1");
        Assert.assertEquals(5, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(130, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(782, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(22180, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(118882, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(3517770, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft25()
    {
        Board b = new Board("r3k2r/8/8/8/8/8/8/4K3 b kq - 0 1");
        Assert.assertEquals(26, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(112, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(3189, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(17945, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(532933, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(2788982, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft26()
    {
        Board b = new Board("8/8/8/8/8/8/6k1/4K2R b K - 0 1");
        Assert.assertEquals(3, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(32, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(134, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(2073, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(10485, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(179869, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft27()
    {
        Board b = new Board("8/8/8/8/8/8/1k6/R3K3 b Q - 0 1");
        Assert.assertEquals(4, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(49, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(243, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(3991, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(20780, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(367724, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft28()
    {
        Board b = new Board("4k2r/6K1/8/8/8/8/8/8 b k - 0 1");
        Assert.assertEquals(12, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(38, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(564, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(2219, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(37735, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(185867, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft29()
    {
        Board b = new Board("r3k3/1K6/8/8/8/8/8/8 b q - 0 1");
        Assert.assertEquals(15, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(65, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(1018, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(4573, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(80619, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(413018, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft30()
    {
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K2R b KQkq - 0 1");
        Assert.assertEquals(26, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(568, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(13744, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(314346, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(7594526, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(179862938, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft31()
    {
        Board b = new Board("r3k2r/8/8/8/8/8/8/1R2K2R b Kkq - 0 1");
        Assert.assertEquals(26, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(583, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(14252, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(334705, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(8198901, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(198328929, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft32()
    {
        Board b = new Board("r3k2r/8/8/8/8/8/8/2R1K2R b Kkq - 0 1");
        Assert.assertEquals(25, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(560, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(13592, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(317324, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(7710115, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(185959088, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft33()
    {
        Board b = new Board("r3k2r/8/8/8/8/8/8/R3K1R1 b Qkq - 0 1");
        Assert.assertEquals(25, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(560, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(13607, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(320792, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(7848606, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(190755813, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft34()
    {
        Board b = new Board("1r2k2r/8/8/8/8/8/8/R3K2R b KQk - 0 1");
        Assert.assertEquals(25, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(567, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(14095, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(328965, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(8153719, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(195629489, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft35()
    {
        Board b = new Board("2r1k2r/8/8/8/8/8/8/R3K2R b KQk - 0 1");
        Assert.assertEquals(25, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(548, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(13502, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(312835, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(7736373, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(184411439, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft36()
    {
        Board b = new Board("r3k1r1/8/8/8/8/8/8/R3K2R b KQq - 0 1");
        Assert.assertEquals(25, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(547, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(13579, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(316214, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(7878456, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(189224276, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft37()
    {
        Board b = new Board("8/1n4N1/2k5/8/8/5K2/1N4n1/8 w - - 0 1");
        Assert.assertEquals(14, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(195, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(2760, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(38675, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(570726, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(8107539, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft38()
    {
        Board b = new Board("8/1k6/8/5N2/8/4n3/8/2K5 w - - 0 1");
        Assert.assertEquals(11, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(156, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(1636, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(20534, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(223507, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(2594412, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft39()
    {
        Board b = new Board("8/8/4k3/3Nn3/3nN3/4K3/8/8 w - - 0 1");
        Assert.assertEquals(19, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(289, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(4442, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(73584, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(1198299, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(19870403, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft40()
    {
        Board b = new Board("K7/8/2n5/1n6/8/8/8/k6N w - - 0 1");
        Assert.assertEquals(3, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(51, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(345, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(5301, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(38348, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(588695, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft41()
    {
        Board b = new Board("k7/8/2N5/1N6/8/8/8/K6n w - - 0 1");
        Assert.assertEquals(17, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(54, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(835, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(5910, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(92250, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(688780, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft42()
    {
        Board b = new Board("8/1n4N1/2k5/8/8/5K2/1N4n1/8 b - - 0 1");
        Assert.assertEquals(15, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(193, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(2816, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(40039, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(582642, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(8503277, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft43()
    {
        Board b = new Board("8/1k6/8/5N2/8/4n3/8/2K5 b - - 0 1");
        Assert.assertEquals(16, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(180, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(2290, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(24640, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(288141, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(3147566, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft44()
    {
        Board b = new Board("8/8/3K4/3Nn3/3nN3/4k3/8/8 b - - 0 1");
        Assert.assertEquals(4, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(68, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(1118, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(16199, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(281190, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(4405103, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft45()
    {
        Board b = new Board("K7/8/2n5/1n6/8/8/8/k6N b - - 0 1");
        Assert.assertEquals(17, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(54, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(835, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(5910, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(92250, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(688780, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft46()
    {
        Board b = new Board("k7/8/2N5/1N6/8/8/8/K6n b - - 0 1");
        Assert.assertEquals(3, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(51, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(345, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(5301, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(38348, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(588695, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft47()
    {
        Board b = new Board("B6b/8/8/8/2K5/4k3/8/b6B w - - 0 1");
        Assert.assertEquals(17, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(278, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(4607, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(76778, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(1320507, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(22823890, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft48()
    {
        Board b = new Board("8/8/1B6/7b/7k/8/2B1b3/7K w - - 0 1");
        Assert.assertEquals(21, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(316, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(5744, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(93338, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(1713368, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(28861171, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft49()
    {
        Board b = new Board("k7/B7/1B6/1B6/8/8/8/K6b w - - 0 1");
        Assert.assertEquals(21, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(144, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(3242, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(32955, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(787524, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(7881673, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft50()
    {
        Board b = new Board("K7/b7/1b6/1b6/8/8/8/k6B w - - 0 1");
        Assert.assertEquals(7, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(143, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(1416, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(31787, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(310862, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(7382896, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft51()
    {
        Board b = new Board("B6b/8/8/8/2K5/5k2/8/b6B b - - 0 1");
        Assert.assertEquals(6, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(106, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(1829, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(31151, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(530585, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(9250746, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft52()
    {
        Board b = new Board("8/8/1B6/7b/7k/8/2B1b3/7K b - - 0 1");
        Assert.assertEquals(17, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(309, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(5133, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(93603, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(1591064, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(29027891, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft53()
    {
        Board b = new Board("k7/B7/1B6/1B6/8/8/8/K6b b - - 0 1");
        Assert.assertEquals(7, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(143, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(1416, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(31787, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(310862, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(7382896, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft54()
    {
        Board b = new Board("K7/b7/1b6/1b6/8/8/8/k6B b - - 0 1");
        Assert.assertEquals(21, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(144, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(3242, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(32955, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(787524, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(7881673, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft55()
    {
        Board b = new Board("7k/RR6/8/8/8/8/rr6/7K w - - 0 1");
        Assert.assertEquals(19, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(275, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(5300, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(104342, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(2161211, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(44956585, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft56()
    {
        Board b = new Board("R6r/8/8/2K5/5k2/8/8/r6R w - - 0 1");
        Assert.assertEquals(36, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(1027, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(29215, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(771461, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(20506480, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(525169084, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft57()
    {
        Board b = new Board("7k/RR6/8/8/8/8/rr6/7K b - - 0 1");
        Assert.assertEquals(19, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(275, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(5300, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(104342, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(2161211, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(44956585, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft58()
    {
        Board b = new Board("R6r/8/8/2K5/5k2/8/8/r6R b - - 0 1");
        Assert.assertEquals(36, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(1027, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(29227, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(771368, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(20521342, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(524966748, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft59()
    {
        Board b = new Board("6kq/8/8/8/8/8/8/7K w - - 0 1");
        Assert.assertEquals(2, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(36, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(143, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(3637, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(14893, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(391507, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft60()
    {
        Board b = new Board("6KQ/8/8/8/8/8/8/7k b - - 0 1");
        Assert.assertEquals(2, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(36, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(143, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(3637, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(14893, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(391507, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft61()
    {
        Board b = new Board("K7/8/8/3Q4/4q3/8/8/7k w - - 0 1");
        Assert.assertEquals(6, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(35, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(495, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(8349, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(166741, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(3370175, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft62()
    {
        Board b = new Board("6qk/8/8/8/8/8/8/7K b - - 0 1");
        Assert.assertEquals(22, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(43, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(1015, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(4167, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(105749, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(419369, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft63()
    {
        Board b = new Board("6KQ/8/8/8/8/8/8/7k b - - 0 1");
        Assert.assertEquals(2, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(36, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(143, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(3637, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(14893, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(391507, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft64()
    {
        Board b = new Board("K7/8/8/3Q4/4q3/8/8/7k b - - 0 1");
        Assert.assertEquals(6, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(35, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(495, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(8349, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(166741, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(3370175, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft65()
    {
        Board b = new Board("8/8/8/8/8/K7/P7/k7 w - - 0 1");
        Assert.assertEquals(3, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(7, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(43, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(199, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(1347, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(6249, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft66()
    {
        Board b = new Board("8/8/8/8/8/7K/7P/7k w - - 0 1");
        Assert.assertEquals(3, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(7, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(43, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(199, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(1347, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(6249, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft67()
    {
        Board b = new Board("K7/p7/k7/8/8/8/8/8 w - - 0 1");
        Assert.assertEquals(1, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(3, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(12, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(80, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(342, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(2343, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft68()
    {
        Board b = new Board("7K/7p/7k/8/8/8/8/8 w - - 0 1");
        Assert.assertEquals(1, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(3, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(12, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(80, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(342, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(2343, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft69()
    {
        Board b = new Board("8/2k1p3/3pP3/3P2K1/8/8/8/8 w - - 0 1");
        Assert.assertEquals(7, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(35, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(210, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(1091, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(7028, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(34834, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft70()
    {
        Board b = new Board("8/8/8/8/8/K7/P7/k7 b - - 0 1");
        Assert.assertEquals(1, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(3, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(12, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(80, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(342, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(2343, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft71()
    {
        Board b = new Board("8/8/8/8/8/7K/7P/7k b - - 0 1");
        Assert.assertEquals(1, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(3, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(12, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(80, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(342, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(2343, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft72()
    {
        Board b = new Board("K7/p7/k7/8/8/8/8/8 b - - 0 1");
        Assert.assertEquals(3, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(7, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(43, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(199, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(1347, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(6249, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft73()
    {
        Board b = new Board("7K/7p/7k/8/8/8/8/8 b - - 0 1");
        Assert.assertEquals(3, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(7, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(43, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(199, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(1347, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(6249, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft74()
    {
        Board b = new Board("8/2k1p3/3pP3/3P2K1/8/8/8/8 b - - 0 1");
        Assert.assertEquals(5, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(35, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(182, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(1091, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(5408, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(34822, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft75()
    {
        Board b = new Board("8/8/8/8/8/4k3/4P3/4K3 w - - 0 1");
        Assert.assertEquals(2, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(8, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(44, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(282, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(1814, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(11848, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft76()
    {
        Board b = new Board("4k3/4p3/4K3/8/8/8/8/8 b - - 0 1");
        Assert.assertEquals(2, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(8, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(44, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(282, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(1814, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(11848, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft77()
    {
        Board b = new Board("8/8/7k/7p/7P/7K/8/8 w - - 0 1");
        Assert.assertEquals(3, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(9, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(57, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(360, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(1969, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(10724, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft78()
    {
        Board b = new Board("8/8/k7/p7/P7/K7/8/8 w - - 0 1");
        Assert.assertEquals(3, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(9, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(57, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(360, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(1969, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(10724, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft79()
    {
        Board b = new Board("8/8/3k4/3p4/3P4/3K4/8/8 w - - 0 1");
        Assert.assertEquals(5, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(25, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(180, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(1294, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(8296, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(53138, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft80()
    {
        Board b = new Board("8/3k4/3p4/8/3P4/3K4/8/8 w - - 0 1");
        Assert.assertEquals(8, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(61, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(483, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(3213, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(23599, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(157093, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft81()
    {
        Board b = new Board("8/8/3k4/3p4/8/3P4/3K4/8 w - - 0 1");
        Assert.assertEquals(8, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(61, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(411, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(3213, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(21637, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(158065, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft82()
    {
        Board b = new Board("k7/8/3p4/8/3P4/8/8/7K w - - 0 1");
        Assert.assertEquals(4, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(15, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(90, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(534, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(3450, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(20960, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft83()
    {
        Board b = new Board("8/8/7k/7p/7P/7K/8/8 b - - 0 1");
        Assert.assertEquals(3, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(9, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(57, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(360, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(1969, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(10724, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft84()
    {
        Board b = new Board("8/8/k7/p7/P7/K7/8/8 b - - 0 1");
        Assert.assertEquals(3, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(9, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(57, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(360, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(1969, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(10724, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft85()
    {
        Board b = new Board("8/8/3k4/3p4/3P4/3K4/8/8 b - - 0 1");
        Assert.assertEquals(5, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(25, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(180, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(1294, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(8296, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(53138, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft86()
    {
        Board b = new Board("8/3k4/3p4/8/3P4/3K4/8/8 b - - 0 1");
        Assert.assertEquals(8, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(61, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(411, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(3213, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(21637, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(158065, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft87()
    {
        Board b = new Board("8/8/3k4/3p4/8/3P4/3K4/8 b - - 0 1");
        Assert.assertEquals(8, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(61, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(483, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(3213, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(23599, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(157093, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft88()
    {
        Board b = new Board("k7/8/3p4/8/3P4/8/8/7K b - - 0 1");
        Assert.assertEquals(4, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(15, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(89, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(537, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(3309, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(21104, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft89()
    {
        Board b = new Board("7k/3p4/8/8/3P4/8/8/K7 w - - 0 1");
        Assert.assertEquals(4, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(19, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(117, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(720, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(4661, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(32191, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft90()
    {
        Board b = new Board("7k/8/8/3p4/8/8/3P4/K7 w - - 0 1");
        Assert.assertEquals(5, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(19, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(116, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(716, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(4786, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(30980, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft91()
    {
        Board b = new Board("k7/8/8/7p/6P1/8/8/K7 w - - 0 1");
        Assert.assertEquals(5, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(22, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(139, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(877, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(6112, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(41874, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft92()
    {
        Board b = new Board("k7/8/7p/8/8/6P1/8/K7 w - - 0 1");
        Assert.assertEquals(4, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(16, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(101, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(637, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(4354, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(29679, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft93()
    {
        Board b = new Board("k7/8/8/6p1/7P/8/8/K7 w - - 0 1");
        Assert.assertEquals(5, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(22, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(139, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(877, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(6112, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(41874, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft94()
    {
        Board b = new Board("k7/8/6p1/8/8/7P/8/K7 w - - 0 1");
        Assert.assertEquals(4, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(16, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(101, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(637, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(4354, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(29679, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft95()
    {
        Board b = new Board("k7/8/8/3p4/4p3/8/8/7K w - - 0 1");
        Assert.assertEquals(3, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(15, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(84, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(573, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(3013, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(22886, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft96()
    {
        Board b = new Board("k7/8/3p4/8/8/4P3/8/7K w - - 0 1");
        Assert.assertEquals(4, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(16, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(101, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(637, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(4271, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(28662, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft97()
    {
        Board b = new Board("7k/3p4/8/8/3P4/8/8/K7 b - - 0 1");
        Assert.assertEquals(5, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(19, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(117, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(720, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(5014, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(32167, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft98()
    {
        Board b = new Board("7k/8/8/3p4/8/8/3P4/K7 b - - 0 1");
        Assert.assertEquals(4, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(19, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(117, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(712, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(4658, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(30749, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft99()
    {
        Board b = new Board("k7/8/8/7p/6P1/8/8/K7 b - - 0 1");
        Assert.assertEquals(5, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(22, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(139, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(877, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(6112, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(41874, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft100()
    {
        Board b = new Board("k7/8/7p/8/8/6P1/8/K7 b - - 0 1");
        Assert.assertEquals(4, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(16, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(101, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(637, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(4354, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(29679, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft101()
    {
        Board b = new Board("k7/8/8/6p1/7P/8/8/K7 b - - 0 1");
        Assert.assertEquals(5, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(22, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(139, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(877, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(6112, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(41874, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft102()
    {
        Board b = new Board("k7/8/6p1/8/8/7P/8/K7 b - - 0 1");
        Assert.assertEquals(4, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(16, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(101, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(637, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(4354, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(29679, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft103()
    {
        Board b = new Board("k7/8/8/3p4/4p3/8/8/7K b - - 0 1");
        Assert.assertEquals(5, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(15, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(102, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(569, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(4337, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(22579, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft104()
    {
        Board b = new Board("k7/8/3p4/8/8/4P3/8/7K b - - 0 1");
        Assert.assertEquals(4, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(16, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(101, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(637, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(4271, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(28662, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft105()
    {
        Board b = new Board("7k/8/8/p7/1P6/8/8/7K w - - 0 1");
        Assert.assertEquals(5, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(22, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(139, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(877, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(6112, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(41874, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft106()
    {
        Board b = new Board("7k/8/p7/8/8/1P6/8/7K w - - 0 1");
        Assert.assertEquals(4, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(16, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(101, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(637, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(4354, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(29679, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft107()
    {
        Board b = new Board("7k/8/8/1p6/P7/8/8/7K w - - 0 1");
        Assert.assertEquals(5, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(22, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(139, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(877, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(6112, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(41874, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft108()
    {
        Board b = new Board("7k/8/1p6/8/8/P7/8/7K w - - 0 1");
        Assert.assertEquals(4, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(16, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(101, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(637, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(4354, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(29679, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft109()
    {
        Board b = new Board("k7/7p/8/8/8/8/6P1/K7 w - - 0 1");
        Assert.assertEquals(5, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(25, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(161, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(1035, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(7574, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(55338, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft110()
    {
        Board b = new Board("k7/6p1/8/8/8/8/7P/K7 w - - 0 1");
        Assert.assertEquals(5, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(25, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(161, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(1035, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(7574, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(55338, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft111()
    {
        Board b = new Board("3k4/3pp3/8/8/8/8/3PP3/3K4 w - - 0 1");
        Assert.assertEquals(7, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(49, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(378, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(2902, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(24122, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(199002, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft112()
    {
        Board b = new Board("7k/8/8/p7/1P6/8/8/7K b - - 0 1");
        Assert.assertEquals(5, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(22, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(139, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(877, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(6112, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(41874, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft113()
    {
        Board b = new Board("7k/8/p7/8/8/1P6/8/7K b - - 0 1");
        Assert.assertEquals(4, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(16, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(101, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(637, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(4354, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(29679, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft114()
    {
        Board b = new Board("7k/8/8/1p6/P7/8/8/7K b - - 0 1");
        Assert.assertEquals(5, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(22, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(139, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(877, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(6112, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(41874, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft115()
    {
        Board b = new Board("7k/8/1p6/8/8/P7/8/7K b - - 0 1");
        Assert.assertEquals(4, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(16, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(101, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(637, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(4354, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(29679, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft116()
    {
        Board b = new Board("k7/7p/8/8/8/8/6P1/K7 b - - 0 1");
        Assert.assertEquals(5, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(25, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(161, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(1035, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(7574, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(55338, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft117()
    {
        Board b = new Board("k7/6p1/8/8/8/8/7P/K7 b - - 0 1");
        Assert.assertEquals(5, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(25, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(161, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(1035, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(7574, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(55338, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft118()
    {
        Board b = new Board("3k4/3pp3/8/8/8/8/3PP3/3K4 b - - 0 1");
        Assert.assertEquals(7, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(49, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(378, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(2902, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(24122, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(199002, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft119()
    {
        Board b = new Board("8/Pk6/8/8/8/8/6Kp/8 w - - 0 1");
        Assert.assertEquals(11, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(97, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(887, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(8048, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(90606, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(1030499, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft120()
    {
        Board b = new Board("n1n5/1Pk5/8/8/8/8/5Kp1/5N1N w - - 0 1");
        Assert.assertEquals(24, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(421, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(7421, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(124608, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(2193768, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(37665329, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft121()
    {
        Board b = new Board("8/PPPk4/8/8/8/8/4Kppp/8 w - - 0 1");
        Assert.assertEquals(18, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(270, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(4699, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(79355, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(1533145, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(28859283, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft122()
    {
        Board b = new Board("n1n5/PPPk4/8/8/8/8/4Kppp/5N1N w - - 0 1");
        Assert.assertEquals(24, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(496, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(9483, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(182838, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(3605103, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(71179139, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft123()
    {
        Board b = new Board("8/Pk6/8/8/8/8/6Kp/8 b - - 0 1");
        Assert.assertEquals(11, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(97, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(887, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(8048, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(90606, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(1030499, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft124()
    {
        Board b = new Board("n1n5/1Pk5/8/8/8/8/5Kp1/5N1N b - - 0 1");
        Assert.assertEquals(24, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(421, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(7421, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(124608, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(2193768, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(37665329, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft125()
    {
        Board b = new Board("8/PPPk4/8/8/8/8/4Kppp/8 b - - 0 1");
        Assert.assertEquals(18, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(270, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(4699, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(79355, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(1533145, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(28859283, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft126()
    {
        Board b = new Board("n1n5/PPPk4/8/8/8/8/4Kppp/5N1N b - - 0 1");
        Assert.assertEquals(24, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(496, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(9483, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(182838, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(3605103, new Perft(b.getFEN()).perft(5));
        Assert.assertEquals(71179139, new Perft(b.getFEN()).perft(6));
    }

    @Test
    public void perft127()
    {
        Board b = new Board("r3k2r/p1ppqpb1/bn2pnp1/3PN3/1p2P3/2N2Q1p/PPPBBPPP/R3K2R w KQkq - 0 1 ");
        Assert.assertEquals(48, new Perft(b.getFEN()).perft(1));
        Assert.assertEquals(2039, new Perft(b.getFEN()).perft(2));
        Assert.assertEquals(97862, new Perft(b.getFEN()).perft(3));
        Assert.assertEquals(4085603, new Perft(b.getFEN()).perft(4));
        Assert.assertEquals(193690690, new Perft(b.getFEN()).perft(5));
    }

}
