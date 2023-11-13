package com.example.onlineshop.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public interface IRepository <T> {

    public T findById(String id);

}