package tictactoe;
import java.util.Scanner;

public class View {
	// Function to receive row value
	public int get_row() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a row value between 0 and 2 (inclusive): ");
		int ROW = in.nextInt();
		return ROW;
	}

	// Function to receive column value
	public int get_col() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a column value between 0 and 2 (inclusive): ");
		int COL = in.nextInt();
		System.out.println();
		return COL;
	}

	// Function to print board
	public void print_board(String positions[][]) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(positions[i][j] + " ");
			}
			System.out.println();
		}
	}
}
