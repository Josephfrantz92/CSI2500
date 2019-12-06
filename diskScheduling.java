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
                    class pos { 
                        // This variable is for the difference between head position and next number 
                        int dist = 0;  
                        // This will be true if next number has been recieved 
                        boolean accessed = false;  
                    }
                    public class SSTF {
                    // Calculates difference of each number from the head position 
                        public static void calcDifference(int queue[],int head, pos diff[]) 
                        { 
                            for (int i = 0; i < diff.length; i++) 
                                diff[i].dist = Math.abs(queue[i] - head); 
                        } 
                        // This finds new number at minimum distance from head 
                        public static int Min(pos diff[]) 
                        { 
                            int start = -1, minimum = Integer.MAX_VALUE; 
                            for (int i = 0; i < diff.length; i++) { 
                                if (!diff[i].accessed && minimum > diff[i].dist) { 
                                    minimum = diff[i].dist; 
                                    start = i; 
                                } 
                            } 
                            return start; 
                        } 
                        public static void SSTF(int request[], int head) 
                        { 
                            if (request.length == 0) 
                                return; 
                            // creates array from pos. class     
                            pos diff[] = new pos[request.length];  
                            // initializes array 
                            for (int i = 0; i < diff.length; i++)  
                                diff[i] = new pos(); 
                            // Seek operations counter 
                            int seek_count = 0;  
                            // Stores disk access sequence
                            int[] seek_sequence = new int[request.length + 1];  
                            for (int i = 0; i < request.length; i++) { 
                                seek_sequence[i] = head; 
                                calcDifference(request, head, diff); 
                                int index = Min(diff); 
                                diff[index].accessed = true; 
                                // total count increase
                                seek_count += diff[index].dist;  
                                // next number is now new "head" 
                                head = request[index];  
                            } 
                            // for last number 
                            seek_sequence[seek_sequence.length - 1] = head;  
                            System.out.println("Total number of seek operations = " + seek_count);  
                        } 
                        //public static void main(String[] args) 
                       // { 
                            // request array 
                           // int arr[] = { 131, 14, 43, 97, 72, 105, 104, 81, 116, 39, 86, 112, 93, 24, 58, 141, 135, 155, 50, 71 };  
                            //SSTF(arr, 122); 
                       // }
                    }
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
