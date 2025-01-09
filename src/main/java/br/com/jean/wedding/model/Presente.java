package br.com.jean.wedding.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tbl_presente")
public class Presente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_presente")
    private Integer id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "link_foto")
    private String linkFoto;
    @Column(name = "preco")
    private Double preco;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLinkFoto() {
        return linkFoto;
    }

    public void setLinkFoto(String linkFoto) {
        this.linkFoto = linkFoto;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Presente presente = (Presente) o;
        return Objects.equals(id, presente.id) && Objects.equals(nome, presente.nome) && Objects.equals(descricao, presente.descricao) && Objects.equals(linkFoto, presente.linkFoto) && Objects.equals(preco, presente.preco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, linkFoto, preco);
    }
}
