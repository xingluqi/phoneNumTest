package com.xlq.test.service.impl;

import com.xlq.test.model.PhoneInfo;
import com.xlq.test.service.PhoneRecognizeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PhoneRecognizeServiceImpl implements PhoneRecognizeService
{
    private static Logger logger = LoggerFactory.getLogger(PhoneRecognizeServiceImpl.class);

    private static Map<String, PhoneInfo> caches = new LinkedHashMap<String, PhoneInfo>();

    //将resources中的文件全部读取到缓存区,并存入caches中
    static
    {
        String line = null;
        InputStream inputStream = PhoneRecognizeServiceImpl.class.getResourceAsStream("/phone.data.txt");
        try
        {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while ((line = bufferedReader.readLine()) != null)
            {
                String[] data = null;
                data = line.split("\t");
                PhoneInfo phoneInfo = new PhoneInfo();
                phoneInfo.setPrefixNum(data[0]);
                phoneInfo.setProvince(data[1]);
                phoneInfo.setCity(data[2]);
                phoneInfo.setT_Mobile(data[3]);
                phoneInfo.setCity(data[4]);
                phoneInfo.setPostCode(data[5]);
                caches.put(phoneInfo.getPrefixNum(), phoneInfo);
            }
        }
        catch (IOException e)
        {
            logger.error(" ", e);
        }
    }

    /**
     * 实现电话号码的运营商和地区的识别
     *
     * @param phone 电话号码
     * @return PhoneInfo
     */
    public PhoneInfo onCall(String phone)
    {
        PhoneInfo phoneInfo = new PhoneInfo();
        //获得号码的前七位
        String phoneNum = phone.substring(0, 7);
        //用二分法找出和caches中匹配的数据,如果没匹配到，则返回null
        int i = 0;
        List<String> list = new ArrayList<String>();
        for (Map.Entry<String, PhoneInfo> phoneInfoEntry : caches.entrySet())
        {
            list.add(phoneInfoEntry.getKey());
        }
        phoneInfo = binarySearch(list, 0, list.size(), Integer.parseInt(phoneNum));
        return phoneInfo;
    }

    /**
     * 二分法查找匹配的数据
     *
     * @param arr   List<String>
     * @param start
     * @param end
     * @param hkey
     * @return PhoneInfo
     */
    public static PhoneInfo binarySearch(List<String> arr, int start, int end, int hkey)
    {
        PhoneInfo phoneInfo = null;
        int result = -1;
        while (start <= end)
        {
            int mid = start + (end - start) / 2;    //防止溢位
            if (Integer.parseInt(arr.get(mid)) > hkey)
            {
                end = mid - 1;
            }

            else if (Integer.parseInt(arr.get(mid)) < hkey)
            {
                start = mid + 1;
            }

            else
            {
                result = mid;
                break;
            }
        }
        if (result == -1)
        {
            return null;
        }
        return caches.get(arr.get(result));
    }

}