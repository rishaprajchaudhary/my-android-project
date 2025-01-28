package com.example.personalexpensetracker;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ExpenseAdapter adapter;
    private List<Expense> expenseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        expenseList = new ArrayList<>();
        adapter = new ExpenseAdapter(expenseList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Floating button click to show dialog
        findViewById(R.id.fab).setOnClickListener(view -> showAddExpenseDialog());
    }

    private void showAddExpenseDialog() {
        // Create and display the dialog
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_add_expense);

        EditText editTextDescription = dialog.findViewById(R.id.editTextDescription);
        EditText editTextAmount = dialog.findViewById(R.id.editTextAmount);
        Button buttonAddExpense = dialog.findViewById(R.id.buttonAddExpense);

        buttonAddExpense.setOnClickListener(v -> {
            String description = editTextDescription.getText().toString().trim();
            String amountText = editTextAmount.getText().toString().trim();

            if (TextUtils.isEmpty(description) || TextUtils.isEmpty(amountText)) {
                Toast.makeText(MainActivity.this, "Please enter both description and amount", Toast.LENGTH_SHORT).show();
                return;
            }

            double amount = Double.parseDouble(amountText);
            expenseList.add(new Expense(description, amount));
            adapter.notifyDataSetChanged();

            dialog.dismiss();
        });

        dialog.show();
    }
}
