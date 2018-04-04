package com.santander.wf.poc.postprocessing.tse.processors;

import java.util.Arrays;
import java.util.Collection;

import com.santander.wf.poc.postprocessing.tse.normolization.*;
import com.workfusion.vds.api.nlp.model.Field;
import com.workfusion.vds.api.nlp.model.IeDocument;
import com.workfusion.vds.api.nlp.normalization.Normalizer;
import com.workfusion.vds.api.nlp.processing.IeProcessor;
import com.workfusion.vds.api.nlp.processing.ProcessingException;
import com.workfusion.vds.nlp.processing.normalization.OcrAmountNormalizer;
import com.workfusion.vds.nlp.processing.normalization.OcrDateNormalizer;

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
        processFields(document, new CaseNormalizer(), "opcion1", "opcion2","divisa1","divisa2","divisa_prima");
        processFields(document, new OcrDateNormalizer("MM/dd/yyyy"), "fecha_pago_prima", "fecha_inicio");
        processFields(document, new AmountNormalizer(), "nominal1", "nominal2", "prima", "barrier");
        processFields(document, new PrecioNormalizer(), "precio","strike_");
        processFields(document, new TipoBarreraNormalizer(), "tipo_barrera");
        processFields(document, new OpcionsNormalizer(1),"opcion1");
        processFields(document, new OpcionsNormalizer(2),"opcion2");
        processFields(document, new FPVNormalizer(),"fecha_pago_vencimiento");
        processFields(document, new FVNormalizer(),"fecha_vencimiento");
        processFields(document, new SpotForwardNormalizer(),"spot_forward");
        processFields(document, new CashDeliveryNormalizer(),"cash_delivery");
        processFields(document, new DivisasNormalizer(1),"divisa1");
        processFields(document, new DivisasNormalizer(2),"divisa2");
    }
}
