public class Mercadorias extends Pesado {
    protected double carga_max;

    public Mercadorias(String omatricula, String omarca, String omodelo, int opotencia, String oquadro, double opeso, double ocarga_max){
        super(omatricula, omarca, omodelo, opotencia, oquadro, opeso);
        this.carga_max = ocarga_max;
    }

    public double getCarga(){
        return this.carga_max;
    }
    public void setCarga(double ocarga_max){
        this.carga_max = ocarga_max;
    }
}
