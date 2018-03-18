package normolization;

import com.workfusion.vds.api.nlp.normalization.Normalizer;

/**
 * Created by Dranitsa_PD on 17.03.2018.
 */
public class CaseNormalizer implements Normalizer {
    @Override
    public String normalize(String text) {
        return text.toUpperCase();
    }
}