package blockchainprojectpackage;

import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Transaction {
    private String fromAddress;
    private String toAddress;
    private double amount;
    private String signature;
    
    public Transaction(String fromAddress, String toAddress, double amount, PrivateKey privateKey) {
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.amount = amount;
        this.signature = signTransaction(privateKey);
    }
    
    public String getFromAddress() {
        return fromAddress;
    }
    
    public String getToAddress() {
        return toAddress;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public boolean verifyTransaction() {
        PublicKey publicKey = null;
        try {
            publicKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.getDecoder().decode(fromAddress)));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        Signature signature;
        try {
            signature = Signature.getInstance("SHA256withRSA");
            signature.initVerify(publicKey);
            signature.update((fromAddress + toAddress + amount).getBytes());
            return signature.verify(Base64.getDecoder().decode(this.signature));
        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    private String signTransaction(PrivateKey privateKey) {
        Signature signature;
        try {
            signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(privateKey);
            signature.update((fromAddress + toAddress + amount).getBytes());
            byte[] sig = signature.sign();
            return Base64.getEncoder().encodeToString(sig);
        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
            e.printStackTrace();
        }
        return null;
    }
}