package com.santander.wf.poc.postprocessing.processors;

import com.workfusion.vds.api.nlp.model.Field;
import com.workfusion.vds.api.nlp.model.IeDocument;
import com.workfusion.vds.nlp.processing.grouping.PositionBasedGroupingProcessor;
import java.util.*;

/**
 * Created by Dranitsa_PD on 12.03.2018.
 */
public class LegGroupingProcessor extends PositionBasedGroupingProcessor {

    List<String> fieldNames = new ArrayList<>();

    public LegGroupingProcessor(){
        fieldNames.add("contrapartida");//good
        fieldNames.add("contrapartida_corta");//good
        fieldNames.add("tipo_de_opcion");//good
        fieldNames.add("estrategia");//good
        fieldNames.add("opcion1");//good
        fieldNames.add("opcion2");//good
        fieldNames.add("divisa1");//process long valuew >3
        fieldNames.add("divisa2");// the same as previous
        fieldNames.add("nominal1");
        fieldNames.add("nominal2");
        fieldNames.add("strike_");
        fieldNames.add("precio");
        fieldNames.add("prima");
        fieldNames.add("divisa_prima");
        fieldNames.add("fecha_pago_prima");
        fieldNames.add("fecha_inicio");
        fieldNames.add("fecha_vencimiento");
        fieldNames.add("fecha_pago_vencimiento");
        fieldNames.add("uti_usi");
        fieldNames.add("cash_delivery");
        fieldNames.add("barrier");
        fieldNames.add("tipo_barrera");
        fieldNames.add("spot_forward");
    }
    @Override
    protected void findGroups(IeDocument document, Set<String> groupCodes) {
        for(String fieldName : fieldNames) {
            Collection<Field> fields = document.findFields(fieldName);
            if(fields != null){
                Iterator<Field> iterator = fields.iterator();
                for (int i = 0 ; iterator.hasNext() ; i++) {
                    Field field= iterator.next();
                    insertGroupIndices(field, i);
                }
            }
        }
    }
}