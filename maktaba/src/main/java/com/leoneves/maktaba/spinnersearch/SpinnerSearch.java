package com.leoneves.maktaba.spinnersearch;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.leoneves.maktaba.R;
import com.leoneves.maktaba.edittext.EditText;

public class SpinnerSearch extends RelativeLayout implements SpinnerSearchListener{
    private Spinner spinner;
    private EditText editText;
    private View viewSelecionar;
    private ProgressBar progressBar;
    private TypedArray typedArray;

    private boolean jaInicializado;
    private ProgressoRun run;
    private SpinnerSearchAdapter adapter;
    private SpinnerSearchListener spinnerSearchListener;
    private AdapterView.OnItemSelectedListener onItemSelectedListener;

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.onItemSelectedListener = onItemSelectedListener;
    }

    private List<Object> tags;
    private List<String> names;

    private String noOneFound;
    private String selectOne;

    public SpinnerSearch(Context context) {
        super(context);
        init(context, null);
    }

    public SpinnerSearch(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public SpinnerSearch(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        View view = LayoutInflater.from(context).inflate(R.layout.spinnersearch_layout, this, true);
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.SpinnerSearch);
        spinner = view.findViewById(R.id.spinnerSpinnerSearch);
        editText = view.findViewById(R.id.editTextSpinnerSearch);
        viewSelecionar = view.findViewById(R.id.viewSelecionarSpinnerSearch);
        progressBar = view.findViewById(R.id.progressSpinnerSearch);
        noOneFound = typedArray.getString(R.styleable.SpinnerSearch_ss_noOneFound);
        selectOne = typedArray.getString(R.styleable.SpinnerSearch_ss_selectOne);
        if (selectOne==null)
            selectOne = context.getString(R.string.spinnersearch_selectone);
        if (noOneFound==null)
            noOneFound = context.getString(R.string.spinnersearch_noonefound);
        String hint = (typedArray.getString(R.styleable.SpinnerSearch_ss_hint));
        String floatingText = typedArray.getString(R.styleable.SpinnerSearch_ss_floatingLabelText);
        editText.setHint(hint);
        editText.setFloatingLabelText(floatingText);
        tags = new ArrayList<>();
        names = new ArrayList<>();
        editText.setOnTextChangeListener(onTextChangeListener);
        final AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (jaInicializado) {
                    jaInicializado = false;
                    editText.setOnTextChangeListener(null);
                    editText.setText(adapter.getItem(position).toString());
                    editText.setSelection(editText.getText().length());
                    editText.setOnTextChangeListener(onTextChangeListener);
                    if (SpinnerSearch.this.onItemSelectedListener!=null)
                        SpinnerSearch.this.onItemSelectedListener.onItemSelected(parent,view,position,id);
                }
                jaInicializado = true;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        spinner.setOnItemSelectedListener(onItemSelectedListener);
        adapter = new SpinnerSearchAdapter(context, "", this, noOneFound, selectOne);
        spinner.setAdapter(adapter);
        configureNomes();
        viewSelecionar.setOnClickListener(abrirSpinnerListener);
    }

    private void configureNomes() {
        if (typedArray.getString(R.styleable.SpinnerSearch_ss_names) != null) {
            names = Arrays.asList(typedArray.getString(R.styleable.SpinnerSearch_ss_names).split("\\s*;\\s*"));
        } else {
            names = new ArrayList<>();
        }
    }

    public void setPosition(int position){
        spinner.setSelection(position+1);
    }

    private EditText.OnTextChangeListener onTextChangeListener = new EditText.OnTextChangeListener() {
        @Override
        public void onTextChange(String palavra) {
            if (run != null && !run.isCancelled())
                run.cancel(true);
            progressBar.setVisibility(View.VISIBLE);
            run = new ProgressoRun(palavra);
            run.execute();
            jaInicializado = false;
        }
    };



    private View.OnClickListener abrirSpinnerListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            spinner.performClick();
        }
    };

    @Override
    public List<Object> getObjetcs(String word) {
        tags = spinnerSearchListener!=null?spinnerSearchListener.getObjetcs(word):tags;
        return tags;
    }

    @Override
    public List<String> getNames(String word) {
        names = spinnerSearchListener!=null?spinnerSearchListener.getNames(word):names;
        return names;
    }

    public void setNames(List<String> names){
        this.names = names;
        adapter = new SpinnerSearchAdapter(getContext(),null, SpinnerSearch.this, noOneFound, selectOne);
        spinner.setAdapter(adapter);
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public void setSpinnerSearchListener(SpinnerSearchListener spinnerSearchListener) {
        this.spinnerSearchListener = spinnerSearchListener;
    }

    public Object getSelectedItemTag() {
        try {
            return tags.get(spinner.getSelectedItemPosition()-1);
        } catch (Exception e) {
            return null;
        }
    }

    public int getSelectedItemPosition(){
        return spinner.getSelectedItemPosition()-1;
    }

    public String getSelectedItemName() {
        try {
            Log.i("SpinnerSearch","Name selected: "+names.get(spinner.getSelectedItemPosition()));
            return names.get(spinner.getSelectedItemPosition()-1);
        } catch (Exception e) {
            return null;
        }
    }

    public void setError() {
        editText.setError();
    }

    public void setSelected(Object tag){

        if (tag!=null && tags.contains(tag)){
            int position = tags.indexOf(tag);
            spinner.setSelection(position+1);
        }
        else{
            spinner.setSelection(0);
        }
    }

    private class ProgressoRun extends AsyncTask<Void, Void, Void> {
        boolean ativo;
        String palavra;

        public ProgressoRun(String palavra) {
            this.palavra = palavra;
        }

        @Override
        protected void onCancelled(Void aVoid) {
            super.onCancelled(aVoid);
            ativo = false;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPreExecute() {
            ativo = true;
        }

        @Override
        protected Void doInBackground(Void... params) {
            SystemClock.sleep(1000);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            if (ativo) {
                adapter = new SpinnerSearchAdapter(getContext(),palavra, SpinnerSearch.this, noOneFound, selectOne);
                progressBar.setVisibility(View.GONE);
                spinner.setAdapter(adapter);
                spinner.performClick();/**/
                editText.requestFocus();
                progressBar.setVisibility(View.GONE);
            }
        }
    }
}
