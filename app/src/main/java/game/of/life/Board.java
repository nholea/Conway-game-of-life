package game.of.life;

import java.util.Scanner;

public class Board {
    private final int rows;
    private final int cols;

    private int[][] board;

    public final Scanner input = new Scanner(System.in);

    public Board() {
        System.out.println("Introduce row numbers: ");
        this.rows = input.nextInt();
        System.out.println("Introduce col numbers: ");
        this.cols = input.nextInt();
        this.board = new int[rows][cols];
    }

    public int[][] createBoard() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                board[row][col] = new Cell().getState();
            }
        }
        return board;
    }

    public void printBoard(int[][] inputBoard) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (inputBoard[row][col] == 0) {
                    System.out.print("\s.\s");
                } else {
                    System.out.print("\s*\s");

                }

            }
            System.out.println();
        }
    }

    public int getCellStatus(int x, int y) {
        if (x < 0 || x >= rows) {
            return 0;
        }
        if (y < 0 || y >= cols) {
            return 0;
        }
        return board[x][y];
    }

    public int aliveNeighboursCounter(int x, int y) {
        int aliveNeighboursCounter = 0;

        aliveNeighboursCounter += getCellStatus(x + 1, y - 1);
        aliveNeighboursCounter += getCellStatus(x + 1, y);
        aliveNeighboursCounter += getCellStatus(x + 1, y + 1);
        aliveNeighboursCounter += getCellStatus(x, y + 1);
        aliveNeighboursCounter += getCellStatus(x, y - 1);
        aliveNeighboursCounter += getCellStatus(x - 1, y + 1);
        aliveNeighboursCounter += getCellStatus(x - 1, y);
        aliveNeighboursCounter += getCellStatus(x - 1, y - 1);
        return aliveNeighboursCounter;
    }

    public void nextGeneration() {
        int[][] nextGeneration = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int aliveNeighbours = aliveNeighboursCounter(row, col);

                if (getCellStatus(row, col) == 1) {
                    if (aliveNeighbours < 2) {
                        nextGeneration[row][col] = 0;
                    } else if (aliveNeighbours > 3) {
                        nextGeneration[row][col] = 0;
                    } else if (aliveNeighbours == 2 || aliveNeighbours == 3) {
                        nextGeneration[row][col] = 1;
                    }
                } else {
                    if (aliveNeighbours == 3) {
                        nextGeneration[row][col] = 1;
                    }
                }
            }
        }
        board = nextGeneration;
    }

    public int[][] getBoard() {
        return board;
    }
}
