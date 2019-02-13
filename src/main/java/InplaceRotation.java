import javafx.util.Pair;

public class InplaceRotation {


    private Pair<Integer, Integer> so;

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4, 5,26}, {6, 7, 8, 9, 10,27}, {11, 12, 13, 14, 15,28}, {16, 17, 18, 19, 20,29}, {21, 22, 23, 24, 25,30},{31,32,33,34,35,36}};
        printMatrix(matrix);
        for(int i=0;i<matrix.length/2;i++){
            int counter=0;
            for(int j=i;j<=matrix.length-2-i;j++){
                //extract values
                Pair<Integer,Integer> tl=new Pair<>(i,j);
                Pair<Integer,Integer> tr=new Pair<>(j,matrix.length-1-i);
                Pair<Integer,Integer> br=new Pair<>(matrix.length-1-i,matrix.length-1-i-counter);
                Pair<Integer,Integer> bl=new Pair<>(matrix.length-1-i-counter,i);
                counter++;
                System.out.println(tl.toString()+" "+tr.toString()+" "+bl.toString()+" "+br.toString());
                int trv = copy(matrix[tl.getKey()][tl.getValue()], tr, matrix);
                int brv= copy(trv,br,matrix);
                int blv=copy(brv,bl,matrix);
                copy(blv,tl,matrix);
            }
        }
        System.out.println();
        printMatrix(matrix);
    }
    private static int copy(int source,Pair<Integer,Integer> destination,int[][] matrix){
        int temp=matrix[destination.getKey()][destination.getValue()];
        matrix[destination.getKey()][destination.getValue()]=source;
        return temp;
    }

    private static void printMatrix(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
