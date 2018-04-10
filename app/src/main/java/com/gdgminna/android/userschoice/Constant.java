package com.gdgminna.android.userschoice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MAGANI on 08/04/2018.
 */

class Constant {

    public static final List<Integer> QUANTITY_LIST = new ArrayList<Integer>();

    static {
        for (int i = 1; i < 6; i++) QUANTITY_LIST.add(i);
    }

    public static final String CURRENCY = "N";
}
