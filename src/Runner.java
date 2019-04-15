public class Runner {
    public static void main(String[] args) {
//        Zobrist.zobristFillArray();
//        Board b = new Board();
//        HashMap<Long, Long> perftHash = new HashMap<Long, Long>();
//        long key = b.zobristKey();
//        perftHash.put(key,50L);
//        System.out.println(perftHash.get(key));
        Board b = new Board("rnbqkbnr/p1ppppp1/8/Pp5p/8/8/1PPPPPPP/RNBQKBNR w KQkq b6 0 3");
        System.out.println(b.zobristKey());
    }
}
