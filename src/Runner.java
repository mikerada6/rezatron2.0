import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        String fen = "k7/2R3R1/8/8/3K4/8/8/8 w - - 0 1 ";
        Board b = new Board(fen);
        ArrayList<Integer> moves = b.generateMovesNeo(true);
        for (int move : moves)
        {
            System.out.print(b.translate(move) +"\t-");
            b.move(move);
            System.out.println(b.generateMovesNeo(true).size());
            b.undo();
        }
        int error =0/0;
        Engine e= new Engine();
        e.start();
        System.out.print("HELLO");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        e.setCont(false);

        System.out.println("MAIN");
    }
}
