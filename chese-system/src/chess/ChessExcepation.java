package chess;

public class ChessExcepation extends RuntimeException {
    public static final long serialVersionUID = 1L;

    public ChessExcepation(String msg) {
        super(msg);
    }
}
