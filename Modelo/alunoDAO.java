package Modelo;
import java.util.*;

/**
 * Escreva uma descrição da classe alunoDAO aqui.
 * @author (Everton Jauer Barlette) 
 * @version (05/01/2022)
 */
public class alunoDAO
{
    private static alunoDAO singleton;

    public static alunoDAO getInstance() 
    {
        if(singleton == null) {
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
     * @param  obj objeto Aluno   
     * @return List<Aluno> 
     */
    public List<Aluno> listarAluno()
    {
        return this.lstalu;  
    }

}
