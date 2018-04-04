package com.santander.wf.poc.postprocessing.tse.normolization;

import com.workfusion.vds.api.nlp.normalization.Normalizer;

/**
 * Created by Dranitsa_PD on 17.03.2018.
 */
public class DivisasNormalizer implements Normalizer {
    public static final int DIVISA_1 = 1;
    public static final int DIVISA_2 = 2;
    public static final String PUT = "PUT";
    public static final String CALL = "CALL";
    private int type = DIVISA_1;

    public DivisasNormalizer(int type){
        this.type = type;
    }

    @Override
    public String normalize(String text) {
        text = text.toUpperCase();
        if(text.contains(PUT) && text.contains(CALL)){
            text = text.replaceAll(CALL,"").replaceAll(PUT,"");
        }
        if(text.length() == 6) {
            switch (type) {
                case DIVISA_1: text = text.substring(0,3);
                    break;
                case DIVISA_2: text = text.substring(3,6);
                    break;
            }
        }
        return text;
    }
}