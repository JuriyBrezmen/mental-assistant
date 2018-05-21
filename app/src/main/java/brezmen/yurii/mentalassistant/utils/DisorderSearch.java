package brezmen.yurii.mentalassistant.utils;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import brezmen.yurii.mentalassistant.data.model.Disorder;

public class DisorderSearch {
    public static List<Disorder> filterDisorders(List<Disorder> disorderList, int currentSymptomId, boolean symptomContained) {
        List<Disorder> potentialDisorderList = new ArrayList<>();

        for (Disorder disorder : disorderList) {
            Log.d("DisorderSearch", "Disorder" + disorder.getName() + "\n" + disorder.getSymptomIdList() + "\n" + currentSymptomId);
            List<Integer> symptomIdList = disorder.getSymptomIdList();

            if (symptomContained && symptomIdList.contains(currentSymptomId)) {
                potentialDisorderList.add(disorder);
            } else if (!symptomContained && !symptomIdList.contains(currentSymptomId)) {
                potentialDisorderList.add(disorder);
            }
        }
        return potentialDisorderList;
    }
}