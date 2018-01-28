package com.zing.nio_study.kans;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Compare {
    List<DuiZhan> zc = new ArrayList<>();
    List<DuiZhan> blog = new ArrayList<>();

    public void initData() {
        DuiZhan zc1 = new DuiZhan("A001", 100, "");
        DuiZhan zc2 = new DuiZhan("A002", 100, "");
        DuiZhan zc3 = new DuiZhan("A003", 100, "");
        DuiZhan zc4 = new DuiZhan("A004", 100, "");
        DuiZhan zc5 = new DuiZhan("A005", 100, "");

        DuiZhan blog1 = new DuiZhan("A001", 100, "");
        DuiZhan blog2 = new DuiZhan("A002", 200, "");
        DuiZhan blog3 = new DuiZhan("A003", 300, "");
        DuiZhan blog4 = new DuiZhan("A004", 400, "");

        zc.addAll(Arrays.asList(zc1, zc2, zc3, zc4, zc5));
        blog.addAll(Arrays.asList(blog1, blog2, blog3, blog4));

    }

    @Test
    public void fuck() {
        initData();
        HashMap<String, DuiZhan> wdt = new HashMap<>();
        List<String> sameKey = new ArrayList<>();
        List<String> onlyZC = new ArrayList<>();
        List<String> onlyBA = new ArrayList<>();
        for (DuiZhan o : zc) {
            wdt.put(o.di(), o);
            onlyZC.add(o.di());
        }

        for (DuiZhan o : blog) {
            if (wdt.containsKey(o.di())) {
                sameKey.add(o.di());
            } else {
                wdt.put(o.di(), o);
                onlyBA.add(o.di());
            }
        }

        onlyZC.removeAll(sameKey);

        System.out.println("\nSame OBJ");
        for (String o : sameKey) {
            System.out.println(wdt.get(o));
        }
        System.out.println("\nonly ZC");

        for (String o : onlyZC) {
            System.out.println(wdt.get(o));
        }
        System.out.println("\nonly BA");
        for (String o : onlyBA) {
            System.out.println(wdt.get(o));
        }
    }


}
