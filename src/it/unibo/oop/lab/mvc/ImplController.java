package it.unibo.oop.lab.mvc;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ImplController implements Controller {
    private final List<String> stringHistory = new LinkedList<>();
    private String nextString;

    @Override
    public void setNextStringToPrint(String nextString) {
        this.nextString = Objects.requireNonNull(nextString, "Does not accept null value");        
    }

    @Override
    public String getStringToPrint() {
                return this.nextString;
    }

    @Override
    public List<String> getPrintedStringHistory() {
        
        return stringHistory;
    }

    @Override
    public void printCurrentString() {
        if (this.nextString == null) {
            throw new IllegalStateException("There is no string set");
        }
        stringHistory.add(this.nextString);
        System.out.println(this.nextString);
                
    }
    

}
