/*
 * The MIT License
 *
 * Copyright 2019 burca.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package semanaFile;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author burca
 */
public class ControleBuffered {

    private File arquivo = null;

    public ControleBuffered(File arquivo) {
        this.arquivo = arquivo;
    }

    public String lerArquivo() {
        //String string = "";
        StringBuilder string = new StringBuilder();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(arquivo);
            bufferedReader = new BufferedReader(fileReader);

            while (bufferedReader.ready()) {
                string.append(bufferedReader.readLine()).append("\n");
            }
            
            bufferedReader.close();
            
        } catch (IOException exp) {
            System.err.println(exp);
        } finally {
            return string.toString();
        }
    }

    public void escreveArquivo(File file, String str, boolean append) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            
            bufferedWriter.write(str);
            
            bufferedWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(ControleBuffered.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
