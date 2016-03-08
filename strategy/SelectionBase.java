package com.lejent.zuoyeshenqi.afanti.analytics;

import java.util.ArrayDeque;
import java.util.Arrays;

import com.lejent.zuoyeshenqi.afanti.application.LeshangxueApplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;



public class SelectionBase {

	private static final int DEFAULT_FILE_ARRAY_LENGTH = 3;
	protected int fileArrayLength; 
	private SharedPreferences innerPrefs;
	private String arrayPrefeName;
	private String arrayFieldName;
	
	public SelectionBase(String prefName, String fieldName){
		this(prefName, fieldName, DEFAULT_FILE_ARRAY_LENGTH);
	}
	
	public SelectionBase(String prefName, String fieldName, int arrayLength){
		fileArrayLength = arrayLength;
		arrayPrefeName = prefName;
		arrayFieldName = fieldName;
		innerPrefs = LeshangxueApplication.getGlobalContext().getSharedPreferences(arrayPrefeName, Context.MODE_PRIVATE);
	}
	protected String get(){
		return innerPrefs.getString(arrayFieldName, "");
	}

	protected boolean put(String str){
		return innerPrefs.edit().putString(arrayFieldName, str).commit();
	}

	private String[] stringToArray(String str){
		if(str.equals("null") || str==null || str.isEmpty() || str.length()==2)
			// when : str is one of { null, "", [] }
			return null;
		return str.substring(1, str.length() - 1).split(", ");
	}
	/**
	 * @param isDefault 没有任何资源时候，初始化资源，并加入第一个资源
	 * */
	private ArrayDeque<String> arrayToQueue(String[] arrstr, boolean isDefault){
		ArrayDeque<String> arr = null;
		if(arrstr == null){
			arr = new ArrayDeque<String>(fileArrayLength);
			if(isDefault)	arr.add("1");
		}else{
			arr = new ArrayDeque<String>(Arrays.asList(arrstr));
		}
		return arr;
	}
	
	protected String queueToString(ArrayDeque<String> q){
		return q.toString();
	}

	protected ArrayDeque<String> stringToQueue(String strarr){
		return arrayToQueue(stringToArray(strarr) , true);
	}

	protected ArrayDeque<String> stringToQueue(String strarr, boolean isDefault){
		return arrayToQueue(stringToArray(strarr) , isDefault);
	}
}
