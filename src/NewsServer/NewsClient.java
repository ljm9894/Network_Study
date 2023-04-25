package NewsServer;

import javax.xml.crypto.Data;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class NewsClient {
    public static void main(String[] args) {
        try{
            //DatagramSocket 생성
            DatagramSocket datagramSocket = new DatagramSocket();

            //구독하고 싶은 뉴스 주제 보낵
            String data = "정치";
            byte[] bytes= data.getBytes("UTF-8");
            DatagramPacket sendPacket = new DatagramPacket(bytes,0,bytes.length
            ,new InetSocketAddress("localhost",50003));
            datagramSocket.send(sendPacket);
            while(true){
                DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);
                datagramSocket.receive(receivePacket);
                String news = new String(receivePacket.getData(),0,receivePacket.getLength(),"UTF-8");
                System.out.println(news);
                //10번째 뉴스를 받으면 while문 종료
                if(news.contains("뉴스10")){
                    System.out.println("[클라이언트]연결 종료");
                    break;
                }
            }
            //Datagramsocket닫기
            datagramSocket.close();
        }catch (Exception e){
            System.out.println("클라이언트"+e.getMessage());
        }
    }
}
