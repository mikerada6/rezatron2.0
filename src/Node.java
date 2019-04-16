public class Node {
    private int alpha;
    private int beta;
    private int score;
    private int depthLeft;

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }

    public int getBeta() {
        return beta;
    }

    public void setBeta(int beta) {
        this.beta = beta;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getDepthLeft() {
        return depthLeft;
    }

    public void setDepthLeft(int depthLeft) {
        this.depthLeft = depthLeft;
    }

    public Node(int alpha, int beta, int score, int depthLeft)
    {
        this.alpha=alpha;
        this.beta=beta;
        this.score=score;
        this.depthLeft=depthLeft;
    }
}
