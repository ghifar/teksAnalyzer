package com.ghifar.teksAnalyzer.service;

import java.util.ArrayList;

public interface TeksService {

    public ArrayList getHurufs(String teks);

    public ArrayList getAnalyzedText(ArrayList<Character> textList, String text);
}
