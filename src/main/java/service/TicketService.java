package service;

import com.sun.istack.internal.Nullable;
import util.Validator;

import java.io.*;

public class TicketService {
    private Validator validator = new Validator();

    @Nullable
    public BufferedReader fileReader(File file) throws IOException {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            return bufferedReader;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String readFromFile(File file) throws IOException {
        BufferedReader bufferedReader = fileReader(file);
        String content = "";
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            content += line + " ";
        }
        return content;
    }

    public int moscow(File file) throws IOException {
        int num[][] = ticketToDigit(file);
        int count = 0;
        for (int i = 0; i < num.length; i++) {
            if((num[i][0] + num[i][1] + num[i][2]) == (num[i][3] + num[i][4] + num[i][5]))
                count++;
        }
        return count;
    }

    public int piter(File file) throws IOException {
        int num[][] = ticketToDigit(file);
        int count = 0;
        for (int i = 0; i < num.length; i++) {
            if((num[i][0] + num[i][2] + num[i][4]) == (num[i][1] + num[i][3] + num[i][5]))
                count++;
        }
        return count;
    }

    public char[][] allTickets(File file) throws IOException {
        String [] fileContent = validator.fileContent(readFromFile(file));
        char[][] stringTicket = new char[fileContent.length][];
        for (int i = 0; i < fileContent.length; i++) {
            stringTicket[i] = fileContent[i].toCharArray();
        }
        return stringTicket;
    }

    public int[][] ticketToDigit(File file) throws IOException {
        char[][] stringTicket = allTickets(file);
        int[][] intTicket = new int[stringTicket.length][6];
        for (int i = 0; i < stringTicket.length; i++) {
            for (int j = 0; j < 6; j++) {
                intTicket[i][j] = Integer.parseInt(String.valueOf(stringTicket[i][j]));
            }
        }
        return intTicket;
    }
}
