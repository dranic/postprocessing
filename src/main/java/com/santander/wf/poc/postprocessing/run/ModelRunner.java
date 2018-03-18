package com.santander.wf.poc.postprocessing.run;

import java.nio.file.Paths;
import java.nio.file.Path;
import com.workfusion.vds.nlp.uima.processing.run.IeProcessingRunner;
import com.santander.wf.poc.postprocessing.model.SantanderModel;

public class ModelRunner {

    public static void main(String[] args) throws Exception {
        System.setProperty("WORKFLOW_LOG_FOLDER", "./logs/");
        LocalSantanderRunner runner = new LocalSantanderRunner();

        Path trainedModelPath = Paths.get("src/local/model");
        Path inputFolderPath = Paths.get("src/local/input");
        Path outputFolderPath = Paths.get("src/local/output");

        runner.run(new SantanderModel(), trainedModelPath, inputFolderPath, outputFolderPath);
    }
}
