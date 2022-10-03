import java.util.*;
import java.io.*;
class Racing_Horses {
    
    private static Scanner sc = new Scanner(System.in);
    private static PrintWriter pw = new PrintWriter(System.out);
    public static void main(String args[]){
        int cases = Integer.parseInt(sc.nextLine());

        int[] skill;

        int horses;

        int dif=0;

        for(int i=0; i<cases; i++){
            horses = sc.nextInt();

            sc.nextLine();

            skill = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            pw.println(sortIntegerArraySelection(skill));

            dif=0;
                
        }
        

        pw.flush();
        

    }

    private static int sortIntegerArraySelection(int[] array){
        int diff=-1;
        for(int rojo = 0 ; rojo < array.length-1 ; rojo++) {
            for (int azul = rojo+1; azul < array.length; azul++) {
                if((Math.abs(array[rojo]-array[azul])<diff||diff==-1)){
                    diff=Math.abs(array[rojo]-array[azul]);
                }else if(array[rojo]==array[azul]){
                    diff=0;
                }
            }
            
        }

        return diff;
    }

}