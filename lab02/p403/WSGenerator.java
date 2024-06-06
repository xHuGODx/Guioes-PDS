import java.util.*;
import java.io.*;

public class WSGenerator {
    static int MAX_SIZE = 40;
    static int count = 0;

    public static void main(String[] args) throws IOException{
        
        File filename = null;
        int puzzle_size = 0;
        String output_file = null;
        
        
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-i":
                    filename = load(args[i+1]);                    
                    break;
            
                case "-s":
                    puzzle_size = Integer.parseInt(args[i+1]);
                    break;

                case "-o":
                    output_file = args[i+1];
                    break;

                default:
                    break;
            }
        }
        
        String[] palavras_teste = readfile(filename, puzzle_size);


        if (palavras_teste != null) {
            String[][] matrix = makeMatrix(palavras_teste, puzzle_size);
            fullMatrix(matrix);
            printMatrix(matrix, palavras_teste, output_file);
        }

    }

    public static File load(String name) {
        File file_name = new File(name);
            
        if (!file_name.exists()){
            System.err.println("Error: File does not exist");
            System.exit(0);
        }

        return file_name;
    }

    public static String[] readfile(File filename, int puzzle_size) throws IOException{
        String[] words = new String[MAX_SIZE];

        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line = null;

        while ((line = br.readLine()) != null) {

            if (line.matches(".*[ ,;].*")) {
                String[] parts = line.split("[ ,;]");

                for (String part : parts) {
                    if (part.length() > puzzle_size) {
                        System.err.println("Error: The word " + part + " is too big for the puzzle");
                        br.close();
                        return null;
                    }
                    if (part != null) {
                        words[count] = part;
                        count++;
                    }

                }
            }
            else{
                if (line.length() > puzzle_size) {
                    System.err.println("Error: The word " + line + " is too big for the puzzle");
                    br.close();
                    return null;
                }
                if (line != null) {
                    words[count] = line;
                    count++;
                }

            }
        }
        br.close();
        return words;
    }

    public static Integer isNumeric(String strsize) {
        if (strsize == null) {
            System.err.println("Error: The size should be a number");
            System.exit(0);
        }
        
        int size = Integer.parseInt(strsize);

        if (size < 1) {
            System.err.println("Error: The size should be greater than zero");
            System.exit(0);
        }

        return size;
    }

    public static String[][] makeMatrix(String[] words, int puzzle_size) {
        String[][] matrix = new String[puzzle_size][puzzle_size];
        int word_size = 0;
        boolean is_valid = false;

        ArrayList<int[]> coordinates = new ArrayList<int[]>();
        ArrayList<Direction> directions = new ArrayList<Direction>();
        
        int[] initial_coord = new int[puzzle_size*puzzle_size];
        Direction direction = Direction.NONE;


        for (String word : words) {
            is_valid = false;
            if (word != null) {
                word_size = word.length();
                coordinates = generateCoordinates(word_size, puzzle_size, matrix);
                directions = generateDirections(word_size, puzzle_size, initial_coord);

                if (!coordinates.isEmpty() && !directions.isEmpty()) { //necessário definir a direção 
                    initial_coord = coordinates.get((int) (Math.random() * coordinates.size()));

                    while (!is_valid) {
                        if (!directions.isEmpty()){
                            direction = directions.get((int) (Math.random() * directions.size()));
                            switch (direction) { //verificar se a palavra cabe na direção escolhida
                                case Up:
                                    if (initial_coord[0] - word_size >= 0) {
                                        for (int i = 0; i < word_size; i++) {
                                            if (matrix[initial_coord[0] - i][initial_coord[1]] != null) {
                                                is_valid = false;
                                                break;
                                            }
                                            is_valid = true;
                                        }
                                    }
                                    break;
    
                                case Down:
                                    if (initial_coord[0] + word_size <= puzzle_size) {
                                        for (int i = 0; i < word_size; i++) {
                                            if (matrix[initial_coord[0] + i][initial_coord[1]] != null) {
                                                is_valid = false;
                                                break;
                                            }
                                            is_valid = true;
                                        }
                                    }
                                    break;
    
                                case Left:
                                    if (initial_coord[1] - word_size >= 0) {
                                        for (int i = 0; i < word_size; i++) {
                                            if (matrix[initial_coord[0]][initial_coord[1] - i] != null) {
                                                is_valid = false;
                                                break;
                                            }
                                            is_valid = true;
                                        }
                                    }
                                    break;
    
                                case Right:
                                    if (initial_coord[1] + word_size <= puzzle_size) {
                                        for (int i = 0; i < word_size; i++) {
                                            if (matrix[initial_coord[0]][initial_coord[1] + i] != null) {
                                                is_valid = false;
                                                break;
                                            }
                                            is_valid = true;
                                        }
                                    }
                                    break;
    
                                case UpLeft:
                                    if (initial_coord[0] - word_size >= 0 && initial_coord[1] - word_size >= 0) {
                                        for (int i = 0; i < word_size; i++) {
                                            if (matrix[initial_coord[0] - i][initial_coord[1] - i] != null) {
                                                is_valid = false;
                                                break;
                                            }
                                            is_valid = true;
                                        }
                                    }
                                    break;
    
                                case UpRight:
                                    if (initial_coord[0] - word_size >= 0 && initial_coord[1] + word_size <= puzzle_size) {
                                        for (int i = 0; i < word_size; i++) {
                                            if (matrix[initial_coord[0] - i][initial_coord[1] + i] != null) {
                                                is_valid = false;
                                                break;
                                            }
                                            is_valid = true;
                                        }
                                    }
                                    break;
    
                                case DownLeft:
                                    if (initial_coord[0] + word_size <= puzzle_size && initial_coord[1] - word_size >= 0) {
                                        for (int i = 0; i < word_size; i++) {
                                            if (matrix[initial_coord[0] + i][initial_coord[1] - i] != null) {
                                                is_valid = false;
                                                break;
                                            }
                                            is_valid = true;
                                        }
                                    }
                                    break;
    
                                case DownRight:
                                    if (initial_coord[0] + word_size <= puzzle_size && initial_coord[1] + word_size <= puzzle_size) {
                                        
                                        for (int i = 0; i < word_size; i++) {
                                            if (matrix[initial_coord[0] + i][initial_coord[1] + i] != null) {
                                                is_valid = false;
                                                break;
                                            }
                                            is_valid = true;
                                        }
                                    }
                                    break;
                                case NONE:
                                    break;
                                
                            }
                            directions.remove(direction);
                        }
                        else {
                        initial_coord = coordinates.get((int) (Math.random() * coordinates.size()));
                        directions = generateDirections(word_size, puzzle_size, initial_coord);
                        }

                    }
                    placeWord(matrix, initial_coord, direction, word);
                }
            }
        }

        return matrix;
    }

    public static ArrayList<int[]> generateCoordinates(int word_size, int puzzle_size, String[][] matrix){
        ArrayList<int[]> coordinates = new ArrayList<int[]>();
        
        if (word_size > puzzle_size) { // se a palavra for maior que o puzzle não é possível inserir
            return null;
        } 

        else if (word_size == puzzle_size) { // se a palavra for do mesmo tamanho que o puzzle só é possível começar nas bordas
 
            for (int row = 0; row < matrix.length; row++) {
                if (matrix[row][0] == null) {
                    coordinates.add(new int[] {row, 0});
                } 

                if(matrix[row][puzzle_size-1] == null){
                    coordinates.add(new int[] {row, puzzle_size-1});
                }
            }

            for (int col = 0; col < matrix.length; col++) {
                if (matrix[0][col] == null) {
                    coordinates.add(new int[] {0, col});
                } 

                if(matrix[puzzle_size-1][col] == null){
                    coordinates.add(new int[] {puzzle_size-1, col});
                }
            }
        } 

        else { // se a palavra for menor que o puzzle é possível começar em qualquer posição
            for (int i = 0; i < puzzle_size; i++) {
                for (int j = 0; j < puzzle_size; j++) {
                    if (matrix[i][j] == null) {
                        coordinates.add(new int[] {i,j});
                    }
                }
           }
        }

        return coordinates;
    }

    public static ArrayList<Direction> generateDirections(int word_size, int puzzle_size, int[] initial_coord){
        ArrayList<Direction> directions = new ArrayList<Direction>();
        int x = initial_coord[0];
        int y = initial_coord[1];

        if (x - word_size >= 0) {
            directions.add(Direction.Up);
        }

        if (x + word_size <= puzzle_size) {
            directions.add(Direction.Down);
        }

        if (y - word_size >= 0) {
            directions.add(Direction.Left);
        }

        if (y + word_size <= puzzle_size) {
            directions.add(Direction.Right);
        }

        if (x - word_size >= 0 && y - word_size >= 0) {
            directions.add(Direction.UpLeft);
        }

        if (x - word_size >= 0 && y + word_size <= puzzle_size) {
            directions.add(Direction.UpRight);
        }

        if (x + word_size <= puzzle_size && y - word_size >= 0) {
            directions.add(Direction.DownLeft);
        }

        
        if (x + word_size <= puzzle_size && y + word_size <= puzzle_size) {
            directions.add(Direction.DownRight);
        }

        return directions;
    }


    public static void placeWord(String[][] matrix, int[] initialcoord, Direction direction, String word) {
        int row = initialcoord[0];
        int col = initialcoord[1];
        int word_size = word.length();

        switch (direction) {
            case Up:
                for (int i = 0; i < word_size; i++) {
                    matrix[row - i][col] = Character.toString(word.charAt(i)).toUpperCase();
                }
                break;

            case Down:
                for (int i = 0; i < word_size; i++) {
                    matrix[row + i][col] = Character.toString(word.charAt(i)).toUpperCase();
                }
                break;

            case Left:
                for (int i = 0; i < word_size; i++) {
                    matrix[row][col - i] = Character.toString(word.charAt(i)).toUpperCase();
                }
                break;

            case Right:
                for (int i = 0; i < word_size; i++) {
                    matrix[row][col + i] = Character.toString(word.charAt(i)).toUpperCase();
                }
                break;

            case UpLeft:
                for (int i = 0; i < word_size; i++) {
                    matrix[row - i][col - i] = Character.toString(word.charAt(i)).toUpperCase();
                }
                break;

            case UpRight:
                for (int i = 0; i < word_size; i++) {
                    matrix[row - i][col + i] = Character.toString(word.charAt(i)).toUpperCase();
                }
                break;

            case DownLeft:
                for (int i = 0; i < word_size; i++) {
                    matrix[row + i][col - i] = Character.toString(word.charAt(i)).toUpperCase();
                }
                break;

            case DownRight:
                for (int i = 0; i < word_size; i++) {
                    matrix[row + i][col + i] = Character.toString(word.charAt(i)).toUpperCase();
                }
                break;
            case NONE:
                break;
        }
    }

    public static void fullMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == null) {
                    matrix[i][j] = Character.toString((char) (Math.random() * 26 + 'a')).toUpperCase();
                }
            }
        }
    }

    public static void printMatrix(String[][] matrix, String[] words, String output_file) throws IOException {
        PrintWriter out;
        
        if (output_file != null) {
            out = new PrintWriter(new FileWriter(output_file));
        } else {
            out = new PrintWriter(System.out);
        }

        for (String[] row : matrix) {
            for (String cell : row) {
                out.print(cell);
            }
            out.print("\n");
        }

        for (String word : words) {
            if (word != null) {
                out.println(word);
            }
        }

        out.close();
    }
    
}
