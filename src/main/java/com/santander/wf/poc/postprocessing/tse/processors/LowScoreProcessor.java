package com.santander.wf.poc.postprocessing.tse.processors;

import com.workfusion.vds.api.nlp.model.Field;
import com.workfusion.vds.api.nlp.model.IeDocument;
import com.workfusion.vds.api.nlp.processing.IeProcessor;
import com.workfusion.vds.api.nlp.processing.ProcessingException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by Dranitsa_PD on 17.03.2018.
 */
public class LowScoreProcessor implements IeProcessor {
    public static BigDecimal TRASHOLD = new BigDecimal(0.7);
    String [] fieldNames = {"nominal2","spot_forward","tipo_de_opcion"};

    protected void processField(IeDocument document, Field field) {
        if(field.getScore().compareTo(TRASHOLD) == -1){
            document.remove(field);
        }
    }

    @Override
    public void process(IeDocument document) throws ProcessingException {
        Arrays.stream(fieldNames).forEach( fieldName -> {
            Collection<Field> fields = document.findFields(fieldName);
            fields.forEach(field -> processField(document,field));
        });
    }
}
