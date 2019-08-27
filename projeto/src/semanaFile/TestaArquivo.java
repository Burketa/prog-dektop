package semanaFile;

import java.io.File;
import java.io.IOException;

/**
 * @author fabricio@utfpr.edu.br
 */
public class TestaArquivo {

    public static void main(String[] args) throws IOException {
        String pathString = "C:/Users/Aluno/Desktop/utfpr-desktop/projeto";
        
        File diretorio = new File(pathString);
        diretorio.mkdir();       

        File arquivoLixo = new File(diretorio, "lixo.txt");
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
        
        if (arquivoLixo.exists()) {
            arquivoLixo.delete();
        } else {
            arquivoLixo.createNewFile();
        }
    }
}
