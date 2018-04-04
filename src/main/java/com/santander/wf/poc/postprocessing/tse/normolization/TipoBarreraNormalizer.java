package com.santander.wf.poc.postprocessing.tse.normolization;

import com.workfusion.vds.api.nlp.normalization.Normalizer;

/**
 * Created by Guillermo Sánchez on 20/03/2018.
 */
public class TipoBarreraNormalizer implements Normalizer{
    @Override
    public String normalize (String text){
      if(text.equalsIgnoreCase("ki")||text.toUpperCase().contains("IN")) {
          text="In";
          return text;
      }
        else {
          text="Out";
          return text;
      }
    }

}
