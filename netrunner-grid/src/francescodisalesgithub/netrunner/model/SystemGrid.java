package francescodisalesgithub.netrunner.model;

import java.util.*;

public class SystemGrid
{

    private Stack<String> buffer;
    private String [][] systemMatrix;

    private LinkedHashMap<String,String> elementCode;

    public SystemGrid(Stack<String> buffer,String [][] systemMatrix)
    {
        this.buffer = buffer;
        this.systemMatrix = systemMatrix;

        this.elementCode = new LinkedHashMap<>();

    }

    public Stack<String> getBuffer() {
        return buffer;
    }

    public void setBuffer(Stack<String> buffer) {
        this.buffer = buffer;
    }

    public String[][] getSystemMatrix() {
        return systemMatrix;
    }

    public void setSystemMatrix(String[][] systemMatrix) {
        this.systemMatrix = systemMatrix;
    }


    public LinkedHashMap<String,String> getElementCode() {
        return elementCode;
    }

    public void setElementCode(LinkedHashMap<String,String> elementCode) {
        this.elementCode = elementCode;
    }
}
