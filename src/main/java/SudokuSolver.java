public class SudokuSolver {


    public static void main(String[] args) {
        int[][] matrix = new int[][]{{5,3,0,0,7,0,0,0,0}, {6,0,0,1,9,5,0,0,0}, {0,9,8,0,0,0,0,6,0}, {8,0,0,0,6,0,0,0,3}, {4,0,0,8,0,3,0,0,1},{7,0,0,0,2,0,0,0,6},{0,6,0,0,0,0,2,8,0},{0,0,0,4,1,9,0,0,5},{0,0,0,0,8,0,0,7,9}};
        doVerify(matrix,0,0);
        printmatrix(matrix);
    }
    private static boolean doVerify(int[][] matrix,int row ,int column){
        if(matrix[row][column]==0){
            for(int k=1;k<=9;k++){
                if(islegalvalue(matrix,row,column,k)){
                    matrix[row][column]=k;
                    if((row==(matrix.length-1)) && (column==(matrix[0].length-1))){
                        return true;
                    }else if(row==matrix.length-1){
                        boolean res=doVerify(matrix,row,column+1);
                        if(res){
                            return true;
                        }else {
                            matrix[row][column]=0;
                        }
                    }else if(column==matrix[0].length-1){
                        boolean res=doVerify(matrix,row+1,0);
                        if(res){
                            return true;
                        }else {
                            matrix[row][column]=0;
                        }
                    }else {
                        boolean res=doVerify(matrix,row,column+1);
                        if(res){
                            return true;
                        }else {
                            matrix[row][column]=0;
                        }
                    }
                }
            }
            return false;
        }else {
            if((row==(matrix.length-1)) && (column==(matrix[0].length-1))){
                return true;
            }else if(row==matrix.length-1){
                return doVerify(matrix,row,column+1);

            }else if(column==matrix[0].length-1){
                return doVerify(matrix,row+1,0);

            }else {
                return doVerify(matrix,row,column+1);
            }
        }
    }

    private static boolean isInRow(int[][] matrix,int row ,int value){
        int count=0;
        for(int i=0;i<9;i++){
            if(matrix[row][i]==value){
                count++;
            }
        }
        return count==0;
    }
    private static boolean isInColumn(int[][] matrix,int column ,int value){
        int count=0;
        for(int i=0;i<9;i++){
            if(matrix[i][column]==value){
                count++;
            }
        }
        return count == 0;
    }
    private static boolean isinSubBox(int[][] matrix,int row,int column,int value){
        int x=row/3;
        int y=column/3;
        int count=0;
        for(int i=(x*3);i<((x+1)*3);i++) {
            for (int j = (y * 3); j < ((y + 1) * 3); j++) {
                if(matrix[i][j]==value){
                    count++;
                }
            }
        }
        return count == 0;
    }

    private static boolean islegalvalue(int[][] matrix,int row,int column,int value){
        return isInRow(matrix,row,value)&&isInColumn(matrix,column,value)&&isinSubBox(matrix,row,column,value);
    }

    private static void printmatrix(int[][] matrix){
        System.out.println("new line");
        for(int i=0;i<9;i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}

