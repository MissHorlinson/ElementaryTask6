package util;

public class Output {

    public void description() {
        System.out.println("Please choice  mode:\n 1) Moscow\n 2) Peter\n -----------------------");
    }

    public void nonexistentChoice() {
        System.out.println("You select nonexistent mode. Please enter y - yes, if you want to try again ");
    }

    public void shouldContinue() {
        System.out.println("Enter y - yes, if you want to continue ?");
    }

    public void fileName() {
        System.out.println("Enter the file name");
    }

    public void fileError() {
        System.out.println("Such file doesn`t exist");
    }

    public void emptyFile() {
        System.out.println("File is empty");
    }

    public void luckyTicket(int count, String method) {
        System.out.println("We have " + count + " lucky tickets by " + method + " method");
    }

    public void fileReadError() {
        System.out.println("Error with reading from file");
    }
}
