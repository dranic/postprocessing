package com.santander.wf.poc.postprocessing.tse.model;

import com.santander.wf.poc.postprocessing.tse.PostProcessingConfiguration;
import com.workfusion.vds.api.nlp.hypermodel.ModelType;
import com.workfusion.vds.api.nlp.hypermodel.annotation.FixedModelConfiguration;
import com.workfusion.vds.api.nlp.hypermodel.annotation.ModelDescription;
import com.workfusion.vds.api.nlp.hypermodel.annotation.PostProcessorsConfiguration;
import com.workfusion.vds.nlp.hypermodel.ie.invoice.generic.GenericInvoiceIeHyperModel;

@ModelDescription(
        code = "santander-tse",
        title = "Santander term sheet extraction",
        description = "Santander term sheet extraction ( based on 8.5.3)",
        version = "1.0",
        type = ModelType.IE
)
@PostProcessorsConfiguration(PostProcessingConfiguration.class)
@FixedModelConfiguration(value = "hpo-config/")
public class SantanderModel extends GenericInvoiceIeHyperModel {

    public SantanderModel() throws Exception {
    }
}
