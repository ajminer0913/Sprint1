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
