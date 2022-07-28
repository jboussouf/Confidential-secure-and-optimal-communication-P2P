import java.security.PublicKey;
import java.io.Serializable;
public class Packege implements Serializable{
    private String type, content, sender, receiver; // type of sanding package; content of a package; package sender; package receiver
    PublicKey publicKey; // RSA publicKey
    byte[] bytes; // a sanding object as content in the package

    // for sending the package of scanning and accept
    public Packege(String type, String content, String sender, String receiver) {
        this.type = type;
        this.content = content;
        this.sender = sender;
        this.receiver = receiver;
    }

    // for sending the order of generate an aes key
    public Packege(String type, String sender, String receiver, PublicKey publicKey) {
        this.type = type;
        this.sender = sender;
        this.receiver = receiver;
        this.publicKey = publicKey;
    }

    // for sending the aes key encrypted
    public Packege(String type, String sender, String receiver, byte[] bytes) {
        this.type = type;
        this.sender = sender;
        this.receiver = receiver;
        this.bytes = bytes;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public byte[] getBytes() {
        return bytes;
    }
}
