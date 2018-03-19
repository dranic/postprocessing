package com.santander.wf.poc.postprocessing.normolization;

import org.junit.Test;

import java.util.Arrays;

public class PrecioAmountTest {

    String[] precioArray = {
            "2100000,00",
            "0,2100",
            "1.9360",
            "1.7985",
            "0.172",
            "60",
            "0.237",
            "1.55",
            "8.25 USD points per EUR",
            "0.155",
            "USD per1 EUR 59.25",
            "0.2875",
            "USD per1 GBP 12.75",
            "0.2575",
            "USD per1 EUR 252.50",
            "0.2175",
            "USD per1 EUR 255.50",
            "0.6950",
            "USD per1 EUR 136.25",
            "0.8450",
            "0.3075",
            "USD per1 EUR (95.75",
            "USD per1 EUR (96.50",
            "0.0875",
            "0.1675",
            "77.25 USD",
            "0.2175",
            "0.29",
            "0.3200",
            "0.1140",
            "0.275",
            "12 USD points per GBP",
    };

    @Test
    public void normolizePrecioTest() {
        Arrays.stream(precioArray).forEach( precio -> {
            PrecioNormalizer normolizer = new PrecioNormalizer();
            System.out.println(precio + "\t\t" + normolizer.normalize(precio));
        });
    }

   String[] nominals = {
                "12,500,000",
                "5,000,000",
                "10,000,000.00",
                "134,469,992",
                "37mios",
                "20mios",
                "10,000,000.00",
                "100 MM",
                "30,000,000.00",
                "1.000.000",
                "50,000,000.00",
                "20,000,000",
                "40,000,000",
                "20,000,000",
                "50,000,000",
                "20,000,000",
                "10,000,000",
                "15m",
                "10,000,000",
                "50,000,000",
                "25,000,000",
                "5,000,000",
                "5,000,000",
                "10,000,000",
                "20,000,000",
                "30,000,000",
                "10,000,000",
                "20,000,000",
                "30,000,000",
                "10m",
                "30,000,000",
                "20m",
                "50,000,000.00",
                "8,000,000.00",
                "15 MIO",
                "M): 50",
                "20,000,000",
                "-20,000,000",
                "6,800,000.00"};

    @Test
    public void normolizeAmountTest() {
        Arrays.stream(nominals).forEach( nominal -> {
            System.out.print(nominal);
            com.workfusion.vds.api.nlp.normalization.Normalizer normolizer = new AmountNormalizer();
            System.out.println("\t\t" + normolizer.normalize(nominal));
        });
    }



     String [] estrategias =
             {"buys",
            "sells",
            "BUYER",
            "SELLER",
            "sells",
            "buys",
            "Buyer",
            "Buyer",
            "Buyer",
            "sells"};

    @Test
    public void normolizeEstrategiaTest() {
        Arrays.stream(estrategias).forEach( est -> {
            System.out.print(est);
            com.workfusion.vds.api.nlp.normalization.Normalizer normolizer = new CaseNormalizer();
            System.out.println("\t\t" + normolizer.normalize(est));
        });
    }
}