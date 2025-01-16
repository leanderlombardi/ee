package site.abc.ee;

import java.util.Random;

public class ElithEncryption {
    private String originalText = "";
    private String key = "";

    public ElithEncryption(String originalText) {
        this.originalText = originalText;
        this.key = generateRandomKey(16);  // Default key length can be set to 16 or any length you prefer
    }

    public ElithEncryption(String originalText, String key) {
        this.originalText = originalText;
        this.key = key;
    }

    private String generateRandomKey(int length) {
        StringBuilder generatedKey = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            generatedKey.append((char)(rand.nextInt(9) + 1 + '0'));
        }
        return generatedKey.toString();
    }

    public String crypt() {
        StringBuilder encryptedText = new StringBuilder();
        int j = 0;
        for (int i = 0; i < originalText.length(); i++) {
            encryptedText.append((char)(originalText.charAt(i) ^ key.charAt(j)));
            j++;
            if (j == key.length()) {
                j = 0;
            }
        }
        return encryptedText.toString();
    }

    public String decrypt(String encryptedText, String key) {
        StringBuilder decryptedText = new StringBuilder();
        int j = 0;
        for (int i = 0; i < encryptedText.length(); i++) {
            decryptedText.append((char)(encryptedText.charAt(i) ^ key.charAt(j)));
            j++;
            if (j == key.length()) {
                j = 0;
            }
        }
        return decryptedText.toString();
    }

    public String getKey() {
        return key;
    }

    public String getKey(String originalText, String encryptedText) {
        StringBuilder derivedKey = new StringBuilder();
        int j = 0;
        for (int i = 0; i < originalText.length(); i++) {
            derivedKey.append((char)(originalText.charAt(i) ^ encryptedText.charAt(i)));
            j++;
            if (j == originalText.length()) {
                j = 0;
            }
        }
        return derivedKey.toString();
    }
}
