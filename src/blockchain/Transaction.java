package blockchain;

import service.DigitalSignature;

import java.security.PublicKey;
import java.util.Arrays;
import java.util.Base64;

public class Transaction {
    private String sender;
    private String recipient;
    private double amount;
    private byte[] signature;
    private PublicKey publicKey;

    public Transaction(String sender, String recipient, double amount) {
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
    }

    public byte[] getSignature() {
        return signature;
    }

    public void setSignature(byte[] signature) {
        this.signature = signature;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    @Override
    public String toString() {
        return sender + recipient + amount;
    }

}
