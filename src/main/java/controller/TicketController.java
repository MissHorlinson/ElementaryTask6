package controller;

import com.sun.istack.internal.Nullable;
import model.Ticket;
import service.TicketService;
import util.*;

import javax.sql.rowset.serial.SerialStruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TicketController {
    private Input         input = new Input();
    private Output        output = new Output();
    private Validator     validator = new Validator();
    private TicketService service = new TicketService();
    private Ticket        model;

    public void choiceMode() throws IOException {
        output.description();
        while (true) {
            if (input.getString().equals("Moscow")) {
                runMoscow();
                break;
            }
            if (input.getString().equals("Piter")) {
                runPiter();
                break;
            }
            output.wrongChoice();
            if(!shouldContinue())
                break;
        }
    }

    public File getFile() {
        // C://Users//Maria//IdeaProjects//ElementaryTask6//tickets.txt
        File file = new File(input.getString());
        return file;
    }

    public void runMoscow() throws IOException {
        output.fileName();
        model = new Ticket(getFile());
        if(validator.fileExist(model.getFile())) {
            if(validator.emptyFile(model.getFile())) {
                output.luckyTicket(service.moscow(model.getFile()), "Moscow");
            } else {
            output.emptyFile();
            }
        } else {
            output.fileError();
        }
    }

    public void runPiter() throws IOException {
        output.fileName();
        model = new Ticket(getFile());
        if(validator.fileExist(model.getFile())) {
            if(validator.emptyFile(model.getFile())) {
                output.luckyTicket(service.piter(model.getFile()), "Piter");
            }
        }
    }

    public boolean shouldContinue() {
        output.shouldContinue();
        return validator.continueRequest(input.getString());
    }

}
