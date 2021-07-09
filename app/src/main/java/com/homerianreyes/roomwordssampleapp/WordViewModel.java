package com.homerianreyes.roomwordssampleapp;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

//implementing WordViewModel - Create a class called WordViewModel that extends AndroidViewModel.
public class WordViewModel extends AndroidViewModel {

    //Add a private member variable to hold a reference to the Repository.
    private WordRepository mRepository;
    //Add a private LiveData member variable to cache the list of words.
    private LiveData<List<Word>> mAllWords;

    //Add a constructor that gets a reference to the WordRepository and gets the list of all words from the WordRepository.
    public WordViewModel(Application application) {
        super(application);

        mRepository = new WordRepository(application);
        mAllWords = mRepository.getmAllWords();
    }
    //Add a "getter" method that gets all the words. This completely hides the implementation from the UI.
    LiveData<List<Word>> getmAllWords() {
        return mAllWords;
    }
    //Create a wrapper insert() method that calls the Repository's insert() method. In this way, the implementation of insert() is completely hidden from the UI.
    public void insert(Word word) {
        mRepository.insert(word);
    }
}
