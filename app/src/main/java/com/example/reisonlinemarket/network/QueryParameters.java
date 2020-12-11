package com.example.reisonlinemarket.network;

import java.util.HashMap;
import java.util.Map;

public class QueryParameters {

    public static Map<String, String> ProductQueryParameters = new HashMap<String, String>() {{
        put("consumer_key","ck_f025265e3479f7bee8e93bffe5685517b93ec27d");
        put("consumer_secret","cs_27b19e572ac9cf1333d4d53f7082a15e9fb6a2b0");
        put("per_page" ,"50");
    }};

    public static Map<String, String> MostViewedProductQueryParameters = new HashMap<String, String>() {{
        put("consumer_key","ck_f025265e3479f7bee8e93bffe5685517b93ec27d");
        put("consumer_secret","cs_27b19e572ac9cf1333d4d53f7082a15e9fb6a2b0");
        put("per_page" ,"50");
        put("orderby","popularity");
    }};

    public static Map<String, String> HighScoreProductQueryParameters = new HashMap<String, String>() {{
        put("consumer_key","ck_f025265e3479f7bee8e93bffe5685517b93ec27d");
        put("consumer_secret","cs_27b19e572ac9cf1333d4d53f7082a15e9fb6a2b0");
        put("per_page" ,"50");
        put("orderby","rating");
    }};
}
