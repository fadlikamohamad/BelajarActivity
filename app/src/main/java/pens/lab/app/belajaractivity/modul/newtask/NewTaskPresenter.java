package pens.lab.app.belajaractivity.modul.newtask;

import pens.lab.app.belajaractivity.data.model.Task;
import pens.lab.app.belajaractivity.data.source.session.SessionRepository;

/**
 * Created by fahrul on 13/03/19.
 */

public class NewTaskPresenter implements NewTaskContract.Presenter{
    private final NewTaskContract.View view;
    private final SessionRepository sessionRepository;

    public NewTaskPresenter(NewTaskContract.View view, SessionRepository sessionRepository) {
        this.view = view;
        this.sessionRepository = sessionRepository;
    }

    @Override
    public void start() {}

    @Override
    public void saveData(final String title, final String description){
        Task newTask = new Task("3", title, description);
        sessionRepository.setSessionData(newTask);
        //save new task
        //then go back to task list
        view.redirectToTaskList();
    }

}
