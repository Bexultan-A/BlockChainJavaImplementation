package blockchain;


import Hashing.StringUtil;

import java.util.Date;
import java.util.List;

public class Block {
    private int nonce;
    private String hash;
    private String previousHash;
    private List<Transaction> transactions;
    private long timeStamp;


    public Block(List<Transaction> transactions, String previousHash) {
        this.previousHash = previousHash;
        this.transactions = transactions;
        this.timeStamp = new Date().getTime();
        calculateHash();
    }

    public void calculateHash() {
        String dataToHash = previousHash + Long.toString(timeStamp) + Integer.toString(nonce) + transactions.toString();

        this.hash = StringUtil.applySha256(dataToHash);
    }

    public void incrementNonce() {

        this.nonce++;
    }

    public int getNonce() {
        return nonce;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        StringBuilder transactionsString = new StringBuilder();
        transactionsString.append("TRANSACTIONS: \n");
        for (Transaction transaction : transactions) {
            transactionsString.append(transaction.toString()).append("\n");
        }
        transactionsString.append("\n Hash: ").append(this.hash).append("\n Previous Hash: ").append(this.previousHash).append("\n Time Stamp: ").append(this.timeStamp);
        return transactionsString.toString();
    }
}
