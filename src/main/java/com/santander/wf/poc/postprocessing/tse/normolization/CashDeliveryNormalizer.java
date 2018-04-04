package com.santander.wf.poc.postprocessing.tse.normolization;

import com.workfusion.vds.api.nlp.normalization.Normalizer;

/**
 * Created by Dranitsa_PD on 17.03.2018.
 */
public class CashDeliveryNormalizer implements Normalizer {
    @Override
    public String normalize(String text) {
        String temp = text.toUpperCase();
        if(temp.contains("CASH"))
            text = "Cash";
        else if(temp.contains("DELIVERY"))
            text = "Delivery";
        else
            text = "";

        return text;
    }
}