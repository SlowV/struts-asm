package struts.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import struts.entity.Event;
import struts.service.EventService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class EventEditAndDeleteAction extends ActionSupport {
    private Event event = new Event();
    private List<Event> eventList = new ArrayList<>();
    private String idEventEdit;
    private String idEventDelete;
    private EventService eventService = new EventService();
    public String edit(){
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        event = eventService.findOne(request.getParameter("idEventEdit"));
        System.out.println(event.toString());
        return INPUT;
    }

    public String store(){
        if (event != null){
            if(EventAction.eventService.save(event)) {
                eventList = new ArrayList<>();
                eventList = EventAction.eventService.findAll();
                return SUCCESS;
            }
        }
        return INPUT;
    }

    public String deleteEvent(){
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
        eventService.deleteById(request.getParameter("idEventDelete"));
        eventList = new ArrayList<>();
        eventList = eventService.findAll();
        return SUCCESS;
    }


    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }


    public EventService getEventService() {
        return eventService;
    }

    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    public String getIdEventEdit() {
        return idEventEdit;
    }

    public void setIdEventEdit(String idEventEdit) {
        this.idEventEdit = idEventEdit;
    }

    public String getIdEventDelete() {
        return idEventDelete;
    }

    public void setIdEventDelete(String idEventDelete) {
        this.idEventDelete = idEventDelete;
    }
}
