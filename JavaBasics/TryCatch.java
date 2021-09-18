
import java.io.BufferedReader;
import java.io.RandomAccessFile;
import java.util.*;



public class TryCatch {
    public static void main(String[] args) {
        try{
            TryCatch tc = new TryCatch();
            tc.extract();
        }catch(Exception e){
            System.out.println("rohit");
        }
    }

    public   void extract(){

        try{
            int x=5;

            try(RandomAccessFile rf = new RandomAccessFile("name", "rw")) {
                int n = 1;
                for(int i=0;i<20;i++){
                    n++;
                    if(n==5){
                        pageExtract();
                    };
                }
                System.out.println("extract_forloopp");
            }

            System.out.println("after catch");
        }catch (Exception e) {
            System.out.println("int extract catch");
            throw new NullPointerException(e.getMessage());
            //TODO: handle exception
        }finally{
            System.out.println("rr");;
        }
    }

    public static void pageExtract() throws Exception{
        throw new Exception();
        // try {
        //     System.out.println("in page extract");
        //     throw new Exception();
        // } catch (Exception e) {
        //     System.out.println("in pageExtract catch");
        //     throw new Exception();
        //     //TODO: handle exception
        // }
    }
}
