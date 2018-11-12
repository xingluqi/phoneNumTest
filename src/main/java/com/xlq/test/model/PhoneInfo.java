package com.xlq.test.model;

public class PhoneInfo
{
    //号码前缀
    String prefixNum = null;

    //省
    String province = null;

    //市
    String city = null;

    //运营商
    String T_Mobile = null;

    //区号
    String areaCode = null;

    //邮编
    String postCode = null;

    public String getPrefixNum()
    {
        return prefixNum;
    }

    public void setPrefixNum(String prefixNum)
    {
        this.prefixNum = prefixNum;
    }

    public String getProvince()
    {
        return province;
    }

    public void setProvince(String province)
    {
        this.province = province;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getT_Mobile()
    {
        return T_Mobile;
    }

    public void setT_Mobile(String t_Mobile)
    {
        T_Mobile = t_Mobile;
    }

    public String getAreaCode()
    {
        return areaCode;
    }

    public void setAreaCode(String areaCode)
    {
        this.areaCode = areaCode;
    }

    public String getPostCode()
    {
        return postCode;
    }

    public void setPostCode(String postCode)
    {
        this.postCode = postCode;
    }
}
