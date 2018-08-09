package info.warlion.riverfarma.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import info.warlion.riverfarma.model.Products;
import info.warlion.riverfarma.R;

public class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

    private Context mContext;
    private List<Products> mData;
    RequestOptions options;

    public RecyclerViewAdapter(Context mContext, List<Products> mData) {
        this.mContext = mContext;
        this.mData = mData;

        //request option for glide
        options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.loading_shape)
                .error(R.drawable.loading_shape);
    }


    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.products_row_item,parent, false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {


        holder.product_name.setText(mData.get(position).getName());
        holder.product_categoria.setText(mData.get(position).getCategoria());
        holder.product_subcategoria.setText(mData.get(position).getParentCategoria());
        holder.product_code.setText(mData.get(position).getCode());

        Glide.with(mContext).load(mData.get(position).getUrl_image()).apply(options).into(holder.product_image);


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView product_name;
        TextView product_categoria;
        TextView product_subcategoria;
        TextView product_code;
        ImageView product_image;





        public MyViewHolder(View itemView){
            super(itemView);

            product_name = itemView.findViewById(R.id.product_name);
            product_categoria = itemView.findViewById(R.id.categorie);
            product_subcategoria = itemView.findViewById(R.id.sub_categorie);
            product_code = itemView.findViewById(R.id.code);
            product_image = itemView.findViewById(R.id.thumbnail);


        }

    }




}
