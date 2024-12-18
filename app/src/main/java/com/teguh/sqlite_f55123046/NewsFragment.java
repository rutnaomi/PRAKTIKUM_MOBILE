package com.teguh.sqlite_f55123046;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

public class NewsFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate layout fragment_news
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        // Menghubungkan DrawerLayout dengan ID di XML
        drawerLayout = view.findViewById(R.id.drawer_layout);

        // Menghubungkan NavigationView dengan ID di XML
        NavigationView navigationView = view.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Mengatur Toolbar
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

            // Mengatur ActionBarDrawerToggle untuk DrawerLayout
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    getActivity(), drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
            drawerLayout.addDrawerListener(toggle);
            toggle.syncState();
        }

        // Menampilkan fragment default saat pertama kali dibuka
        if (savedInstanceState == null) {
            getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new UtamaFragment())
                    .commit();
            navigationView.setCheckedItem(R.id.nav_utama);
        }

        return view;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        Fragment selectedFragment = null;

        if (id == R.id.nav_utama) {
            selectedFragment = new UtamaFragment();
        } else if (id == R.id.nav_olahraga) {
            selectedFragment = new OlahragaFragment();
        } else if (id == R.id.nav_politik) {
            selectedFragment = new PolitikFragment();
        } else if (id == R.id.nav_kesehatan) {
            selectedFragment = new KesehatanFragment();
        } else if (id == R.id.nav_teknologi) {
            selectedFragment = new TeknologiFragment();
        } else if (id == R.id.nav_bisnis) {
            selectedFragment = new BisnisFragment();
        } else if (id == R.id.nav_logout) {
            Toast.makeText(getContext(), "Logout!", Toast.LENGTH_SHORT).show();
        }

        if (selectedFragment != null) {
            getChildFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, selectedFragment)
                    .commit();
        }

        // Menutup Navigation Drawer setelah memilih item
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (drawerLayout != null) {
            drawerLayout.removeDrawerListener(null);
        }
    }
}
