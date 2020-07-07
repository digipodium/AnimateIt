package digipodium.animateit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.transition.TransitionManager;

public class SecondFragment extends Fragment {
    boolean isVisible = false;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ConstraintLayout transitionWrapper = view.findViewById(R.id.trainsition_wrapper);
        Button btnSecond = view.findViewById(R.id.button_second);
        TextView animatedText = view.findViewById(R.id.animatedText);

        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(transitionWrapper);
                isVisible = !isVisible;
                animatedText.setVisibility(isVisible ? View.VISIBLE : View.GONE);

            }
        });
    }
}