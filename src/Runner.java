public class Runner {
    public static void main(String[] args) {
//        Zobrist.zobristFillArray();
//        Board b = new Board();
//        HashMap<Long, Long> perftHash = new HashMap<Long, Long>();
//        long key = b.zobristKey();
//        perftHash.put(key,50L);
//        System.out.println(perftHash.get(key));
        Board b = new Board("8/2k2p2/2b3p1/P1p1Np2/1p3b2/1P1K4/5r2/R3R3 b - - 0 1");
        String next = "6k1/5p2/1p5p/p4Np1/5q2/Q6P/PPr5/3R3K w - - 1 0";
        next = "k7/2R5/8/8/8/8/8/6RK w - - 1 0";
        next = "K7/2r5/8/8/8/8/8/6rk b - - 1 0";
        b=new Board(next);
        System.out.println(b);
        AlphaBeta ab = new AlphaBeta(b);
        System.out.println(ab.search(1));
        System.out.println(ab.search(2));
        System.out.println(ab.search(3));
        System.out.println(ab.search(4));
        System.out.println(ab.search(5));
    }
}
