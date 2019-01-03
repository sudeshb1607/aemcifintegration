package de.deloitte.commerce.aem.core.models;

import com.google.gson.Gson;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

@Model(adaptables = Resource.class)
public class ProductModel {

    @Inject @Optional
    private String productId;

    private String productFeatures;

    private static final String URL = "https://adobeioruntime.net/apis/deloitte-de/binding-commercetools/products/";

    @PostConstruct
    protected void init(){
        setProductFeatures(this.productId);
    }

    public String getProductFeatures() {
        return productFeatures;
    }

    public void setProductFeatures(String productId) {

        if(!productId.isEmpty()) {
            String productURL = URL.concat(productId);

            Gson gson = new Gson();
            CloseableHttpClient client = HttpClients.createDefault();
            try {
                try {
                    HttpGet get = new HttpGet(productURL);
                    CloseableHttpResponse response = client.execute(get);
                    BufferedReader rd = new BufferedReader(
                            new InputStreamReader(response.getEntity().getContent()));

                    StringBuffer result = new StringBuffer();
                    String line = "";
                    while ((line = rd.readLine()) != null) {
                        result.append(line);
                    }
                    Map map = gson.fromJson(result.toString(),Map.class);
                    this.productFeatures = result.toString();
                } finally {

                    client.close();
                }

            } catch (IOException e){
            }
        }
    }
}
