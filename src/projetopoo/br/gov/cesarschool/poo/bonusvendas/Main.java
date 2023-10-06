package projetopoo.br.gov.cesarschool.poo.bonusvendas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import projetopoo.br.gov.cesarschool.poo.bonusvendas.dao.VendedorDAO;
import projetopoo.br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import projetopoo.br.gov.cesarschool.poo.bonusvendas.entidade.geral.Endereco;
import projetopoo.br.gov.cesarschool.poo.bonusvendas.entidade.geral.Sexo;

public class Main {
    public static void main(String[] args) {
        LocalDate dataDeNascimento = LocalDate.parse("2003-12-10", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Endereco casa = new Endereco("Rua Santo Elias", 175, "Do lado do Edmar Victor", "52020214", "Recife", "Pernambuco", "Brasil");

        Vendedor edmar = new Vendedor("13755959461", "Edmar Rocha Alencar", Sexo.masculino, dataDeNascimento, 240, casa);
        Vendedor joao = new Vendedor("12312132132131", "João", Sexo.feminino, dataDeNascimento, 600, casa);

        VendedorDAO vendedorDAO = new VendedorDAO();

        vendedorDAO.incluir(edmar);
        vendedorDAO.incluir(joao);

        Vendedor[] vendedores = vendedorDAO.buscarTodos();

        for (int i = 0; i < vendedores.length; i++) {
            System.out.println("Nome: " + vendedores[i].getNomeCompleto());
            System.out.println("Endereço: " + vendedores[i].getEndereco().getLogradouro());
            System.out.println("Sexo: " + vendedores[i].getSexo().getDescricao());
        }
    }
}