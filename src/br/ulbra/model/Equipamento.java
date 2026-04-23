package br.ulbra.model;


public class Equipamento {

    private int id;
    private String tag_patrimonio;
    private String sala;
 

    
     public Equipamento() {
    }
     
     public Equipamento(int id, String tag_patrimonio, String sala) {

        this.id = id;
        this.tag_patrimonio = tag_patrimonio;
        this.sala = sala;
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag_patrimonio() {
        return tag_patrimonio;
    }

    public void setTag_patrimonio(String tag_patrimonio) {
        this.tag_patrimonio = tag_patrimonio;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }
}
