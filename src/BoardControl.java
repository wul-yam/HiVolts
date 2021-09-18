import java.awt.*;
import java.util.HashSet;
import java.util.Random;

public class BoardControl {
    // 0 is empty
    // 1 is fence
    // 2 is mho
    // 3 is player
    private int[][] board;
    private HashSet<Point> randomPositionsFences = new HashSet<>();

    public BoardControl(int height, int width) {
        int[][] board = new int[height][width];
        System.out.println(1);
    }

    public int[][] getBoard() {
        return board;
    }

    public HashSet<Point> getRandomPositionsFences() {
        return randomPositionsFences;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public void setRandomPositionsFences(HashSet<Point> randomPositionsFences) {
        this.randomPositionsFences = randomPositionsFences;
    }

    public int length() {
        return this.getBoard().length;
    }

    public void spawnFences() {
        Random ran = new Random();

        for (int i = 0; i < 20; i++) {
            Point pos = new Point(ran.nextInt(10), ran.nextInt(10));
            if (!randomPositionsFences.contains(pos)) {
                randomPositionsFences.add(pos);
            } else {
                i--;
            }
        }

        for (int y = 0; y < 2; y++) {
            for (int x = 0; x < 10; x++) {
                if (y == 0) {
                    board[y][x] = 1;
                } else {
                    board[this.length() - 1][x] = 1;
                }
            }
        }

        for (int y = 1; y < this.length() - 1; y++) {
            for (int x = 0; x < 2; x++) {
                if (x == 0) {
                    board[y][x] = 1;
                } else {
                    board[y][this.length() - 1] = 1;
                }
            }
        }

        for (Point k : randomPositionsFences) {
            int x = (int) k.getX();
            int y = (int) k.getY();
            board[x][y] = 1;
        }
    }

    public void print() {
        for (int y = 0; y < this.length(); y++) {
            for (int x = 0; x < this.length(); x++) {
                System.out.print(board[y][x]);
            }
            System.out.println();
        }
    }
}
