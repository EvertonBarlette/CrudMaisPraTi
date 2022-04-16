package Controle;
import java.util.*;
import Modelo.*;
import java.text.*;
import Visualiza.*;
/**
 * Escreva uma descrição da classe pessoaControle aqui.
 * 
 * @author (Everton Jauer Barlette) 
 * @version (05/01/2022)
 */
public class pessoaControle
{
    Scanner lerpes = new Scanner(System.in);
    int selpes;

    /**
     * Método que coleta os dados para cadastrar uma pessoa 
     * 
     * @param String nome da pessoa 
     * @param String telefone da pessoa
     * @param Date Data de nascimento da pessoa
     * @param Date Data do cadastro da pessoa
     * @return boolean true se gravou ou false se deu bug 
     */
    public boolean criaPessoa(String nom,String tel,Date Ddn,Date cdt)
    {
        // Criar o objeto pessoa , ajustar os dados
        Pessoa objpes = new Pessoa(nom,tel,Ddn,cdt);

        pessoaDAO.getInstance().cadastrarPessoa(objpes);
        return true;
    }

    /**
     * 
     */
    public void mostraPessoa()
    {
        int ip=1;

        List<Pessoa> lstpes = pessoaDAO.getInstance().listarPessoa();
        for(Pessoa pessoa : lstpes) 
        { 
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println("==============================PESSOA "+ip+"===================");
            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("Telefone: " + pessoa.getTel());
            System.out.println("Data de nascimento: " + df.format(pessoa.getData_nasc()));
            System.out.println("Data de cadastro: " + df.format(pessoa.getCadastro()));
            ip++;
        }
        if(lstpes.isEmpty())
        {
            System.out.println("=================A lista de pessoas está vazia===========");
        }
    }

    public void deletaPessoa()
    {
        boolean pos = true;
        while(pos)
        {
        int i=0;   
        List<Pessoa> lstpes = pessoaDAO.getInstance().listarPessoa();    
        for(Pessoa pessoa : lstpes)
        {
            System.out.println("Posição"+i+"-"+pessoa.getNome());
            i++;
        }
        if(lstpes.isEmpty())
        {
            System.out.println("A lista de pessoas esta vazia ");
        }
        else
        {
            try
            {
                System.out.printf("\nInforme a posição a ser excluída:\n");
                i = lerpes.nextInt();
                // [ D ] remove o i-ésima pessoa da lista
                lstpes.remove(i);
                pos = false;
            }
            catch(IndexOutOfBoundsException e)
            {
                System.out.println("Insira um número de posição Existente");
            }
            catch(InputMismatchException e)
            {
                lerpes.nextLine();
                System.out.println("caracter invalido.Insira um número de posição Existente");
            }
        }
        }
        }

    public void editaPessoa()
    {
        boolean pos = true;
        while(pos)
        {
        int ie=0;
        selpes=0;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        List<Pessoa> lstpes = pessoaDAO.getInstance().listarPessoa();

        for(Pessoa pessoa : lstpes)
        {
            System.out.println("Posição"+ie+"-"+pessoa.getNome());
            ie++;
        } 
        if(lstpes.isEmpty())
        {
            System.out.println("A lista de pessoas esta vazia ");
        }
        else
        {
            try
            {
                System.out.printf("\nInforme a posição a ser editada:\n");
                ie = lerpes.nextInt();
                System.out.println("Posição"+ie+"-"+lstpes.get(ie).getNome());
                pos = false;
            }
            catch(IndexOutOfBoundsException e)
            {
                System.out.println("Insira um número de posição Existente");
                selpes = 5;
            }
            catch(InputMismatchException e)
            {
                lerpes.nextLine();
                System.out.println("caracter invalido.Insira um número de posição Existente");
                selpes = 5;
            }
        
            while(selpes != 5)
            { 
                    System.out.println("Selecione o número do campo que deseja editar:");
                    System.out.println("Nome(1) Telefone(2) Data de nascimento(3) Data de cadastro(4) sair(5)");
                    selpes = lerpes.nextInt();
                switch(selpes)
                {
                    case 1:
                        System.out.print("Informe o novo nome: ");
                        String newnom = lerpes.next();
                        lstpes.get(ie).setNome(newnom);
                        break;
                    case 2:
                        System.out.print("Informe o novo telefone: ");
                        String newtel = lerpes.next();
                        lstpes.get(ie).setTel(newtel);
                        break;
                    case 3:
                        try
                        {
                            System.out.print("Informe a nova data de nascimento: ");
                            String newdat_nasct = lerpes.next();
                            Date newdat_nasc = df.parse(newdat_nasct);
                            lstpes.get(ie).setData_nasc(newdat_nasc);
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
                            String newdat_cdpt = lerpes.next();
                            Date newdat_cdp = df.parse(newdat_cdpt);
                            lstpes.get(ie).setCadastro(newdat_cdp);
                        }
                        catch(Exception e)
                        {
                            System.out.println(e.getMessage());
                        } 
                    default:
                }
            }
        }
        }
    }

    public boolean validaNome(String nome) 
    {
        return nome.matches("^[A-Za-záàâãéèêíïóôõöúüçñÁÀÂÃÉÈÍÏÓÔÕÖÚÜÇÑ ]+$");
    }

    public boolean validaTelefone(String telefone)
    {
        return telefone.matches("^[(][1-9]{2}[)][0-9]{5}[-][0-9]{4}|[(][1-9]{2}[)][0-9]{4}[-][0-9]{4}$"); 
    }
    public boolean validaData(String data)
    {
        return data.matches("^(0[1-9]|[12][0-9]|[3][01])/(0[1-9]|1[012])/\\d{4}$");
    }
}

