import java.io.*;
import java.nio.*;
import java.util.*;

public class diskScheduling {
    public static void main(String[] args) throws FileNotFoundException {
        //Begin parsing user's choice for algorithm
        int userAlgorithm = Integer.parseInt(args[0]);
        System.out.println("/////Debug stuff/////");
        System.out.println("User picked: " + userAlgorithm); //User's choice of Algorithm
        
        //Begin finding file path
        File f = new File(args[1]);
        String absolute = f.getAbsolutePath();
        System.out.println("File path is: " + absolute); //File path

        try{
            //Read file and store into an array
            Scanner input = new Scanner(f);
            List<String> list = new ArrayList<String>();

            while (input.hasNextLine()) {
                list.add(input.nextLine());
            }

            //Variables used for algorithms
            Integer startPos = Integer.parseInt(list.get(0));
            Integer direction = Integer.parseInt(list.get(1));
            //Integer requests = Integer.parseInt(list.get(2));
            //Array requests needs to be transposed from x x x x x to:
            //x
            //x
            //x
            //x
            //x

            
            //System.out.println(startPos); 
            //System.out.println(direction);
            //System.out.println(requests); //Need to convert to an array

                //Algorithms *These should be in a class/method*
                if (userAlgorithm == 0){
                    System.out.println("Algorithm: FCFS");
                }
                else if (userAlgorithm == 1){
                    System.out.println("Algorithm: SSTF");
                }
                else if (userAlgorithm == 2){
                    System.out.println("Algorithm: LOOK"); 
                }
                else if (userAlgorithm == 3){
                    System.out.println("Algorithm: C-LOOK");    
                }

        }
        catch (FileNotFoundException ex)  
        {
            System.out.println("My code sucks"); // insert code to run when exception occurs
        }

        
    }
}