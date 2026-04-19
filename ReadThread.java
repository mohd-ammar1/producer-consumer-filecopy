package ThreadingPractice;

import java.io.BufferedReader;
import java.io.FileReader;


public class ReadThread extends Thread {
    public void run(){
        try(BufferedReader buffread = new BufferedReader(new FileReader("src/main/java/ThreadingPractice/hello.txt"))){
            String line;
            while((line = buffread.readLine()) != null){
                Main.queue.put(line);
            }
            Main.queue.put("poisonpill".toUpperCase());
        }catch(Exception e){
            System.out.println("Exception While Reading File: "+e.getMessage());
        }
    }
}
