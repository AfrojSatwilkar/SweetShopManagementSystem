package com.bridglabz.sweetshop;
import java.util.HashSet;
import java.util.Set;

public class SweetRepository {

    private Set<Sweet> sweetList = new HashSet();
    public static SweetRepository instance;

    private SweetRepository(){

    }

    public static synchronized SweetRepository getInstance(){
        if (instance == null){
            instance = new SweetRepository();
        }
        return instance;
    }

    public Set getSweetList() {
        return sweetList;
    }

    public void add(Sweet sweet){
        sweetList.add(sweet);
    }

    public void delete(Sweet sweet){
        sweetList.remove(sweet);
    }

    public Sweet getSweet(String name){
        for(Sweet sweet : sweetList){
            if(sweet.name.equalsIgnoreCase(name)){
                return sweet;
            }
        }
        return null;
    }
}