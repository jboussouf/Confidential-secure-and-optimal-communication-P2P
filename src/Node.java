import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.Base64;

public class Node extends Thread{

    private String id; //A node's identifier

    private KeyPair keys; //RSA key pair for asymmetric encryption
    public static ArrayList<InfoNodes> myNodes = new ArrayList<InfoNodes>(); //a list that records information about the associated nodes.
    //constrictor of a network node
    public Node(String id){
        this.id = id;
        try {
            this.keys = RSAKeyGenerate.generateRSAKkeyPair();
        } catch (Exception e) {
            System.out.println("Key error !");
        }
    }
    //to start the wire under the channel
    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(1234);
            while (true) {
                Socket s = ss.accept();
                String ip = s.getRemoteSocketAddress().toString();
                ip = ip.substring(1, ip.indexOf(":"));
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                Packege packege = (Packege) ois.readObject();
                System.out.println(packege.getType());
                if (packege.getType().equals("scanning")){
                    boolean flag = true;
                    for (InfoNodes node:
                         Node.myNodes) {
                        if (node.getId().equals(packege.getSender())){
                            flag = false;
                        }
                    }
                    if (flag && !packege.getSender().equals(id)){
                        InfoNodes info = new InfoNodes(packege.getSender(), ip);
                        Node.myNodes.add(info);
                        App.insertNode();
                        // !!!
                    }
                    Packege packege1 = new Packege("acceptConnection", "accept the scanne", this.id, packege.getSender());
                    Sendpkg sendpkg = new Sendpkg(ip, packege1);
                    sendpkg.start();

                } else if (packege.getType().equals("acceptConnection") && !packege.getSender().equals(id)) {
                    System.out.println("connection is accepted !!");
                    boolean flag = true;
                    for (InfoNodes n:
                         Node.myNodes) {
                        if (n.getId().equals(packege.getSender())){
                            flag = false;
                            break;
                        }
                    }
                    if (flag){
                        InfoNodes info = new InfoNodes(packege.getSender(), ip);
                        Node.myNodes.add(info);
                        App.insertNode();
                    }
                    Packege packege1 = new Packege("setAES", id, packege.getSender(), keys.getPublic());
                    Sendpkg sendpkg = new Sendpkg(ip, packege1);
                    sendpkg.start();

                } else if (packege.getType().equals("message")){
                    boolean flag = true;
                    for (InfoNodes info:
                         Node.myNodes) {
                        if (info.getId().equals(packege.getSender())){
                            info.update(ASEkey.decrypt(packege.getContent(), info.getAes()), packege.getSender());
                            App.chatting(info.getChat());
                            flag = false;
                        }
                    }
                    if (flag){
                        InfoNodes infoNodes = new InfoNodes(packege.getSender(), ip);
                        infoNodes.update(packege.getContent(), packege.getSender());
                        Node.myNodes.add(infoNodes);
                        App.chatting(infoNodes.getChat());
                        App.insertNode();

                    }
                } else if (packege.getType().equals("setAES")) {
                    SecretKey aes = ASEkey.getAESKey();
                    for (InfoNodes node:
                         myNodes) {
                        if (node.getId().equals(packege.getSender()) && node.isFlag()){
                            node.setAes(aes);
                            node.setFlag(false);
                            break;
                        } else if (node.getId().equals(packege.getSender()) && !node.isFlag()) {
                            aes = node.getAes();
                            break;
                        }
                    }
                    String encodedKey = Base64.getEncoder().encodeToString(aes.getEncoded());
                    Packege packege1 = new Packege("getAES", id, packege.getSender(), RSAKeyGenerate.do_RSAecryption(encodedKey, packege.getPublicKey()));
                    Sendpkg sendpkg = new Sendpkg(ip, packege1);
                    sendpkg.start();
                    System.out.println("AES is: "+encodedKey);
                } else if (packege.getType().equals("getAES")) {
                    String aes = RSAKeyGenerate.do_RSADecryption(packege.getBytes(), keys.getPrivate());
                    System.out.println(aes);
                    byte[] decodedKey = Base64.getDecoder().decode(aes);
                    SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");

                    for (InfoNodes node:
                         myNodes) {
                        if (node.getId().equals(packege.getSender()) && node.isFlag()){
                            node.setAes(originalKey);
                            System.out.println("key AES is add it");
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("there is an error in listening part !!");
        } catch (ClassNotFoundException e) {
            System.out.println("there is an error in listening part !!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    

}
