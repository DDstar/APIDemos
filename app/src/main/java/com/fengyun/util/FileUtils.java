package com.fengyun.util;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.content.FileProvider;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by prize on 2017/7/3.
 */

public class FileUtils {

    public static final String PACKAGE_NAME = "com.example.android.apis";

    public static boolean inputStreamToOutputStream(InputStream inputStream, OutputStream outputStream){
        byte[] buffer = new byte[1024];
        int length;
        try {
            while((length = inputStream.read(buffer)) > 0){
                outputStream.write(buffer,0,length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    public static File getFileProviderPath(String path){
        File dir = Environment.getExternalStorageDirectory();
        File dir1 = new File(dir, path);
        if(!dir1.exists())
            dir1.mkdirs();
        return dir1;
    }

    public static Uri getUriForFile(Context context, File file){
        if(context == null || file == null){
            throw new NullPointerException();
        }
        Uri uri;
        if(Build.VERSION.SDK_INT >= 24){
            uri = FileProvider.getUriForFile(context,PACKAGE_NAME + ".fileprovider", file);
        }else{
            uri = Uri.fromFile(file);
        }
        return uri;
    }

    @Test
    public void testCreateFile() {
        File file = new File("share.txt");
        System.out.println(file.getAbsolutePath());
        if(!file.exists()){
            System.out.println("create share.txt");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testMkDir() {
        File file = new File("share.txt");
        System.out.println(file.getAbsolutePath());
        if(file.mkdir()){
            System.out.println("mkdir share.txt");
        }
//        if(!file.exists()){
//            System.out.println("create share.txt");
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        File file1 = new File("share");
        try {
            file1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(file1.mkdir()){
            System.out.println("mkdir share");
        }
    }
    @Test
    public void testMkDirs(){
        File file = new File("hello/fengyun/work/api");
        if(file.mkdir()){
            System.out.println("mkdir hello/fengyun/work/api");
        }

        File file1 = new File("hello/fengyun/work/api");
        if(file1.mkdirs()){
            System.out.println("mkdirs hello/fengyun/work/api");
        }
    }

}
