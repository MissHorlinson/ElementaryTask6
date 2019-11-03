package controller;

import model.Ticket;
import service.TicketService;
import util.*;
import java.io.File;
import java.io.IOException;

public class TicketController {

    private Input         input = new Input();
    private Output        output = new Output();
    private Validator     validator = new Validator();
    private TicketService service = new TicketService();
    private Ticket        model;

    public void run() throws IOException {
        output.fileName();
        model = new Ticket(getFile());
        if(validator.fileExist(model.getFile())) {
            if(validator.emptyFile(model.getFile())) {
                choiceMode();
            } else { output.emptyFile(); }
        } else { output.fileError(); }
    }

    public File getFile() {
        // C://Users//Maria//IdeaProjects//ElementaryTask6//tickets.txt
        File file = new File(input.getString());
        return file;
    }

    public void choiceMode() throws IOException {
        while (true) {
            output.description();
            String mode = validator.mode(input.getString());

            if (mode.equals("MOSCOW")) {
                runMoscow();
                break;
            }
            if (mode.equals("PETER")) {
                runPeter();
                break;
            }
            output.nonexistentChoice();
            if(!shouldContinue())
                break;
        }
    }

    public void runMoscow() throws IOException {
        output.luckyTicket(service.moscow(model.getFile()), "Moscow");
    }

    public void runPeter() throws IOException {
        output.luckyTicket(service.peter(model.getFile()), "Peter");
    }

    public boolean shouldContinue() {
        output.shouldContinue();
        return validator.continueRequest(input.getString());
    }
}
