package trabalho1.model;

public class Criatura
{
    private String nome, tipo, nivel, vida, string_dados;
    public static String separador = ";", finalizador = "!";
    
    public Criatura(String nome, String tipo, String nivel, String vida)
    {
        this. nome = nome;
        this.tipo = tipo;
        this.nivel = nivel;
        this.vida = vida;
        string_dados = nome + separador + tipo + separador + nivel + separador + vida + finalizador;
    }
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the nivel
     */
    public String getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    /**
     * @return the vida
     */
    public String getVida() {
        return vida;
    }

    /**
     * @param vida the vida to set
     */
    public void setVida(String vida) {
        this.vida = vida;
    }
    
    public String getStringDados() {
        return string_dados;
    }

    public void setStringDados(String string_dados) {
        this.string_dados = string_dados;
    }
}
