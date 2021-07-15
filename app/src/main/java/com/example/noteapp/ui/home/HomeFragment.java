package com.example.noteapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.noteapp.R;
import com.example.noteapp.TaskModel;
import com.example.noteapp.adapter.TaskAdapter;
import com.example.noteapp.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private TaskModel model;
    private TaskAdapter adapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        intRecycler();
        getData();
        return binding.getRoot();
    }

    private void intRecycler() {
        adapter = new TaskAdapter();
        binding.recycleView.setAdapter(adapter);
        binding.recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.addModel(new TaskModel("Детектив","преступление — расследование — изобличение преступника."));
        adapter.addModel(new TaskModel("Любовный роман","герои встречаются — влюбляются — сражаются за любовь — соединяют сердца."));
        adapter.addModel(new TaskModel("Триллер","герой жил своей обычной жизнью — возникает угроза — герой пытается спастись — герой избавляется от опасности."));
        adapter.addModel(new TaskModel("Приключения","герой ставит перед собой цель и, преодолев множество препятствий, добивается желаемого."));
    }
    private void getData() {
        getParentFragmentManager().setFragmentResultListener("title", getViewLifecycleOwner(), ((requestKey, result) -> {
            TaskModel model = (TaskModel) result.getSerializable("not");
            adapter.addModel(model);
        }));
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }


}