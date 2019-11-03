package service;

import com.sun.istack.internal.Nullable;
import util.*;
import java.io.*;

public class TicketService {

    private Validator   validator = new Validator();
    private MyException exception = new MyException();

    public int moscow(File file) throws IOException {
        int num[][] = ticketToDigit(file);
        int count = 0;
        for (int i = 0; i < num.length; i++) {
            if(getSum(num[i], 0, 2) == getSum(num[i], 3, 5))
                count++;
        }
        return count;
    }

    public int getSum(int[] num, int first, int last) {
        int sum = 0;
        for (int i = first; i <= last; i++) {
            sum += num[i];
        }
        return sum;
    }

    public int peter(File file) throws IOException {
        int num[][] = ticketToDigit(file);
        int count = 0;
        for (int i = 0; i < num.length; i++) {
            if(getPeter(num[i])) {
                count++;
            }
        }
        return count;
    }

    public boolean getPeter(int[] num) {
        int sum0 = 0;
        int sum1 = 0;
        for (int j = 0; j < 6; j++) {
            if (j % 2 == 0) {
                sum0 += num[j];
            } else {
                sum1 += num[j];
            }
        }
        return  (sum0 == sum1);
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

    public char[][] allTickets(File file) throws IOException {
        String [] fileContent = validator.fileContent(readFromFile(file));
        char[][] stringTicket = new char[fileContent.length][];
        for (int i = 0; i < fileContent.length; i++) {
            stringTicket[i] = fileContent[i].toCharArray();
        }
        return stringTicket;
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

    @Nullable
    public BufferedReader fileReader(File file) {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            return bufferedReader;
        } catch (Exception e) {
            exception.fileReadError();
            return null;
        }
    }
}
