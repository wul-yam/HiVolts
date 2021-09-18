public class Main {
    public static void main(String[] args) {
        BoardControl board = new BoardControl(12, 12);
        board.spawnFences();
        board.print();
    }
}
