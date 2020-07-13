package invoice;/**
 * Copyright (C), 2020-2020, 软件公司
 * FileName: RushiInvoiceService
 * Author:   cakin
 * Date:     2020/7/13
 * Description:
 */


import invoice.dto.CertificationRequestDto;
import invoice.dto.CertificationResponseDto;
import invoice.dto.RushiCertificationRequestDto;
import invoice.dto.RushiCertificationResponseDto;

/**
 * @ClassName: RushiInvoiceService
 * @Description: TODO
 * @Date: 2020/7/13
 * @Author: cakin
 */
public class RushiInvoiceServiceImpl implements InvoiceService {
    @Override
    public CertificationResponseDto certification(CertificationRequestDto dto) {
        ((RushiCertificationRequestDto)dto).setToken("12345");
        RushiCertificationResponseDto resDto = new RushiCertificationResponseDto();
        return resDto;
    }
//    @Override
//    public CertificationResponseDto certification(CertificationRequestDto dto) {
//        String url = new PropertiesUtils().readProperty("certification_url");
//        String jwtToken =  new PropertiesUtils().readProperty("RushiJwtKey");
//        ((RushiCertificationRequestDto)dto).setToken(jwtToken);
//        String requestJson = JSON.toJSONString(dto);
//        String res = HttpClientUtils.sendPostByJson(url, requestJson);
//        RushiCertificationResponseDto resDto = new JSONObject().parseObject(res, RushiCertificationResponseDto.class);
//        return resDto;
//    }
}
