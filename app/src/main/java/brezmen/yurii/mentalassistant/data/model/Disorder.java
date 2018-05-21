package brezmen.yurii.mentalassistant.data.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuriy on 21.04.17.
 */
public class Disorder {
    private String name;
    private int id;
    private List<Integer> symptomIdList;
    private String description;

    public Disorder() {
        symptomIdList = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getSymptomIdList() {
        return symptomIdList;
    }

    public void setSymptomIdList(List<Integer> symptomIdList) {
        this.symptomIdList = symptomIdList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addSymptoms(Integer... symptoms) {

        for (Integer symptom : symptoms) {
            symptomIdList.add(symptom);
        }

    }
}