public class Taxi extends Ligeiro {
    protected String licenca;

    public Taxi(String omatricula, String omarca, String omodelo, int opotencia, String oquadro, int ocapacidade, String olicenca){
        super(omatricula, omarca, omodelo, opotencia, oquadro, ocapacidade);
        this.licenca = olicenca;
    }

    public String getLicenca(){
        return this.licenca;
    }
    public void setLicenca(String olicenca){
        this.licenca = olicenca;
    }

}
