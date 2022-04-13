package Visualiza;
import java.util.*;
import Modelo.*;
import Controle.*;
import java.text.*;

/**
 * Escreva uma descrição da classe Tela aqui.
 * 
 * @author (Everton jauer Barlette) 
 * @version (05/01/2022)
 */
public class Tela
{

    /**
     * Construtor para objetos da classe Tela
     */
    public static void mostrarInterface()
    {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        int opt = 0;
        String nom="";
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat df2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        df.setLenient(false);
        df2.setLenient(false);
        Date hoje = new Date();
        pessoaControle pctl = new pessoaControle();
        alunoControle actl = new alunoControle();
        while(opt != 5)
        {
            System.out.println("=========================================================");
            System.out.println("Escolha uma opção:");
            System.out.println("Opção 1 - Cadastra Pessoas ou Alunos");
            System.out.println("Opção 2 - Mostra Pessoas e Alunos cadastrados");
            System.out.println("Opção 3 - Atualizar dados");
            System.out.println("Opção 4 - Deletar Pessoas ou Alunos");
            System.out.println("Opção 5 - Aplicação encerrada");
            System.out.println("=========================================================");
            try
            {
                System.out.print("Digite o número da opção escolhida: ");
                opt = Integer.parseInt(sc.nextLine());
                limpaTela();
            }
            catch(NumberFormatException e)
            {
                System.out.println("Opção inválida, digite somente números de 1 a 5");
                mostrarInterface();
            }
            if(opt == 1)
            {
                //pega os dados da pessoa ou aluno
                System.out.print("Informe seu nome: ");
                nom = sc.nextLine();
                while(!pctl.validaNome(nom))
                {
                    System.out.println("caracteres inválidos");
                    System.out.println("Informe seu nome novamente: ");
                    nom = sc.nextLine();
                }

                System.out.print("Informe seu telefone ((xx)xxxx-xxxx): ");
                String tel = sc.nextLine();
                while(!pctl.validaTelefone(tel))
                {
                    System.out.println("padrão de caracteres inválidos");
                    System.out.println("Informe seu telefone novamente: ");
                    tel = sc.nextLine();
                }

                try
                {
                    System.out.print("Informe a data de nascimento(dd/MM/aaaa): ");
                    String Ddnt = sc.nextLine();
                    Date Ddn = df.parse(Ddnt);
                    while(Ddn.after(hoje))
                    {
                        System.out.println("Data inválida : data superior ao dia de hoje");
                        System.out.print("Informe uma nova data de nascimento(dd/MM/aaaa): ");
                        Ddnt = sc.nextLine();
                        Ddn = df.parse(Ddnt);
                    } 

                    System.out.print("Informe a data do cadastro (dd/MM/aaaa): ");
                    String dcpt = sc.nextLine();
                    Date dcp = df.parse(dcpt);
                    while(dcp.after(hoje))
                    {
                        System.out.println("Data inválida : data superior ao dia de hoje");
                        System.out.print("Informe uma data de cadastro(dd/MM/aaaa): ");
                        dcpt = sc.nextLine();
                        dcp = df.parse(dcpt);
                    } 
                    try 
                    {
                        System.out.print("Informe sua nota separando com ponto(.) o valor fracionado (caso for aluno): ");
                        String nott = sc.nextLine();
                        double not = Double.parseDouble(nott);
                        actl.criaAluno(nom,tel,Ddn,dcp,not);  
                    }                
                    catch(Exception e) 
                    {
                        pctl.criaPessoa(nom,tel,Ddn,dcp);
                    }
                    
                }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }

            else if(opt == 2)
            {
                pctl.mostraPessoa();
                actl.mostraAluno();
                System.out.println("Data da última atualização " + df2.format(hoje));
            }

            else if(opt == 3)
            {
                try
                {
                    System.out.println("Para editar pessoa digite 1,para editar aluno digite 2");
                    opt = Integer.parseInt(sc.nextLine());
                }
                catch(NumberFormatException e)
                {
                    {
                        System.out.println("Digite apenas os números 1 ou 2");
                    }
                }
                if(opt==1)
                {
                    pctl.editaPessoa();
                }
                else if(opt==2)
                {
                    actl.editaAluno();
                }
                else if(opt != 1)
                {
                    System.out.println("Número da opção inválido.");
                }
                else if(opt != 2 )
                {
                    System.out.println("Número da opção inválido.");
                }
            }
            else if(opt == 4)
            {  
                try
                {
                    System.out.println("Para deletar pessoa digite 1,para deletar aluno digite 2");
                    opt = Integer.parseInt(sc.nextLine());
                }
                catch(NumberFormatException e)
                {
                    {
                        System.out.println("Digite apenas os números 1 ou 2");
                    }
                }
                if(opt==1)
                {
                    pctl.deletaPessoa();
                }
                else if(opt==2)
                {
                    actl.deletaAluno(); 
                }
                else if(opt != 1)
                {
                    System.out.println("Número da opção inválido.");
                }
                else if(opt != 2 )
                {
                    System.out.println("Número da opção inválido.");
                }
            }
            else if(opt != 5)
            {
                System.out.println("Número da opção inválido.");
            }

        }
        //encerramento da aplicação
        System.out.print("Aplicação encerrada");

        //encerra o fluxo de manipulação do System.in
        sc.close();
    }

    public static void limpaTela()
    {
        //Limpa a tela no windows, no linux e no MacOS
        try
        {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        }
        catch(Exception e) {}

    } 

}
