import java.util.ArrayList;

public class AlphaBeta {

    Board b;

    public AlphaBeta(Board b) {
        this.b = b;
    }

    public int search(int depth)
    {
        if(this.b.isWhitesTurn())
        {
            return alphaBetaMax(Integer.MIN_VALUE,Integer.MAX_VALUE,depth);
        }
        else
        {
            return alphaBetaMin(Integer.MIN_VALUE,Integer.MAX_VALUE,depth);
        }
    }

    public int alphaBetaMax(int alpha, int beta, int depthLeft) {
        if (depthLeft == 0)
            return b.evaluateBoard();
        ArrayList<Integer> moves = b.generateMovesNeo(true);
        for (int move : moves) {
            b.move(move);
            int score = alphaBetaMin(alpha, beta, depthLeft - 1);
            System.out.println(b.translate(move) +"\t" + score);
            if (score >= beta) {
                return beta;
            }
            if (score > alpha) {
                alpha = score;
            }
            b.undo();
        }
        return alpha;
    }

    public int alphaBetaMin(int alpha, int beta, int depthLeft) {
        if (depthLeft == 0) return b.evaluateBoard();
        ArrayList<Integer> moves = b.generateMovesNeo(true);
        for (int move : moves) {
            b.move(move);
            int score = alphaBetaMax(alpha, beta, depthLeft - 1);
            if (score <= alpha) {
                return alpha; // fail hard alpha-cutoff
            }
            if (score < beta) {
                beta = score; // beta acts like min in MiniMax
            }
            b.undo();
        }
        return beta;
    }
}
