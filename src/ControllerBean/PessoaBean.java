package ControllerBean;

import ControllerDAO.PessoaDAO;
import Model.TbPessoa;
import java.util.ArrayList;

public class PessoaBean {

    private TbPessoa pessoa = new TbPessoa();
    private final PessoaDAO pessoaDAO = new PessoaDAO();

    public PessoaBean(String NmNome, String NrTelefone, String NrCelular, String NmSexo, String NmEmail) {
        pessoa.setNmNome(NmNome);
        pessoa.setNrTelefone(NrTelefone);
        pessoa.setNrCelular(NrCelular);
        pessoa.setNmSexo(NmSexo);
        pessoa.setNmEmail(NmEmail);
    }

    public TbPessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(TbPessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String CadastroPessoa() {

        pessoa = pessoaDAO.inserirPessoa(pessoa);//salva
        return "Sucesso"; // Caso de Sucesso

    }

    public int listaUltimo() {
        ArrayList<TbPessoa> lista = pessoaDAO.listarUltimaLinha();

        for (TbPessoa o : lista) {
           return o.getIdPessoa();
        }
       return 0;

    }

}
