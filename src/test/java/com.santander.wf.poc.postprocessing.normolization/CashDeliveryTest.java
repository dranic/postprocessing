package com.santander.wf.poc.postprocessing.normolization;

import com.santander.wf.poc.postprocessing.tse.normolization.CashDeliveryNormalizer;
import com.santander.wf.poc.postprocessing.tse.normolization.SpotForwardNormalizer;
import org.junit.Test;

import java.util.Arrays;

public class CashDeliveryTest {

    String[] data = {
            "Delivery",
            "Delivery",
            "Delivery",
            "Physical",
            "USDPutMXNCall",
            "USDPutMXNCall",
            "USDPutMXNCall",
            "USDPutMXNCall",
            "Physical",
            "USDPutMXNCall",
            "USDPutMXNCall",
            "Physical",
            "USDPutMXNCall",
            "USDPutMXNCall",
            "USDPutMXNCall",
            "USDPutMXNCall",
            "USDCAllMXNPut",
            "Delivery",
            "USDPutMXNCall",
            "USDCallMXNPut",
            "USDCallMXNPut",
            "USDPutMXNCall",
            "USDPutMXNCall",
            "Physical",
            "USDCallMXNput",
            "USDPutMXNCall",
            "USDCallMXNPut",
            "USDCallMXNPut",
            "delivery",
            "Physical",
            "Cash Settlement",
            "Physical",
            "Delivery",
            "Delivery",
            "Delivery",
            "Delivery",
            "Delivery",
            "Delivery",
            "Delivery",
            "Delivery",
            "delivery",
            "Physical",
            "FxEuroOpt",
            "Delivery",
            "USDPUTMXNCall",
            "Delivery",
            "Delivery",
            "HEDGE",
            "Delivery",
            "Delivery",
            "Delivery",
            "Delivery",
            "Delivery",
            "Delivery",
            "Delivery",
            "Delivery",
            "Delivery",
            "Delivery",
            "Delivery",
            "Delivery",
            "Delivery",
            "Delivery",
            "Delivery",
            "Delivery",
            "Physical",
            "Physical",
            "Physical",
            "Physical",
            "Physical",
            "Delivery"
    };

    @Test
    public void normolizeOpcionTest() {
        Arrays.stream(data).forEach( text -> {
            CashDeliveryNormalizer normolizer = new CashDeliveryNormalizer();
            System.out.println(text + "\t\t" + normolizer.normalize(text));
        });
    }


}