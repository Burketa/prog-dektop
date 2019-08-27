package semanaFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 * @author burca
 */
public class TestaArquivoOtimizado {

    public static void main(String[] args) throws IOException {
        //String pathString = "C:/Users/Aluno/Desktop/utfpr-desktop/projeto/escrita/log.txt";
        File arquivo = new File("C:/Users/Aluno/Desktop/utfpr-desktop/projeto/escrita/log.txt");
        ControleBuffered controle = new ControleBuffered(arquivo);
        String conteudo = controle.lerArquivo();
        System.out.println(conteudo);
        /*//1 - ligacao da linguagem com o sistema de arquivos
        File arquivoLog = new File(diretorio, "log.txt");
        //2 - capacidade de escrita de texto em arquivo
        FileWriter escritor = new FileWriter(arquivoLog, false); //segundo parametro eh pra concatenar ou nao, default é false
        //3- capacidade de buffer (RAM)
        BufferedWriter escritorBuffer = new BufferedWriter(escritor);
        
        File subdir = new File(diretorio, "subdir1");
        subdir.mkdir();
        
        String[] arquivos = diretorio.list();
        System.out.println(arquivos);
        
        assert arquivos != null;
        
        escritorBuffer.write("Log criado em " + new Date(System.currentTimeMillis()));
        escritorBuffer.newLine();
        escritorBuffer.newLine();
        
        for (String path : arquivos) {
        File filho = new File(diretorio, path);
        
        escritorBuffer.write(filho.getAbsolutePath());
        escritorBuffer.newLine();
        escritorBuffer.write("" + filho.getParent());
        escritorBuffer.newLine();
        escritorBuffer.write("É diretorio? " + filho.isDirectory());
        escritorBuffer.newLine();
        escritorBuffer.write("É arquivo? " + filho.isFile());
        escritorBuffer.newLine();
        escritorBuffer.write("Tamanho = " + filho.length() + " bytes./n");
        escritorBuffer.flush();
        }
        escritorBuffer.newLine();
        escritorBuffer.write("Fim.");
        escritorBuffer.close();
        
        /*if (arquivoLog.exists()) {
        arquivoLog.delete();
        } else {
        arquivoLog.createNewFile();
        }*/
        //}*/
    }
}
