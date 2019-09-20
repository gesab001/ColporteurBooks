package com.giovannisaberon.colporteurbooks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.giovannisaberon.colporteurbooks.BookCardViewDataAdapter;


import java.util.ArrayList;
import java.util.List;

public class AddBooks extends AppCompatActivity {


    private Toolbar toolbar;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<Book> bookList;

    private Button btnSelection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_books);

        Bundle extras = getIntent().getExtras();
        // Step 6: Get the data out of the Bundle
        double lat  = extras.getDouble("lat");
        double longitude = extras.getDouble("longitude");
        String message = "lat: " + Double.toString(lat) + " longitude: " + Double.toString(longitude);
        Log.d("INFO", message);

        //toolbar = (Toolbar) findViewById(R.id.toolbar);
        btnSelection = (Button) findViewById(R.id.btn_show);

        bookList = new ArrayList<Book>();

//        for (int i = 1; i <= 15; i++) {
//            Book bk = new Book("Book " + i, "androidstudent" + i
//                    + "@gmail.com", false);
//
//            bookList.add(bk);
//        }

        Book bk = new Book("Desire of Ages", "DA", false);
        bookList.add(bk);

        bk = new Book("Great Controversy", "GC", false);
        bookList.add(bk);

        bk = new Book("Acts of the Apostles", "AA", false);
        bookList.add(bk);

        bk = new Book("Patriarchs and Prophets", "PP", false);
        bookList.add(bk);

        bk = new Book("Prophets and Kings", "PK", false);
        bookList.add(bk);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new BookCardViewDataAdapter(bookList);
        mRecyclerView.setAdapter(mAdapter);


//        btnSelection.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(AddBooks.this,
//                        "Selected Books: \n" + "DA", Toast.LENGTH_LONG)
//                        .show();
//            }
//        });
//
//
        btnSelection.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                String data = "";
                List<Book> bkList = ((BookCardViewDataAdapter) mAdapter)
                        .getBookList();

                for (int i = 0; i < bkList.size(); i++) {
                    Book singleBook = bkList.get(i);
                    if (singleBook.isSelected() == true) {

                        data = data + "\n" + singleBook.getName().toString();

                    }

                }

                Toast.makeText(AddBooks.this,
                        "Selected Books: \n" + data, Toast.LENGTH_LONG)
                        .show();

            }
        });

    }
}
