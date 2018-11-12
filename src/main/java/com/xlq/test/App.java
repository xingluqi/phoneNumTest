package com.xlq.test;

import com.xlq.test.model.PhoneInfo;
import com.xlq.test.service.impl.phoneRecognizeServiceImpl;
import com.xlq.test.service.phoneRecognizeService;

import java.util.Scanner;

public class App
{

    public static void main(String[] args)
    {
        phoneRecognizeService phoneRecognizeService = new phoneRecognizeServiceImpl();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext())
        {
            PhoneInfo phoneInfo = phoneRecognizeService.onCall(scanner.next());
            System.out.println(
                "省份： " + phoneInfo.getProvince() + " 地区： " + phoneInfo.getCity() + " 运营商： " + phoneInfo.getT_Mobile() +
                    " 地区邮政编号" + phoneInfo.getPostCode());
        }
    }
}
