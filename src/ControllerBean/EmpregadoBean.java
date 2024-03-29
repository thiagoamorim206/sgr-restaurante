package ControllerBean;

import ControllerDAO.EmpregadoDAO;
import Model.TbEmpregado;
import Model.TbPessoa;
import java.util.ArrayList;

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

    public String ListarEmpregado() {

        empregadoDAO.listarEmpregado();
        return "Sucesso";
    }

    public String ListarEmpregadoFuncao() {
        empregadoDAO.listarEmpregadoFuncao();
        return "Sucesso";
    }

    public String ListarTudoEmpregado() {
        empregadoDAO.listarTudoEmpregado();
        return "Sucesso";
    }

    public String DeletarEmpregado(int idEmpregado) {
        empregadoDAO.deletarEmpregado(idEmpregado);
        return "Sucesso";
    }

    public String AtualizarPessoa(TbPessoa p, TbEmpregado e, int x) {
        empregadoDAO.AtualizarPessoa(p, e, x);
        return "Sucesso";
    }

    /////ALTERADO POR ADRIANO

    public ArrayList vercozinheiros() {
        return empregadoDAO.idsCozinheiros();
    }
    
    
    ///// ALTERADO POR ADRIANO
    
    public void verGarcons(){
        empregadoDAO.mostrarGarcons();
    }
}
