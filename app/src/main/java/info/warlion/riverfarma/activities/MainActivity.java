package info.warlion.riverfarma.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import info.warlion.riverfarma.R;
import info.warlion.riverfarma.adapter.RecyclerViewAdapter;
import info.warlion.riverfarma.model.Products;

public class MainActivity extends AppCompatActivity {


    private final String JSON_URL = "http://riverfarma.com.mx/json_app.php?product";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Products> lstProduct;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        lstProduct = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerviewid);
        jsonrequest();
    }

    private void jsonrequest() {
        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;
                for(int i = 0; i < response.length(); i++){

                    try{
                        jsonObject = response.getJSONObject(i);
                        Products products = new Products();
                        products.setId(jsonObject.getInt("id"));
                        products.setName(jsonObject.getString("name"));
                        products.setDescription(jsonObject.getString("description"));
                        products.setCategoria(jsonObject.getString("categoria"));
                        products.setParentCategoria(jsonObject.getString("ParentCategoria"));
                        products.setCode(jsonObject.getString("code"));
                        products.setPdf(jsonObject.getString("pdf"));
                        products.setYoutube(jsonObject.getString("youtube"));
                        products.setUrl_image(jsonObject.getString("url_image"));
                        lstProduct.add(products);



                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                setuprecyclerciew(lstProduct);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);
    }

    private void setuprecyclerciew(List<Products> lstProduct) {

        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this,lstProduct);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);



    }
}
