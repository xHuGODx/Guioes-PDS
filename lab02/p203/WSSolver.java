package p203;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;

public class WSSolver {
    public static Scanner sc = new Scanner(System.in);    
    public static void main(String[] args){
        verifyInputArgs(args);

        String fileName = args[0];
        char[][] parsedPuzzle = readFile(fileName);
        if(!checkPuzzleAllCaps(parsedPuzzle)){
            System.out.println("Puzzle isn't written in capital letters.");
            System.exit(0);
        }
        String[] words = getWordstoFind(fileName);
        if(!areAllWordsAlphabetic(words)){
            System.out.println("Given words contain non-alphabetic characters.");
            System.exit(0);
        }
        ArrayList<String> wordsFound = findWords(parsedPuzzle, words);
        char[][] puzzleSolution = displaySolution(parsedPuzzle, wordsFound);
        Scanner consoleInput = new Scanner(System.in);
        System.out.println("Output file name: ");
        String outputFilename = consoleInput.nextLine();
        writeToFile(wordsFound, puzzleSolution, outputFilename);
        consoleInput.close();

    }

    public static char[][] readFile(String fname){
        File myFile = new File(fname);
        char[][] puzzle = null;
        try{
            sc = new Scanner(myFile);
            ArrayList<String> lines = new ArrayList<>();
            while(sc.hasNextLine()){
                String data = sc.nextLine();
                if(data.isEmpty()){ // check if there empty line
                    System.out.println("Puzzle contains empty lines.");
                    return null;
                }
                if(data.contains(";") || data.contains(",") || data.contains(";")){
                    break; // ignore solutions
                }
                lines.add(data);
            }
            sc.close();
            int rows = lines.size();
            if(!isSquare(lines, rows)){
                System.out.println("The puzzle is not square.");
                return null;
            }
            int cols = lines.get(0).length(); // get the size of the 1st line
            if(!validSize(rows, cols)){
                System.out.println("Puzzle is bigger than 40x40.");
            }
            puzzle = new char[rows][cols];
            for(int i = 0; i < rows; i++){
                puzzle[i] = lines.get(i).toCharArray();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Non-existent file.");
        }
        return puzzle;
    }

    public static boolean isSquare(ArrayList<String> lines, int rows){
        for(int i = 0 ; i<rows; i++){
            if(lines.get(i).length() != rows){
                return false;
            }
        }
        return true;
    }

    public static boolean validSize(int rows, int cols){
        if(rows > 40 && cols > 40){
            return false;
        }
        return true;
    }

    public static boolean checkPuzzleAllCaps(char[][] parsedPuzzle){
        for(int i = 0; i<parsedPuzzle.length; i++){
            for(int j = 0; j<parsedPuzzle.length; j++){
                if(!Character.isUpperCase(parsedPuzzle[i][j])){
                    return false;
                }
            }
        }
        return true;
    }

    public static String[] getWordstoFind(String filename){
        String line;
        ArrayList<String> words = new ArrayList<>();
        File f = new File(filename);
        try {
            sc = new Scanner(f);
            while(sc.hasNextLine()){
                line = sc.nextLine();
                if(line.contains(" ") || line.contains(",") || line.contains(";")){
                    String[] lineWords = line.split("[, ;]");
                    for(int i = 0; i<lineWords.length;i++){
                        words.add(lineWords[i]);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error.");
        }
        String[] solutionWords = new String[words.size()];
        words.toArray(solutionWords);
        return solutionWords;
    }

    public static ArrayList<String> findWords(char[][] puzzle, String[] words){ 
        ArrayList<String> foundWords = new ArrayList<>();
        for(String word:words){
            for(int row = 0; row<puzzle.length; row++){
                for(int col = 0; col<puzzle.length; col++){
                    String orientation = findWordInDirection(puzzle, word, row, col);
                    if(orientation != null){
                        String result = word.toUpperCase() + " " + word.length() + " (" + row + ", " + col + ") " + orientation;
                        foundWords.add(result);
                    }
                }
            }
        }
        return foundWords;
    }

    public static String findWordInDirection(char[][] puzzle, String word, int row, int col){
        int[] rowDirections = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colDirections = {-1, 0, 1, -1, 1, -1, 0, 1};
        String[] directionsNames = {"UpLeft", "Up", "UpRight", "Left", "Right", "DownLeft", "Down", "DownRight"};
        for(int dir = 0; dir<8; dir++){ //check all 8 possible directions
            int rd = row;
            int cd = col;
            int charIndex;
            for(charIndex = 0; charIndex<word.length(); charIndex++){
                if(cd < 0 || cd >= puzzle.length || rd <0 || rd >= puzzle.length || puzzle[rd][cd] != Character.toUpperCase(word.charAt(charIndex))){
                    break;
                }
                rd += rowDirections[dir];
                cd += colDirections[dir];
            }
            if(charIndex == word.length()){
                return directionsNames[dir];
            }
        }
        return null;
    }

    public static boolean areAllWordsAlphabetic(String[] words){
        for(int i = 0;i<words.length;i++){
            for(int j = 0;j<words[i].length();j++){
                if(!Character.isLetter(words[i].charAt(j))){
                    return false;
                }
            }
        }
        return true;
    }

    public static char[][] displaySolution(char[][] puzzle, ArrayList<String> wordsFound) {
        char[][] solution = new char[puzzle.length][puzzle[0].length];
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                solution[i][j] = '.';
            }
        }
    
        for (String word : wordsFound) {
            String[] parts = word.split(" ");
            String foundWord = parts[0];
            int row = Integer.parseInt(parts[2].substring(1, parts[2].length() - 1));
            int col = Integer.parseInt(parts[3].substring(0, parts[3].length() - 1));
            String direction = parts[4];
    
            for (int i = 0; i < foundWord.length(); i++) {
                solution[row][col] = foundWord.charAt(i);
                switch (direction) {
                    case "UpLeft":
                        row--; col--; break;
                    case "Up":
                        row--; break;
                    case "UpRight":
                        row--; col++; break;
                    case "Left":
                        col--; break;
                    case "Right":
                        col++; break;
                    case "DownLeft":
                        row++; col--; break;
                    case "Down":
                        row++; break;
                    case "DownRight":
                        row++; col++; break;
                }
            }
        }
    
        return solution;
    }

    public static void writeToFile(ArrayList<String> wordsFound, char[][] solution, String filename) {
        try {
            PrintWriter writer = new PrintWriter(filename, "UTF-8");
    
            for (String word : wordsFound) {
                writer.println(word);
            }
    
            writer.println();
    
            for (char[] row : solution) {
                for (char c : row) {
                    writer.print(c);
                }
                writer.println();
            }
    
            writer.close();
        } catch (Exception e) {
            System.out.println("Error writing to file.");
        }
    }

    public static void verifyInputArgs(String[] args){
        if(args.length < 1){
            System.out.println("Please provide an input file as a command-line argument.");
            System.exit(1);
        }
    }
}
