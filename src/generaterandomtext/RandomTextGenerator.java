
package generaterandomtext;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class RandomTextGenerator {

    private int stemLength;
    private int resultLength;
    private Scanner fileReader;
    private File file;
    private String book;
    
    //k is the length of the stem(the stem is the amount of letters after the seed)
    //the seed is the letter which to which the stem is compared to 
    public RandomTextGenerator(String filePath,int k, int length)
    {
        
        file = new File(filePath);
        try{
            fileReader= new Scanner(file);
        }
        catch(FileNotFoundException e)
        {
            //THIS SHOULD NEVER HAPPEN, THE USER DOES NOT GIVE FILES
            System.out.println("Caught File Not Found Exception: " + e.getMessage());
        }
        book = makeString();
        resultLength = length;
        stemLength = k;
    }
    
    
    public String makeString()
    {
        String str="";
        fileReader.useDelimiter("\\z");
        str += fileReader.next();
        return str;
    }
    
    //must compare seed->stem->seed->stem... to the end of the book
    /*
    Methods:
        use getIndexOf(stem) to go through the array in chunks and find what letters are usually returned(make a stem class that is flexible to deal with this??)
    */
    public String generateText()
    {
        String str="";
        int firstIndex = (int)(Math.random()*(book.length()-(stemLength*2)));
        str += book.substring(firstIndex, firstIndex + stemLength);
        int checkLength = 0;
        while(resultLength > str.length())
        {
            str += nextChar(str.substring(str.length()-stemLength, str.length()));
            if (checkLength == str.length()-1) {
                str = str.substring(0,str.length());
            }
            checkLength = str.length();
        }
        return str;
    }
    //possibility of temp probList being 0
    public String nextChar(String seed)
    {
        ArrayList<String> tempList = new ArrayList<String>();
        int index = seed.indexOf(book);
        int i = 0;
        while (index != -1) {
            tempList.add(book.substring(index + stemLength, index + stemLength + 1));
            i += index;
            index = seed.indexOf(book.substring(i));
        }
        if(tempList.size()==0)
            return "";
        return tempList.get((int) (Math.random()*(tempList.size())));
    }
    
}
