package com.timnesbitt.hashtagtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDB;
    int numberOfTags;

    Button upButton = (Button) this.findViewById(R.id.upButton);
    Button downButton = (Button) this.findViewById(R.id.downButton);
    Button hashtags = (Button) this.findViewById(R.id.hashtagsButton);
    Button categories = (Button) this.findViewById(R.id.categoriesButton);
    Button customList = (Button) this.findViewById(R.id.customListButtom);
    Button selectCategories = (Button) this.findViewById(R.id.selectCategoriesButton);
    Button random = (Button) this.findViewById(R.id.randomButton);

    TextView selectedCategories  = (TextView) this.findViewById(R.id.selectedCategoriesMainText);
    EditText numberOfTagsBox = (EditText) this.findViewById(R.id.numberOfTagsMainText);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TN: Create the DB (initialize the DB?)
        myDB = new DatabaseHelper(this);

    }

    public void randomClickHandler(View view) {
        String numberOfTagsString = numberOfTagsBox.getText().toString();
        int numberOfTagsInt = Integer.parseInt(numberOfTagsString);
        String existingCategories = selectCategories.getText().toString();
        Intent intent = new Intent(getApplicationContext(), RandomPreviewActivity.class);
        intent.putExtra("numberoftags",numberOfTagsInt);
        intent.putExtra("categories",existingCategories);
        startActivity(intent);
    }

    public void hashtagsClickHandler(View view) {
        Intent intent = new Intent(getApplicationContext(), HashtagsActivity.class);
        startActivity(intent);
    }

    public void categoriesClickHandler(View view) {
        Intent intent = new Intent(getApplicationContext(), CategoriesActivity.class);
        startActivity(intent);
    }

    public void customListClickHandler(View view) {
        String existingCategories = selectCategories.getText().toString();
        Intent intent = new Intent(getApplicationContext(), CustomListActivity.class);
        intent.putExtra("categories",existingCategories);
        startActivity(intent);
    }

    public void selectCategoriesClickHandler(View view) {
        String existingCategories = selectCategories.getText().toString();
        Intent intent = new Intent(getApplicationContext(), CategoryListSelectionActivity.class);
        intent.putExtra("categories",existingCategories);
        startActivity(intent);
    }

    public void upButtonClickHandler(View view) {
        numberOfTags++;
        numberOfTagsBox.setText(numberOfTags);
        if (numberOfTags > 30) {
            numberOfTagsBox.setTextColor(getResources().getColor(R.color.RED));
        }else if (numberOfTags == 30) {
            numberOfTagsBox.setTextColor(getResources().getColor(R.color.ORANGE));
        }
    }

    public void downButtonClickHandler(View view) {
        if (numberOfTags > 0) {
            numberOfTags--;
            numberOfTagsBox.setText(numberOfTags);
            if (numberOfTags < 30) {
                numberOfTagsBox.setTextColor(getResources().getColor(R.color.DARKBLUE));
            }else if (numberOfTags == 30) {
                    numberOfTagsBox.setTextColor(getResources().getColor(R.color.ORANGE));
                }
            }
        }
        //else{
        //    return;
    }







