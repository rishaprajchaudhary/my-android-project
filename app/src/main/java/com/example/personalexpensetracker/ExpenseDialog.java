package com.example.personalexpensetracker;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class ExpenseDialog extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new MaterialAlertDialogBuilder(requireContext())
                .setTitle("Add Expense")
                .setMessage("This is a placeholder for the expense dialog.")
                .setPositiveButton("OK", (dialogInterface, i) -> dismiss())
                .setNegativeButton("Cancel", (dialogInterface, i) -> dismiss())
                .create();
    }
}
