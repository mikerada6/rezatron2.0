import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Runner {
    public static void main(String[] args) {
//        Zobrist.zobristFillArray();
//        Board b = new Board();
//        HashMap<Long, Long> perftHash = new HashMap<Long, Long>();
//        long key = b.zobristKey();
//        perftHash.put(key,50L);
//        System.out.println(perftHash.get(key));
        Board b=new Board("R6R/1r3pp1/4p1kp/3pP3/1r2qPP1/7P/1P1Q3K/8 w - - 1 0");
        b=new Board("1k6/4R3/8/8/8/8/7R/7K w - - 1 0");
        b=new Board("1nbqkbnr/2pppppp/8/rp6/3PP3/1PPB1N2/P4PPP/RNB1K2R w KQk - 0 4");
        System.out.println(b);
        for(int i=0;i<100;i++) {
            if (i % 2 == 0) {
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(System.in));
                boolean cont=true;
                while(cont) {
                    try {
                        String move = reader.readLine();
                        b.move(move);
                        cont=false;
                    }catch(Exception e)
                    {
                        cont=true;
                        System.out.println("Error: " + e);
                    }
                }
            } else {
                int move = AlphaBeta.alphaBetaRoot(b, 3);
                System.out.println("MOVE: " + b.translate(move));
                b.move(move);
            }
            System.out.println(b);
            System.out.println(b.getFEN());
        }
    }
}
