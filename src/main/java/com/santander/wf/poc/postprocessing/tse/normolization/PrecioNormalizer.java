package com.santander.wf.poc.postprocessing.tse.normolization;

import com.workfusion.vds.api.nlp.normalization.Normalizer;
import java.math.BigDecimal;

/**
 * Created by Dranitsa_PD on 17.03.2018.
 */
public class PrecioNormalizer implements Normalizer {

    public static final String LETTERS_AND_SPECIAL = "[a-zA-Z\\s()%,]+";

    @Override
    public String normalize(String text) {
        String temp;
        if (text.toUpperCase().contains("PER1") || text.toUpperCase().contains("POINTS")) {
            temp = text.toUpperCase().replaceAll("PER1", "");
            temp = temp.replaceAll(LETTERS_AND_SPECIAL, "");
            BigDecimal result = stringToBigDecimal(temp);
            if(result != null) {
                result = result.divide(new BigDecimal(100));
                return result.toString();
            } else {
                return text.replaceAll(LETTERS_AND_SPECIAL,"");
            }
        }
        BigDecimal result = stringToBigDecimal(text.replaceAll(LETTERS_AND_SPECIAL,""));
        return result == null ? text : result.toString();
    }

    private BigDecimal stringToBigDecimal(String number){
        try{
            return new BigDecimal(number);
        } catch (NumberFormatException exc) {
            return null;
        }
    }
}