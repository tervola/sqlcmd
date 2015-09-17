import java.sql.Connection;
import java.util.ArrayList;

/**
 * Created by user on 9/15/2015.
 */
public interface Informer {
    void help();
    void print(String string);
    void printTable(ArrayList<String[]> table);
    int parser(String string);
}
