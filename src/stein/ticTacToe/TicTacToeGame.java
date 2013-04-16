package stein.ticTacToe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class TicTacToeGame {
	private Stack<BoardGame> boardStack;
	private HashMap<ArrayList<Move>, BoardGame> uniqueEndingBoards;
	private HashMap<ArrayList<Move>, BoardGame> uniqueBoardStates;
	private Move player;

	public TicTacToeGame() {
		boardStack = new Stack<BoardGame>();
		uniqueEndingBoards = new HashMap<ArrayList<Move>, BoardGame>();
		uniqueBoardStates = new HashMap<ArrayList<Move>, BoardGame>();
		player = Move.X;

	}

	private void pushNextBoards(BoardGame b) {
		changePlayer();
		int[][] possibleMoves = b.getPossibleMoves();
		for (int i = 0; i < possibleMoves.length; i++) {
			BoardGame newBoard = new BoardGame(b);
			newBoard.mark(player, possibleMoves[i][0], possibleMoves[i][1]);
			boardStack.push(newBoard);
		}
	}

	public void playGame() {
		boardStack.push(new BoardGame());
		while (!boardStack.isEmpty()) {
			BoardGame topBoard = boardStack.pop();
			if (!uniqueBoardStates.containsKey(topBoard.getBoardArrayList())) {
				uniqueBoardStates.put(topBoard.getBoardArrayList(), topBoard);
			}
			if (!topBoard.gameOver()) {
				pushNextBoards(topBoard);
			} else {
				if (!uniqueEndingBoards.containsKey(topBoard.getBoardArrayList())) {
					uniqueEndingBoards.put(topBoard.getBoardArrayList(), topBoard);
				}
				if (topBoard.gameWon()) {
					System.out.println(topBoard.getWinner()
							+ " IS THE WINNER!!\n");
				} else {
					System.out.println("Game Over, No Winner.\n");
				}
				topBoard.displayBoard();
				System.out.print("\n");
			}
		}
		System.out.println("Number of unique ending boards: " + uniqueEndingBoards.size());
		System.out.println("Number of unique board states: "+uniqueBoardStates.size());
	}

	private void changePlayer() {
		switch (player) {
		case X:
			player = Move.O;
			break;
		case O:
			player = Move.X;
			break;
		default:
			break;

		}
	}

	public static void main(String[] args) {
		TicTacToeGame ticTacToe = new TicTacToeGame();
		ticTacToe.playGame();
	}
}
