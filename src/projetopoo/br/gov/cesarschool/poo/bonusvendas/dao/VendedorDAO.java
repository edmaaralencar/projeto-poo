package projetopoo.br.gov.cesarschool.poo.bonusvendas.dao;

import java.io.Serializable;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;
import projetopoo.br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;

public class VendedorDAO {
    private static final String BRANCO = "";
    private CadastroObjetos cadastro = new CadastroObjetos(Vendedor.class);

    public boolean incluir(Vendedor vendedor) {
        Vendedor vendedorBusca = buscar(vendedor.getCpf());

        if (vendedorBusca != null) {
            return false;
        } else {
            cadastro.incluir(vendedor, BRANCO + vendedor.getCpf());
            return true;
        }
    }

    public Vendedor buscar(String cpf) {
        return (Vendedor)cadastro.buscar(BRANCO + cpf);
    }

    public Vendedor[] buscarTodos() {
        Serializable[] rets = cadastro.buscarTodos(Vendedor.class);
        Vendedor[] prods = new Vendedor[rets.length];
        for(int i = 0; i < rets.length; i++) {
            prods[i] = (Vendedor)rets[i];
        }
        return prods;
    }
}
