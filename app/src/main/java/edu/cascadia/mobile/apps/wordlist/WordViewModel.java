package edu.cascadia.mobile.apps.wordlist;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {
    private WordRepository mRepo;
    private LiveData<List<Word>> mAllWords;
    public WordViewModel (Application app){
        super(app);
        mRepo = new WordRepository(app);
        mAllWords = mRepo.getAllWords();
    }

    LiveData<List<Word>> getAllWords(){return mAllWords;}

    public void insert(Word word){
        mRepo.insert(word);
    }
}
