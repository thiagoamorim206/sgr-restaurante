package ControllerBean;

import ControllerDAO.EmpregadoDAO;
import Model.TbEmpregado;

public class EmpregadoBean {

    private TbEmpregado empregado = new TbEmpregado();
    private final EmpregadoDAO empregadoDAO = new EmpregadoDAO();

    public EmpregadoBean(int IdPessoa, String FuncaoRestaurante) {
        empregado.setIdPessoa(IdPessoa);
        empregado.setDsFuncaoRestaurante(FuncaoRestaurante);

    }

    public EmpregadoBean() {
    }

    public TbEmpregado getEmpregado() {
        return empregado;
    }

    public void setEmpregado(TbEmpregado empregado) {
        this.empregado = empregado;
    }

    public String CadastroEmpregado() {

        empregado = empregadoDAO.inserirEmpregado(empregado);//salva
        return "Sucesso"; // Caso de Sucesso

    }

    public boolean ListarEmpregado() {

        boolean teste = empregadoDAO.listarEmpregado();
        return teste;
    }

    public boolean ListarEmpregadoFuncao() {
        boolean teste = empregadoDAO.listarEmpregadoFuncao();
        return teste;
    }

    public String DeletarEmpregado(int idEmpregado) {
        empregadoDAO.deletarEmpregado(idEmpregado);
        return "Sucesso";
    }

}
