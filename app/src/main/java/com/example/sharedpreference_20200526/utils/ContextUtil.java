package com.example.sharedpreference_20200526.utils;

import android.content.Context;
import android.content.SharedPreferences;

//    단순히 기능을 받는 클래스여서 따로 상속을 명시하지 않는다.
public class ContextUtil {

//    메모장의 파일명에 대응되는 개념.
    private static final String prefName = "practicePref";

//    항목의 이름에 오타를 내지 않기 위해서 변수로 만들고 => 자동완성으로 활용
    private static final String USER_ID = "USER_ID";

//    아이디를 받아서 저장해주는 메쏘드드
    public static void setUserId(Context context, String inputId) {
//        메모장을 실제로 열어준다.
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
//        기록해준다.
        pref.edit().putString(USER_ID, inputId).apply();
    }
//    저장되어있는 아이디를 받아서 리턴해주는 메쏘드
    public static String getUserId(Context context) {
        SharedPreferences pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        return pref.getString(USER_ID, "");
    }

}
