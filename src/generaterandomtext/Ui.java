
package generaterandomtext;
import java.util.Scanner;


public class Ui {
    //this class needs to manage the book files
    
    
    private Scanner reader = new Scanner(System.in);
    private RandomTextGenerator rtg;
    //maintain a collection of books/string paths
    private String[] fileList;
    
    public void setFileList()
    {
        fileList = new String[3];
        fileList[0]="";
        fileList[1]="";
        fileList[2]="";
    }
    public void setFileList(String[] arr)
    {
        fileList=arr;
    }
    
    public void userInterface()
    {
        setFileList();
        int input;
        int k=0;
        boolean keepRunning=true;
        
        while(keepRunning)
        {
            System.out.println("Input the corresponding number to preform the following...");
            System.out.println("0: Exit program");
            for(int i=0;i<fileList.length;i++)
                System.out.println(i+1+ ": Generate random text from this book");
            input = reader.nextInt();
            if(input ==0)
                keepRunning =false;
            else
            {
                System.out.println("\n please input the level you would like to generate text with.");
                k = reader.nextInt();
                rtg = new RandomTextGenerator(fileList[input],k);
            }
        }
    }
    
    
}
