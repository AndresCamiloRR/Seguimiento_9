import java.util.*;
import java.io.*;
//Porfavor recordar quitar el public al introducir en el juez
class Maximum_Weight_Difference {
 
    private static Scanner sc = new Scanner(System.in);
    private static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args){

        int times = Integer.parseInt(sc.nextLine());

        int products;

        int k;

        int[] weigths;

        int group1=0;

        int group2=0;

        for(int i=0; i<times; i++){

            products = sc.nextInt();
            k = sc.nextInt();

            sc.nextLine();

            weigths = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            weigths = sortIntArrayInsertion(weigths);

            if(k<=Math.ceil(weigths.length/2)){

                for(int j=0; j<weigths.length; j++){
                
                    if(j<k)group1+=(weigths[j]);
                    else group2+=(weigths[j]);

                }

            }else{

                for(int j=0; j<weigths.length;j++){
                    if(j>=weigths.length-k)group1+=(weigths[j]);
                    else group2+=(weigths[j]);
                }

            }

            
            
            pw.println(Math.abs(group1-group2)+"\n");
            group1=0;
            group2=0;      
            
        }

        pw.flush();
    }

    private static int[] sortIntArrayInsertion(int[] array) {
        for (int rojo = 1; rojo < array.length; rojo++) {
            int valorRojo = array[rojo];
            int verde = rojo-1;
            int valorVerde;
            while ( verde > -1 && (valorVerde = array[verde])>(valorRojo)) {
                array[verde+1]=valorVerde;
                verde--;
            }
            array[verde+1]=valorRojo;
        }

        return array;

    }
}