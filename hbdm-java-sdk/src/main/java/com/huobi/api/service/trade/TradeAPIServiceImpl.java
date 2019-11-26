package com.huobi.api.service.trade;

import com.alibaba.fastjson.JSON;
import com.huobi.api.constants.HuobiFutureAPIConstants;
import com.huobi.api.exception.ApiException;
import com.huobi.api.request.trade.*;
import com.huobi.api.response.trade.*;
import com.huobi.api.util.HbdmHttpClient;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TradeAPIServiceImpl implements TradeAPIService {


    String api_key = ""; // huobi申请的apiKey
    String secret_key = ""; // huobi申请的secretKey
    String url_prex = "https://api.hbdm.com";


    public TradeAPIServiceImpl(String api_key, String secret_key) {
        this.api_key = api_key;
        this.secret_key = secret_key;
    }


    @Override
    public ContractOrderResponse contractOrderRequest(ContractOrderRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();

            params.put("volume", request.getVolume());
            params.put("direction", request.getDirection().getValue());
            params.put("offset", request.getOffset().getValue());
            params.put("lever_rate", request.getLeverRate());
            params.put("order_price_type", request.getOrderPriceType());

            if (StringUtils.isNotEmpty(request.getSymbol()) && StringUtils.isNotEmpty(request.getContractType())) {
                params.put("symbol", request.getSymbol());
                params.put("contract_type", request.getContractType());
            }
            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode());
            }
            if (request.getPrice() != null) {
                params.put("price", request.getPrice());
            }
            if (request.getClientOrderId() != null) {
                params.put("client_order_id", request.getClientOrderId());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_ORDER, params);
            ContractOrderResponse response = JSON.parseObject(body, ContractOrderResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractBatchorderResponse contractBatchorderRequest(ContractBatchorderRequest request) {
        List<Map<String, Object>> listMap = new ArrayList<>();
        String body;
        try {

            request.getList().stream()
                    .forEach(e -> {
                        Map<String, Object> params = new HashMap<>();
                        params.put("volume", e.getVolume());
                        params.put("direction", e.getDirection().getValue());
                        params.put("offset", e.getOffset().getValue());
                        params.put("lever_rate", e.getLeverRate());
                        params.put("order_price_type", e.getOrderPriceType());
                        if (StringUtils.isNotEmpty(e.getSymbol()) && StringUtils.isNotEmpty(e.getContractType())) {
                            params.put("symbol", e.getSymbol());
                            params.put("contract_type", e.getContractType());
                        }
                        if (StringUtils.isNotEmpty(e.getContractCode())) {
                            params.put("contract_code", e.getContractCode());
                        }
                        if (e.getPrice() != null) {
                            params.put("price", e.getPrice());
                        }
                        if (e.getClientOrderId() != null) {
                            params.put("client_order_id", e.getClientOrderId());
                        }

                        listMap.add(params);
                    });
            Map<String, Object> params = new HashMap<>();

            params.put("orders_data", listMap);

            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_BATCHORDER, params);
            ContractBatchorderResponse response = JSON.parseObject(body, ContractBatchorderResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    /**
     * 撤销订单
     *
     * @param request 请求数据
     * @return
     */
    @Override
    public ContractCancelResponse contractCancelRequest(ContractCancelRequest request) {
        String body = "";
        try {
            Map<String, Object> params = new HashMap<>();
            if (request.getOrderId() != null) {
                params.put("order_id", request.getOrderId());
            }
            if (request.getClientOrderId() != null) {
                params.put("client_order_id", request.getClientOrderId());
            }
            params.put("symbol", request.getSymbol().toUpperCase());
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_CANCEL, params);
            ContractCancelResponse response = JSON.parseObject(body, ContractCancelResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            System.out.println("body:" + body);
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    /**
     * 全部撤单
     *
     * @param request 请求数据
     * @return
     */
    @Override
    public ContractCancelallResponse contractCancelallRequest(ContractCancelallRequest request) {
        String body = "";
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("symbol", request.getSymbol().toUpperCase());
            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode());
            }
            if (StringUtils.isNotEmpty(request.getContractType())) {
                params.put("contract_type", request.getContractType());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_CANCELALL, params);
            ContractCancelallResponse response = JSON.parseObject(body, ContractCancelallResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractOrderInfoResponse contractOrderInfoRequest(ContractOrderInfoRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(request.getSymbol())) {
                params.put("symbol", request.getSymbol().toUpperCase());
            }
            if (request.getClientOrderId() != null) {
                params.put("client_order_id", request.getClientOrderId());
            }
            if (request.getOrderId() != null) {
                params.put("order_id", request.getOrderId());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_ORDER_INFO, params);
            ContractOrderInfoResponse response = JSON.parseObject(body, ContractOrderInfoResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    /**
     * 获取订单明细信息
     *
     * @param request 请求数据
     * @return
     */
    @Override
    public ContractOrderDetailResponse contractOrderDetailRequest(ContractOrderDetailRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("symbol", request.getSymbol().toUpperCase());
            params.put("order_id", request.getOrderId());
            if (request.getCreatedAt() != null) {
                params.put("created_at", request.getCreatedAt());
            }
            params.put("order_type", request.getOrderType());
            if (request.getPageIndex() != null) {
                params.put("page_index", request.getPageIndex());
            }
            if (request.getPageSize() != null) {
                params.put("page_size", request.getPageSize());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_ORDER_DETAIL, params);
            ContractOrderDetailResponse response = JSON.parseObject(body, ContractOrderDetailResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    /**
     * 获取合约当前未成交委托
     *
     * @param request 请求数据
     * @return
     */
    @Override
    public ContractOpenordersResponse contractOpenordersRequest(ContractOpenordersRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("symbol", request.getSymbol().toUpperCase());
            if (request.getPageIndex() != null) {
                params.put("page_index", request.getPageIndex());
            }
            if (request.getPageSize() != null) {
                params.put("page_size", request.getPageSize());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_OPENORDERS, params);
            ContractOpenordersResponse response = JSON.parseObject(body, ContractOpenordersResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractHisordersResponse contractHisordersRequest(ContractHisordersRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(request.getSymbol())) {
                params.put("symbol", request.getSymbol().toUpperCase());
            }
            if (request.getTradeType() != null) {
                params.put("trade_type", request.getTradeType());
            }
            if (request.getType() != null) {
                params.put("type", request.getType());
            }
            if (request.getStatus() != null) {
                params.put("status", request.getStatus());
            }
            if (request.getCreateDate() != null) {
                params.put("create_date", request.getCreateDate());
            }
            if (request.getPageIndex() != null) {
                params.put("page_index", request.getPageIndex());
            }
            if (request.getPageSize() != null) {
                params.put("page_size", request.getPageSize());
            }
            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode().toUpperCase());
            }

            if (StringUtils.isNotEmpty(request.getOrderType())) {
                params.put("order_type", request.getOrderType());
            }


            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_HISORDERS, params);
            ContractHisordersResponse response = JSON.parseObject(body, ContractHisordersResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public ContractMatchresultsResponse contractMatchresultsRequest(ContractMatchresultsRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("symbol", request.getSymbol().toUpperCase());
            params.put("trade_type", request.getTradeType());
            params.put("create_date", request.getCreateDate());

            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode().toUpperCase());
            }
            if (request.getPageIndex() != null) {
                params.put("page_index", request.getPageIndex());
            }
            if (request.getPageSize() != null) {
                params.put("page_size", request.getPageSize());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.CONTRACT_MATCHRESULTS, params);
            ContractMatchresultsResponse response = JSON.parseObject(body, ContractMatchresultsResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }

    @Override
    public LightningClosePositionResponse lightningClosePositionRequest(LightningClosePositionRequest request) {
        String body;
        try {
            Map<String, Object> params = new HashMap<>();
            if (StringUtils.isNotEmpty(request.getSymbol())) {
                params.put("symbol", request.getSymbol().toUpperCase());
            }
            if (StringUtils.isNotEmpty(request.getContractCode())) {
                params.put("contract_code", request.getContractCode());
            }
            if (StringUtils.isNotEmpty(request.getContractType())) {
                params.put("contract_type", request.getContractType());
            }
            params.put("direction", request.getDirection());
            params.put("volume", request.getVolume());
            if (request.getClientOrderId() != null) {
                params.put("client_order_id", request.getClientOrderId());
            }
            body = HbdmHttpClient.getInstance().doPost(api_key, secret_key, url_prex + HuobiFutureAPIConstants.LIGHTNING_CLOSE_POSITION, params);
            LightningClosePositionResponse response = JSON.parseObject(body, LightningClosePositionResponse.class);
            if ("ok".equalsIgnoreCase(response.getStatus())) {
                return response;
            }

        } catch (Exception e) {
            throw new ApiException(e);
        }
        throw new ApiException(body);
    }
}
