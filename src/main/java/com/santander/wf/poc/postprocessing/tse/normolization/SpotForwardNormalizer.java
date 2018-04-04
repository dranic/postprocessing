package com.santander.wf.poc.postprocessing.tse.normolization;

import com.workfusion.vds.api.nlp.normalization.Normalizer;

/**
 * Created by Dranitsa_PD on 17.03.2018.
 */
public class SpotForwardNormalizer implements Normalizer {
    @Override
    public String normalize(String text) {
        if("fwd".equalsIgnoreCase(text) || "forward".equalsIgnoreCase(text))
            text = "forward";
        if ("spot".equalsIgnoreCase(text))
            text = "Spot";
        return text;
    }
}