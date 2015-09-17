package temp;

/**
 * Created by user on 9/17/2015.
 */
public class temp2 {
    public static void main(String[] args) {
        String string = "Mydb|postgres|Password01";
        String[] list = string.split("\\|");

        for (int i = 0; i <list.length ; i++) {
            System.out.println(list[i]);
        }
    }
}
