package com.example.healyhyapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.healyhyapp.Adapter.BestDealAdapter;
import com.example.healyhyapp.Adapter.CategoryAdapter;
import com.example.healyhyapp.Domain.CategoryDomain;
import com.example.healyhyapp.Domain.ItemsDomain;
import com.example.healyhyapp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter catAdapter,bestDealAdapter;
    private RecyclerView recyclerViewCat,recyclerViewBestDeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerviewCat();
        initLocation();
        initRecyclerViewBestDeal();
    }

    private void initLocation() {
        String[] items=new String[]{"LosAngles, USA","NewYork, USA"};
        final Spinner locationSpin= findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpin.setAdapter(adapter);
    }

    private void initRecyclerviewCat() {
        ArrayList<CategoryDomain> items=new ArrayList<>();
        items.add(new CategoryDomain("cat1","Vegetable"));
        items.add(new CategoryDomain("cat2","Fruits"));
        items.add(new CategoryDomain("cat3","Dairy"));
        items.add(new CategoryDomain("cat4","Drinks"));
        items.add(new CategoryDomain("cat5","Grain"));

        recyclerViewCat=findViewById(R.id.catView);
        recyclerViewCat.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        catAdapter = new CategoryAdapter(items);
        recyclerViewCat.setAdapter(catAdapter);


    }
    private void initRecyclerViewBestDeal(){
        recyclerViewBestDeal=findViewById(R.id.bestView);
        recyclerViewBestDeal.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));

        bestDealAdapter=new BestDealAdapter(getData());
        recyclerViewBestDeal.setAdapter(bestDealAdapter);
    }
    public ArrayList<ItemsDomain> getData(){
        ArrayList<ItemsDomain>items=new ArrayList<>();
        items.add(new ItemsDomain("orange","Fresh Orange",6.2,"With its vibrant orange hue and a burst of refreshing" +
                " citrus flavor, the juicy orange is a natural source of" +
                " vitamin C, invigorating your senses and" +
                "supporting your immune system. A delightful snack" +
                " that combines health and taste.",4.2));
        items.add(new ItemsDomain("apple","Fresh apple",6.5, "Crisp and succulent, apples are nature's candy. Each bite offers a symphony of sweetness and a satisfying crunch. Packed with fiber and antioxidants, apples make for a wholesome snack,keeping you energized throughout the day.",4.8));
        items.add(new ItemsDomain("watermelon","Fresh berry",5.1,"Quench your thirst and satisfy your sweet tooth with the hydrating goodness of watermelon. Bursting with juiciness and vibrant color,this summer favorite is a natural way to stay cool and refreshed. Enjoy the taste of summer with every juicy bite",4.9));
        items.add(new ItemsDomain("berry","Fresh Berry",6,"Nature's little jewels, cherries are a burst of sweet indulgence. Packed with antioxidants, these tiny treats not only satisfy your sweet cravings but also contribute to overall well-being. Pop a handful for a guilt-free snack that delights your taste buds.",4.5));
        items.add(new ItemsDomain("pineapple","Fresh Pineapple",10,"Transport yourself to the tropics with the exotic taste of pineapple. Juicy and tantalizingly sweet, this golden fruit is not only a treat for your taste buds but also a rich source of sunshine to your day.",3));
        items.add(new ItemsDomain("strawberry","Fresh Strawberry",12,"Delight in the sweetness of strawberries each berry a burst of flavor and nutrition. Whether enjoyed on their own or addend to your favorite dishes, these red gems are a guilt-free pleasure, offering a dose of vitamin C, antioxidants, and a touch of natural sweetness.",4));
        return items;

    }
}