package com.xyren.devtool.zd;

import org.springframework.util.Base64Utils;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TransferBase64 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        InputStreamReader inputStreamReader = null;
        BufferedReader bf = null;
        try {
            String path = ResourceUtils.getURL("classpath:").getPath();
            System.out.println(path);
            inputStreamReader = new InputStreamReader(new FileInputStream(new File(path + "title.txt")));
            bf = new BufferedReader(inputStreamReader);
            //行读取
            String str;
            while ((str = bf.readLine()) != null){
                list.add(str);
            }

            Iterator<String> it = list.iterator();
            while (it.hasNext()){
                String titleBase64 = (String) it.next();
                String title = new String(Base64Utils.decodeFromString(titleBase64),"UTF-8");

                System.out.println(title);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            try {
                bf.close();
                inputStreamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
