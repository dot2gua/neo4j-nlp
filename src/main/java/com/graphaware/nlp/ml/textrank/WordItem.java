/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.graphaware.nlp.ml.textrank;

/**
 *
 * @author vla
 */
public class WordItem {
    private final int startPosition;
    private final int endPosition;
    private final String word;

    public WordItem(int start, int end, String word) {
        this.startPosition = start;
        this.endPosition = end;
        this.word = word;
    }
    
    public int getStart() {
        return this.startPosition;
    }

    public int getEnd() {
        return this.endPosition;
    }

    public String getWord() {
        return this.word;
    }
}
