package ThreadingPractice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.concurrent.BlockingQueue;

public class WriteThread extends Thread{
    public void run(){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/java/ThreadingPractice/Copyhello.txt"))){
                        BlockingQueue<String> queue = Main.queue;
            String line ;
            while ((line = queue.take())!= null){
                bufferedWriter.write(line+"\n");
                if(queue.isEmpty()&& !Main.reading || "poisonpill".toUpperCase().equals(line)){
                    break;
                }
            }
        }catch(Exception e){
            System.out.println("Exception in WriteThread:"+e.getMessage());
        }
    }
}
