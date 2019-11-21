package com.leoneves.maktaba.spinnersearch;

import java.util.List;

public interface SpinnerSearchListener {
    List<Object> getObjetcs(String word);
    List<String> getNames(String word);
}
