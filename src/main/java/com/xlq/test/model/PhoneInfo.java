package com.xlq.test.model;

public class PhoneInfo
{
    //号码前缀
    private String prefixNum;

    //省
    private String province;

    //市
    private String city;

    //运营商
    private String T_Mobile;

    //区号
    private String areaCode;

    //邮编
    private String postCode;

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
