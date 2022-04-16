package Modelo;
import java.util.*;

/**
 * Classe Aluno recebe por herança os atributos da classe pessoa.
 * 
 * @author (Everton Jauer Barlette) 
 * @version (08/01/2022)
 */
public class Aluno extends Pessoa 
{
    private Double nota=0.0;
    /**
     * Construtor para objetos da classe Alunos
     * A clase aluno está herdando os atributos nome,tel,Data_nasc e nota por passagem de 
     * parâmetro. A palavra reservada "super" recebe os parâmetros que foram herdados da 
     * super classe (classe pai).
     */
    public Aluno(String nome,String tel, Date Data_nasc,Date cadastro,Double nota)
    {
        super(nome,tel,Data_nasc,cadastro);
        this.nota=nota;
    }

    /**
     * Métodos getters and setters (get pega parâmetro, atribui para o atributo e retorna o
     * valor. set pega o o parãmetro atribui para o atributo sem retorno de valor(somente
     * ajusta o valor)).
     */
    public void setNota(double nota)
    {
        this.nota=nota; 
    }

    public Double getNota()
    {
        return this.nota;
    }

}
