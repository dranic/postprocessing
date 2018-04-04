package com.santander.wf.poc.postprocessing.tse.run;

import com.workfusion.nlp.uima.pipeline.workflow.CustomWorkflowPipeline;
import com.workfusion.nlp.uima.workflow.model.Hypermodel;
import com.workfusion.vds.api.nlp.hypermodel.ModelType;
import com.workfusion.vds.nlp.processing.annotator.PostProcessingAnnotator;
import com.workfusion.vds.nlp.uima.annotator.processing.ExtractPostProcessingAnnotator;
import com.workfusion.vds.nlp.uima.processing.run.IeProcessingRunner;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.fit.factory.AnalysisEngineFactory;

import java.nio.file.Path;

/**
 * Created by Dranitsa_PD on 13.03.2018.
 */
public class LocalSantanderRunner extends IeProcessingRunner{

    private Path modelFolderPath;

    @Override
    public void run(Hypermodel model, Path modelFolderPath, Path inputFolderPath, Path outputFolderPath) throws Exception {
        this.modelFolderPath = modelFolderPath;
        super.run(model, modelFolderPath, inputFolderPath, outputFolderPath);
    }

    @Override
    protected AnalysisEngine createPostProcessingPipeline(Hypermodel model) throws Exception {
        CustomWorkflowPipeline pipeline = new CustomWorkflowPipeline("Post-processing");
        if(ModelType.IE.equals(model.getType())) {
            pipeline.addComponent("post-processing on extract",
                    ExtractPostProcessingAnnotator.getDescription(model.getPostProcessorsConfigClass(), getAnswersJson()));
        } else if(ModelType.CLASSIFICATION.equals(model.getType())) {
            pipeline.addComponent("post-processing on extract", new PostProcessingAnnotator.Builder()
                    .type(PostProcessingAnnotator.ProcessingType.CLASSIFICATION)
                    .processorsConfiguration(model.getPostProcessorsConfigClass()));
        } else {
            // TODO: Add support for other model types
        }
        return AnalysisEngineFactory.createEngine(pipeline.getPipeline());
    }

    private String getAnswersJson(){
        //all
        return "[{\"answerCode\":\"tagged_text\",\"answerType\":\"INFO_EXTRACTION\",\"subAnswers\":[{\"answerCode\":\"leg\",\"answerType\":\"GROUP\",\"subAnswers\":[{\"answerCode\":\"contrapartida\",\"answerType\":\"FREE_TEXT\",\"subAnswers\":[],\"required\":true},{\"answerCode\":\"contrapartida_corta\",\"answerType\":\"FREE_TEXT\",\"subAnswers\":[],\"required\":false},{\"answerCode\":\"tipo_de_opcion\",\"answerType\":\"FREE_TEXT\",\"subAnswers\":[],\"required\":false},{\"answerCode\":\"estrategia\",\"answerType\":\"FREE_TEXT\",\"subAnswers\":[],\"required\":false},{\"answerCode\":\"opcion1\",\"answerType\":\"CHECK_ONE\",\"subAnswers\":[],\"required\":true},{\"answerCode\":\"opcion2\",\"answerType\":\"CHECK_ONE\",\"subAnswers\":[],\"required\":true},{\"answerCode\":\"divisa1\",\"answerType\":\"CURRENCY\",\"subAnswers\":[],\"required\":true},{\"answerCode\":\"divisa2\",\"answerType\":\"CURRENCY\",\"subAnswers\":[],\"required\":true},{\"answerCode\":\"nominal1\",\"answerType\":\"NUMBER\",\"subAnswers\":[],\"required\":true},{\"answerCode\":\"nominal2\",\"answerType\":\"NUMBER\",\"subAnswers\":[],\"required\":true},{\"answerCode\":\"strike_\",\"answerType\":\"NUMBER\",\"subAnswers\":[],\"required\":true},{\"answerCode\":\"precio\",\"answerType\":\"FREE_TEXT\",\"subAnswers\":[],\"required\":true},{\"answerCode\":\"prima\",\"answerType\":\"NUMBER\",\"subAnswers\":[],\"required\":true},{\"answerCode\":\"divisa_prima\",\"answerType\":\"CURRENCY\",\"subAnswers\":[],\"required\":true},{\"answerCode\":\"fecha_pago_prima\",\"answerType\":\"DATE\",\"subAnswers\":[],\"required\":true},{\"answerCode\":\"fecha_inicio\",\"answerType\":\"DATE\",\"subAnswers\":[],\"required\":true},{\"answerCode\":\"fecha_vencimiento\",\"answerType\":\"DATE\",\"subAnswers\":[],\"required\":true},{\"answerCode\":\"fecha_pago_vencimiento\",\"answerType\":\"DATE\",\"subAnswers\":[],\"required\":true},{\"answerCode\":\"uti_usi\",\"answerType\":\"FREE_TEXT\",\"subAnswers\":[],\"required\":false},{\"answerCode\":\"cash_delivery\",\"answerType\":\"CHECK_ONE\",\"subAnswers\":[],\"required\":true},{\"answerCode\":\"barrier\",\"answerType\":\"NUMBER\",\"subAnswers\":[],\"required\":true},{\"answerCode\":\"tipo_barrera\",\"answerType\":\"CHECK_ONE\",\"subAnswers\":[],\"required\":true},{\"answerCode\":\"spot_forward\",\"answerType\":\"CHECK_ONE\",\"subAnswers\":[],\"required\":true}],\"required\":true}],\"required\":true}]";

    }
}

