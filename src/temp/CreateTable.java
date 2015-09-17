package temp;

/**
 * Created by user on 9/15/2015.
 */
public class CreateTable {
    public static void main(String[] args) {
        int width = 20;
        String string = "string";
        drawTable(string, width);
    }

    private static void drawTable(String string, int width) {
        int count = 3;
        String formater = createFormater(count);

        System.out.println(formater);
        for (int i = 0; i < 10; i++) {
            print(string, width,formater);
        }
    }

    private static String createFormater(int count) {
        String formater = "|";
        for (int i = 0; i < count; i++) {
            formater += " %10s |";
        }
        return formater + "\n";
    }

    private static void print(String string, int width, String formater) {
        System.out.format(formater, string + "11", width + 100000, "data2");
    }
}
