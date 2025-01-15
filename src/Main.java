import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Repository<Kunde> kundeRepository = new Repository();
        Repository<Produkt> produktRepository = new Repository();
        Controller controller = new Controller(produktRepository, kundeRepository);
        ConsoleView consoleView = new ConsoleView(controller);
        consoleView.run();
    }
}
