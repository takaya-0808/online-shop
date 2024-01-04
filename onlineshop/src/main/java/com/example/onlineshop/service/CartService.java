package com.example.onlineshop.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlineshop.model.GoodsCartModel;
import com.example.onlineshop.entity.OnlineCategoryEntity;
import com.example.onlineshop.entity.OnlineProductEntity;
import com.example.onlineshop.repository.OnlineCategory;
import com.example.onlineshop.repository.IOnlineProduct;
import com.example.onlineshop.service.ICartService;

@Service
public class CartService implements ICartService {

    @Autowired
    private OnlineCategory onlineCategory;

    @Autowired
    private IOnlineProduct onlineProduct;

    public Map<String, GoodsCartModel> shoppingGoods = new HashMap<String, GoodsCartModel>();

    @Override
    public GoodsCartModel findById(String id) {
        
        OnlineProductEntity entity = (OnlineProductEntity)onlineProduct.findById(id);
        GoodsCartModel model = new GoodsCartModel();
        model.setProductCode(entity.getProductCode());
        model.setProductName(entity.getProductName());
        model.setProductSeller(entity.getMaker());
        model.setProductPrice(String.valueOf(entity.getUnitPrice()));
        return model;
    }

    @Override
    public List<GoodsCartModel> findAll() {

        return null;
    }

    @Override
    public void removeById(String id) {
    }

    @Override
    public void cancelAll() {

    }

    @Override
    public int order(List<GoodsCartModel> model) {
        return 0;
    }

    @Override
    public List<GoodsCartModel> add(String id, int count) {

        GoodsCartModel cartModel;
        if (shoppingGoods.containsKey(id)) {
            cartModel = shoppingGoods.get(id);
            count += Integer.parseInt(cartModel.getProductCount());
            shoppingGoods.remove(id);
        } else {
            cartModel = (GoodsCartModel)findById(id);
        }
        cartModel.setProductCount(String.valueOf(count));
        shoppingGoods.put(id, cartModel);
        List<GoodsCartModel> shoppingCart = new ArrayList<>();
        for (var value : shoppingGoods.values()) {
            shoppingCart.add(value);
        }
        return shoppingCart;
    }

    @Override
    public int getCountStock(String id) {

        OnlineProductEntity entity = (OnlineProductEntity)onlineProduct.findById(id);
        int count = entity.getCountStock();
        return count;
    }
}