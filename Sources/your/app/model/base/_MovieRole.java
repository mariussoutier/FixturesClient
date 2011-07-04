// DO NOT EDIT.  Make changes to your.app.model.MovieRole.java instead.
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
public abstract class _MovieRole extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "MovieRole";

  // Attribute Keys
  public static final ERXKey<NSTimestamp> LAST_UPDATED = new ERXKey<NSTimestamp>("lastUpdated");
  public static final ERXKey<String> ROLE_NAME = new ERXKey<String>("roleName");
  // Relationship Keys
  public static final ERXKey<your.app.model.Movie> MOVIE = new ERXKey<your.app.model.Movie>("movie");
  public static final ERXKey<your.app.model.Talent> TALENT = new ERXKey<your.app.model.Talent>("talent");

  // Attributes
  public static final String LAST_UPDATED_KEY = LAST_UPDATED.key();
  public static final String ROLE_NAME_KEY = ROLE_NAME.key();
  // Relationships
  public static final String MOVIE_KEY = MOVIE.key();
  public static final String TALENT_KEY = TALENT.key();

  private static Logger LOG = Logger.getLogger(_MovieRole.class);

  public your.app.model.MovieRole localInstanceIn(EOEditingContext editingContext) {
    your.app.model.MovieRole localInstance = (your.app.model.MovieRole)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public NSTimestamp lastUpdated() {
    return (NSTimestamp) storedValueForKey(_MovieRole.LAST_UPDATED_KEY);
  }

  public void setLastUpdated(NSTimestamp value) {
    if (_MovieRole.LOG.isDebugEnabled()) {
    	_MovieRole.LOG.debug( "updating lastUpdated from " + lastUpdated() + " to " + value);
    }
    takeStoredValueForKey(value, _MovieRole.LAST_UPDATED_KEY);
  }

  public String roleName() {
    return (String) storedValueForKey(_MovieRole.ROLE_NAME_KEY);
  }

  public void setRoleName(String value) {
    if (_MovieRole.LOG.isDebugEnabled()) {
    	_MovieRole.LOG.debug( "updating roleName from " + roleName() + " to " + value);
    }
    takeStoredValueForKey(value, _MovieRole.ROLE_NAME_KEY);
  }

  public your.app.model.Movie movie() {
    return (your.app.model.Movie)storedValueForKey(_MovieRole.MOVIE_KEY);
  }
  
  public void setMovie(your.app.model.Movie value) {
    takeStoredValueForKey(value, _MovieRole.MOVIE_KEY);
  }

  public void setMovieRelationship(your.app.model.Movie value) {
    if (_MovieRole.LOG.isDebugEnabled()) {
      _MovieRole.LOG.debug("updating movie from " + movie() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setMovie(value);
    }
    else if (value == null) {
    	your.app.model.Movie oldValue = movie();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _MovieRole.MOVIE_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _MovieRole.MOVIE_KEY);
    }
  }
  
  public your.app.model.Talent talent() {
    return (your.app.model.Talent)storedValueForKey(_MovieRole.TALENT_KEY);
  }
  
  public void setTalent(your.app.model.Talent value) {
    takeStoredValueForKey(value, _MovieRole.TALENT_KEY);
  }

  public void setTalentRelationship(your.app.model.Talent value) {
    if (_MovieRole.LOG.isDebugEnabled()) {
      _MovieRole.LOG.debug("updating talent from " + talent() + " to " + value);
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	setTalent(value);
    }
    else if (value == null) {
    	your.app.model.Talent oldValue = talent();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, _MovieRole.TALENT_KEY);
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, _MovieRole.TALENT_KEY);
    }
  }
  

  public static your.app.model.MovieRole createMovieRole(EOEditingContext editingContext, your.app.model.Movie movie, your.app.model.Talent talent) {
    your.app.model.MovieRole eo = (your.app.model.MovieRole) EOUtilities.createAndInsertInstance(editingContext, _MovieRole.ENTITY_NAME);    
    eo.setMovieRelationship(movie);
    eo.setTalentRelationship(talent);
    return eo;
  }

  public static ERXFetchSpecification<your.app.model.MovieRole> fetchSpec() {
    return new ERXFetchSpecification<your.app.model.MovieRole>(_MovieRole.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<your.app.model.MovieRole> fetchAllMovieRoles(EOEditingContext editingContext) {
    return _MovieRole.fetchAllMovieRoles(editingContext, null);
  }

  public static NSArray<your.app.model.MovieRole> fetchAllMovieRoles(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _MovieRole.fetchMovieRoles(editingContext, null, sortOrderings);
  }

  public static NSArray<your.app.model.MovieRole> fetchMovieRoles(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<your.app.model.MovieRole> fetchSpec = new ERXFetchSpecification<your.app.model.MovieRole>(_MovieRole.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<your.app.model.MovieRole> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static your.app.model.MovieRole fetchMovieRole(EOEditingContext editingContext, String keyName, Object value) {
    return _MovieRole.fetchMovieRole(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static your.app.model.MovieRole fetchMovieRole(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<your.app.model.MovieRole> eoObjects = _MovieRole.fetchMovieRoles(editingContext, qualifier, null);
    your.app.model.MovieRole eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one MovieRole that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static your.app.model.MovieRole fetchRequiredMovieRole(EOEditingContext editingContext, String keyName, Object value) {
    return _MovieRole.fetchRequiredMovieRole(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static your.app.model.MovieRole fetchRequiredMovieRole(EOEditingContext editingContext, EOQualifier qualifier) {
    your.app.model.MovieRole eoObject = _MovieRole.fetchMovieRole(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no MovieRole that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static your.app.model.MovieRole localInstanceIn(EOEditingContext editingContext, your.app.model.MovieRole eo) {
    your.app.model.MovieRole localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
