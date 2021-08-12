package dnd.team4backend.config;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.junit.jupiter.api.Test;

class PropertyEncyptConfigurationTest {
    @Test
    public void checkEncrpt() throws Exception {

        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setProvider(new BouncyCastleProvider());
        encryptor.setPoolSize(2);
        encryptor.setPassword("MySecretKey");
        encryptor.setAlgorithm("PBEWithSHA256And128BitAES-CBC-BC");

        String plainText1 = ""; // 암호화 할 내용
        String encryptedText1 = encryptor.encrypt(plainText1); // 암호화
        String decryptedText1 = encryptor.decrypt(encryptedText1); // 복호화
        System.out.println("Enc:" + encryptedText1 + ", Dec:" + decryptedText1);

        String plainText2 = ""; // 암호화 할 내용
        String encryptedText2 = encryptor.encrypt(plainText2); // 암호화
        String decryptedText2 = encryptor.decrypt(encryptedText2); // 복호화
        System.out.println("Enc:" + encryptedText2 + ", Dec:" + decryptedText2);

    }

}