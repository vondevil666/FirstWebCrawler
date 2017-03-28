import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

/**
 * Created by dongz on 2017/3/28.
 */
class FirstWebCrawler {
    public static void main(String[] args) {
        try {
            new FirstWebCrawler().startFire();
        } catch (Exception e) {

        }
    }

    public void startFire() throws Exception {
        CloseableHttpClient client = HttpClients.createDefault();
        URI uri = new URIBuilder("http://www.metal-archives.com/bands/emperor/30").build();
        HttpGet httpGet = new HttpGet(uri);
        HttpResponse response = client.execute(httpGet);
        HttpEntity entity = response.getEntity();

        BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent()));
        String tmp = "";
        StringBuffer finalText = new StringBuffer();
        while ((tmp = br.readLine()) != null) {
            finalText.append(tmp).append("\n");
        }
        System.out.println(finalText);
    }

}
