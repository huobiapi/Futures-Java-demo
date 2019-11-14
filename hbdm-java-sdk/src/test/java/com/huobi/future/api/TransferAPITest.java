package com.huobi.future.api;

import com.alibaba.fastjson.JSON;
import com.huobi.api.response.transfer.FuturesTransferResponse;
import com.huobi.api.service.transfer.TransferApiServiceImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;

/**
 * 合约划转接口
 */
@FixMethodOrder(MethodSorters.JVM)
public class TransferAPITest implements BaseTest {


    TransferApiServiceImpl transferApiService = new TransferApiServiceImpl("", "");

    @Test
    public void transfer() {
        //从合约账户到现货账户：“futures-to-pro”，从现货账户到合约账户： “pro-to-futures”
        BigDecimal amount = BigDecimal.valueOf(0.00090002);//注意划转的金额精度
        FuturesTransferResponse response =
                transferApiService.transfer("btc", amount, "pro-to-futures");
        logger.debug("1.现货-合约账户间进行资金的划转：{}", JSON.toJSONString(response));


    }


}
