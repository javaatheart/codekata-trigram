package com.codekata.test.trigram;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import org.junit.Test;

import com.codekata.trigram.Trigram;



public class TrigramTest {
    
    @Test
    public void must_never_accept_two_words() {
        try {
            new Trigram().put("key", new ArrayList<String>());
        } catch (UnsupportedOperationException e) {
            return;
        }
        
        fail("Method is not supported");
    }
    
    @Test
    public void remove_operation_not_supported() {
    	Trigram trigram = new Trigram();
    	trigram.put("word1", "word2", "word3");
    	
        try {
        	trigram.remove("word1");
        } catch (UnsupportedOperationException e) {
            return;
        }
        
        fail("Method is not supported");
    }   
}