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
        this.index = index;
        this.hash = hashFunc();
        this.time = new Date().getTime();
        this.data = data;
        this.prevHash = prevHash;
    }

    private String hashFunc() {
        String toBeHashed = Integer.toString(index) + data + prevHash + Long.toString(time) + Integer.toString(nonce);
        String hashedData = null;

        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(toBeHashed.getBytes(StandardCharsets.UTF_8));
            hashedData = Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        this.hash = hashedData;
        return hashedData;
    }

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = hashFunc();
        }
        System.out.println("Block Mined : " + hash);
    }

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

    public void setPreviousHash(String prevHash) {
        this.prevHash = prevHash;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}