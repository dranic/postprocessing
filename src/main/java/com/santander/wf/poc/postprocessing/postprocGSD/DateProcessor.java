package com.santander.wf.poc.postprocessing.postprocGSD;


import com.workfusion.vds.api.nlp.model.Field;
import com.workfusion.vds.api.nlp.model.IeDocument;
import com.workfusion.vds.api.nlp.processing.IeProcessor;
import com.workfusion.vds.api.nlp.processing.ProcessingException;
import com.workfusion.vds.nlp.processing.normalization.OcrDateNormalizer;

/**
 * Created by Guillermo on 15/03/2018.
 */
public class DateProcessor implements IeProcessor {
    @Override
public void process(IeDocument document) throws ProcessingException{
    Field fechaPagoPrima=document.findField("fecha_pago_prima");
        if(fechaPagoPrima!=null && fechaPagoPrima.getValue()!=null){
            OcrDateNormalizer dateNormalizer=new OcrDateNormalizer("MM/dd/yyyy");
            String value=fechaPagoPrima.getValue();
            String correctValue=dateNormalizer.normalize(value);
            fechaPagoPrima.setValue(correctValue);
    }
    Field fechaInicio=document.findField("fecha_inicio");
        if(fechaInicio!=null && fechaInicio.getValue()!=null){
            OcrDateNormalizer dateNormalizer=new OcrDateNormalizer("MM/dd/yyyy");
            String value=fechaInicio.getValue();
            String correctValue=dateNormalizer.normalize(value);
            fechaInicio.setValue(correctValue);
        }
    Field fechaVencimiento=document.findField("fecha_vencimiento");
        if(fechaVencimiento!=null && fechaVencimiento.getValue()!=null){
            OcrDateNormalizer dateNormalizer=new OcrDateNormalizer("MM/dd/yyyy");
            String value=fechaVencimiento.getValue();
            String correctValue=dateNormalizer.normalize(value);
            fechaVencimiento.setValue(correctValue);
        }
        Field fechaPagoVencimiento=document.findField("fecha_pago_vencimiento");
        if(fechaPagoVencimiento!=null && fechaPagoVencimiento.getValue()!=null){
            OcrDateNormalizer dateNormalizer=new OcrDateNormalizer("MM/dd/yyyy");
            String value=fechaPagoVencimiento.getValue();
            String correctValue=dateNormalizer.normalize(value);
            fechaPagoVencimiento.setValue(correctValue);
        }
}
}
