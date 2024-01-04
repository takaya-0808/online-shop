package com.example.onlineshop.service;

import java.util.List;
import java.util.Map;

import com.example.onlineshop.model.GoodsCartModel;

public interface ICartService extends IService {

    public List<GoodsCartModel> add(String id, int count);

    public List<GoodsCartModel> findAll();

    public void removeById(String id);

    public void cancelAll();

    public int order(List<GoodsCartModel> model);

    public int getCountStock(String id);

}