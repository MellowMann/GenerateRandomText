package generaterandomtext;
import java.util.ArrayList;


public class Seed {
    private int length;
    private ArrayList<String> probList;
            
    //work in progress, try to get rid of passing both the string and the string of the whole book
    //alternative method could fix this?
    
    public Seed(int length, ArrayList probList)
    {
        this.probList = probList;
        this.length = length;
        
    }

}

