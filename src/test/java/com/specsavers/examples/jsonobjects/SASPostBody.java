package com.specsavers.examples.jsonobjects;

import org.json.JSONObject;

public class SASPostBody {

    JSONObject generalParams = new JSONObject();
    JSONObject customerParams = new JSONObject();
    JSONObject medicareParams = new JSONObject();

    public String returnBookBodyv1()
    {
        generalParams.put("date", "2017-08-10");
        generalParams.put("type", 2000);
        generalParams.put("slot_ids", "[41172]");
        generalParams.put("note", "");

        customerParams.put("gender_id", 1);
        customerParams.put("title_id", 1);
        customerParams.put("first_name", "John");
        customerParams.put("last_name", "Wick");
        customerParams.put("date_of_birth", "1981-01-01");
        customerParams.put("email", "success@simulator.amazonses.com");
        customerParams.put("detail", "04547536535");
        customerParams.put("sa_authority_id", 1);

        generalParams.put("customer",customerParams);

        return generalParams.toString();
    }



    public String returnBookBody(String date, String slotID)
    {
        generalParams.put("date", date);
        generalParams.put("type", "2002");
        generalParams.put("slot_id", slotID);
        generalParams.put("note", "Blank");

        customerParams.put("gender_id", 1);
        customerParams.put("title_id", 1);
        customerParams.put("first_name", "John");
        customerParams.put("last_name", "Wick");
        customerParams.put("date_of_birth", "1981-01-01");
        customerParams.put("email", "success@simulator.amazonses.com");
        customerParams.put("detail", "45645600");
        customerParams.put("mobile", "23112332");
        customerParams.put("sa_authority_id", 2);
        customerParams.put("std", "134");

        generalParams.put("customer",customerParams);

        return generalParams.toString();
    }

    public String returnMockBookBody(String slotID, String date)
    {
        generalParams.put("date", date);
        generalParams.put("type", "2000");
        generalParams.put("slot_id", slotID);
        generalParams.put("note", "");
        generalParams.put("customer_id", 223344);

        customerParams.put("gender_id", 1);
        customerParams.put("title_id", 1);
        customerParams.put("first_name", "John");
        customerParams.put("last_name", "Wick");
        customerParams.put("date_of_birth", "1980-01-01");
        customerParams.put("email", "success@simulator.amazonses.com");
        customerParams.put("detail", "04547536535");
        customerParams.put("sa_authority_id", 1);


        generalParams.put("customer",customerParams);

        return generalParams.toString();
    }

    public String returnTSTMockBookBody() {

        generalParams.put("date", "2018-09-10");
        generalParams.put("type", "2000");
        generalParams.put("slot_id", 41172);
        generalParams.put("note", "");

        customerParams.put("gender_id", 1);
        customerParams.put("title_id", 1);
        customerParams.put("first_name", "John");
        customerParams.put("last_name", "Wick");
        customerParams.put("date_of_birth", "1980-01-01");
        customerParams.put("email", "success@simulator.amazonses.com");
        customerParams.put("detail", "04547536535");
        customerParams.put("sa_authority_id", 2);
        customerParams.put("std", "134");

        medicareParams.put("number","2123456701");
        medicareParams.put("irn","1");
        medicareParams.put("valid_date","2100-12");

        customerParams.put("medicare",medicareParams);
        generalParams.put("customer",customerParams);

        return generalParams.toString();
   }


    public String returnUpdateBody(String date, String slotID, String customerID)
    {
        generalParams.put("date", date);
        generalParams.put("type", 2000);
        generalParams.put("slot_id", slotID);
        generalParams.put("customer_id", customerID);

        return generalParams.toString();
    }
}

