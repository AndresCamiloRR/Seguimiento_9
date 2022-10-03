import java.util.*;
import java.io.*;
public class Barrels {

    private static Scanner sc = new Scanner(System.in);
    private static PrintWriter pw = new PrintWriter(System.out);
    public static void main(String args[]){
        int cases = Integer.parseInt(sc.nextLine());
        long[] water;
        int pourTimes;
        int barrels;
        long sum=0;
        for(int i=0; i<cases; i++){
            barrels = sc.nextInt();
            pourTimes = sc.nextInt();
            sc.nextLine();
            water = Arrays.stream(sc.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
              
            water = quickSort(water, 0,water.length-1);

            for(int j=0, w=1; j<=pourTimes; j++){
                sum+=water[water.length-w];
                w++;
            }

            pw.println(sum);

            sum=0;
                
        }
        

        pw.flush();
        

    } 

    public static long[] quickSort(long[]A, int first, int last){
        long piv = (A[first] + A[last])/2;
        int i = first;
        int j = last;

        while (i<j){
            while (A[i]<piv) i++;
            while (A[j]>piv) j--;
            if(i<=j){
                long x = A[i];
                A[i] = A[j];
                A[j] = x;
                i++;
                j--;
            }
        }
        if(first<j){
            A = quickSort(A, first, j);
        }
        if(last>i){
            A = quickSort(A, i, last);
        }

        return A;
    }

}