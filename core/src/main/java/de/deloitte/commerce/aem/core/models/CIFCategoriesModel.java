package de.deloitte.commerce.aem.core.models;

import com.google.gson.Gson;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

@Model(adaptables = Resource.class)
public class CIFCategoriesModel {

    private static final String URL = "https://adobeioruntime.net/apis/deloitte-de/binding-commercetools/categories" ;

    private static final Logger LOG = LoggerFactory.getLogger(CIFCategoriesModel.class);

    private String categories;

    @PostConstruct
    protected void init() {
        setCategories(this.categories);
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {

        Gson gson = new Gson();
        CloseableHttpClient client = HttpClients.createDefault();
        try {
            try {
                HttpGet get = new HttpGet(URL);
                CloseableHttpResponse response = client.execute(get);
                LOG.debug("response {}",response.toString());
                BufferedReader rd = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent()));

                StringBuffer result = new StringBuffer();
                String line = "";
                while ((line = rd.readLine()) != null) {
                    result.append(line);
                }
                Map map = gson.fromJson(result.toString(),Map.class);
                this.categories = result.toString();
            } finally {

                client.close();
            }

        } catch (IOException e){
            LOG.error("Erro IO {}",e.getMessage());
        }
    }
}
