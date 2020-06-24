import org.junit.Test;

import java.io.*;

public class FileTest {
    public static void main(String[] args) {
        File file=new File("hello.txt");
        System.out.println(file.getAbsolutePath());
    }
    @Test
    public void test(){
        File file=new File("hello.txt");
        FileReader fr=null;
        try {
            fr=new FileReader(file);
            char da[]=new char[5];
            int data=fr.read(da);
            while (data!=-1){
                for (int i = 0; i <data; i++) {
                    System.out.print(da[i]);
                }
                data=fr.read(da);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fr!=null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //System.out.println(file.getAbsolutePath());
    }
    @Test
    public void test1(){
        FileWriter fw=null;
        try {
            File file=new File("world.txt");
            fw=new FileWriter(file,true);
            fw.write("232323");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fw!=null)
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void test2(){
        FileReader fr=null;
        FileWriter fw=null;
        try {
            File file =new File("hello.txt");
            File file1=new File("hello1.txt");
            fr=new FileReader(file);
            fw=new FileWriter(file1);
            char c[]=new char[8];
            int data;
            while ((data=fr.read(c))!=-1){
                for (int i = 0; i <data ; i++) {
                    fw.write(c[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fr!=null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fw!=null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    @Test
    public void test3(){
        FileInputStream fi=null;
        FileOutputStream fo=null;
        try {
            File file=new File("3232.jpg");
            File file1=new File("32cpoy.jpg");
            fi=new FileInputStream(file);
            fo=new FileOutputStream(file1);
            byte[] bytes=new byte[10];
            int a;
            while ((a=fi.read(bytes))!=-1){
                for (int i = 0; i <a ; i++) {
                    fo.write(bytes[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fi!=null){
                try {
                    fi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fo!=null){
                try {
                    fo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
