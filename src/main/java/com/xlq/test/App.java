package com.xlq.test;

import com.xlq.test.model.PhoneInfo;
import com.xlq.test.service.impl.PhoneRecognizeServiceImpl;
import com.xlq.test.service.PhoneRecognizeService;

import java.util.Scanner;

public class App
{

    public static void main(String[] args)
    {
        PhoneRecognizeService phoneRecognizeService = new PhoneRecognizeServiceImpl();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext())
        {
            PhoneInfo phoneInfo = phoneRecognizeService.onCall(scanner.next());
            System.out.println(
                "省：" + phoneInfo.getProvince() + ";\n市：" + phoneInfo.getCity() + ";\n运营商:" + phoneInfo.getT_Mobile() +
                    ";\n区号:" + phoneInfo.getAreaCode() + ";\n邮政编号" + phoneInfo.getPostCode() + "。");
        }
    }
}
