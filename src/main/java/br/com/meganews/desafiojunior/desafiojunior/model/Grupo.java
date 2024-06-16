package br.com.meganews.desafiojunior.desafiojunior.model;

public class Grupo {

    public long idGrupo;
    private String descricao;

    public Grupo(){

    }
    public Grupo(long idGrupo, String descricao){
        this.idGrupo = idGrupo;
        this.descricao = descricao;
    }

    public long getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(long idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
