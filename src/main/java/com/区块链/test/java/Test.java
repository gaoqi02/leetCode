package com.区块链.test.java;

import com.alibaba.fastjson.JSONObject;
import org.fisco.bcos.sdk.v3.BcosSDK;
import org.fisco.bcos.sdk.v3.client.Client;
import org.fisco.bcos.sdk.v3.client.protocol.response.BlockNumber;
import org.fisco.bcos.sdk.v3.codec.datatypes.generated.tuples.generated.Tuple2;
import org.fisco.bcos.sdk.v3.crypto.keypair.CryptoKeyPair;
import org.fisco.bcos.sdk.v3.model.TransactionReceipt;

import java.math.BigInteger;

public class Test {

    // 获取配置文件路径
    public final static String configFile = Test.class.getClassLoader().getResource("config.toml").getPath();

    public static void testClient() throws Exception {
        // 初始化BcosSDK
        BcosSDK sdk =  BcosSDK.build(configFile);
        // 为群组group初始化client
        Client client = sdk.getClient("group0");

        // 获取群组1的块高
        BlockNumber blockNumber = client.getBlockNumber();

        // 向群组1部署HelloWorld合约
        CryptoKeyPair cryptoKeyPair = client.getCryptoSuite().getCryptoKeyPair();
        TableTestV320 helloWorld = TableTestV320.deploy(client, cryptoKeyPair);


        // 调用HelloWorld合约的set接口
        TransactionReceipt receipt = helloWorld.insert(new BigInteger("1"),"Hello, fisco", "a");
        int blockNum = receipt.getBlockNumber().intValue();

        Tuple2<String,String> tuple2 = helloWorld.select(new BigInteger("2"));
        System.out.println(JSONObject.toJSON(tuple2));
    }

    public static void main(String[] args) {
        try {
            testClient();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
