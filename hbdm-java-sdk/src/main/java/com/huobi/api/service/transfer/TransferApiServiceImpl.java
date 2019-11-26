package com.huobi.api.service.transfer;

import com.alibaba.fastjson.JSON;
import com.huobi.api.constants.HuobiFutureAPIConstants;
import com.huobi.api.exception.ApiException;
import com.huobi.api.response.transfer.FuturesTransferResponse;
import com.huobi.api.util.HbdmHttpClient;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class TransferApiServiceImpl implements TransferApiService {

    String api_key = ""; // huobi申请的apiKey
    String secret_key = ""; // huobi申请的secretKey
    String url_prex = "https://api.huobi.pro";

    public TransferApiServiceImpl(String api_key, String secret_key) {
        this.api_key = api_key;
        this.secret_key = secret_key;
    }


    /**
     * @param currency 币
     * @param amount   金额  注意划转的金额精度
     * @param type     从合约账户到现货账户：“futures-to-pro”，从现货账户到合约账户： “pro-to-futures”
     * @return
     */
    @Override
    public FuturesTransferResponse transfer(String currency, BigDecimal amount, String type) {
        String body = "";
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("currency", currency.toLowerCase());
            params.put("amount", amount);
            params.put("type", type);
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.FUTURES_TRANSFER, params);
            FuturesTransferResponse response = JSON.parseObject(body, FuturesTransferResponse.class);
            return response;

        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
