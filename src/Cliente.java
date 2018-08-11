public class Cliente {
    private int codigo;
    private String nome;
    private int idade;
    private String sexo;
    private String profissao;

    public Cliente() {
    }

    public Cliente(String nome, int idade, String sexo, String profissao) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.profissao = profissao;
    }

    public Cliente(int codigo, String nome, int idade, String sexo, String profissao) {
        this.codigo = codigo;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.profissao = profissao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
    
    
}