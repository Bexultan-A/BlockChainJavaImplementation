package blockchain;

import service.AsymmetricEncryption;
import service.DigitalSignature;
import Hashing.Miner;
import java.security.KeyPair;
import java.util.Collections;

public class TransactionManager {
    BlockChain blockChain;
    Miner miner;

    public TransactionManager(BlockChain blockChain, Miner miner) {
        this.blockChain = blockChain;
        this.miner = miner;
    }

    public void addTransaction(String sender, String recipient, double amount) throws Exception {
        Transaction transaction = new Transaction(sender, recipient, amount);
        KeyPair keyPair = AsymmetricEncryption.generateRSAKeyPair();
        byte[] encryptedTransaction = AsymmetricEncryption.Encrypt(transaction.toString(), keyPair.getPrivate());
        byte[] signature = DigitalSignature.sign(encryptedTransaction, keyPair.getPrivate());
        transaction.setSignature(signature);
        transaction.setPublicKey(keyPair.getPublic());

        if (DigitalSignature.verify(encryptedTransaction, transaction.getSignature(), transaction.getPublicKey())) {
            Block block = new Block(Collections.singletonList(transaction), blockChain.getBlockChain().get(blockChain.getBlockChain().size()-1).getHash());
            miner.mine(block, blockChain);
            System.out.println("Transaction added Successfully!!!");
        } else {
            System.out.println("Transaction verification failed!!!");
        }
    }
}
