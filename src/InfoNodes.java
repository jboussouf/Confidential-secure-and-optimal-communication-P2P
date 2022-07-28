import javax.crypto.SecretKey;
import java.security.KeyPair;

public class InfoNodes {
    private String idNode, ip, chat = "";//id of the other nodes; ip of other nodes; text of message with each node
    private SecretKey aes; //The symmetric encryption key aes

    private boolean flag = true; // useful parameter

    //contractor of a infoNodes object
    public InfoNodes(String id, String ip) {
        this.idNode = id;
        this.ip = ip;
    }

    public SecretKey getAes() {
        return aes;
    }

    public void setAes(SecretKey aes) {
        this.aes = aes;
    }

    public String getId() {
        return idNode;
    }

    public String getIp() {
        return ip;
    }

    public String getChat() {
        return chat;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isFlag() {
        return flag;
    }

    //update the chat parameter
    public void update(String msg, String id){
        if (!idNode.equals(id)){
            this.chat = chat + "me: "+msg+"\n";
        }else {
            this.chat = chat + idNode +": "+msg+"\n";
        }
    }
}
