import java.util.*;
import java.io.*;
class FrogSort {

    private static Scanner sc = new Scanner(System.in);

        private static PrintWriter pw = new PrintWriter(System.out);
        private static int[] frogsWeights;
        private static int[] distanceOfJump;
        private static int[] distance;
        private static int totalJumps=0;


    public static void main(String args[]){
        int cases = sc.nextInt();
        int numOfFrogs;
        sc.nextLine();
        for(int i=0; i<cases; i++){

            numOfFrogs=Integer.parseInt(sc.nextLine());

            frogsWeights = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            distanceOfJump = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            
            distance = new int[distanceOfJump.length];

            for(int j=0; j<distanceOfJump.length; j++){
                distance[j]=j;
            }
            
            frogSort(numOfFrogs);

        }

        pw.flush();

    }

    private static void frogSort(int numOfFrogs){

        for(int i=0; i<numOfFrogs; i++){
            for(int j=0; j<numOfFrogs; j++){
                if(frogsWeights[i]>frogsWeights[j]){
                    while(distance[i]<=distance[j]){
                        distance[i]+=distanceOfJump[i];
                        totalJumps++;
                    }       
                }
            }

            for(int j=0; j<numOfFrogs; j++){
                if(i-j>-1&&frogsWeights[i]<frogsWeights[i-j]&&distance[i]>=distance[i-j]){
                    i=i-j-1;
                }

            }

        }

        pw.println(totalJumps);
        totalJumps=0;

    }

}