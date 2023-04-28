import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class HtmlAnalyzer {

    public static void main(String[] args){
        
        try {
            
            URL url = new URL(args[0]);
            Scanner s = new Scanner(url.openStream());
            
            int count = 0;
            int deepestLevel = 0;
            String text = " ";
            
            while (s.hasNextLine()) {
                String line = s.nextLine().trim();
                
                //Checa se a linha é uma abertura de tag html e começa a contar o nível de profundidade.
                if (line.startsWith("<") && !line.startsWith("</")) {
                    count = count + 1;
                    
                } 
                //Checa se a linha é um fechamento de tag html e subtrai um nível de profundidade.
                else if (line.startsWith("</")) {
                    count = count - 1;
                }
                //Se não for abertura nem fechamento de tag html, compara o nível de profundidade do texto da linha atual.
                else {
                    //Pula linha em branco
                    if (line.length() == 0) {
                        continue;
                    }
                    //Compara nível de profundidade do texto.
                    else if (count > deepestLevel) {
                        deepestLevel = count;
                        text = line;
                    } 
                }
            }
            
            System.out.println(text);
            
        } catch (MalformedURLException e) {
            System.out.println("URL connection error");
        } catch (IOException e) {
            System.out.println("URL connection error");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("URL connection error");
        }
                
    }
    
}
