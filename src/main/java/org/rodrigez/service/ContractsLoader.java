package org.rodrigez.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.rodrigez.model.dto.ContractDTO;
import org.rodrigez.model.dto.DocumentDTO;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Component
public class ContractsLoader implements Loader {

    private static int count = 10; // for testing
    private static OkHttpClient client = new OkHttpClient();
    private static List<String> contractIDs = new ArrayList<>();
    Gson gson = new Gson();

    public void run() {
        String basicUrl = "https://public.api.openprocurement.org/api/2.4/contracts";
        loadPage(basicUrl);
        for(String contractID : contractIDs){
            String contractUrl = basicUrl + "/" + contractID;
            loadContract(contractUrl);
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
                String contractId = joItem.get("id").toString();
                contractIDs.add(contractId);
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

    private void loadContract(String url){

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {

            String jsonString = response.body().string();
            JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonString);
            JSONObject jsonData = (JSONObject) jsonObject.get("data");
            ContractDTO contractDTO = gson.fromJson(jsonData.toJSONString(), ContractDTO.class);
            //System.out.println(contractDTO.getDocumentDTOList());
            //loadDocumentList(url);
            contractDTO.getDocumentDTOList().forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void loadDocumentList(String contractUrl){

        String url = contractUrl + "/documents";

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {

            String jsonString = response.body().string();
            JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonString);
            JSONArray jsonDocumentList = (JSONArray) jsonObject.get("data");
            Type listType = new TypeToken<List<DocumentDTO>>() {}.getType();
            List<DocumentDTO> documentDTOList = gson.fromJson(jsonDocumentList.toJSONString(), listType);
            //documentDTOList.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
