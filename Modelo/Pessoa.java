package Modelo;
import java.util.*;

/**
 * Criação da classe Pessoa e seus atributos (nome,tel,Data_nasc,cadastro).
 * 
 * @author (Everton Jauer Barlette) 
 * @version (05/01/2022)
 */
public  class Pessoa
{
    private String nome;
    private String tel;
    private Date Data_nasc;
    private Date cadastro;
    /**
     * Contrutor de inicialização básica sem parâmetros mas com o mesmo nome do construtor 
     * abaixo (polimorfismo).
     */
    public Pessoa( )
    {
        this.nome = "";
        this.tel ="";
        this.Data_nasc = new Date();
        this.cadastro = new Date();
    }

    /**
     * Construtor com a passagem de parâmetros
     * @param (String,String,Date,Date)
     */

    public Pessoa(String nome,String tel, Date Data_nasc,Date cadastro )
    {
        this.nome=nome;
        this.tel=tel;
        this.Data_nasc=Data_nasc;
        this.cadastro=cadastro;
    }

    /**
     * Métodos getters and setters (get pega parâmetro, atribui para o atributo e retorna o
     * valor. set pega  o parâmetro atribui para o atributo sem retorno de valor(somente
     * ajusta o valor)).
     */
    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getNome()
    {
        return this.nome;
    }

    public void setTel(String tel)
    {
        this.tel = tel;
    }

    public  String getTel()
    {
        return this.tel;
    }

    public void setData_nasc(Date Data_nasc)
    {
        this.Data_nasc = Data_nasc;
    }

    public  Date getData_nasc()
    {
        return this.Data_nasc; 
    }

    public void setCadastro(Date cadastro)
    {
        this.cadastro = cadastro;
    }

    public  Date getCadastro()
    {
        return this.cadastro;
    }

       
   

}
