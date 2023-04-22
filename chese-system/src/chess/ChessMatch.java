package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
    private Board board;

    // quem tem definir o tamanho do tabuleiro de xadrez é essa classe
    public ChessMatch() {
        board = new Board(8, 8);
        initialSetup();
    }

    // esse metodo vai ter que retornar uma matriz de peças de xadrez, correspodente
    // a essa partida
    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);// foi feito um Downcast para que ele saiba que uma peça
            }
        }
        return mat;
    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validadeSourcePosition(source);
        validadeTargetPosition(source, target);
        Piece capturePiece = makeMove(source, target);
        return (ChessPiece) capturePiece;
    }

    public Piece makeMove(Position source, Position target) {
        Piece p = board.removePiece(source);
        Piece capturePiece = board.removePiece(target);
        board.placePiece(p, target);
        return capturePiece;
    }

    private void validadeSourcePosition(Position position) {
        if (!board.thereIsAPieace(position)) {
            throw new ChessExcepation("Não existe peça na posição de origem.");
        }
        if (!board.piece(position).isThereAnyPossibleMove()) {
            throw new ChessExcepation("Não existe movimentos possiveis para essas peça");
        }
    }

    private void validadeTargetPosition(Position source, Position target) {
        if (!board.piece(source).possibleMove(target)) {
            throw new ChessExcepation("A peça escolhida não pode se mover para a posição de destino.");
        }
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    public void initialSetup() {
        placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
    }
}
