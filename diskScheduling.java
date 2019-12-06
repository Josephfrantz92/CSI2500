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
            Integer head = Integer.parseInt(list.get(0)); //Variable for starting position
            Integer direction = Integer.parseInt(list.get(1)); //Variable for direction
            String requests = list.get(2); 
            int[] numbers = Arrays.stream(requests.split(" ")).mapToInt(Integer::parseInt).toArray();  
            Arrays.sort(numbers);
            

                //Algorithms *These should be in a class/method*
                if (userAlgorithm == 0){
                    System.out.println("Algorithm: FCFS");
                    int diff = 0;
                    int seek = 0;
                    for(int j=0; j<19; j++){
                        diff = Math.abs(numbers[j+1] - numbers[j]);
                        seek += diff;
                    }
                        System.out.println("Total head movement is: " + seek);
                }
                else if (userAlgorithm == 1){
                    System.out.println("Algorithm: SSTF");
                    SSTF.SSTF2(numbers, head);
                }
                else if (userAlgorithm == 2){
                    System.out.println("Algorithm: LOOK"); 
                }
                else if (userAlgorithm == 3){
                    System.out.println("Algorithm: C-LOOK");
                    int low = 0;
                    int high = 199;
                    int[] above = new int[20];
                    int aboveIndex = 0;
                    int[] below = new int[20];
                    int belowIndex = 0;
                    //loop to sort into Above and Below head
                    for (int j=0; j<19; j++){
                        if(numbers[j] >= head){
                            above[aboveIndex] = numbers[j];
                            aboveIndex++;
                        }else{
                            below[belowIndex] = numbers[j];
                            belowIndex++;
                        }
                    }
                System.out.println("Numbers above head: " + Arrays.toString(above));
                System.out.println("Numbers below head: " + Arrays.toString(below));
                }

        }
        catch (FileNotFoundException ex)  
        {
            System.out.println("Error"); // insert code to run when exception occurs
        }

        
    }
}