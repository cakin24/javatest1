package invoice;/**
 * Copyright (C), 2020-2020, 软件公司
 * FileName: test
 * Author:   cakin
 * Date:     2020/7/13
 * Description:
 */

import invoice.dto.CertificationRequestDto;
import invoice.dto.RushiCertificationRequestDto;

/**
 * @ClassName: test
 * @Description: TODO
 * @Date: 2020/7/13
 * @Author: cakin
 */
public class test {
    public static void main(String[] args) {
        // 确定策略 1：如是 2：惠多多
        System.out.println("根据某种算法确定策略");
        int strategy = 1;
        switch (strategy) {
            case 1: {
                RushiInvoiceServiceImpl rushiInvoiceService = new RushiInvoiceServiceImpl();
                RushiCertificationRequestDto dto = new RushiCertificationRequestDto();
                dto.setBank("中国银行");
                rushiInvoiceService.certification(dto);
                System.out.println("测试OK");
                break;
            }
            case 2: {
                System.out.println("惠多多逻辑");
                break;
            }
            default: {
                break;
            }
        }
    }
}
