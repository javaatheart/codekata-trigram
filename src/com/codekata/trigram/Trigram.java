/**
 * Had a close look found Trigram is nothing but Map of 3 Strings
 * Key is nothing but first combination of fist and second word
 * Value is the list of Strings following the same key pair
 * @author java_at_heart
 */

package com.codekata.trigram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Trigram extends HashMap<String, List<String>> {

	public final static String SPACE = " ";
	/**
	 *	Just keep the compiler happy.
	 */ 
	private static final long serialVersionUID = 1L;

	public List<String> put(String word1, String word2, String word3) {

		final String mergedKey = getMergedKey(word1,word2);
		List<String> valueList = null;
		if(this.containsKey(mergedKey)){
			valueList = this.get(mergedKey);
			valueList.add(word3);
		}else {
			valueList = new ArrayList<String>();
			valueList.add(word3);
		}
		return super.put(mergedKey, valueList);
	}

	private String getMergedKey(String word1, String word2){
		return word1 + SPACE +  word2;
	}

	private String[] getSplitKeys(String mergedKey){
		return mergedKey.split(SPACE);
	}

	@Override
	public void putAll(Map<? extends String, ? extends List<String>> arg0) {

		for(final String key : arg0.keySet()){
			final String[] splitKeys = getSplitKeys(key);
			for(final String value : arg0.get(key)){
				put(splitKeys[0],splitKeys[1],value);
			}
		}
	}
	@Override
	public List<String> remove(Object key) {
		throw new UnsupportedOperationException("This is Trigram. Remove is not supported. !!");
	}
	@Override
	public List<String> put(String key, List<String> value) {
		throw new UnsupportedOperationException("This is Trigram. Use put(String, String, String) only !!");	
	}
	
	// TODO to be implemented
	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return super.containsValue(value);
	}
}