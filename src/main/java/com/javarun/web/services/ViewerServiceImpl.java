package main.java.com.javarun.web.services;
import java.util.List;
import java.util.Optional;

import com.javarun.web.dto.EventDto;
import com.javarun.web.repository.EventRepository;
import com.javarun.web.repository.ViewerRepository;

import main.java.com.javarun.web.services.interfaces.IViewerService;
import main.java.com.javarun.web.services.interfaces.ViewerDto;

public class ViewerServiceImpl implements IViewerService {

    private final EventRepository eventRepository;
    private final ViewerRepository viewerRepository;

    /**
     * Constructor to inject the EventRepository and TeamRepository dependencies.
     *
     * @param eventRepository The EventRepository instance to be injected.
     * @param viewerRepository  The TeamRepository instance to be injected.
     */
    @Autowired
    public EventService(EventRepository eventRepository, ViewerRepository viewerRepository) {
        this.eventRepository = eventRepository;
        this.viewerRepository = viewerRepository;
    }
    @Override
    public void createViewer(ViewerDto ViewerDto, EventDto event) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteViewer(Long ViewerId) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<ViewerDto> getAllViewers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<ViewerDto> getViewerById(Long ViewerId) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public void updateViewer(ViewerDto ViewerDto) {
        // TODO Auto-generated method stub
        
    }
    
}
