import java.io.*;
import java.util.Scanner;

public class AidenMiner_inventory {

    //Creates File
    static final String fileName = "inventory_team3.txt";
    static File inventory = new File(fileName);

    public static void main(String[] args) throws FileNotFoundException{
        read();
    }

    public void create(){
        
    }

////////////////////
/* Reads every Line 
in Text File*/
////////////////////

    public static void read() throws FileNotFoundException{
    
      Scanner scan = new Scanner(inventory);
      
      while(scan.hasNextLine()) {
          
         String nextLine = scan.nextLine();
         
      }

    }

    public void update() {

    }

    public void delete() {

    }

}