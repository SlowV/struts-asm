package struts.action;

import com.opensymphony.xwork2.ActionSupport;
import struts.entity.Event;
import struts.service.EventService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class EventAction extends ActionSupport {
    private static final Logger LOGGER = Logger.getLogger(EventAction.class.getSimpleName());
    public Event event = new Event();
    public static final EventService eventService = new EventService();
    public List<Event> eventList;

    public String getForm(){
        return INPUT;
    }

    public String store(){
         if(eventService.save(event)){
             event = new Event();
             eventList = eventService.findAll();
             return SUCCESS;
         }
        return INPUT;
    }
    @Override
    public void validate() {
        if (event == null) {
            return;
        }

        if (event.getDate() == null){
            addFieldError("event.date", "Date is empty!");
        }else if(event.getPlane() == null || event.getPlane().trim().length() == 0){
            addFieldError("event.plane", "Plane is empty!");
        }else if(event.getLocation() == null || event.getPlane().trim().length() == 0){
            addFieldError("event.location", "Location is empty!");
        }else if(event.getTime() == null ){
            addFieldError("event.time", "Time is empty!");
        }else if (event.getInfo() == null || event.getInfo().trim().length() == 0){
            addFieldError("event.info", "Info is empty!");
        }else{

        }
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public EventService getEventService() {
        return eventService;
    }
    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
}
