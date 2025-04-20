package persistencia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonAdapter {
    private static JsonAdapter instance;
    private final Gson gson;
    
    private JsonAdapter() {
        this.gson = new GsonBuilder()
                .setPrettyPrinting() 
                .serializeNulls()    
                .create();
    }
    
    public static JsonAdapter getInstance() {
        if (instance == null) {
            instance = new JsonAdapter();
        }
        return instance;
    }
    
    public String objectToJson(Object objeto) {
        return gson.toJson(objeto);
    }
    
    public <T> T jsonToObject(String json, Class<T> clase) {
        return gson.fromJson(json, clase);
    }
}
