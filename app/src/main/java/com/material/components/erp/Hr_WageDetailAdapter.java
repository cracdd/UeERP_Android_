package com.material.components.erp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.material.components.R;

import java.util.List;

public class Hr_WageDetailAdapter extends BaseAdapter {

    private List<SalaryStatementVO> sslist;

    public Hr_WageDetailAdapter(List<SalaryStatementVO> ssList) {
        this.sslist = ssList;
    }

    @Override
    public int getCount() {
        return sslist.size();
    }

    @Override
    public Object getItem(int position) {
        return sslist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Viewholder holder;

        if(convertView == null) {
            holder = new Viewholder();

            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout._erp_hrwagedetail_main, parent, false);

            TextView dep_name = convertView.findViewById(R.id.wddep_name);
            TextView hr_code_name = convertView.findViewById(R.id.wdhr_code_name);
            TextView emp_name = convertView.findViewById(R.id.wdemp_name);
            TextView ss_total_sal = convertView.findViewById(R.id.wdss_total_sal);
            TextView ss_state = convertView.findViewById(R.id.wdss_state);

            holder.dep_name = dep_name;
            holder.hr_code_name = hr_code_name;
            holder.emp_name = emp_name;
            holder.ss_total_sal = ss_total_sal;
            holder.ss_state = ss_state;

            convertView.setTag(holder);

        } else {
            holder = (Viewholder)convertView.getTag();
        }

        SalaryStatementVO vo = sslist.get(position);

        holder.dep_name.setText(vo.department.getDep_name());
        holder.hr_code_name.setText(vo.hrCode.getHr_code_name());
        holder.emp_name.setText(vo.employee.getEmp_name());
        holder.ss_total_sal.setText(vo.getSs_total_sal());
        if (vo.getSs_state().equals("1")) {
            holder.ss_state.setText("지급");
        }
        if (vo.getSs_state().equals("0")) {
            holder.ss_state.setText("대기");
        }

        return convertView;
    }

    static class Viewholder {
        TextView dep_name;
        TextView hr_code_name;
        TextView emp_name;
        TextView ss_total_sal;
        TextView ss_state;
    }

}
