package com.santander.wf.poc.postprocessing.model;

import com.workfusion.vds.api.nlp.hypermodel.ModelType;
import com.workfusion.vds.api.nlp.hypermodel.annotation.ModelDescription;
import com.workfusion.vds.api.nlp.hypermodel.annotation.PostProcessorsConfiguration;
import com.workfusion.vds.nlp.hypermodel.ie.invoice.generic.GenericInvoiceIeHyperModel;

import com.santander.wf.poc.postprocessing.SantanderModelPostProcessingConfiguration;

@ModelDescription(
        code = "santander-ie",
        title = "Santander ie",
        description = "santander information extraction 8.5.3",
        version = "1.0-SNAPSHOT",
        type = ModelType.IE
)
@PostProcessorsConfiguration(SantanderModelPostProcessingConfiguration.class)
public class SantanderModel extends GenericInvoiceIeHyperModel {

    public SantanderModel() throws Exception {
    }
}
