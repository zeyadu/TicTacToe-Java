package tictactoe;
import java.util.Random;

public class Board {
	Random rand = new Random();
	String[][] positions = new String[3][3];

	// Constructor to initialize board with dots.
	public Board() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				positions[i][j] = ".";
			}
		}
	}

	// Validate position is within bounds
	private boolean position_isValid(int row, int col) {
		if (row < 0 || row > 2 || col < 0 || col > 2) {
			return false;
		}
		return true;
	}

	// Validate that selected cell is empty
	private boolean is_Empty(int row, int col) {
		if (positions[row][col] != ".") {
			return false;
		}
		return true;
	}

	// If Validation Checks Are Passed Then Assign Selected Position With
	// Corresponding Value
	public boolean set_value(int row, int col, String Value) {
		if (!position_isValid(row, col)) {
			System.out.println("Selected Position is out of bounds!\n");
			return false;
		} else if (!is_Empty(row, col)) {
			if (Value == "X") {
				System.out.println("Please select an empty cell!\n");
			}
			return false;
		} else {
			positions[row][col] = Value;
			return true;
		}
	}

	// Getter function
	public String[][] get_board() {
		return positions;
	}

	// Function to check if winning condition exists
	public boolean is_Winning(String val) {
		// Horizontals
		if ((positions[0][0].equals(val) && positions[0][1].equals(val) && positions[0][2].equals(val))
				|| (positions[1][0].equals(val) && positions[1][1].equals(val) && positions[1][2].equals(val))
				|| (positions[2][0].equals(val) && positions[2][1].equals(val) && positions[2][2].equals(val))) {
			return true;
		}
		// Verticals
		if ((positions[0][0].equals(val) && positions[1][0].equals(val) && positions[2][0].equals(val))
				|| (positions[0][1].equals(val) && positions[1][1].equals(val) && positions[2][1].equals(val))
				|| (positions[0][2].equals(val) && positions[1][2].equals(val) && positions[2][2].equals(val))) {
			return true;
		}
		// Diagonals
		if ((positions[0][0].equals(val) && positions[1][1].equals(val) && positions[2][2].equals(val))
				|| (positions[0][2].equals(val) && positions[1][1].equals(val) && positions[2][0].equals(val))) {
			return true;
		}
		return false;
	}

	// Function to automate computer selection of position on the board
	public boolean computer_plays() {
		int row = 0;
		int col = 0;

		int value = rand.nextInt(9) + 1;
		switch (value) {
		case 1:
			row = 0;
			col = 0;
			break;
		case 2:
			row = 0;
			col = 1;
			break;
		case 3:
			row = 0;
			col = 2;
			break;
		case 4:
			row = 1;
			col = 0;
			break;
		case 5:
			row = 1;
			col = 1;
			break;
		case 6:
			row = 1;
			col = 2;
			break;
		case 7:
			row = 2;
			col = 0;
			break;
		case 8:
			row = 2;
			col = 1;
			break;
		case 9:
			row = 2;
			col = 2;
			break;
		}

		boolean position_validity = set_value(row, col, "O");
		return position_validity;
	}
}
