package semanaFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author fabricio@utfpr.edu.br
 */
public class TestaArquivo {

    public static void main(String[] args) throws IOException {
        String pathString = "C:/Users/Aluno/Desktop/utfpr-desktop/projeto/escrita";

        File diretorio = new File(pathString);
        diretorio.mkdir();
        
        //1 - ligacao da linguagem com o sistema de arquivos
        File arquivoLog = new File(diretorio, "log.txt");
        //2 - capacidade de escrita de texto em arquivo
        FileWriter escritor = new FileWriter(arquivoLog, true); //segundo parametro eh pra concatenar ou nao, default é false
        //3- capacidade de buffer (RAM)
        BufferedWriter escritorBuffer = new BufferedWriter(escritor);

        File subdir = new File(diretorio, "subdir1");
        subdir.mkdir();

        String[] arquivos = diretorio.list();
        System.out.println(arquivos);

        assert arquivos != null;

        for (String path : arquivos) {
            File filho = new File(diretorio, path);

            System.out.println(filho.getAbsolutePath());
            System.out.println(filho.getParent());
            System.out.println("É diretorio? " + filho.isDirectory());
            System.out.println("É arquivo? " + filho.isFile());
            System.out.println("Tamanho = " + filho.length() + " bytes.\n");
        }

        /*if (arquivoLog.exists()) {
            arquivoLog.delete();
        } else {
            arquivoLog.createNewFile();
        }*/
    }
}
