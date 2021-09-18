public class Main {
    public static void main(String[] args) {
        BoardControl.init(12, 12);
        BoardControl.spawnFences();
        BoardControl.spawnMhos();
        BoardControl.spawnPlayer();
        BoardControl.print();
        System.out.println();
        BoardControl.updatePlayerPosition('d');
        BoardControl.print();
    }
}
