package invoice.dto;/**
 * Copyright (C), 2020-2020, 软件公司
 * FileName: RushiCertificationRequestDto
 * Author:   cakin
 * Date:     2020/7/13
 * Description:
 */

/**
 * @ClassName: RushiCertificationRequestDto
 * @Description: TODO
 * @Date: 2020/7/13
 * @Author: cakin
 */
public class RushiCertificationRequestDto extends CertificationRequestDto{
    private  String name;

    private  String token;

    private  String idNo;

    private  String frontBase64;

    private  String backBase64;

    private  String idBank;

    private  String bank;

    private String mobile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getFrontBase64() {
        return frontBase64;
    }

    public void setFrontBase64(String frontBase64) {
        this.frontBase64 = frontBase64;
    }

    public String getBackBase64() {
        return backBase64;
    }

    public void setBackBase64(String backBase64) {
        this.backBase64 = backBase64;
    }

    public String getIdBank() {
        return idBank;
    }

    public void setIdBank(String idBank) {
        this.idBank = idBank;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
