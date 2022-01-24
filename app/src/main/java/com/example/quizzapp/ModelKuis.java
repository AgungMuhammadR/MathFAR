package com.example.quizzapp;

import java.util.ArrayList;

public class ModelKuis {

    public ArrayList<String> pertanyaan;
    public ArrayList<String> jawaban;

    private int currJawaban;

    public ModelKuis(ArrayList<String> pertanyaan, ArrayList<String> jawaban) {
        this.pertanyaan = pertanyaan;
        this.jawaban = jawaban;
    }

    public void setCurrJawaban (int x) {
        this.currJawaban = x;
    }

    public boolean checkJawaban (int y) {

        if (y == this.currJawaban) {
            return true;
        }

        else {
            return false;
        }
    }

}
