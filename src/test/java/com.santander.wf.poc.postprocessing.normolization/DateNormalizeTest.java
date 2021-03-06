package com.santander.wf.poc.postprocessing.normolization;

import com.santander.wf.poc.postprocessing.tse.normolization.FPVNormalizer;
import com.santander.wf.poc.postprocessing.tse.normolization.FVNormalizer;
import com.santander.wf.poc.postprocessing.tse.normolization.OpcionsNormalizer;
import org.junit.Test;

import java.util.Arrays;

public class DateNormalizeTest {

    String[] dates = {
            "02.01.2018",
            "05Oct2017",
            "27.03.2019",
            "09.02.2018",
            "29Jan2018",
            "11/14Dec2017",
            "16/18Aug",
            "11",
            "06/11Oct",
            "02Aug 2018",
            "09Aug2017",
            "30may/01Jun 2018",
            "08/10Nov 2017",
            "16/21NOv",
            "11/13Oct2017",
            "19Oct2017",
            "07/09Nov 2017",
            "19/21Dec",
            "26/28Jun 2018",
            "13/15Nov 2017",
            "01/05Jun",
            "29.12.2017",
            "07/09May 2018",
            "20/24Apr 2018",
            "31May/04Jun",
            "17/19Oct2018",
            "21/26Dec2017",
            "13Oct2017",
            "29Nov/Dec01",
            "29Nov/1Dec",
            "27/29Dec",
            "20/22Sep",
            "01.04.2019",
            "10/12Apr 2018",
            "February-13-2018",
            "25 January 2018",
            "30 October 2017",
            "10Nov2017",
            "22.01.2018",
            "19-Oct-2017",
            "30.04.2018",
            "29 Jan 2019",
            "22Sep2017",
            "17Aug2017",
            "21Nov2017",
            "26Jul2017",
            "16Aug2017",
            "19Oct2017",
            "15 September 2017",
            "15/19Dec17",
            "23 Mar 2018",
            "13-Jul-2017",
            "11 Jan 2018",
            "05Feb2018",
            "08/13Dec 2017",
            "25-Oct-17",
            "31.10.2017",
            "25-29 JAN 2018",
            "22 Nov 2017",
            "09 Oct 2018",
            "10 Jan 2018",
            "19 Mar 2018",
            "11 Jul 2017",
            "16 Nov 2017",
            "22 Jan 2018",
            "29 Sep 2017",
            "29.12.2017",
            "31 Oct 2017",
            "02 Oct 2018",
            "04 Dec 2018",
            "10 Jan 2018",
            "10 Jan 2018",
            "21 Jun 2018",
            "13 Nov 2017",
            "13 Sep 2018",
            "20 Aug 2018",
            "08 Mar 2018",
            "08 Mar 2018",
            "11Oct2017",
            "06Nov2017",
            "07Jul2017",
            "17Oct2017",
            "17Nov2017",
            "31 Jan 2018",
            "26-Mar-2018",
            "07Sep2017",
            "06Sep2017",
            "04/12/2017",
            "06/12/2017",
            "12/12/2017"
    };

    @Test
    public void normolizeFPVTest() {
        Arrays.stream(dates).forEach( date -> {
            FPVNormalizer normolizer1 = new FPVNormalizer();
            System.out.println(date + "\t\t" + normolizer1.normalize(date));
        });
    }

    String[] datesFV = {
            "03Oct2017",
            "25Jan2018",
            "11/14Dec2017",
            "16/18Aug",
            "11/13oct",
            "06/11Oct",
            "31Jul 2018/",
            "17Jul2017",
            "30may/01Jun 2018",
            "08/10Nov 2017",
            "16/21NOv",
            "11/13Oct2017",
            "18Oct2017",
            "07/09Nov 2017",
            "19/21Dec",
            "26/28Jun 2018",
            "13/15Nov",
            "01/05Jun",
            "07/09May 2018",
            "20/24Apr",
            "31May/04Jun",
            "17/19Oct2018",
            "21/26Dec2017",
            "12Oct2017",
            "29Nov/Dec01",
            "29Nov/1Dec",
            "27/29Dec",
            "20/22Sep",
            "10/12Apr 2018",
            "February-09-2018",
            "26 October 2017",
            "08Nov2017",
            "18.01.2018",
            "17-Oct-2017",
            "25 Jan 2019",
            "21Sep2017",
            "16Aug2017",
            "17Nov2017",
            "24Jul2017",
            "14Aug2017",
            "18Oct2017",
            "13 Nov 2017",
            "23Jul2019",
            "13 September 2017",
            "15/19Dec17",
            "21 Mar 2018",
            "09 Jan 2018",
            "01Feb2018",
            "08/13Dec 2017",
            "23-Oct-17",
            "04 Oct 2018",
            "08 Jan 2018",
            "15 Mar 2018",
            "07 Jul 2017",
            "14 Nov 2017",
            "18 Jan 2018",
            "20 Jul 2018",
            "27 Sep 2017",
            "27 Oct 2017",
            "28 Sep 2018",
            "08 Jan 2018",
            "08 Jan 2018",
            "19 Jun 2018",
            "09 Nov 2017",
            "11 Sep 2018",
            "16 Aug 2018",
            "06 Mar 2018",
            "06 Mar 2018",
            "09Oct2017",
            "02Nov2017",
            "05Jul2017",
            "16Oct2017",
            "15Nov2017",
            "29 Jan 2018",
            "22-Mar-2018",
            "06Sep2017",
            "04/12/2017",
            "06/12/2017",
            "12/12/2017"
    };

    @Test
    public void normolizeFVTest() {
        Arrays.stream(datesFV).forEach( date -> {
            FVNormalizer normolizer1 = new FVNormalizer();
            System.out.println(date + "\t\t" + normolizer1.normalize(date));
        });
    }


}