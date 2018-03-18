package com.santander.wf.poc.postprocessing.processors;

import java.util.Arrays;
import java.util.Collection;

import normolization.AmountNormalizer;
import normolization.CaseNormalizer;
import com.workfusion.vds.api.nlp.model.Field;
import com.workfusion.vds.api.nlp.model.IeDocument;
import com.workfusion.vds.api.nlp.normalization.Normalizer;
import com.workfusion.vds.api.nlp.processing.IeProcessor;
import com.workfusion.vds.api.nlp.processing.ProcessingException;
import com.workfusion.vds.nlp.processing.normalization.OcrDateNormalizer;
import normolization.PrecioNormalizer;


/**
 * Created by Dranitsa_PD on 17.03.2018.
 */
public class SantanderProcessor implements IeProcessor {

    protected void processFields(IeDocument document, Normalizer normalizer, String... dateFieldNames) {
        Arrays.stream(dateFieldNames).forEach( fieldName -> {
            Collection<Field> fields = document.findFields(fieldName);
            fields.forEach(field -> field.setValue(normalizer.normalize(field.getValue())));
        });
    }

    @Override
    public void process(IeDocument document) throws ProcessingException {
        processFields(document, new CaseNormalizer(), "opcion1", "opcion2","divisa1","divisa2");
        processFields(document, new OcrDateNormalizer("MM/dd/yyyy"), "fecha_pago_prima", "fecha_inicio", "fecha_vencimiento", "fecha_pago_vencimiento");
        processFields(document, new AmountNormalizer(), "nominal1", "nominal2", "prima");
        processFields(document, new PrecioNormalizer(), "precio","strike_");
    }
}