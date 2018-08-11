
import com.sun.corba.se.impl.presentation.rmi.DynamicMethodMarshallerImpl;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    //caminho e nomes do arquivo (ALTERAR COM BASE EM SEUS DADOS)
    private static final String CAMINHO_DO_ARQUIVO = "C:\\Users\\gmsil\\Documents\\NetBeansProjects\\Exercicio - Percistencia - 04-08\\src\\ArquivosDeDados\\";
    private static final String NOME_DO_ARQUIVO = "database.txt";

    public static void main(String[] args) throws IOException {
        Scanner scr = new Scanner(System.in);
        boolean sair = true;

        List<Cliente> clientes = new ArrayList<>();

        do {
            System.out.println("1 - Inserir\n2 - Pesquisar\n3 - Remover\n");
            int op = scr.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Digite o Codigo:");
                    final int codigo = scr.nextInt();
                    System.out.println("Digite o Nome:");
                    final String nome = scr.next();
                    System.out.println("Digite o Idade:");
                    final int idade = scr.nextInt();
                    System.out.println("Digite o Sexo:");
                    final String sexo = scr.next();
                    System.out.println("Digite o Profissao:");
                    final String profissao = scr.next();
                    
                    salva(new Cliente(codigo, nome, idade, sexo, profissao));
                    
                    break;
                case 2:
                    System.out.println("Digite o codigo:\n");
                    final int id = scr.nextInt();
                    clientes.clear();
                    
                    clientes = lee();
                    if (id == -1) {
                        for (Cliente cliente : clientes) {
                            System.out.println("Codigo:" + cliente.getCodigo() + "\n"
                                    + "Nome:" + cliente.getNome() + "\n"
                                    + "Idade:" + cliente.getIdade() + "\n"
                                    + "Sexo:" + cliente.getSexo() + "\n"
                                    + "Profissao:" + cliente.getProfissao() + "\n");
                        }
                    } else {
                        for (Cliente cliente : clientes) {
                            if (cliente.getCodigo() == id) {
                                System.out.println("Codigo:" + cliente.getCodigo() + "\n"
                                        + "Nome:" + cliente.getNome() + "\n"
                                        + "Idade:" + cliente.getIdade() + "\n"
                                        + "Sexo:" + cliente.getSexo() + "\n"
                                        + "Profissao:" + cliente.getProfissao() + "\n");
                            }
                        }
                    }

                    break;
                case 3:
                    System.out.println("Digite o codigo:");
                    final int index = scr.nextInt();
                    for (int i = 0; i < clientes.size(); i++) {
                        if (clientes.get(i).getCodigo() == index) {
                            final Cliente removido = clientes.remove(i);
                            System.out.println("Item removido: \n"
                                    + "Codigo:" + removido.getCodigo() + "\n"
                                    + "Nome:" + removido.getNome() + "\n"
                                    + "Idade:" + removido.getIdade() + "\n"
                                    + "Sexo:" + removido.getSexo() + "\n"
                                    + "Profissao:" + removido.getProfissao() + "\n");
                        }
                    }

                    break;
                default:
                    sair = false;
                    break;
            }

        } while (sair);
    }

    
    //metodo busca no arquivo texto e retorna uma lista com tudo que tem no arquivo texto
    public static List lee() throws FileNotFoundException, IOException {
        List<Cliente> clientes = new ArrayList<>();
        
        //metodo leitor (transforma oque tem neste aquivo em bits);
        FileReader fileReader = new FileReader(CAMINHO_DO_ARQUIVO + NOME_DO_ARQUIVO);
        
        //transforma os bits do arquivo em string
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        
        String linha;
        
        //pega linha a linha e monta a lista 
        while ( ( linha = bufferedReader.readLine())  != null) {
            String[] vet = linha.split("@");
            Cliente cliente = new Cliente(Integer.parseInt(vet[0]), vet[1], Integer.parseInt(vet[2]), vet[3], vet[4]);
            clientes.add(cliente);
        }
        bufferedReader.close();
        
        return clientes;
    }

    //salva no arquivo
    public static void salva(Cliente cliente) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        
        //lee o arquivo todo
        FileReader fileReader = new FileReader(CAMINHO_DO_ARQUIVO + NOME_DO_ARQUIVO);
        
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        
        String linha;
        
        while ( ( linha = bufferedReader.readLine())  != null) {
            stringBuilder.append(linha);
            stringBuilder.append("\n");
        }
///
        
//metodo escritor (cria um arquivo neste local para escrever no mesmo)
        FileWriter arq = new FileWriter(CAMINHO_DO_ARQUIVO + NOME_DO_ARQUIVO);
        
        //metodo q escreve de verdade 
        PrintWriter gravarArq = new PrintWriter(arq);

        //monta a linha
        stringBuilder.append(cliente.getCodigo());
        stringBuilder.append("@");
        stringBuilder.append(cliente.getNome());
        stringBuilder.append("@");
        stringBuilder.append(cliente.getIdade());
        stringBuilder.append("@");
        stringBuilder.append(cliente.getSexo());
        stringBuilder.append("@");
        stringBuilder.append(cliente.getProfissao());
        stringBuilder.append("\n");
        
        //escreve
       gravarArq.print(stringBuilder.toString());
       
// fecha o arquiv
        arq.close();
        
    }
}
