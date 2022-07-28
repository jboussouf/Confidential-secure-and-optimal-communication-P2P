import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Scanning extends Thread{
    private String id;//A node's identifier

    //Constructor of a scanner object
    public Scanning(String id){
        this.id = id;
    }

    @Override
    //start a scanning thread
    public void run() {
        scanne();
    }
    // find the current ip address
    public String getIP() {
        try {
            Socket s = new Socket();
            s.connect(new InetSocketAddress("google.com", 80));//google.com
            //System.out.println(s.getLocalAddress());
            return s.getLocalAddress().toString();
        }catch (Exception e){
            System.out.println("[!] error in scanning part");
        }
        return null;
    }
    //principal method of scanning
    public void scanne(){
        String myIP = getIP();
        char[] ipChar = myIP.toCharArray();
        myIP ="";
        int s = 0;
        for (int i = 1; i<ipChar.length; i++){
            if (ipChar[i] == '.') {
                s += 1;
            }
            myIP+=ipChar[i];
            if (s == 3)
                break;
        }
        //myIP = "127.0.0.";
        String ip;
        for (int i=1; i<255; i++){
            ip = myIP+i;
            try {
                Socket socket = new Socket(ip, 1234);
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                Packege packege = new Packege("scanning", "just a scanne", this.id, "inconnu");
                oos.writeObject(packege);

            } catch (IOException e) {
                System.out.println("this ip doesn't work: "+ip);
            }
        }
    }
}
