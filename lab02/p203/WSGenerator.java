package p203;
import java.util.*; //Scanner & Random
import java.io.*;   // Files
public class WSGenerator {
    public static final Scanner sc = new Scanner(System.in);
    public static ArrayList<String> words = new ArrayList<String>();
    public static ArrayList<String>sortedWords = new ArrayList<String>();
    public static final int GRID_MAX_SIZE = 40;
    public static final int RIGHT = 0;
    public static final int LEFT = 1;
    public static final int DOWN = 2;
    public static final int UP = 3;
    public static final int UP_LEFT = 4;
    public static final int UP_RIGHT = 5;
    public static final int DOWN_LEFT = 6;
    public static final int DOWN_RIGHT = 7;
    public static int gridSize = 0;

    public static void main(String[] args) throws Exception {
        String inputFile = null;
        String outputFile = null;
        int gridSize = 0;
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-i":
                    inputFile = args[++i];
                    break;
                case "-s":
                    gridSize = Integer.parseInt(args[++i]);
                    break;
                case "-o":
                    outputFile = args[++i];
                    break;
            }
        }
        readerFile(inputFile);
        sizeChecker(gridSize);
        setGridSize(gridSize); 
        wordSorter();

        char [][] grid = new char [getGridsize()][getGridsize()];
    
        placeInGrid(grid,sortedWords.get(0),0, getGridsize()/2,RIGHT);
        sortedWords.remove(0);
        Random random = new Random(); 
        for (int i = 0; i < sortedWords.size(); i++) {
            String word = sortedWords.get(i);
            int[] placement = checkSpace(grid, word); 
    
            if (placement != null) {
                placeInGrid(grid, word, placement[0], placement[1], placement[2]);
            } else {
                boolean placed = false;
                for (int attempts = 0; attempts < 100; attempts++) {
                    int randomX = random.nextInt(getGridsize());
                    int randomY = random.nextInt(getGridsize());
                    int randomDirection = random.nextInt(8);
                    if (canPlaceWord(grid, word, randomX, randomY, randomDirection)) {
                        placeInGrid(grid, word, randomX, randomY, randomDirection);
                        placed = true;
                        break;
                    }
                }
                if (!placed) {
                    System.out.println("Could not place word: " + word);
                }
            }
        }
        fillEmptySpots(grid);
        printGrid(grid);
        fileGen(grid, outputFile,words); 
    }

    public static char randCharGen(){
        Random r = new Random();
        char c = (char)(r.nextInt(26) + 'A'); 
        return c;
    }

    public static void readerFile(String filename){
        try{
            File wordFile = new File(filename);
            Scanner reader = new Scanner(wordFile);
            if(!reader.hasNextLine()){
                System.out.println("Error: File is empty");
            }
            while(reader.hasNextLine()){
                String data = reader.nextLine();
                emptyLine(data);
                addWords(data);
            }
            reader.close();
        }catch(FileNotFoundException e){
            System.out.println("An error has occured");
            e.printStackTrace();
        }   
    }

    public static void fileGen(char[][] grid, String filename, ArrayList<String>words) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(filename));
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                writer.print(grid[i][j]);
            }
            writer.println();
        }
        System.out.println();
        for(String word : words){
            writer.print(word + ";");
        }
        writer.close();
    }

    public static void sizeChecker(int size){
        if(size > GRID_MAX_SIZE){
            System.out.println("Puzzle must be less than 41x41");
        }
    }

    public static void wordChecker(String word){
        for(int i = 0; i < word.length(); i++){
            char a  = word.charAt(i);
            if(Character.isLetter(a)){
            
            }else{
                System.out.printf("Error: character %s is not a alphabetical letter",a);
            }
        }
    }

    public static void emptyLine(String word){
        if(word.isEmpty()){
            System.out.println("Error: File has an empty line");
        }
    }

    public static void addWords(String data){
        String [] splitWords = data.split("[ ;,\n]");
        for(String word : splitWords){
            words.add(word);
            wordChecker(word);
        }
    }

    public static void wordSorter(){
        sortedWords.addAll(words);
        Collections.sort(sortedWords, new Comparator<String>() {
            public int compare(String word1, String word2) {
                return word2.length() - word1.length();
            }
        });
        capitalizeWords();
    }

    public static int getGridsize() {
        return gridSize;
    }

    public static void setGridSize(int gridSize) {
        WSGenerator.gridSize = gridSize;
    }

    public static void printGrid(char [][] grid){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        for(String word : words){
            System.out.print(word + ";");
        }
    }

    public static void capitalizeWords(){
        for(int i = 0; i < sortedWords.size(); i++){
            sortedWords.set(i, sortedWords.get(i).toUpperCase());
        }
    }

    public static void placeInGrid(char[][] grid, String word, int xcord, int ycord, int direction) {
        int dx = 0, dy = 0;
        switch (direction) {
            case RIGHT: dx = 1; break;
            case LEFT: dx = -1; break;
            case DOWN: dy = 1; break;
            case UP: dy = -1; break;
            case UP_LEFT: dx = -1; dy = -1; break;
            case UP_RIGHT: dx = 1; dy = -1; break;
            case DOWN_LEFT: dx = -1; dy = 1; break;
            case DOWN_RIGHT: dx = 1; dy = 1; break;
        }
    
        for (int i = 0; i < word.length(); i++) {
            grid[ycord + i * dy][xcord + i * dx] = word.charAt(i);
        }
    }

    public static int[] checkSpace(char[][] grid, String word) {
        int wordLength = word.length();
        int[] result = new int[3]; // To store x-coordinate, y-coordinate and direction
    
        for (int i = 0; i < wordLength; i++) {
            char selectedChar = word.charAt(i);
            for (int ycord = 0; ycord < grid.length; ycord++) {
                for (int xcord = 0; xcord < grid[ycord].length; xcord++) {
                    if (grid[ycord][xcord] == selectedChar) {
                        for (int direction = 0; direction <= 7; direction++) {
                            if (canPlaceWord(grid, word, xcord - i, ycord, direction)) {
                                result[0] = xcord - i; 
                                result[1] = ycord; 
                                result[2] = direction; 
                                return result;
                            }
                        }
                    }
                }
            }
        }
        return null; 
    }
    
    public static boolean canPlaceWord(char[][] grid, String word, int xcord, int ycord, int direction) {
        int dx = 0, dy = 0;
        switch (direction) {
            case RIGHT: dx = 1; break;
            case LEFT: dx = -1; break;
            case DOWN: dy = 1; break;
            case UP: dy = -1; break;
            case UP_LEFT: dx = -1; dy = -1; break;
            case UP_RIGHT: dx = 1; dy = -1; break;
            case DOWN_LEFT: dx = -1; dy = 1; break;
            case DOWN_RIGHT: dx = 1; dy = 1; break;
        }
    
        for (int i = 0; i < word.length(); i++) {
            int newX = xcord + i * dx;
            int newY = ycord + i * dy;
    
            if (newX < 0 || newX >= grid[0].length || newY < 0 || newY >= grid.length) {
                return false;
            }
    
            if (grid[newY][newX] != '\0' && grid[newY][newX] != word.charAt(i)) {
                return false;
            }
        }
    
        return true;
    }

    public static void fillEmptySpots(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '\0') { 
                    grid[i][j] = randCharGen();
                }
            }
        }
    }
}
