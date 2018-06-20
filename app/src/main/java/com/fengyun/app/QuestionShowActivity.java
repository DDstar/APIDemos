package com.fengyun.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.android.apis.R;
import com.fengyun.model.utils.ModelUtils;
import com.fengyun.utils.ActivityUtils;
import com.fengyun.view.VQuestion;

/**
 * Created by fengyun on 2017/10/13.
 */

public class QuestionShowActivity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        VQuestion vQuestion = new VQuestion(this);
        ActivityUtils.hideNavigationBar(this);
        setContentView(vQuestion);
        vQuestion.setQuestion(ModelUtils.QuestionInstance(this));
    }

}
