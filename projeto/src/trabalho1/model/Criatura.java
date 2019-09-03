package trabalho1.model;

public class Criatura
{
    public static String separador = ";", finalizador = "!";
    
    private StringBuilder stringBuilderDados = new StringBuilder();
    private String nome, tipo, nivel, vida, stringDados;
    
    public Criatura(String nome, String tipo, String nivel, String vida)
    {
        this. nome = nome;
        this.tipo = tipo;
        this.nivel = nivel;
        this.vida = vida;
        
        stringBuilderDados.append(nome).append(separador);
        stringBuilderDados.append(tipo).append(separador);
        stringBuilderDados.append(nivel).append(separador);
        stringBuilderDados.append(vida).append(finalizador);
        
        stringDados = stringBuilderDados.toString();
    }
   
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getVida() {
        return vida;
    }

    public void setVida(String vida) {
        this.vida = vida;
    }
    
    public String getStringDados() {
        return stringDados;
    }

    public void setStringDados(String stringDados) {
        this.stringDados = stringDados;
    }
}
