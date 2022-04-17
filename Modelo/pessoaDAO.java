package Modelo;
import java.util.*;

/**
 * Classe que possui os métodos que instanciam o objeto , criam a sua arraylist e retornam sua lista 
 * @author (Everton Jauer Barlette) 
 * @version (05/01/2022)
 */
public class pessoaDAO
/**
 * Método que usa o padrão singleton (padrão criado para quando se precisa apenas de uma instância).
 */
{
    private static pessoaDAO singleton;
    
    public static  pessoaDAO getInstance()
    /**
     * Metodo que instancia o objeto.
     */
    {
        if(singleton == null) {
            // Esse if  Caso a classe já tenha sido instanciada o atributo não será nulo, assim retorna-se a única instância já criada.
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
     * @return List<Pessoa> 
     */
    public List<Pessoa> listarPessoa()
    {
        return this.lstpes;  
    }

}
