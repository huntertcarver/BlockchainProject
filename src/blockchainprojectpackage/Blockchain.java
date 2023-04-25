package blockchainprojectpackage;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;

public class Blockchain {
    private ArrayList<Block> blocks; //Array list to hold blocks, to make it easy to access different transactions.
    private int difficulty; //number that mining algorithm increases up to (changes how many 0's to check for, the more 0's the more difficult).

    //constructor
    public Blockchain(int difficulty) {
        this.blocks = new ArrayList<Block>(); //dynamically allocate the arraylist class object.
        this.difficulty = difficulty; //set the difficulty to what was passed when making the object.
        // create genesis block
        Block genesisBlock = new Block(0, "Genesis Block", "0"); //First block in blockchain, does not point to any previous block.
        genesisBlock.mineBlock(difficulty);
        this.blocks.add(genesisBlock);
    }

    //returns the most recent block from the arraylist.
    public Block getLatestBlock() {
        return this.blocks.get(this.blocks.size() - 1);
    }

    //adds a new block to the end of the blockchain.
    public void addBlock(Block newBlock) {
        newBlock.setPreviousHash(this.getLatestBlock().getHash());
        newBlock.mineBlock(difficulty);
        this.blocks.add(newBlock);
    }

    //Makes sure that there are no duplicates hash values, and that all blocks are pointing correctly.
    public boolean isValid() {
        for (int i = 1; i < this.blocks.size(); i++) {
            Block currentBlock = this.blocks.get(i);
            Block previousBlock = this.blocks.get(i - 1);

            //checks if the blocks are in order.
            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                return false;
            }
            //verifying that the block matches itself
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
    
    public ArrayList<Block> getBlocks(){
    	return this.blocks;
    }
}