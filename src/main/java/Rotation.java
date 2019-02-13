public class Rotation {


    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        printMatrix(matrix);
        for(int i=0;i<matrix.length;i++) {
            for (int j = 0; j < (matrix[0].length/2); j++) {
                int temp=matrix [i] [j];
                matrix[i][j]=matrix [i] [matrix.length-1-j];
                matrix [i] [matrix.length-1-j]=temp;
            }
        }
        printMatrix(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(j>i){
                    int temp=matrix[i] [j];
                    matrix [i] [j]=matrix [j] [i];
                    matrix [j] [i]=temp;
                }
            }
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++) {
                System.out.print(matrix[i] [j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
