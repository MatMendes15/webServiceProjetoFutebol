package ps2.restapidb;

import javax.persistence.*;

@Entity
@Table(name = "jogadores")
public class Jogador {

    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private int idade;
    private String posicao;

    public Jogador() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }
}
