public class jogoGalo implements JGaloInterface {
    // First, we define three variables: X, O, and EMPTY, to represent possible moves of the board.
    private char X = 'X';
    private char O = 'O';
    private char winner = ' ';

    char[][] game = new char[3][3];
    boolean isPlayerX = true;

    @Override
    public char getActualPlayer() {
        isPlayerX = !isPlayerX;
        return isPlayerX ? X:O;
    }

    @Override
    public boolean setJogada(int lin, int col) {
        lin--; col--;
        
        char symbolToAdd;

        // Symbol to Add to the board depends on the player
        if(isPlayerX) {
            symbolToAdd = X;
        } else {
            symbolToAdd = O;
        }

        if(game[lin][col] == '\0') {
            game[lin][col] = symbolToAdd;
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean isFinished() {
        if(existsWinner(game)) {
            return true; // Exists a winner -> Game is Over
        }

        // If doesn't exist winner but exists cells "\0" -> Game is not yet over
        for(int row=0; row<3;row++) {
            for(int column=0; column<3;column++) {
                if (game[row][column] == '\0') return false;
            }    
        }    
        return true;
    }

    private boolean existsWinner(char[][] game2) {
        
        // Iterate through rows 
        for(int i=0; i<3;i++) {
            // Check Rows
            if ( game[i][0] != '\0' && game[i][0] == game[i][1] && game[i][1] == game[i][2] ) {
                winner = game[i][0];
                return true;
            }
            // Check Columns
            if ( game[0][i] != '\0' && game[0][i] == game[1][i] && game[1][i] == game[2][i] ) {
                winner = game[0][i];
                return true;
            }
        }

        // Check diagonals
        if ( game[0][0] != '\0' && game[0][0] == game[1][1] && game[0][0] == game[2][2] ) {
            winner = game[0][0];
            return true;
        }  
        if ( game[2][0] != '\0' && game[2][0] == game[1][1] && game[2][0] == game[0][2] ) {
            winner = game[2][0];
            return true;
        }

        return false;
    }

    @Override
    public char checkResult() {
       return winner;
    }


}
