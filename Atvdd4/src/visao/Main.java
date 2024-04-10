package visao;

import javax.swing.JOptionPane;

import modelagem.Cliente;
import negocio.ClienteArmazenamento;

public class Main {
    public static void main(String[] args) {
        
        ClienteArmazenamento armazenamento = new ClienteArmazenamento(10);

        
        int opcao;
        do {
            String[] opcoes = {"Adicionar Cliente", "Listar Clientes", "Sair"};
            opcao = JOptionPane.showOptionDialog(null, "Escolha uma op��o", "Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

            switch (opcao) {
                case 0:
                    String nome = JOptionPane.showInputDialog("Nome do cliente:");
                    String endereco = JOptionPane.showInputDialog("Endere�o do cliente:");
                    String telefone = JOptionPane.showInputDialog("Telefone do cliente:");
                    Cliente novoCliente = new Cliente(nome, endereco, telefone);
                    armazenamento.adicionarCliente(novoCliente);
                    break;
                case 1:
                    armazenamento.listarClientes();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Op��o inv�lida!");
            }
        } while (opcao != 2);
    }
}