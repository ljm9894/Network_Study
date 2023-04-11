package ServerSocketExample;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.spec.RSAOtherPrimeInfo;

public class ClientExam {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("localhost", 50001);
            System.out.println("[클라이언트] 연결 성공");

//            //데이터 보내기
//            String sendMessage = "나는 자바가 좋아~~";
//            OutputStream os = socket.getOutputStream();
//            byte[] bytes = sendMessage.getBytes("UTF-8");
//            os.write(bytes);
//            os.flush();
//
//            //데이터 받기
//            InputStream is = socket.getInputStream();
//            bytes = new byte[1024];
//            int readByteCount = is.read(bytes);
//            String receiveMessage =new String(bytes, 0, readByteCount, "UTF-8");


            //데이터 보내기
            String sendMessage = "나는 자바가 좋아~~";
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(sendMessage);
            dos.flush();
            System.out.println("[클라이언트] 데이터 보내기 :"+sendMessage);

            //데이터 받기
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String receiveMessage = dis.readUTF();
            System.out.println("[클라이언트] 데이터 받음 : " + receiveMessage);

            socket.close();
            System.out.println("[클라이언트] 연결 끊음");

        }catch(UnknownHostException e){
            //IP 또는 도메인 표기 방법이 잘못되었을 경우
            System.out.println("UnknownException:" + e.toString());
        }catch(IOException e){
            //IP 또는 Port 번호가 존재하지 않을 경우
            System.out.println("IOException: "+ e.toString());
            throw new RuntimeException(e);
        }
    }
}
