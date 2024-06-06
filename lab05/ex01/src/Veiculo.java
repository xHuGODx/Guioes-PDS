public class Veiculo implements KmPercorridosInterface {
    protected String matricula;
    protected String marca;
    protected String modelo;
    protected double potencia;
    protected int ultimoTrajeto;
    protected int distanciaTotal;

    @Override
    public void trajeto(int quilometros) {
        this.ultimoTrajeto = quilometros;
        this.distanciaTotal += ultimoTrajeto;
    }
    @Override
    public int ultimoTrajeto() {
        return this.ultimoTrajeto;
    }
    @Override
    public int distanciaTotal() {
        return this.distanciaTotal;
    }

    public Veiculo(String omatricula, String omarca, String omodelo, int opotencia){
        this.matricula = omatricula;
        this.marca = omarca;
        this.modelo = omodelo;
        this.potencia = opotencia;
    }

    public String getMatricula(){
        return this.matricula;
    }
    public String getMarca(){
        return this.marca;
    }
    public String getModelo(){
        return this.modelo;
    }
    public double getPotencia(){
        return this.potencia;
    }

    public void setMatricula(String omatricula){
        this.matricula = omatricula;
    }
    public void setMarca(String omarca){
        this.marca = omarca;
    }
    public void setModelo(String omodelo){
        this.modelo = omodelo;
    }
    public void setPotencia(int opotencia){
        this.potencia = opotencia;
    }

    public String toString(){
        return "Matrícula: "+this.matricula+"; Marca: "+this.marca+"; Modelo: "+this.modelo+"; Potencia: "+this.potencia+"; Distancia Percorrida: "+this.distanciaTotal;
    }

    
}
