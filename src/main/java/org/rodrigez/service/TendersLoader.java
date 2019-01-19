package org.rodrigez.service;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.rodrigez.model.dto.TenderDTO;
import org.rodrigez.repository.TenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class TendersLoader implements Loader {

    @Autowired
    TenderRepository tenderRepository;

    private static int count = 1; // for testing
    private static OkHttpClient client = new OkHttpClient();
    private static List<String> tenderIDs = new ArrayList<>();
    Gson gson = new Gson();

    @Override
    public void run() {
        String basicUrl = "https://public.api.openprocurement.org/api/2.4/tenders";
        loadPage(basicUrl);
        for(String tenderID : tenderIDs){
            String tenderUrl = basicUrl + "/" + tenderID;
            loadTender(tenderUrl);
        }
    }

    private void loadPage(String url){

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {

            String jsonString = response.body().string();
            JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonString);
            JSONArray jsonContractsList = (JSONArray) jsonObject.get("data");

            for (Object jsObj : jsonContractsList) {
                JSONObject joItem = (JSONObject) jsObj;
                String tenderId = joItem.get("id").toString();
                tenderIDs.add(tenderId);
            }

            JSONObject jsonNextPage = (JSONObject) jsonObject.get("next_page");

            // for testing
            if(count--<0){
                return;
            }

            if(jsonNextPage!=null){
                String nextPageURI = (String) jsonNextPage.get("uri");
                loadPage(nextPageURI);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadTender(String url){

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {

            String jsonString = response.body().string();
            JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonString);
            JSONObject jsonData = (JSONObject) jsonObject.get("data");
            TenderDTO tenderDTO = gson.fromJson(jsonData.toJSONString(), TenderDTO.class);
            //Tender tender = new Tender(tenderDTO);
            //tenderRepository.save(tender);
            System.out.println(tenderDTO.getProcuringEntityDTO().getIdentifierDTO().getId() + "-----------" + tenderDTO.getProcuringEntityDTO().getName());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
