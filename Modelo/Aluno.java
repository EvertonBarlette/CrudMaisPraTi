package Modelo;
import java.util.*;

/**
 * Escreva uma descrição da classe Aluno aqui.
 * 
 * @author (Everton Jauer Barlette) 
 * @version (08/01/2022)
 */
public class Aluno extends Pessoa 
{
    private Double nota=0.0;
    /**
     * Construtor para objetos da classe Alunos
     */
    public Aluno(String nome,String tel, Date Data_nasc,Date cadastro,Double nota)
    {
        super(nome,tel,Data_nasc,cadastro);
        this.nota=nota;
    }

    public void setNota(double nota)
    {
        this.nota=nota; 
    }

    public Double getNota()
    {
        return this.nota;
    }

}
