import java.util.ArrayList;

public class MinMax {
    static String best="";

    public static int minMax(int depth, Board game, boolean isMaximisingPlayer, int max, String moveString)
    {
        ArrayList<Integer> newGameMoves = game.generateMovesNeo(true);
        if(depth==0 || newGameMoves.size()==0) {
            //System.out.println(moveString +"\t" + (-1*game.evaluateBoard()));
            return 1*game.evaluateBoard();
        }

        if(isMaximisingPlayer) {
            int bestMove = Integer.MIN_VALUE;
            for(int move: newGameMoves) {
                game.move(move);
                int oldBest=bestMove;
                bestMove = Math.max(bestMove,MinMax.minMax(depth-1,game,!isMaximisingPlayer, max, moveString+"\t"+game.translate(move)));
                if(oldBest!=bestMove && depth==max)
                {
                    best = moveString+"\t"+game.translate(move) + "\t|"+ (-1*game.evaluateBoard());
                }
                game.undo();
            }
            return bestMove;
        }
        else {
            int bestMove = Integer.MAX_VALUE;
            for(int move: newGameMoves) {
                game.move(move);
                int oldBest=bestMove;
                bestMove = Math.min(bestMove,MinMax.minMax(depth-1,game,!isMaximisingPlayer, max, moveString+"\t"+game.translate(move)));
                if(oldBest!=bestMove && depth==max)
                {
                    best = moveString+"\t"+game.translate(move) + "\t|"+ (-1*game.evaluateBoard());
                }
                game.undo();
            }
            return bestMove;
        }
    }
}
