package com.huobi.api.service.transfer;

import com.huobi.api.response.transfer.FuturesTransferResponse;

import java.math.BigDecimal;

public interface TransferApiService {

    FuturesTransferResponse transfer(String currency, BigDecimal amount, String type);
}
