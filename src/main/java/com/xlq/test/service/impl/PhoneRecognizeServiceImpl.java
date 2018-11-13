package com.xlq.test.service.impl;

import com.xlq.test.model.PhoneInfo;
import com.xlq.test.service.PhoneRecognizeService;

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

    private static Map<String, PhoneInfo> phoneInfoMap = new LinkedHashMap<String, PhoneInfo>();

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
                phoneInfo.setAreaCode(data[4]);
                phoneInfo.setPostCode(data[5]);
                phoneInfoMap.put(phoneInfo.getPrefixNum(), phoneInfo);
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public PhoneInfo onCall(String phone)
    {
        PhoneInfo phoneInfo = new PhoneInfo();
        String phoneNum = phone.substring(0, 7);
        int i = 0;
        List<String> list = new ArrayList<String>();
        for (Map.Entry<String, PhoneInfo> phoneInfoEntry : phoneInfoMap.entrySet())
        {
            list.add(phoneInfoEntry.getKey());
        }
        phoneInfo = binarySearch(list, 0, list.size(), Integer.parseInt(phoneNum));
        return phoneInfo;
    }

    public static PhoneInfo binarySearch(List<String> arr, int start, int end, int hkey)
    {
        PhoneInfo phoneInfo = null;
        int result = -1;
        while (start <= end)
        {
            int mid = start + (end - start) / 2;
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
        return phoneInfoMap.get(arr.get(result));
    }

}