// Generated by view binder compiler. Do not edit!
package com.smhrd.gmore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.smhrd.gmore.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityGameCategoryBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final RecyclerView rvCategoryList1;

  @NonNull
  public final TextView tvCategoryListName1;

  private ActivityGameCategoryBinding(@NonNull ConstraintLayout rootView,
      @NonNull RecyclerView rvCategoryList1, @NonNull TextView tvCategoryListName1) {
    this.rootView = rootView;
    this.rvCategoryList1 = rvCategoryList1;
    this.tvCategoryListName1 = tvCategoryListName1;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityGameCategoryBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityGameCategoryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_game_category, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityGameCategoryBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.rvCategoryList1;
      RecyclerView rvCategoryList1 = ViewBindings.findChildViewById(rootView, id);
      if (rvCategoryList1 == null) {
        break missingId;
      }

      id = R.id.tvCategoryListName1;
      TextView tvCategoryListName1 = ViewBindings.findChildViewById(rootView, id);
      if (tvCategoryListName1 == null) {
        break missingId;
      }

      return new ActivityGameCategoryBinding((ConstraintLayout) rootView, rvCategoryList1,
          tvCategoryListName1);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
