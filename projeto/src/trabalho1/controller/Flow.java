package trabalho1.controller;

import java.awt.Component;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import trabalho1.model.*;

public class Flow {

    public static int numEntrys = 0, currentIndex = 0;
    public static ArrayList<Entry> entrys = new ArrayList();

    public static void openFile(JTextArea textArea) {
        File file = chooseFile(0);
        if (file != null) {
            String str = readText(file);

            //Reseta os registros ja existentes, se houverem, e as variaveis de controle
            entrys = new ArrayList<>();
            numEntrys = 0;
            currentIndex = 0;

            //Decodifica a string e guarda em Flow.registros[]
            decodeString(str);

            //Mostra o primeiro registro, se houver
            if (!entrys.isEmpty()) {
                textArea.setText(entrys.get(0).toString());
            }
        }
    }

    public static void saveFile(Component parentComponent) {
        //Faz o encode dos registros pra forma certa pra poder ser aberto corretamente na proxima vez
        String str = encodeString();
        File arquivo = chooseFile(1);
        if (arquivo != null) {
            if (writeText(arquivo, str)) {
                JOptionPane.showMessageDialog(
                        parentComponent, "Texto Escrito com sucesso!");
            } else {
                JOptionPane.showMessageDialog(
                        parentComponent, "Erro ao escrever Texto!");
            }
        } else {
            JOptionPane.showMessageDialog(
                    parentComponent, "Erro ao selecionar arquivo para escrita!");
        }
    }

    public static File chooseFile(int choice) {
        String homeFolder = System.getProperty("user.dir");

        JFileChooser chooser = new JFileChooser(homeFolder);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int option = choice == 1 ? chooser.showSaveDialog(null) : chooser.showOpenDialog(null);

        File file = null;
        if (option == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();

            System.out.println("O Arquivo selecionado foi: " + file.getAbsolutePath());
        }
        return file;
    }

    public static boolean writeText(File file, String text) {
        boolean isWritten = false;
        try {
            BufferedWriter bufferedWritter = new BufferedWriter(new FileWriter(file, false));
            bufferedWritter.write(text);
            bufferedWritter.close();
            isWritten = true;
        } catch (IOException erro) {
            System.err.println("Erro na escrita do texto. " + erro);
        } finally {
            return isWritten;
        }
    }

    public static String readText(File file) {
        StringBuilder str = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (bufferedReader.ready()) {
                str.append(bufferedReader.readLine()).append("\n");
            }
            bufferedReader.close();
        } catch (IOException erro) {
            System.err.println("Erro na leitura do arquivo. " + erro);
        } finally {
            return str.toString();
        }
    }

    public static void decodeString(String decodeStr) {
        //Vamos decodificar a string lida para mostrar pro usuario.
        String[] dataStr = decodeStr.split(Creature.finalizer);

        //Agora vamos separar os campos de cada substring para imprimir corretamente. (Não sei porque o tamanho retorna um a mais do que eu esperava !)
        for (int i = 0; i < dataStr.length - 1; i++) {
            String[] fieldsStr = dataStr[i].split(";");   //Separa os campos Nome, Tipo, Nivel e Vida em fields_str[0], fields_str[1], fields_str[2], fields_str[3] respectivamente 

            numEntrys++;

            Entry entry = new Entry(fieldsStr, numEntrys);

            //Adiciona o registro a lista
            addEntry(entry);
        }
    }

    public static String encodeString() {
        String dataStr = "";

        for (Entry entry : Flow.entrys) {
            dataStr += entry.getDataString();
        }

        System.out.println("Final: " + dataStr);

        return dataStr;
    }

    public static void addEntry(Entry newEntry) {
        //Checa se a lista esta inicializada, se não estiver, inicialize
        if (entrys == null) {
            entrys = new ArrayList<>();
        }
        entrys.add(newEntry);
    }

    public static void removeEntry() {
        if (numEntrys > 0) {
            //Como a ação de remover da lista desloca pra esquerda as celulas depois da removida, esse if é nescessario para o bum funcionamento do programa caso o registro retirado seja o de indice 0
            if (currentIndex == 0) {
                entrys.remove(Flow.currentIndex);
                numEntrys--;
            } else {
                entrys.remove(Flow.currentIndex);
                numEntrys--;
                currentIndex--;
            }
        }
    }

    public static void nextEntry(JButton button, JTextArea textArea) {
        if (currentIndex < numEntrys - 1) {
            currentIndex++;
            button.setEnabled(true);
            textArea.setText(Flow.entrys.get(Flow.currentIndex).toString());
        }
    }

    public static String addEntry(String name, String type, String level, String life) {
        //Cria uma nova criatura
        Creature creature = new Creature(name, type, level, life);

        //Pega as substrings dos campos da criatura
        String[] subs = {name, type, level, life};

        //Adiciona a nova criatura ao registro
        numEntrys++;
        addEntry(new Entry(subs, numEntrys));

        //Coloca o novo index como sendo o novo registro
        currentIndex = numEntrys - 1;

        //Mostra na tela o novo registro
        return entrys.get(numEntrys - 1).toString();
    }
}
