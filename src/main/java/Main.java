import controller.TicketController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        while (true) {
            TicketController controller = new TicketController();
            controller.run();
            if(!controller.shouldContinue())
                break;
        }
    }
}
