package blockchainprojectpackage;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;

public class Block {

    private int index;
    private String hash;
    private String prevHash;
    private String data;
    private long time;
    private int nonce;
  
    public Block(int index, String data, String prevHash) {
        this.index = index; //the Block's current position within the Blockchain
        this.hash = hashFunc(); //the unique ID assigned to the Block upon generation
        this.time = new Date().getTime(); //the precise time the Block was created
        this.data = data; //the actual data stored within the Block
        this.prevHash = prevHash; //a pointer to the ID of the previous Block on the chain
    }

    private String hashFunc() {
        String toBeHashed = Integer.toString(index) + data + prevHash + Long.toString(time) + Integer.toString(nonce);
        String hashedData = null;

        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256"); //initialize a MessageDigest object which gives access to our one-way hash algorithm, SHA-256
            byte[] hash = digest.digest(toBeHashed.getBytes(StandardCharsets.UTF_8)); //encodes the string of data into bytes and runs it through SHA
            hashedData = Base64.getEncoder().encodeToString(hash); //encodes the byte array back into a string
        } catch (NoSuchAlgorithmException e) { //thrown when SHA is not found in the environment
            e.printStackTrace();
        }

        this.hash = hashedData;
        return hashedData;
    }

    public void mineBlock(int difficulty) {
        String hashPassword = new String(new char[difficulty]).replace('\0', '0'); //creates a password of zeroes based on difficulty (n)
        while (!hash.substring(0, difficulty).equals(hashPassword)) { //check if the first character to the nth character in the hash is equal to the password of zeroes
            nonce++;
            hash = hashFunc();
	    //nonce is iterated and the hash function is called again to generate a new hash, which is then checked until the first nth characters equal the password
        }
        System.out.println("Block Mined : " + hash); //succeeds and prints the hash value
    }

    //-------------------Getters and setters for the Block class-------------------

    public int getIndex() {
        return index;
    }
    
    public long getTime() {
    	return time;
    }
    
    public int getNonce() {
    	return nonce;
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return prevHash;
    }

    public String getData() {
        return data;
    }

    public void setPreviousHash(String prevHash) {
        this.prevHash = prevHash;
    }

    public void setData(String data) {
        this.data = data;
    }

}