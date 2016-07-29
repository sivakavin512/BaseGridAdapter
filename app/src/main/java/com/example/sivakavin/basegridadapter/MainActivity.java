package com.example.sivakavin.basegridadapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener{

    GridView icons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        icons= (GridView) findViewById(R.id.gridView);
        CustomAdapter adapter=new CustomAdapter(this);
        icons.setAdapter(adapter);
        icons.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String[] item={"First","Second","Third","Fourth","Fiveth","Sixth","Seventh","Eighth","Nineth"};
        Intent intent=new Intent(this,Mydialog.class);
        Viewholder holder= (Viewholder) view.getTag();
        singleitem temp= (singleitem) holder.icon_v.getTag();
        String dataa=temp.icon_name.toString();
        try {
            intent.putExtra("icon_im", temp.icon_image);
            intent.putExtra("icon_tx", temp.icon_name);
        }catch (Exception e){
            Log.i("vuz",""+e);
        }
        startActivity(intent);
    }
}


//Creating a single Item For Optimazation
class singleitem{
    int icon_image;
    String icon_name;
    public singleitem(int icon,String name){
        this.icon_image=icon;
        this.icon_name=name;
    }
}

//To Redude a inflation Process
class Viewholder{
    ImageView icon_v;
    TextView name_icon;
    public Viewholder(View view){
        icon_v= (ImageView) view.findViewById(R.id.icon_view);
        name_icon= (TextView) view.findViewById(R.id.icon_name);
    }
}

class CustomAdapter extends BaseAdapter{
    Context context;
    ArrayList<singleitem> list;
    String[] icone_na;
    int[] icons_draw;

    public CustomAdapter(Context c){
        this.context=c;
        Resources resources=c.getResources();
        icone_na=resources.getStringArray(R.array.icons);
        icons_draw= new int[]{R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six, R.drawable.seven, R.drawable.eight, R.drawable.nine};
        list=new ArrayList<singleitem>();
        for (int i = 0; i <9 ; i++) {
            list.add(new singleitem(icons_draw[i],icone_na[i]));
        }

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row=convertView;
        Viewholder holder;
        if(row==null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.icon_design,parent,false);
            holder=new Viewholder(row);
            row.setTag(holder);
        }else{
            holder= (Viewholder) row.getTag();
        }
        holder.icon_v.setImageResource(icons_draw[position]);
        holder.name_icon.setText(icone_na[position]);

        return row;
    }
}
