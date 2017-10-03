package ch1_arrays_and_strings;

public class RotateMatrix1p7 {
	
	
    //    1  2  3  4  5
    //    6  7  8  9  10
    //    11 12 13 14 15
    //    16 17 18 19 20
    //    21 22 23 24 25
    
    //rotated: 
    //    21 16 11 6  1
    //    22 17 12 7  2
    //    23 18 13 8  3
    //    24 19 14 9  4
    //    25 20 15 10 5
    
    // it's a member variable
    public static  int[][] rotate(int[][] mMatrix){ 
        // lol we're doing this iteratively and it seems easier than the recursive method
        //I guess my first thought wasnt to do it recursively
        //i guess ill stop typing until i figure out the recursive way
        // the only thing it doesn't pass by reference are primatives
        // all objects are by refernce, including arrays
        // hahaha, what don't you like? and yeah, even arrays are pass by refernce
        //ibelieve you but thats so weird i never thought about it
        // which way are we rotating? i'll look up above. clockwise
        //why did you do the /2 and *2 stuff? 
        //ohhhh// cause the outer loop represents going through each layer
        
        
        int matrixLength = mMatrix.length; 
        if (mMatrix != null && matrixLength > 1) {
            // dont need this if we're
            // int[][] finalMatrix = new int[matrixLength][matrixLength];
            
            // for the number of outer rows we need to considerdi
            for(int i = 0; i < mMatrix.length/2; i++){
            
                // for the appropriate lenght/height of this "inner matrix" 
                for(int j = i; j < mMatrix[0].length - i - 1; j++){
                    // temporarily store upper left value
                    int tempUpperLeft = mMatrix[i][j];
                    
                    // move bottom left to upper left... this isn't rig
                    mMatrix[i][j] = mMatrix[matrixLength - j - 1][i];
                    
                    // i = 0; j = 1
                    // move bottom right to bottom left
                    mMatrix[matrixLength - j - 1][i] = mMatrix[matrixLength - i - 1][matrixLength - j - 1];
                    
                    // move top right to bottom right
                    mMatrix[matrixLength - i - 1][matrixLength - j - 1] = mMatrix[j][matrixLength - i - 1];
                    
                    // move top left (in temp var) to top right
                    mMatrix[j][matrixLength - i - 1] = tempUpperLeft;
                    
                    
                    printMatrix(mMatrix);
                }
                
            }
        }
        
        
        
        return mMatrix;
    }
    
    public static void printMatrix(int[][] arr) {
    
        for(int row = 0; row < arr.length; ++row) {
            for (int col = 0; col < arr.length; ++col) {
                System.out.print(arr[row][col]);
                if (arr[row][col] > 9) {
                	System.out.print(" ");
                } else {
                	System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[][] arr1 = new int[5][5];
        
        for(int row = 0; row < arr1.length; ++row) {
            for (int col = 0; col < arr1.length; ++col) {
                arr1[row][col] = col + row*arr1.length + 1;
            }
        }
        
        printMatrix(arr1);
        printMatrix(rotate(arr1));
        
        
//        int[][] arr2 = new int[4][4];
//        
//        for(int row = 0; row < arr2.length; ++row) {
//            for (int col = 0; col < arr2.length; ++col) {
//                arr2[row][col] = col + row*arr2.length + 1;
//            }
//        }
//        
//        printMatrix(arr2);
//        rotate(arr2);
//        printMatrix(arr2);
        
    }
    
}