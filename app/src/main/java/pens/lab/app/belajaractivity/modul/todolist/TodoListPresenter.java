package pens.lab.app.belajaractivity.modul.todolist;

import java.util.ArrayList;

import pens.lab.app.belajaractivity.data.model.Task;
import pens.lab.app.belajaractivity.data.source.session.SessionRepository;

/**
 * Created by fahrul on 13/03/19.
 */

public class TodoListPresenter implements TodoListContract.Presenter{
    private final TodoListContract.View view;
    private final SessionRepository sessionRepository;

    public TodoListPresenter(TodoListContract.View view, SessionRepository sessionRepository) {
        this.view = view;
        this.sessionRepository = sessionRepository;
    }
    @Override
    public void start() {}

    @Override
    public ArrayList<Task> getDataSet() {
        Task task = (Task) sessionRepository.getSessionData();
        //get Data from DB
        ArrayList<Task> data = new ArrayList<> ();
        if (task != null)
            data.add(task);
        data.add(new Task("1","Task 1", "Kerjakan task satu"));
        data.add(new Task("2", "Task 2", "Kerjakan task dua"));


        return data;
    }

}
