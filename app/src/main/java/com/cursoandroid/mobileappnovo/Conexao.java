package com.cursoandroid.mobileappnovo;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class Conexao {

    private static FirebaseAuth firebaseAuth;
    private static FirebaseAuth.AuthStateListener authStateListener;
    private static FirebaseUser firebaseUser;

    private Conexao(){

    }

    public static FirebaseAuth getFirebaseAuth(){
        if (firebaseAuth == null){
            inicializarFirebaseAuth();
        }

        return firebaseAuth;
    }

    private static void inicializarFirebaseAuth() {
        firebaseAuth = FirebaseAuth.getInstance();

        authStateListener = firebaseAuth -> {
            FirebaseUser user = firebaseAuth.getCurrentUser();

            if (Objects.nonNull(user)){
                firebaseUser = user;
            }
        };
        firebaseAuth.addAuthStateListener(authStateListener);
    }

    public static  FirebaseUser getFirebaseUser(){
        return firebaseUser;
    }

    public static void logout(){
        firebaseAuth.signOut();
    }
}
