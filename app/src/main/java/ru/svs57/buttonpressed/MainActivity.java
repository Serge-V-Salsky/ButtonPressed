package ru.svs57.buttonpressed;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private int buttonPressed = 0, textViewPressed = 0, pr = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view)
    {
        show(view);
    }
    public void onTextViewClick(View view)
    {
        show(view);
    }

    public void show(View view)
    {

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, findViewById(R.id.toast_layout));

        TextView toastText = findViewById(R.id.toastText);
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);//targetSdk должно быть <= 29
        toast.setDuration(Toast.LENGTH_SHORT);
        switch (view.getId())
        {
            case (R.id.button):
                buttonPressed ++;
                toastText.setText("Нажата кнопка");
 //               toast = Toast.makeText(this, "Нажата кнопка", Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();
                break;
            case (R.id.textView):
                textViewPressed ++;
                toastText.setText("Нажатие на текст");
                toast = Toast.makeText(this, "Нажатие на текст", Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();
                break;
        }
        TextView textView = findViewById(R.id.textView);
        textView.setText("Нажатий кнопки - "+buttonPressed+"\nНажатий текста  - "+textViewPressed);
    }
}
