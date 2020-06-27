import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class IP_Test {
    public static void main(String[] args) {
        try {
            System.out.println(InetAddress.getLocalHost());
//            System.out.println(InetAddress.ge);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void client(){
        //1.声明服务器的ip和port
        Socket socket=null;
        OutputStream os=null;
        FileInputStream fs=null;
        InputStream is=null;
        InputStreamReader ir=null;
        try {
            socket=new Socket("192.168.1.5",9696);
            os=socket.getOutputStream();
            fs=new FileInputStream("beauty.jpg");
            byte b[]=new byte[10];
            int len;
            while ((len=fs.read(b))!=-1){
                os.write(b,0,len);
            }
            socket.shutdownOutput();
            is = socket.getInputStream();
            ir=new InputStreamReader(is);
            char ch[]=new char[10];
            int leng;
            while ((leng=ir.read(ch))!=-1){
                String s=new String(ch,0,leng);
                System.out.println(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fs!=null){
                try {
                    fs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ir!=null){
                try {
                    ir.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void Server(){
        Socket socket=null;
        ServerSocket ss=null;
        InputStream is=null;
        FileOutputStream fo=null;
        OutputStream os=null;
        try {
            ss=new ServerSocket(9696);
            socket=ss.accept();
            is=socket.getInputStream();
            fo=new FileOutputStream("b1.jpg");
            int len;
            byte c[]=new byte[10];
            while ((len=is.read(c))!=-1){
                fo.write(c,0,len);
            }
            os = socket.getOutputStream();
            os.write("接收到了兄弟。".getBytes());



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ss!=null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is!=null){
                try {
                    is.close();
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
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
