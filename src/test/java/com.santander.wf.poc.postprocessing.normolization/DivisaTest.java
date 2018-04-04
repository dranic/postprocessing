package com.santander.wf.poc.postprocessing.normolization;

import com.santander.wf.poc.postprocessing.tse.normolization.DivisasNormalizer;
import com.santander.wf.poc.postprocessing.tse.normolization.OpcionsNormalizer;
import org.junit.Test;

import java.util.Arrays;

public class DivisaTest {

    String[] divisas = {
            "GBP",
            "EURPLN",
            "USD",
            "EURUSD",
            "USDPutMXNCall",
            "USDPutMXNCall",
            "USDPutMXNCall",
            "USDPutMXNCall",
            "USD",
            "USDCallMXNPut",
            "USDPutMXNCall",
            "USDPutMXNCall",
            "USDCallMXNPut",
            "USDCAD",
            "USDPutMXNCall",
            "USDPutMXNCall",
            "USDPutMXNCall",
            "USDPutMXNCall",
            "USDCAllMXNPut",
            "USDPutMXNCall",
            "USDCallMXNPut",
            "USDCallMXNPut",
            "USDPutMXNCall",
            "USDPutMXNCall",
            "USDCAD",
            "USDCallMXNput",
            "USDPutMXNCall",
            "USDCallMXNput",
            "USDCallMXNPut",
            "USDCallMXNPut",
            "mxn",
            "GBP",
            "PLN",
            "MXN",
            "GBP",
            "USD",
            "USDCAD",
            "USDCAD",
            "EURGBP",
            "EURUSD",
            "EURGBP",
            "USDCAD",
            "USD",
            "GBP",
            "MXN",
            "USD",
            "SEK",
            "USD",
            "EURGBP",
            "USDPUTMXNCall",
            "COP",
            "USDBRL",
            "USDBRL",
            "USDBRL",
            "USDMXN",
            "EUR",
            "USDMXN",
            "USDMXN",
            "USDMXN",
            "USDMXN",
            "USDMXN",
            "GBP",
            "USDBRL",
            "USDBRL",
            "USDBRL",
            "USDMXN",
            "USDMXN",
            "PLN",
            "USDMXN",
            "USDBRL",
            "USDBRL",
            "USDMXN",
            "GBP",
            "USDMXN",
            "USD",
            "USDCAD",
            "GBP",
            "MXN",
            "CNH",
            "USDCAD"
    };

    @Test
    public void normolizeOpcionTest() {
        Arrays.stream(divisas).forEach( divisa -> {
            DivisasNormalizer normolizer1 = new DivisasNormalizer(1);
            DivisasNormalizer normolizer2 = new DivisasNormalizer(2);
            System.out.println(divisa + "\t\t" + normolizer1.normalize(divisa)  + "\t\t" + normolizer2.normalize(divisa));
        });
    }


}