public class VehicleFactory {
    public static Veiculo createMotociclo(String matricula, String marca, String modelo, int cilindrada, String tipo){
        return new Motociclo(matricula, marca, modelo, cilindrada, tipo);
    }
    public static Veiculo createAutomovelLigeiro(String matricula, String marca, String modelo, int cilindrada, String numeroQuadro, int capacidade){
        return new Ligeiro(matricula, marca, modelo, cilindrada, numeroQuadro, capacidade);
    }
    public static Veiculo createTaxi(String omatricula, String omarca, String omodelo, int opotencia, String oquadro, int ocapacidade, String olicenca){
        return new Taxi(omatricula, omarca, omodelo, opotencia, oquadro, ocapacidade, olicenca);
    }
    public static Veiculo createPPEletrico(String omatricula, String omarca, String omodelo, int opotencia,String oquadro, double opeso, double omax_passageiros, int oautonomia){
        return new PassageirosEletrico(omatricula, omarca, omodelo, opotencia, oquadro, opeso, omax_passageiros, oautonomia);
    }    
    public static Veiculo createALEletrico(String omatricula, String omarca, String omodelo, int opotencia, String oquadro, int ocapacidade, int oautonomia){
        return new LigeiroEletrico(omatricula, omarca, omodelo, opotencia, oquadro, ocapacidade, oautonomia);
    }
    public static Veiculo createPesadoMercadorias(String omatricula, String omarca, String omodelo, int opotencia, String oquadro, double opeso, double ocarga_max){
        return new Mercadorias(omatricula, omarca, omodelo, opotencia, oquadro, opeso, ocarga_max);
    }
    public static Veiculo createPesadoPassageiros(String omatricula, String omarca, String omodelo, int opotencia,String oquadro, double opeso, double omax_passageiros){
        return new Passageiros(omatricula, omarca, omodelo, opotencia, oquadro, opeso, omax_passageiros);
    }
}
