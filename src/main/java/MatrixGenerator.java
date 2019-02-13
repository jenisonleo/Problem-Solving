public class MatrixGenerator {

    static int width=2,height=2;
    static int counter=0;
    public static void main(String[] args){
        int[][] data={{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
        recurse(data,0,0);
        System.out.println("count"+" "+counter);
        printmatrix(data);

    }

    public static void recurse(int[] [] data,int row,int col){
        for(int i=0;i<10;i++){
            data[row][col]=i;
            if(row==height && col==width){
                counter++;
//                printmatrix(data);
            }else if(row==height){
                recurse(data,row,col+1);
            }else if(col==width){
                recurse(data,row+1,0);
            }else {
                recurse(data,row,col+1);
            }
        }
    }

    private static void printmatrix(int[][] data){
        System.out.println("new line");
        for(int i=0;i<data.length;i++){
            for(int j=0;j<data[0].length;j++){
                System.out.print(data[i][j]+"    ");
            }
            System.out.println();
        }
    }
}
