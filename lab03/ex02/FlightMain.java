package lab03.Voos;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class FlightMain {
    public static void main(String[] args) {
        String input, op;
        Scanner sc = new Scanner(System.in);
        Scanner sc_input;
        int numberOfSeats;
        Flight currentFlight = null;
        
        // Lista para aramzenar os nosso voos.
        // Quando for usado o código, é necessário iterar o array para descobrir o index que tem o mesmo.
        List<Flight> allFlights = new ArrayList<>();
    
        do {
            System.out.println("Escolha uma opção: (H para ajuda)");
            input = sc.nextLine();
            String[] input_array = input.split("\\s+");
            op = input_array[0].toUpperCase();
    
            switch (op) {
                case "H":
                    System.out.println("H - Help");
                    System.out.println("I - (I filename)\n\t"+"Lê um ficheiro com informação sobre os voos."+
                                        "E mostra essa informação no ecrã.");
                    System.out.println("M - (M flight_code)");
                    System.out.println("F - (F flight_code num_seats_executive num_seats_tourist)");
                    System.out.println("R - (R flight_code class number_seats)");
                    System.out.println("C - (C reservation_code)");
                    System.out.println("Q - Quit");
                    break;
                
                case "I":
                    // TODO: Implement functionality for option I
                    if(input_array.length != 2){
                        System.out.println("Número de argumentos inválido. Por favor, tente novamente.");
                        break;
                    }

                    try {
                        funcForI(input_array, allFlights);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                        break;
                    }
                    break;
                case "M":
                    // TODO: Implement functionality for option M
                    break;
                case "F":
                    //DONE
                    try {
                        funcForF(input_array, allFlights);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                        break;
                    }
                    break;
                case "R":
                    try {
                        funcForR(input_array, allFlights);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                        break;
                    }
                    break;
                case "C":
                    // TODO: Implement functionality for option C
                    break;
                case "Q":
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
                    break;
            }
        } while (!op.equals("Q"));

        sc.close();
        // Só chegamos aqui quando a opcão é "Q".
        System.out.println("Quitting the program...");
        System.exit(0);
    }

    public static void funcForI(String[] input_array, List<Flight> allFlights) throws Exception {
        String filename = input_array[1];
        boolean isFirstLine = true;
        String code = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                String[] line_array = line.split("\\s+");
                if(isFirstLine){
                    if(line_array.length < 2 || line_array.length > 3){
                        throw new Exception("O ficheiro não está no formato correto!");
                    }
                    if(line.charAt(0) != '>'){
                        throw new Exception("O ficheiro não está no formato correto!");
                    }
                    if (line_array.length == 3){
                        code = line_array[0].substring(1);


                        String executiveString = line_array[1];
                        int[] executiveSitsInfo = new int[2];
                        String[] splitArray = executiveString.split("x");
                        executiveSitsInfo[0] = Integer.parseInt(splitArray[0]);
                        executiveSitsInfo[1] = Integer.parseInt(splitArray[1]);


                        String touristString = line_array[2];
                        int[] touristSitsInfo = new int[2];
                        String[] splitArray2 = touristString.split("x");
                        touristSitsInfo[0] = Integer.parseInt(splitArray2[0]);
                        touristSitsInfo[1] = Integer.parseInt(splitArray2[1]);

                        //TODO fazer o print que esta la no guiao
                        System.out.println("Código de voo " + code +"."+ "Lugares disponiveis: " + executiveSitsInfo[0]*executiveSitsInfo[1] + " lugares em classe Executiva; " + touristSitsInfo[0]*touristSitsInfo[1] + " lugares em classe Turistica.");
                    }
                    else{
                        code = line_array[0].substring(1);
                        String touristString = line_array[1];

                        int[] touristSitsInfo = new int[2];
                        String[] splitArray2 = touristString.split("x");
                        touristSitsInfo[0] = Integer.parseInt(splitArray2[0]);
                        touristSitsInfo[1] = Integer.parseInt(splitArray2[1]);

                        //TODO fazer o print que esta la no guiao
                        System.out.println("Código de voo " + code +"."+ "Lugares disponiveis: " + touristSitsInfo[0]*touristSitsInfo[1] + " lugares em classe Turistica.");
                    }
                    isFirstLine = false;
                    
                    //TODO: Criar o voo com estes dados (e o aviao tambem xD )
                    //deve ser so chamar a funcao f com um pouco de manipulacoa de dados mas nao me apetece agora
                }
                else{
                    if(line_array[0].equals("E")){
                        String[] dados = {code, "E", line_array[1]};
                        funcForR(dados, allFlights);
                    }
                    else if(line_array[0].equals("T")){
                        String[] dados = {code, "T", line_array[1]};
                        funcForR(dados, allFlights);
                    }
                    else{
                        throw new Exception("O ficheiro não está no formato correto!");
                    }
                }
            }
        }
            catch (IOException e) {
                throw new Exception("Não foi possível ler o ficheiro!");
            }
        
    }

    public static void funcForR(String[] input_array, List<Flight> allFlights) throws Exception {

        Flight currentFlight = null;
        String code = input_array[1];
        String currentClasse = input_array[2];
        int numberOfSeats = Integer.parseInt(input_array[3]);

        for (Flight f : allFlights) {
            if (f.getCode() == code){
                currentFlight = f;
                break;
            }
        }
        if (currentFlight == null){
            throw new Exception("Não foi possível encontrar o seu voo!");
        }
        currentFlight.addReservation(currentClasse, numberOfSeats);
    }

    public static void funcForF(String[] input_array, List<Flight> allFlights) throws Exception{
        //TODO: Falta aqui agum throw new Exception se for preciso

        String code = input_array[1];
        if(input_array.length == 3){ //so tem lugares turisticos

            int[] touristSitsInfo = new int[2];
            String[] splitArray = input_array[2].split("x");
            touristSitsInfo[0] = Integer.parseInt(splitArray[0]);
            touristSitsInfo[1] = Integer.parseInt(splitArray[1]);

            allFlights.add(new Flight(code, new TouristicPlaneOnly(touristSitsInfo[0], touristSitsInfo[1])));
        }
        else{

            int[] executiveSitsInfo = new int[2];
            String[] splitArray = input_array[2].split("x");
            executiveSitsInfo[0] = Integer.parseInt(splitArray[0]);
            executiveSitsInfo[1] = Integer.parseInt(splitArray[1]);

            int[] touristSitsInfo = new int[2];
            String[] splitArray2 = input_array[3].split("x");
            touristSitsInfo[0] = Integer.parseInt(splitArray[0]);
            touristSitsInfo[1] = Integer.parseInt(splitArray[1]);

            allFlights.add(new Flight(code, new PlaneWithExecutive(touristSitsInfo[0], touristSitsInfo[1], executiveSitsInfo[0], executiveSitsInfo[1])));
        }
    }
}
