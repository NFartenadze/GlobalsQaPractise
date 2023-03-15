package com.solvd.carina.globalsqa;

public class Main {
    public static void stringExpansion(String text){
        String filtered = text.replaceAll("\\[|]", "");// b2a3
        int digit = 0;
        StringBuilder expansion = new StringBuilder();
        for (int i = filtered.length() - 1; i >= 0; i--) {
            char c = filtered.charAt(i);
            if (Character.isDigit(c)) {
                digit = Character.getNumericValue(c);
                expansion = new StringBuilder(expansion.toString().repeat(digit)).reverse();
            } else {
                expansion.append(c);
            }
        }
        System.out.println(expansion);
    }

    public static void main(String[] args) {
        stringExpansion("3[abcs]");
    }
}
