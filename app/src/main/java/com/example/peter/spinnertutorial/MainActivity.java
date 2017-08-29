package com.example.peter.spinnertutorial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Spinnerで選択したアイテムを表示する
 *
 * @author :ryo.yamada
 * @since :1.0 :2017/08/30
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // spinnerのアイテムのリスト
        final String[] languageList = getResources().getStringArray(R.array.programming_language);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        final TextView textView = (TextView) findViewById(R.id.text);

        // args[2]: アイテムのレイアウト
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item, languageList);
        // args: ドロップダウン用のレイアウト
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);

        // spinnerにadapterをセット
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Spinner spinner = (Spinner) adapterView;
                String item = (String) spinner.getSelectedItem();

                for (String lang : languageList) {
                    if (item.equals(lang)) {
                        textView.setText(lang);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
