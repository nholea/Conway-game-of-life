package Conway.game.of.life;

public class Grid {
    private int rows;
    private int cols;
    private String[][] grid;

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new String[rows][cols];
    }

    public void buildGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = ".";
                System.out.print(grid[i][j] + "\s");
            }
            System.out.println();
        }
    }


    public static void main(String[] args){
        Grid grid = new Grid(4,4);
        grid.buildGrid();

    }
}
