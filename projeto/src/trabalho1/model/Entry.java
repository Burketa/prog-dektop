package trabalho1.model;

/**
 *
 * @author burca
 */
public class Entry {

    private int index;
    private String[] fieldsStr;

    public Entry(String[] strFields, int index) {
        this.fieldsStr = strFields;
        this.index = index;
    }
    
    public String[] getField_str() {
        return fieldsStr;
    }

    public void setField_str(String[] strFields) {
        this.fieldsStr = strFields;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    public String getDataString()
    {
        StringBuilder strBuilder = new StringBuilder();
        
        strBuilder.append(fieldsStr[0]).append(Creature.separator);
        strBuilder.append(fieldsStr[1]).append(Creature.separator);
        strBuilder.append(fieldsStr[2]).append(Creature.separator);
        strBuilder.append(fieldsStr[3]).append(Creature.finalizer);
        
        System.out.println(strBuilder.toString());
        return strBuilder.toString();
    }
    
    @Override
    public String toString()
    {
        StringBuilder strBuilder = new StringBuilder();
        
        strBuilder.append("Nome: ").append(fieldsStr[0]).append("\n\n");
        strBuilder.append("Tipo: ").append(fieldsStr[1]).append("\n\n");
        strBuilder.append("Nível: ").append(fieldsStr[2]).append("\n\n");
        strBuilder.append("Vida: ").append(fieldsStr[3]).append("\n\n");
        
        System.out.println(strBuilder.toString());
        return strBuilder.toString();
    }
}
