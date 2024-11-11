package boardgame;

public class Board {
	private int rows;
	private int colums;
	private Piece[][] pieces;

	public Board(int rows, int colums) {
		if (rows < 1 || colums < 1) {
			throw new BoardException("Erro creating board: there must be at last 1 row and 1 column");
		}

		this.rows = rows;
		this.colums = colums;
		pieces = new Piece[rows][colums];
	}

	public int getRows() {
		return rows;
	}

	public int getColums() {
		return colums;
	}

	public void setColums(int colums) {
		this.colums = colums;
	}

	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}

	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColum()];
	}

	public void placePiece(Piece piece, Position position) {
		if (thereIsAPice(position)) {
			throw new BoardException("There is a piece on position: " + position);
		}
		pieces[position.getRow()][position.getColum()] = piece;
		piece.position = position;
	}

	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < colums;
	}

	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColum());
	}

	public boolean thereIsAPice(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;
	}
}