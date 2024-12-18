package com.teguh.sqlite_f55123046;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.cardview.widget.CardView;

import com.teguh.sqlite_f55123046.R;

public class AccountFragment extends Fragment {

    // Variabel untuk elemen UI
    private ImageView profileImage;
    private TextView profileName, profileEmail;
    private CardView profileSettingsCard, privacyCard, favoriteNewsCard;

    public AccountFragment() {
        // Constructor kosong
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate layout fragment_account.xml
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        // Inisialisasi elemen UI
        profileImage = view.findViewById(R.id.profile_image);
        profileName = view.findViewById(R.id.profile_name);
        profileEmail = view.findViewById(R.id.profile_email);

        profileSettingsCard = view.findViewById(R.id.kolom_setting);
        privacyCard = view.findViewById(R.id.kolom_Privacy);
        favoriteNewsCard = view.findViewById(R.id.kolom_Privacy);

        // Contoh event handling: klik CardView
        profileSettingsCard.setOnClickListener(v -> {
            // Aksi saat CardView Profile Settings diklik
            navigateToProfileSettings();
        });

        privacyCard.setOnClickListener(v -> {
            // Aksi saat CardView Privacy diklik
            navigateToPrivacySettings();
        });

        favoriteNewsCard.setOnClickListener(v -> {
            // Aksi saat CardView Favorite News diklik
            navigateToFavoriteNews();
        });

        return view;
    }

    private void navigateToProfileSettings() {
        // Intent untuk memulai ProfileActivity
        Intent intent = new Intent(getActivity(), ProfileActivity.class);
        startActivity(intent);
    }

    private void navigateToPrivacySettings() {
        // Contoh aksi: navigasi ke halaman privasi
        System.out.println("Navigating to Privacy Settings");
    }

    private void navigateToFavoriteNews() {
        // Contoh aksi: navigasi ke halaman favorite news
        System.out.println("Navigating to Favorite News");
    }
}
