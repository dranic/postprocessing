package com.santander.wf.poc.postprocessing;

import com.santander.wf.poc.postprocessing.processors.LegGroupingProcessor;
import com.santander.wf.poc.postprocessing.processors.SantanderProcessor;
import com.workfusion.vds.api.nlp.processing.Processor;
import com.workfusion.vds.api.nlp.processing.ProcessorsConfiguration;

import java.util.Arrays;
import java.util.List;

public class SantanderModelPostProcessingConfiguration implements ProcessorsConfiguration {

    @Override
    public List<Processor> getProcessors() {
        return Arrays.asList( new LegGroupingProcessor(), new SantanderProcessor());
    }


}
