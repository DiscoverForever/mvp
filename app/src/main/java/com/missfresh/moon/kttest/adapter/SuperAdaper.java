package com.missfresh.moon.kttest.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.missfresh.moon.kttest.R;
import com.missfresh.moon.kttest.entity.goods.Goods;

import java.util.List;

public class SuperAdaper extends RecyclerView.Adapter<SuperAdaper.ViewHolder> {
    private List<Goods> goodsList;

    public SuperAdaper(@NonNull List<Goods> list) {
        goodsList = list;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        /**
         * id : 1
         * shelfLay : 2
         * layLine : 2
         * goodsName : 华北红肉火龙果【品类水果】
         * goodsNo : p-hbhrhlg-1g
         * picUrl : https://image.missfresh.cn/731945401be04d6e87cda4d08401785e.jpeg
         * codeType : 2
         * codeNo : 6000006
         * materialNo : 6000006
         * qualityType : 0
         * operationDate : 1536031350385
         * uniqueCode : 275
         */
        TextView id;
        TextView shelfLay;
        TextView layLine;
        TextView goodsName;
        TextView goodsNo;
        TextView codeType;
        TextView codeNo;
        TextView materialNo;
        TextView qualityType;
        TextView operationDate;
        TextView uniqueCode;
        public ViewHolder(View view) {
            super(view);
            id = view.findViewById(R.id.id);
            shelfLay = view.findViewById(R.id.shelfLay);
            layLine = view.findViewById(R.id.layLine);
            goodsName = view.findViewById(R.id.goodsName);
            goodsNo = view.findViewById(R.id.goodsNo);
            codeType = view.findViewById(R.id.codeType);
            codeNo = view.findViewById(R.id.codeNo);
            materialNo = view.findViewById(R.id.materialNo);
            qualityType = view.findViewById(R.id.qualityType);
            operationDate = view.findViewById(R.id.operationDate);
            uniqueCode = view.findViewById(R.id.uniqueCode);
        }
    }

    @Override
    public int getItemCount() {
        Log.d("size", "" + goodsList.size());
        return goodsList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int poistion) {
        Goods goods = goodsList.get(poistion);
        viewHolder.id.setText("" + goods.getId());
        viewHolder.shelfLay.setText("" + goods.getShelfLay());
        viewHolder.layLine.setText("" + goods.getLayLine());
        viewHolder.goodsName.setText("" + goods.getGoodsName());
        viewHolder.goodsNo.setText("" + goods.getGoodsNo());
        viewHolder.codeType.setText("" + goods.getCodeType());
        viewHolder.codeNo.setText("" + goods.getCodeNo());
        viewHolder.materialNo.setText("" + goods.getMaterialNo());
        viewHolder.qualityType.setText("" + goods.getQualityType());
        viewHolder.operationDate.setText("" + goods.getOperationDate());
        viewHolder.uniqueCode.setText("" + goods.getUniqueCode());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
}
