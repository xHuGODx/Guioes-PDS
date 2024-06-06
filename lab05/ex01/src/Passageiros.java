public class Passageiros extends Pesado {
    protected double max_passageiros;

    public Passageiros(String omatricula, String omarca, String omodelo, int opotencia,String oquadro, double opeso, double omax_passageiros){
        super(omatricula, omarca, omodelo, opotencia, oquadro, opeso);
        this.max_passageiros = omax_passageiros;
    }

    public double getPassageiros(){
        return this.max_passageiros;
    }
    public void setPassageiros(double omax_passageiros){
        this.max_passageiros = omax_passageiros;
    }
}
