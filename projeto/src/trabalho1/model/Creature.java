package trabalho1.model;

public class Creature
{
    public static String separator = ";", finalizer = "!";
    
    private StringBuilder stringBuilder = new StringBuilder();
    private String name, type, level, life, dataStr;
    
    public Creature(String name, String type, String level, String life)
    {
        this. name = name;
        this.type = type;
        this.level = level;
        this.life = life;
        
        stringBuilder.append(name).append(separator);
        stringBuilder.append(type).append(separator);
        stringBuilder.append(level).append(separator);
        stringBuilder.append(life).append(finalizer);
        
        dataStr = stringBuilder.toString();
    }
   
    public String getNome() {
        return name;
    }
    
    public void setNome(String nome) {
        this.name = nome;
    }

    public String getTipo() {
        return type;
    }

    public void setTipo(String tipo) {
        this.type = tipo;
    }

    public String getNivel() {
        return level;
    }

    public void setNivel(String nivel) {
        this.level = nivel;
    }

    public String getVida() {
        return life;
    }

    public void setVida(String vida) {
        this.life = vida;
    }
    
    public String getStringDados() {
        return dataStr;
    }

    public void setStringDados(String stringDados) {
        this.dataStr = stringDados;
    }
}
