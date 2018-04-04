package com.santander.wf.poc.postprocessing.normolization;

import com.santander.wf.poc.postprocessing.tse.normolization.AmountNormalizer;
import com.santander.wf.poc.postprocessing.tse.normolization.CaseNormalizer;
import com.santander.wf.poc.postprocessing.tse.normolization.OpcionsNormalizer;
import org.junit.Test;

import java.util.Arrays;

public class OptionsTest {

    String[] opcions = {
            "Put",
            "Call",
            "Put",
            "USDPutMXNCall",
            "USDCallMXNPut",
            "USDCallMXNPut",
            "USDPutMXNCall",
            "USDPutMXNCall",
            "Call",
            "USDPutMXNCall",
            "USDCallMXNPut",
            "USDCallMXNPut",
            "USDCallMXNPut"
    };

    @Test
    public void normolizeOpcionTest() {
        Arrays.stream(opcions).forEach( opcion -> {
            OpcionsNormalizer normolizer1 = new OpcionsNormalizer(1);
            OpcionsNormalizer normolizer2 = new OpcionsNormalizer(2);
            System.out.println(opcion + "\t\t" + normolizer1.normalize(opcion)  + "\t\t" + normolizer2.normalize(opcion));
        });
    }


}