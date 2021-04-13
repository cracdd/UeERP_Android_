package com.material.components.erp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.material.components.R;

import java.util.List;

public class Hr_CheckCardAdapter extends BaseAdapter {

    private List<EmployeeVO> checkList;

    public Hr_CheckCardAdapter(List<EmployeeVO> checkList) {
        this.checkList = checkList;
    }

    @Override
    public int getCount() {
        return checkList.size();
    }

    @Override
    public Object getItem(int position) {
        return checkList.get(position);
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

            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout._erp_hrcardcheck_main, parent, false);

            TextView ccemp_code = convertView.findViewById(R.id.ccemp_code);
            TextView ccdep_name = convertView.findViewById(R.id.ccdep_name);
            TextView cchr_code_name = convertView.findViewById(R.id.cchr_code_name);
            TextView ccemp_name = convertView.findViewById(R.id.ccemp_name);
            TextView ccemp_hire_date = convertView.findViewById(R.id.ccemp_hire_date);

            holder.ccemp_code = ccemp_code;
            holder.ccdep_name = ccdep_name;
            holder.cchr_code_name = cchr_code_name;
            holder.ccemp_name = ccemp_name;
            holder.ccemp_hire_date = ccemp_hire_date;

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder)convertView.getTag();
        }

        EmployeeVO vo = checkList.get(position);

        holder.ccemp_code.setText(vo.getEmp_code());
        holder.ccdep_name.setText(vo.department.getDep_name());
        holder.cchr_code_name.setText(vo.hrCode.getHr_code_name());
        holder.ccemp_name.setText(vo.getEmp_name());
        holder.ccemp_hire_date.setText(vo.getEmp_address());

        return convertView;
    }

    static class ViewHolder {
        TextView ccemp_code;
        TextView ccdep_name;
        TextView cchr_code_name;
        TextView ccemp_name;
        TextView ccemp_hire_date;
    }
}
