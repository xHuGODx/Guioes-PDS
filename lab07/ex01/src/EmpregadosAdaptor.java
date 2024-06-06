public class EmpregadosAdaptor extends Employee{

    /**
     * Creates a new instance of the EmpregadosAdaptor class.
     * 
     * @param empregado The empregado object to be adapted.
     */
    private EmpregadosAdaptor(Empregado empregado){
        super(empregado.nome() + " " + empregado.apelido(), (long) empregado.codigo(), empregado.salario());
    }

    /**
     * Creates a new instance of the EmpregadosAdaptor class.
     * 
     * @param empregado The empregado object to be adapted.
     * @return A new instance of the EmpregadosAdaptor class.
     */
    public static EmpregadosAdaptor createEmpregadosAdaptor(Empregado empregado){
        return new EmpregadosAdaptor(empregado);
    }
}
