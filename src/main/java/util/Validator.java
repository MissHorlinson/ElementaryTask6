package util;

import java.io.File;

public class Validator {

    public boolean fileExist(File file) {
        if(file.exists() && file.isFile())
            return true;
        else
            return false;
    }

    public boolean emptyFile(File file) {
        if(file.length() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public String[] fileContent(String string) {
        String[] content = string.split("\\s+");
        return content;
    }

    public String mode(String str) {
       return str.replaceAll("\\s+", "").toUpperCase();
    }

    public boolean continueRequest(String answer) {
        answer = answer.replaceAll("\\s+","").toUpperCase();
        if(answer.equals("Y") || answer.equals("YES"))
            return true;
        else
            return false;
    }
}
