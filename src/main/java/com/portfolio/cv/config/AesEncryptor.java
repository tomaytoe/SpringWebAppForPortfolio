package com.portfolio.cv.config;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.SerializationUtils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.AttributeConverter;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Configuration
public class AesEncryptor implements AttributeConverter<Object,String> {

    @Value("${aes.encryption.key}")
    private static String encryptionKey;
    private static String encryptionCipher = "AES";

    private static Key key;
    private static Cipher cipher;

    private Key getKey(){
        if(key == null){
            key = new SecretKeySpec(encryptionKey.getBytes(), encryptionCipher);
        }
        return key;
    }

    private Cipher getCipher() throws NoSuchPaddingException, NoSuchAlgorithmException {
        if(cipher == null){
            cipher = Cipher.getInstance(encryptionCipher);
        }
        return cipher;
    }

    private void initCipher(int encryptorMode) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        getCipher().init(encryptorMode,getKey());
    }

    @SneakyThrows
    @Override
    public String convertToDatabaseColumn(Object attribute) {
        if(attribute == null){
            return null;
        }
        initCipher(Cipher.ENCRYPT_MODE);
        byte[] bytes = SerializationUtils.serialize(attribute);
        return Base64.getEncoder().encodeToString(getCipher().doFinal(bytes));

    }

    @SneakyThrows
    @Override
    public Object convertToEntityAttribute(String dbData) {
        if(dbData == null){
            return null;
        }
        initCipher(Cipher.DECRYPT_MODE);
        byte[] bytes = getCipher().doFinal(Base64.getDecoder().decode(dbData));
        return SerializationUtils.deserialize(bytes);
    }
}
