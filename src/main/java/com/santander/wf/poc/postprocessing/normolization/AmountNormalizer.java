package com.santander.wf.poc.postprocessing.normolization;

import com.workfusion.vds.nlp.processing.normalization.OcrAmountNormalizer;

/**
 * Created by Dranitsa_PD on 17.03.2018.
 */
public class AmountNormalizer extends OcrAmountNormalizer {

    public static final String LETTERS_AND_SPACE = "[a-zA-Z\\s]+";
    @Override
    public String normalize(String text) {
        if (text.toUpperCase().contains("M")) {
            text = text.replaceAll(LETTERS_AND_SPACE, "") + "000000";
        } else if(text.toUpperCase().contains("K")){
            text = text.replaceAll(LETTERS_AND_SPACE, "") + "000";
        }
        return super.normalize(text);
    }
}