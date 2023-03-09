package blockchainprojectpackage;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;

public class Blockchain {
    private ArrayList<Block> blocks;
    private int difficulty;

    public Blockchain(int difficulty) {
        this.blocks = new ArrayList<Block>();
        this.difficulty = difficulty;
        // create genesis block
        Block genesisBlock = new Block(0, "Genesis Block", "0");
        genesisBlock.mineBlock(difficulty);
        this.blocks.add(genesisBlock);
    }

    public Block getLatestBlock() {
        return this.blocks.get(this.blocks.size() - 1);
    }

    public void addBlock(Block newBlock) {
        newBlock.setPreviousHash(this.getLatestBlock().getHash());
        newBlock.mineBlock(difficulty);
        this.blocks.add(newBlock);
    }

    public boolean isValid() {
        for (int i = 1; i < this.blocks.size(); i++) {
            Block currentBlock = this.blocks.get(i);
            Block previousBlock = this.blocks.get(i - 1);

            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                return false;
            }
            
            if (!currentBlock.getHash().equals(hashBlock(currentBlock))) {
                return false;
            }

            if (currentBlock.getIndex() != i) {
                return false;
            }
        }
        return true;
    }
    
    //Hash function to hash any block for verification that it's current data matched the data that it had when it was added.
    public String hashBlock(Block block) {
    	String toBeHashed = Integer.toString(block.getIndex()) + block.getData() + block.getPreviousHash() + Long.toString(block.getTime()) + Integer.toString(block.getNonce());
        String hashedData = null;

        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(toBeHashed.getBytes(StandardCharsets.UTF_8));
            hashedData = Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        
        return hashedData;
    }
}