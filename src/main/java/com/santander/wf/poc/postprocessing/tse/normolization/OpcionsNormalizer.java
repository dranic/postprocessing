package com.santander.wf.poc.postprocessing.tse.normolization;

import com.workfusion.vds.api.nlp.normalization.Normalizer;

/**
 * Created by Dranitsa_PD on 17.03.2018.
 */
public class OpcionsNormalizer implements Normalizer {
    public static final int OPTION_1 = 1;
    public static final int OPTION_2 = 2;
    public static final String PUT = "PUT";
    public static final String CALL = "CALL";
    private int type = 1;

    public OpcionsNormalizer(int type){
        this.type = type;
    }

    @Override
    public String normalize(String text) {
        text = text.toUpperCase();
        if(text.contains(PUT) && text.contains(CALL)){
            int putPosition = text.indexOf(PUT);
            int callPosition = text.indexOf(CALL);
            if(type == OPTION_1) {
                text = putPosition < callPosition ? PUT : CALL;
            } else {
                text = putPosition > callPosition ? PUT : CALL;
            }
        }
        if(text.contains(PUT)) {
            text = PUT;
        }
        if(text.contains(CALL)) {
            text = CALL;
        }
        return text;
    }
}