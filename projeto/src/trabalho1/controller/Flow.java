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

    public static int numRegistros = 0, currentIndex = 0;
    public static ArrayList<Registro> registros = new ArrayList();

    public static File escolherArquivo(int escolha) {
        String homeFolder = System.getProperty("user.dir");
        JFileChooser chooser = new JFileChooser(homeFolder);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int option;
        if (escolha == 1) {
            option = chooser.showSaveDialog(null);
        } else {
            option = chooser.showOpenDialog(null);
        }

        File file = null;
        if (option == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();

            System.out.println("O Arquivo selecionado foi: " + file.getAbsolutePath());
        }
        return file;
    }

    public static boolean escreverTexto(File arquivo, String texto) {
        boolean retorno = false;
        try {
            BufferedWriter bufferedWritter = new BufferedWriter(new FileWriter(arquivo, false));
            bufferedWritter.write(texto);
            bufferedWritter.close();
            retorno = true;
        } catch (IOException erro) {
            System.err.println("Erro na escrita do texto. " + erro);
        } finally {
            return retorno;
        }
    }

    public static String lerTexto(File arquivo) {
        StringBuilder str = new StringBuilder();
        try {
            BufferedReader leitorbuffer = new BufferedReader(new FileReader(arquivo));
            while (leitorbuffer.ready()) {
                str.append(leitorbuffer.readLine()).append("\n");
            }
            leitorbuffer.close();
        } catch (IOException erro) {
            System.err.println("Erro na leitura do arquivo. " + erro);
        } finally {
            return str.toString();
        }
    }

    public static void decodeString(String to_decode) {
        //Vamos decodificar a string lida para mostrar pro usuario.
        String[] data_str = to_decode.split(Criatura.finalizador);

        //Agora vamos separar os campos de cada substring para imprimir corretamente. (Não sei porque o tamanho retorna um a mais do que eu esperava !)
        for (int i = 0; i < data_str.length - 1; i++) {
            String[] fields_str = data_str[i].split(";");   //Separa os campos Nome, Tipo, Nivel e Vida em fields_str[0], fields_str[1], fields_str[2], fields_str[3] respectivamente 

            numRegistros++;

            Registro new_registro = new Registro(fields_str, numRegistros);

            //Adiciona o registro a lista
            addRegistro(new_registro);
        }
    }

    public static String encodeString() {
        String data_str = "";

        for (Registro reg : Flow.registros) {
            data_str += reg.getDataString();
        }

        System.out.println("Final: " + data_str);

        return data_str;
    }

    public static void addRegistro(Registro new_reg) {
        //Checa se a lista esta inicializada, se não estiver, inicialize
        if (registros == null) {
            registros = new ArrayList<>();
        }
        registros.add(new_reg);
    }

    public static void removeRegistro() {
        if (numRegistros > 0) {
            //Como a ação de remover da lista desloca pra esquerda as celulas depois da removida, esse if é nescessario para o bum funcionamento do programa caso o registro retirado seja o de indice 0
            if (currentIndex == 0) {
                registros.remove(Flow.currentIndex);
                numRegistros--;
            } else {
                registros.remove(Flow.currentIndex);
                numRegistros--;
                currentIndex--;
            }
        }
    }

    public static void saveFile(Component parentComponent) {
        //Faz o encode dos registros pra forma certa pra poder ser aberto corretamente na proxima vez
        String str = encodeString();
        File arquivo = escolherArquivo(1);
        if (arquivo != null) {
            if (escreverTexto(arquivo, str)) {
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

    public static void openFile(JTextArea textArea) {
        File arquivo = escolherArquivo(0);
        if (arquivo != null) {
            String str = lerTexto(arquivo);

            //Reseta os registros ja existentes, se houverem, e as variaveis de controle
            registros = new ArrayList<>();
            numRegistros = 0;
            currentIndex = 0;

            //Decodifica a string e guarda em Flow.registros[]
            decodeString(str);

            //Mostra o primeiro registro, se houver
            if (!registros.isEmpty()) {
                textArea.setText(registros.get(0).toString());
            }

        }
    }

    public static void nextEntry(JButton button, JTextArea textArea) {
        if (currentIndex < numRegistros - 1) {
            currentIndex++;
            button.setEnabled(true);
            textArea.setText(Flow.registros.get(Flow.currentIndex).toString());
        }
    }

    public static String addEntry(String name, String type, String level, String life) {
        //Cria uma nova criatura
        Criatura criatura = new Criatura(name, type, level, life);

        //Pega as substrings dos campos da criatura
        String[] subs = {name, type, level, life};

        //Adiciona a nova criatura ao registro
        numRegistros++;
        addRegistro(new Registro(subs, numRegistros));

        //Coloca o novo index como sendo o novo registro
        currentIndex = numRegistros - 1;

        //Mostra na tela o novo registro
        return registros.get(numRegistros - 1).toString();
    }
}
