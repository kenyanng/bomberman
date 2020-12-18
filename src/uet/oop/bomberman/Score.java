package uet.oop.bomberman;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Score {

    public static String path = "res\\Score.txt";

    public static void write( int point)  {
        File file =new File (path);
        try (FileWriter fw = new FileWriter (file,false);
             BufferedWriter bf = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bf)) {
            pw.println(point);
        } catch (Exception e){
            e.getMessage();
        }
    }
    public static String Read(){
        String str = null;
        File file =new File (path);
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext())  {
                str = sc.nextLine();
            }
        } catch (Exception e){
            e.getMessage();
        }

        return str;
    }
}

