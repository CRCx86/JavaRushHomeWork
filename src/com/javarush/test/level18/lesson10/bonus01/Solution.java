package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import javax.crypto.*;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Solution {
    private static FileInputStream fileIn = null;
    private static FileOutputStream fileOut = null;
    private static final String secretKey = "12345678";

    public static void main(String[] args) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {

        if (args.length == 0) {
            throw new IllegalArgumentException();
        }

        switch (args[0]) {
            case "-e" :
                initFileIn(args[1]);
                initFileOut(args[2]);
                getFileCrypt(initAESEnCrypt(), fileOut);
                break;
            case "-d" :
                initFileIn(args[1]);
                initFileOut(args[2]);
                getFileCrypt(fileIn, initAESDeCrypt());
                break;
            default:
        }

    }

    public static void initFileIn(String f1) throws FileNotFoundException {
        fileIn = new FileInputStream(f1);
    }

    public static void initFileOut(String f1) throws FileNotFoundException {
        fileOut = new FileOutputStream(f1);
    }

    public static SecretKey getSecretKey() throws NoSuchAlgorithmException {
//
        SecretKey sk = new SecretKey() {
            @Override
            public String getAlgorithm() {
                return "DES";
            }

            @Override
            public String getFormat() {
                return "RAW";
            }

            @Override
            public byte[] getEncoded() {
                return secretKey.getBytes();
            }
        };

        return sk;
    }

    public static CipherInputStream initAESEnCrypt() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, getSecretKey());

        return new CipherInputStream(fileIn, cipher);
    }

    public static CipherOutputStream initAESDeCrypt() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, getSecretKey());

        return new CipherOutputStream(fileOut, cipher);
    }

    public static void getFileCrypt(InputStream is, OutputStream os) throws IOException {

        byte[] bytes = new byte[64];
        int b = 0;
        while ((b = is.read(bytes))!= -1) {
            os.write(bytes, 0, b);
        }

        is.close();
        os.close();
        fileIn.close();
        fileOut.close();
    }
}

