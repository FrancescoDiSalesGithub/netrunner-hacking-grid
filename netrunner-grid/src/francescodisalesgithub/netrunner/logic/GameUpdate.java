package francescodisalesgithub.netrunner.logic;

import francescodisalesgithub.netrunner.model.SystemGrid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GameUpdate
{

    public void createMatrix(SystemGrid grid,int dimension)
    {
        System.out.println("Creation of the grid");

        try
        {
            BufferedReader matrixReader = new BufferedReader(new InputStreamReader(System.in));

            for(int i=0;i<dimension;i++)
            {
                for(int j=0;j<dimension;j++)
                {
                    System.out.println("insert code: ");
                    String number = matrixReader.readLine();

                    if(number.length()>2 || number.length()<=1)
                        System.out.println("error matrix code must have a lenght of 2 characters");

                    grid.getSystemMatrix()[i][j] = number.toUpperCase();
                }
            }


            System.out.println("Setup completed");


        }
        catch(IOException io)
        {

        }

    }

    public void displayMatrix(SystemGrid grid)
    {
        for(int i=0;i<grid.getSystemMatrix().length;i++)
        {
            for(int j=0;j<grid.getSystemMatrix().length;j++)
            {
                System.out.print(grid.getSystemMatrix()[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void hack(SystemGrid grid, int desideratedRowPosition, Stack<String> buffer)
    {
        boolean trovatoRow = false;
        boolean trovatoColumn = false;

        LinkedHashMap<String,String> bufferMap = bufferToMap(buffer);

        for(Map.Entry<String,String> value : bufferMap.entrySet())
        {
            for(int j=0;j<grid.getSystemMatrix().length;j++)
            {
                if(trovatoRow)
                    break;

                if(grid.getSystemMatrix()[desideratedRowPosition][j].equals(value.getValue()))
                {
                    trovatoRow = true;
                    grid.getElementCode().put(grid.getSystemMatrix()[desideratedRowPosition][j],String.valueOf(desideratedRowPosition+1) + " " + String.valueOf(j+1));

                }
            }

            if(trovatoRow)
            {
                for(int k=0;k<grid.getSystemMatrix().length;k++)
                {

                    if(trovatoColumn)
                        break;


                    if(grid.getSystemMatrix()[k][desideratedRowPosition].equals(value.getValue()))
                    {
                        trovatoColumn = true;
                        grid.getElementCode().put(grid.getSystemMatrix()[k][desideratedRowPosition],String.valueOf(k+1) + " " + String.valueOf(desideratedRowPosition+1));

                    }
                }

            }
        }


    }

    public LinkedHashMap<String,String> bufferToMap(Stack<String> buffer)
    {
        LinkedHashMap<String,String> bufferMap = new LinkedHashMap<>();


        for(String value : buffer)
        {
            bufferMap.put(value,value);
        }

        return bufferMap;
    }
    public boolean realHack(SystemGrid grid, Stack<String> buffer)
    {
        for(int j=0;j<grid.getSystemMatrix().length;j++)
        {
            this.hack(grid,j,buffer);
        }

        if(grid.getElementCode().size()<=0)
            return false;

        return true;

    }

    public int initDimensionGrid()
    {
        try
        {
            BufferedReader bufferio = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("how much is big the grid? (matrix must be a squared matrix)");
            int dimensionGrid = Integer.valueOf(bufferio.readLine());


            return dimensionGrid;


        }
        catch(IOException e)
        {

        }
            return 0;

    }

    public void populateBuffer(Stack<String> buffer)
    {
        try
        {
            BufferedReader bufferio = new BufferedReader(new InputStreamReader(System.in));
            int elements = 0;

            System.out.println("how many elements in the buffer");
            elements = Integer.valueOf(bufferio.readLine());

            System.out.println("Insert element you want to search in the buffer in the specific order");

            for(int i=0;i<elements;i++)
            {
                String stackElement = bufferio.readLine();
                buffer.push(stackElement.toUpperCase());
            }


        }
        catch(IOException e)
        {

        }


    }

}
