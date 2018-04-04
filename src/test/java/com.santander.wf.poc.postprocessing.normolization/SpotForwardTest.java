package com.santander.wf.poc.postprocessing.normolization;

import com.santander.wf.poc.postprocessing.tse.normolization.OpcionsNormalizer;
import com.santander.wf.poc.postprocessing.tse.normolization.SpotForwardNormalizer;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

public class SpotForwardTest {

    String[] data = {
            "Forward",
            "Fwd",
            "Fwd",
            "fwd",
            "spot",
            "Fwd",
            "Forward",
            "fwd",
            "Spot",
            "Fwd",
            "Spot",
            "Spot",
            "fwd",
            "Spot",
            "Fwd",
            "Spot",
            "Fwd",
            "Fwd",
            "Fwd",
            "Fwd",
            "Fwd",
            "Fwd",
            "Spot",
            "Fwd",
            "Fwd",
            "Fwd",
            "Spot",
            "Fwd",
            "spot",
            "Forward",
            "Forward",
            "Spot",
            "SPOT",
            "Forward",
            "SPOT",
            "Spot",
            "Spot",
            "Spot",
            "Spot",
            "Spot",
            "Forward",
            "Forward",
            "SPOT"
    };

    @Test
    public void normolizeOpcionTest() {
        Arrays.stream(data).forEach( text -> {
            SpotForwardNormalizer normolizer = new SpotForwardNormalizer();
            System.out.println(text + "\t\t" + normolizer.normalize(text));
        });
    }


    @Test
    public void testBigDecimal(){
        BigDecimal b = new BigDecimal(0.699999);

        System.out.println(b.compareTo(new BigDecimal(0.7)));
    }

}