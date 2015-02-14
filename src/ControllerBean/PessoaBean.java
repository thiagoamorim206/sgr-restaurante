package ControllerBean;

import ControllerDAO.PessoaDAO;
import Model.TbPessoa;

public class PessoaBean {

    private TbPessoa pessoa = new TbPessoa();
    private final PessoaDAO pessoaDAO = new PessoaDAO();

    public PessoaBean(String NmNome, String NrTelefone, String NrCelular, char NmSexo, String NmEmail) {
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

}
