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
                        public static void SSTF2(int request[], int head) 
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
                            System.out.println("Total number of head movements is: " + seek_count);  
                        } 
                        public static void main(String[] args) 
                        { 

                     }
                    }
                