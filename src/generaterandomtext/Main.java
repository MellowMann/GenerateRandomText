
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generaterandomtext;
import java.util.Scanner;
/**
 *
 * @author isedgewick17
 */
public class Main {

    static private Scanner reader = new Scanner(System.in);
    public static void main(String[] args) {
        String test = "test";
        String filePath = "C:\\Users\\Ian Sedgewick\\Documents\\NetBeansProjects\\OGPC-2016-Java\\GenerateRandomText\\book1";
        System.out.println("please input the level you would like to generate text with:");
        int randomLevel = reader.nextInt();
        System.out.println("please input the length of the string you would like to generate:");
        int length = reader.nextInt();
        RandomTextGenerator rtg = new RandomTextGenerator(filePath,randomLevel, length);
        //System.out.println(rtg.generateText());
        //for(int i=0;i<10;i++)
            //System.out.println(rtg.nextChar("n"));
    }
    
}
