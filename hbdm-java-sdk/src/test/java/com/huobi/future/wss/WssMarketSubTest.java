package com.huobi.future.wss;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.huobi.wss.event.MarketDepthSubResponse;
import com.huobi.wss.event.MarketDetailSubResponse;
import com.huobi.wss.event.MarketKLineSubResponse;
import com.huobi.wss.handle.WssMarketHandle;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URISyntaxException;
import java.util.List;

public class WssMarketSubTest {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private String URL = "wss://www.btcgateway.pro/ws";//合约站行情请求以及订阅地址
    WssMarketHandle wssMarketHandle = new WssMarketHandle(URL);


    /**
     * 订阅 KLine 数据
     * market.$symbol.kline.$period
     * $symbol 如"BTC_CW"表示BTC当周合约，"BTC_NW"表示BTC次周合约，"BTC_CQ"表示BTC季度合约
     * $period 如 1min, 5min, 15min, 30min, 1hour,4hour,1day, 1mon
     * <p>
     * 注：一个webSocket 可以一次订阅多个
     *
     * @throws URISyntaxException
     * @throws InterruptedException
     */
    @Test
    public void test1() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("market.BTC_CW.kline.1min");
        channels.add("market.BTC_CW.kline.5min");
        channels.add("market.BTC_CW.kline.15min");
        channels.add("market.BTC_CW.kline.30min");
        channels.add("market.BTC_CW.kline.60min");
        channels.add("market.BTC_CW.kline.4hour");
        channels.add("market.BTC_CW.kline.1day");
        channels.add("market.BTC_CW.kline.1week");
        channels.add("market.BTC_CW.kline.1mon");



        wssMarketHandle.sub(channels, response -> {
            logger.info("kLineEvent用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            MarketKLineSubResponse event = JSON.parseObject(response, MarketKLineSubResponse.class);
            logger.info("kLineEvent的ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);


    }


    /**
     * 订阅 Market Depth 数据
     * market.$symbol.depth.$type
     * $symbol 如"BTC_CW"表示BTC当周合约，"BTC_NW"表示BTC次周合约，"BTC_CQ"表示BTC季度合约.
     * $type  (150档数据) step0, step1, step2, step3, step4, step5（合并深度1-5）,step0时，不合并深度;(20档数据) step6, step7, step8, step9, step10, step11（合并深度7-11）；step6时，不合并深度
     * <p>
     * 注：一个webSocket 可以一次订阅多个
     *
     * @throws URISyntaxException
     * @throws InterruptedException
     */
    @Test
    public void test2() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        //channels.add("market.BTC_CW.depth.step0");
        channels.add("market.BTC_CW.depth.step11");
        wssMarketHandle.sub(channels, response -> {
            logger.info("depthEvent用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            MarketDepthSubResponse event = JSON.parseObject(response, MarketDepthSubResponse.class);
            logger.info("depthEvent的ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
            logger.info("数据大小为:{}", event.getTick().getAsks().size());
        });
        Thread.sleep(Integer.MAX_VALUE);

    }


    /**
     * 订阅 Market detail 数据
     * market.$symbol.detail
     * $symbol 如"BTC_CW"表示BTC当周合约，"BTC_NW"表示BTC次周合约，"BTC_CQ"表示BTC季度合约
     * <p>
     * 注：一个webSocket 可以一次订阅多个
     *
     * @throws URISyntaxException
     * @throws InterruptedException
     */
    @Test
    public void test3() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("market.BTC_CW.detail");
        channels.add("market.BTC_NW.detail");
        wssMarketHandle.sub(channels, response -> {
            logger.info("detailEvent用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            MarketDetailSubResponse event = JSON.parseObject(response, MarketDetailSubResponse.class);
            logger.info("detailEvent的ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }


    /**
     * 订阅 Trade Detail 数据
     * "sub": "market.$symbol.trade.detail"
     * symbol	合约名称		如"BTC_CW"表示BTC当周合约，"BTC_NW"表示BTC次周合约，"BTC_CQ"表示BTC季度合约
     *
     * @throws URISyntaxException
     * @throws InterruptedException
     */
    @Test
    public void test4() throws URISyntaxException, InterruptedException {
        List<String> channels = Lists.newArrayList();
        channels.add("market.BTC_CW.trade.detail");
        channels.add("market.BTC_NW.trade.detail");
        wssMarketHandle.sub(channels, response -> {
            logger.info("订阅TradeDetail数据用户收到的数据===============:{}", JSON.toJSON(response));
            Long currentTimeMillis = System.currentTimeMillis();
            MarketDetailSubResponse event = JSON.parseObject(response, MarketDetailSubResponse.class);
            logger.info("detailEvent的ts为：{},当前的时间戳为：{},时间间隔为：{}毫秒", event.getTs(), currentTimeMillis, currentTimeMillis - event.getTs());
        });
        Thread.sleep(Integer.MAX_VALUE);
    }


}
