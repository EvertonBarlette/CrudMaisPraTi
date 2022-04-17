package Controle;
import java.util.*;
import Modelo.*;
import java.text.*;
import Visualiza.*;
/**
 * Classe de controle de cadastro de alunos.
 * 
 * @author (Everton Jauer Barlette) 
 * @version (05/01/2022)
 */
public class alunoControle
/**
 * Criação das variáveis de leitura das informações digitadas pelo usuário e seletor das opções.
 */
{
    Scanner leralu = new Scanner(System.in);
    int selalu;
    /**
     * Método que coleta os dados para cadastrar um objeto. 
     * 
     * @param String nome do aluno 
     * @param String telefone do aluno
     * @param Date Data de nascimento do aluno
     * @param Date Data do cadastro do aluno
     * @return boolean true se gravou ou false se deu bug 
     */
    public boolean criaAluno(String nom,String tel,Date Ddn,Date cdt,Double not)
    {
        // Criar o objeto pessoa , ajustar os dados
        Aluno objalu = new Aluno(nom,tel,Ddn,cdt,not);

        alunoDAO.getInstance().cadastrarAluno(objalu);
        return true;
    }

    public void mostraAluno()
    /**
     * Método que mostra todas as informações dos objetos cadastrados ou indica que a lista está vazia caso contrário.
     */
    {
        int ia=1;   
        List<Aluno> lstalu = alunoDAO.getInstance().listarAluno();
        for(Aluno aluno : lstalu) 
        { 
            Date hoje = new Date();
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            DateFormat df2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            System.out.println("===================ALUNO " +ia+"===============================");
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("Telefone: " + aluno.getTel());
            System.out.println("Data de nascimento: " + df.format(aluno.getData_nasc()));
            System.out.println("Data de cadastro: " + df.format(aluno.getCadastro()));
            System.out.println("Nota: " + aluno.getNota());
            ia++;
        }
        if(lstalu.isEmpty())
        {
            System.out.println("=================A lista de alunos está vazia============");
        }
    }

    public void deletaAluno()
     /**
     * Método que deleta objetos através do seu indice (posição) ou indica que a lista está vazia caso contrário.
     */
    {
        boolean pos = true;
        while(pos)
        {
         int i=0;   
         List<Aluno> lstalu = alunoDAO.getInstance().listarAluno();    
         for(Aluno aluno : lstalu)
         {
            System.out.println("Posição"+i+"-"+aluno.getNome());
            i++;
         }
         if(lstalu.isEmpty())
         {
            System.out.println("A lista de alunos está vazia ");
         }
         else
         {
              try
            {
                System.out.printf("\nInforme a posição a ser excluída:\n");
                i = leralu.nextInt();
                // [ D ] remove o i-ésimo aluno da lista
                lstalu.remove(i);
                pos = false;
            }
             catch(IndexOutOfBoundsException e)
            {
                System.out.println("Insira um número de posição Existente");
            }
            catch(InputMismatchException e)
            {
                leralu.nextLine();
                System.out.println("caracter invalido.Insira um número de posição Existente");
            }
         }
        }
    }

    public void editaAluno()
    /**
     * Método que edita informações dos objetos através do seu indice (posição) ou indica que a lista está vazia caso contrário.
     */
    {
        boolean pos = true;
        while(pos)
        {
         int ie=0;
         selalu=0;
         DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
         List<Aluno> lstalu = alunoDAO.getInstance().listarAluno();
         for(Aluno aluno : lstalu)
         {
            System.out.println("Posição"+ie+"-"+aluno.getNome());
            ie++;
         }
         if(lstalu.isEmpty())
         {
            System.out.println("A lista de alunos está vazia ");
         }
         else
         {
             try
            {
                System.out.printf("\nInforme a posição a ser editada:\n");
                ie = leralu.nextInt();
                System.out.println("Posição"+ie+"-"+lstalu.get(ie).getNome());
                pos = false;
            }
             catch(IndexOutOfBoundsException e)
            {
                System.out.println("Insira um número de posição Existente");
                selalu = 5;
            }
            catch(InputMismatchException e)
            {
                leralu.nextLine();
                System.out.println("caracter invalido.Insira um número de posição Existente");
                selalu = 5;
            }
            while(selalu != 6)
            {
                    System.out.println("Selecione o número do campo que deseja editar:");
                    System.out.println("Nome(1) Telefone(2) Data de nascimento(3) Data de cadastro(4) nota(5) sair(6)");
                    selalu = leralu.nextInt();
                switch(selalu)
                {
                    case 1:
                        System.out.print("Informe o novo nome: ");
                        String newnom = leralu.next();
                        lstalu.get(ie).setNome(newnom);
                        break;
                    case 2:
                        System.out.print("Informe o novo telefone: ");
                        String newtel = leralu.next();
                        lstalu.get(ie).setTel(newtel);
                        break;
                    case 3:
                        try
                        {
                            System.out.print("Informe a nova data de nascimento: ");
                            String newdat_nasct = leralu.next();
                            Date newdat_nasc = df.parse(newdat_nasct);
                            lstalu.get(ie).setData_nasc(newdat_nasc);
                        }
                        catch(Exception e)
                        {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        try
                        {
                            System.out.print("Informe a nova data de cadastro: ");
                            String newdat_cdpt = leralu.next();
                            Date newdat_cdp = df.parse(newdat_cdpt);
                            lstalu.get(ie).setCadastro(newdat_cdp);
                        }
                        catch(Exception e)
                        {
                            System.out.println(e.getMessage());
                        }
                    case 5:
                        System.out.print("Informe a nova nota do aluno: ");
                        String newnott = leralu.next();
                        double newnot = Double.parseDouble(newnott);
                        lstalu.get(ie).setNota(newnot);
                        break;
                    default:
                }

            }
         }
        }
    }
}
