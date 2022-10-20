package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ListManipulator {
    public ArrayList<Integer> sort(ArrayList<Integer> myLst, Boolean ascending) {
        if (ascending) {
            Collections.sort(myLst);
        } else {
            Collections.sort(myLst, Collections.reverseOrder());
        }
        return myLst;
    }

    public ArrayList<Integer> swapLargestSmallest(ArrayList<Integer> myLst) {
        int minElement = 0;
        int maxElement = 0;
        minElement = myLst.indexOf(Collections.min(myLst));
        maxElement = myLst.indexOf(Collections.max(myLst));
        Collections.swap(myLst, minElement, maxElement);
        return myLst;
    }

    void table(ArrayList<Integer> myLst) {
        Map<Integer, Integer> myHm = new HashMap<Integer, Integer>();
        for (Integer key : myLst) {
            Integer count = myHm.get(key);
            myHm.put(key, (count == null) ? 1 : count + 1);
        }
        for (Map.Entry<Integer, Integer> val : myHm.entrySet()) {
            System.out.println("value: " + val.getKey() + " occurs " + val.getValue() + " times");
        }
    }

}