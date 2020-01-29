package edu.cascadia.mobile.apps.wordlist;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class WordRepository {

    private WordDAO mWordDao;
    private LiveData<List<Word>> mAllWords;
    WordRepository(Application app){
        WordRoomDatabase db = WordRoomDatabase.getDatabase(app);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAlphabetizedWords();
    }
    LiveData<List<Word>> getAllWords(){
        return mAllWords;
    }
    void insert(Word word){
        WordRoomDatabase.databaseWriteExecutor.execute(() -> {
            mWordDao.insert(word);
        });
    }
}
