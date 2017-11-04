package Model;

/**
 * Created by FDUSER on 11/2/2017.
 */

public class Credentials {
    private static String DB_NAME = "shortlistapplication";
    public static String API_KEY = "48BIPLlX6BZCHsJdwF_3VFWwMuC2IF5r";
    public static  String base_url = String.format("https://api.mlab.com/api/1/databases/%s",DB_NAME);

    public static String getAdressString(String collection_name)
    {
        String url = String.format(base_url+"/collections/%s",collection_name);
        StringBuilder stringBuilder = new StringBuilder(url);
        stringBuilder.append("/?apiKey="+API_KEY);
        return stringBuilder.toString();
    }



    }
