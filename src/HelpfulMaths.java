import java.util.*;
public class HelpfulMaths {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String args[]){
        String operations = sc.nextLine();
        sortStringArrayInsertion(operations.split("\\+"));
    }

    private static void sortStringArrayInsertion(String[] array) {
        String out="";
        for (int rojo = 1; rojo < array.length; rojo++) {
            String valorRojo = array[rojo];
            int verde = rojo-1;
            String valorVerde;
            while ( verde > -1 && (valorVerde = array[verde]).compareTo(valorRojo)> 0 ) {
                array[verde+1]=valorVerde;
                verde--;
            }
            array[verde+1]=valorRojo;
        }

        for(String s: array){
            if(s==array[array.length-1])out+=s;
            else  out+=s+"+";
        }

        System.out.println(out);
    }
}
