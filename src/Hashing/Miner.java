package Hashing;

import blockchain.Block;
import blockchain.BlockChain;

public class Miner {
    private double reward;

    public void mine(Block block, BlockChain blockChain) {

        while (notGoldenHash(block)) {
            block.calculateHash();
            block.incrementNonce();
        }

        blockChain.addBlock(block);

        reward += 10;
    }

    public boolean notGoldenHash(Block block) {

        String leadingZeros = new String(new char[4]).replace('\0', '0');

        return !block.getHash().substring(0,4).equals(leadingZeros);
    }

    public double getReward() {
        return reward;
    }
}
