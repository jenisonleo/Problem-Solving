import java.util.ArrayList;

public class FindBest {
    public static ArrayList<Movie> movie;
    public static int  maxMovies=0;

    public static void main(String[] args){
        Movie[] movies=new Movie[5];
        movies[0]=new Movie("jenison",1,365);
        movies[1]=new Movie("leo",2,200);
        movies[2]=new Movie("vonoth",3,100);
        movies[3]=new Movie("vonoth",201,320);
        movies[4]=new Movie("vonoth",101,220);
        permute(movies,0);
        System.out.println(movie.toString());
    }

    public static void permute(Movie[] movies,int tracker){
        if(tracker!=movies.length-1){
            for(int i=tracker;i<movies.length;i++){
                swap(movies,i,tracker);
                permute(movies,tracker+1);
                swap(movies,i,tracker);
            }
        }else {
            ArrayList<Movie> m=new ArrayList<>();
            int dateIndex=0;
            int counter=0;
            for(int i=0;i<movies.length;i++){
                if(movies[i].start>dateIndex){
                    dateIndex=movies[i].end;
                    counter++;
                    m.add(movies[i]);
                }
            }
            if(counter>maxMovies){
                maxMovies=counter;
                movie=m;
            }
        }
    }

    public static void swap(Movie[] movies,int from,int to){
        Movie temp=movies[from];
        movies[from]=movies[to];
        movies[to]=temp;
    }

    public static class Movie {
        public String name;
        public int start;
        public int end;

        public Movie(String name, int start, int end){

            this.name = name;
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return new String(name+" "+start+" "+end);
        }
    }

}
