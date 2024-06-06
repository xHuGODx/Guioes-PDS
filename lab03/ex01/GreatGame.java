package lab03.JogoDoGalo;

public class GreatGame implements JGaloInterface{
    private char actualPlayer;
    private char[][] gameplay = new char[3][3];

    GreatGame(){
        this.actualPlayer = 'X';
    }
    GreatGame(char aP){
        this.actualPlayer = aP;
    }

    public char getActualPlayer(){
        return this.actualPlayer;
    }
    public void setActualPlayer(char aP){
        this.actualPlayer = aP;
    }
    public boolean setJogada(int lin, int col){
        if (gameplay[lin - 1][col - 1] == '\0'){
            gameplay[lin - 1][col - 1] = getActualPlayer();
            if (getActualPlayer() == 'X')
                setActualPlayer('O');
            else    
                setActualPlayer('X');
            return true;
        }
        return false;
    }
    public boolean isFinished(){
        if (didSomebodyWonInALineOrColumn(gameplay) || didSomebodyWonInADiagonal(gameplay) || isBoardFull(gameplay)) 
            return true;
        return false;
    }
    public char checkResult(){
        if (didSomebodyWonInADiagonal(gameplay))
            return gameplay[1][1];
        for (int i = 0; i < 3; i++){
            if (gameplay[i][0] != '\0'&& (gameplay[i][0] == gameplay[i][1] && gameplay[i][0] == gameplay[i][2])){
                return gameplay[i][0];
            }
            if (gameplay[0][i] != '\0'&& (gameplay[0][i] == gameplay[1][i] && gameplay[0][i] == gameplay[2][i])){
                return gameplay[0][i];
            }
        }
        // Just in case something goes wrong
        return ' ';
    }

    public static boolean didSomebodyWonInALineOrColumn(char[][] gameplay){
        for (int i = 0; i < 3; i++){
            if (gameplay[i][0] != '\0'&& (gameplay[i][0] == gameplay[i][1] && gameplay[i][0] == gameplay[i][2])){
                return true;
            }
            if (gameplay[0][i] != '\0'&& (gameplay[0][i] == gameplay[1][i] && gameplay[0][i] == gameplay[2][i])){
                return true;
            }
        }
        return false;
    }
    public static boolean didSomebodyWonInADiagonal(char[][] gameplay){
        // Se o botão do meio está vazio, podemos garantir que ninguém ganhou numa diagonal.
        if (gameplay[1][1] == '\0')
            return false;

        if (gameplay[0][0] == gameplay[1][1] && gameplay[0][0] == gameplay[2][2]){
            return true;
        }
        if (gameplay[0][2] == gameplay[1][1] && gameplay[0][2] == gameplay[2][0]){
            return true;
        }
        return false;
    }
    public static boolean isBoardFull(char[][] gameplay){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (gameplay[i][j] == '\0'){
                    return false;
                }
            }
        }
        return true;
    }
}
