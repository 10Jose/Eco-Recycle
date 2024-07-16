package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
ProgressBarAnimation progressBarAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView mihoja =  findViewById(R.id.autumn_leaf);
        mihoja.setRotation(27);
//---------------------------------------------------------------------
        TextView number = findViewById(R.id.number);
        final Handler increment = new Handler();
        //usamos Handler y los convertimos a objeto
        final int finalValue = 70;
        // El valor final al que va llegar el numero
        final int[] curretnValue = {0};
        //El valor actual, inicializado en 0

        final Runnable runner = new Runnable() {
            @Override
            public void run() {
                if (curretnValue[0] < finalValue) {
                    curretnValue[0]++;
                    number.setText(String.valueOf(curretnValue[0]+ "Kg"));
                    //incrementa en 1 cada vez que se menor al valor final
                    increment.postDelayed(this, 30);
                    //un dealy de 1 seg
                }else{
                    increment.removeCallbacks(this);
            }

        }
        };
        increment.post(runner);
//-------------------------------------------------------------------------


        ProgressBar loading =  findViewById(R.id.plasticBar);
        float desde = 0;
        float hasta = 50;
        progressBarAnimation  = new ProgressBarAnimation(loading,desde, hasta);
        progressBarAnimation.setDuration(3000);
        loading.startAnimation(progressBarAnimation);


        ProgressBar loading2 = findViewById(R.id.electronicBar);
        float desde1 = 0;
        float hasta1 = 70;
        progressBarAnimation = new ProgressBarAnimation(loading2,desde1, hasta1);
        progressBarAnimation.setDuration(3000);
        loading2.startAnimation(progressBarAnimation);

        ProgressBar loading3 =  findViewById(R.id.glassBar);
        float desde2 = 0;
        float hasta2 = 20;
        progressBarAnimation = new ProgressBarAnimation(loading3,desde2, hasta2);
        progressBarAnimation.setDuration(3000);
        loading3.startAnimation(progressBarAnimation);

        ProgressBar loading4 =  findViewById(R.id.metalBar);
        float desde4 = 0;
        float hasta4 = 10;
    progressBarAnimation = new ProgressBarAnimation(loading4,desde4, hasta4);
        progressBarAnimation.setDuration(3000);
        loading4.startAnimation(progressBarAnimation);

        ProgressBar loading5 =  findViewById(R.id.paperBar);
        float desde5 = 0;
        float hasta5 = 85;
        progressBarAnimation = new ProgressBarAnimation(loading5,desde5, hasta5);
        progressBarAnimation.setDuration(3000);
        loading5.startAnimation(progressBarAnimation);
//-------------------------------------------------------------------

        BarChart chart = findViewById(R.id.chart);
        ArrayList<BarEntry> values = new ArrayList<>();
        values.add(new BarEntry(0f,50f));
        values.add(new BarEntry(1f,80f));

        BarDataSet set = new BarDataSet(values, "defectValues");
        set.setColors(Color.BLUE, Color.GRAY);
        set.setValueTextColor(Color.WHITE);
        XAxis xAxis = chart.getXAxis();
        xAxis.setTextColor(Color.WHITE);
        YAxis yAxis = chart.getAxisLeft();
        yAxis.setTextColor(Color.WHITE);
        YAxis yAxis1 = chart.getAxisRight();
        yAxis1.setTextColor(Color.WHITE);
        Legend legend = chart.getLegend();
        legend.setTextColor(Color.WHITE);
        legend.setTextSize(14f);
        legend.setCustom(Arrays.asList(new LegendEntry("Actual",Legend.LegendForm.SQUARE,10f,2f,null,Color.WHITE),
        new LegendEntry("Mes Anterior",Legend.LegendForm.SQUARE,10f,2f,null,Color.BLUE)));

        ArrayList<IBarDataSet> datos = new ArrayList<>();
        datos.add(set);

        BarData data = new BarData(datos);
        chart.setData(data);
        chart.invalidate(); //refresh
    }
}