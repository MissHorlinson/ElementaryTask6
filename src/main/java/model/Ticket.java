package model;

import java.io.File;

public class Ticket {
    private File file;

    public Ticket(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
