import java.io.*;
import java.nio.*;
import java.util.*;

public class diskScheduling {
    public static void main(String[] args) throws FileNotFoundException {
        //Begin parsing user's choice for algorithm
        int userAlgorithm = Integer.parseInt(args[0]);
        System.out.println("/////Debug stuff/////");
        System.out.println("User picked: " + userAlgorithm); //User's choice of Algorithm
        
        //Import scheduling file
        File f = new File(args[1]);


        try{
            //Read file and store into an array
            Scanner sc = new Scanner(f);
            ArrayList<String> list = new ArrayList<String>();

            while (sc.hasNextLine()) {
                list.add(sc.nextLine());
            }

            //Variables used for algorithms
            Integer startPos = Integer.parseInt(list.get(0)); //Variable for starting position
            Integer direction = Integer.parseInt(list.get(1)); //Variable for direction
            String requests = list.get(2); 
            String[] requestArray = requests.split(" "); //Array for requests *Example requestArray[0] *


                //Algorithms *These should be in a class/method*
                if (userAlgorithm == 0){
                    System.out.println("Algorithm: FCFS");
                }
                else if (userAlgorithm == 1){
                    System.out.println("Algorithm: SSTF");
                    System.out.println("Starting position: " + startPos); 
                    System.out.println("Direction: " + direction);
                    //System.out.println(requestArray[9]);
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