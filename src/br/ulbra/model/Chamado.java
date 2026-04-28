package br.ulbra.model;

public class Chamado {

    private Long id;
    private int idUsuario;
    private Usuario usuario;
    private int  idEquipamentoTag;
    private Equipamento equipamentoTag;
    private String problemaRelatado;
    private String diagnosticoTecnico;
    private String prioridade;
    private String status;
    private String dataAbertura;

    
     public Chamado() {
    }

    public Chamado(Long id, int idUsuario,  int idEquipamentoTag,  String problemaRelatado, String diagnosticoTecnico, String prioridade, String status, String dataAbertura) {
        this.id = id;
        this.idUsuario = idUsuario;
      
        this.idEquipamentoTag = idEquipamentoTag;
      
        this.problemaRelatado = problemaRelatado;
        this.diagnosticoTecnico = diagnosticoTecnico;
        this.prioridade = prioridade;
        this.status = status;
        this.dataAbertura = dataAbertura;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getIdEquipamentoTag() {
        return idEquipamentoTag;
    }

    public void setIdEquipamentoTag(int idEquipamentoTag) {
        this.idEquipamentoTag = idEquipamentoTag;
    }

    public Equipamento getEquipamentoTag() {
        return equipamentoTag;
    }

    public void setEquipamentoTag(Equipamento equipamentoTag) {
        this.equipamentoTag = equipamentoTag;
    }

    public String getProblemaRelatado() {
        return problemaRelatado;
    }

    public void setProblemaRelatado(String problemaRelatado) {
        this.problemaRelatado = problemaRelatado;
    }

    public String getDiagnosticoTecnico() {
        return diagnosticoTecnico;
    }

    public void setDiagnosticoTecnico(String diagnosticoTecnico) {
        this.diagnosticoTecnico = diagnosticoTecnico;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    

   
     
    
}