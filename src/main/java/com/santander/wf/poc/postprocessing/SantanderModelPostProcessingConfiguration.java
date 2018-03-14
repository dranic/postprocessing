package com.santander.wf.poc.postprocessing;

import java.util.Arrays;
import java.util.List;

import com.workfusion.vds.api.nlp.processing.Processor;
import com.workfusion.vds.api.nlp.processing.ProcessorsConfiguration;

public class SantanderModelPostProcessingConfiguration implements ProcessorsConfiguration {

    @Override
    public List<Processor> getProcessors() {
        return Arrays.asList(new PostProcessorExample(),new LegGroupingProcessor());
    }

}
