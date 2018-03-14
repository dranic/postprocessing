package com.santander.wf.poc.postprocessing;

import com.workfusion.vds.api.nlp.model.Field;
import com.workfusion.vds.api.nlp.model.IeDocument;
import com.workfusion.vds.api.nlp.processing.IeProcessor;
import com.workfusion.vds.api.nlp.processing.ProcessingException;

public class PostProcessorExample implements IeProcessor {

    @Override
    public void process(IeDocument document) throws ProcessingException {
        Field amount = document.findField("invoice_amount");
        if (amount != null && amount.getValue() != null) {
            String value = amount.getValue();
            amount.setValue(value.replaceAll("G", "6").replaceAll("B", "8").replaceAll("O", "0"));
        }
    }
}
