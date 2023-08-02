// Generated by view binder compiler. Do not edit!
package com.smhrd.gmore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.smhrd.gmore.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityBoardDetailBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView boardBookmark;

  @NonNull
  public final ImageView boardLike;

  @NonNull
  public final EditText editTextText;

  @NonNull
  public final Guideline guideline2;

  @NonNull
  public final Guideline guideline3;

  @NonNull
  public final Guideline guidelineEnd;

  @NonNull
  public final Guideline guidelineHorizontalBottom;

  @NonNull
  public final Guideline guidelineHorizontalTop;

  @NonNull
  public final Guideline guidelineStart;

  @NonNull
  public final ImageView ivBoardImage;

  @NonNull
  public final ImageView ivInputAdd;

  @NonNull
  public final RecyclerView rvComments;

  @NonNull
  public final ScrollView svBoardContent;

  @NonNull
  public final TextView tvBoardContent;

  @NonNull
  public final TextView tvBoardDate;

  @NonNull
  public final TextView tvBoardTitle;

  @NonNull
  public final TextView tvBoardWriter;

  private ActivityBoardDetailBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView boardBookmark, @NonNull ImageView boardLike,
      @NonNull EditText editTextText, @NonNull Guideline guideline2, @NonNull Guideline guideline3,
      @NonNull Guideline guidelineEnd, @NonNull Guideline guidelineHorizontalBottom,
      @NonNull Guideline guidelineHorizontalTop, @NonNull Guideline guidelineStart,
      @NonNull ImageView ivBoardImage, @NonNull ImageView ivInputAdd,
      @NonNull RecyclerView rvComments, @NonNull ScrollView svBoardContent,
      @NonNull TextView tvBoardContent, @NonNull TextView tvBoardDate,
      @NonNull TextView tvBoardTitle, @NonNull TextView tvBoardWriter) {
    this.rootView = rootView;
    this.boardBookmark = boardBookmark;
    this.boardLike = boardLike;
    this.editTextText = editTextText;
    this.guideline2 = guideline2;
    this.guideline3 = guideline3;
    this.guidelineEnd = guidelineEnd;
    this.guidelineHorizontalBottom = guidelineHorizontalBottom;
    this.guidelineHorizontalTop = guidelineHorizontalTop;
    this.guidelineStart = guidelineStart;
    this.ivBoardImage = ivBoardImage;
    this.ivInputAdd = ivInputAdd;
    this.rvComments = rvComments;
    this.svBoardContent = svBoardContent;
    this.tvBoardContent = tvBoardContent;
    this.tvBoardDate = tvBoardDate;
    this.tvBoardTitle = tvBoardTitle;
    this.tvBoardWriter = tvBoardWriter;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityBoardDetailBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityBoardDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_board_detail, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityBoardDetailBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.boardBookmark;
      ImageView boardBookmark = ViewBindings.findChildViewById(rootView, id);
      if (boardBookmark == null) {
        break missingId;
      }

      id = R.id.boardLike;
      ImageView boardLike = ViewBindings.findChildViewById(rootView, id);
      if (boardLike == null) {
        break missingId;
      }

      id = R.id.editTextText;
      EditText editTextText = ViewBindings.findChildViewById(rootView, id);
      if (editTextText == null) {
        break missingId;
      }

      id = R.id.guideline2;
      Guideline guideline2 = ViewBindings.findChildViewById(rootView, id);
      if (guideline2 == null) {
        break missingId;
      }

      id = R.id.guideline3;
      Guideline guideline3 = ViewBindings.findChildViewById(rootView, id);
      if (guideline3 == null) {
        break missingId;
      }

      id = R.id.guidelineEnd;
      Guideline guidelineEnd = ViewBindings.findChildViewById(rootView, id);
      if (guidelineEnd == null) {
        break missingId;
      }

      id = R.id.guidelineHorizontalBottom;
      Guideline guidelineHorizontalBottom = ViewBindings.findChildViewById(rootView, id);
      if (guidelineHorizontalBottom == null) {
        break missingId;
      }

      id = R.id.guidelineHorizontalTop;
      Guideline guidelineHorizontalTop = ViewBindings.findChildViewById(rootView, id);
      if (guidelineHorizontalTop == null) {
        break missingId;
      }

      id = R.id.guidelineStart;
      Guideline guidelineStart = ViewBindings.findChildViewById(rootView, id);
      if (guidelineStart == null) {
        break missingId;
      }

      id = R.id.ivBoardImage;
      ImageView ivBoardImage = ViewBindings.findChildViewById(rootView, id);
      if (ivBoardImage == null) {
        break missingId;
      }

      id = R.id.ivInputAdd;
      ImageView ivInputAdd = ViewBindings.findChildViewById(rootView, id);
      if (ivInputAdd == null) {
        break missingId;
      }

      id = R.id.rvComments;
      RecyclerView rvComments = ViewBindings.findChildViewById(rootView, id);
      if (rvComments == null) {
        break missingId;
      }

      id = R.id.svBoardContent;
      ScrollView svBoardContent = ViewBindings.findChildViewById(rootView, id);
      if (svBoardContent == null) {
        break missingId;
      }

      id = R.id.tvBoardContent;
      TextView tvBoardContent = ViewBindings.findChildViewById(rootView, id);
      if (tvBoardContent == null) {
        break missingId;
      }

      id = R.id.tvBoardDate;
      TextView tvBoardDate = ViewBindings.findChildViewById(rootView, id);
      if (tvBoardDate == null) {
        break missingId;
      }

      id = R.id.tvBoardTitle;
      TextView tvBoardTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvBoardTitle == null) {
        break missingId;
      }

      id = R.id.tvBoardWriter;
      TextView tvBoardWriter = ViewBindings.findChildViewById(rootView, id);
      if (tvBoardWriter == null) {
        break missingId;
      }

      return new ActivityBoardDetailBinding((ConstraintLayout) rootView, boardBookmark, boardLike,
          editTextText, guideline2, guideline3, guidelineEnd, guidelineHorizontalBottom,
          guidelineHorizontalTop, guidelineStart, ivBoardImage, ivInputAdd, rvComments,
          svBoardContent, tvBoardContent, tvBoardDate, tvBoardTitle, tvBoardWriter);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
