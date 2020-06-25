import org.junit.Test;

import java.io.*;

public class FileTest {
    @Test
    public void test() {
        BufferedInputStream bi = null;
        BufferedOutputStream bo = null;
        long start = System.currentTimeMillis();
        try {
            File file = new File("C:\\Users\\asus\\Desktop\\爱.死亡和机器人.Love.Death.and.Robots.S01E01.720p-官方中字.mp4");
            File file1 = new File("C:\\Users\\asus\\Desktop\\LDR.mp4");

            FileInputStream fi = new FileInputStream(file);
            FileOutputStream fo = new FileOutputStream(file1);

            bi = new BufferedInputStream(fi);
            bo = new BufferedOutputStream(fo);

            byte a[] = new byte[1024];
            int b;
            while ((b = bi.read(a)) != -1) {
                for (int i = 0; i < b; i++) {
                    bo.write(a[i]);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bi != null) {
                try {
                    bi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bo != null) {
                try {
                    bo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    public void test1() {
        BufferedReader bi = null;
        BufferedWriter bw = null;

        try {
            bi = new BufferedReader(new FileReader(new File("hello.txt")));
            bw = new BufferedWriter(new FileWriter(new File("he.txt")));
            String data;
            while ((data = bi.readLine()) != null) {
                bw.write(data);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bi != null) {
                try {
                    bi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test//字节转字符，转换流
    public void test2() throws IOException {
        FileInputStream i = new FileInputStream("hello.txt");
        InputStreamReader ir = new InputStreamReader(i, "utf-8");
        char c[] = new char[10];
        int a;
        while ((a=ir.read(c)) != -1) {
            String s=new String(c,0,a);
            System.out.print(s);
        }
    }
}
