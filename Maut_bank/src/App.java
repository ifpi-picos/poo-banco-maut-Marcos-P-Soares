import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        
        
        scanner.close();
    }
}
