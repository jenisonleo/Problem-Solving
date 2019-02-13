import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Lander {
    
    public static void main(String[] args) {
//        int[][] matrix = new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        int[][] matrix = new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};
        System.out.println("size" + " " + matrix.length);
        System.out.println("size" + " " + matrix[0].length);
        int x = matrix.length;
        int y = matrix[0].length;
        for (int i = 0; (i < (x + y) - 1); i++) {
            int x1,x2,y1,y2;
            if(i<x){
                x1=i;
                x2=0;
            }else {
                x1=x-1;
                x2=i-x+1;
            }
            if(i<y){
                y1=0;
                y2=i;
            }else {
                y1=i-y+1;
                y2=y-1;
            }
            int max=x1-y1+1;
            for(int j=1;j<=max;j++){
                System.out.print(matrix[x1][x2]+" ");
                x1--;
                x2++;
            }
            System.out.println('\n');
        }
    }
}
