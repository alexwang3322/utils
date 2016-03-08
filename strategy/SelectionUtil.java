package com.lejent.zuoyeshenqi.afanti.analytics;

import java.util.ArrayDeque;

import android.util.Log;

/**
 * 测试用例:
 * 	[] , [1] , [1,2,3] ,,,,,,,,,,,,,  [2,3] ?
 * */
public class SelectionUtil extends SelectionBase {
	
	private ArrayDeque<String> mQueue;
	private String currSendFileName;
	private String currWritableFileName;
	
	
	public SelectionUtil(String prefName, String fieldName){
		super(prefName,fieldName);
	}
	
	/**
	 * @return if nothing would be sent then return null;
	 * */
	public String getSendFileName(){	//取最新应该上传的文件去编辑
		mQueue = stringToQueue(get(), false);
		currSendFileName =  mQueue!=null && mQueue.size()!=0?  mQueue.getFirst():	null;
		return currSendFileName;
	}

	public String getWritableFileName(){
		mQueue = stringToQueue(get(), true);
		currWritableFileName = mQueue.getLast();
		put(queueToString(mQueue));
		return currWritableFileName;
	}
	
	public boolean deleteSendFile(){	//上传完成当前文件
		mQueue.pop();
		return put(queueToString(mQueue));
	}
	
	public boolean updateFileArray(){
		if(mQueue == null)	return false;
		if(mQueue.size() >= fileArrayLength){
			mQueue.pop();
		}
		mQueue.add(getNext());
		if(put(queueToString(mQueue))){
			currWritableFileName = mQueue.getLast();
			return true;
		}
		return false;
	}

	private String getNext(){
		int i = mQueue.size()==0?1:Integer.valueOf(mQueue.getLast())%fileArrayLength + 1;
		return String.valueOf(i);
	}
}
