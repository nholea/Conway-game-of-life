package Conway.game.of.life;

public class Cell {
    private int colPosition;
    private int rowPosition;
    private boolean isAlive;

    public Cell(int colPosition, int rowPosition, boolean isAlive) {
        this.colPosition = colPosition;
        this.rowPosition = rowPosition;
        this.isAlive = isAlive;
    }

    public boolean getState() {
        return isAlive;
    }

    public void makeAlive() {
        isAlive = true;
    }

    public void makeDead() {
        isAlive = false;
    }

    public static void main(String[] args){
        Cell cell = new Cell(1, 4, true);
        System.out.println(cell.getState());

    }
}
