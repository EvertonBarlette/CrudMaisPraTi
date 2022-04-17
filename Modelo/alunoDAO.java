package Modelo;
import java.util.*;

/**
 *  Classe que possui os métodos que instanciam o objeto , criam a sua arraylist e retornam sua lista 
 * @author (Everton Jauer Barlette) 
 * @version (05/01/2022)
 */
public class alunoDAO
/**
 * Método que usa o padrão singleton (padrão criado para quando se precisa apenas de uma instância).
 */
{
    private static alunoDAO singleton;

    public static alunoDAO getInstance()
    /**
     * Metodo que instancia o objeto.
     */
    {
        if(singleton == null) {
            // Esse if  Caso a classe já tenha sido instanciada o atributo não será nulo, assim retorna-se a única instância já criada.
            singleton = new alunoDAO();
        } 
        return singleton;
    }

    private final List<Aluno> lstalu = new ArrayList<Aluno>();
    /**
     * Construtor para objetos da classe alunoDAO
     */
    private alunoDAO()
    {

     
    }

    /**
     * Método que grava um objeto Aluno no ArrayList
     * @param  obj objeto Aluno    
     */
    public void cadastrarAluno(Aluno objalu)
    {
        this.lstalu.add(objalu);
    }

    /**
     * Método que retorna a lista com os Alunos    
     * @return List<Aluno> 
     */
    public List<Aluno> listarAluno()
    {
        return this.lstalu;  
    }

}
