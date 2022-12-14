package com.example.gridviewex;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    Integer[] bookTitles = {R.string.book1, R.string.book2, R.string.book3, R.string.book4,
                            R.string.book5, R.string.book6, R.string.book7, R.string.book8,
                            R.string.book9, R.string.book10, R.string.book11, R.string.book12};

    Integer[] authors = { R.string.author1, R.string.author2, R.string.author3, R.string.author4,
                          R.string.author5, R.string.author6, R.string.author7, R.string.author8,
                          R.string.author9, R.string.author10, R.string.author11, R.string.author12};

    Integer[] bookCovers = {R.drawable.book_img1,  R.drawable.book_img2, R.drawable.book_img3,
                        R.drawable.book_img4,  R.drawable.book_img5, R.drawable.book_img6,
                        R.drawable.book_img7,  R.drawable.book_img8, R.drawable.book_img9,
                        R.drawable.book_img10,  R.drawable.book_img11, R.drawable.book_img12};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView bookList = findViewById(R.id.gridView);

        bookList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*Toast.makeText(MainActivity.this,
                        getResources().getString(bookTitles[position]), Toast.LENGTH_SHORT).show();*/

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("title", getResources().getString(bookTitles[position]));
                intent.putExtra("author", getResources().getString(authors[position]));
                intent.putExtra("cover_index", position);

                startActivity(intent);
            }
        });

        // ????????? ?????? ??????
        BookAdapter adapter = new BookAdapter(MainActivity.this);
        // ??????????????? ????????? ??????
        bookList.setAdapter(adapter);
    }


    class BookAdapter extends BaseAdapter {
        Activity context;

        public BookAdapter(Activity context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return bookTitles.length;
        }

        @Override
        public Object getItem(int position) {
            return bookTitles[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();

            // ????????? ????????? ????????? ??? ??????????????? ????????? ??????
            if (convertView == null) {  // ????????? ?????? ???????????? ???????????? ?????? ????????? ?????? ??????
                convertView = inflater.inflate(R.layout.book_item, null);
            }

            ImageView coverImage = convertView.findViewById(R.id.book_cover);
            TextView  bookName = convertView.findViewById(R.id.book_name);
            TextView  authorName = convertView.findViewById(R.id.book_author);

            // converView??? ??? ????????? ???????????? ??????
            coverImage.setImageResource(bookCovers[position]);  // ?????? ?????? ????????? ??????
            bookName.setText(getResources().getString(bookTitles[position]));   // ?????? ?????? ??????
            authorName.setText(getResources().getString(authors[position])); // ?????? ??????

            return convertView;
        }
    }
}

