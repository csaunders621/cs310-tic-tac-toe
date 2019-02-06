package edu.jsu.mcis;

public class TicTacToeModel {
    
    private Mark[][] board; /* Game board */
    private boolean xTurn;  /* True if X is current player */
    private int width;      /* Size of game board */
    
    /* ENUM TYPE DEFINITIONS */
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a TIE,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("TIE"), 
        NONE("NONE");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        this(TicTacToe.DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create board (width x width) as a 2D Mark array */
        
        board = new Mark[width][width];

        /* Initialize board by filling every square with empty marks */
        
        // INSERT YOUR CODE HERE
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < width; ++j) {
                board[i][j] = Mark.EMPTY;
            }
        }
        
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Use "isValidSquare()" to check if the specified location is in range,
           and use "isSquareMarked()" to see if the square is empty!  If the
           specified location is valid, make a mark for the current player, then
           toggle "xTurn" from true to false (or vice-versa) to switch to the
           other player before returning TRUE.  Otherwise, return FALSE. */
        
        // INSERT YOUR CODE HERE
        if (isValidSquare(row, col)) {
            if (isSquareMarked(row, col)) {
                return false;
            }
            else {
                if (xTurn) {
                    board[row][col] = Mark.X;
                    xTurn = false;
                    return true;
                }
                else {
                    board[row][col] = Mark.O;
                    xTurn = true;
                    return true;
                }
            }
        }
        else{return false;}     
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return TRUE if the specified location is within the bounds of the board */
        
        // INSERT YOUR CODE HERE
        if (row < width && col < width) {
            return true;
        }
        else {
            return false;
        }
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return TRUE if the square at specified location is marked */
        
        // INSERT YOUR CODE HERE
        if (board[row][col] == Mark.EMPTY) {
            return false;
        }
        else {
            return true;
        }            
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return the mark from the square at the specified location */
        
        // INSERT YOUR CODE HERE

        return board[row][col]; 
            
    }
	
    public Result getResult() {
        
        /* Call "isMarkWin()" to see if X or O is the winner, if the game is a
           TIE, or if the game is not over.  Return the corresponding Result
           value */
        
        // INSERT YOUR CODE HERE
        if (xTurn) {
            if (isMarkWin(Mark.X)) {
                return Result.X;
            }
            else if (isTie()) {
                return Result.TIE;
            }
            else {
                return Result.NONE;
            }
        }
        else {
            if (isMarkWin(Mark.O)) {
                return Result.O;
            }
            else if (isTie()) {
                return Result.TIE;
            }
            else {
                return Result.NONE;
            }
        }        
    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        // INSERT YOUR CODE HERE
        int Hcount = 0;
        int Vcount = 0;

        if (mark == Mark.X) {     
            for (int j = 0; j < width; ++j) {
                for (int i = 0; i < width; ++i) {
                    if (board[j][i] == mark) {
                        ++Hcount;
                    }
                    else if (board[i][j] == mark) {
                        ++Vcount;
                    }
                }
            }
        }

        else if (mark == Mark.O) {
            for (int j = 0; j < width; ++j) {
                for (int i=0; i < width; ++i) {
                    if (board[j][i] == mark) {
                        ++Hcount;
                    }
                    else if (board[i][j] == mark) {
                        ++Vcount;
                    }
                }
            }
        }

        else {
            return false;
        }  

        if (Hcount == width || Vcount == width) {
            return true;
        }
        else {
            return false;
        } 
    }
	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */
        
        // INSERT YOUR CODE HERE

        int Hcount = 0;
        int Vcount = 0;

            for (int j = 0; j < width; ++j) {
                for (int i = 0; i < width; ++i) {
                    if (board[j][i] != Mark.EMPTY) {
                        ++Hcount;
                    }
                    else if (board[i][j] != Mark.EMPTY) {
                        ++Vcount;
                    }
                    else if (board[i][j] == Mark.EMPTY) {
                        return false;
                    }
                }
            }

        if (Hcount == width || Vcount == width) {
            return false;
        }
        else {
            return true;
        }
       
    }

    public boolean isGameover() {
        
        /* Return TRUE if the game is over */
        
        return (Result.NONE != getResult());
        
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth() {
        
        /* Getter for width */
        
        return width;
        
    }
    
    @Override
    public String toString() {
        
        StringBuilder output = new StringBuilder("  ");
        
        /* Output the board contents as a string (see examples) */
        
        // INSERT YOUR CODE HERE
        for (int i = 0; i < width; ++i) {
            output.append(i);
        }

        output.append("\n");

        for (int i = 0; i < width; ++i) {
            for(int k = 0; k < width; ++k) {
                if (k == 0) {
                    output.append(i).append(" ").append(board[i][k]);
                }
                else if (k > 0) {
                    output.append(board[i][k]);
                }
                if (k == width - 1) {
                    output.append("\n");
                }
            }
        }
        
        return output.toString();
        
    }
    
}
