package com.santander.wf.poc.postprocessing.processors;

import com.workfusion.vds.api.nlp.model.Field;
import com.workfusion.vds.api.nlp.model.IeDocument;
import com.workfusion.vds.api.nlp.processing.IeProcessor;
import com.workfusion.vds.api.nlp.processing.ProcessingException;

/**
 * Created by Guillermo Sánchez on 20/03/2018.
 */
public class CurrenciesProcessor implements IeProcessor {
    @Override
    public void process (IeDocument document) throws ProcessingException{
        Field divisa1=document.findField("divisa1");
        Field divisa2=document.findField("divisa2");

        String auxDivisa1=divisa1.getValue();
        String auxDivisa2=divisa2.getValue();


        if(auxDivisa2.length()>3) {

            if(divisa1.getValue()==null) {

                divisa1.setValue(auxDivisa2.substring(0, 3));

            }

            String auxDivisa=auxDivisa2.substring(3,auxDivisa2.length());

            divisa2.setValue(auxDivisa);

        }



        else if(auxDivisa1.length()>3) {

            if(divisa2.getValue()==null) {

                divisa2.setValue(auxDivisa1.substring(3, auxDivisa1.length()));

            }

            String auxDivisa=auxDivisa1.substring(0,3);

            divisa1.setValue(auxDivisa);

        }



    }

}



