package com.santander.wf.poc.postprocessing.tse.run;

import java.nio.file.Paths;
import java.nio.file.Path;

import com.santander.wf.poc.postprocessing.tse.model.SantanderModel;

public class ModelRunner {

    public static void main(String[] args) throws Exception {
        System.setProperty("WORKFLOW_LOG_FOLDER", "./logs/");
        LocalSantanderRunner runner = new LocalSantanderRunner();

        //tse299
//        Path trainedModelPath = Paths.get("local/tse_299/model");
//        Path inputFolderPath = Paths.get("local/tse_299/input");
//        Path outputFolderPath = Paths.get("local/tse_299/output");

        //tse531
//        Path trainedModelPath = Paths.get("local/tse_531/model");
//        Path inputFolderPath = Paths.get("local/tse_531/input");
//        Path outputFolderPath = Paths.get("local/tse_531/output");

        //tse681
//        Path trainedModelPath = Paths.get("local/tse_681/model");
//        Path inputFolderPath = Paths.get("local/tse_681/input");
//        Path outputFolderPath = Paths.get("local/tse_681/output");

        //tse1213
//        Path trainedModelPath = Paths.get("local/tse_1213/model");
//        Path inputFolderPath = Paths.get("local/tse_1213/input");
//        Path outputFolderPath = Paths.get("local/tse_1213/output");

        //tse_1207_final
        Path trainedModelPath = Paths.get("local/tse_1207_final/model");
        Path inputFolderPath = Paths.get("local/tse_1207_final/input");
//        Path inputFolderPath = Paths.get("c:\\_projects\\santander\\workspace\\postprocessing\\tse_extraction\\local\\tse_1207_final\\input\\Final test.csv");
        Path outputFolderPath = Paths.get("local/tse_1207_final/output");


        runner.run(new SantanderModel(), trainedModelPath, inputFolderPath, outputFolderPath);
//        runner.runFromCsv(new SantanderModel(), trainedModelPath, inputFolderPath, "Column 01", outputFolderPath);
    }
}
