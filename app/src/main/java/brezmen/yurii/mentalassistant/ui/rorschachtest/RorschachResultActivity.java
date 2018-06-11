package brezmen.yurii.mentalassistant.ui.rorschachtest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.TextView;

import java.util.ArrayList;

import brezmen.yurii.mentalassistant.R;

public class RorschachResultActivity extends Activity {

    private static final String KEY_QUESTIONS = "KEY_QUESTIONS";

    private TextView txtHuman;
    private TextView txtAnimal;
    private TextView txtFantastic;
    private TextView txtThings;
    private TextView txtMotion;
    private TextView txtGeneralOrPartly;
    private TextView txtNeitherColorNorShape;
    private TextView txtClearShape;
    private TextView txtVividColor;

    public static Intent createIntent(Context context, @NonNull ArrayList<Question> questions) {
        Intent intent = new Intent(context, RorschachResultActivity.class);
        intent.putParcelableArrayListExtra(KEY_QUESTIONS, questions);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rorschach_result);

        initView();

        ArrayList<Question> questions = getIntent().getParcelableArrayListExtra(KEY_QUESTIONS);

        int humanAnswers = 0;
        int animalAnswers = 0;
        int fantasticAnswers = 0;
        int thingsAnswers = 0;

        for (Question question : questions) {
            // людські образи
            if (Question.WhatYouSee.HUMAN == question.getWhatYouSee()) {
                humanAnswers++;
            }

            // тварини
            if (Question.WhatYouSee.ANIMAL == question.getWhatYouSee()) {
                animalAnswers++;
            }

            // фантастичні істоти
            if (Question.WhatYouSee.FANTASTIC == question.getWhatYouSee()) {
                fantasticAnswers++;
            }

            // нежива природа
            if (Question.WhatYouSee.THINGS == question.getWhatYouSee()) {
                thingsAnswers++;
            }
        }


    }

    private void initView() {
        // для першого питання
        txtHuman = findViewById(R.id.txt_human);
        txtAnimal = findViewById(R.id.txt_animal);
        txtFantastic = findViewById(R.id.txt_fantastic);
        txtThings = findViewById(R.id.txt_things);

        // для другого питання
        txtMotion = findViewById(R.id.txt_motion);

        // для третього питанння
        txtGeneralOrPartly = findViewById(R.id.txt_general_or_partly);

        // для четвертого питання
        txtNeitherColorNorShape = findViewById(R.id.txt_neither_color_nor_shape);
        txtClearShape = findViewById(R.id.txt_clear_shape);
        txtVividColor = findViewById(R.id.txt_vivid_color);
    }
}
