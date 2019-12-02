import java.io.*;

public class DiskSched {
    public static void main(String[] args) {
        //Begin parsing user's choice for algorithm
        int userAlgorithm = Integer.parseInt(args[0]);
        System.out.println("User picked: " + userAlgorithm); //User's choice of Algorithm
        
        //Begin finding file path
        File f = new File(args[1]);
        String absolute = f.getAbsolutePath();
        System.out.println("File path is: " + absolute); //File path
        System.out.println("");
        
        //Read file and store into 3 arrays. (1st = initial position, 2nd = direction, 3rd= requests)


        //Algorithms *These should be in a class/method*
        if (userAlgorithm == 0){
            System.out.println("FCFS");
        }
        else if (userAlgorithm == 1){
            System.out.println("SSTF");
        }
        else if (userAlgorithm == 2){
            System.out.println("LOOK");   
        }
        else if (userAlgorithm == 3){
            System.out.println("C-LOOK");    
        }
    }
}