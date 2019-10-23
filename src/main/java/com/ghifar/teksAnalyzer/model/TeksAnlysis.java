package com.ghifar.teksAnalyzer.model;

import java.util.List;

public class TeksAnlysis {

    private char huruf;
    private int hurufCount;
    private List hurufBefore;
    private List hurufAfter;
    private int hurufDistance;

    public TeksAnlysis(char huruf, int hurufCount, List hurufBefore, List hurufAfter, int hurufDistance) {
        this.huruf = huruf;
        this.hurufCount = hurufCount;
        this.hurufBefore = hurufBefore;
        this.hurufAfter = hurufAfter;
        this.hurufDistance = hurufDistance;
    }


    public char getHuruf() {
        return huruf;
    }

    public void setHuruf(char huruf) {
        this.huruf = huruf;
    }

    public int getHurufCount() {
        return hurufCount;
    }

    public void setHurufCount(int hurufCount) {
        this.hurufCount = hurufCount;
    }

    public List getHurufBefore() {
        return hurufBefore;
    }

    public void setHurufBefore(List hurufBefore) {
        this.hurufBefore = hurufBefore;
    }

    public List getHurufAfter() {
        return hurufAfter;
    }

    public void setHurufAfter(List hurufAfter) {
        this.hurufAfter = hurufAfter;
    }

    public int getHurufDistance() {
        return hurufDistance;
    }

    public void setHurufDistance(int hurufDistance) {
        this.hurufDistance = hurufDistance;
    }
}
