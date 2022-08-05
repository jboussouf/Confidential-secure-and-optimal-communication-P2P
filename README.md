
# Confidential, secure and optimal communication: Secure P2P chat application using java


In this work, we will propose a secure P2P chat application in java programming language, and this system consists of a robust, fully decentralized (P2P) and end-to-end encrypted network architecture.



![Logo](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhxcnmQkMI8EKosZuySbGis6TQ_KvMk9gs8M0mVf8Wdo9ddZrGQVmy3y3o3Z_lArgLd0PtmRWeUTOZQ60C8NgxybZyAB60kPFZfJvHBb_V2PFy9rzYqSAiT60eGzsNj4K86EweBfQ9tz-PJOQSqvRvZILqmRTI5UElr5LwnVag-xS15TPAqZjxJGeRaBw/s1600/chat.png)


## Chat application secured using the Java programming language

- Introduction

- Network architecture

- Data exchange

- Security

    - Representation of the network

    - Scanning

    - Exchange of keys

    - Communication
    
- Conclusion
## Introduction

The need to transmit messages between us human beings requires a strong need for security due to the existence of sensitive data; this always leads us to find more confidential means of communication when messages are transmitted from a sender to a receiver. In other words, it is a matter of avoiding the survival of messages by bailout attacks.

Today we find enough applications that perform this task, but as far as the idea of peer to peer is concerned, we don't find enough, because its network architecture presents complications to ensure real security since there is no controlled organization that manages the transmission of messages. At this stage, we have worked in this project to develop a secure chat application that includes more powerful encryption and coding methods, we are talking about RSA, AES... .
![Logo](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEg5f5-HB3P6LoggHwgE6YDUuuMMx7z8DPC8Shw4rRO8mqocRE_kLNtwJou8mbrVDVeATcBE45TcSPvF0-O4UNdDooiZ-fJmq7Ifchxiigqxcw6EKb2tAvVbxVvO0nb9J8d0Zh_hQuUkgU4PfJrhem9SfvD3TtHk_46qFX5Fs8Zx75WSzHa-OFMCn8r1yg/s1600/fig1.png)
In this work we will propose a solution with :

        - A robust network architecture.

        - Fully decentralized (P2P).

        - End-to-end encryption.
## Network architecture
The general architecture of the proposed system is in the form of a complete and fully connected graph: there are nodes that are connected to each other by a virtual communication channel. The nodes on the one hand are defined by a logical address (IP), a key pair (public/private) and an identifier (ID) so that they are recognized by the rest of the network.

![Logo](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhV-zYgKFLUF7i8M05xwQzNYAa4hgG9f3kzO0RoowL8C6Vu197R55T93vUs05BOxRBJJZTvcpEIF2W8BTiTJTuHVJhH_Hws4DwGMKqD6Pqsk7JLBbZfxrin9jcvJyUlzIcucsDBDLs0xTcFToYEFa7SwrdGPFDfQrYqeBekYQAwnVwNahUrCjQZ05PLAw/s1600/fig2.png)

## Data exchange
When communicating between nodes in the network, nodes send secure packet types based on the state of the communication, i.e., each node enters a three-state process before it can communicate securely. These states are reached as soon as the receiver accepts each of the three packet types. The first is for discovering the nodes in the network, the second is for exchanging key packets (AES) to manage them. The first is for discovering the nodes in the network, the second is for exchanging key packets (AES) to manage them securely, as we will see later, and the last packet is used for sending the message and for general communication. These packets usually circulate in an internal network where the architecture is defined.

![Logo](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEivdeKahxUvetMXvH08wlV-r3g4uXLIv6Vi3GZXp1JIYwLFi57OUnNvp9ZyVwCpyX_7VOjFqUsG4NdpTlFP0Wattt1D4WXGwJfqAekCRX6xRQd-k889QzdzscucO42fk5kiS0I9dvTWmnA0_ILhbwgTwwwEQMO71vaYa5gpcx6o45g6dzp8iFOgaCCCEQ/s1600/Diagramme%20sans%20nom.drawio%20%286%29.png)

## Security
### Representation of the network

we have configured our network as a darkroom, this room is divided into sub-areas, each area is represented by its address (1-1, 1-2, ..., n-n). For this room users can't see other areas without sending a scan packet and if this area is full of a user, the user sends another acceptance scan packet with his information.

![Logo](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEj78eVDn3UiS-SV_GDDSEY_aABHGMheIiUb6ifgSuetd8cja8czXnOoHxJ8U5t_6usmCZccI9WwsDBdK_1-OveU1Dx-U-HxM6NT9ZhomT1bg3xf4LcN_SmrJEAxY77bLIT2rhHPLUUhKtw5nuDM565BwAJQEqGhEGUI1bxxScq_o55MdEn-_axmS2E5kw/s1600/Diagramme%20sans%20nom.drawio%20%281%29.png)

Currently, if a new user wants to be added to the network, it sends a message to each zone, the message contains its name, and if a user exists in a zone, it adds the new user to its user list (infoNode list as a new node). Then the receiver sends the person who scanned an accepted scan packet with the receiver's ID.

### Scanning

As we have seen, the user sends a packet to each network zone. If a user exists in one of the zones zone, the receiver creates a new infoNode containing the new node's information and adds it to a list of nodes, then to a list of nodes, then generates a packet with its ID and sends it to the sender to do the same job of adding a new node. add a user to its list of nodes.

![Logo](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhkjyHe5Im27qIK55g7tG-db8i6-7ttXvjTP_843MdMNjp9u9WDDKTjhN95pqo7frtXjv3bj7dtNddLRUTo6w0Rr9CLIbN6VrBTTt2RmVeqEYiVvvISA1hcN5hb0dJ5YtI0gd8u4FralzxddfVtdQVTI9BMI8DUOpIl-233njlN0H0Yeq-2enzP-gsPjw/s1600/Diagramme%20sans%20nom.drawio%20%2811%29.png)

### Exchange of keys
At the moment, the user has a list of other users but he can't establish a secure communication with the other users, so we have to use AES to generate a secure communication channel and to exchange this and to exchange this key we have to use another algorithm called RSA algorithm, and the users exchange the AES keys by sending a packet of type setAES and also include the public key of the RSA key pair ; then the receiver of the packet generates an AES key and adds it to the information of the sender's node, then encrypts it with the RSA public key, then generates a getAES packet, and for the time being the new receiver (which was a sender) decrypts the AES key using the RSA private key and adds it to the sender's information.

![Logo](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhV7oyqgc85JvKFwL07iftfysY9iaGO0O37R0wRcJGDy2dYj9dMzZB21GWDYguCQPl6jzuw5EZvqK2V-j4wXGIroKdOHtSO80uYcl9SSo6eXmw5B0T8BBaAUeWHGobUk7i0-Zlz6EhPC3Nc7OQviW8NYdVDCGfq_1cpf7mwGmJ7NJkuVKbEATlfIycIVw/s1600/Diagramme%20sans%20nom.drawio%20%2817%29.png)

### Communication

Finally, for the moment, we are able to communicate in a secure way and without going through a server (decentralized) and to use a secure channel to exchange messages.

![Logo](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhzoIKAushBJKhP4Ir4oDEmT4nBNUQo2PzDYTaDMW3hhLp1hbKAI0xlmwM89-ckp9fDu-sm2E0adA5BzhTn_6YY-zVblb9teNhJOkQz2RlebOvBuTPWUFmcLjnqVIi4wFIFZd9Pjb7zMqLZ0PSpSACxpYoySTUNIgga1QxzNDiRCN7ErVkCEykaJkouOw/s1600/Diagramme%20sans%20nom.drawio%20%2810%29.png)

## Conclusion

In this work, we proposed a secure chat application using java. Two encryption approaches (symmetric/asymmetric), the first for message transmission and the second for key exchange. The architecture of the network is peer to peer, there is no mastered concept to manage what happens between two users of the system, it is fair and confidential between the two This work is a more confidential means of communication on an internal network, will be used to exchange more sensitive data.

![Logo](https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgzXcW98DxhQiGAyOOrab1ljA_i6qhRj6LmshoZkxXnycGRkVneALotfoZMUIa7uN9w3DeY3JMLkTNzgPxx01at1IhJ71-KRVq5y8aDvhQ2O7CxLsaDdb30EScZVC4xNghY1lWrFPFsVuGGw_iNs8zAj7r1tggFVGNC4TDGPx2haA4YWMXr4nUgB7vzaw/s1600/Diagramme%20sans%20nom.drawio%20%2814%29.png)


## Authors

- [@iseddik](https://github.com/iseddik)
    - [![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/issamseddik/)
- [@jamalboussouf](https://github.com/jamalboussouf)
    - [![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/jamal-boussouf-996a05205/)