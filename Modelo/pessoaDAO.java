package Modelo;
import java.util.*;

/**
 * Escreva uma descrição da classe pessoaDAO aqui.
 * @author (Everton Jauer Barlette) 
 * @version (05/01/2022)
 */
public class pessoaDAO
{
    private static pessoaDAO singleton;

    public static pessoaDAO getInstance() 
    {
        if(singleton == null) {
            singleton = new pessoaDAO();
        } 
        return singleton;
    }

    private final List<Pessoa> lstpes = new ArrayList<Pessoa>();
    /**
     * Construtor para objetos da classe pessoaDAO
     */
    private pessoaDAO()
    {

     
    }

    /**
     * Método que grava um objeto pessoa no ArrayList
     * @param  obj objeto Pessoa    
     */
    public void cadastrarPessoa(Pessoa objpes)
    {
        this.lstpes.add(objpes);
    }

    /**
     * Método que retorna a lista com as pessoas 
     * @param  obj objeto Pessoa   
     * @return List<Pessoa> 
     */
    public List<Pessoa> listarPessoa()
    {
        return this.lstpes;  
    }

}
