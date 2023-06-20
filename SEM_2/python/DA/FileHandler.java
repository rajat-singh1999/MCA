import java.io.*;

public class FileHandler {
    public synchronized void readFile(String filename){
        try{
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            
            String line = "";
            StringBuilder str = new StringBuilder();
            while((line = br.readLine()) != null){
                str.append(line);
            } 
        }
        catch(IOException ex){
            System.out.println("Some Error ocuured while reading the file!");
        }

    }

    public synchronized void writeFile(String filename, String content){

    }

    public static void main(String args[]){

    }
}
