package com.bluehouse.bluehouse;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<Plant> selectedPlant = new MutableLiveData<>();

    public LiveData<Plant> getSelectedPlant() {
        return selectedPlant;
    }

    public void setSelectedPlant(Plant plant) {
        selectedPlant.setValue(plant);
    }
}