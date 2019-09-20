package com.giovannisaberon.colporteurbooks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookCardViewDataAdapter extends
            RecyclerView.Adapter<BookCardViewDataAdapter.ViewHolder> {

        private List<Book> bkList;

        public BookCardViewDataAdapter(List<Book> books) {
            this.bkList = books;

        }

        // Create new views
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                 int viewType) {
            // create a new view
            View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.cardview_row, null);

            // create ViewHolder

            ViewHolder viewHolder = new ViewHolder(itemLayoutView);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int position) {

            final int pos = position;

            viewHolder.tvName.setText(bkList.get(position).getName());

            viewHolder.tvEmailId.setText(bkList.get(position).getEmailId());

            viewHolder.chkSelected.setChecked(bkList.get(position).isSelected());

            viewHolder.chkSelected.setTag(bkList.get(position));


            viewHolder.chkSelected.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    CheckBox cb = (CheckBox) v;
                    Book contact = (Book) cb.getTag();

                    contact.setSelected(cb.isChecked());
                    bkList.get(pos).setSelected(cb.isChecked());

                    Toast.makeText(
                            v.getContext(),
                            "Clicked on Checkbox: " + cb.getText() + " is "
                                    + cb.isChecked(), Toast.LENGTH_LONG).show();
                }
            });

        }

        // Return the size arraylist
        @Override
        public int getItemCount() {
            return bkList.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {

            public TextView tvName;
            public TextView tvEmailId;

            public CheckBox chkSelected;

            public Book singlebook;

            public ViewHolder(View itemLayoutView) {
                super(itemLayoutView);

                tvName = (TextView) itemLayoutView.findViewById(R.id.tvName);

                tvEmailId = (TextView) itemLayoutView.findViewById(R.id.tvEmailId);
                chkSelected = (CheckBox) itemLayoutView
                        .findViewById(R.id.chkSelected);

            }

        }

        // method to access in activity after updating selection
        public List<Book> getBookList() {
            return bkList;
        }

    }
