// DO NOT EDIT.  Make changes to your.app.model.Talent.java instead.
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
public abstract class _Talent extends  ERXGenericRecord {
  public static final String ENTITY_NAME = "Talent";

  // Attribute Keys
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  // Relationship Keys
  public static final ERXKey<your.app.model.MovieRole> MOVIES = new ERXKey<your.app.model.MovieRole>("movies");

  // Attributes
  public static final String NAME_KEY = NAME.key();
  // Relationships
  public static final String MOVIES_KEY = MOVIES.key();

  private static Logger LOG = Logger.getLogger(_Talent.class);

  public your.app.model.Talent localInstanceIn(EOEditingContext editingContext) {
    your.app.model.Talent localInstance = (your.app.model.Talent)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String name() {
    return (String) storedValueForKey(_Talent.NAME_KEY);
  }

  public void setName(String value) {
    if (_Talent.LOG.isDebugEnabled()) {
    	_Talent.LOG.debug( "updating name from " + name() + " to " + value);
    }
    takeStoredValueForKey(value, _Talent.NAME_KEY);
  }

  public NSArray<your.app.model.MovieRole> movies() {
    return (NSArray<your.app.model.MovieRole>)storedValueForKey(_Talent.MOVIES_KEY);
  }

  public NSArray<your.app.model.MovieRole> movies(EOQualifier qualifier) {
    return movies(qualifier, null, false);
  }

  public NSArray<your.app.model.MovieRole> movies(EOQualifier qualifier, boolean fetch) {
    return movies(qualifier, null, fetch);
  }

  public NSArray<your.app.model.MovieRole> movies(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings, boolean fetch) {
    NSArray<your.app.model.MovieRole> results;
    if (fetch) {
      EOQualifier fullQualifier;
      EOQualifier inverseQualifier = new EOKeyValueQualifier(your.app.model.MovieRole.TALENT_KEY, EOQualifier.QualifierOperatorEqual, this);
    	
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
      results = movies();
      if (qualifier != null) {
        results = (NSArray<your.app.model.MovieRole>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<your.app.model.MovieRole>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    }
    return results;
  }
  
  public void addToMovies(your.app.model.MovieRole object) {
    includeObjectIntoPropertyWithKey(object, _Talent.MOVIES_KEY);
  }

  public void removeFromMovies(your.app.model.MovieRole object) {
    excludeObjectFromPropertyWithKey(object, _Talent.MOVIES_KEY);
  }

  public void addToMoviesRelationship(your.app.model.MovieRole object) {
    if (_Talent.LOG.isDebugEnabled()) {
      _Talent.LOG.debug("adding " + object + " to movies relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	addToMovies(object);
    }
    else {
    	addObjectToBothSidesOfRelationshipWithKey(object, _Talent.MOVIES_KEY);
    }
  }

  public void removeFromMoviesRelationship(your.app.model.MovieRole object) {
    if (_Talent.LOG.isDebugEnabled()) {
      _Talent.LOG.debug("removing " + object + " from movies relationship");
    }
    if (er.extensions.eof.ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
    	removeFromMovies(object);
    }
    else {
    	removeObjectFromBothSidesOfRelationshipWithKey(object, _Talent.MOVIES_KEY);
    }
  }

  public your.app.model.MovieRole createMoviesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName( your.app.model.MovieRole.ENTITY_NAME );
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, _Talent.MOVIES_KEY);
    return (your.app.model.MovieRole) eo;
  }

  public void deleteMoviesRelationship(your.app.model.MovieRole object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, _Talent.MOVIES_KEY);
    editingContext().deleteObject(object);
  }

  public void deleteAllMoviesRelationships() {
    Enumeration<your.app.model.MovieRole> objects = movies().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteMoviesRelationship(objects.nextElement());
    }
  }


  public static your.app.model.Talent createTalent(EOEditingContext editingContext) {
    your.app.model.Talent eo = (your.app.model.Talent) EOUtilities.createAndInsertInstance(editingContext, _Talent.ENTITY_NAME);    
    return eo;
  }

  public static ERXFetchSpecification<your.app.model.Talent> fetchSpec() {
    return new ERXFetchSpecification<your.app.model.Talent>(_Talent.ENTITY_NAME, null, null, false, true, null);
  }

  public static NSArray<your.app.model.Talent> fetchAllTalents(EOEditingContext editingContext) {
    return _Talent.fetchAllTalents(editingContext, null);
  }

  public static NSArray<your.app.model.Talent> fetchAllTalents(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Talent.fetchTalents(editingContext, null, sortOrderings);
  }

  public static NSArray<your.app.model.Talent> fetchTalents(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    ERXFetchSpecification<your.app.model.Talent> fetchSpec = new ERXFetchSpecification<your.app.model.Talent>(_Talent.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<your.app.model.Talent> eoObjects = fetchSpec.fetchObjects(editingContext);
    return eoObjects;
  }

  public static your.app.model.Talent fetchTalent(EOEditingContext editingContext, String keyName, Object value) {
    return _Talent.fetchTalent(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static your.app.model.Talent fetchTalent(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<your.app.model.Talent> eoObjects = _Talent.fetchTalents(editingContext, qualifier, null);
    your.app.model.Talent eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Talent that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static your.app.model.Talent fetchRequiredTalent(EOEditingContext editingContext, String keyName, Object value) {
    return _Talent.fetchRequiredTalent(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static your.app.model.Talent fetchRequiredTalent(EOEditingContext editingContext, EOQualifier qualifier) {
    your.app.model.Talent eoObject = _Talent.fetchTalent(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Talent that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static your.app.model.Talent localInstanceIn(EOEditingContext editingContext, your.app.model.Talent eo) {
    your.app.model.Talent localInstance = (eo == null) ? null : ERXEOControlUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
