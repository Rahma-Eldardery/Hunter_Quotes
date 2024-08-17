package com.example.hunter.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.hunter.MainActivity;
import com.example.hunter.R;
import com.example.hunter.databinding.FragmentLoginOrRegisterBinding;
import com.example.hunter.model.User;
import com.example.hunter.ui.home.Characters;

import java.util.Objects;

public class LoginActivity extends Fragment implements AdapterView.OnItemSelectedListener {

    private FragmentLoginOrRegisterBinding binding;

    private EditText firstName, lastName, email, phone, password, registerEmail, registerPassword;
    private TextView signIn , register, start;
    private boolean isSigningIn = false;
    Spinner spinner ;
    private final String[] countryNames = {"Select Country","Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bangladesh", "Belgium", "Bolivia", "Brunei", "Bulgaria", "Cambodia", "Canada", "Chile", "China", "Colombia", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Dominican Republic", "Ecuador", "Egypt", "El Salvador", "Estonia", "Finland", "France", "Georgia", "Germany", "Greece", "Greenland", "Guatemala", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Malaysia", "Malta", "Mexico", "Moldova", "Monaco", "Mongolia", "Morocco", "Myanmar", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Nigeria", "North Korea", "Norway", "Oman", "Pakistan", "Palestine", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russia", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "San Marino", "Saudi Arabia", "Senegal", "Serbia", "Singapore", "Slovakia", "Slovenia", "South Africa", "South Korea", "Spain", "Sri Lanka", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Thailand", "Timor-Leste", "Turkey", "Turkmenistan", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe"};
    private String country;

    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLoginOrRegisterBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        firstName = root.findViewById(R.id.firstName);
        lastName = root.findViewById(R.id.lastName);
        email = root.findViewById(R.id.email);
        phone = root.findViewById(R.id.phone);
        password = root.findViewById(R.id.password);
        registerEmail = root.findViewById(R.id.registerEmail);
        registerPassword = root.findViewById(R.id.registerPassword);

        spinner = root.findViewById(R.id.spinnerCountry);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter adapterCountrySpinner = new ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, countryNames);
        adapterCountrySpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterCountrySpinner);

        signIn = root.findViewById(R.id.textSignIn);
        register = root.findViewById(R.id.textRegister);
        start = root.findViewById(R.id.sign);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSignInClick();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRegisterClick();
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
            }
        });
        return root;
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        country = countryNames[i];
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void onSignInClick() {
        isSigningIn = true;
        firstName.setVisibility(View.GONE);
        lastName.setVisibility(View.GONE);
        email.setVisibility(View.VISIBLE);
        phone.setVisibility(View.GONE);
        password.setVisibility(View.VISIBLE);
        spinner.setVisibility(View.GONE);
    }

    private void onRegisterClick() {
        isSigningIn = false;
        firstName.setVisibility(View.VISIBLE);
        lastName.setVisibility(View.VISIBLE);
        email.setVisibility(View.GONE);
        phone.setVisibility(View.VISIBLE);
        password.setVisibility(View.GONE);
        spinner.setVisibility(View.VISIBLE);
        registerEmail.setVisibility(View.VISIBLE);
        registerPassword.setVisibility(View.VISIBLE);
    }


    public void start() {
        if (isSigningIn) {
            String emailString = email.getText().toString();
            String passwordString = password.getText().toString();
            if (findAccount(emailString, passwordString)) {
                Intent intent2 = new Intent(getContext(), MainActivity.class);
                String firstNameString = firstName.getText().toString();
                String lastNameStirng = lastName.getText().toString();
                intent2.putExtra("isSignedIn", true);
                intent2.putExtra("firstname",firstNameString);
                intent2.putExtra("lastname",lastNameStirng);
                startActivity(intent2);
            } else {
                Toast.makeText(getContext(), "Invalid email or password", Toast.LENGTH_SHORT).show();
            }
        } else {
            if (registerUser()) {
                Intent intent2 = new Intent(getContext(), MainActivity.class);
                String firstNameString = firstName.getText().toString();
                String lastNameStirng = lastName.getText().toString();
                intent2.putExtra("isSignedIn", true);
                intent2.putExtra("firstname",firstNameString);
                intent2.putExtra("lastname",lastNameStirng);
                startActivity(intent2);
            } else {
                Toast.makeText(getContext(), "Please fill all fields correctly", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean findAccount(String email, String password) {
        for (User member : User.membersList) {
            if (member.getEmail().equals(email) && member.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    private boolean registerUser() {
        String firstNameString = firstName.getText().toString();
        String lastNameString = lastName.getText().toString();
        String emailString = registerEmail.getText().toString();
        String phoneString = phone.getText().toString();
        String passwordString = registerPassword.getText().toString();

        if (firstNameString.isEmpty() || lastNameString.isEmpty() || emailString.isEmpty() || phoneString.isEmpty() || passwordString.isEmpty()) {
            return false;
        }

        User newUser = new User(firstNameString, lastNameString, emailString, phoneString, passwordString, country );
        User.membersList.add(newUser);
        return true;
    }
    }