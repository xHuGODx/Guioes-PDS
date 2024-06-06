public class Ligeiro extends Veiculo {
    protected String quadro;
    protected int capacidade;

    public Ligeiro(String omatricula, String omarca, String omodelo, int opotencia, String oquadro, int ocapacidade){
        super(omatricula, omarca, omodelo, opotencia);
        this.quadro = oquadro;
        this.capacidade = ocapacidade;
    }
    
    public String getQuadro(){
        return this.quadro;
    }
    public double getCapacidade(){
        return this.capacidade;
    }

    public void setQuadro(String oquadro){
        this.quadro = oquadro;
    }
    public void setCapacidade(int ocapacidade){
        this.capacidade = ocapacidade;
    }

    @Override public String toString(){
        return super.toString() + "; Numero do Quadro: "+this.quadro+"; Capacidade de Passageiros: "+this.capacidade;
    }
}
