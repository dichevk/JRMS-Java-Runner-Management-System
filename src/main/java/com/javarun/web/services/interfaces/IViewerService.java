package main.java.com.javarun.web.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.javarun.web.dto.EventDto;
import com.javarun.web.dto.ViewerDto;

public interface IViewerService {
    /**
     * Get a list of all Viewers.
     *
     * @return A list of ViewerDto representing all Viewers.
     */
    List<ViewerDto> getAllViewers();
    
    /**
     * Get details of a specific Viewer by its ID.
     *
     * @param ViewerId The ID of the Viewer to retrieve.
     * @return The ViewerDto representing the requested Viewer, or an empty Optional if not found.
     */
    Optional<ViewerDto> getViewerById(Long ViewerId);
    
    /**
     * Create a new Viewer associated with a specific team, history, and events.
     *
     * @param ViewerDto   The ViewerDto representing the new Viewer.
     * @param event      The list of EventDto representing events associated with the Viewer.
     */
    void createViewer(ViewerDto ViewerDto, EventDto event);

    /**
     * Delete a Viewer by its ID.
     *
     * @param ViewerId The ID of the Viewer to delete.
     */
    void deleteViewer(Long ViewerId);

    /**
     * Update the details of an existing Viewer.
     *
     * @param ViewerDto The ViewerDto representing the updated Viewer details.
     */
    void updateViewer(ViewerDto ViewerDto);
}
