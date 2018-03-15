package com.santander.wf.poc.postprocessing.postprocGSD;

import com.workfusion.vds.api.nlp.model.Field;
import com.workfusion.vds.api.nlp.model.IeDocument;
import com.workfusion.vds.api.nlp.processing.IeProcessor;
import com.workfusion.vds.nlp.processing.normalization.OcrAmountNormalizer;

/**
 * Created by x263860 on 15/03/2018.
 */
public class NumbersProcessor implements IeProcessor {

    @Override

    public void process (IeDocument document){
      Field prima=document.findField("prima");
        if(prima!=null&&prima.getValue()!=null) {
            double auxPrima;
            if (prima.getValue().toUpperCase().contains("MM") || prima.getValue().toUpperCase().contains("MIO")) {
                String aux = prima.getValue().replaceAll("[a-zA-Z]+", "");
                auxPrima = Double.parseDouble(aux) * 1000000;
                prima.setValue(Double.toString(auxPrima));
            } else if(prima.getValue().toUpperCase().contains("K")){
                String aux = prima.getValue().replaceAll("[a-zA-Z]+", "");
                auxPrima = Double.parseDouble(aux) * 1000;
                prima.setValue(Double.toString(auxPrima));
            }
            else {
                OcrAmountNormalizer normalizer=new OcrAmountNormalizer();
                String correctValue=normalizer.normalize(prima.getValue());
                prima.setValue(correctValue);

            }
        }

    }
}
