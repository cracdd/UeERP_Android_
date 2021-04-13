package com.material.components.erp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.material.components.R;

import java.util.List;

public class Ld_StockSupplyAdapter extends BaseAdapter {

    private List<StockSupplyVO> list;

    public Ld_StockSupplyAdapter(List<StockSupplyVO> list) {
        this.list = list;
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
        ViewHolder holder;

        if(convertView == null) {
            holder = new ViewHolder();

            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout._erp_ldinventorysupply_main, parent, false);

            TextView supply_name = convertView.findViewById(R.id.supply_name);
            TextView supply_regdate = convertView.findViewById(R.id.supply_regdate);
            TextView supply_type = convertView.findViewById(R.id.supply_type);
            TextView supply_amount = convertView.findViewById(R.id.supply_amount);
            TextView supply_quantity = convertView.findViewById(R.id.supply_quantity);

            holder.supply_name = supply_name;
            holder.supply_regdate = supply_regdate;
            holder.supply_type = supply_type;
            holder.supply_amount = supply_amount;
            holder.supply_quantity = supply_quantity;

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder)convertView.getTag();
        }

        StockSupplyVO vo = list.get(position);

        holder.supply_name.setText(vo.product.getPro_name());
        holder.supply_regdate.setText(vo.getStsu_content());
        if (vo.getStsu_type().equals("1")) {
            holder.supply_type.setText("입고");
        }
        if (vo.getStsu_type().equals("2")) {
            holder.supply_type.setText("출고");
        }
        if (vo.getStsu_type().equals("3")) {
            holder.supply_type.setText("이동");
        }
        if (vo.getStsu_type().equals("4")) {
            holder.supply_type.setText("조정");
        }

        holder.supply_amount.setText(vo.getStsu_amount());
        holder.supply_quantity.setText(vo.getStsu_quantity());

        return convertView;
    }

    static class ViewHolder {
        TextView supply_name;
        TextView supply_regdate;
        TextView supply_type;
        TextView supply_amount;
        TextView supply_quantity;
    }

}
