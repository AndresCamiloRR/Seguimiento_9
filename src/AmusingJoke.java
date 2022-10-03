import java.util.*;

public class AmusingJoke {

    private static Scanner sc = new Scanner(System.in);
    public static void main(String args[]){
        String name1 = sc.nextLine();
        String name2 = sc.nextLine();
        name1=name1.concat(name2);
        String weird = sc.nextLine();
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> wNames = new ArrayList<String>();
        for(int i=0; i < name1.length(); i++){
            names.add(""+(name1.charAt(i)));
        }
        for(int i=0; i < weird.length(); i++){
            wNames.add(""+(weird.charAt(i)));
        }

        if(sortStringArrayInsertion(names).equals(sortStringArrayInsertion(wNames))){
            System.out.println("YES");
        }else{System.out.println("NO");}

    }

    private static ArrayList<String> sortStringArrayInsertion(ArrayList<String> array) {
        for (int rojo = 1; rojo < array.size(); rojo++) {
            String valorRojo = array.get(rojo);
            int verde = rojo-1;
            String valorVerde;
            while ( verde > -1 && (valorVerde = array.get(verde)).compareTo(valorRojo)> 0 ) {
                array.set(verde+1, valorVerde);
                verde--;
            }
            array.set(verde+1, valorRojo);
        }

        return array;
    }
}
