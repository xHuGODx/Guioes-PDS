import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        FlightManager flightManager = new FlightManager();

        System.out.println("Bem-vindo ao sistema de reservas de voos!");

        while (true) {
            printHelp();

            System.out.print("Digite o comando: ");
            String command = scanner.nextLine();

            switch (command.charAt(0)) {
                case 'H':
                    // Ajuda
                    printHelp();
                    break;
                case 'I':
                    // Importar dados do arquivo
                    if (command.length() > 2) {
                        String filename = command.substring(2).trim();
                        flightManager.importDataFromFile(filename);
                    } else {
                        System.out.println("Formato inválido. Utilize: I filename");
                    }
                    break;
                case 'M':
                    // Mostrar detalhes do voo
                    if (command.length() > 2) {
                        String flightCode = command.substring(2).trim();
                        flightManager.displayFlightDetails(flightCode);
                    } else {
                        System.out.println("Formato inválido. Utilize: M flight_code");
                    }
                    break;
                case 'F':
                    // Criar novo voo
                    if (command.length() > 2) {
                        String[] tokens = command.substring(2).trim().split(" ");
                        int[] TouristicSize = {0,0};
                        int[] ExecutiveSize = {0,0};
                        String flightCode = null;

                        if (tokens.length == 3) {
                            flightCode = tokens[0]; 
                            String numSeatsExecutive = tokens[1];
                            String numSeatsTourist = tokens[2];

                            // Process "numSeatsExecutive" -> e.g: "4x3"
                            String[] executiveParts = numSeatsExecutive.split("x"); 
                            int numRowsE = Integer.parseInt(executiveParts[0]);
                            int numSeatsE = Integer.parseInt(executiveParts[1]);

                            // Process "numSeatsTourist" -> e.g: "4x3"
                            String[] turisticParts = numSeatsTourist.split("x"); 
                            int numRowsT = Integer.parseInt(turisticParts[0]);
                            int numSeatsT = Integer.parseInt(turisticParts[1]);
                            
                            ExecutiveSize[0] = numSeatsE;
                            ExecutiveSize[1] = numRowsE;

                            TouristicSize[0] = numSeatsT;
                            TouristicSize[1] = numRowsT;

                        } else if (tokens.length == 2)  {
                            flightCode = tokens[0]; 
                            String numSeatsTourist = tokens[1];
                
                            // Process "numSeatsTourist" -> e.g: "4x3"
                            String[] turisticParts = numSeatsTourist.split("x"); 
                            int numRowsT = Integer.parseInt(turisticParts[0]);
                            int numSeatsT = Integer.parseInt(turisticParts[1]);

                            TouristicSize[0] = numSeatsT;
                            TouristicSize[1] = numRowsT;
                        }
        
                        flightManager.createFlight(flightCode, TouristicSize, ExecutiveSize);

                    } else {
                        System.out.println("Formato inválido. Utilize: F flight_code num_seats_executive num_seats_tourist");
                    }
                    break;

                case 'R':
                    // Reservar assentos
                    if (command.length() > 2) { 
                        String[] tokens = command.substring(2).trim().split(" "); 
                        if (tokens.length == 3) {
                            String flightCode = tokens[0];
                            String seatsClass = tokens[1];
                            int numberSeats = Integer.parseInt(tokens[2]);

                            Reservation reserve = flightManager.reserveSeats(flightCode, seatsClass, numberSeats);
                            printReservation(reserve);
                        } else {
                            System.out.println("Formato inválido. Utilize: R flight_code class number_seats");
                        }
                    } else {
                        System.out.println("Formato inválido. Utilize: R flight_code class number_seats");
                    }
                    break;
                case 'C':
                    // Cancelar reserva
                    String reservationCode = command.substring(2).trim();
                    flightManager.cancelReservation(reservationCode);
                    break;
                case 'Q':
                    // Sair
                    System.out.println("Saindo do programa. Até logo!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Comando inválido. Digite 'H' para ajuda.");
            }
        }
    }

    private static void printReservation(Reservation reserve) {
        if (reserve == null)
            return;

        String resvCode = reserve.getReservationCode();
        System.out.print(resvCode + " = ");

        ArrayList<ArrayList<Integer>> positions = reserve.getPositionOfPassengers();

        int i, row;
        char seat;
        for (i = 0; i < positions.size()-1; i++) {
            ArrayList<Integer> passenger = positions.get(i);
            row = passenger.get(0)+1;
            seat = (char) (65 + passenger.get(1));

            System.out.printf("%d%c | ", row, seat);
        }

        ArrayList<Integer> passenger = positions.get(i);
        row = passenger.get(0)+1;
        seat = (char) (65 + passenger.get(1));
        System.out.printf("%d%c\n", row, seat);
    }

    private static void printHelp() {
        System.out.println("\nComandos disponíveis:");
        System.out.println("H - Ajuda");
        System.out.println("I filename - Importar dados de um voo a partir do ficheiro de texto.");
        System.out.println("M flight_code - Exibe o mapa das reservas de um voo");
        System.out.println("F flight_code num_seats_executive num_seats_tourist - Criar novo voo");
        System.out.println("R flight_code class number_seats - Reservar assentos");
        System.out.println("C reservation_code - Cancelar reserva");
        System.out.println("Q - Sair");
    }
}
