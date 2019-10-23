package com.ghifar.teksAnalyzer.service.impl;

import com.ghifar.teksAnalyzer.model.TeksAnlysis;
import com.ghifar.teksAnalyzer.service.TeksService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeksServiceImpl implements TeksService {

    @Override
    public ArrayList getHurufs(String text) {
        text= text.toLowerCase();

        ArrayList<Character> hurufList = new ArrayList<>();

        for (char huruf : text.toCharArray()){
            if(!hurufList.contains(huruf)){
                hurufList.add(huruf);
            }
        }


        return hurufList;
    }

    @Override
    public ArrayList getAnalyzedText(ArrayList<Character> textList, String text) {
        text= text.toLowerCase();

        ArrayList<TeksAnlysis> results= new ArrayList<>();

        for (char c : textList) {
           results.add(analyzeHuruf(c, text));
        }
        return results;
    }

    private TeksAnlysis analyzeHuruf(char huruf, String text){

        TeksAnlysis result= null;
        List hurufBeforeList = new ArrayList();
        List hurufAfterList= new ArrayList();

        int count = 0;
        //hitung huruf sama
        for (char h : text.toCharArray()){
            if(h == huruf){
                count++;
            }
        }

        //before after
        for (int i=0; i<text.length();i++){

            if(huruf == text.charAt(i)) {

                try {
                    char before = text.charAt(i + 1);

                    if (before == ' ') {//spasi
                        continue;
                    }

                    hurufBeforeList.add(before);

                }catch (Exception e){

                }


                try {
                    char after = text.charAt(i - 1);

                    if (after == ' ') {//spasi
                        continue;
                    }
                    hurufAfterList.add(after);

                }catch (Exception e){

                }

            }
        }

        //distance max between huruf sama
//        int hurufMaxDistance=0;
//        if (count >= 2){
//            hurufMaxDistance= getHurufMaxDistance(text,huruf);
//        }

        result= new TeksAnlysis(huruf, count, hurufBeforeList,hurufAfterList, 0);
        return result;


    }

    private int getHurufMaxDistance(String str, char huruf){
        int n = str.length();
        List maxLength = new ArrayList();
        for (int i =0;i< n-1; i++){
            if (str.charAt(i) == huruf){
                int nxt= str.indexOf(huruf+"",(i+1));

            }

        }
        int[] out = new int[maxLength.size()];
        for (int i= 0; i < maxLength.size(); i++){
            out[i] = (int) maxLength.get(i);
        }

        return out[out.length-1];
    }


}
