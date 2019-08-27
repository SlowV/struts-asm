package struts.action;

import com.opensymphony.xwork2.ActionSupport;
import struts.entity.Event;

import java.util.ArrayList;
import java.util.List;

public class EventList extends ActionSupport {
    private List<Event> eventList;
    public String getList(){
        eventList = new ArrayList<>();
        eventList= EventAction.eventService.findAll();
        return SUCCESS;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
}
