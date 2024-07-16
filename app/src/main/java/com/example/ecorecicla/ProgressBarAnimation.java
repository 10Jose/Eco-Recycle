package com.example.ecorecicla;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;

public class ProgressBarAnimation extends Animation {

    public ProgressBar progressBar;
    public float desde;
    public float hasta;

    public ProgressBarAnimation(ProgressBar progressBar,float desde, float hasta){
        super();
        this.progressBar = progressBar;
        this.desde = desde;
        this.hasta = hasta;
    }

    @Override
    protected void applyTransformation(float time, Transformation t){
        super.applyTransformation(time, t);
        float value = desde + (hasta - desde) * time;

        progressBar.setProgress((int)value);
    }
}