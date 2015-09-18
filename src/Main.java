import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by user on 8/28/2015.
 */
public class Main {
    static String SERVER_NAME = "localhost";
    static String DATABASE_NAME = "Mydb";
    static String PORT = "5433";
    static String DRIVER = "jdbc:postgresql://";
    static String USER_NAME = "postgres";
    static String PASSWORD = "Password01";
    static boolean USING_SCANNER = false; //false - hardcoding connection params
    static AuthCredential authCredential;
    static Informer informer;

    public static void main(String[] args) {

        authCredential = new AuthCredential(DRIVER,SERVER_NAME,PORT,DATABASE_NAME,USER_NAME,PASSWORD,USING_SCANNER);
        informer = new InformerImpl(authCredential);

        int code = 0;
        while (code >=0 ) {
            informer.print("Input command:");
            try {
                code = informer.parser(new Scanner(System.in).nextLine());
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
            if(code == 0) informer.print("Error command. Try again or type \"exit\"");
        }
    }
}
