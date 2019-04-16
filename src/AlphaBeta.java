import java.util.ArrayList;
import java.util.HashMap;

public class AlphaBeta {

    static String best;
    private Board b;
    private HashMap<Long, Long> perftHash = new HashMap<Long, Long>();


    public AlphaBeta(Board b) {
        this.b = b;
        best = "";
    }

    public static int alphaBetaRoot(Board b, int depth)
    {
        int best=0;
        int alpha = Integer.MIN_VALUE + 1000;
        int beta = Integer.MAX_VALUE-1000;
        ArrayList<Integer> moves = b.generateMovesNeo(true);
        for(int move: moves)
        {
            b.move(move);
            int value = -alphaBeta(b,depth,-1*beta,-1*alpha);
            b.undo();
//            System.out.println(b.translate(move)+"\t:" + value);
                    if(value>alpha)
                    {
                        alpha=value;
                        best=move;
                        System.out.println("BEST MOVE: " + b.translate(best));
                    }
        }
        return best;
    }

    private static int alphaBeta(Board b, int depth, int alpha, int beta)
    {

        if (depth==0)
        {
            return b.sideToMoveScore();
        }
        ArrayList<Integer> moves = b.generateMovesNeo(true);
        int moveCount= moves.size();
        boolean isWhiteChecked=b.isWhiteChecked();
        boolean isBlackChecked=b.isBlackChecked();
        if (isWhiteChecked || isBlackChecked || moveCount == 0)
        {
            if (moveCount==0)
            {
                if (isBlackChecked)
                {
                    if (!b.isWhitesTurn() ) {
                        return -32767 - depth;
                    }
                    return 32767 + depth;
                }
                if (isWhiteChecked)
                {
                    if (!b.isWhitesTurn()) {
                        return 32767 + depth;
                    }
                    return -32767 - depth;
                }

                //If Not Mate then StaleMate
                return 0;
            }
        }

        //TODO sort moves

        for(int move: moves)
        {
            b.move(move);
            int value = -1* alphaBeta(b,depth-1,-beta,-alpha);
//            System.out.println("\t"+b.translate(move)+"\t:" + value);
            b.undo();
            if(value >= beta)
            {
                return beta;
            }
            if(value > alpha)
            {
                alpha = value;
            }
        }
        return alpha;
    }
}
