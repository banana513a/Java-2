package com.blackybear.test.basis.io;

import org.apache.commons.io.FileUtils;

import java.io.*;

/**
 * Description: IO读写
 * Author: Dell_Blacky8
 * CopyRight: Dell_Blacky8
 * Create Date: 2017-08-01
 */
public class IOTest {
    private final static int BUFFERSIZE = 1 << 10;
    private final static int STREAMBUFFERSIZE = 1 << 16;

    public static void main(String[] args) {
        // IteratorFile(new File("G:/MyProjects/Projects_Java/TestProject"), 1);
        // IteratorFile(new File("../TestProject"), 1);
        // readByStream();
        // writeByStream();
        // copyByStream();
        // copyByBufferByStream();
        // copyByCharStream();
        copyByBufferByCharStream();
        // copyByFileReaderWriter();
        // randomAccessFileRead();
        // apacheCopy();
    }

    // Print some attribution of class File
    public static void showFileMethod() {
        File fileRelative = new File("Test.txt");
        File fileAbsolute = new File("G:\\MyProjects\\Projects_Java\\TestProject\\Test.txt");
        System.out.println(String.format("File Name==%s", fileAbsolute.getName()));
        System.out.println(String.format("Relative Path==%s", fileAbsolute.getPath()));
        System.out.println(String.format("Absolute Path==%s", fileAbsolute.getAbsolutePath()));
        // The pathname string of the parent directory named by this
        // abstract pathname,
        // or null if this pathname does not name a parent
        System.out.println(String.format("Parent Path==%s", fileRelative.getParent()));
        System.out.println(
                String.format("Parent Path of Relative ==%s", new File(fileAbsolute.getAbsolutePath()).getParent()));
        System.out.println(String.format("Parent Path==%s", fileAbsolute.getParent()));
        System.out.println(String.format("Attribution:Hide==%b", fileAbsolute.isHidden()));
        System.out.println(String.format("Attribution:Read==%b", fileAbsolute.canRead()));
        System.out.println(String.format("Attribution:Write==%b", fileAbsolute.canWrite()));
    }

    // Iterator files in the directory
    public static void iteratorFile(File directory, int tab) {
        if (!directory.isDirectory())
            return;
        System.out.println(directory.getName());
        File[] files = directory.listFiles();
        for (int i = 0; i < files.length; i++) {
            for (int j = 0; j < tab; j++)
                System.out.print("|--");
            if (files[i].isFile()) {
                System.out.println(files[i].getName());
            } else {
                iteratorFile(files[i], tab + 1);
            }
        }
    }

    // IO: read, write file by stream directly
    public static void readByStream() {
        try {
            FileInputStream fileInputStream = new FileInputStream("Test_IO_Stream.txt");
            byte[] buffer = new byte[BUFFERSIZE];
            int len = 0;
            while ((len = fileInputStream.read(buffer)) != -1) {
                String inputString = new String(buffer, 0, len, "gbk");
                System.out.println(inputString);
            }
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeByStream() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("Test_IO_Stream_New.txt");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("    �ǻƺ�¥    \n");
            stringBuffer.append("������ɽ�����ƺ��뺣����\n");
            stringBuffer.append("����ǧ��Ŀ������һ��¥��\n");
            byte[] buffer = stringBuffer.toString().getBytes("gbk");
            fileOutputStream.write(buffer);
            fileOutputStream.close();
            System.out.println("Write by stream has been completed!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyByStream() {
        try {
            // Copy a unity package file
            FileInputStream fileInputStream = new FileInputStream("Test_IO_Buffer_Stream.unitypackage");
            FileOutputStream fileOutputStream = new FileOutputStream("Test_IO_Buffer_Stream_New.unitypackage");
            byte[] buffer = new byte[BUFFERSIZE];
            int count = 0;
            long beforeTime = System.currentTimeMillis();
            while (fileInputStream.read(buffer) != -1) {
                fileOutputStream.write(buffer);
                count++;
            }
            long finishTime = System.currentTimeMillis();
            fileInputStream.close();
            fileOutputStream.close();
            System.out.println(String.format("��дʱ�䣺%s ms", finishTime - beforeTime));
            System.out.println(String.format("��д������%d", count));
            System.out.println("Copy by stream has been completed!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // IO: read, write large file by buffer (Note that: Need calling method
    // "flush" before close buffered stream)
    public static void copyByBufferByStream() {
        try {
            FileInputStream fileInputStream = new FileInputStream("Test_IO_Buffer_Stream.unitypackage");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, STREAMBUFFERSIZE);
            FileOutputStream fileOutputStream = new FileOutputStream("Test_IO_Buffer_Stream_New.unitypackage");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream, STREAMBUFFERSIZE);
            byte[] buffer = new byte[BUFFERSIZE];
            int count = 0;
            long beforeTime = System.currentTimeMillis();
            while (bufferedInputStream.read(buffer) != -1) {
                bufferedOutputStream.write(buffer);
                count++;
            }
            bufferedOutputStream.flush();
            bufferedInputStream.close();
            fileInputStream.close();
            bufferedOutputStream.close();
            fileOutputStream.close();
            long finishTime = System.currentTimeMillis();
            System.out.println(String.format("��ȡʱ�䣺%s ms", finishTime - beforeTime));
            System.out.println(String.format("��ȡ������%d", count));
            System.out.println("Copy by buffer stream has been completed!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // IO: read ,write file by char stream
    public static void copyByCharStream() {
        try {
            FileInputStream fileInputStream = new FileInputStream("Test_IO_Char.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "gbk");
            FileOutputStream fileOutputStream = new FileOutputStream("Test_IO_Char_New.txt");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "gbk");
            char[] buffer = new char[BUFFERSIZE];
            int len = 0; // Use to print appropriate length of char array
            while ((len = inputStreamReader.read(buffer)) != -1) {
                outputStreamWriter.write(buffer, 0, len);
            }
            inputStreamReader.close();
            fileInputStream.close();
            outputStreamWriter.close();
            fileOutputStream.close();
            System.out.println("Copy by char stream has been completed!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // IO: read,write large file by buffered char stream
    public static void copyByBufferByCharStream() {
        try {
            FileInputStream fileInputStream = new FileInputStream("Test_IO_Char.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "gbk");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            FileOutputStream fileOutputStream = new FileOutputStream("Test_IO_Char_New.txt");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "gbk");
            // BufferedWriter bufferedWriter = new
            // BufferedWriter(outputStreamWriter);
            PrintWriter printWriter = new PrintWriter(outputStreamWriter, true);// true:printWriter.flush()
            String buffString = "";
            while ((buffString = bufferedReader.readLine()) != null) {
                printWriter.println(buffString);
                // bufferedWriter.write(buffString);
            }
            // bufferedWriter.flush();
            // printWriter.flush();
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
            printWriter.close();
            // bufferedWriter.close();
            outputStreamWriter.close();
            fileOutputStream.close();
            System.out.println("Copy by buffered char stream has been completed!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // IO: read, write file by FileReader and FileWriter(operate text file
    // quickly)
    public static void copyByFileReaderWriter() {
        try {
            FileReader fileReader = new FileReader("Test_IO_FileReaderWriter.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("Test_IO_FileReaderWriter_New.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String bufferString = "";
            while ((bufferString = bufferedReader.readLine()) != null) {
                bufferedWriter.write(bufferString + "\n");
            }
            bufferedWriter.flush();
            bufferedReader.close();
            fileReader.close();
            bufferedWriter.close();
            fileWriter.close();
            System.out.println("Copy by FileReader & FileWriter has been completed!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // IO: read, write file by randomAccessFile
    public static void randomAccessFileRead() {
        File file = new File("Test_IO_RandomAccessFile.txt");
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            byte[] buffer = new byte[1 << 5];
            randomAccessFile.seek(1 << 6);
            randomAccessFile.read(buffer);
            String buffersString = new String(buffer);
            System.out.println(buffersString);
            randomAccessFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void randomAccessFileWrite() {
        File file = new File("Test_IO_RandomAccessFile.txt");
        if (file.exists())
            file.delete();
        new WriteFile(file, 5).start();
        new WriteFile(file, 2).start();
        new WriteFile(file, 1).start();
        new WriteFile(file, 3).start();
        new WriteFile(file, 4).start();
    }

    // IO: copy file by Apache API
    public static void apacheCopy() {
        try {
            FileUtils.copyFile(new File("Test_IO_Apache.txt"), new File("Test_IO_Apache_New.txt"));
            System.out.println("Copy file by Apache has been completed!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class WriteFile extends Thread {
    private File file;
    private int blockIndex;
    private int blockSize = 1 << 6;

    public WriteFile(File file, int blockIndex) {
        this.file = file;
        this.blockIndex = blockIndex;
    }

    @Override
    public void run() {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(blockSize * (blockIndex - 1));
            randomAccessFile.write(String.format("This is block : %d", blockIndex).getBytes("gbk"));
            randomAccessFile.close();
            System.out.println(String.format("Thread %s task has been completed!", blockIndex));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
