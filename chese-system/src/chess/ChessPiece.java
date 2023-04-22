package chess;

import boardgame.Board;
import boardgame.Piece;

public class ChessPiece extends Piece {

    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    // para que a cor da peça não seja modificada foi adicinado apenas o get
    public Color getColor() {
        return color;
    }

}
