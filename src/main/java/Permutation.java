public class Permutation {


    public static void main(String[] args) {
        String data="abcd";
        generateCombinations(data.toCharArray(),0);
    }


    public static void generateCombinations(char[] data,int index){
        if(index==data.length-1){
            System.out.println(String.copyValueOf(data));
            return;
        }
        for(int i=index;i<data.length;i++){
            doSwap(data,index,i);
            generateCombinations(data,index+1);
            doSwap(data,index,i);
        }
    }

    public static void doSwap(char[] data,int source,int destination){
        char temp=data[source];
        data[source]=data[destination];
        data[destination]=temp;
    }
}