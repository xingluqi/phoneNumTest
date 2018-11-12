package com.xlq.test;

import com.xlq.test.model.PhoneInfo;

import java.io.*;

public class phoneNumData
{
    public static void readTxtFile()
    {
        try
        {
            String filePath = "D:\\Chrome Download\\phone.data.txt";
            String encoding = "UTF-8";
            File file = new File(filePath);
            if (file.isFile() && file.exists())//判断文件是否存在
            {
                InputStreamReader
                    read = new InputStreamReader(
                    new FileInputStream(file), encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null)
                {
                    //System.out.println(lineTxt);
                    String[] phoneData = lineTxt.split("\t");
                    System.out.println(phoneData);
                    PhoneInfo pi = new PhoneInfo();
                    pi.setPrefixNum(phoneData[0]);//号码前缀
                    pi.setProvince(phoneData[1]);//省
                    pi.setCity(phoneData[2]);//市
                    pi.setT_Mobile(phoneData[3]);//运营商
                    pi.setAreaCode(phoneData[4]);//区号
                    pi.setPostCode(phoneData[5]);//邮编
                }
                read.close();
            }
            else
            {
                System.out.println("找不到指定的文件");
            }
        }
        catch (Exception e)
        {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }

    }

    public static void main(String[] args)
    {
        readTxtFile();
    }
}
