import java.util.ArrayList;

public class EmpresaAluger {
    private String nome;
    private String postal;
    private String email;
    private ArrayList<Veiculo> viaturas;

    public EmpresaAluger(String onome, String opostal, String oemail){
        this.nome = onome;
        this.postal = opostal;
        this.email = oemail;
        this.viaturas = new ArrayList<Veiculo>();
    }

    public ArrayList<Veiculo> getStock(){
        return this.viaturas;
    }



    public int size(){
        return this.viaturas.size();
    }
    
    public Veiculo get(int i){
        return this.viaturas.get(i);
    }

    public String getNome(){
        return this.nome;
    }
    public String getPostal(){
        return this.postal;
    }
    public String getEmail(){
        return this.email;
    }

    public void setNome(String onome){
        this.nome = onome;
    }
    public void setPostal(String opostal){
        this.postal = opostal;
    }
    public void setEmail(String oemail){
        this.email = oemail;
    }

    public Veiculo getVeiculo(int i){
        return viaturas.get(i);
    }

    public void addVeiculo(Veiculo veic){
        viaturas.add(veic);
    }

    public boolean removeVeiculo(Veiculo veic){
        return viaturas.remove(veic);
    }

    public String toString(){
        String res = "Nome: "+this.nome+"\nCódigo Postal: "+this.postal+"\nEmail: "+this.email+"\n\n";
        if(this.viaturas.size()>0){
            for (int i=0;i<this.viaturas.size();i++){
                res += this.viaturas.get(i)+"\n";
            }
        }
        return res;
    }


}
