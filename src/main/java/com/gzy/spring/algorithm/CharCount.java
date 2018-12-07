package com.gzy.spring.algorithm;

import java.util.HashSet;

/**
 * @Discribe
 * @Author gzy
 * @Date 2018/12/4 10:33
 */
public class CharCount {

    char character;
    int count;

    public int hashcode(){
        return (int)this.character;
    }

    public boolean equals(Object obj){
        return obj == this || obj instanceof CharCount && this.character == ((CharCount)obj).character;
    }

    public void add(int n){
        this.count += n;
    }

    public CharCount(char character, int count) {
        this.character = character;
        this.count = count;
    }

    @Override
    public String toString() {
        return "CharCount{" + "character=" + character + ", count=" + count + '}';
    }

    class HashCharWeight{

        private HashSet<CharCount> hashSet;

        public HashCharWeight(String text) {
            this.hashSet = new HashSet<>(text.length());
            for (int i= 0;i<text.length();i++){
                CharCount charCount = new CharCount(text.charAt(i),1);
                boolean contains = hashSet.contains(charCount);
            }


        }
    }

}
