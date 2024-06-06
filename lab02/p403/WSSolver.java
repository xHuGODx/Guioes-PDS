import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;


public class WSSolver {

    static int MAX_SIZE = 40;

    static int size, solution_size = 0;
    
    private static String[] words = new String[MAX_SIZE];
    private static int count, y = 0;

    static Integer[] solution = new Integer[100000];



    public static void main(String[] args) throws IOException{

        if (args.length != 1) {
            System.err.println("Error: Invalid number of arguments");
            System.exit(1);
        }

        File file = load(args[0]);

        char[][] puzzle = Analyse(file);


        char[][] puzzlesolved = Resolve(puzzle, words);

        printSolution(puzzle,puzzlesolved);
    }

    public static File load(String name) {

        File file = new File(name);

        if (!file.exists()) {
            System.err.println("Error: File does not exist");
            System.exit(1);
        }

        return file;
    }

    public static char[][] Analyse(File filename) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();

            if (line == null) {
                System.err.println("Error: File is empty");
                return null;
            }

            size = line.length();

            if (size > MAX_SIZE) {
                System.err.println("Error: File is too big");
                return null;
            }

            if (size == 0) {
                System.err.println("Error: File is empty");
                return null;
            }

            char[][] puzzle = new char[size][size];


            for (int i = 0; i < size; i++) {
                puzzle[i][y] = line.charAt(i);
            }
            y++;

            for (int reading_line = 0; reading_line < size - 1; reading_line++) {
                String nextLine = br.readLine();
                if (nextLine.length() != size) {
                    System.err.println("Error: Puzzle is not a square");
                    System.exit(1);
                }
                for (int i = 0; i < size; i++) {
                    puzzle[i][y] = nextLine.charAt(i);
                }
                y++;
            }

            while ((line = br.readLine()) != null) {
                //percorre a linha e verfica se a letra é maiuscula
                int line_size = line.length();
                int uppercounter = 0;
                for (int i = 0; i < line.length(); i++) {
                    if (Character.isUpperCase(line.charAt(i))) {
                        uppercounter++;
                    }
                }

                if (uppercounter == line_size) {
                    System.err.println("Error: Puzzle is not a square");
                    System.exit(1);
                }


                if (line.matches(".*[ ,;].*")) {
                    String[] parts = line.split("[ ,;]");
                
                    for (String part : parts) {
                        words[count] = part;
                        count++;
                    }
                }
                else {
                    words[count] = line;
                    count++;
                }
            }
            


            return puzzle;
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file.");
            e.printStackTrace();
            throw e; 
        }
       
    }

    public static char[][] Resolve(char[][] puzzle, String[] words) {
        char[][] solvedPuzzle = new char[size][size];
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                solvedPuzzle[i][j] = '.';
            }
        }

        for (int word = 0; word < count; word++) {
            char first_letter = words[word].charAt(0);
            first_letter = Character.toUpperCase(first_letter);
            for (int y = 0; y < puzzle.length; y++) {
                for (int x = 0; x < puzzle.length; x++) {
                    if (puzzle[x][y] == first_letter) {
                        Direction result = recursiveCheck(puzzle, words[word], x, y, Direction.NONE, 0);
                        if (result != Direction.NONE) {
                            solution[solution_size] = y+1;
                            solution_size++;
                            solution[solution_size] = x+1;
                            solution_size++;
                            solution[solution_size] = result.ordinal();
                            solution_size++;

                            solvedPuzzle[x][y] = first_letter;
                            for (int i = 1; i < words[word].length(); i++) {
                                if(result == Direction.Right) {
                                    solvedPuzzle[x + i][y] = Character.toUpperCase(words[word].charAt(i));
                                } else if(result == Direction.Left) {
                                    solvedPuzzle[x - i][y] = Character.toUpperCase(words[word].charAt(i));
                                } else if(result == Direction.Down) {
                                    solvedPuzzle[x][y + i] = Character.toUpperCase(words[word].charAt(i));
                                } else if(result == Direction.Up) {
                                    solvedPuzzle[x][y - i] = Character.toUpperCase(words[word].charAt(i));
                                } else if(result == Direction.DownRight) {
                                    solvedPuzzle[x + i][y + i] = Character.toUpperCase(words[word].charAt(i));
                                } else if(result == Direction.DownLeft) {
                                    solvedPuzzle[x - i][y + i] = Character.toUpperCase(words[word].charAt(i));
                                } else if(result == Direction.UpRight) {
                                    solvedPuzzle[x + i][y - i] = Character.toUpperCase(words[word].charAt(i));
                                } else if(result == Direction.UpLeft) {
                                    solvedPuzzle[x - i][y - i] = Character.toUpperCase(words[word].charAt(i));
                                }
                            }
                                
                        }


                    }


                }
            }
        }

        return solvedPuzzle;
    }
    

    static int[] dx = {0, 1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 0, 1, -1, 1, -1, 1, -1};
    static Direction[] directions = {Direction.NONE, Direction.Right, Direction.Left, Direction.Down, Direction.Up, Direction.DownRight, Direction.DownLeft, Direction.UpRight, Direction.UpLeft};

    public static Direction recursiveCheck(char[][] puzzle, String word, int x, int y, Direction direction, int index) {
        if (index == word.length()) {
            return direction; 
        }

        if (x < 0 || y < 0 || x >= puzzle.length || y >= puzzle.length) {
            return Direction.NONE; 
        }

        if (puzzle[x][y] != Character.toUpperCase(word.charAt(index))) {
            return Direction.NONE;
        }

        if (direction == Direction.NONE) {
            for (int i = 1; i < directions.length; i++) {
                Direction found = recursiveCheck(puzzle, word, x + dx[i], y + dy[i], directions[i], index + 1);
                if (found != Direction.NONE) {
                    return found;
                }
            }
        } else {
            if(direction == Direction.Right) {
                return recursiveCheck(puzzle, word, x + 1, y, direction, index + 1);
            } else if(direction == Direction.Left) {
                return recursiveCheck(puzzle, word, x - 1, y, direction, index + 1);
            } else if(direction == Direction.Down) {
                return recursiveCheck(puzzle, word, x, y + 1, direction, index + 1);
            } else if(direction == Direction.Up) {
                return recursiveCheck(puzzle, word, x, y - 1, direction, index + 1);
            } else if(direction == Direction.DownRight) {
                return recursiveCheck(puzzle, word, x + 1, y + 1, direction, index + 1);
            } else if(direction == Direction.DownLeft) {
                return recursiveCheck(puzzle, word, x - 1, y + 1, direction, index + 1);
            } else if(direction == Direction.UpRight) {
                return recursiveCheck(puzzle, word, x + 1, y - 1, direction, index + 1);
            } else if(direction == Direction.UpLeft) {
                return recursiveCheck(puzzle, word, x - 1, y - 1, direction, index + 1);
            }
        }

        return Direction.NONE;
    }

    public static void printSolution(char[][] solvedPuzzle, char[][] puzzle) {

        System.out.println("\n---UNSOLVED PUZZLE---\n");

        for (int j = 0; j < solvedPuzzle.length;j++) {
            for (int i = 0; i < solvedPuzzle.length; i++) {
                System.out.print(solvedPuzzle[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\n---SOLVED PUZZLE---\n");

        for (int j = 0; j < puzzle.length;j++) {
            for (int i = 0; i < puzzle.length; i++) {
                System.out.print(puzzle[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("\n-----SOLUTION-----");
        System.out.printf("%-15s %-18s %-10s\n", "Word", "Coordinates", "Direction"); 
        for (int word = 0; word < count; word++) {
            System.out.printf("%-15s (%2d,%2d) %20s\n", words[word], solution[word*3], solution[word*3+1], directions[solution[word*3+2]]);
        }
        

    }
    
}
