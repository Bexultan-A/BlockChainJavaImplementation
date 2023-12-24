package blockchain;

import Hashing.Miner;
import service.AsymmetricEncryption;
import service.DigitalSignature;

import java.security.KeyPair;
import java.util.*;

public class BlockChain {
    private List<Block> blockChain;
    Miner miner;

    public BlockChain() {
        this.blockChain = new ArrayList<>();
        this.miner = new Miner();
        addGenesisBlock();
    }

    private void addGenesisBlock() {
        blockChain.add(new Block( new ArrayList<>(), "000000000000000000000000000000000000000000000000000000000000000"));
    }

    public void addBlock(Block block) {
        this.blockChain.add(block);
    }

    public List<Block> getBlockChain() {
        return this.blockChain;
    }

    public int size() {
        return this.blockChain.size();
    }

    @Override
    public String toString() {
        StringBuilder blockChain = new StringBuilder();
        for(Block block : this.blockChain)
            blockChain.append(block.toString()).append("\n");
        return blockChain.toString();
    }

}
