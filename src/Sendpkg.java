import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.security.KeyPair;

public class Sendpkg extends Thread{
    private String ip; // the receiver ip address
    Packege packege; // the sending objet

    //the contractor of the sendpkg objet
    public Sendpkg(String ip, Packege packege){
        this.ip = ip;
        this.packege = packege;
    }

    //start thread to send a package
    @Override
    public void run() {
        try {
            Socket socket = new Socket(ip, 1234);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            if (packege.getType().equals("message")) {
                for (InfoNodes node:
                     Node.myNodes) {
                    if (node.getId().equals(packege.getReceiver())){
                        node.update(packege.getContent(), packege.getSender());
                        App.chatting(node.getChat());
                        packege = new Packege(packege.getType(), ASEkey.encrypt(packege.getContent(), node.getAes()), packege.getSender(), packege.getReceiver());
                        break;
                    }
                }

            }

            oos.writeObject(this.packege);
            //System.out.println(packege.getType());
        } catch (IOException e) {
            System.out.println("error in the package sending !!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
