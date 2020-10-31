package pens.lab.app.belajaractivity.modul.edittask;

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
import pens.lab.app.belajaractivity.data.model.Task;
import pens.lab.app.belajaractivity.modul.todolist.TodoListActivity;


/**
 * Created by fahrul on 13/03/19.
 */

public class EditTaskFragment extends BaseFragment<EditTaskActivity, EditTaskContract.Presenter> implements EditTaskContract.View {

    String id;
    EditText ptTaskTitle;
    EditText ptTaskDescription;
    Button btSave;

    public EditTaskFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_task2, container, false);
        mPresenter = new EditTaskPresenter(this);
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

        setTitle("Edit Task");
        mPresenter.loadData(this.id);

        return fragmentView;
    }

    public void setBtSaveClick(){
        String title = ptTaskTitle.getText().toString();
        String description = ptTaskDescription.getText().toString();
        mPresenter.saveData(title,description);
    }

    @Override
    public void setPresenter(EditTaskContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void redirectToTaskList() {
            Intent intent = new Intent(activity, TodoListActivity.class);
            startActivity(intent);
            activity.finish();
    }

    @Override
    public void showData(Task task) {
        this.ptTaskTitle.setText(task.getTitle());
        this.ptTaskDescription.setText(task.getDescription());
    }

    @Override
    public void setId(String id) {
        this.id=id;
    }

}
