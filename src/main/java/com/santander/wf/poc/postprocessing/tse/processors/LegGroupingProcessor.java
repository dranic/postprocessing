package com.santander.wf.poc.postprocessing.tse.processors;

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
        fieldNames.add("contrapartida");
        fieldNames.add("contrapartida_corta");
        fieldNames.add("tipo_de_opcion");
        fieldNames.add("estrategia");
        fieldNames.add("opcion1");
        fieldNames.add("opcion2");
        fieldNames.add("divisa1");
        fieldNames.add("divisa2");
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
        Map<Integer, Integer> groupsMap = new HashMap<>();
        for(String fieldName : fieldNames) {
            Collection<Field> fields = document.findFields(fieldName);
            if (fields != null) {
                Iterator<Field> iterator = fields.iterator();
                for (int i = 0; iterator.hasNext(); i++) {
                    iterator.next();
                    update(groupsMap,i);
                }
            }
        }

        for(String fieldName : fieldNames) {
            Collection<Field> fields = document.findFields(fieldName);
            if (fields != null) {
                Iterator<Field> iterator = fields.iterator();
                for (int i = 0; iterator.hasNext(); i++) {
                    Field field = iterator.next();
                    if(groupsMap.get(i) > 3){
                        insertGroupIndices(field, i);
                    } else {
                        document.remove(field);
                    }
                }
            }
        }
    }
    private void update(Map<Integer,Integer> map, int key) {
        Integer value = map.get(key);
        if(value == null) {
            map.put(key,0);
        } else {
            map.put(key,value + 1);
        }
    }
}