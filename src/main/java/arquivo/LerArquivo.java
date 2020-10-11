package arquivo;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

public class LerArquivo implements Serializable {

    private static final String IF = "if";
    private static final String ELSE = "else";
    private static final String ELSEIF = "else if";

    public void lerArquivo() throws FileNotFoundException {

        try {
            File fr = new File("../../resources/Calculadora.dart");
            BufferedReader br = new BufferedReader(new FileReader(fr));
            
            while (br.ready()) {
                Object java = ControleFluxo(br.readLine());
                System.out.println(java);

            }
            fr.close();
            br.close();
        } catch (IOException ex) {
        };
    }
}