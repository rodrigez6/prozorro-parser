package org.rodrigez.controller;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.rodrigez.model.domain.Tender;
import org.rodrigez.model.dto.TenderDTO;
import org.rodrigez.service.TenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class TendersLoader implements Loader {

    @Autowired
    TenderService tenderService;


    private static int count = 100; // for testing
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

            // for testing
            if(count--<0){
                return;
            }

            for (Object jsObj : jsonContractsList) {
                JSONObject joItem = (JSONObject) jsObj;
                String tenderId = joItem.get("id").toString();
                tenderIDs.add(tenderId);
            }

            JSONObject jsonNextPage = (JSONObject) jsonObject.get("next_page");

            if(jsonNextPage!=null){
                String nextPageURI = (String) jsonNextPage.get("uri");
                loadPage(nextPageURI);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadTender(String url){

        System.out.println(url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {

            String jsonString = response.body().string();
            JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonString);
            JSONObject jsonData = (JSONObject) jsonObject.get("data");
            TenderDTO tenderDTO = gson.fromJson(jsonData.toJSONString(), TenderDTO.class);
            Tender tender = new Tender(tenderDTO);
            info(tenderDTO);
            //info(tender);

            tenderService.persist(tenderDTO);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void info(Tender tender) {

        tender.getDocuments().forEach(System.out::println);
        tender.getLots().forEach(System.out::println);
        //tender.getFeatures().forEach(System.out::println);
    }

    private void info(TenderDTO tenderDTO){
        //System.out.println(tenderDTO.getTenderId());
        tenderDTO.getQuestionDTOList().forEach(System.out::println);
        tenderDTO.getFunderList().forEach(System.out::println);
        tenderDTO.getBidDTOList().forEach(System.out::println);
        //tenderDTO.getLotDTOList().forEach(System.out::println);
        tenderDTO.getRevisionDTOList().forEach(System.out::println);
        tenderDTO.getAwardList().forEach(System.out::println);
        //tenderDTO.getItemDTOList().forEach(System.out::println);
        tenderDTO.getContractDTOList().forEach(System.out::println);
        tenderDTO.getCancellationDTOList().forEach(System.out::println);
        tenderDTO.getComplaintDTOList().forEach(System.out::println);
        //tenderDTO.getDocumentDTOList().forEach(System.out::println);
        //tenderDTO.getFeatureDTOList().forEach(System.out::println);
    }

}
