package francescodisalesgithub.netrunner.main;

import francescodisalesgithub.netrunner.logic.GameUpdate;
import francescodisalesgithub.netrunner.model.Graphics;
import francescodisalesgithub.netrunner.model.SystemGrid;

import java.util.*;

public class NetrunnerGrid
{

    public static void main(String args[])
    {

        Graphics.showBanner();


        GameUpdate update = new GameUpdate();

        Stack<String> buffer = new Stack<String>();
        int dimension = update.initDimensionGrid();
        String [][] matrix = new String[dimension][dimension];

        SystemGrid grid = new SystemGrid(buffer,matrix);


        update.populateBuffer(buffer);
        update.createMatrix(grid,dimension);
        update.displayMatrix(grid);


        if(update.realHack(grid,buffer))
        {
            System.out.println("hack found");

            LinkedHashMap<String,String> elements = grid.getElementCode();

            for(Map.Entry<String,String> value : elements.entrySet())
            {
                System.out.println(value.getKey()+ " =  row "+value.getValue() + " column");
            }

        }
        else
            System.out.println("hack not found");


    }
}
