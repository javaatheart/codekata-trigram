package com.codekata.test.trigram;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.codekata.trigram.Trigram;

/**
 * @author java_at_heart
 *
 */
public class TrigramTest {
	
	Trigram trigram = new Trigram();
	
    @Test
    public void must_never_accept_two_words() {
    	try {
    		trigram.clear();
            trigram.put("key", new ArrayList<String>());
        } catch (UnsupportedOperationException e) {
            return;
        }
        
        fail("Method is not supported");
    }
    
    @Test
    public void remove_operation_not_supported() {
    	trigram.clear();
    	trigram.put("word1", "word2", "word3");
        try {
        	trigram.remove("word1");
        } catch (UnsupportedOperationException e) {
            return;
        }
        
        fail("Method is not supported");
    }
    @Test
    public void test_all_three_words_same() {
    	trigram.clear();
    	trigram.put("sameword", "sameword", "sameword");
    	assertEquals(trigram.keySet().size(), 1);
    }
    @Test
    public void test_data_formation_using_trigram() {
    	trigram.clear();
    	trigram.put("word1", "word2", "word3");
    	assertEquals(trigram.keySet().toArray()[0], "word1 word2");
    	trigram.put("word1", "word2", "word3");
    	trigram.put("word1", "word2", "word3");
    	assertEquals(trigram.keySet().size(), 1);
    	
    	trigram.put("I", "WISH", "I");
    	
    	List<String> actual = trigram.get("I WISH");
    	List<String> expected = new ArrayList<String>();
    	expected.add("I");
    	assertEquals(actual, expected);
    	
    	trigram.put("I", "WISH", "MAY");
    	expected.add("MAY");
    	assertEquals(actual, expected);
    }
    
}