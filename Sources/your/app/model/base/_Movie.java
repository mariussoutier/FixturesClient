// DO NOT EDIT.  Make changes to your.app.model.Movie.java instead.
package your.app.model.base;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;

import er.extensions.eof.*;
import er.extensions.foundation.*;

@SuppressWarnings("all")
public abstract class _Movie extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Movie";

  // Attribute Keys
  public static final ERXKey<String> DESCRIPTION = new ERXKey<String>("description");
  public static final ERXKey<String> TITLE = new ERXKey<String>("title");
  public static final ERXKey<Integer> YEAR = new ERXKey<Integer>("year");
  // Relationship Keys
  public static final ERXKey<your.app.model.MovieRole> TALENTS = new ERXKey<your.app.model.MovieRole>("talents");

  // Attributes
  public static final String DESCRIPTION_KEY = DESCRIPTION.key();
  public static final String TITLE_KEY = TITLE.key();
  public static final String YEAR_KEY = YEAR.key();
  // Relationships
  public static final String TALENTS_KEY = TALENTS.key();

  private static Logger LOG = Logger.getLogger(_Movie.class);

  public your.app.model.Movie localInstanceIn(EOEditingContext editingContext) {
    your.app.model.Movie localInstance = (your.app.model.Movie)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String description() {
    return (String) storedValueForKey(_Movie.DESCRIPTION_KEY);
  }

  public void setDescription(String value) {
    if (_Movie.LOG.isDebugEnabled()) {
    	_Movie.LOG.debug( "updating description from " + description() + " to " + value);
    }
    takeStoredValueForKey(value, _Movie.DESCRIPTION_KEY);
  }

  public String title() {
    return (String) storedValueForKey(_Movie.TITLE_KEY);
  }

  public void setTitle(String value) {
    if (_Movie.LOG.isDebugEnabled()) {
    	_Movie.LOG.debug( "updating title from " + title() + " to " + value);
    }
    takeStoredValueForKey(value, _Movie.TITLE_KEY);
  }

  public Integer year() {
    return (Integer) storedValueForKey(_Movie.YEAR_KEY);
  }

  public void setYear(Integer value) {
    if (_Movie.LOG.isDebugEnabled()) {
    	_Movie.LOG.debug( "updating year from " + year() + " to " + value);
    }
    takeStoredValueForKey(value, _Movie.YEAR_KEY);
  }

  public NSArray<your.app.model.MovieRole> talents() {
    return (NSArray<your.app.model.MovieRole>)storedValueForKey(_Movie.TALENTS_KEY);
  }

  public NSArray<your.app.model.MovieRole> talents(EOQualifier qualifier) {
    return talents(qualifier, null, false);
  }

  public NSArray<your.app.model.MovieRole> talents(EOQualifier qualifier, boolean fetch) {
    return talents(qualifier, null, fetch);
  }

  public NSArray<your.app.model.MovieRole> talents(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<your.app.model.MovieRole> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(your.app.model.MovieRole.MOVIE_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
      if (qualifier == null) {
        fullQualifier = inverseQualifier;
      }
      else {
        NSMutableArray<EOQualifier> qualifiers = new NSMutableArray<EOQualifier>();
        qualifiers.addObject(qualifier);
        qualifiers.addObject(inverseQualifier);
        fullQualifier = new EOAndQualifier(qualifiers);
      }

      results = your.app.model.MovieRole.fetchMovieRoles(editingContext(), fullQualifier, sortOrderings);
    }
    else {
      results = talents();
      if (qualifier != null) {
        results = (NSArray<your.app.model.MovieRole>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<your.app.model.MovieRole>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToTalents(your.app.model.MovieRole object) {
    includeObjectIntoPropertyWithKey(object, _Movie.TALENTS_KEY);
  }

  public void removeFromTalents(your.app.model.MovieRole object) {
    excludeObjectFromPropertyWithKey(object, _Movie.TALENTS_KEY);
  }

  public void addToTalentsRelationship(your.app.model.MovieRole object) {
    if (_Movie.LOG.isDebugEnabled()) {
      _Movie.LOG.debug("adding " + object + " to talents relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToTalents(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _Movie.TALENTS_KEY);
    }
  }

  public void removeFromTalentsRelationship(your.app.model.MovieRole object) {
    if (_Movie.LOG.isDebugEnabled()) {
      _Movie.LOG.debug("removing " + object + " from talents relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromTalents(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _Movie.TALENTS_KEY);
    }
  }

  public your.app.model.MovieRole createTalentsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( your.app.model.MovieRole.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _Movie.TALENTS_KEY);
    return (your.app.model.MovieRole) eo;
  }

  public void deleteTalentsRelationship(your.app.model.MovieRole object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Movie.TALENTS_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllTalentsRelationships() {
    Enumeration<your.app.model.MovieRole> objects = talents().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteTalentsRelationship(objects.nextElement());
    }
  }


  public static your.app.model.Movie createMovie(EOEditingContext editingContext) {
    your.app.model.Movie eo = (your.app.model.Movie) EOUtilities.createAndInsertInstance(editingContext, _Movie.ENTITY_NAME);    
    return eo;
  }

  public static ERXFetchSpecification<your.app.model.Movie> fetchSpec() {
    return new ERXFetchSpecification<your.app.model.Movie>(_Movie.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<your.app.model.Movie> fetchAllMovies(EOEditingContext editingContext) {
    return _Movie.fetchAllMovies(editingContext, null);
  }

  public static NSArray<your.app.model.Movie> fetchAllMovies(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Movie.fetchMovies(editingContext, null, sortOrderings);
  }

  public static NSArray<your.app.model.Movie> fetchMovies(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<your.app.model.Movie> fetchSpec = new ERXFetchSpecification<your.app.model.Movie>(_Movie.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<your.app.model.Movie> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static your.app.model.Movie fetchMovie(EOEditingContext editingContext, String keyName, Object value) {
    return _Movie.fetchMovie(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static your.app.model.Movie fetchMovie(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<your.app.model.Movie> eoObjects = _Movie.fetchMovies(editingContext, qualifier, null);
    your.app.model.Movie eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Movie that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static your.app.model.Movie fetchRequiredMovie(EOEditingContext editingContext, String keyName, Object value) {
    return _Movie.fetchRequiredMovie(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static your.app.model.Movie fetchRequiredMovie(EOEditingContext editingContext, EOQualifier qualifier) {
    your.app.model.Movie eoObject = _Movie.fetchMovie(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Movie that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static your.app.model.Movie localInstanceIn(EOEditingContext editingContext, your.app.model.Movie eo) {
    your.app.model.Movie localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
