public class PassageirosEletrico extends Passageiros implements VeiculoEletrico {
    protected int max_autonomia;
    protected int autonomia = max_autonomia;
    
    public PassageirosEletrico(String omatricula, String omarca, String omodelo, int opotencia,String oquadro, double opeso, double omax_passageiros, int oautonomia){
        super(omatricula, omarca, omodelo, opotencia, oquadro, opeso, omax_passageiros);
        this.max_autonomia = oautonomia;
    }

    public void trajeto(int distância){
        if (autonomia>=distância){
            super.trajeto(distância);
            autonomia -= distância;
        }
    }

    @Override
    public int autonomia() {
        return this.autonomia;
    }

    @Override
    public void carregar(int percentagem) {
        this.autonomia += percentagem*this.max_autonomia/100;
        if (this.autonomia > this.max_autonomia) this.autonomia = this.max_autonomia;
    }
}
