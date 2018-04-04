package com.santander.wf.poc.postprocessing.tse.run;

import com.santander.wf.poc.postprocessing.tse.model.SantanderModel;
import com.workfusion.nlp.uima.workflow.constant.ProcessGlobalConst;

import java.util.HashMap;
import java.util.Map;

import com.workfusion.nlp.uima.workflow.run.WorkflowRunner;

/**
 * Created by Dranitsa_PD on 21.03.2018.
 */
public class SantanderModelEvalRunner {
    public static void main(String[] args) throws Exception {
        System.setProperty("WORKFLOW_LOG_FOLDER", "./logs/");

        String executionId = "santander";

        Map<String, Object> params = new HashMap<>();
        String answerJson = "[{\"answerCode\":\"tagged_text\",\"answerType\":\"INFO_EXTRACTION\",\"subAnswers\":[{\"answerCode\":\"leg\",\"answerType\":\"GROUP\",\"subAnswers\":[{\"answerCode\":\"contrapartida\",\"answerType\":\"FREE_TEXT\",\"subAnswers\":[],\"required\":true},{\"answerCode\":\"contrapartida_corta\",\"answerType\":\"FREE_TEXT\",\"subAnswers\":[],\"required\":false},{\"answerCode\":\"tipo_de_opcion\",\"answerType\":\"FREE_TEXT\",\"subAnswers\":[],\"required\":false},{\"answerCode\":\"estrategia\",\"answerType\":\"FREE_TEXT\",\"subAnswers\":[],\"required\":false},{\"answerCode\":\"opcion1\",\"answerType\":\"CHECK_ONE\",\"subAnswers\":[],\"required\":true},{\"answerCode\":\"opcion2\",\"answerType\":\"CHECK_ONE\",\"subAnswers\":[],\"required\":true},{\"answerCode\":\"divisa1\",\"answerType\":\"CURRENCY\",\"subAnswers\":[],\"required\":true},{\"answerCode\":\"divisa2\",\"answerType\":\"CURRENCY\",\"subAnswers\":[],\"required\":true},{\"answerCode\":\"nominal1\",\"answerType\":\"NUMBER\",\"subAnswers\":[],\"required\":true},{\"answerCode\":\"nominal2\",\"answerType\":\"NUMBER\",\"subAnswers\":[],\"required\":true},{\"answerCode\":\"strike_\",\"answerType\":\"NUMBER\",\"subAnswers\":[],\"required\":true},{\"answerCode\":\"precio\",\"answerType\":\"FREE_TEXT\",\"subAnswers\":[],\"required\":true},{\"answerCode\":\"prima\",\"answerType\":\"NUMBER\",\"subAnswers\":[],\"required\":true},{\"answerCode\":\"divisa_prima\",\"answerType\":\"CURRENCY\",\"subAnswers\":[],\"required\":true},{\"answerCode\":\"fecha_pago_prima\",\"answerType\":\"DATE\",\"subAnswers\":[],\"required\":true},{\"answerCode\":\"fecha_inicio\",\"answerType\":\"DATE\",\"subAnswers\":[],\"required\":true},{\"answerCode\":\"fecha_vencimiento\",\"answerType\":\"DATE\",\"subAnswers\":[],\"required\":true},{\"answerCode\":\"fecha_pago_vencimiento\",\"answerType\":\"DATE\",\"subAnswers\":[],\"required\":true},{\"answerCode\":\"uti_usi\",\"answerType\":\"FREE_TEXT\",\"subAnswers\":[],\"required\":false},{\"answerCode\":\"cash_delivery\",\"answerType\":\"CHECK_ONE\",\"subAnswers\":[],\"required\":true},{\"answerCode\":\"barrier\",\"answerType\":\"NUMBER\",\"subAnswers\":[],\"required\":true},{\"answerCode\":\"tipo_barrera\",\"answerType\":\"CHECK_ONE\",\"subAnswers\":[],\"required\":true},{\"answerCode\":\"spot_forward\",\"answerType\":\"CHECK_ONE\",\"subAnswers\":[],\"required\":true}],\"required\":true}],\"required\":true}]";
        params.put(ProcessGlobalConst.PARAM_ANSWERS_JSON, answerJson);

        String localWorkingDir = "local/eval/output";
        String training = "local/eval/input";

        new WorkflowRunner(executionId, SantanderModel.class)
                .useLocalWorkingDir(localWorkingDir)
                .withTrainingSet(training)
                .withParameters(params)
                .resetProcess()
                .runLocally();
    }
}