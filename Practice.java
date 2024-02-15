import java.util.Arrays;

public class Practice{
    public static void main(String[] args) {
        
        String[] someArray = {'a', 'c', 'a', 'b', 'a', 'd'};
    
        int[] someArray2 = new int[10];
        int index = 0;
        for (int i=0; i<someArray.length; i++){
            int currentElement = someArray[i];
            boolean duplicate=false;
            for (int j=0; j<someArray2.length; j++){
                if (currentElement == someArray2[j]){
                    duplicate = true;
                    break;
                }
            }
            if (duplicate==false){
                someArray2[index]=someArray[i];
                System.out.println(someArray[i]);
                index+=1;
            }
            
        }

        // int[][] numArray = {{1, 2, 3}, {4, 5}, {6, 7}};
        // int collectiveSum = 0;
        // for (int m=0; m<numArray.length; m++){
        //     int currentSum = 0;
        //     for (int n=0; n<numArray[m].length; n++){
        //         System.out.println(numArray[m][n]);
        //         currentSum+=numArray[m][n];
        //     }
        //     System.out.println("Current Sum: " + currentSum);
        //     collectiveSum+=currentSum;

        // }
        // System.out.println("Collective Sum Sum: " + collectiveSum);

        // int[][] matrix = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}};
        // int[][] updatedMatrix = new int[3][3];
        // for (int r = 0; r < 3; r++){
        //     // int[] currentRow = new int[3];
        //     for (int s=0; s < 3; s++){
        //         updatedMatrix[r][s] = matrix[s][r];
        //         // System.out.println(matrix[s][r]);
        //     }

        // }
        // for (int r = 0; r < 3; r++){
        //     // int[] currentRow = new int[3];
        //     for (int s=0; s < 3; s++){
        //         System.out.println(updatedMatrix[r][s]);
        //     }

        // }

    }
}

// {{name, address}, {rushan, ahmedabad}, {maneet, delhi}}