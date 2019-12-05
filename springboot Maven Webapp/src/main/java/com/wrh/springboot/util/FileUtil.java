package com.wrh.springboot.util;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;

public class FileUtil {

    public static void OldCopyFile(String source,String dist){
        File sourceFile = new File(source);
        File distFile = new File(dist);
        FileInputStream inputStream = null;
        FileOutputStream outStream = null;
        try {
            inputStream = new FileInputStream(sourceFile);
            outStream = new FileOutputStream(distFile);
            byte[] a = new byte[512];
            int len = 0;
            while((len=inputStream.read(a))!=-1)
            {
                outStream.write(a,0,len);
            }
            outStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outStream.close();
            } catch (IOException e) {
            }
        }
    }

    public static void NewCopyFile(String source,String dist){
        File sourceFile = new File(source);
        File distFile = new File(dist);
        FileInputStream inputStream = null;
        FileOutputStream outStream = null;

        try {
            inputStream = new FileInputStream(sourceFile);
            outStream = new FileOutputStream(distFile);
            BufferedInputStream inbuffer = new BufferedInputStream(inputStream);
            BufferedOutputStream outbuffer = new BufferedOutputStream(outStream);
            byte[] a = new byte[512];
            int len = 0;
            while((len=inbuffer.read(a))!=-1)
            {
                outbuffer.write(a,0,len);
            }
            outStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outStream.close();
            } catch (IOException e) {
            }
        }
    }

    public static void NewCopyFile2(String source,String dist){
        File sourceFile = new File(source);
        File distFile = new File(dist);
        try {
            FileChannel inputChannel =  FileChannel.open(sourceFile.toPath());
            FileChannel outChannel = FileChannel.open(distFile.toPath(), StandardOpenOption.WRITE);
            ByteBuffer buffer = ByteBuffer.allocate(50*1024*1024);
            int len = 0;
            while ((len = inputChannel.read(buffer)) != -1) {
                           //buffer从读切换到写
                              buffer.flip();
                            // 打印信息必须放在flip后面, 否则decode出来的是上次read的结果.根据in.txt的字符编码修改下面的ISO_8859_1
                             //System.out.println(read + "--" + StandardCharsets.ISO_8859_1.decode(byteBuffer));
                                outChannel.write(buffer);
                            // 写完之后清空缓冲区,否则read=0一直死循环
                                 buffer.clear();
                        }
                inputChannel.close();
             outChannel.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    public static void NewCopyFile3(String source,String dist){
        File sourceFile = new File(source);
        File distFile = new File(dist);
        try {
            FileChannel inputChannel =  FileChannel.open(sourceFile.toPath());
            FileChannel outChannel = FileChannel.open(distFile.toPath(), StandardOpenOption.WRITE);
            inputChannel.transferTo(0,inputChannel.size(),outChannel);
            inputChannel.close();
            outChannel.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long a = System.currentTimeMillis();
        System.out.println(a);
        FileUtil.OldCopyFile("F:/下载/CentOS-7-x86_64-Minimal-1810.iso","F:/demo/Data6.bdt");
        System.out.println(System.currentTimeMillis()-a);
    }
}
