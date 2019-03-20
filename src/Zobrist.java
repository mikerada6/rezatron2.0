import java.security.SecureRandom;

public class Zobrist {
    static long[][][] zArray = new long[2][6][64];
    static long[] zEnPassant = new long[8];
    static long[] zCastle = new long[4];
    static long zBlackMove;

    public static long random64() {
        SecureRandom random = new SecureRandom();
        //a random seed is used for testing and debugging purposes.
        random.setSeed(5920155765L);
        return random.nextLong();
    }

    public static void testDistribution() {
        int sampleSize = 2000;
        int sampleSeconds = 10;
        long startTime = System.currentTimeMillis();
        long endTime = startTime + (sampleSeconds * 1000);
        int[] distArray = new int[sampleSize];
        while (System.currentTimeMillis() < endTime) {
            for (int i = 0; i < 10000; i++) {
                distArray[(int) (random64() % (sampleSize / 2)) + (sampleSize / 2)]++;
            }
        }
        for (int i = 0; i < sampleSize; i++) {
            System.out.println(distArray[i]);
        }
    }

    public static void zobristFillArray() {
        for (int piece = 0; piece < 6; piece++) {
            for (int square = 0; square < 64; square++) {
                for (int color = 0; color < 2; color++) {
                    zArray[color][piece][square] = random64();
                }
            }
        }

        for (int column = 0; column < 8; column++) {
            zEnPassant[column] = random64();
        }

        for (int i = 0; i < 4; i++) {
            zCastle[i] = random64();
        }

        zBlackMove = random64();
    }

}
