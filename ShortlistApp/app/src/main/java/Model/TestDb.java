package Model;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import Classes.JobHolder;

import static Classes.JobHolder.generateJsonObject;

/**
 * Created by FDUSER on 11/2/2017.
 */

public class TestDb {



    public static String getAllDocuments(String collection, Context ctx)
    {
        String op = "failed";
        try {
            String urlString = Credentials.getAdressString(collection);
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            if(urlConnection.getResponseCode()==200)
            {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader r = new BufferedReader(new InputStreamReader(in));
                String line ;
                StringBuilder sb = new StringBuilder();
                while((line=r.readLine())!=null)
                    sb.append(line);
                op = sb.toString();
                urlConnection.disconnect();
            }
            else
            {
                Toast.makeText(ctx,"Something went wrong",Toast.LENGTH_LONG).show();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return op;
    }

    public static String insertDocument(String collection, Context ctx,JobHolder jobHolder)
    {
        String op = "failed";
        try {
            JSONObject document = generateJsonObject(jobHolder);
            String urlString = Credentials.getAdressString(collection);
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.setRequestProperty("Content-Type","application/json");
            urlConnection.setRequestProperty("Accept","application/json");
            urlConnection.setRequestProperty("Method","POST");
            OutputStream os = urlConnection.getOutputStream();
            os.write(document.toString().getBytes("UTF-8"));
            os.close();
            StringBuilder sb = new StringBuilder();
            int HttpResult = urlConnection.getResponseCode();
            if(HttpResult == HttpURLConnection.HTTP_OK)
            {
                BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"utf-8"));

                String line = null;
                while((line = br.readLine())!= null)
                {
                    sb.append(line + "\n");
                }
                br.close();
                Log.e("what happened " , sb.toString());
                op="Success";
            }
            else
            {
                System.out.println("" + urlConnection.getResponseCode());
                System.out.println(urlConnection.getResponseMessage());
            }
            urlConnection.disconnect();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return op;
    }








}
