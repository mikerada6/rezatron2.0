import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        int[] int_list = {1, 2, 3, 4, 5, 6};
        int varA = 0;
        for(int i=0;i<int_list.length;i++)
        {
            int iter = int_list[i];
            varA += iter;
        }
        System.out.println(varA);
        System.out.println(varA/int_list.length);

        int error =0/0;
        String fen = "k7/P1b5/KP6/8/8/8/8/8 w - - 0 1 ";
        Board b=new Board(fen);
        System.out.println(b.getFEN());
        System.out.println(b);
        ArrayList<Integer> moves = b.generateMovesNeo(true);
        for(int move: moves)
        {
            b.move(move);
            System.out.println(b.translate(move));
            System.out.println("\t"+ b.getFEN() +"\t" + b.evaluateBoard());
            b.undo();
        }
    }
}
