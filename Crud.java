/**
 * Program to perform CRUD (Create, Read, Update, Destroy) operations on excel/csv files
 *
 * @authors Sparkling Barracudas
 */

import java.io.*;
import java.util.Scanner;

public class Crud {

    private static Crud firstInstance = null;

    // Constuctor for crud
    private Crud() {
    }

    /**
     * Creates new instance of Crud and if there is already an instance
     * running, will not do anything
     * 
     * @return returns the instance that's running or creates a new one
     */
    public static Crud getInstance() {
        if (firstInstance == null) {
            firstInstance = new Crud();
        }

        return firstInstance;
    }

    /**
    * Method to create new entry on CSV file.
    * Gets user input and adds data to new line.
    * 
    */
    public static void create(String fileName) throws IOException{
                 
        Scanner sc = new Scanner(System.in);
        System.out.println("Input Product ID: ");
        String id = sc.nextInt();
        System.out.println("Input Quantity: ");
        String quantity = sc.nextLine();
        System.out.println("Input Wholesale Price: ");
        String wholesale = sc.nextDouble();
        System.out.println("Input Sales Price: ");
        String salesPrice = sc.nextDouble();
        System.out.println("Input Supplier ID: ");
        String supplierId = sc.nextLine();
        
        try{
        
          FileWriter writer = new FileWriter(fileName, true);
          writer.append(id);
          writer.append(",");
          writer.append(quantity);
          writer.append(",");
          writer.append(wholesale);
          writer.append(",");
          writer.append(salesPrice);
          writer.append(",");
          writer.append(supplierId);
          writer.append('\n');
        
          writer.close();
        
        }
        
        catch(IOException writer){
        
           System.out.println("IOExcpetion, data maybe incorrect");
        
        }
        
        sc.close();
        
   }

    public void read() {
    }

    public void update() {
    }
    /**
     * A method that takes in the filename and product ID and deletes
     * the data at the ID's location
     * @param id of the the product
     * @param fileName location of the file
     * @throws Exception
     */
    public void delete(String id, String fileName)throws Exception {
    	Scanner sc = new Scanner(new FileInputStream(fileName));
		int dataLocation = 0;
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			String data[] = line.split(",");
			String current = data[0];
			
			if (current.equals(id)) {
				
				Scanner myObj = new Scanner(System.in);
				System.out.println("Press Enter to Comfirm");
				
				String newData = myObj.nextLine();
				System.out.println("Product ID: " + id + " Was Deleted");
				
				break;
			}
			dataLocation += 1;
		}
		sc.close();
		int toEdit = dataLocation;
		File tmp = File.createTempFile("tmp", "");
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		BufferedWriter bw = new BufferedWriter( new FileWriter(tmp));
		
		for(int i = 0; i < toEdit; i++) 
			bw.write(String.format("%s%n" , br.readLine()));
		
		br.readLine();
		
		String l;
		while(null != (l = br.readLine()))
			bw.write(String.format("%s%n", l));
		br.close();
		bw.close();
		
		File oldFile = new File(fileName);
		if(oldFile.delete())
			tmp.renameTo(oldFile);
		

    }

}
