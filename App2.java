import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class App2 {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        
        try {
            FileInputStream arquivo = new FileInputStream("arquivo.csv");            
            InputStreamReader reader = new InputStreamReader(arquivo);
            BufferedReader br = new BufferedReader(reader);
            
            String linha = br.readLine();

            OutputStreamWriter arquivoNew = new FileWriter("NewFile.txt");
            OutputStreamWriter arquivoNewSql = new FileWriter("NewSQL.sql");
            

                while(linha != null) {
                    String[] vetFileParts = linha.split(";");
                
                        
                    if ("Vietnam".equals(vetFileParts[10])){
                        String conteudo = vetFileParts[0]+";"+vetFileParts[1]+";"+vetFileParts[7]+";"+vetFileParts[8]+";\n";
                        String conteudoSQL =  "INSERT INTO DadosValues ('FactoryName','FactoryType','City','State') VALUES ("+"'"+vetFileParts[0]+"','"+vetFileParts[1]+"','"+vetFileParts[7]+"','"+vetFileParts[8]+"'"+");\n";
                        
                        arquivoNew.write(String.valueOf(conteudo));
                        arquivoNewSql.write(String.valueOf(conteudoSQL));
                    }
                        

                    linha = br.readLine();
                
                }

            
        
            arquivo.close();

            }catch (IOException e){
                System.out.println("Erro na abertura do arquivo "+ e.getMessage());
                
                }
            
        }

    }
        
    
