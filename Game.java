package tictactoe;

public class Game {
	public static void main(String[] args) {
		Game game = new Game();
		game.play();
	}
	private static int used_cells = 0;
	private static boolean comp_is_winning = false, user_is_winning = false;

	Board board = new Board();
	View view = new View();

	private String[][] positions = board.get_board();
	private int row, col;
	private boolean user_marked_cell = false, comp_marked_cell = false;

	public void play() {
		// Print Initial Empty Board
		System.out.println("--Initial Empty Board--");
		System.out.println("You: X	Computer: O");
		view.print_board(positions);
		System.out.print("\n");

		while (true) {

			// Mark requested position by user
			// Loop is used to validate selected position is applicable
			user_marked_cell = false;
			while (!user_marked_cell) {
				// Receive User Input
				row = view.get_row();
				col = view.get_col();
				user_marked_cell = board.set_value(row, col, "X");
			}

			// Print Board After User Insertion
			System.out.println(">>User Turn:");
			view.print_board(positions);

			// Increment Number Of Used Cells
			used_cells++;

			// Check If User Has Won
			user_is_winning = board.is_Winning("X");
			if (user_is_winning)
				break;

			// Check if board has been fully used
			if (used_cells == 9)
				break;

			// Mark requested position by computer
			// Loop is used to validate selected position is applicable
			comp_marked_cell = false;
			while (!comp_marked_cell) {
				// Handle Computer Input
				comp_marked_cell = board.computer_plays();
			}

			// Print Board After Computer Insertion
			System.out.println(">>Computer Turn:");
			view.print_board(positions);
			System.out.print("\n");

			// Increment Number Of Used Cells
			used_cells++;

			// Check If User Has Won
			comp_is_winning = board.is_Winning("O");
			if (comp_is_winning)
				break;
		}

		// Check Final Board State
		if (comp_is_winning == true) {
			System.out.println("Computer Has Won!");
		} else if (user_is_winning) {
			System.out.println("\nUser Has Won!");
		} else if (used_cells == 9) {
			System.out.println("\nIt is a draw!");
		}
	}
}
