package pens.lab.app.belajaractivity.modul.newtask;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import pens.lab.app.belajaractivity.R;
import pens.lab.app.belajaractivity.base.BaseFragment;
import pens.lab.app.belajaractivity.modul.todolist.TodoListActivity;


/**
 * Created by fahrul on 13/03/19.
 */

public class NewTaskFragment extends BaseFragment<NewTaskActivity, NewTaskContract.Presenter> implements NewTaskContract.View {

    EditText ptTaskTitle;
    EditText ptTaskDescription;
    Button btSave;

    public NewTaskFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_task2, container, false);
        mPresenter = new NewTaskPresenter(this);
        mPresenter.start();

        ptTaskTitle = fragmentView.findViewById(R.id.ptTaskTitle);
        ptTaskDescription = fragmentView.findViewById(R.id.ptTaskDescription);
        btSave = fragmentView.findViewById(R.id.btSave);
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBtSaveClick();
            }
        });

        setTitle("Add New Task");

        return fragmentView;
    }

    public void setBtSaveClick(){
        String title = ptTaskTitle.getText().toString();
        String description = ptTaskDescription.getText().toString();
        mPresenter.saveData(title,description);
    }

    @Override
    public void setPresenter(NewTaskContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void redirectToTaskList() {
            Intent intent = new Intent(activity, TodoListActivity.class);
            startActivity(intent);
            activity.finish();
    }


}
