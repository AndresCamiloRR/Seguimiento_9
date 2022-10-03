import java.util.*;
public class SpykeTalks {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String args[]){
        int secretaries = Integer.parseInt(sc.nextLine());
        String ids = sc.nextLine();
        if(ids.split(" ").length==secretaries)sortStringArrayInsertion(ids.split(" "));
    }

    private static void sortStringArrayInsertion(String[] array) {
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

        int counter=0;
        boolean flag=true;
        for(int i = 0; i<array.length&&flag; i++){

            if(i+2<array.length&&!array[i].equals("0")&&array[i]!=null&&array[i].equals(array[i+1])&&array[i].equals(array[i+2])){
                counter=-1;
                flag=false;
            }else if(i+1<array.length&&!array[i].equals("0")&&array[i]!=null&&array[i].equals(array[i+1])){
                counter++;
                i++;
            }
        }

        System.out.println(counter);
    }
}
