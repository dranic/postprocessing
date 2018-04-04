package com.santander.wf.poc.postprocessing.tse.normolization;

import com.workfusion.vds.nlp.processing.normalization.OcrDateNormalizer;

import java.util.Calendar;

/**
 * Created by Dranitsa_PD on 17.03.2018.
 */
public class FVNormalizer extends OcrDateNormalizer {

    public FVNormalizer(){
        super("MM/dd/yyyy");
    }

    @Override
    public String normalize(String text) {
        if(text.matches("\\d{1,4}\\/\\d{1,4}\\/\\d{1,4}")) return text;
        if(text.contains("/")) {
            String[] result = text.split("/");
            if(result.length > 1)
            text = text.replaceAll("\\/\\d{1,2}","");
        }
        if(text.matches("^\\d{1,2}\\w{3}")){
            text += Calendar.getInstance().get(Calendar.YEAR);
        }
        return super.normalize(text);
    }
}