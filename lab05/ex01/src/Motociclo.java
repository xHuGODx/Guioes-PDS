public class Motociclo extends Veiculo {
    protected String tipo;

    public Motociclo(String omatricula, String omarca, String omodelo, int opotencia, String tipo) {
        super(omatricula, omarca, omodelo, opotencia);
        this.tipo = tipo;
    }


    public String getTipo(){
        return this.tipo;
    }

    public void setTipo(String otipo){
        this.tipo = otipo;
    }

    @Override public String toString(){
        return super.toString() +"; Tipo: " + this.tipo;
    }
}
