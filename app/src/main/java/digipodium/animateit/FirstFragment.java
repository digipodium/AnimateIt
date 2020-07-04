package digipodium.animateit;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textFirst = view.findViewById(R.id.textview_first);
        Button btnFirst = view.findViewById(R.id.button_first);
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textFirst.animate()
                        .scaleX(3.0f)
                        .scaleY(3.0f)
                        .rotationY(360f)
                        .setDuration(500)
                        .setInterpolator(new BounceInterpolator())
                        .start();
            }
        });

        Button btnAnim = view.findViewById(R.id.btnAnim);
        btnAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ObjectAnimator animator = ObjectAnimator.ofArgb(view, "backgroundColor", Color.BLUE, Color.GREEN);
                animator.setDuration(2500);
                animator.setInterpolator(new AccelerateDecelerateInterpolator());
                animator.start();
            }
        });

        btnAnim.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ObjectAnimator changeColor = ObjectAnimator.ofArgb(view, "backgroundColor", Color.BLUE, Color.GREEN);
                ObjectAnimator changeX = ObjectAnimator.ofFloat(view, "x", 0, 600);
                ObjectAnimator changeRadius = ObjectAnimator.ofFloat(view, "translationY", 0, 150);
                changeColor.setDuration(2500);
                changeX.setDuration(500);
                changeRadius.setDuration(500);

                AnimatorSet set = new AnimatorSet();
                set.playSequentially(changeX, changeRadius, changeColor);
                set.start();
                return true;
            }
        });
        btnFirst.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(getActivity(),R.animator.scale_move);
                set.setTarget(btnAnim);
                set.start();
                return true;
            }
        });
    }
}