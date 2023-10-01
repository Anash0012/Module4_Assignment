package com.geekster.Event_Management.Service;

import com.geekster.Event_Management.Model.Event;
import com.geekster.Event_Management.Repo.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    EventRepo eventRepo;

    public String addEvent(Event event) {
        eventRepo.save(event);
        return "Event added successfully!";
    }

    public String updateEvent(Long id, Event event) {
        Optional<Event> optionalEvent = eventRepo.findById(id);
        if (optionalEvent.isPresent()) {
            Event existingEvent = optionalEvent.get();
            existingEvent.setEventName(event.getEventName());
            existingEvent.setLocationOfEvent(event.getLocationOfEvent());
            existingEvent.setDate(event.getDate());
            existingEvent.setStartTime(event.getStartTime());
            existingEvent.setEndTime(event.getEndTime());
            eventRepo.save(existingEvent);
            return "Event updated successfully!";
        } else {
            return "Event not found!";
        }
    }

    public String deleteEvent(Long id) {
        if (eventRepo.existsById(id)) {
            eventRepo.deleteById(id);
            return "Event deleted successfully!";
        } else {
            return "Event not found!";
        }
    }


}