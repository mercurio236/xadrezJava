package chess;

import boardgame.Board;

public class ChessMatch {
    private Board board;

    // quem tem definir o tamanho do tabuleiro de xadrez é essa classe
    public ChessMatch() {
        board = new Board(8, 8);
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
}
