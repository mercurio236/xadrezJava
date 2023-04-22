package chess;

import boardgame.BoardException;

public class ChessExcepation extends BoardException {
    public static final long serialVersionUID = 1L;

    public ChessExcepation(String msg) {
        super(msg);
    }
}
