public class EncryptFacade {//客户端所见外观类
    private FileReader reader;
    private CipherMachine cipher;
    private FileWriter writer;

    public EncryptFacade() {
        this.reader = new FileReader();
        this.cipher = new CipherMachine();
        this.writer = new FileWriter();
    }

    public void fileEncrypt(String fileNameSrc, String fileNmaeDes) {//读取加密保存方法
        String plainStr = reader.read(fileNameSrc);
        String encryptStr = cipher.encrypt(plainStr);
        writer.write(encryptStr, fileNmaeDes);
    }
}
