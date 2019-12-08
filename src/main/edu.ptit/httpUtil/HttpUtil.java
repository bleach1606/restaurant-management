package httpUtil;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpUtil {
    private String key;

    public HttpUtil(String key) {
        this.key = key;
    }

    public <T> T toModel(Class<T> tClass) {
        try {
            return new ObjectMapper().readValue(key, tClass);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public static HttpUtil of (BufferedReader reader) {
        StringBuilder builder = new StringBuilder();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        }catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return new HttpUtil(builder.toString());
    }
}
