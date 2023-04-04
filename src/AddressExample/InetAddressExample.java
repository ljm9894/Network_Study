package AddressExample;
import java.net.InetAddress;
import java.net.UnknownHostException;
public class InetAddressExample {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        try{
            InetAddress local = InetAddress.getLocalHost();
            System.out.println("내컴퓨터 IP 주소" + local.getHostAddress());

            InetAddress[] isArr = InetAddress.getAllByName("www.naver.com");
            for(InetAddress remote:isArr){
                System.out.println("www.naver.com IP 주소"+ remote.getHostAddress());
            }

        }catch(UnknownHostException e){
            e.printStackTrace();
        }
    }
}
