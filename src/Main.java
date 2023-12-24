import Hashing.Miner;
import blockchain.Block;
import blockchain.BlockChain;
import blockchain.Transaction;
import blockchain.TransactionManager;
import service.AsymmetricEncryption;

import java.security.KeyPair;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        BlockChain blockChain = new BlockChain();
        Scanner scanner = new Scanner(System.in);
        Miner miner = new Miner();
        TransactionManager transactionManager = new TransactionManager(blockChain, miner);


        while (true) {
            System.out.println("1. Add Transaction");
            System.out.println("2. Display Blockchain");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter sender: ");
                    String sender = scanner.next();
                    System.out.print("Enter recipient: ");
                    String recipient = scanner.next();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    transactionManager.addTransaction(sender, recipient, amount);
                }
                case 2 -> System.out.println(blockChain);
                case 3 -> System.exit(0);
            }
        }

    }
}