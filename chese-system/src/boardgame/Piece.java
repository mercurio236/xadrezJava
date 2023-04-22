package boardgame;

public abstract class Piece {
    // aqui está usando o protected porque eu não quero que apareça no Board
    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
        position = null; // posição de uma peça recem criada
    }

    // esta como protected porque eu quero que somente as classes dentro do mesmo
    // pacote podem ter acesso e subclasses
    protected Board getBoard() {
        return board;
    }

    public abstract boolean[][] possibleMoves();

    // Rook methods
    public boolean possibleMove(Position position) {
        return possibleMoves()[position.getRow()][position.getColumn()];
    }

    public boolean isThereAnyPossibleMove() {
        boolean[][] mat = possibleMoves();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // o set não foi adicionando, pois o tabuleiro não pode ser altrado, por esse
    // motivo temos apenas o get

}
