package com.santander.wf.poc.postprocessing.normolization;

import com.santander.wf.poc.postprocessing.tse.normolization.AmountNormalizer;
import com.santander.wf.poc.postprocessing.tse.normolization.CaseNormalizer;
import com.santander.wf.poc.postprocessing.tse.normolization.PrecioNormalizer;
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



    String[] strike_Array = {
            "1.281",
            "4.33",
            "0.87",
            "1.215",
            "1.231",
            "19",
            "17.5",
            "18.625",
            "18.09",
            "19.4",
            "1.13",
            "19.5",
            "19",
            "19.161",
            "18.625",
            "1.26",
            "19",
            "19",
            "18.75",
            "19",
            "19.25",
            "1.3234",
            "17.75",
            "18.33",
            "19.4",
            "20",
            "19",
            "1.26",
            "19.5",
            "18.8",
            "19.667",
            "17.78",
            "1.2033",
            "18.5",
            "19",
            "1.1823",
            "1.185",
            "0.9",
            "4.28",
            "19.459",
            "10.8478",
            "1.3286",
            "1.286",
            "1.245",
            "1.275",
            "0.8925",
            "1.17",
            "0.9115",
            "1.21",
            "1.155",
            "1.19",
            "0.9208",
            "18.75",
            "1.39",
            "9.629",
            "634.6",
            "0.878",
            "18",
            "2850",
            "1.3015",
            "3.242",
            "3.194",
            "3.275",
            "18.5385",
            "1.1455",
            "18.225",
            "18.88",
            "18.017",
            "15.4315",
            "17.768",
            "1.29218",
            "3.1995",
            "3.328",
            "3.404",
            "18.551",
            "18.551",
            "4.238",
            "18.8335",
            "3.2405",
            "3.3245",
            "17.73",
            "1.29",
            "17.73",
            "1.2925",
            "1.345",
            "1.138",
            "1.265",
            "1.2897",
            "1.41",
            "18.8835",
            "6.3",
            "1.237"
    };

    @Test
    public void normolizeStrikeTest() {
        Arrays.stream(strike_Array).forEach( strike_ -> {
            PrecioNormalizer normolizer = new PrecioNormalizer();
            System.out.println(strike_ + "\t\t" + normolizer.normalize(strike_));
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