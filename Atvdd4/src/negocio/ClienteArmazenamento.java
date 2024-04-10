package negocio;

import javax.swing.JOptionPane;

import modelagem.Cliente;

public class ClienteArmazenamento {
    private Cliente[] clientes;
    private TreeNode raiz; 
    private int tamanhoMaximo;
    private int contador;

    public ClienteArmazenamento(int tamanhoMaximo) {
        this.tamanhoMaximo = tamanhoMaximo;
        clientes = new Cliente[tamanhoMaximo];
        contador = 0;
        raiz = null; 
    }

    public void adicionarCliente(Cliente cliente) {
        if (contador < tamanhoMaximo) {
            clientes[contador] = cliente;
            contador++;
            //
            char primeiroCaractere = cliente.getNome().charAt(0); 
            if (raiz == null) {
                raiz = new TreeNode(primeiroCaractere);
            } else {
                adicionarClienteNaArvore(raiz, primeiroCaractere);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Armazenamento cheio!");
        }
    }

    
    private void adicionarClienteNaArvore(TreeNode node, char data) {
        if (data < node.data) {
            if (node.left != null) {
                adicionarClienteNaArvore(node.left, data);
            } else {
                node.left = new TreeNode(data);
            }
        } else if (data > node.data) {
            if (node.right != null) {
                adicionarClienteNaArvore(node.right, data);
            } else {
                node.right = new TreeNode(data);
            }
        }
    }

    
    public void listarClientesPreOrdem(TreeNode node) {
        if (node != null) {
            listarClientesPreOrdem(node.left);
            JOptionPane.showMessageDialog(null, "Nome: " + encontrarClientePorCaractere(node.data).getNome() +
                    ", Endereço: " + encontrarClientePorCaractere(node.data).getEndereco() +
                    ", Telefone: " + encontrarClientePorCaractere(node.data).getTelefone());
            listarClientesPreOrdem(node.right);
        }
    }

    
    private Cliente encontrarClientePorCaractere(char caracter) {
        for (Cliente cliente : clientes) {
            if (cliente != null && cliente.getNome().charAt(0) == caracter) {
                return cliente;
            }
        }
        return null; 
    }

 
    public void listarClientes() {
        StringBuilder sb = new StringBuilder();
        for (Cliente cliente : clientes) {
            if (cliente != null) {
                sb.append("Nome: ").append(cliente.getNome()).append("\n");
                sb.append("Endereço: ").append(cliente.getEndereco()).append("\n");
                sb.append("Telefone: ").append(cliente.getTelefone()).append("\n\n");
            }
        }
        JOptionPane.showMessageDialog(null, sb.toString());
}
    
}