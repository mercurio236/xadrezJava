package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces; // aqui temos uma matriz de peças

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("Erro ao criar tabuleiro: é necessário que haja pelo menos 1 linha e uma coluna");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column) {
        return pieces[row][column];
    }

    // criando uma sobrecarga para carregar a posição
    public Piece piece(Position position) {

        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
        if (thereIsAPieace(position)) {
            throw new BoardException("Já existe uma peça nessa posição " + position);
        }
        // aqui pega a posição dada a peça e atribuindo a peça o lugar dela
        pieces[position.getRow()][position.getColumn()] = piece;
        // aqui iniciava com null, agora essa peça tem uma posicão
        piece.position = position;
    }

    // metodo auxiliar para testar
    private boolean positionExists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPieace(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Não existe essa posição no tabuleiro");
        }
        return piece(position) != null;
    }

}
