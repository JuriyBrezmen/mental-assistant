package brezmen.yurii.mentalassistant.ui.rorschachtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;

import brezmen.yurii.mentalassistant.R;

public class RorschachQuestionFragment extends Fragment {
    public static final String TAG = "RorschachQuestionFragment";
    private int currentIndex = 0;
    private RadioGroup rgQuestion1;
    private RadioGroup rgQuestion2;
    private RadioGroup rgQuestion3;
    private RadioGroup rgQuestion4;
    private ArrayList<Question> questions;
    private ImageView imgPicture;
    private Button btnNext;
    private Button btnResult;
    private ScrollView scrollView;

    @NonNull
    public static Fragment newInstance() {
        return new RorschachQuestionFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.rorschach_question_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        questions = createQuestions();
        initView(view);

    }

    private void initView(@NonNull View view) {
        rgQuestion1 = view.findViewById(R.id.rg_question1);
        rgQuestion2 = view.findViewById(R.id.rg_question2);
        rgQuestion3 = view.findViewById(R.id.rg_question3);
        rgQuestion4 = view.findViewById(R.id.rg_question4);

        scrollView = view.findViewById(R.id.scroll_view);
        imgPicture = view.findViewById(R.id.img_picture);

        btnNext = view.findViewById(R.id.btn_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dataIsValid()) {
                    saveAnswersAndShowNextPicture();
                } else {
                    Toast.makeText(RorschachQuestionFragment.this.getContext(), R.string.data_not_valid, Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnResult = view.findViewById(R.id.btn_result);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentStartDiagnostics = RorschachResultActivity.createIntent(RorschachQuestionFragment.this.getContext(), questions);
                startActivity(intentStartDiagnostics);
            }
        });
    }

    private void saveAnswersAndShowNextPicture() {
        Question question = questions.get(currentIndex);
        saveAnswers(question);

        Question nextQuestion = questions.get(++currentIndex);
        imgPicture.setImageResource(nextQuestion.getPictureId());

        //scroll to the top of screen
        scrollView.fullScroll(ScrollView.FOCUS_UP);

        //for last picture we want to show Result button instead of Next
        if (currentIndex == questions.size() - 1) {
            btnNext.setVisibility(View.GONE);
            btnResult.setVisibility(View.VISIBLE);
        }

        // clear all previous answers
        rgQuestion1.clearCheck();
        rgQuestion2.clearCheck();
        rgQuestion3.clearCheck();
        rgQuestion4.clearCheck();
    }

    private void saveAnswers(Question question) {
        switch (rgQuestion1.getCheckedRadioButtonId()) {
            case R.id.rb_question1_human:
                question.setWhatYouSee(Question.WhatYouSee.HUMAN);
                break;
            case R.id.rb_question1_animal:
                question.setWhatYouSee(Question.WhatYouSee.ANIMAL);
                break;
            case R.id.rb_question1_things:
                question.setWhatYouSee(Question.WhatYouSee.THINGS);
                break;
            case R.id.rb_question1_fantastic:
                question.setWhatYouSee(Question.WhatYouSee.FANTASTIC);
                break;
        }

        switch (rgQuestion2.getCheckedRadioButtonId()) {
            case R.id.rb_question2_yes:
                question.setMotion(true);
                break;
            case R.id.rb_question2_no:
                question.setMotion(false);
                break;
        }

        switch (rgQuestion3.getCheckedRadioButtonId()) {
            case R.id.rb_question3_general:
                question.setAssociationIsGeneral(true);
                break;
            case R.id.rb_question3_partly:
                question.setAssociationIsGeneral(false);
                break;
        }

        switch (rgQuestion4.getCheckedRadioButtonId()) {
            case R.id.rb_question4_neither:
                question.setVividOrClear(Question.VividOrClear.NEITHER);
                break;
            case R.id.rb_question4_vivid:
                question.setVividOrClear(Question.VividOrClear.VIVID);
                break;
            case R.id.rb_question4_clear:
                question.setVividOrClear(Question.VividOrClear.CLEAR);
                break;
        }
    }

    private boolean dataIsValid() {
        boolean isValid = true;
        if (rgQuestion1.getCheckedRadioButtonId() == -1) {
            isValid = false;
        } else if (rgQuestion2.getCheckedRadioButtonId() == -1) {
            isValid = false;
        } else if (rgQuestion3.getCheckedRadioButtonId() == -1) {
            isValid = false;
        } else if (rgQuestion4.getCheckedRadioButtonId() == -1) {
            isValid = false;
        }
        return isValid;
    }

    private ArrayList<Question> createQuestions() {
        ArrayList<Question> questions = new ArrayList<>();
        questions.add(new Question(R.drawable.q0));
        questions.add(new Question(R.drawable.q1));
        questions.add(new Question(R.drawable.q3));
        questions.add(new Question(R.drawable.q4));
        questions.add(new Question(R.drawable.q5));
        questions.add(new Question(R.drawable.q6));
        questions.add(new Question(R.drawable.q7));
        questions.add(new Question(R.drawable.q8));
        questions.add(new Question(R.drawable.q9));
        return questions;
    }
}
