package brezmen.yurii.mentalassistant.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import brezmen.yurii.mentalassistant.data.model.Disorder;
import brezmen.yurii.mentalassistant.data.source.Database;
import brezmen.yurii.mentalassistant.data.model.Symptom;
import brezmen.yurii.mentalassistant.R;
import brezmen.yurii.mentalassistant.utils.DisorderSearch;

/**
 * Created by yuriy on 21.04.17.
 */
public class DiagnosticsActivity extends AppCompatActivity {

    private TextView question;
    private TextView textStatus;
    private int currentQuestion;
    private List<Symptom> symptomList;
    private List<Integer> selectedSymptom;
    private List<Disorder> disorderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnostics);

        initView();

        Database factory = new Database();
        disorderList = factory.getDisorderList();
        symptomList = factory.getSymptomList();
        selectedSymptom = new ArrayList<>();

        currentQuestion = 0;
        askQuestion();

    }

    private void initView() {

        textStatus = (TextView) findViewById(R.id.status);

        question = (TextView) findViewById(R.id.question);
        Button buttonYes = (Button) findViewById(R.id.buttonYes);
        buttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Symptom symptom = symptomList.get(currentQuestion);
                disorderList = DisorderSearch.filterDisorders(disorderList, symptom.getId(), true);
                selectedSymptom.add(symptom.getId());
                textStatus.setText(Integer.toString(disorderList.size()));
                checkResults();
            }
        });

        Button buttonNo = (Button) findViewById(R.id.buttonNo);
        buttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textStatus.setText(Integer.toString(disorderList.size()));
                checkResults();
            }
        });

        Button buttonUnknown = (Button) findViewById(R.id.buttonUnknown);
        buttonUnknown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textStatus.setText(Integer.toString(disorderList.size()));
                checkResults();
            }
        });
    }

    private void checkResults() {
        if (disorderList.size() == 0) {
            //disorder not found
            Toast.makeText(this, "disorder not found", Toast.LENGTH_SHORT).show();

        } else {
            currentQuestion++;
            if (currentQuestion < symptomList.size()) {
               askQuestion();
            }
            else {
                for (Disorder disorder : disorderList) {
                    if (selectedSymptom.containsAll(disorder.getSymptomIdList())) {
                        Toast.makeText(this, disorder.getName(), Toast.LENGTH_SHORT).show();
                        // на всі питання відповіли "так", значить це точно ця хвороба
                        // вивести десь в текств'ю disorder.getName();
                    } else {
                        Toast.makeText(this, "МАБУТЬ" + disorder.getName(), Toast.LENGTH_SHORT).show();
                        // деякі симптоми збігаються, а на деякі відповіли "невідомо"
                        // значить вивести десь в ттекств'ю, що це припущення disorder.getName();
                    }
                }
            }
        }
    }
        public void askQuestion() {
            boolean found = false;
            Symptom symptom = symptomList.get(currentQuestion);
            for (Disorder disorder : disorderList) {
                if (disorder.getSymptomIdList().contains(symptom.getId())) {
                    found = true;
                    break;
                }
            }

            if (found) {
                question.setText(symptom.getQuestion());
            } else {
                checkResults();
            }

        }

}