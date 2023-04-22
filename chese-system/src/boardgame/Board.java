package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces; // aqui temos uma matriz de peças

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public Piece piece(int row, int column) {
        return pieces[row][column];
    }

    // criando uma sobrecarga para carregar a posição
    public Piece piece(Position position) {
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
        // aqui pega a posição dada a peça e atribuindo a peça o lugar dela
        pieces[position.getRow()][position.getColumn()] = piece;
        // aqui iniciava com null, agora essa peça tem uma posicão
        piece.position = position;
    }

}
