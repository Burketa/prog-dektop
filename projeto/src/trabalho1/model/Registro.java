/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1.model;

/**
 *
 * @author Burca
 */
public class Registro {

    private int index;
    private String[] strFields;

    public Registro(String[] field_str, int index) {
        this.strFields = field_str;
        this.index = index;
    }
    
    public String[] getField_str() {
        return strFields;
    }

    public void setField_str(String[] field_str) {
        this.strFields = field_str;
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
        
        strBuilder.append(strFields[0]).append(Criatura.separador);
        strBuilder.append(strFields[1]).append(Criatura.separador);
        strBuilder.append(strFields[2]).append(Criatura.separador);
        strBuilder.append(strFields[3]).append(Criatura.separador);
        
        System.out.println(strBuilder.toString());
        return strBuilder.toString();
    }
    
    @Override
    public String toString()
    {
        StringBuilder strBuilder = new StringBuilder();
        
        strBuilder.append("Nome: ").append(strFields[0]).append("\n\n");
        strBuilder.append("Tipo: ").append(strFields[1]).append("\n\n");
        strBuilder.append("Nível: ").append(strFields[2]).append("\n\n");
        strBuilder.append("Vida: ").append(strFields[3]).append("\n\n");
        
        System.out.println(strBuilder.toString());
        return strBuilder.toString();
    }
}
