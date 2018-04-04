package com.santander.wf.poc.postprocessing.tse;

import com.santander.wf.poc.postprocessing.tse.processors.LegGroupingProcessor;
import com.santander.wf.poc.postprocessing.tse.processors.LowScoreProcessor;
import com.santander.wf.poc.postprocessing.tse.processors.SantanderProcessor;
import com.workfusion.vds.api.nlp.processing.Processor;
import com.workfusion.vds.api.nlp.processing.ProcessorsConfiguration;

import java.util.Arrays;
import java.util.List;

public class PostProcessingConfiguration implements ProcessorsConfiguration {

    @Override
    public List<Processor> getProcessors() {
        return Arrays.asList(new LegGroupingProcessor(), new SantanderProcessor(), new LowScoreProcessor());
    }
}
