package semanaFile;

import java.io.*;

/**
 * @author burca
 */
public class TestaArquivoOtimizado {

    public static void main(String[] args) throws IOException {
        String pathString = "C:/Users/Aluno/Desktop/utfpr-desktop/projeto/escrita/log.txt";
        boolean append = false;
        String str = "Oieee";
        
        File arquivo = new File(pathString);
        ControleBuffered controle = new ControleBuffered(arquivo);
        
        controle.escreveArquivo(arquivo, str, append);
        System.out.println(controle.lerArquivo());
    }
}
